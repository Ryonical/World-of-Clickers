import java.util.*;
/**
* This will be your Secpnd Ally.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class Bob implements Ally
{
    public final double MY_DAMAGE_INCREACE = 1.23;
    public final double MY_COST_INCREACE = 1.25;
    public final int ROUND = 100;
    private ArrayList <Double> myDamage;
    private ArrayList <Integer> myCost;
    private boolean myFirst;
    /**
    * This is the constructer.
    * pre none
    * pram none
    * return none
    * post none
    */
    public Bob()
    {
        myDamage = new ArrayList<Double>();
        myCost = new ArrayList<Integer>();
        myCost.add((Integer)50);//this is how much it costs at the begining
        myFirst = true;
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
        if(myFirst)
        {
            return 0.0;
        }
        else
        {
            return myDamage.get(myDamage.size()-1);
        }
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
             if(myFirst)
             {
                 //this is so it starts at the assigned dps
                 myFirst = false;
                 myDamage.add((Double)(5.0 / 10));//this is how much damage 
                 //it starts at I want 5 dps and it attacks 4 times a second
             }
             else
             {
                 myDamage.add((double)((int)(myDamage.get((myDamage.size() - 1)).doubleValue() * MY_DAMAGE_INCREACE * ROUND)) / ROUND);
             }
             myCost.add((int)(myCost.get((myCost.size() - 1)).intValue() * MY_COST_INCREACE));
             clicker.setGold(gold);
             clicker.setBob(true);
         }//ends if
    }//ends upgrade
}//ends Ryonical
