import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.Thread;
import java.text.DecimalFormat;
/**
* This will drive world clicker 2.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class FastAllyAttack extends TimerTask
{
    public double myMonsterHealth;
    WorldOfClickers clicker;
    Bob bob;
    Issy issy;
    Skeeldude skeeldude;
    Ryonical ryonical;
    public FastAllyAttack(WorldOfClickers clicker2, 
    Bob bob2, Issy issy2, Skeeldude skeeldude2, Ryonical ryonical2)
    {
        clicker = clicker2;
        bob = bob2;
        issy = issy2;
        skeeldude = skeeldude2;
        ryonical = ryonical2;
    }//ends constructer
   
    public void run()
    {
        //ryonical
        myMonsterHealth = clicker.getMonsterHealth();
        if(clicker.getRyonical() == true)
        {
            myMonsterHealth -= ryonical.getDamage();
            clicker.setHealth(myMonsterHealth);
        }//ends if
        
        //Skeeldude
        myMonsterHealth = clicker.getMonsterHealth();
        if(clicker.getSkeeldude() == true)
        {
            myMonsterHealth -= skeeldude.getDamage();
            clicker.setHealth(myMonsterHealth);
        }//ends if
        
        //issy
        myMonsterHealth = clicker.getMonsterHealth();
        if(clicker.getIssy() == true)
        {
            myMonsterHealth -= issy.getDamage();
            clicker.setHealth(myMonsterHealth);
        }//ends if
        
        //bob
        myMonsterHealth = clicker.getMonsterHealth();
        if(clicker.getBob() == true)
        {
            myMonsterHealth -= bob.getDamage();
            clicker.setHealth(myMonsterHealth);
        }//ends if
    }//ends run
}//ends AllyAttack
