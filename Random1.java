import java.util.*;
public class Random1 {
     static Scanner in=new Scanner(System.in);
    int cal(int num,int chance){
    int randnum=0;
    while(randnum!=num && chance!=0){
        System.out.print("Enter the number:");
        randnum=in.nextInt();
        if(randnum>num){
        System.out.print("Sorry the number that you have guessed is too high.Please try again..\n");
        chance--;
        }
        else if(randnum<num){
        System.out.print("Sorry the number you have guessed is too low.Please try again...\n");
        chance--;    
        }
        else{
        System.out.print("You have guessed the number correctly\n");
        }
    }
    return chance;
    }
    public static void main(String args[]){    
    int up,low,num2=0;char c='Y';
    System.out.print("Enter the upper bound and the lower bound of the random numbers:");
    up=in.nextInt();
    low=in.nextInt();
    Random1 ob=new Random1();
    Random rand = new Random();
    int num=(rand.nextInt(up-low+1)+low);
    System.out.print("A random number has been generated!!You have got three chances to guess it....\n");
    int chance=3;
    int num1=ob.cal(num, chance);
    if(num1==0){
        do{
            System.out.print("You have spent all your chances!! Do you want to go at it again?(Y/N):");
            c=in.next().charAt(0);
            if(c=='Y'){
            num2=ob.cal(num, chance);
        }
        else
         break;
       
    }while(num2==0);
    }
    
   }
}
