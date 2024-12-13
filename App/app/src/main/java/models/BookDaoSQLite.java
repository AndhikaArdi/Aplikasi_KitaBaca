package models;

import entities.Book;
import helpers.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoSQLite implements BookDAO{
    @Override
    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, publisher, year, is_available) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setInt(4, book.getYear());
            stmt.setBoolean(5, book.getIsAvailable());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        String query = "UPDATE books SET title = ?, author = ?, publisher = ?, year = ?, is_available = ? WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setInt(4, book.getYear());
            stmt.setBoolean(5, book.getIsAvailable());
            stmt.setInt(6, book.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        String query = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Book getBookById(int id) throws SQLException {
        String query = "SELECT * FROM books WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year"),
                        rs.getBoolean("is_available")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Book> searchBooks(String keyword) throws SQLException {
        String query = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR id = ?";
        List<Book> books = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            try {
                int id = Integer.parseInt(keyword);
                stmt.setInt(3, id);
            } catch (NumberFormatException e) {
                stmt.setInt(3, -1);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year"),
                        rs.getBoolean("is_available")
                    ));
                }
            }
        }
        return books;
    }
    

    @Override
    public List<Book> listBooks() throws SQLException {
        String query = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year"),
                        rs.getBoolean("is_available")
                    ));
                }
            }
        }
        return books;    }
}

