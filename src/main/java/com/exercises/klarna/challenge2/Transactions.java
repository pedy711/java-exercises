package com.exercises.klarna.challenge2;

import java.util.*;

public class Transactions {

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        Map<String, Integer> consumerCredit = new HashMap<>();
        List<String> rejectedTransactions = new ArrayList<>();

        for (String transactionStr : transactions) {
            Transaction transaction = Transaction.fromString(transactionStr);

            String consumerKey = transaction.getConsumerKey();
            int consumedCredit = consumerCredit.getOrDefault(consumerKey, 0);

            if (consumedCredit + transaction.getAmount() <= creditLimit) {
                consumerCredit.put(consumerKey, consumedCredit + transaction.getAmount());
            } else {
                rejectedTransactions.add(transaction.getTransactionId());
            }
        }

        System.out.println(rejectedTransactions);
        return rejectedTransactions;
    }

    private static class Transaction {
        private final String consumerKey;
        private final int amount;
        private final String transactionId;

        public Transaction(String consumerKey, int amount, String transactionId) {
            this.consumerKey = consumerKey;
            this.amount = amount;
            this.transactionId = transactionId;
        }

        public String getConsumerKey() {
            return consumerKey;
        }

        public int getAmount() {
            return amount;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public static Transaction fromString(String transactionStr) {
            if(transactionStr == null || transactionStr.isBlank())
                throw new IllegalArgumentException("Transaction has no valid format.");

            String[] parts = transactionStr.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            String email = parts[2];
            int amount = Integer.parseInt(parts[3]);
            String transactionId = parts[4];
            String consumerKey = firstName + lastName + email;
            return new Transaction(consumerKey, amount, transactionId);
        }
    }
}
