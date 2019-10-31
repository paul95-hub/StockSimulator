
public class Stock
{
    // instance variables
    private String name;
    private int value;
    
    public Stock(String n,int val)
    {
       // initialise instance variables
       name = n;
       value = val;
    }
    //Creating getters
    public String getName()
    {
        return name;
    }
  
    public int getValue()
    {
        return value;
    }
    
    public double getTaxesPaid()
    {
        return (((getValue())*20)/100);
    }
}
