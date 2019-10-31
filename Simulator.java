import java.util.Random;
import java.util.ArrayList;
public class Simulator
{
    // instance variables
    
    private ArrayList<String> stockNames;  
    private String name;
    private String updown;
    private int change;
    
    public Simulator()
    {
        // initialise instance variables
        stockNames= new ArrayList<String>();       
    }
    //Setters
    public void setStockNames(String name){
        
        String[] s = {"up By", "down By"};

        Random ran = new Random();
        String updown = s[ran.nextInt(s.length)];
        
        

        // Obtain a number between [0 - 100].
         int change = (int)(Math.random() * 100 + 1);
        stockNames.add(name+":"+updown+" "+Integer.toString(change)+"%");
    }
    //Setters
    
    //Creating getters
    public ArrayList<String> getStockNames(){
        return stockNames;
    }
    
    // public String getName()
    // {
        // int m;

        // String n="";

        // for(String i:stockNames){
            // m=i.indexOf(":");
           
            // n=i.substring(0,m-1);

        // }
        // return n;
    // }
    
    public String getUpdown(String name)
    {
        int m;
        int j;
  

        String s="";
        for(String i:stockNames){
            if(i.indexOf(name)>-1){
            m=i.indexOf(":");
            j=i.indexOf("By") ;
           

            s=i.substring(m,j+2);
        }
        }
        return s;
    }
    
    public int getValue(String name)
    {

        int j;
        int k;
        String n="";
        int nr=0;
        try{
        for(String i:stockNames){
            if(i.indexOf(name)>-1){
            j=i.indexOf("By") ;
            k=i.indexOf("%");
            n=i.substring(j+3,k);

        }
        }
        
        nr=Integer.parseInt(n);
        }
        catch(NumberFormatException e){
        System.out.println("formatting error in the list");
        System.exit(0);
        }
        return nr;
    }
}
