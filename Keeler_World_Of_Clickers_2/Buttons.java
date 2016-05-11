import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.lang.String.*;
import java.text.DecimalFormat;
import java.io.*;
/**
 * This will be the buttons.
 * 
 * @Ryan Keeler
 * @World Of Dlicker
 */
public class Buttons extends JFrame
{
    public final int BUTTON_NUM = 13;
    //vars   
    private JButton jbtAttack;
    private JButton jbtUpgrade;
    private JButton jbtUpgradeAll;
    private JButton jbtBob;
    private JButton jbtIssy;
    private JButton jbtSkeeldude;
    private JButton jbtRyonical;
    private JButton jbtBoss;
    private JButton jbtProgress;
    private JButton jbtDegress;
    private JButton jbtSave;
    private JButton jbtAutoSave;
    private JButton jbtLoad;
    
    private boolean myAutoSave;
    
    WorldOfClickers clicker;
    Bob bob;
    Issy issy;
    Skeeldude skeeldude;
    Ryonical ryonical;
    EasterEggFirst firstEgg;
    GameScreen game;
    
    /**
    * This will be the buttons.
    * pre none
    * pram none
    * return none
    * post all
    */
    public Buttons(WorldOfClickers clicker2, 
    Bob bob2, Issy issy2, Skeeldude skeeldude2, Ryonical ryonical2,
    EasterEggFirst firstEgg2, GameScreen game2)
    {
        
        
        clicker = clicker2;
        bob = bob2;
        issy = issy2;
        skeeldude = skeeldude2;
        ryonical = ryonical2;
        firstEgg = firstEgg2;
        game = game2;
        
        jbtAttack = new JButton("Attack");
        jbtUpgrade = new JButton("Upgrade");
        jbtUpgradeAll = new JButton("Upgrade All");
        jbtBob = new JButton("Bob Powers");
        jbtIssy = new JButton("Issy");
        jbtSkeeldude = new JButton("Skeeldude");
        jbtRyonical = new JButton("Ryonical the destroyer");
        jbtBoss = new JButton("Boss");
        jbtProgress = new JButton("Progress");
        jbtDegress = new JButton("Go Back");
        jbtSave = new JButton("Save");
        jbtAutoSave = new JButton("Auto Save");
        jbtLoad = new JButton("Load");
        
        myAutoSave = false;
    }
    
