package models;

import entities.Transaction;
import helpers.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoSQLite implements TransactionDAO {
    @Override
    public void addTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions (book_id, member_id, borrow_date, due_date, return_date, fine) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, transaction.getBookId());
            stmt.setInt(2, transaction.getMemberId());
            stmt.setDate(3, new java.sql.Date(transaction.getBorrowDate().getTime()));
            stmt.setDate(4, new java.sql.Date(transaction.getDueDate().getTime()));
            if (transaction.getReturnDate() != null) {
                stmt.setDate(5, new java.sql.Date(transaction.getReturnDate().getTime()));
            } else {
                stmt.setNull(5, Types.DATE);
            }
            stmt.setBigDecimal(6, transaction.getFine());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateTransaction(Transaction transaction) throws SQLException {
        String query = "UPDATE transactions SET book_id = ?, member_id = ?, borrow_date = ?, due_date = ?, return_date = ?, fine = ? WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, transaction.getBookId());
            stmt.setInt(2, transaction.getMemberId());
            stmt.setDate(3, new java.sql.Date(transaction.getBorrowDate().getTime()));
            stmt.setDate(4, new java.sql.Date(transaction.getDueDate().getTime()));
            if (transaction.getReturnDate() != null) {
                stmt.setDate(5, new java.sql.Date(transaction.getReturnDate().getTime()));
            } else {
                stmt.setNull(5, Types.DATE);
            }
            stmt.setBigDecimal(6, transaction.getFine());
            stmt.setInt(7, transaction.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteTransaction(int id) throws SQLException {
        String query = "DELETE FROM transactions WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Transaction getTransactionById(int id) throws SQLException {
        String query = "SELECT * FROM transactions WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Transaction(
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getInt("member_id"),
                        rs.getDate("borrow_date"),
                        rs.getDate("due_date"),
                        rs.getDate("return_date"),
                        rs.getBigDecimal("fine")
                    );
                }
            }
        }
        return null;
    }
    
    @Override
    public List<Transaction> searchTransactions(String keyword) throws SQLException{
        String query = "SELECT * FROM transactions WHERE book_id = ? OR member_id = ?";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            try {
                int id = Integer.parseInt(keyword);
                stmt.setInt(1, id);
                stmt.setInt(2, id);
            } catch (NumberFormatException e) {
                stmt.setInt(1, -1);
                stmt.setInt(2, -1);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    transactions.add(new Transaction(
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getInt("member_id"),
                        rs.getDate("borrow_date"),
                        rs.getDate("due_date"),
                        rs.getDate("return_date"),
                        rs.getBigDecimal("fine")
                    ));
                }
            }
        }
        return transactions;
    }
    
    @Override
    public List<Transaction> listTransactions() throws SQLException {
        String query = "SELECT * FROM transactions";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                transactions.add(new Transaction(
                    rs.getInt("id"),
                    rs.getInt("book_id"),
                    rs.getInt("member_id"),
                    rs.getDate("borrow_date"),
                    rs.getDate("due_date"),
                    rs.getDate("return_date"),
                    rs.getBigDecimal("fine")
                ));
            }
        }
        return transactions;
    }
}

