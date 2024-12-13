package GUI;

import entities.Book;
import entities.Member;
import entities.Transaction;
import helpers.OpsiTable;
import helpers.ShowTable;

import java.awt.CardLayout;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import models.BookDAO;
import models.BookDaoSQLite;
import models.MemberDAO;
import models.MemberDaoSQLite;
import models.TransactionDAO;
import models.TransactionDaoSQLite;

public class STransaction extends javax.swing.JPanel {

    CardLayout mainLayout;
    JPanel mainPanel;
    
    private Transaction transaction;
    private Book book;
    private Member member;
    
    private ShowTable showTable;
    private String[] TransactionHeader = {"ID","IdBk","Judul","IdAg","Nama","Tgl Pinjam","Tgl Batas","Tgl Kembali","Denda"};
    
    public STransaction(CardLayout mainLayout, JPanel mainPanel) throws SQLException {
        this.mainLayout = mainLayout;
        this.mainPanel = mainPanel;
        
        initComponents();
        
        TransactionDAO transactionDAO = new TransactionDaoSQLite();
        List<Transaction> Transactionlist = transactionDAO.listTransactions();
        showTable = new ShowTable(MainTable,Transactionlist,TransactionHeader,false);
    
        initializeForm();
    }
    
    public void refresh() throws SQLException {
        SearchField.setText("");
        Field1.setText("");
        Field2.setText("");
        Field3.setText("");
        Field4.setText("");
        Field5.setText("");
        Field6.setText("");
        
        LabelName.setText("Nama Anggota");
        LabelTitle.setText("Judul Buku");
        LabelID.setText("Id Transaksi");
        
        TransactionDAO transactionDAO = new TransactionDaoSQLite();
        List<Transaction> Transactionlist = transactionDAO.listTransactions();
        showTable = new ShowTable(MainTable,Transactionlist,TransactionHeader,false);
        
        initializeForm();
    }
    
    private String getValueAtAsString(JTable table, int row, int column) {
        Object value = table.getValueAt(row, column);
        return (value != null) ? value.toString() : "";
    }
        
    // <editor-fold defaultstate="collapsed" desc="Kumpulan Method u/ Mengatur status Editable"> 
    private void initializeForm() {
        setEditable(false);
        setFieldDefaultText(Field1, "Pilih Data Pada Table");
        setFieldDefaultText(Field2, "Pilih Data Pada Table");
        setFieldDefaultText(Field3, "Pilih Data Pada Table");
        setFieldDefaultText(Field4, "Pilih Data Pada Table");
        setFieldDefaultText(Field5, "Pilih Data Pada Table");
        setFieldDefaultText(Field6, "Pilih Data Pada Table");
    }
    
    private void setEditable(boolean status) {
        setFieldEditable(Field1, status);
        setFieldEditable(Field2, status);
        setFieldEditable(Field3, status);
        setFieldEditable(Field4, status);
        setFieldEditable(Field5, status);
        setFieldEditable(Field6, status);
        Edit.setEnabled(status);
        Delete.setEnabled(status);
        IDtoMember.setEnabled(status);
        IDtoBook.setEnabled(status);
        CalculateFineBtn.setEnabled(status);
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
        Field1 = new javax.swing.JTextField();
        Field2 = new javax.swing.JTextField();
        Field3 = new javax.swing.JTextField();
        Field4 = new javax.swing.JTextField();
        Edit = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        LabelTitle = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LabelName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Field5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Field6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        LabelID = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CalculateFineBtn = new javax.swing.JButton();
        IDtoBook = new javax.swing.JButton();
        IDtoMember = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(745, 445));
        setPreferredSize(new java.awt.Dimension(745, 445));

        LabelSearch.setText("Anggota :");

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

        jLabel1.setText("ID Anggota       :");

        jLabel2.setText("ID Buku              :");

        jLabel3.setText("Tgl Peminjaman :");

        jLabel4.setText("Jatuh Tempo      :");

        Delete.setText("Hapus");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        LabelTitle.setText("Judul Buku");

        jLabel7.setText("Nama    :");

        jLabel8.setText("Judul     :");

        LabelName.setText("Nama Anggota");

        jLabel9.setText("Pengembalian    :");

        jLabel10.setText("Denda   :");

        jLabel11.setText("ID          :");

        LabelID.setText("Id Transaksi");

