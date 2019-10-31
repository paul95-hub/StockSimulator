
public class SmallCapStock extends Stock
{
    public SmallCapStock(String n,int val){
    super(n,val);
    }
    
     public double getTaxesPaid()
    {
        return (((getValue())*10)/100);
    }
}
