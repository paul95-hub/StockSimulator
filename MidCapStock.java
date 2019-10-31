
public class MidCapStock extends Stock
{
    public MidCapStock(String n,int val){
    super(n,val);
    }
    
     public double getTaxesPaid()
    {
        return (((getValue())*15)/100);
    }
}
