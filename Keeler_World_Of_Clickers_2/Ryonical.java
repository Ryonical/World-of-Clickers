import java.util.*;

/**
* This will be your Secpnd Ally.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class Ryonical implements Ally
{
    public final double MYDAMAGEINCREACE = 1.23;
    public final double MYCOSTINCREACE = 1.25;
    private ArrayList <Double> myDamage;
    private ArrayList <Integer> myCost;
    /**
    * This is the constructer.
    * pre none
    * pram none
    * return none
    * post none
    */
    public Ryonical()
    {
        myDamage = new ArrayList<Double>();
        myCost = new ArrayList<Integer>();
        myDamage.add((Double)1000.0);
        myCost.add((Integer)20000);
    }//ends constructer
    
    /**
    * This will return myDamage.
    * pre none
    * pram none
    * return myDamage
    * post none
    */
    public Double getDamage()
    {
        return myDamage.get(myDamage.size()-1);
    }//ends getDamage
    
    /**
    * This will return myCost.
    * pre none
    * pram none
    * return myCost
    * post none
    */
    public Integer getCost()
    {
        return myCost.get(myCost.size() - 1);
    }//ends getCost
    
    /**
    * This will upgrade Bob.
    * pre none
    * pram clicker
    * return none
    * post none
    */
    public void upgrade(WorldOfClickers clicker)
    {
         int gold;
         gold = clicker.getTotalGold();
         if(gold >= myCost.get(myCost.size() - 1))
         {
             gold -= myCost.get(myCost.size() - 1);
             if(myDamage.get(myDamage.size() - 1) <= 5)
             {
                 myDamage.add(myDamage.get((myDamage.size() - 1)).doubleValue() + 0.5);
             }
             else
             {
                 myDamage.add(myDamage.get((myDamage.size() - 1)).doubleValue() * MYDAMAGEINCREACE);
             }
             myCost.add((int)(myCost.get((myCost.size() - 1)).intValue() * MYCOSTINCREACE));
             clicker.setGold(gold);
             clicker.setRyonical(true);
         }//ends if
    }//ends upgrade
}//ends Ryonical
