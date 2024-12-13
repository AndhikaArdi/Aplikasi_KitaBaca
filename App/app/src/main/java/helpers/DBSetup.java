package helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSetup {
    public static void createTable() {
        String[] sql = {
            """
            CREATE TABLE IF NOT EXISTS books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                author TEXT NOT NULL,
                publisher TEXT,
                year INTEGER,
                is_available BOOLEAN DEFAULT TRUE
            );
            """,

            """
            CREATE TABLE IF NOT EXISTS members (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                address TEXT,
                phone_number TEXT,
                email TEXT
            );
            """,

            """
            CREATE TABLE IF NOT EXISTS transactions (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                book_id INTEGER NOT NULL,
                member_id INTEGER NOT NULL,
                borrow_date DATE NOT NULL,
                due_date DATE NOT NULL,
                return_date DATE,
                fine DECIMAL(10, 2),
                FOREIGN KEY (book_id) REFERENCES books(id),
                FOREIGN KEY (member_id) REFERENCES members(id)
            );
            """,

            """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password_hash TEXT NOT NULL,
                role TEXT CHECK( role IN ('admin','staff') ) DEFAULT 'staff'
            );
            """,

            """
            CREATE TABLE IF NOT EXISTS activity_logs (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                user_id INTEGER,
                action TEXT NOT NULL,
                timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY (user_id) REFERENCES users(id)
            );
            """,
//------------------------------------------------------------------------------
            """
            CREATE TRIGGER IF NOT EXISTS update_book_availability_on_insert
            AFTER INSERT ON transactions
            FOR EACH ROW
            BEGIN
                UPDATE books
                SET is_available = FALSE
                WHERE id = NEW.book_id;
            END;
            """,

            """
            CREATE TRIGGER IF NOT EXISTS update_book_availability_on_return
            AFTER UPDATE ON transactions
            FOR EACH ROW
            WHEN NEW.return_date IS NOT NULL
            BEGIN
                UPDATE books
                SET is_available = TRUE
                WHERE id = NEW.book_id;
            END;
            """,

            """
            CREATE TRIGGER IF NOT EXISTS update_book_availability_on_update
            AFTER UPDATE ON transactions
            FOR EACH ROW
            WHEN OLD.book_id != NEW.book_id
            BEGIN
                UPDATE books
                SET is_available = TRUE
                WHERE id = OLD.book_id;
                UPDATE books
                SET is_available = FALSE
                WHERE id = NEW.book_id;
            END;
            """
        };

        try (Connection conn = DBConnect.connect();
            Statement stmt = conn.createStatement()) {
            for(String sqlExec: sql){
                stmt.execute(sqlExec);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
