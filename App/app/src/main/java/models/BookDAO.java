package models;

import entities.Book;
import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    
    public void addBook(Book book) throws SQLException;
    public void updateBook(Book book) throws SQLException;
    public void deleteBook(int id) throws SQLException;
    public Book getBookById(int id) throws SQLException;
    public List<Book> searchBooks(String keyword) throws SQLException;
    public List<Book> listBooks() throws SQLException;
}
