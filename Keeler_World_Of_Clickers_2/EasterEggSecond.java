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
public class EasterEggSecond extends EasterEgg
{
    public final int GOLD_FOR_NO_DAYS = 0; //this will be how much 
    //gold you have if you do the easter egg
    WorldOfClickers clicker;
    Bob bob;
    Issy issy;
    Skeeldude skeeldude;
    Ryonical ryonical;
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
    public EasterEggSecond(WorldOfClickers clicker2, 
    Bob bob2, Issy issy2, Skeeldude skeeldude2, Ryonical ryonical2)
    {
        myHasGone = false;
        clicker = clicker2;
        bob = bob2;
        issy = issy2;
        skeeldude = skeeldude2;
        ryonical = ryonical2;
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
            f = new File("E:\\6\\Keeler_World_Of_Clickers_2\\AAEasterEgg.txt");
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
        }//ends if
    }//ends check
    
    /**
    * This will give your special ability.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void ability()
    {
        clicker.setTotalGold(GOLD_FOR_NO_DAYS);
        myHasGone = true;
    }//ends ability
}//ends EasterEggFirst
