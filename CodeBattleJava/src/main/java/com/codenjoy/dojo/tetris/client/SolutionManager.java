package com.codenjoy.dojo.tetris.client;

import com.codenjoy.dojo.services.Command;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.tetris.model.Elements;

import java.util.ArrayList;
import java.util.List;

public class SolutionManager {

    public int iteration = 0;
    public int commandsToEdge = 8;
    public int fit = 0;

    public List<Command> getAction(Board board) {
        Elements el = board.getCurrentFigureType();
        if (el.ch() == 'O') {fit = 2;}
        if (el.ch() == 'I') {fit = 1;}
        List<Point> pointList = board.getGlass().getFreeSpace();



        List<Command> result = new ArrayList<Command>();

        if (iteration == 0) { iterate0(result);}
        else if (iteration == 1) { iterate1(result);}
        else if (iteration == 2) { iterate2(result);}
        else if (iteration == 3) { iterate3(result);}
        else if (iteration == 4) { iterate4(result);}
        else if (iteration == 5) { iterate5(result);}
        else if (iteration == 6) { iterate6(result);}
        else if (iteration == 7) { iterate7(result);}
        else if (iteration == 8) { iterate8(result);}

        iteration = iteration > 8 ? 0 : ++iteration;

        return result;
    }

    private List<Command> iterate0(List<Command> result) {
        return fastStep(result, 8, Command.LEFT);
    }
    private List<Command> iterate1(List<Command> result) {
        return fastStep(result, 6, Command.LEFT);
    }
    private List<Command> iterate2(List<Command> result) {
        return fastStep(result, 4, Command.LEFT);
    }
    private List<Command> iterate3(List<Command> result) {
        return fastStep(result, 2, Command.LEFT);
    }
    private List<Command> iterate4(List<Command> result) {
        return fastStep(result, 1, Command.DOWN);
    }
    private List<Command> iterate5(List<Command> result) {
        return fastStep(result, 2, Command.RIGHT);
    }
    private List<Command> iterate6(List<Command> result) {
        return fastStep(result, 4, Command.RIGHT);
    }
    private List<Command> iterate7(List<Command> result) {
        return fastStep(result, 6, Command.RIGHT);
    }
    private List<Command> iterate8(List<Command> result) {
        return fastStep(result, 8, Command.RIGHT);
    }



    private List<Command> fastStep(List<Command> result, int number, Command command) {
        for (int i = 0; i < number; i++) {
            result.add(command);
        }
        result.add(Command.DOWN);
        return result;
    }
}
