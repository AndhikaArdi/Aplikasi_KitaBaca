package helpers;

import java.util.ArrayList;
import java.util.List;
import models.BookDAO;
import models.BookDaoSQLite;
import models.MemberDAO;
import models.MemberDaoSQLite;
import models.TransactionDAO;
import models.TransactionDaoSQLite;
import entities.Book;
import entities.Member;
import entities.Transaction;
import java.sql.SQLException;

public class OpsiTable {
    BookDAO bookDAO;
    MemberDAO memberDAO;
    TransactionDAO transactionDAO;

    public List<Object> getDataTable(String criteria, String keyword, int Key) throws SQLException {
        bookDAO = new BookDaoSQLite();
        memberDAO = new MemberDaoSQLite();
        transactionDAO = new TransactionDaoSQLite();
        
        List<Object> dataList = new ArrayList<>();
        switch (Key) {
            case 1 -> {
                dataList = listTable(criteria);
            }
            case 2 -> {
                dataList = searchTable(criteria,keyword);
            }
            default -> {
                dataList = listTable(criteria);
            }
        }
        
        return dataList;
    }
    
    private List<Object> listTable(String criteria) throws SQLException {
        List<Object> dataList = new ArrayList<>();

        switch (criteria) {
            case "Buku" -> {
                List<Book> bookList = bookDAO.listBooks();
                dataList.addAll(bookList);
            }
            case "Anggota" -> {
                List<Member> memberList = memberDAO.listMembers();
                dataList.addAll(memberList);
            }
            case "Transaksi" -> {
                List<Transaction> transactionList = transactionDAO.listTransactions();
                dataList.addAll(transactionList);
            }
            default -> {
            }
        }

        return dataList;
    }
    
    private List<Object> searchTable(String criteria,String keyword) throws SQLException {
        List<Object> dataList = new ArrayList<>();

        switch (criteria) {
            case "Buku" -> {
                List<Book> bookList = bookDAO.searchBooks(keyword);
                dataList.addAll(bookList);
            }
            case "Anggota" -> {
                List<Member> memberList = memberDAO.searchMembers(keyword);
                dataList.addAll(memberList);
            }
            case "Transaksi" -> {
                List<Transaction> transactionList = transactionDAO.searchTransactions(keyword);
                dataList.addAll(transactionList);
            }
            default -> {
            }
        }

        return dataList;
    }
}
