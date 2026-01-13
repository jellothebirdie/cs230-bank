
/**
 * Checking account in a bank, holds a balance
 *
 * @author Cindy and Anisa
 * @version 10/19/25
 */
public class Checking extends Account
{
    // instance variables - replace the example below with your own
    private int minBal = 100;
    private int overdraftFee = 25;
    

    /**
     * Constructor for objects of class Checking
     */
    public Checking(String accountOwner, double accountBal)
    {
        // initialise instance variables
        super(accountOwner, accountBal);
    }

    /**
     * withdraws money from the account and charges overdraft fee if applicable
     * 
     * @param money the amount to be withdrawn
     */
    public void withdraw(double money)
    {
        if (money > accountBal ){
            System.out.println("A withdraw of "+money+" is ordered. The transaction is denied.");
        } else if(accountBal - money < minBal){
            System.out.println("A withdraw of "+ money+ " is ordered. The new balance would be " + (accountBal - money)+" which is below the minimum balance. Therefore the overdraft fee of $25 is charged, which brings the account balance to "+ (accountBal - money - overdraftFee));
            accountBal = accountBal - money - overdraftFee; 
        }
        else {
            accountBal = accountBal - money;
        }
        
    }
    
    
    
    /**
     * creates a string representation of a checking account 
     *
     * @return    the string representation of a checking account 
     */
    public String toString()
    {
        return "Checking  account num: "+this.unique+"    Balance: "+this.accountBal+"    Minimum balance: 100.0       Overdraft fee: 25";
        
    }
}