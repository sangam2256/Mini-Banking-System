public class SavingAccount extends BankAccount {
    public SavingAccount(int accountNumber, String accountHolderName, double initialDeposit) {
        super(accountNumber, accountHolderName, initialDeposit);
    }

    private static final double MIN_BALANCE = 500;

    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Invalid Amount");
            return;
        }
        if(balance - amount < MIN_BALANCE){
            System.out.println("Minimum balance limit reached .Cannot Withdraw");
        }
        else{
            balance -= amount;
            addTransaction("Withdrew Rs.: " + amount);
            System.out.println("Withdrawal Successful");
        }
    }
}
