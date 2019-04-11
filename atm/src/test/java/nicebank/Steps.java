package nicebank;

import common.AbstractSteps;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import transforms.MoneyConverter;

public class Steps extends AbstractSteps {
    private KnowsTheDomain helper;

    public Steps(){
        helper = new KnowsTheDomain();
    }

    class Account{
        private Money balance = new Money();

        public void deposit(Money amount){
            balance = balance.add(amount);
        }

        public Money getBalance(){
            return balance;
        }
    }

    class Teller{
        public void withdrawFrom(Account account, int dollars){

        }
    }

    class CashSlot{
        public int getContents(){
            return 0;
        }
    }

    class KnowsTheDomain{
        private Account myAccount;
        private CashSlot cashSlot;


        public Account getMyAccount(){
            if(myAccount == null) {
                myAccount = new Account();
            }
            return myAccount;
        }

        public CashSlot getCashSlot(){
            if(cashSlot == null){
                cashSlot = new CashSlot();
            }
            return cashSlot;
        }
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable{

        helper.getMyAccount().deposit(amount);

        Assert.assertEquals("incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }

    @When("^I request \\$(\\d+)$")
    public void i_request_$(int dollars) throws Throwable {
        Teller teller = new Teller();
        teller.withdrawFrom(helper.getMyAccount(), dollars);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed - ",
                dollars, helper.getCashSlot().getContents());
    }
}
