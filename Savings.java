
/**
 * savings account in a bank, holds a balance
 *
 * @author Cindy & Anisa
 * @version 10/19/25
 */
public class Savings extends Account
{

    /**
     * Constructor for objects of class Savings
     */
    public Savings(String accountOwner, double accountBal)
    {
        // initialise instance variables
        super(accountOwner, accountBal);
    }

    /**
     * updates the account balance w/ interest
     *
     */
    public void accrueInterest()
    {
        // put your code here
        this.accountBal = this.accountBal * 1.05;
    }
    
    /**
     * withdraws money from the account
     * 
     * @param money the amount to be withdrawn
     */
    public void withdraw(double money)
    {
        if (money > accountBal ){
            System.out.println("A withdraw of "+money+" is ordered. The transaction is denied.");   
        } else {
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
     return "Savings account num: "+this.unique +"   Balance: $"+this.accountBal +"    Interest rate: 0.5";
    }
}