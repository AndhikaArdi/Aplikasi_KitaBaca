package GUI;

import entities.Book;
import helpers.OpsiTable;
import helpers.ShowTable;

import java.awt.CardLayout;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import models.BookDAO;
import models.BookDaoSQLite;

public class Default extends javax.swing.JPanel {

    CardLayout mainLayout;
    JPanel mainPanel;
    
    private ShowTable showTable;
    private String[] SearchBox = {"Buku","Anggota","Transaksi"};
    private String[] BookHeader = {"ID","Judul","Penulis","Penerbit","Tahun Terbit","Ketersediaan"};
    private String[] MemberHeader = {"ID","Nama","alamat","Nomor Telepon", "Email"};
    private String[] TransactionHeader = {"ID","IdBk","Judul","IdAg","Nama","Tgl Pinjam","Tgl Batas","Tgl Kembali","Denda"};
    
    public Default(CardLayout mainLayout, JPanel mainPanel) throws SQLException {
        this.mainLayout = mainLayout;
        this.mainPanel = mainPanel;
        
        initComponents();
        
        SearchList.removeAllItems();
        for (String item : SearchBox) {
            SearchList.addItem(item);
        }
        
        BookDAO bookDAO = new BookDaoSQLite();
        List<Book> Booklist = bookDAO.listBooks();
        showTable = new ShowTable(MainTable,Booklist,BookHeader,false);
    
    }
    
    public void refresh() throws SQLException {
        SearchField.setText("");
        SearchList.setSelectedIndex(0);
        
        BookDAO bookDAO = new BookDaoSQLite();
        List<Book> Booklist = bookDAO.listBooks();
        showTable = new ShowTable(MainTable,Booklist,BookHeader,false);
    }
        
    public String[] Header(String criteria) {
        if (null == criteria) {
            return BookHeader;
        } else return switch (criteria) {
            case "Buku" -> BookHeader;
            case "Anggota" -> MemberHeader;
            case "Transaksi" -> TransactionHeader;
            default -> BookHeader;
        };
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        MainTable = new javax.swing.JTable();
        SearchField = new javax.swing.JTextField();
        LabelSearch = new javax.swing.JLabel();
        SearchList = new javax.swing.JComboBox<>();
        SearchButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(745, 445));
        setPreferredSize(new java.awt.Dimension(745, 445));

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
        jScrollPane1.setViewportView(MainTable);

        LabelSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelSearch.setText("Cari Data :");

        SearchList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SearchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchListActionPerformed(evt);
            }
        });

        SearchButton.setText("Cari");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchList, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(SearchButton)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelSearch)
                    .addComponent(SearchList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String searchList = (String) SearchList.getSelectedItem();
        String Keyword = SearchField.getText();
        if(Keyword.isEmpty()){
            return;
        }
        
        try {
            String[] header = Header(searchList);
            
            OpsiTable opsiTable = new OpsiTable();
            List<Object> Selectedlist = opsiTable.getDataTable(searchList,Keyword,2);
            showTable = new ShowTable(MainTable,Selectedlist,header,false);

        } catch (SQLException ex) {
            Logger.getLogger(Default.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void SearchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchListActionPerformed
        
        String searchList = (String) SearchList.getSelectedItem();
        
        if (searchList != null) {
            try {
                String[] header = Header(searchList);

                OpsiTable opsiTable = new OpsiTable();
                List<Object> Selectedlist = opsiTable.getDataTable(searchList,"",1);
                showTable = new ShowTable(MainTable,Selectedlist,header,false);

            } catch (SQLException ex) {
                Logger.getLogger(Default.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        SearchField.setText("");
    }//GEN-LAST:event_SearchListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSearch;
    private javax.swing.JTable MainTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JComboBox<String> SearchList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
