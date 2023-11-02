import java.util.*;
class BankAccount {
    public double balance;
    public BankAccount (double initialBalance){
        balance = initialBalance;
    }   
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount){
        if(amount > 0){
        balance += amount;
        System.out.println("The new balance is :" + balance);            
        }
        else{ System.out.println("Invalid amount for deposit!!");}
    }
    public void withdraw(double amount)
    {
        if(amount >0 && amount<=balance)
        {
            balance -= amount;
            System.out.println("Amount withdrawn: "+ balance);
        }
        else{
            System.out.println("Insufficient funds or invalid amount for withdrawing!");
        }
    }
}
class ATM{
    private BankAccount account;
    static Scanner in = new Scanner(System.in);
    public ATM(BankAccount account)
    {
        this.account =account;
    }
    void menu(){
        System.out.println("******************ATM***********************");
        System.out.print("ATM Menu:\nPlease select what you want to do from the list below:\n1.Check balance\n2.Deposit Balance\n3.Withdraw Balance\n4.Exit\n");
    }
    public void initiate(){
        int choice,pin;
        System.out.print("Enter your pin:");
        pin = in.nextInt();
        do{
            menu();
            System.out.print("Enter your choice:");
            choice=in.nextInt();
            switch (choice) {
                case 1:
                    ChekcBalance();
                    break;
                case 2:
                    depositBalance();
                    break;
                case 3:
                    withdrawBalance();
                    break;
                case 4:
                    break;
                default:
                    System.out.print("Please enter a valid choice....\n");
            }
        }while(choice!=4);
    }
    public void ChekcBalance(){System.out.println("The Balance of your account is:"+account.getBalance()+"\n");}
    public void depositBalance(){System.out.print("Enter the amount you want to deposit:");
    double amount=in.nextInt();
    account.deposit(amount);
    }
    public void withdrawBalance(){System.out.print("Enter the amount you want to withdraw:");
    double amount=in.nextInt();
    account.withdraw(amount);
    }
}
class ATMinterface{
    public static void main(String args[])
    {
        BankAccount ob = new BankAccount(1000);
        ATM ob1 = new ATM(ob);
        ob1.initiate();
    }
    
}
    

        

