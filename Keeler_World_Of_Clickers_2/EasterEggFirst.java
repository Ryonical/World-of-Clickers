import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.Thread;

/**
* This will be the easter egg.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class EasterEggFirst extends EasterEgg
{
    public final int GOLD_FOR_DAYS = 999999999; //this will be how much 
    //gold you have if you do the easter egg
    WorldOfClickers clicker;
    Bob bob;
    Issy issy;
    Skeeldude skeeldude;
    Ryonical ryonical;
    MessagePanel messagePanel;
    JTextField jftMessage;
    EasterEggSecond secondEgg;
    private boolean myHasGone;
    private ArrayList <String> mySave;
    private ArrayList <String> myInput;
    private File f;
    private Scanner inFile;
    /**
    * This is the constructer.
    * pre none
    * pram none
    * return none
    * post none
    */
    public EasterEggFirst(WorldOfClickers clicker2, 
    Bob bob2, Issy issy2, Skeeldude skeeldude2, Ryonical ryonical2,
    MessagePanel messagePanel2, JTextField jftMessage2,
    EasterEggSecond secondEgg2)
    {
        myHasGone = false;
        clicker = clicker2;
        bob = bob2;
        issy = issy2;
        skeeldude = skeeldude2;
        ryonical = ryonical2;
        messagePanel = messagePanel2;
        jftMessage = jftMessage2;
        secondEgg = secondEgg2;
        mySave = new ArrayList<String>();
        myInput = new ArrayList<String>();
        try
        {
            f = new File("E:\\6\\Keeler_World_Of_Clickers_2\\AAEasterEgg.txt");
            inFile = new Scanner(f);
        }//ends try
        catch(Exception e)
        {
            //does nothing
        }//ends catch
    }//ends constructer
    
    /**
    * This will read in the file.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void read()
    {
        try
        {
            f = new File("AAEasterEgg.txt");
            inFile = new Scanner(f);
        }//ends try
        catch(Exception e)
        {
            //does nothing
        }//ends catch
        while(inFile.hasNext())
        {
            mySave.add(new String(inFile.next()));
        }//ends while
    }//ends read
    
    /**
    * This will check to see if they are the same.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void check(String nextInput)
    {   if(!myHasGone)
        {
            int numSequence = 0;
            int i = 0;
            Iterator itr = mySave.iterator();
            //adds the next element
            myInput.add(nextInput);
            if(myInput.size() == mySave.size())
            {
                //checks to see if same
                for(i = 0; itr.hasNext() && i < myInput.size(); i++)
                {
                    
                    if(mySave.get(i).equals(myInput.get(i)))
                    {
                        numSequence++;
                    }//ends if
                }//ends for
                //removes the first element if their is one
                myInput.remove(0);
                
            }//ends if
            if(i == numSequence && i == mySave.size())
            {
                ability();
                i = 0;
                numSequence = 0;
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
        }//ends if
        else
        {
            secondEgg.check(nextInput);
        }//ends else
    }//ends check
    
    /**
    * This will give your special ability.
    * pre none
    * pram none
    * return none
    * post myHasGone
    */
    public void ability()
    {
        clicker.setTotalGold(GOLD_FOR_DAYS);
        myHasGone = true;
        secondEgg.read();
    }//ends ability
    
    /**
    * This will get myHasGone.
    * pre none
    * pram none
    * return myHasGone
    * post none
    */
    public boolean getHasGone()
    {
        return myHasGone;
    }//ends getHasGone
}//ends EasterEggFirst
