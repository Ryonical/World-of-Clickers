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
public class Load
{
    //to save
    private File fileInt = null;
    private File fileDouble = null;
    private File fileBool = null;
    private Scanner inFileInt = null;
    private Scanner inFileDouble = null;
    private Scanner inFileBool = null;

    //vars
    private ArrayList <Integer> mySaveInt;
    private ArrayList <Double> mySaveDouble;
    private ArrayList <Boolean> mySaveBool;

    //classes
    WorldOfClickers clicker;
    Bob bob;
    Issy issy;
    Skeeldude skeeldude;
    Ryonical ryonical;
    EasterEggFirst firstEgg;
    /**
     * This will construct.
     * pre none
     * pram none
     * return none
     * post all
     */
    public Load(WorldOfClickers clicker2, 
    Bob bob2, Issy issy2, Skeeldude skeeldude2, Ryonical ryonical2,
    EasterEggFirst firstEgg2)
    {
        try
        {
            fileInt = new File("saveInt.txt");
            inFileInt = new Scanner(fileInt);
            fileDouble = new File("saveDouble.txt");
            inFileDouble = new Scanner(fileDouble);
            fileBool = new File("saveBool.txt");
            inFileBool = new Scanner(fileBool);
        }catch(Exception e)
        {
            System.out.println(e);
        }

        clicker = clicker2;
        bob = bob2;
        issy = issy2;
        skeeldude = skeeldude2;
        ryonical = ryonical2;
        firstEgg = firstEgg2;
        mySaveInt = new ArrayList<Integer>();
        mySaveDouble = new ArrayList<Double>();
        mySaveBool = new ArrayList<Boolean>();
    }//ends constructer

    /**
     * This will read everything.
     * pre none
     * pram none
     * return none
     * post none
     */
    public void reader()
    {
        try
        {
            //ints
            if(fileInt != null)
            {
                while(inFileInt.hasNext())
                {
                    mySaveInt.add(Integer.valueOf(inFileInt.nextInt()).intValue());
                }//ends while
            }//ends if
            //doubles
            if(fileDouble != null)
            {
                while(inFileDouble.hasNext())
                {
                    mySaveDouble.add(Double.valueOf(inFileDouble.nextDouble()).doubleValue());
                }//ends while
            }//ends if
            //bools
            if(fileInt != null)
            {
                while(inFileBool.hasNext())
                {
                    mySaveBool.add(Boolean.valueOf(inFileBool.nextBoolean()));
                }//ends while
            }//ends if
        }//ends try
        catch(Exception e)
        {
            System.out.println(e);
        }//ends catch
    }//ends reader
    
    /**
     * This will save everything that needs to be saved.
     * pre none
     * pram none
     * return none
     * post none
     */
    public void load()
    {
        //so I can add vars later
        int countInt = 0;
        int countDouble = 0;
        int countBool = 0;
        //the input for ints
        clicker.setAttackDamage(mySaveInt.get(countInt));
        countInt++;
        clicker.setDamageUpgradeCost(mySaveInt.get(countInt));
        countInt++;
        clicker.setBaseHealth(mySaveInt.get(countInt));
        countInt++;
        clicker.setTotalGold(mySaveInt.get(countInt));
        countInt++;
        clicker.setGoldGain(mySaveInt.get(countInt));
        countInt++;
        bob.setCost(mySaveInt.get(countInt));
        countInt++;
        issy.setCost(mySaveInt.get(countInt));
        countInt++;
        skeeldude.setCost(mySaveInt.get(countInt));
        countInt++;
        ryonical.setCost(mySaveInt.get(countInt));
        countInt++;
        
        //the input for doubles
        clicker.setDamageUpgrade(mySaveDouble.get(countDouble));
        countDouble++;
        clicker.setHealth(mySaveDouble.get(countDouble));
        countDouble++;
        bob.setDamage(mySaveDouble.get(countDouble));
        countDouble++;
        issy.setDamage(mySaveDouble.get(countDouble));
        countDouble++;
        skeeldude.setDamage(mySaveDouble.get(countDouble));
        countDouble++;
        ryonical.setDamage(mySaveDouble.get(countDouble));
        countDouble++;
        
        //the input for bools
        clicker.setBob(mySaveBool.get(countBool));
        countBool++;
        clicker.setIssy(mySaveBool.get(countBool));
        countBool++;
        clicker.setSkeeldude(mySaveBool.get(countBool));
        countBool++;
        clicker.setRyonical(mySaveBool.get(countBool));
        countBool++;
        bob.setFirst(mySaveBool.get(countBool));
        countBool++;
        issy.setFirst(mySaveBool.get(countBool));
        countBool++;
        skeeldude.setFirst(mySaveBool.get(countBool));
        countBool++;
        ryonical.setFirst(mySaveBool.get(countBool));
        countBool++;
    }//ends load
}//ends Save
