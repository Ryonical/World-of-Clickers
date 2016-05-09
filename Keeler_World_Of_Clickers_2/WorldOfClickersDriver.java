import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
/**
 * This will drive world clicker 2.
 * 
 * @Ryan Keeler
 * @World Of Dlicker
 */
public class WorldOfClickersDriver
{
    /**
    * This will run everything.
    * pre none
    * pram none
    * return none
    * post none
    */
    public static void main()
    {
        final int ATTACKSPEED = 100;
        WorldOfClickers clicker = new WorldOfClickers();
        Bob bob = new Bob();
        Issy issy = new Issy();
        Skeeldude skeeldude = new Skeeldude();
        Ryonical ryonical = new Ryonical();
        EasterEggSecond secondEgg = new EasterEggSecond(clicker, bob, issy, skeeldude, ryonical);
        EasterEggFirst firstEgg = new  EasterEggFirst(clicker, bob, issy, skeeldude, ryonical, secondEgg);
        
        GameScreen game = new GameScreen();
        Buttons button = new Buttons(clicker, bob, issy, skeeldude, ryonical, firstEgg, game);
        button.activate();
        game.showScreen();
        game.addButtons(button.getButtons());java.util.Timer timer1 = new java.util.Timer();
        timer1.schedule(new AllyAttack(clicker, bob, issy, skeeldude, ryonical, button), 0 , ATTACKSPEED);
    }//ends main
}//ends WorldOfClickersDriver