        jLabel12.setFont(new java.awt.Font("Adobe Arabic", 0, 24)); // NOI18N
        jLabel12.setText("Atur Transaksi");

        CalculateFineBtn.setText("Kalkulasi");
        CalculateFineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateFineBtnActionPerformed(evt);
            }
        });

        IDtoBook.setText(">");
        IDtoBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtoBookActionPerformed(evt);
            }
        });

        IDtoMember.setText(">");
        IDtoMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtoMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Field4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .addComponent(Field3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Field2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Field1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Field5)))
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDtoMember)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelTitle))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelID))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(201, 201, 201)
                                .addComponent(IDtoBook))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Field6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(CalculateFineBtn)))
                        .addGap(29, 29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(LabelName)
                    .addComponent(IDtoMember, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(LabelTitle)
                    .addComponent(IDtoBook, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(LabelID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(Field6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalculateFineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Field5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelSearch))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Edit)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String Keyword = SearchField.getText();
        if(Keyword.isEmpty()){
            return;
        }

        try {

            OpsiTable opsiTable = new OpsiTable();
            List<Object> Selectedlist = opsiTable.getDataTable("Transaksi",Keyword,2);
            showTable = new ShowTable(MainTable,Selectedlist,TransactionHeader,false);

        } catch (SQLException ex) {
            Logger.getLogger(Default.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SearchButtonActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        
        String ID_Member  = Field1.getText();
        String ID_Book    = Field2.getText();
        String BORROWDate = Field3.getText();
        String DUEDate    = Field4.getText();
        String RETURNDate = Field5.getText();
        String Fine       = Field6.getText();
        
        if (ID_Member.isEmpty() || ID_Book.isEmpty() || BORROWDate.isEmpty() || DUEDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Area Teks tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        java.sql.Date returndate = null;
        BigDecimal fine = null;

        if (!RETURNDate.isEmpty() && Fine.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field Denda harus di isi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }if(!RETURNDate.isEmpty() && !Fine.isEmpty()) {
            fine = new BigDecimal(Fine);
            returndate = java.sql.Date.valueOf(RETURNDate);
        }
        

        int idmember, idbook;
        java.sql.Date borrowdate, duedate;
        try {
            idmember    = Integer.parseInt(ID_Member);
            idbook      = Integer.parseInt(ID_Book);
            borrowdate  = java.sql.Date.valueOf(BORROWDate);
            duedate     = java.sql.Date.valueOf(DUEDate);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        transaction = new Transaction(transaction.getId(),idbook,idmember,borrowdate,duedate,returndate,fine);

        try {
            TransactionDAO transactionDAO = new TransactionDaoSQLite();
            transactionDAO.updateTransaction(transaction);

            JOptionPane.showMessageDialog(this, "Transaksi berhasil diubah!", "Success", JOptionPane.INFORMATION_MESSAGE);

            refresh();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Transaksi gagal diubah : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_EditActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        try {
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(STransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data buku ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (response == JOptionPane.YES_OPTION) { 
            try {
                TransactionDAO transactionDAO = new TransactionDaoSQLite();
                transactionDAO.deleteTransaction(transaction.getId());

                JOptionPane.showMessageDialog(this, "Data Transaksi Berhasil dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);

                refresh();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data Transaksi Gagal dihapus : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void MainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainTableMouseClicked
        int selectedRow = MainTable.getSelectedRow();
        
        if (selectedRow != -1) {
            try {
                String ID         = getValueAtAsString(MainTable, selectedRow, 0);
                String ID_Book    = getValueAtAsString(MainTable, selectedRow, 1);
                String ID_Member  = getValueAtAsString(MainTable, selectedRow, 3);
                String BORROWDate = getValueAtAsString(MainTable, selectedRow, 5);
                String DUEDate    = getValueAtAsString(MainTable, selectedRow, 6);
                String RETURNDate = getValueAtAsString(MainTable, selectedRow, 7);
                String Fine       = getValueAtAsString(MainTable, selectedRow, 8);

                int idmember, idbook;
                int id = Integer.parseInt(ID);
                BigDecimal fine = null;
                if (Fine != null && !Fine.isEmpty()) {
                    fine = new BigDecimal(Fine);
                }
                java.sql.Date borrowdate, duedate, returndate = null;
                try {
                    idmember    = Integer.parseInt(ID_Member);
                    idbook      = Integer.parseInt(ID_Book);
                    borrowdate  = java.sql.Date.valueOf(BORROWDate);
                    duedate     = java.sql.Date.valueOf(DUEDate);
                    if (RETURNDate != null && !RETURNDate.isEmpty()) {
                        returndate = java.sql.Date.valueOf(RETURNDate);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, "Format Tanggal tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                transaction = new Transaction(id, idbook, idmember, borrowdate, duedate, returndate, fine);

                BookDAO bookDAO = new BookDaoSQLite();
                MemberDAO memberDAO = new MemberDaoSQLite();

                book = bookDAO.getBookById(idbook);
                member = memberDAO.getMemberById(idmember);

                Field1.setText(ID_Member);
                Field2.setText(ID_Book);
                Field3.setText(BORROWDate);
                Field4.setText(DUEDate);
                Field5.setText(RETURNDate);
                Field6.setText(Fine);

                LabelID.setText(ID);

                LabelName.setText(member.getName());
                LabelTitle.setText(book.getTitle());
            } catch (SQLException ex) {
                Logger.getLogger(STransaction.class.getName()).log(Level.SEVERE, null, ex);
            }
            setEditable(true);
        }
    }//GEN-LAST:event_MainTableMouseClicked

    private void CalculateFineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateFineBtnActionPerformed
        String RETURNDate = Field5.getText();
        String DUEDate = Field4.getText();

        if (RETURNDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field Tanggal Kembali harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            java.sql.Date returnDate = java.sql.Date.valueOf(RETURNDate);
            java.sql.Date dueDate = java.sql.Date.valueOf(DUEDate);

            // menghitung jumlah hari terlewat dengan menggunakan rumus : 
            //hitung dulu selisih tanggal (dlm bentuk mili detik) kemudian bagi dengan :
            long missedday = (returnDate.getTime() - dueDate.getTime()) / (24 * 60 * 60 * 1000);
            
            BigDecimal fine;
            if(missedday > 0){
                fine = new BigDecimal(missedday * 5000);
            }else
                fine = new BigDecimal(0);
            
            Field6.setText(fine.toString());
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Format Tanggal tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CalculateFineBtnActionPerformed

    private void IDtoMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtoMemberActionPerformed
        String ID_Member  = Field1.getText();
        int idmember;
        
        if (ID_Member.isEmpty()) {
            LabelName.setText("Nama Anggota");
        }else{
            try {
                idmember = Integer.parseInt(ID_Member);
                MemberDAO memberDAO = new MemberDaoSQLite();
                member = memberDAO.getMemberById(idmember);
                if(member != null){
                    LabelName.setText(member.getName());
                }else{
                    JOptionPane.showMessageDialog(this, "ID Tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                    LabelName.setText("Nama Anggota");
                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID harus berupa Angka!", "Error", JOptionPane.ERROR_MESSAGE);
                LabelName.setText("Nama Anggota");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Koneksi Putus, ID Tidak bisa dikoneversi", "Error", JOptionPane.ERROR_MESSAGE);
                LabelName.setText("Nama Anggota");
            }
        }
    }//GEN-LAST:event_IDtoMemberActionPerformed

    private void IDtoBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtoBookActionPerformed
        String ID_Book  = Field2.getText();
        int idbook;
        
        if (ID_Book.isEmpty()) {
            LabelTitle.setText("Judul Buku");
        }else{
            try {
                idbook = Integer.parseInt(ID_Book);
                BookDAO bookDAO = new BookDaoSQLite();
                book = bookDAO.getBookById(idbook);
                if(book != null){
                    LabelTitle.setText(book.getTitle());
                }else{
                    JOptionPane.showMessageDialog(this, "ID Tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                    LabelTitle.setText("Judul Buku");
                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID harus berupa Angka!", "Error", JOptionPane.ERROR_MESSAGE);
                LabelTitle.setText("Judul Buku");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Koneksi Putus, ID Tidak bisa dikoneversi", "Error", JOptionPane.ERROR_MESSAGE);
                LabelTitle.setText("Judul Buku");
            }
        }
    }//GEN-LAST:event_IDtoBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalculateFineBtn;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField Field1;
    private javax.swing.JTextField Field2;
    private javax.swing.JTextField Field3;
    private javax.swing.JTextField Field4;
    private javax.swing.JTextField Field5;
    private javax.swing.JTextField Field6;
    private javax.swing.JButton IDtoBook;
    private javax.swing.JButton IDtoMember;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelSearch;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JTable MainTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
