import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //Default Constructor
    Customer(){
        this.accountNumber= 1;
        this.deposits = new ArrayList <> ();
        this.withdraws = new ArrayList <> ();
        this.name = "Customer";
        this.checkBalance = 0.0;
        this.savingBalance = 0.0;
        this.savingRate = 0.0;
    }

    //Constructor
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.deposits = new ArrayList <> ();
        this.withdraws = new ArrayList <> ();
        deposit(checkDeposit, new Date(), CHECKING);
        deposit(savingDeposit, new Date(), SAVING);

    }

    //Requires: Double, amount / Date / String, account
    //Modifies: this, deposits
    //Effects: Returns the balance of money for the account where money is added into. Else do nothing.
    public double deposit(double amt, Date date, String account){
        //Makes sure that the deposit is not negative.
        if(amt>=0) {
            //Adds deposit to deposit ArrayList. Adds amount being deposited to the appropriate account's balance.
            if (account.equals(CHECKING)) {
                this.deposits.add(new Deposit(amt, date, CHECKING));
                this.checkBalance += amt;
                return this.checkBalance;
            } else if (account.equals(SAVING)) {
                this.deposits.add(new Deposit(amt, date, SAVING));
                this.savingBalance += amt;
                return this.savingBalance;
            } else {
                return 0;
            }
        }
        else{
            return 0;
        }
    }

    //Requires: Double, amount / Date / String, account
    //Modifies: this, withdraws
    //Effects: Returns a new lesser balance of money for the account where the money being taken out of. Else do nothing
    public double withdraw(double amt, Date date, String account){
        if(amt>0) {
            if (account.equals(CHECKING) && checkOverdraft(amt, CHECKING) == true) {
                this.withdraws.add(new Withdraw(amt, date, CHECKING));
                this.checkBalance -= amt;
                return this.checkBalance;
            } else if (account.equals(SAVING) && checkOverdraft(amt, SAVING) == true) {
                this.withdraws.add(new Withdraw(amt, date, SAVING));
                this.savingBalance -= amt;
                return this.savingBalance;
            } else {
                return 0;
            }
        }
        else{
            return 0;
        }
    }

    //Requires: Integer, amount / String, account
    //Effects: Return true if balance stays equal to or above -100. Return false if balance becomes lower than -100.
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)){
            return this.checkBalance - amt >= OVERDRAFT;
        }
        else if (account.equals(SAVING)){
            return this.savingBalance - amt >= OVERDRAFT;
        }
        else{
            return false;
        }
    }

    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    //Created these getters for tests on withdraw and deposit methods
    public double getCheckBalance() {
        return checkBalance;
    }
    public double getSavingBalance() {
        return savingBalance;
    }
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

}
