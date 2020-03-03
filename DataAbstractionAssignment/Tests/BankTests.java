import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.*;

public class BankTests {
    Customer test;

    @Before
    public void setUp(){
        test = new Customer("Customer", 1, 0, 0);
    }

    @Test
    public void testWithdrawToString(){
        //Create a withdraw object
        Withdraw testChecking = new Withdraw(1.0,new Date(), Customer.CHECKING);
        //Create a string of what it is suppose to output
        String expected = "Withdraw of: $" + 1.0 + " Date: " + new Date() +" into account: " + Customer.CHECKING;
        //Check that the withdraw methods output is the same as the expected string.
        assertEquals(expected, testChecking.toString());

        //Repeat for savings class
        Withdraw testSaving = new Withdraw(1.0,new java.util.Date(), Customer.SAVING);
        String expectedTwo = "Withdraw of: $" + 1.0 + " Date: " + new Date() +" into account: " + Customer.SAVING;
        assertEquals(testSaving.toString(), expectedTwo);
    }

    @Test
    public void testDepositToString(){
        //Same as testWithdrawToString, but with depositing money.
        Deposit testChecking =new Deposit(1.0, new Date(), Customer.CHECKING);
        String expected = "Deposit of: $" + 1.0 + " Date: " + new Date() +" into account: " + Customer.CHECKING;
        assertEquals(expected, testChecking.toString());

        Deposit testSaving = new Deposit(1.0,new java.util.Date(), Customer.SAVING);
        String expectedTwo = "Deposit of: $" + 1.0 + " Date: " + new Date() +" into account: " + Customer.SAVING;
        assertEquals(testSaving.toString(), expectedTwo);
    }

    @Test
    public void testDeposit(){
        //Make sure the balance is 0
        assertEquals(0.0, test.getCheckBalance());
        //Check that it doesn't allow negative deposits
        test.deposit(-1.0,new Date(), Customer.CHECKING);
        assertEquals(0.0, test.getCheckBalance());
        //Check that deposits work. The size is 3, since deposited 0 during setup.
        test.deposit(10.0, new Date(), Customer.CHECKING);
        assertEquals(10.0, test.getCheckBalance());
        assertEquals(3, test.getDeposits().size());

        //Same thing for savings account.
        assertEquals(0.0, test.getSavingBalance());
        test.deposit(-1.0,new Date(), Customer.SAVING);
        assertEquals(0.0,test.getSavingBalance());
        test.deposit(10.0, new Date(), Customer.SAVING);
        assertEquals(10.0, test.getSavingBalance());
        assertEquals( 4, test.getDeposits().size());
    }


    @Test
    public void testWithdraw(){
        //Putting in 10 dollars, then taking it out to make sure withdrawing works.
        assertEquals(0.0, test.getCheckBalance());
        test.deposit(10.0, new Date(), Customer.CHECKING);
        test.withdraw(10.0, new Date(), Customer.CHECKING);
        assertEquals( 0.0, test.getCheckBalance());
        //Making sure that the code doesn't allow the customer to withdraw to a point where they are -100 in debt.
        test.withdraw(100.0, new Date(), Customer.CHECKING);
        assertEquals( -100.0, test.getCheckBalance());
        test.withdraw(1, new Date(), Customer.CHECKING);
        assertFalse(test.getCheckBalance()==-101.0);
        assertEquals(-100.0,test.getCheckBalance());
        assertEquals(2, test.getWithdraws().size());

        //Same thing for savings account
        test.deposit(10.0, new Date(), Customer.SAVING);
        test.withdraw(10.0, new Date(), Customer.SAVING);
        assertEquals(0.0, test.getSavingBalance());
        test.withdraw(100.0, new Date(), Customer.SAVING);
        assertEquals(-100.0,test.getSavingBalance());
        test.withdraw(1.0, new Date(), Customer.SAVING);
        assertFalse(test.getSavingBalance()==-101.0);
        assertEquals(-100.0, test.getSavingBalance());
        assertEquals(4, test.getWithdraws().size());

    }

}
