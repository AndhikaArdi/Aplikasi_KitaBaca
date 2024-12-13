package models;

import entities.Transaction;
import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO {
    
    public void addTransaction(Transaction transaction) throws SQLException;
    public void updateTransaction(Transaction transaction) throws SQLException;
    public void deleteTransaction(int id) throws SQLException;
    public Transaction getTransactionById(int id) throws SQLException;
    public List<Transaction> searchTransactions(String keyword) throws SQLException;
    public List<Transaction> listTransactions() throws SQLException;
    
}