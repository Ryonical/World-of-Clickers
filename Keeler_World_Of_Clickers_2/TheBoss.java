import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.lang.Thread;
/**
* This will be the bossFight.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class TheBoss extends TimerTask
{
    public int BOSSTIME = 5;
    private int myTimeLeft;
    private int myMonsterKills;
    private double myMonsterHealth;
    WorldOfClickers clicker;
    /**
    * This is the constructer
    * pre none
    * pram monsterKills
    * return none
    * post none
    */
    public TheBoss(WorldOfClickers clicker2, int monsterKills)
    {
        clicker = clicker2;
        myMonsterHealth = 5;
        myMonsterKills = monsterKills;
        myTimeLeft = BOSSTIME;
    }
    
    /**
    * This is the boss fight
    * pre none
    * pram none
    * return none
    * post none
    */
    public void run()
    {
        myMonsterHealth = clicker.getMonsterHealth();
        if(myTimeLeft > 0)
        {
            //for later
            clicker.setBossFight(true);
            //this will count down how much time you have
            if(clicker.getMonsterHealth() >= 0)
            {
                myTimeLeft--;
            }
        }
        else
        {
            //this will happen to end the bossFight
            clicker.setBossFight(false);
            //this will end the boss fight
            clicker.death(-1272369823);
        }
        clicker.setHealth(myMonsterHealth);
    }
}
