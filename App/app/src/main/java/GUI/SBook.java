package GUI;

import entities.Book;
import entities.Transaction;
import helpers.OpsiTable;
import helpers.ShowTable;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.BookDAO;
import models.BookDaoSQLite;
import models.TransactionDAO;
import models.TransactionDaoSQLite;

public class SBook extends javax.swing.JPanel {

    CardLayout mainLayout;
    JPanel mainPanel;
    
    private Book book;
    private List<Transaction> Transactionlist;
    
    private ShowTable showTable;
    private String[] BookHeader = {"ID","Judul","Penulis","Penerbit","Tahun Terbit","Ketersediaan"};
    private String[] AvailableBox = {"Tersedia","Tidak Tersedia"};

    public SBook(CardLayout mainLayout, JPanel mainPanel) throws SQLException {
        this.mainLayout = mainLayout;
        this.mainPanel = mainPanel;
        
        initComponents();
        
        AvailableList.removeAllItems();
        for (String item : AvailableBox) {
            AvailableList.addItem(item);
        }
        
        BookDAO bookDAO = new BookDaoSQLite();
        List<Book> Booklist = bookDAO.listBooks();
        showTable = new ShowTable(MainTable,Booklist,BookHeader,false);

        initializeForm();
    }
    
    public void refresh() throws SQLException {
        SearchField.setText("");
        FieldTitle.setText("");
        FieldAuthor.setText("");
        FieldPublisher.setText("");
        FieldYear.setText("");
        
        LabelID.setText("ID Buku");
        
        AvailableList.removeAllItems();
        for (String item : AvailableBox) {
            AvailableList.addItem(item);
        }
        
        BookDAO bookDAO = new BookDaoSQLite();
        List<Book> Booklist = bookDAO.listBooks();
        showTable = new ShowTable(MainTable,Booklist,BookHeader,false);
        
        initializeForm();
        LableAlert.setText("");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Kumpulan Method u/ Mengatur status Editable"> 
    private void initializeForm() {
        setEditable(false);
        setFieldDefaultText(FieldTitle, "Pilih Data Pada Table");
        setFieldDefaultText(FieldAuthor, "Pilih Data Pada Table");
        setFieldDefaultText(FieldPublisher, "Pilih Data Pada Table");
        setFieldDefaultText(FieldYear, "Pilih Data Pada Table");
    }
    
    private void setEditable(boolean status) {
        setFieldEditable(FieldTitle, status);
        setFieldEditable(FieldAuthor, status);
        setFieldEditable(FieldPublisher, status);
        setFieldEditable(FieldYear, status);
        Edit.setEnabled(status);
        Delete.setEnabled(status);
        AvailableList.setEnabled(status);
    }
    
    private void setFieldDefaultText(JTextField field, String defaultText) {
        field.setText(defaultText);
        field.setEnabled(false);
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (!field.isEnabled() && defaultText.equals(field.getText())) {
                    field.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (!field.isEnabled() && field.getText().isEmpty()) {
                    field.setText(defaultText);
                }
            }
        });
    }
    
    private void setFieldEditable(JTextField field, boolean status) {
        field.setEnabled(status);
        if (status && "Pilih Data Pada Table".equals(field.getText())) {
            field.setText("");
        } else if (!status && field.getText().isEmpty()) {
            field.setText("Pilih Data Pada Table");
        }
    }
    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelSearch = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainTable = new javax.swing.JTable();
        FieldTitle = new javax.swing.JTextField();
        FieldAuthor = new javax.swing.JTextField();
        FieldPublisher = new javax.swing.JTextField();
        FieldYear = new javax.swing.JTextField();
        Edit = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LabelID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AvailableList = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        LableAlert = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(745, 445));
        setPreferredSize(new java.awt.Dimension(745, 445));

        LabelSearch.setText("Cari Data :");

        SearchButton.setText("Cari");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        MainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        MainTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        MainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MainTable);

        Edit.setText("Simpan");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Cancel.setText("Batal");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Judul       :");

        jLabel2.setText("Penulis    :");

        jLabel3.setText("Penerbit  :");

        jLabel4.setText("Tahun     :");

        Delete.setText("Hapus");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("ID           :");

        LabelID.setText("ID Buku");

        jLabel6.setText("Ketersediaan    :");

        AvailableList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Adobe Arabic", 0, 24)); // NOI18N
        jLabel7.setText("Atur Buku");

        LableAlert.setForeground(new java.awt.Color(255, 51, 51));
        LableAlert.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LabelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(471, 471, 471)
                            .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(FieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FieldPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SearchField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LabelID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AvailableList, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LableAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LabelID)
                    .addComponent(jLabel6)
                    .addComponent(AvailableList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LableAlert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelSearch)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Edit)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Kumpulan Action Performed"> 
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String Keyword = SearchField.getText();
        if(Keyword.isEmpty()){
            return;
        }

        try {

            OpsiTable opsiTable = new OpsiTable();
            List<Object> Selectedlist = opsiTable.getDataTable("Buku",Keyword,2);
            showTable = new ShowTable(MainTable,Selectedlist,BookHeader,false);

        } catch (SQLException ex) {
            Logger.getLogger(Default.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SearchButtonActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        
        String title = FieldTitle.getText();
        String author = FieldAuthor.getText();
        String publisher = FieldPublisher.getText();
        String year = FieldYear.getText();
        String availableList = (String) AvailableList.getSelectedItem();
        
        if (title.isEmpty() || author.isEmpty() || publisher.isEmpty() || year.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Area Teks tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int yearInt;
        try {
            yearInt = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tahun harus berupa angka : ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Boolean availBool;
        availBool = "Tersedia".equals(availableList);

        book = new Book(book.getId(),title, author, publisher, yearInt, availBool);

        try {
            BookDAO bookDAO = new BookDaoSQLite();
            bookDAO.updateBook(book);
            
            JOptionPane.showMessageDialog(this, "Data Buku Berhasil diubah!", "Success", JOptionPane.INFORMATION_MESSAGE);

            refresh();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Buku Gagal diubah : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_EditActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        try {
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(SBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data buku ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (response == JOptionPane.YES_OPTION) { 
            try {
                BookDAO bookDAO = new BookDaoSQLite();
                bookDAO.deleteBook(book.getId());

                JOptionPane.showMessageDialog(this, "Data Buku Berhasil dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);

                refresh();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data Buku Gagal dihapus : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void MainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainTableMouseClicked
        int selectedRow = MainTable.getSelectedRow();
        
        if (selectedRow != -1) {
            String ID = MainTable.getValueAt(selectedRow, 0).toString();
            String YEAR = MainTable.getValueAt(selectedRow, 4).toString();
            String title = MainTable.getValueAt(selectedRow, 1).toString();
            String author = MainTable.getValueAt(selectedRow, 2).toString();
            String publisher = MainTable.getValueAt(selectedRow, 3).toString();
            Boolean isAvailable = Boolean.valueOf(MainTable.getValueAt(selectedRow, 5).toString());
            
            int id = Integer.parseInt(ID);
            int year = Integer.parseInt(YEAR);
            String AVAIL = isAvailable ? "Tersedia" : "Tidak Tersedia";
            
            book = new Book(id,title,author,publisher,year,isAvailable);
          
            FieldTitle.setText(title);
            FieldAuthor.setText(author);
            FieldPublisher.setText(publisher);
            FieldYear.setText(YEAR);
            
            AvailableList.setSelectedItem(AVAIL);
            
            LabelID.setText(ID);
            
            setEditable(true);
            
//----------Bagian chechk apakah buku sedang di pinjam oleh seseorang
            if(!isAvailable){
                TransactionDAO transactionDAO = new TransactionDaoSQLite();
                try {
                    Transactionlist = transactionDAO.listTransactions();
                } catch (SQLException ex) {
                    Logger.getLogger(SBook.class.getName()).log(Level.SEVERE, null, ex);
                }

                for(Transaction data : Transactionlist){
                    if(data.getBookId() == id && data.getReturnDate() == null){
                        AvailableList.setEnabled(false);
                        LableAlert.setText("Buku sedang dipinjamkan");
                    }
                }
            }else
                LableAlert.setText("");
//-------------------------------------------------------------------            
        }
    }//GEN-LAST:event_MainTableMouseClicked
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Kumpulan Deklarasi Variabel"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvailableList;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField FieldAuthor;
    private javax.swing.JTextField FieldPublisher;
    private javax.swing.JTextField FieldTitle;
    private javax.swing.JTextField FieldYear;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelSearch;
    private javax.swing.JLabel LableAlert;
    private javax.swing.JTable MainTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
