import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.io.*; 

public class Investor extends JFrame
{
     
    public static void main(String[] args)throws Exception
    {   
       // creating the shares as objects 
        ArrayList<Stock> arraylist = new ArrayList<Stock>();
       arraylist.add(new LargeCapStock("Google",1300));
       arraylist.add(new LargeCapStock("Facebook",1500));
       arraylist.add(new MidCapStock("Goldcorp",700));
       arraylist.add(new SmallCapStock("TPI Composites",700));
        
       printStock(arraylist);
       Portofolio p1 = new Portofolio();
            p1.setStockNames("Google");
            p1.setStockNames("Facebook");
            p1.setStockNames("Goldcorp");
            p1.setStockNames("TPI Composites");
        
        Simulator s1 = new Simulator();
        s1.setStockNames("Google");
    
       
        
        s1.setStockNames("Facebook");
        
      
        s1.setStockNames("Goldcorp");
  
      
        s1.setStockNames("TPI Composites");
        
        printchange(s1);
        //creating GUI
          
           
        //create a frame 
       JFrame f = new JFrame("ProgressBar demo"); 
  
        //create a panel 
        JPanel p = new JPanel(); 
        
       // create new label
        JLabel l1 = new JLabel("Google "+s1.getUpdown("Google")); 
        JLabel l2 = new JLabel("Facebook "+s1.getUpdown("Facebook")); 
        JLabel l3 = new JLabel("Goldcorp "+s1.getUpdown("Goldcorp")); 
        JLabel l4 = new JLabel("TPI Composites"+s1.getUpdown("TPI Composites")); 
      //  create a progressbar 
       JProgressBar b1 = new JProgressBar(); 
       JProgressBar b2 = new JProgressBar();
       JProgressBar b3 = new JProgressBar();
       JProgressBar b4 = new JProgressBar();
       
      // setting values for bars
       // set value for google 
        b1.setValue(s1.getValue("Google")); 
        
        b1.setStringPainted(true); 
        
       // set value for Facebook
        b2.setValue(s1.getValue("Facebook")); 
        
        b2.setStringPainted(true); 
        
         b3.setValue(s1.getValue("Goldcorp")); 
        
        b3.setStringPainted(true); 
        
        
         b4.setValue(s1.getValue("TPI Composites")); 
        
        b4.setStringPainted(true); 
       // add progressbar and labels
        p.add(l1);
        p.add(b1); 
        p.add(l2);
        p.add(b2);
        p.add(l3);
        p.add(b3);
        p.add(l4);
        p.add(b4);
      //  add panel 
        
        f.add(p); 
  
      //  set the size of the frame 
        f.setSize(200, 500); 
        f.setVisible(true); 
        
        Scanner input3 = new Scanner(System.in);
        System.out.print("Would you like to read a portofolio? Y/N");
        String answer3=input3.nextLine();
        if ((answer3.equals("y")||(answer3.equals("Y")))){
        File file = new File("Portofolio.txt"); 
  
       //     use a BufferedReader around FileReader
            BufferedReader br = new BufferedReader(new FileReader(file)); 
  
            String st; 
            int value2=0;
            int nr=0;
            int i=0;
            String ReadName="";
        //    use the readLine method of the BufferedReader to read one line at a time.
            br.readLine();
            while ((st = br.readLine()) != null) 
            {
             nr=0;
            String result =""; 
            System.out.println("i="+i);
            result =st.substring(st.length() - 1);
            System.out.println("result:"+result);
            nr=Integer.parseInt(result);
            if (i==0){
            ReadName="Google";
            }
            if (i==1){
            ReadName="Facebook";
            }
            if (i==2){
            ReadName="Goldcorp";
            }
            if (i==3){
            ReadName="TPI Composites";
            }
            i++;
            System.out.println("nr="+nr);
            if(nr!=0){
            while(nr>=1){
            for(Stock j:arraylist)
             {value2=0;
             if (j.getName().equals(ReadName)){
               value2=j.getValue();
               
               
            }
            if (value2!=0){
                p1.buyStock(ReadName,value2);
            }
            nr--;
        }
        }
              
                
          
        
        }}}
        printportofolio(p1);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to see create a portofolio? Y/N");
        String answer=input.nextLine();
        //checking if the input is y or Y so we can show the portofolio
        
        if ((answer.equals("y")||(answer.equals("Y"))))
        {    
           
            
            printportofolio(p1);
    
            
        
        
        Scanner input1 = new Scanner(System.in);
        
        System.out.print("Would you like to buy a Stock? Y/N");
        String answer1=input1.nextLine();
        //checking if the input is y or Y so we can show buy a stock
        int value1=0;
        while ((answer1.equals("y")||(answer1.equals("Y"))))
        {
            System.out.print("Please enter the name of the stock");
             Scanner input2 = new Scanner(System.in);
             String answer2=input2.nextLine();
             //getting the budget
             
             for(Stock i:arraylist)
             {
             if (i.getName().equals(answer2)){
               value1=i.getValue();
               
            }
        }   
              
                if(value1==0) System.out.println("Can't find it");
            
             if (value1!=0){
                p1.buyStock(answer2,value1);
            }
            System.out.print("Would you like to buy a Stock? Y/N");
            answer1=input1.nextLine();
             
        }
            printportofolio(p1);
            
            //creating the file writer
        Scanner input2 = new Scanner(System.in);
        
        System.out.print("Would you like to print Portofolio? Y/N");
        String answer2=input2.nextLine();
        if ((answer2.equals("y")||(answer2.equals("Y"))))
        {
            BufferedWriter bw = null;
        try {
           
            //declare  the file name and path here
            String budget=Integer.toString(p1.getBudget());
            File file = new File("Portofolio.txt");
 
           /* Tests whether the file or directory denoted by this abstract pathname exists.*/
            if (!file.exists()) {
                file.createNewFile();
            }
 
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(budget);
            bw.newLine();
            for(int i=0;i<p1.getStockNames().size();i++){
            
            String content=p1.getStockNames().get(i)+" Stock hold: "+p1.getStockHold().get(i);
            bw.write(content);
            bw.newLine();
        }
            System.out.println("Portofolio written to the file Successfully");
            
        } catch (IOException e) {
            
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the file Stream" + ex);
            }
        }
             
        
        }
        else System.out.println("Not Printed");
    }
     
    }
    
     
       
    
    //printing the name and value of the stock
    public static void printStock(ArrayList<Stock> arraylist){
        for(Stock i:arraylist){
        
        System.out.println("Stock Name: "+i.getName());
        System.out.println("Value: "+i.getValue());
        System.out.println("Taxes Paid: "+i.getTaxesPaid());
    }
    }
    //printing the changhes in price by percentage of the stock
    public static void printchange(Simulator s)
    {
        System.out.println("Changes:");
        for(int i=0;i<s.getStockNames().size();i++){
            System.out.println(s.getStockNames().get(i));
          
        }
    }
    //printing the portofolio and the budget 
    public static void printportofolio(Portofolio p)
    {
        System.out.println();
        System.out.println("Portofolio:");
        System.out.println("Current budget: "+p.getBudget());
        System.out.println();
        
        for(int i=0;i<p.getStockNames().size();i++){
            System.out.println(p.getStockNames().get(i));
            System.out.println(p.getStockHold().get(i));
        }
        
    }
}
