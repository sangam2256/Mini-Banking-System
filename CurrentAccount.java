public class CurrentAccount extends BankAccount {
    public CurrentAccount(int accountNumber, String accountHolderName, double initialDeposit) {
        super(accountNumber, accountHolderName, initialDeposit);
    }

    //private static final double MIN_BALANCE = 500;

    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Invalid Amount");
            return;
        }
        if(amount > balance){
            System.out.println("Insufficient Balance");
        }
        else{
            balance -= amount;
            addTransaction("Withdrew Rs.: " + amount);
            System.out.println("Withdrawal Successful");
        }
    }
}
