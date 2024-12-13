package GUI;

import entities.Book;
import entities.Member;
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

import models.BookDAO;
import models.BookDaoSQLite;
import models.MemberDAO;
import models.MemberDaoSQLite;
import models.TransactionDAO;
import models.TransactionDaoSQLite;

public class TTransaction extends javax.swing.JPanel {

    CardLayout mainLayout;
    JPanel mainPanel;
    
    private Transaction transaction;
    private Book book;
    private Member member;
    
    private ShowTable showTable;
    private String[] BookHeader = {"ID","Judul","Ketersediaan"};
    private String[] MemberHeader = {"ID","Nama","Email"};
    
    private String[] TransactionHeader = {"ID","ID Buku","ID Anggota","Tgl Peminjaman","Jatuh Tempo","Tgl Pengembalian","Denda"};
    
    
    public TTransaction(CardLayout mainLayout, JPanel mainPanel) throws SQLException {
        this.mainLayout = mainLayout;
        this.mainPanel = mainPanel;
        
        initComponents();

//----- KODE INI MASIH HARUS I UTAK ATIK
        BookDAO bookDAO = new BookDaoSQLite();
        List<Book> Booklist = bookDAO.listBooks();
        showTable = new ShowTable(BookTable,Booklist,BookHeader,false);
    
        MemberDAO memberDAO = new MemberDaoSQLite();
        List<Member> Memberlist = memberDAO.listMembers();
        showTable = new ShowTable(MemberTable,Memberlist,MemberHeader,false);
    
    }
    
