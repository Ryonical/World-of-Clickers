/*
 *1 Integer && Double in Ally Children done
 *2 5 relational operaters (== in death, <= in death, >= in damageUpgrade,
 * != in attack, && in bossFight) done
 *3 if else in attack done
 *4 all while loop in upgrade done
 *5 1 interface 3 classes Ally done
 *6 interaction between classes all over done
 *7 inharadence done
 *8 1 interface (abstract class) done
 *9 poilymorphism EasterEgg done
 *10 ArrayList in EasterEgg children done
 *11 comments everywhere done
 *12 gui buttons and repaint done
 *13 meningfull variable names all over done
 *14 javadocs done
 */ 
import java.awt.*;
import javax.swing.*;

/**
* This will drive world clicker 2.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class WorldOfClickers extends JFrame
{
    
    //damage finals
    public final double DAMAGE_INCREASE = 1.23;//used to upgrade damage
    public final double HIGH_DAMAGE_INCREASE = 5;//used to upgrade damage
    public final double UPGRADE_COST_INCREASE = 1.25;//this is how much more gold to upgrade damage
    //gold finals
    public final double PROGRESS_GOLD = 1.5;//this is how much mor you make when you go to the next level
    public final int UPGRADE_COST_IF = 3;//this will be used for if's
    //health finals
    public final int STARTING_HEALTH = 10;//this is how much health the monster starts with
    //at the begging of the game
    
    //this is monster health
    private double myMonsterHealth;//this is the monster health
    private int myBaseMonsterHealth;//this is the health at reset

    
    //this is damage
    private int myAttackDamage;//this is attack damage
    private double myDamageUpgrade;//this will upgrade damage
     //ally vars
    private boolean myHaveBob;
    private boolean myHaveIssy;
    private boolean myHaveSkeeldude;
    private boolean myHaveRyonical;
    
    
    //this is gold
    private int myTotalGold;//this is how much gold you have
    private int myGoldGain;//this is how much gold you get for a kill
    private int myDamageUpgradeCost;//this is how much gold to upgrade damage
    
    //this is boss vars
    private boolean myBossFight;//checks to see if you are in a boss fight
    private boolean myBossKill;//checks to see if boss was killed
    private int myMonsterKills;//this will let you fight the boss if you have atleast 5 kills
    
    /**
    * This will construct WorldOfClickers.
    * pre none
    * pram none
    * return none
    * post all
    */
    public WorldOfClickers()
    {
        //monster health
        myMonsterHealth = STARTING_HEALTH;
        myBaseMonsterHealth = STARTING_HEALTH;
        
        //attack damage
        myAttackDamage = 1;
        myDamageUpgrade = 1;
            //ally vars
        myHaveBob = false;
        myHaveIssy = false;
        myHaveSkeeldude = false;
        myHaveRyonical = false;
        //gold
        myTotalGold = 0;
        myGoldGain = 1;
        myDamageUpgradeCost = 5;
        
        //boss
        myBossFight = false;
        myBossKill = false;
        myMonsterKills = 0;
    }//ends constructer
    
    
    /**
    * This will return myMonsterKills.
    * pre none
    * pram none
    * return myMonsterKills
    * post none
    */
    public int getMonsterKills()
    {
        return myMonsterKills;
    }//ends getMonsterKills
    
    /**
    * This will set myBossFight.
    * pre none
    * pram bossFight
    * return none
    * post none
    */
    public void setBossFight(boolean bossFight)
    {
        myBossFight = bossFight;
    }//ends setBossFight
    
    /**
    * This will get myBossFight.
    * pre none
    * pram none
    * return myBossFight
    * post none
    */
    public boolean getBossFight()
    {
        return myBossFight;
    }//ends getBossFight
    
    /**
    * This will set monster health after ally's attack.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void setHealth(double health)
    {
        myMonsterHealth = health;
        death(myMonsterHealth);
    }//ends setHealth
    
    /**
    * This will return myMonsterHealth.
    * pre none
    * pram none
    * return myMonsterHealth
    * post none
    */
    public double getMonsterHealth()
    {
        return myMonsterHealth;
    }//ends getMonsterHealth
    
    /**
    * This will return myTotalGold.
    * pre none
    * pram none
    * return myTotalGold
    * post none
    */
    public int getTotalGold()
    {
        return myTotalGold;
    }//ends getTotalGold
    
    /**
    * This will return myDamageUpgradeCost.
    * pre none
    * pram none
    * return myDamageUpgradeCost
    * post none
    */
    public int getDamageUpgradeCost()
    {
        return myDamageUpgradeCost;
    }//ends getDamageUpgradeCost
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void setGold(int gold)
    {
        myTotalGold = gold;
    }//ends setGold
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void setBob(boolean bob)
    {
        myHaveBob = bob;
    }//ends setBob
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public boolean getBob()
    {
        return myHaveBob;
    }//ends getBob
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void setIssy(boolean issy)
    {
        myHaveIssy = issy;
    }//ends setIsst
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public boolean getIssy()
    {
        return myHaveIssy;
    }//ends getIssy
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void setSkeeldude(boolean skeeldude)
    {
        myHaveSkeeldude = skeeldude;
    }//ends setIsst
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public boolean getSkeeldude()
    {
        return myHaveSkeeldude;
    }//ends getIssy
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void setRyonical(boolean ryonical)
    {
        myHaveRyonical = ryonical;
    }//ends setRyonical
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public boolean getRyonical()
    {
        return myHaveRyonical;
    }//ends getRyonical
    
    /**
    * This will set gold after upgrading.
    * pre none
    * pram none
    * return none
    * post none
    */
    public boolean getBossKill()
    {
        return myBossKill;
    }
    
    /**
    * This will attack
    * pre none
    * pram none
    * return none
    * post myUserInput
    */
    public double attack()
    {
        myMonsterHealth -= myAttackDamage;
        death(myMonsterHealth);
        return myMonsterHealth;
    }//ends attack
    
    /**
    * This will check to see if the monster is dead
    * then it will give money and refil life.
    * pre none
    * pram monsterHealth
    * return none
    * post myTotalGold, myMonsterHealth
    */
    public void death(double monsterHealth)
    {
        if(monsterHealth == -1272369823)
        {
            //this makes it so boss fights don't kill the monster
            myMonsterKills--;
            //will make it so you don't get money for starting the fight
            myTotalGold -= myGoldGain;
        }//ends if
        if(monsterHealth <= 0)
        {
            //will add gold
            myTotalGold += myGoldGain;
            //will reset monster health
            myMonsterHealth = myBaseMonsterHealth;
            //lets you get closer to boss fight
            myMonsterKills++;
            if(myBossFight == true)
            {
                //to say you have killed the boss
                myBossKill = true;
                //to say you are no longer in a boss fight
                myBossFight = false;
            }//ends if
        }//ends if
    }//ends death
    
    /**
    * This will upgrade damage
    * pre none
    * pram monsterHealth
    * return none
    * post myTotalGold, myAttackDamage
    */
    public void damageUpgrade()
    {
        if(myTotalGold >= myDamageUpgradeCost)
        {
            myTotalGold -= myDamageUpgradeCost;
            myDamageUpgrade *= DAMAGE_INCREASE;
            //will make it so you alwase get an increase in damage
            if(myAttackDamage <= HIGH_DAMAGE_INCREASE)
            {
               myAttackDamage += 1;
            }
            else
            {
                myAttackDamage += myDamageUpgrade;
            }
            if(myDamageUpgradeCost <= UPGRADE_COST_IF)
            {
               myDamageUpgradeCost += 1;
            }
            else
            {
                myDamageUpgradeCost *= UPGRADE_COST_INCREASE;
            }
        }
    }
    
    /**
    * This will upgrade damage as many times as possible
    * pre none
    * pram monsterHealth
    * return none
    * post myTotalGold, myAttackDamage
    */
    public void damageUpgradeAll()
    {
        while(myTotalGold >= myDamageUpgradeCost)
        {
            myTotalGold -= myDamageUpgradeCost;
            myDamageUpgrade *= DAMAGE_INCREASE;
            //will make it so you alwase get an increase in damage
            if(myAttackDamage <= HIGH_DAMAGE_INCREASE)
            {
               myAttackDamage += 1;
            }
            else
            {
                myAttackDamage += myDamageUpgrade;
            }
            if(myDamageUpgradeCost <= UPGRADE_COST_IF)
            {
               myDamageUpgradeCost += 1;
            }
            else
            {
                myDamageUpgradeCost *= UPGRADE_COST_INCREASE;
            }
        }
    }
    
    /**
    * This will let you progress
    * pre none
    * pram none
    * return none
    * post myBaseMonsterHealth, myGoldGain
    */
    public void progress()
    {
        if(myBossKill == true)
        {
            myBossKill = false;
            if(myGoldGain <= UPGRADE_COST_IF)
            {
               myGoldGain++;
            }
            else
            {
                myGoldGain *= PROGRESS_GOLD;
            }
            myMonsterKills = 0;
            myBaseMonsterHealth *= 2;
        }
    }
    
    /**
    * This will let you go back
    * pre none
    * pram none
    * return none
    * post myBaseMonsterHealth, myGoldGain
    */
    public void degress()
    {
        if(myBaseMonsterHealth > STARTING_HEALTH)
        {
            myBossKill = true;
            if(myGoldGain <= UPGRADE_COST_IF)
            {
                if(myGoldGain > 1)
                {
                     myGoldGain--;
                }
            }
            else
            {
                myGoldGain /= PROGRESS_GOLD;
            }
            myMonsterKills = 5;
            myBaseMonsterHealth /= 2;
        }
    }
}
