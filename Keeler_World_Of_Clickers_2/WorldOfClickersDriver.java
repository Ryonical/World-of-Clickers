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
    public static void main(String [] args)
    {
        final int ATTACKSPEED = 100; //sets the attack speed
        WorldOfClickers clicker = new WorldOfClickers();
        Bob bob = new Bob();
        Issy issy = new Issy();
        Skeeldude skeeldude = new Skeeldude();
        Ryonical ryonical = new Ryonical();
        Buttons button = new Buttons();
        MessagePanel messagePanel = new MessagePanel();
        messagePanel.setBackground(Color.white);
        JTextField jftMessage = new JTextField(10);
        EasterEggSecond secondEgg = new EasterEggSecond(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
        EasterEggFirst firstEgg = new  EasterEggFirst(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage, secondEgg);
        Load load = new Load(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage, firstEgg);
        button.activate(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage, load, firstEgg, secondEgg);
        java.util.Timer timer1 = new java.util.Timer();
        timer1.schedule(new AllyAttack(clicker, bob, issy, skeeldude, ryonical, button, messagePanel, jftMessage), 0 , ATTACKSPEED);
    }//ends main
}//ends WorldOfClickersDriver
