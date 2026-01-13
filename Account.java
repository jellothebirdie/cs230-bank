
/**
 * Account is in a bank. it can be either Checking or Savings
 *
 * @Cindy and Anisa
 * @10/19/25
 */
public abstract class Account
{
    // instance variables - replace the example below with your own
    private static int universalnum = 0;
    protected int unique;
    protected String accountOwner;
    protected double accountBal;

    /**
     * Constructor for objects of class Account
     */
    public Account(String accountOwner, double accountBal)
    {
        this.accountOwner = accountOwner;
        this.accountBal = accountBal;
        universalnum++;
        this.unique = universalnum;
        //universalnum++;
    }

    /**
     * deposits money into an account
     *
     * @param  money  amount of money to be added
     */
    public void deposit(double money)
    {
        accountBal = accountBal + money;
    }
    
    /**
     * withdraws money from the account
     * 
     * @param money the amount to be withdrawn
     */
    public abstract void withdraw(double money);

    
    /**
     * creates a string representation of an account
     * 
     * @return    String representation of account
     */
    public abstract String toString();
    
}