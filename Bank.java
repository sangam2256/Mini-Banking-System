import java.util.*;

/*
Stores all accounts using a collection (e.g., Map<Integer, BankAccount>)
Methods: addAccount(),
         deleteAccount(),
         searchAccount(),
         getAllAccounts(),
         getTotalBankBalance()
*/
public class Bank {
    private Map<Integer,BankAccount> accounts;

    public Bank(){
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account){
        accounts.put(account.getAccountNumber(),account);
        System.out.println("Account Successfully created");
    }
    public void deleteAccount(int accountNumber){
        if(accounts.containsKey(accountNumber)){
            accounts.remove(accountNumber);
            System.out.println("Account Deleted");
        }
        else{
            System.out.println("Account Does not exist");
        }
    }

    public BankAccount searchAccount(int accountNumber){
        return accounts.get(accountNumber);
    }

    public Collection<BankAccount> getAllAccounts(){
        return accounts.values();
    }

    public double getTotalBankBalance(){
        double total =0;
        for(BankAccount acc : accounts.values()){
            total+=acc.getBalance();
        }
        return total;
    }







}
