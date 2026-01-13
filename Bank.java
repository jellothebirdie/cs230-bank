
/**
 * Bank represents a bank that holds a collection of accounts, checkings and savings.
 *
 * @author Cindy and Anisa
 * @version 10/19/25
 */
public class Bank
{
    private Account[] AccountCollection;
    private int totalAccs;

    /**
     * Constructor for objects of class Bank
     */
    public Bank()
    {
        this.AccountCollection  = new Account[10];
        this.totalAccs = 0;
    }
    
    
    /**
     * adds an account to the bank account collection
     *
     * @param  a  an account to be added to the bank
     */
    public void addAccount(Account a)
    {
        AccountCollection[totalAccs] = a;
        totalAccs++;
    }
    
    /**
     * opens a new bank account
     *
     * @param  accountType  either a Checking or Savings account
     * @param   owner   the owner of the account
     * @param   balance the starting balance of the account
     */
    public void open(String accountType, String owner, double balance)
    {
        if (accountType.equals("Checking") && balance >= 100.0){
            Checking a1 = new Checking(owner, balance);
            this.addAccount(a1);
        } else if (accountType.equals("Checking") && balance < 100.0){
            System.out.println("REMINDER: must deposit at least $100 to open a Checking account.");
        } else if (accountType.equals("Savings")){
            Savings a1 = new Savings(owner, balance);
            this.addAccount(a1);
        } else {
            System.out.println("Must be either Checking or Savings.");
        }
    }
    
    /**
     * search looks for an account by its account number
     *
     * @param  accNum  a number to look for associated accounts
     * @return the account that is associated if it exists
     */
    public Account search(int accNum){
        for (int i = 0; i < totalAccs; i++){
            if (this.AccountCollection[i].unique == accNum){
                return AccountCollection[i];
            }
        }
        return null;
    }
    
    /**
     * creates a string representation of a bank
     *
     * @return  string representation of a bank
     */
    public String toString()
    {
        String bankString = "This bank currently manages "+ totalAccs +" accounts. \n";  
        for (int i=0; i < totalAccs; i++){
            bankString = bankString + AccountCollection[i].toString() + "\n";
        }
        return bankString;
    }
    
    /**
     * total funds finds the total amount of money that a bank manages
     *
     * @return the total amount of money
     */
    public double totalFunds()
    {
        double total = 0;
        for (int i=0; i < totalAccs; i++){
            total = total + AccountCollection[i].accountBal;
        }
        return total;
    }
    
    /**
     * display finds the accounts associated with an owner 
     *
     * @return string representation of owner's accounts 
     */
    public void display(String owner)
      {
        String bankString = "These are your current accounts: ";  
        for (int i=0; i < totalAccs; i++){
            if(owner.equals(AccountCollection[i].accountOwner)){
                bankString = bankString + AccountCollection[i].toString() + "\n";
            }
        }
        System.out.println(bankString);
    }  
    
    public static void main(String[] args){
        Bank chase = new Bank();
        //chase.open("Checking", "John", 150.0);
        //chase.open("Checking", "John", 120.0);
        //chase.open("Savings", "John", 300.0);
        chase.open("Checking", "Tabitha", 50.0);
        System.out.println("Creating new Checking account with $50 for Tabitha. Expected output: REMINDER: must deposit at least $100 to open a Checking account. \n" + chase.toString());
        
        chase.open("Checking", "Amy", 100.0);
        System.out.println("Creating new Checking account with $100 for Amy. \n" + chase.toString());
        System.out.println("Withdrawing $200. Expected output: A withdraw of 200 is ordered. The transaction is denied.");
        chase.search(1).withdraw(200.0);
        System.out.println(chase.toString());
        System.out.println("Depositing $110. Expected balance: 210.");
        chase.search(1).deposit(110.0);
        System.out.println(chase.toString());
        System.out.println("Withdrawing $50. Expected balance: 160.");
        chase.search(1).withdraw(50.0);
        System.out.println(chase.toString());
        System.out.println("Withdrawing $100. Expected balance: 35.");
        chase.search(1).withdraw(100.0);
        System.out.println(chase.toString());
        System.out.println("Withdrawing $15. Expected balance: -5.");
        chase.search(1).withdraw(15.0);
        System.out.println(chase.toString());
        
        System.out.println("accruing Interest on checking. Expected output: Cannot accrue interest. This is a Checking account.");
        ((Savings) chase.search(1)).accrueInterest();
        System.out.println(chase.toString());
        
        chase.open("Savings", "Amy", 300.0);
        System.out.println("Creating new Sanvings account with $300 for Amy. \n" + chase.toString());
        
        System.out.println("Withdrawing $200. Expected balance: 100.");
        chase.search(2).withdraw(200.0);
        System.out.println(chase.toString());
        
        System.out.println("Withdrawing $50. Expected balance: 50.");
        chase.search(2).withdraw(50.0);
        System.out.println(chase.toString());
        
        System.out.println("Withdrawing $60. Expected output: A withdraw of $60 is ordered. The transaction is denied.");
        chase.search(2).withdraw(60.0);
        System.out.println(chase.toString());
        
        System.out.println("Depositing $50. Expected balance: 100.");
        chase.search(2).deposit(50.0);
        System.out.println(chase.toString());
        
        System.out.println("accruing Interest. Expected balance: 105.");
        Account savings = chase.search(2);
        ((Savings) savings).accrueInterest();
        System.out.println(chase.toString());
        
        
        
        System.out.println("Calling totalFunds method. Expected output: $100");
        chase.totalFunds();
        
        System.out.println("Displaying Amy's accounts");
        chase.display("Amy");
        
        System.out.println(chase.toString());
        
        
        
    }
    
}