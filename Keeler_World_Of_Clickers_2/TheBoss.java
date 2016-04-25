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
    public int BOSS_TIME = 500;
    private int myTimeLeft;
    private int myMonsterKills;
    private double myMonsterHealth;
    WorldOfClickers clicker;
    java.util.Timer timer2;
    /**
    * This is the constructer
    * pre none
    * pram monsterKills
    * return none
    * post none
    */
    public TheBoss(WorldOfClickers clicker2, int monsterKills, java.util.Timer timerDelete)
    {
        clicker = clicker2;
        myMonsterHealth = 5;
        myMonsterKills = monsterKills;
        myTimeLeft = BOSS_TIME;
        timer2 = timerDelete;
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
            }//ends if
        }//ends if
        else
        {
            //this will happen to end the bossFight
            clicker.setBossFight(false);
            timer2.cancel();
        }//ends else
        if(clicker.getBossKill())
        {
            timer2.cancel();
        }
    }//ends run
}//ends TheBoss