    /**
    * This will be the buttons.
    * pre none
    * pram none
    * return none
    * post all
    */
    public void activate()
    {
        //to remove the exess numbers off the monster health
        DecimalFormat format = new DecimalFormat("0.#");
        
        
        Buttons frame = new Buttons(clicker, bob, issy, skeeldude, ryonical, firstEgg, game);
        
        //adds buttons
        JPanel jpButtons = new JPanel();
        jpButtons.setLayout(new FlowLayout());
        jpButtons.add(jbtAttack);
        jpButtons.add(jbtUpgrade);
        jpButtons.add(jbtUpgradeAll);
        jpButtons.add(jbtBob);
        jpButtons.add(jbtIssy);
        jpButtons.add(jbtSkeeldude);
        jpButtons.add(jbtRyonical);
        jpButtons.add(jbtBoss);
        jpButtons.add(jbtProgress);
        jpButtons.add(jbtDegress);
        jpButtons.add(jbtSave);
        jpButtons.add(jbtAutoSave);
        jpButtons.add(jbtLoad);
        
        //reads in for easteregg
        firstEgg.read();
        
        //attacks
        jbtAttack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clicker.attack();
                //for the easteregg
                firstEgg.check("attack");
            }//ends actionPerformed
        });//ends jbtAttack
        
        //upgrade
        jbtUpgrade.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clicker.damageUpgrade();
                //for the easteregg
                firstEgg.check("upgrade");
            }//ends actionPerformed
        });//ends jbtUpgrade
        
        //upgrade all
        jbtUpgradeAll.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clicker.damageUpgradeAll();
                //for the easteregg
                firstEgg.check("upgrade all");
            }//ends actionPerformed
        });//ends jbtUpgradeAll
        
        //bob
        jbtBob.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                bob.upgrade(clicker);
                //for the easteregg
                firstEgg.check("bob");
            }//ends actionPerformed
        });//ends jbtBob
        
        //issy
        jbtIssy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                issy.upgrade(clicker);
                //for the easteregg
                firstEgg.check("issy");
            }//ends actionPerformed
        });//ends jbtIssy
        
        //skeeldude
        jbtSkeeldude.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                skeeldude.upgrade(clicker);
                //for the easteregg
                firstEgg.check("skeeldude");
            }//ends actionPerformed
        });//ends jbtSkeeldude
        
        //Ryonical
        jbtRyonical.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ryonical.upgrade(clicker);
                //for the easteregg
                firstEgg.check("ryonical");
            }//ends actionPerformed
        });//ends jbtRyonical
        
        //bossFight
        jbtBoss.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(clicker.getMonsterKills() >= 5 && !clicker.getBossFight())
                {
                    clicker.death(-1272369823);
                    //doubles the health
                    clicker.setHealth(clicker.getMonsterHealth() * 2);
                    clicker.setBossFight(true);
                    //runs the timer
                    java.util.Timer timer2 = new java.util.Timer();
                    timer2.schedule(new TheBoss(clicker, clicker.getMonsterKills(), timer2), 0 , 10);
                }//ends if
                //for the easteregg
                firstEgg.check("boss");
            }//ends actionPerformed
        });//ends jbtBoss
        
        //progresses
        jbtProgress.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clicker.progress();
                //for the easteregg
                firstEgg.check("progress");
            }//ends actionPerformed
        });//ends jbtProgress
        
        //degress
        jbtDegress.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clicker.degress();
                //for the easteregg
                firstEgg.check("degress");
            }//ends actionPerformed
        });//ends jbtDegress
        
        //saves
        jbtSave.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Save save = new Save(clicker, bob, issy, skeeldude, ryonical, firstEgg);
                save.getStats();
                save.save();
                //for the easteregg
                firstEgg.check("save");
            }//ends actionPerformed
        });//ends jbtSave
        
        //auto saves
        jbtAutoSave.addActionListener(new ActionListener()
        {
            long SAVE_TIME = 10000;
            public void actionPerformed(ActionEvent e)
            {
                java.util.Timer timer1 = new java.util.Timer();
                if(!myAutoSave)
                {
                    timer1.schedule(new AutoSave(clicker, bob, issy, skeeldude, ryonical, firstEgg), 0 , SAVE_TIME);
                    myAutoSave = true;
                }//ends if
                else
                {
                    timer1.cancel();
                    myAutoSave = false;
                }//ends else
                //for the easteregg
                firstEgg.check("save");
            }//ends actionPerformed
        });//ends jbtSave
        
        //loads
        jbtLoad.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Load load = new Load(clicker, bob, issy, skeeldude, ryonical, firstEgg);
                load.reader();
                load.load();
                //for the easteregg
                firstEgg.check("load");
            }//ends actionPerformed
        });//ends jbtLoad
    }//ends activate
    
    /**
    * This will getSave.
    * pre none
    * pram none
    * return autosave is on, or autosave is off
    * post none
    */
    public String getSave()
    {
        String output = "";
        if(myAutoSave)
        {
            output = "autosave is on";
        }
        else
        {
            output = "autosave is off";
        }
        return output;
    }
    
    public JButton[] getButtons()
    {
        JButton[] buttons = new JButton[13];
        buttons[0] = jbtAttack;
        buttons[1] = jbtUpgrade;
        buttons[2] = jbtUpgradeAll;
        buttons[3] = jbtBob;
        buttons[4] = jbtIssy;
        buttons[5] = jbtSkeeldude;
        buttons[6] = jbtRyonical;
        buttons[7] = jbtBoss;
        buttons[8] = jbtProgress;
        buttons[9] = jbtDegress;
        buttons[10] = jbtSave;
        buttons[11] = jbtAutoSave;
        buttons[12] = jbtLoad;
        return buttons;
    }
        
    /**
    * This will output.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void output()
    {
        DecimalFormat format = new DecimalFormat("0.#");
        //vars
        double monsterHealth;
        int totalGold;
        int damageUpgradeCost;
        int bobUpgrade;
        int issyUpgrade;
        int skeeldudeUpgrade;
        int ryonicalUpgrade;
        double dps;
        //gets monster health
        monsterHealth = clicker.getMonsterHealth();
        //gets costs
        damageUpgradeCost = clicker.getDamageUpgradeCost();
        //gets bob costs
        bobUpgrade = bob.getCost();
        //gets issy costs
        issyUpgrade = issy.getCost();
        //gets issy costs
        skeeldudeUpgrade = skeeldude.getCost();
        //gets ryonical costs
        ryonicalUpgrade = ryonical.getCost();
        //gets gold
        totalGold = clicker.getTotalGold();
        //calcs the dps
        dps = ((bob.getDamage() + issy.getDamage() + skeeldude.getDamage() + ryonical.getDamage()) * 10);
        
        String[] output = new String [9];
        output[0] = "The Monster has " + format.format(clicker.simplify(monsterHealth)) + clicker.getMyType() + " health";
        output[1] = "You have " + format.format(clicker.simplify(totalGold)) + clicker.getMyType() + " gold";
        output[2] = "The next upgrade costs " + format.format(clicker.simplify(damageUpgradeCost)) + clicker.getMyType() + " gold";
        output[3] = "Bob costs " + format.format(clicker.simplify(bobUpgrade)) + clicker.getMyType() + " gold";
        output[4] = "Issy costs " + format.format(clicker.simplify(issyUpgrade)) + clicker.getMyType() + " gold";
        output[5] = "Skeeldude costs " + format.format(clicker.simplify(skeeldudeUpgrade)) + clicker.getMyType() + " gold";
        output[6] = "Ryonical costs " + format.format(clicker.simplify(ryonicalUpgrade)) + clicker.getMyType() + " gold";
        output[7] = "The DPS is " + format.format(clicker.simplify(dps)) + clicker.getMyType();
        output[8] = getSave();
        
        
        
        game.refresh(output);
    }//ends output
}//ends Buttons
