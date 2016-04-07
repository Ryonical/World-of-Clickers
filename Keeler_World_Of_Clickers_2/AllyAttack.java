import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.Thread;
/**
* This will drive world clicker 2.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class AllyAttack extends TimerTask
{
    public double myMonsterHealth;
    WorldOfClickers clicker;
    Bob bob;
    Issy issy;
    Ryonical ryonical;
    MessagePanel messagePanel;
    JTextField jftMessage;
    public AllyAttack(WorldOfClickers clicker2, 
    Bob bob2, Issy issy2, Ryonical ryonical2,
    MessagePanel messagePanel2, JTextField jftMessage2)
    {
        clicker = clicker2;
        bob = bob2;
        issy = issy2;
        ryonical = ryonical2;
        messagePanel = messagePanel2;
        jftMessage = jftMessage2;
    }//ends constructer
   
    public void run()
    {
        //bob
        myMonsterHealth = clicker.getMonsterHealth();
        if(clicker.getBob() == true)
        {
            myMonsterHealth -= bob.getDamage();
            clicker.setHealth(myMonsterHealth);
        }//ends if
    
        //issy
        myMonsterHealth = clicker.getMonsterHealth();
        if(clicker.getIssy() == true)
        {
            myMonsterHealth -= issy.getDamage();
            clicker.setHealth(myMonsterHealth);
        }//ends if
    
        //ryonical
        myMonsterHealth = clicker.getMonsterHealth();
        if(clicker.getRyonical() == true)
        {
            myMonsterHealth -= ryonical.getDamage();
            clicker.setHealth(myMonsterHealth);
        }//ends if
        
        //this is output
        double myMonsterHealth = 5;
        int myTotalGold;
        int myDamageUpgradeCost;
        int myBobUpgrade;
        int myissyUpgrade;
        int myRyonicalUpgrade;
        //gets monster health
        myMonsterHealth = clicker.getMonsterHealth();
        //gets costs
        myDamageUpgradeCost = clicker.getDamageUpgradeCost();
        //gets bob costs
        myBobUpgrade = bob.getCost();
        //gets issy costs
        myissyUpgrade = issy.getCost();
        //gets ryonical costs
        myRyonicalUpgrade = ryonical.getCost();
        //gets gold
        myTotalGold = clicker.getTotalGold();
        messagePanel.setMessage("The monster has " + myMonsterHealth + " health You have " + myTotalGold + " gold" + 
        " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, issy costs " +
        myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
        jftMessage.requestFocusInWindow();
        messagePanel.repaint();
    }//ends run
}//ends AllyAttack
