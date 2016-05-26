import java.util.*;
/**
* This will be your Secpnd Ally.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public class Skeeldude implements Ally
{
    public final double MY_DAMAGE_INCREACE = 1.25;
    public final double MY_COST_INCREACE = 1.23;
    public final int ROUND = 100;
    private double myDamage;
    private int myCost;
    private boolean myFirst;
    /**
    * This is the constructer.
    * pre none
    * pram none
    * return none
    * post none
    */
    public Skeeldude()
    {
        myDamage = 0;
        myCost = 2500;//this is how much it costs at the begining
        myFirst = true;
    }//ends constructer
    
    
    /**
    * This will set myDamage.
    * pre none
    * pram none
    * return none
    * post myDamage
    */
    public void setDamage(double damage)
    {
         myDamage = damage;
    }//ends getCost
    
    /**
    * This will return myDamage.
    * pre none
    * pram none
    * return myDamage
    * post none
    */
    public double getDamage()
    {
        if(myFirst)
        {
            return 0.0;
        }
        else
        {
            return myDamage;
        }
    }//ends getDamage
    
    /**
    * This will set myFirst.
    * pre none
    * pram none
    * return none
    * post myFirst
    */
    public void setFirst(boolean first)
    {
         myFirst = first;
    }//ends getCost
    
    /**
    * This will return myFirst.
    * pre none
    * pram none
    * return myFirst
    * post none
    */
    public boolean getFirst()
    {
         return myFirst;
    }//ends getCost
    
    /**
    * This will set myCost.
    * pre none
    * pram none
    * return none
    * post myCost
    */
    public void setCost(int cost)
    {
         myCost = cost;
    }//ends getCost
    
    /**
    * This will return myCost.
    * pre none
    * pram none
    * return myCost
    * post none
    */
    public int getCost()
    {
        return myCost;
    }//ends getCost
    
    /**
    * This will upgrade Skeeldude.
    * pre none
    * pram clicker
    * return none
    * post none
    */
    public void upgrade(WorldOfClickers clicker)
    {
         int gold;
         gold = clicker.getTotalGold();
         if(gold >= myCost)
         {
             gold -= myCost;
             if(myFirst)
             {
                 //this is so it starts at the assigned dps
                 myFirst = false;
                 myDamage =(425.0 / 10) * clicker.getRecombobulateDamage();//this is how much damage 
                 //it starts at I want 5 dps and it attacks 10 times a second
             }
             else
             {
                 myDamage *= ((MY_DAMAGE_INCREACE * ROUND) / ROUND) * clicker.getRecombobulateDamage();
             }
             myCost *= MY_COST_INCREACE;
             clicker.setTotalGold(gold);
             clicker.setSkeeldude(true);
         }//ends if
    }//ends upgrade
}//ends Skeeldude
