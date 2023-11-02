import java.util.*;
public class Calculator {
    static Scanner in=new Scanner(System.in);
    int mark1[]=new int[100];
    int n,tot=0,avg=0;
    void input()
    {
        System.out.print("Enter the number of subject you want to enter:");
        n=in.nextInt();
        System.out.print("Enter the marks of the subject out of 100...\n");
        for(int i=0;i<n;i++){System.out.print("Enter the number of "+(i+1)+"th subject:");mark1[i]=in.nextInt();}
        
    }

    void calculate(){
        for(int i=0;i<n;i++)
        {
            tot=tot+mark1[i];
            avg=tot/n;
        }
    }
    void display(){
        System.out.println("Your total marks is:"+tot);
        System.out.println("Your average percentage: "+avg);
        if(avg>=90)
        System.out.print("Your Grade: O");
        else if(avg<90 && avg>=80)
        System.out.print("Your Grade: E");
        else if(avg<80 && avg>=70)
        System.out.print("Your Grade: A");
        else if(avg<70 && avg>=60)
        System.out.print("Your Grade: B");
        else if(avg<60 && avg>=50)
        System.out.print("Your Grade: C");
        else if(avg<50 && avg>=40)
        System.out.print("Your Grade: D");
        else
        System.out.print("You have failed in the exama.");
    }
    public static void main(String args[])
    {
     Calculator ob=new Calculator();
     ob.input();
     ob.calculate();
     ob.display(); 
    }
}
