package helpers;

import entities.Book;
import entities.Member;
import entities.Transaction;
import java.sql.SQLException;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import models.BookDAO;
import models.BookDaoSQLite;
import models.MemberDAO;
import models.MemberDaoSQLite;

public class ShowTable<AllType> {
    
    private String keyColumn;
    private int columnLenght;

    public ShowTable(JTable table, List<AllType> dataList, String[] header, boolean editableColumns) throws SQLException {
        CustomTableModel tableModel = new CustomTableModel(new Object[][]{}, header, editableColumns);

        tableModel.setRowCount(0);
        
        Object[] rowData;
        for (AllType data : dataList) {
            rowData = DataConversion(data,header.length);

            tableModel.addRow(rowData);
        }

        int rowsToAdd = Math.max(20 - dataList.size(), 0);
        for (int i = 0; i < rowsToAdd; i++) {
            tableModel.addRow(new Object[header.length]);
        }

        table.setModel(tableModel);
        ColumnSize(table, keyColumn); //ter-set saat melewati fungsi 'instace of'
        
    }
    
    private void ColumnSize(JTable table, String keyColumn){
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(24);
        columnModel.getColumn(0).setMinWidth(20);
        columnModel.getColumn(0).setMaxWidth(40);
        
        if (keyColumn == "Transaksi 9 Table") {
            
            columnModel.getColumn(1).setPreferredWidth(35);
            columnModel.getColumn(1).setMinWidth(35);
            columnModel.getColumn(1).setMaxWidth(40);
            
            columnModel.getColumn(2).setMinWidth(110);
            
            columnModel.getColumn(3).setPreferredWidth(35);
            columnModel.getColumn(3).setMinWidth(35);
            columnModel.getColumn(3).setMaxWidth(40);
            
            columnModel.getColumn(5).setPreferredWidth(80);
            columnModel.getColumn(5).setMinWidth(40);
            columnModel.getColumn(5).setMaxWidth(80);
            
            columnModel.getColumn(6).setPreferredWidth(80);
            columnModel.getColumn(6).setMinWidth(40);
            columnModel.getColumn(6).setMaxWidth(80);
            
            columnModel.getColumn(7).setPreferredWidth(85);
            columnModel.getColumn(7).setMinWidth(40);
            columnModel.getColumn(7).setMaxWidth(85);
            
            columnModel.getColumn(8).setPreferredWidth(50);
            columnModel.getColumn(8).setMinWidth(40);
            columnModel.getColumn(8).setMaxWidth(50);

        }else if (keyColumn == "Buku Ori") {
            columnModel.getColumn(4).setPreferredWidth(90);
            columnModel.getColumn(4).setMinWidth(70);
            columnModel.getColumn(4).setMaxWidth(90);
            
            columnModel.getColumn(5).setPreferredWidth(90);
            columnModel.getColumn(5).setMinWidth(70);
            columnModel.getColumn(5).setMaxWidth(90);
        }
    }

    private Object[] DataConversion(AllType data, int tablevarian) throws SQLException {
        if (data instanceof Book book && tablevarian == 6) {
            this.keyColumn = "Buku Ori";
            this.columnLenght = tablevarian;
            return new Object[]{
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getYear(),
                book.getIsAvailable()};
        } else if (data instanceof Member member && tablevarian == 5) {
            this.keyColumn = "Member Ori";
            this.columnLenght = tablevarian;
            return new Object[]{
                member.getId(),
                member.getName(),
                member.getAddress(),
                member.getPhoneNumber(),
                member.getEmail()};
        } else if (data instanceof Transaction transaction && tablevarian == 7) {
            this.keyColumn = "Transaksi Ori";
            this.columnLenght = tablevarian;
            return new Object[]{
                transaction.getId(),
                transaction.getBookId(),
                transaction.getMemberId(),
                transaction.getBorrowDate(),
                transaction.getDueDate(),
                transaction.getReturnDate(),
                transaction.getFine()};
        }else if (data instanceof Transaction transaction && tablevarian == 9) {
            this.keyColumn = "Transaksi 9 Table";
            this.columnLenght = tablevarian;
            
            BookDAO bookDAO = new BookDaoSQLite();
            Book book = bookDAO.getBookById(transaction.getBookId());
            
            MemberDAO memberDAO = new MemberDaoSQLite();
            Member member = memberDAO.getMemberById(transaction.getMemberId());
            return new Object[]{
                transaction.getId(),
                transaction.getBookId(),
                book.getTitle(),
                transaction.getMemberId(),
                member.getName(),
                transaction.getBorrowDate(),
                transaction.getDueDate(),
                transaction.getReturnDate(),
                transaction.getFine()};
        }else if (data instanceof Book book && tablevarian == 3) {
            this.keyColumn = "Buku 3 Table";
            this.columnLenght = tablevarian;
            return new Object[]{
                book.getId(),
                book.getTitle(),
                book.getIsAvailable()};
        }else if (data instanceof Member member && tablevarian == 3) {
            this.keyColumn = "Member 3 Table";
            this.columnLenght = tablevarian;
            return new Object[]{
                member.getId(),
                member.getName(),
                member.getEmail()};
        }
        return new Object[0];
    }
}
