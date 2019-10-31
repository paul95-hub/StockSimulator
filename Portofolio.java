import java.util.ArrayList;

public class Portofolio
{
    // instance variables
    private ArrayList<String> stockNames;  
    private ArrayList<Integer> stockHold; 
    private int budget;
    
    public Portofolio()
    {
        // initialise instance variables
        stockNames= new ArrayList<String>();
        stockHold=new ArrayList<Integer>();
        budget=5000;
    }
    //incrasing the value in StockHold
    public void buyStock(String name,int value){
        if((budget-value)>0){
        int i= stockNames.indexOf(name);
        int Number=stockHold.get(i);
        Number++;
        stockHold.set(i,Number);
        budget=budget-value;
    }
        else{
            System.out.println("Not enought budget");
            System.out.println("Your bugdet is "+budget);
        }
        
        
    }
    public void setStockNames(String name){
        stockNames.add(name);
        stockHold.add(0);
    }
    
    public ArrayList<Integer> getStockHold(){
        return stockHold;
    }
    
    public ArrayList<String> getStockNames(){
        return stockNames;
    }
    public int getBudget()
    {
        return budget;
    }
}
