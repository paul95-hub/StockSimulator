
public class LargeCapStock extends Stock
{
   public LargeCapStock(String n,int val){
    super(n,val);
    }
    
     public double getTaxesPaid()
    {
        return (((getValue())*20)/100);
    }
}
