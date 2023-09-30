package klarna;


import com.exercises.klarna.challenge2.Transactions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class TransactionsSampleTest {

    @Test
    public void shouldReturnEmptyListIfThereIsNoTransactions() {
        assertThat(Transactions.findRejectedTransactions(new ArrayList<>(), 0).size(), is(0));
    }

    @Test
    public void shouldReturnEmptyListIfThereIsATransactionWithinCreditLimit() {
        List<String> transactions = List.of("John,Doe,john@doe.com,200,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions.size(), is(0));
    }

    @Test
    public void shouldReturnTransationThatIsOverCreditLimit() {
        List<String> transactions = List.of("John,Doe,john@doe.com,201,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(List.of("TR0001")));
    }

    @Test
    public void shouldReturnTwoTransationsThatIsOverCreditLimit() {
        List<String> transactions = Arrays.asList(
                "John,Doe,john@doe.com,199,TR0001",
                "John,Doe,john@doe.com,2,TR0002",
                "John,Doe,john@doe.com,0,TR0003");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(List.of("TR0002")));
    }

    @Test
    public void shouldReturnOneTransactionThatIsOverCreditLimit() {
        List<String> transactions = Arrays.asList(
                "John,Doe,john@doe.com,200,TR0001",
                "John,Doe,john@doe.com,2,TR0002",
                "John,Doe,jj@doe.com,3,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(List.of("TR0002")));
    }

    @Test
    public void shouldNotReturnEmptyTransaction() {
        List<String> transactions = Arrays.asList(
                "John,Doe,john@doe.com,200,TR0001",
                "John,Doe,john@doe.com,2,TR0002",
                "John,Doe,jj@doe.com,0,TR0003");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(List.of("TR0002")));
    }



}