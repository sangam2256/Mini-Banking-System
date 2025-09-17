import java.util.*;
public abstract class BankAccount {
    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected List<String> transactionHistory;

    //Methods: deposit(), withdraw(),
    // getAccountDetails(), addTransaction(), getTransactionHistory()

    BankAccount(int accountNumber,String accountHolderName,double initialDeposit){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance=initialDeposit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial deposit: ₹" + initialDeposit);
    }

    public void deposit(double deposit){
        if(deposit<=0){
            System.out.print("Invalid Balance");
            return;
        }
        balance+=deposit;
        addTransaction("Deposited Amount: " + deposit);
        System.out.println("Deposited Successful");
    }

    public abstract void withdraw(double amount);

    public void getAccountDetails(){
        System.out.println("Account No.: "+ accountNumber);
        System.out.println("Name: "+ accountHolderName);
        System.out.println("Balance: "+ balance);
    }

    protected void addTransaction(String transaction){
        transactionHistory.add(transaction);
    }

    public void getTransactionHistory(){
        System.out.println("Transaction History of: " + accountNumber + ":--");
        if(transactionHistory.isEmpty()){
            System.out.println("No transaction History found");
        }
        else{
            for(String txn : transactionHistory){
                System.out.println(txn);
            }
        }
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }
}
