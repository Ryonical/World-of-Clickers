import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * This will drive world clicker 2.
 * 
 * @Ryan Keeler
 * @World Of Dlicker
 */
public class Save
{
    //to save
    FileWriter fileInt;
    FileWriter fileDouble;
    FileWriter fileBool;
    
    //arraylist
    private ArrayList <String> mySaveInt;
    private ArrayList <String> mySaveDouble;
    private ArrayList <String> mySaveBool;
    
    //classes
    WorldOfClickers clicker;
    Bob bob;
    Issy issy;
    Skeeldude skeeldude;
    Ryonical ryonical;
    MessagePanel messagePanel;
    JTextField jftMessage;
    EasterEggFirst firstEgg;
    /**
    * This will construct .
    * pre none
    * pram none
    * return none
    * post all
    */
    public Save(WorldOfClickers clicker2, 
    Bob bob2, Issy issy2, Skeeldude skeeldude2, Ryonical ryonical2,
    MessagePanel messagePanel2, JTextField jftMessage2,
    EasterEggFirst firstEgg2)
    {
        try
        {
            fileInt = new FileWriter("saveInt.txt");
            fileDouble = new FileWriter("saveDouble.txt");
            fileBool = new FileWriter("saveBool.txt");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        clicker = clicker2;
        bob = bob2;
        issy = issy2;
        skeeldude = skeeldude2;
        ryonical = ryonical2;
        messagePanel = messagePanel2;
        jftMessage = jftMessage2;
        firstEgg = firstEgg2;
        mySaveInt = new ArrayList<String>();
        mySaveDouble = new ArrayList<String>();
        mySaveBool = new ArrayList<String>();
    }
    
    /**
    * This will get the info that needs to be saved.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void getStats()
    {
        //ints
        mySaveInt.add(Integer.toString(clicker.getAttackDamage()));
        mySaveInt.add(Integer.toString(clicker.getDamageUpgradeCost()));
        mySaveInt.add(Integer.toString(clicker.getBaseMonsterHealth()));
        mySaveInt.add(Integer.toString(clicker.getTotalGold()));
        mySaveInt.add(Integer.toString(clicker.getGoldGain()));
        mySaveInt.add(Integer.toString(bob.getCost()));
        mySaveInt.add(Integer.toString(issy.getCost()));
        mySaveInt.add(Integer.toString(skeeldude.getCost()));
        mySaveInt.add(Integer.toString(ryonical.getCost()));
        //doubles
        mySaveDouble.add(Double.toString(clicker.getDamageUpgrade()));
        mySaveDouble.add(Double.toString(clicker.getMonsterHealth()));
        mySaveDouble.add(Double.toString(bob.getDamage()));
        mySaveDouble.add(Double.toString(issy.getDamage()));
        mySaveDouble.add(Double.toString(skeeldude.getDamage()));
        mySaveDouble.add(Double.toString(ryonical.getDamage()));
        //bools
        mySaveBool.add(Boolean.toString(clicker.getBob()));
        mySaveBool.add(Boolean.toString(clicker.getIssy()));
        mySaveBool.add(Boolean.toString(clicker.getSkeeldude()));
        mySaveBool.add(Boolean.toString(clicker.getRyonical()));
        mySaveBool.add(Boolean.toString(bob.getFirst()));
        mySaveBool.add(Boolean.toString(issy.getFirst()));
        mySaveBool.add(Boolean.toString(skeeldude.getFirst()));
        mySaveBool.add(Boolean.toString(ryonical.getFirst()));
    }//ends getStats
    
    /**
    * This will save everything that needs to be saved.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void save()
    {        
        try
        {
            //to save ints
            for(int i = 0; i < mySaveInt.size(); i++)
            {
                fileInt.write((mySaveInt.get(i) + System.lineSeparator()));
            }//ends for
            fileInt.close();
            //to save doubles
            for(int i = 0; i < mySaveDouble.size(); i++)
            {
                fileDouble.write((mySaveDouble.get(i) + System.lineSeparator()));
            }//ends for
            fileDouble.close();
            //to save bools
            for(int i = 0; i < mySaveBool.size(); i++)
            {
                fileBool.write((mySaveBool.get(i) + System.lineSeparator()));
            }//ends for
            fileBool.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }//ends catch
    }//ends save
}//ends Save
