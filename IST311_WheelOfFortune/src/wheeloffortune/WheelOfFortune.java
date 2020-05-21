package wheeloffortune;

import controller.Game;
import model.Puzzle;
import view.Board;
import view.MenuChoice;
import view.Menu;

public class WheelOfFortune {

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
        
    }

}
/*
This is just incase anyone has issues using Git from Netbeans
Commands run with Git Bash

git push origin HEAD:master
git commit -am "msg"

To connect back to HEAD
git checkout master
Or, if you have changes that you want to keep, do this:

git checkout -b temp
git checkout -B master temp
*/