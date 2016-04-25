import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.lang.Thread;
import java.text.DecimalFormat;
/**
 * This will drive world clicker 2.
 * 
 * @Ryan Keeler
 * @World Of Dlicker
 */
public class WorldOfClickersDriver extends JFrame
{
    //vars   
    private JButton jbtAttack = new JButton("Attack");
    private JButton jbtUpgrade = new JButton("Upgrade");
    private JButton jbtUpgradeAll = new JButton("Upgrade All");
    private JButton jbtBob = new JButton("Bob Powers");
    private JButton jbtIssy = new JButton("Issy");
    private JButton jbtSkeeldude = new JButton("Skeeldude");
    private JButton jbtRyonical = new JButton("Ryonical the destroyer");
    private JButton jbtBoss = new JButton("Boss");
    private JButton jbtProgress = new JButton("Progress");
    private JButton jbtDegress = new JButton("Go Back");
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
        WorldOfClickersDriver driver = new WorldOfClickersDriver();
        MessagePanel messagePanel = new MessagePanel();
        messagePanel.setBackground(Color.white);
        JTextField jftMessage = new JTextField(10);
        EasterEggSecond secondEgg = new EasterEggSecond(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
        EasterEggFirst firstEgg = new  EasterEggFirst(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage, secondEgg);
        driver.activate(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage, firstEgg, secondEgg);
        java.util.Timer timer1 = new java.util.Timer();
        timer1.schedule(new AllyAttack(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage), 0 , ATTACKSPEED);
    }
    
    /**
    * This will be the buttons.
    * pre none
    * pram none
    * return none
    * post all
    */
    public void activate(WorldOfClickers clicker, Bob bob, Issy issy, Skeeldude skeeldude, Ryonical ryonical,
    MessagePanel messagePanel, JTextField jftMessage, EasterEggFirst firstEgg, EasterEggSecond secondEgg)
    {
        //to remove the exess numbers off the monster health
        DecimalFormat format = new DecimalFormat("0.#");
        
        //buttons
        JButton jbtAttack = new JButton("Attack");
        JButton jbtUpgrade = new JButton("Upgrade");
        JButton jbtUpgradeAll = new JButton("Upgrade All");
        JButton jbtBob = new JButton("Bob Powers");
        JButton jbtIssy = new JButton("Issy");
        JButton jbtSkeeldude = new JButton("Skeeldude");
        JButton jbtRyonical = new JButton("Ryonical the Destroyer");
        JButton jbtBoss = new JButton("Boss");
        JButton jbtProgress = new JButton("Progress");
        JButton jbtDegress = new JButton("Go Back");
        WorldOfClickersDriver frame = new WorldOfClickersDriver();

        frame.setTitle("World of Clicker");
        frame.setSize(1250, 125);
        frame.setLocationRelativeTo(null);//centers theclicker
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
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
        
        //reads in for easteregg
        firstEgg.read();
        
        //places buttons
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(messagePanel, BorderLayout.CENTER);
        contentPane.add(jpButtons, BorderLayout.SOUTH);
        
        //attacks
        jbtAttack.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                clicker.attack();
                //for the easteregg
                firstEgg.check("attack");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //upgrade
        jbtUpgrade.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                clicker.damageUpgrade();
                //for the easteregg
                firstEgg.check("upgrade");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //upgrade all
        jbtUpgradeAll.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                clicker.damageUpgradeAll();
                //for the easteregg
                firstEgg.check("upgrade all");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //bob
        jbtBob.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                bob.upgrade(clicker);
                //for the easteregg
                firstEgg.check("bob");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //issy
        jbtIssy.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                issy.upgrade(clicker);
                //for the easteregg
                firstEgg.check("issy");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //skeeldude
        jbtSkeeldude.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                skeeldude.upgrade(clicker);
                //for the easteregg
                firstEgg.check("skeeldude");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //Ryonical
        jbtRyonical.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                ryonical.upgrade(clicker);
                //for the easteregg
                firstEgg.check("ryonical");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //bossFight
        jbtBoss.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            boolean myBossFight;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
            public void actionPerformed(ActionEvent e)
            {
                if(clicker.getMonsterKills() >= 5 && !clicker.getBossFight())
                {
                    clicker.death(-1272369823);
                    //doubles the health
                    clicker.setHealth(clicker.getMonsterHealth() * 2);
                    //runs the timer
                    java.util.Timer timer2 = new java.util.Timer();
                    timer2.schedule(new TheBoss(clicker, clicker.getMonsterKills(), timer2), 0 , 10);
                }
                
                
                myBossFight = clicker.getBossFight();
                //for the easteregg
                firstEgg.check("boss");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //progresses
        jbtProgress.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
            public void actionPerformed(ActionEvent e)
            {
                clicker.progress();
                //for the easteregg
                firstEgg.check("progress");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
        
        //degress
        jbtDegress.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myIssyUpgrade;
            int mySkeeldudeUpgrade;
            int myRyonicalUpgrade;
            public void actionPerformed(ActionEvent e)
            {
                clicker.degress();
                //for the easteregg
                firstEgg.check("degress");
                output(clicker, bob, issy, skeeldude, ryonical, messagePanel, jftMessage);
            }
        });
    }
    
    /**
    * This will output.
    * pre none
    * pram none
    * return none
    * post all
    */
    public void output(WorldOfClickers clicker, Bob bob, Issy issy, 
    Skeeldude skeeldude, Ryonical ryonical, MessagePanel messagePanel, JTextField jftMessage)
    {
        //to remove the exess numbers off the monster health
        DecimalFormat format = new DecimalFormat("0.#");
        //vars
        double myMonsterHealth = 5;
        int myTotalGold;
        int myDamageUpgradeCost;
        int myBobUpgrade;
        int myIssyUpgrade;
        int mySkeeldudeUpgrade;
        int myRyonicalUpgrade;
        //gets monster health
        myMonsterHealth = clicker.getMonsterHealth();
        //gets costs
        myDamageUpgradeCost = clicker.getDamageUpgradeCost();
        //gets bob costs
        myBobUpgrade = bob.getCost();
        //gets issy costs
        myIssyUpgrade = issy.getCost();
        //gets issy costs
        mySkeeldudeUpgrade = skeeldude.getCost();
        //gets ryonical costs
        myRyonicalUpgrade = ryonical.getCost();
        //gets gold
        myTotalGold = clicker.getTotalGold();
        messagePanel.setMessage("The monster has " + format.format(myMonsterHealth) + " health You have " + myTotalGold + " gold" + 
        " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, issy costs " + myIssyUpgrade +" gold, Skeeldude costs " + mySkeeldudeUpgrade +
        " gold, and Ryonical costs " + myRyonicalUpgrade + " gold the DPS is " + format.format((bob.getDamage() + issy.getDamage() + skeeldude.getDamage() + ryonical.getDamage()) * 10));
        jftMessage.requestFocusInWindow();
        messagePanel.repaint();
    }

}