    public void refresh() throws SQLException {
        SearchFMember.setText("");
        SearchFBook.setText("");
        Field1.setText("");
        Field2.setText("");
        Field3.setText("");
        Field4.setText("");
        
        LabelName.setText("Nama Anggota");
        LabelTitle.setText("Judul Buku");
        
//----- KODE INI MASIH HARUS I UTAK ATIK
        BookDAO bookDAO = new BookDaoSQLite();
        List<Book> Booklist = bookDAO.listBooks();
        showTable = new ShowTable(BookTable,Booklist,BookHeader,false);
    
        MemberDAO memberDAO = new MemberDaoSQLite();
        List<Member> Memberlist = memberDAO.listMembers();
        showTable = new ShowTable(MemberTable,Memberlist,MemberHeader,false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelSearch = new javax.swing.JLabel();
        SearchFMember = new javax.swing.JTextField();
        SearchBMember = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MemberTable = new javax.swing.JTable();
        Field1 = new javax.swing.JTextField();
        Field2 = new javax.swing.JTextField();
        Field3 = new javax.swing.JTextField();
        Field4 = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookTable = new javax.swing.JTable();
        SearchBBook = new javax.swing.JButton();
        LabelSearch1 = new javax.swing.JLabel();
        SearchFBook = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        LabelTitle = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LabelName = new javax.swing.JLabel();
        IDtoBookBtn = new javax.swing.JButton();
        IDtoMemberBtn = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(745, 445));
        setPreferredSize(new java.awt.Dimension(745, 445));

        LabelSearch.setText("Anggota :");

        SearchBMember.setText("Cari");
        SearchBMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBMemberActionPerformed(evt);
            }
        });

        MemberTable.setModel(new javax.swing.table.DefaultTableModel(
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
        MemberTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        MemberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MemberTable);

        Add.setText("Tambah");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
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

        BookTable.setModel(new javax.swing.table.DefaultTableModel(
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
        BookTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BookTable);

        SearchBBook.setText("Cari");
        SearchBBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBBookActionPerformed(evt);
            }
        });

        LabelSearch1.setText("Buku :");

        jLabel9.setFont(new java.awt.Font("Adobe Arabic", 0, 24)); // NOI18N
        jLabel9.setText("Tambah Transaksi");

        LabelTitle.setText("Judul Buku");

        jLabel7.setText("Nama    :");

        jLabel8.setText("Judul     :");

        LabelName.setText("Nama Anggota");

        IDtoBookBtn.setText(">");
        IDtoBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtoBookBtnActionPerformed(evt);
            }
        });

        IDtoMemberBtn.setText(">");
        IDtoMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtoMemberBtnActionPerformed(evt);
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
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(LabelSearch)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SearchFMember)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SearchBMember, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(LabelSearch1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(SearchFBook)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(SearchBBook, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Field4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .addComponent(Field3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Field2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Field1, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(IDtoMemberBtn)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(IDtoBookBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelTitle))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(IDtoBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IDtoMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchFMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchBMember, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelSearch1)
                        .addComponent(SearchFBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SearchBBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBMemberActionPerformed
        String Keyword = SearchFMember.getText();
        if(Keyword.isEmpty()){
            return;
        }

        try {

            OpsiTable opsiTable = new OpsiTable();
            List<Object> Selectedlist = opsiTable.getDataTable("Anggota",Keyword,2);
            showTable = new ShowTable(MemberTable,Selectedlist,MemberHeader,false);
            
        } catch (SQLException ex) {
            Logger.getLogger(Default.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SearchBMemberActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        
        String ID_Member  = Field1.getText();
        String ID_Book    = Field2.getText();
        String BORROWDate = Field3.getText();
        String DUEDate    = Field4.getText();
        
        if (ID_Member.isEmpty() || ID_Book.isEmpty() || BORROWDate.isEmpty() || DUEDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Area Teks tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idmember, idbook;
        java.sql.Date borrowdate, duedate;
        try {
            idmember    = Integer.parseInt(ID_Member);
            idbook      = Integer.parseInt(ID_Book);
            try {
                MemberDAO memberDAO = new MemberDaoSQLite();
                member  = memberDAO.getMemberById(idmember);
                BookDAO bookDAO = new BookDaoSQLite();
                book    = bookDAO.getBookById(idbook);
                
                if(member == null || book == null){ //check apakah Data buku / anggota terdapat didatabase
                    JOptionPane.showMessageDialog(this, "ID Tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }else if(book.getIsAvailable() == false){
                    JOptionPane.showMessageDialog(this, "<html> Maaf, Buku <b>'"+ book.getTitle() +"'</b> sedang Tidak Tersedia </html>", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Koneksi Putus, ID Tidak bisa dikoneversi", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            borrowdate  = java.sql.Date.valueOf(BORROWDate);
            duedate     = java.sql.Date.valueOf(DUEDate);
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa Angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Format Tanggal tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        transaction = new Transaction(idbook,idmember,borrowdate,duedate);

        try {
            TransactionDAO transactionDAO = new TransactionDaoSQLite();
            transactionDAO.addTransaction(transaction);

            JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);

            refresh();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Transaksi gagal ditambahkan : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        try {
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(TTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void MemberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberTableMouseClicked
        int selectedRow = MemberTable.getSelectedRow();
        
        if (selectedRow != -1) {
            String ID = MemberTable.getValueAt(selectedRow, 0).toString();
            String nama = MemberTable.getValueAt(selectedRow, 1).toString();
            
            //simpan untuk keperluan lain :
//            int id = Integer.parseInt(ID);
//            MemberDAO memberDAO = new MemberDaoSQLite();
//            member = memberDAO.getMemberById(id);
          
            Field1.setText(ID);
            LabelName.setText(nama);
        }
    }//GEN-LAST:event_MemberTableMouseClicked

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
        int selectedRow = BookTable.getSelectedRow();
        
        if (selectedRow != -1) {
            String ID = BookTable.getValueAt(selectedRow, 0).toString();
            String title = BookTable.getValueAt(selectedRow, 1).toString();

            //simpan untuk keperluan lain :
//            int id = Integer.parseInt(ID);
//            BookDAO bookDAO = new BookDaoSQLite();
//            book = bookDAO.getBookById(id);

            Field2.setText(ID);
            LabelTitle.setText(title);
        }
    }//GEN-LAST:event_BookTableMouseClicked

    private void SearchBBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBBookActionPerformed
        String Keyword = SearchFBook.getText();
        if(Keyword.isEmpty()){
            return;
        }

        try {

            OpsiTable opsiTable = new OpsiTable();
            List<Object> Selectedlist = opsiTable.getDataTable("Buku",Keyword,2);
            showTable = new ShowTable(BookTable,Selectedlist,BookHeader,false);

        } catch (SQLException ex) {
            Logger.getLogger(Default.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchBBookActionPerformed

    private void IDtoMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtoMemberBtnActionPerformed
        
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
    }//GEN-LAST:event_IDtoMemberBtnActionPerformed

    private void IDtoBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtoBookBtnActionPerformed
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
    }//GEN-LAST:event_IDtoBookBtnActionPerformed
        

    // <editor-fold defaultstate="collapsed" desc="Template Comment Code"> 
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Variable Declaration"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTable BookTable;
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField Field1;
    private javax.swing.JTextField Field2;
    private javax.swing.JTextField Field3;
    private javax.swing.JTextField Field4;
    private javax.swing.JButton IDtoBookBtn;
    private javax.swing.JButton IDtoMemberBtn;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelSearch;
    private javax.swing.JLabel LabelSearch1;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JTable MemberTable;
    private javax.swing.JButton SearchBBook;
    private javax.swing.JButton SearchBMember;
    private javax.swing.JTextField SearchFBook;
    private javax.swing.JTextField SearchFMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
