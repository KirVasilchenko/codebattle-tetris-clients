from tetris_client import GameClient
import random
import logging
from typing import Text
from tetris_client import TetrisAction
from tetris_client import Board
from tetris_client import Element

logging.basicConfig(format="%(asctime)s %(levelname)s:%(message)s", level=logging.INFO)


def turn(gcb: Board) -> TetrisAction:
    # this function must return one of the actions from TetrisAction: tetris_client/internals/tetris_action.py
    #     LEFT = 'left'
    #     RIGHT = 'right'
    #     DOWN = 'down'
    #     STOP = 'stop'
    #     ACT = 'act'
    #     ACT_2 = 'act(2)'
    #     ACT_3 = 'act(3),'
    #     ACT_0_0 = 'act(0,0)'
    # change return below to your code (right now its returns random aciton):
    return random.choice(list(TetrisAction))


def main(uri: Text):
    """
    uri: url for codebattle game
    """
    gcb = GameClient(uri)
    gcb.run(turn)


if __name__ == "__main__":
    # в uri переменную необходимо поместить url с игрой для своего пользователя
    # put your game url in the 'uri' path 1-to-1 as you get in UI
    uri = "http://codebattle2020.westeurope.cloudapp.azure.com/codenjoy-contest/board/player/9r84saxen4c3whdvqfhx?code=3106303325539433635&gameName=tetris"
    main(uri)