package transforms;

import cucumber.api.Transformer;
import nicebank.Money;

import java.util.StringTokenizer;

public class MoneyConverter extends Transformer<Money> {
    public Money transform(String amount){
        String[] numbers = amount.split("\\.");
        int dollars = Integer.parseInt(numbers[0]);
        int cents = Integer.parseInt(numbers[1]);
        return new Money(dollars, cents);
    }
}
