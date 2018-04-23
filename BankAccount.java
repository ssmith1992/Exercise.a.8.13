package Week10.Exercise13;

//Add a transfer method to the BankAccount class from the previous exercises. Your method should move money
//from the current bank account to another account. The method accepts two parameters: a second BankAccount to
//accept the money, and a real number for the amount of money to transfer. There is a $5.00 fee for transferring
//money, so this much must be deducted from the current account’s balance before any transfer. The method should
//modify the two BankAccount objects such that “this” current object has its balance decreased by the given amount
//plus the $5 fee, and the other account's balance is increased by the given amount. If this account object does not have
//enough money to make the full transfer, transfer whatever money is left after the $5 fee is deducted. If this account
//has under $5 or the amount is 0 or less, no transfer should occur and neither account's state should be modified. The
//following are some example calls to the method:
//BankAccount ben = new BankAccount();
//ben.deposit(80.00);
//BankAccount hal = new BankAccount();
//hal.deposit(20.00);
//ben.transfer(hal, 20.00); // ben $55, hal $40 (ben -$25, hal +$20)
//ben.transfer(hal, 10.00); // ben $40, hal $50 (ben -$15, hal +$10)
//hal.transfer(ben, 60.00); // ben $85, hal $ 0 (ben +$45, hal -$50)

public class BankAccount
{
    private String name;
    private double balance;
    private double transactionFee;

    public BankAccount(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0;
    }

    public void deposit(double amount)
    {
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount)
    {
        if (this.balance - amount - this.transactionFee >= 0)
        {
            this.balance = this.balance - amount - this.transactionFee;
        }
        else
        {
            System.out.println("Not enough money, OP CANCELLED");
        }
    }

    public void transfer(BankAccount otherAccount, double amount)
    {
        if (this.balance - amount - 5 >= 0)
        {
            this.balance = this.balance -5;
            this.withdraw(amount);
            otherAccount.deposit(amount);
        }
        else if(this.balance - 5 > 0 && this.balance - amount - 5 < 0)
        {
            this.balance = this.balance -5;
            double rest = this.balance;
            this.withdraw(rest);
            otherAccount.deposit(rest);
        }
        else
        {
            System.out.println("Not enough money, OP CANCELLED");
        }
    }

    public void setTransactionFee(double transactionFee)
    {
        this.transactionFee = transactionFee;
    }

    @Override
    public String toString()
    {
        return this.name + ", "  +  this.balance;
    }
}
