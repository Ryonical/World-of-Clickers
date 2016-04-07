import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.lang.Thread;
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
    private JButton jbtissy = new JButton("issy");
    private JButton jbtRyonical = new JButton("Ryonical the destroyer");
    private JButton jbtBoss = new JButton("Boss");
    private JButton jbtProgress = new JButton("Progress");
    private JButton jbtDegress = new JButton("Go Back");
    public static void main(String [] args)
    {
        
        final int ATTACKSPEED = 500; //sets the attack speed
        WorldOfClickers clicker = new WorldOfClickers();
        Bob bob = new Bob();
        Issy issy = new Issy();
        Ryonical ryonical = new Ryonical();
        WorldOfClickersDriver driver = new WorldOfClickersDriver();
        MessagePanel messagePanel = new MessagePanel();
        messagePanel.setBackground(Color.white);
        JTextField jftMessage = new JTextField(10);
        EasterEggSecond secondEgg = new EasterEggSecond(clicker, bob, issy, ryonical, messagePanel, jftMessage);
        EasterEggFirst firstEgg = new  EasterEggFirst(clicker, bob, issy, ryonical, messagePanel, jftMessage, secondEgg);
        driver.activate(clicker, bob, issy, ryonical, messagePanel, jftMessage, firstEgg, secondEgg);
        java.util.Timer timer1 = new java.util.Timer();
        timer1.schedule(new AllyAttack(clicker, bob, issy, ryonical, messagePanel, jftMessage), 0 , ATTACKSPEED);
    }
    
    
    public void activate(WorldOfClickers clicker, Bob bob, Issy issy, Ryonical ryonical, MessagePanel messagePanel,
    JTextField jftMessage, EasterEggFirst firstEgg, EasterEggSecond secondEgg)
    {
        
        
        //buttons
        JButton jbtAttack = new JButton("Attack");
        JButton jbtUpgrade = new JButton("Upgrade");
        JButton jbtUpgradeAll = new JButton("Upgrade All");
        JButton jbtBob = new JButton("Bob Powers");
        JButton jbtissy = new JButton("Issy");
        JButton jbtRyonical = new JButton("Ryonical the Destroyer");
        JButton jbtBoss = new JButton("Boss");
        JButton jbtProgress = new JButton("Progress");
        JButton jbtDegress = new JButton("Go Back");
        WorldOfClickersDriver frame = new WorldOfClickersDriver();

        frame.setTitle("World of Clicker");
        frame.setSize(950, 125);
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
        jpButtons.add(jbtissy);
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
            int myissyUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("attack");
                
                myMonsterHealth = clicker.attack();
                clicker.death(myMonsterHealth);
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
            }
        });
        
        //upgrade
        jbtUpgrade.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myissyUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("upgrade");
                clicker.damageUpgrade();
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
            }
        });
        
        //upgrade
        jbtUpgradeAll.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myissyUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("upgrade all");
                clicker.damageUpgradeAll();
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
            }
        });
        
        //bob
        jbtBob.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myissyUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("bob");
                bob.upgrade(clicker);
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
            }
        });
        
        //issy
        jbtissy.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myissyUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("issy");
                
                issy.upgrade(clicker);
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
            }
        });
        
        //Ryonical
        jbtRyonical.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myissyUpgrade;
            int myRyonicalUpgrade;
                public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("ryonical");
                
                ryonical.upgrade(clicker);
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
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
            int myissyUpgrade;
            int myRyonicalUpgrade;
            public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("boss");
                if(clicker.getMonsterKills() >= 5 && !clicker.getBossFight())
                {
                    clicker.death(-1272369823);
                    //doubles the health
                    clicker.setHealth(clicker.getMonsterHealth() * 2);
                    //runs the timer
                    java.util.Timer timer2 = new java.util.Timer();
                    timer2.schedule(new TheBoss(clicker, clicker.getMonsterKills()), 0 , 1000);
                }
                
                
                myBossFight = clicker.getBossFight();
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
            }
        });
        
        //progresses
        jbtProgress.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myissyUpgrade;
            int myRyonicalUpgrade;
            public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("progress");
                clicker.progress();
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
            }
        });
        
        //degress
        jbtDegress.addActionListener(new ActionListener()
        {
            double myMonsterHealth = 5;
            int myTotalGold;
            int myDamageUpgradeCost;
            int myBobUpgrade;
            int myissyUpgrade;
            int myRyonicalUpgrade;
            public void actionPerformed(ActionEvent e)
            {
                firstEgg.check("degress");
                clicker.degress();
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
                " The next upgrade costs " + myDamageUpgradeCost + " gold Bob costs " + myBobUpgrade + " gold, Issy costs " +
                myissyUpgrade + " gold, and Ryonical costs " + myRyonicalUpgrade + " gold.");
                jftMessage.requestFocusInWindow();
                messagePanel.repaint();
            }
        });
    }

}
