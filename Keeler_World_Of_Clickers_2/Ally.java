
/**
* This will be the Interface.
* 
* @Ryan Keeler
* @World Of Clicker
*/
public interface Ally
{
    
    /**
    * This will return myDamage.
    * pre none
    * pram none
    * return myDamage
    * post none
    */
    public abstract double getDamage();
    
    /**
    * This will return myCost.
    * pre none
    * pram none
    * return myCost
    * post none
    */
    public abstract int getCost();
    
    /**
    * This will upgrade the Ally.
    * pre none
    * pram clicker
    * return none
    * post none
    */
    public abstract void upgrade(WorldOfClickers clicker);
}
