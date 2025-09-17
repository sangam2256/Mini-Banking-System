import java.util.*;
public class BankingApp {
    private static  Bank bank = new Bank();
    private static Scanner sc = new Scanner(System.in);
    private static int counter = 1726101;
    public static void main(String[] args){

         int choice ;
         do{
             System.out.println("====== Welcome to My Bank ======");
             System.out.println("1. Create Account");
             System.out.println("2. Deposit Money");
             System.out.println("3. Withdraw Money");
             System.out.println("4. View Account Details");
             System.out.println("5. View Transaction History");
             System.out.println("6. Admin Login");
             System.out.println("7. Exit");
             System.out.print("Enter your choice: ");
             choice = sc.nextInt();

             switch(choice){
                 case 1:
                     createAccount();
                     break;
                 case 2:
                     deposit();
                     break;
                 case 3:
                     withdraw();
                     break;
                 case 4:
                     viewAccountDetails();
                     break;
                 case 5:
                     viewTransactionHistory();
                     break;
                 case 6:
                     adminMenu();
                     break;
                 case 7:
                     System.out.println("Thank You!!");
                     break;
                 default:
                     System.out.println("Invalid Selection");

             }

         }
         while(choice != 7);
    }

    public static void createAccount(){
        System.out.println("Enter Account Holder Name: ");
        String name = sc.next();
        System.out.println("Initial Deposit");
        double deposit = sc.nextInt();


        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int type = sc.nextInt();

        BankAccount account = null;

        if(type ==1){
            if(deposit<500){
                System.out.println("Minimum deposit should be 500.");
                return;
            }
            account = new SavingAccount(counter++,name,deposit);

        }else if(type==2){
            account = new CurrentAccount(counter++,name,deposit);

        }else{
            System.out.println("Invalid Account Type. ");
            return;
        }

        bank.addAccount(account);
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public static void deposit(){
        System.out.print("Enter account number:");
        int accNo = sc.nextInt();
        BankAccount account = bank.searchAccount(accNo);
        if(account != null){
            System.out.print("Enter amount : ");
            double amount = sc.nextInt();
            account.deposit(amount);
        }
        else {
            System.out.println("Account doesn't exist");
        }
    }
    public static void withdraw(){
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount account = bank.searchAccount(accNo);
        if(account != null){
            System.out.print("Enter amount : ");
            double amount = sc.nextInt();
            account.withdraw(amount);
        }
        else {
            System.out.println("Account doesn't exist");
        }
    }
    public static void viewAccountDetails(){
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount account = bank.searchAccount(accNo);
        if (account != null) {
            account.getAccountDetails();
        } else {
            System.out.println("Account doesn't exist.");
        }
    }

    private static void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        BankAccount account = bank.searchAccount(accNo);
        if (account != null) {
            account.getTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void adminMenu(){
        System.out.print("Enter Admin Password: ");
        String password = sc.next();
        if(!password.equals("Sangam123")){
            System.out.println("Incorrect Password");
            return;
        }

        int choice ;
        do{
            System.out.println("-- Admin Menu --");
            System.out.println("1. View All Accounts");
            System.out.println("2. Search Account");
            System.out.println("3. Delete Account");
            System.out.println("4. View Total Bank Balance");
            System.out.println("5. Exit Admin Menu");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    for(BankAccount acc : bank.getAllAccounts()){
                        acc.getAccountDetails();
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int accNo = sc.nextInt();
                    BankAccount account = bank.searchAccount(accNo);
                    if (account != null) {
                        account.getAccountDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number to delete: ");
                    int accNum = sc.nextInt();
                    bank.deleteAccount(accNum);
                    break;
                case 4:
                    System.out.println("Total Bank Balance: ₹" + bank.getTotalBankBalance());
                    break;
                case 5:
                    System.out.println("Exiting Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");


            }
        }while(choice!=5);
    }

}
