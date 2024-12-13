package GUI;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindows extends javax.swing.JFrame {

    Default defaultPanel;
    TBook bookPanel;
    TMember memberPanel;
    TTransaction transactionPanel;
    
    SBook bookEditPanel;
    SMember memberEditPanel;
    STransaction transactionEditPanel;
    
    CardLayout layout;
    
    public MainWindows() throws SQLException {
        
        initComponents();
        layout = (CardLayout) MainPanelCrd.getLayout();
        
        defaultPanel = new Default(layout,MainPanelCrd);
        bookPanel = new TBook(layout, MainPanelCrd);
        memberPanel = new TMember(layout, MainPanelCrd);
        transactionPanel  = new TTransaction(layout, MainPanelCrd);

        //--- Panel Edit ----
        bookEditPanel = new SBook(layout, MainPanelCrd);
        memberEditPanel = new SMember(layout, MainPanelCrd);
        transactionEditPanel = new STransaction(layout, MainPanelCrd);
        //-------------------
        MainPanelCrd.add("Default", defaultPanel);
        MainPanelCrd.add("BookPanel", bookPanel);
        MainPanelCrd.add("MemberPanel", memberPanel);
        MainPanelCrd.add("TransactionPanel", transactionPanel);
        
        MainPanelCrd.add("BookEdit", bookEditPanel);
        MainPanelCrd.add("MemberEdit", memberEditPanel);
        MainPanelCrd.add("TransactionEdit", transactionEditPanel);
        
        layout.show(MainPanelCrd, "Default");
    }
    
    private void refreshPanels() throws SQLException {
        defaultPanel.refresh();
        bookPanel.refresh();
        memberPanel.refresh();
        transactionPanel.refresh();
        //------------------------
        bookEditPanel.refresh();
        memberEditPanel.refresh();
        transactionEditPanel.refresh();
    }

    // <editor-fold defaultstate="collapsed" desc="Template Comment Code"> 
    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackMainPanel = new javax.swing.JPanel();
        MainPanelCrd = new javax.swing.JPanel();
        TB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SB = new javax.swing.JButton();
        TA = new javax.swing.JButton();
        TT = new javax.swing.JButton();
        SA = new javax.swing.JButton();
        ST = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KitaBaca");
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setPreferredSize(new java.awt.Dimension(1000, 500));
        setResizable(false);

        BackMainPanel.setBackground(new java.awt.Color(178, 178, 178));
        BackMainPanel.setMinimumSize(new java.awt.Dimension(760, 460));
        BackMainPanel.setPreferredSize(new java.awt.Dimension(760, 460));

        MainPanelCrd.setMinimumSize(new java.awt.Dimension(0, 0));
        MainPanelCrd.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout BackMainPanelLayout = new javax.swing.GroupLayout(BackMainPanel);
        BackMainPanel.setLayout(BackMainPanelLayout);
        BackMainPanelLayout.setHorizontalGroup(
            BackMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanelCrd, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        BackMainPanelLayout.setVerticalGroup(
            BackMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanelCrd, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        TB.setText("Tambah");
        TB.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Adobe Arabic", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KitaBaca");
        jLabel1.setToolTipText("");

        SB.setText("Sunting");
        SB.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SBActionPerformed(evt);
            }
        });

        TA.setText("Tambah");
        TA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAActionPerformed(evt);
            }
        });

        TT.setText("Tambah");
        TT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTActionPerformed(evt);
            }
        });

        SA.setText("Sunting");
        SA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAActionPerformed(evt);
            }
        });

        ST.setText("Sunting");
        ST.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STActionPerformed(evt);
            }
        });

        Back.setText("Kembali");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Adobe Arabic", 0, 18)); // NOI18N
        jLabel2.setText("Buku :");

        jLabel3.setFont(new java.awt.Font("Adobe Arabic", 0, 18)); // NOI18N
        jLabel3.setText("Anggota :");

        jLabel4.setFont(new java.awt.Font("Adobe Arabic", 0, 18)); // NOI18N
        jLabel4.setText("Transaksi :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(SB, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(TT, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(TA, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(SA, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(ST, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(TB, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(TA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SA)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Button Action Performed"> 
    private void TBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBActionPerformed
        try {
            refreshPanels();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        layout.show(MainPanelCrd, "BookPanel");
    }//GEN-LAST:event_TBActionPerformed

    private void SBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SBActionPerformed
        try {
            refreshPanels();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        layout.show(MainPanelCrd, "BookEdit");
    }//GEN-LAST:event_SBActionPerformed

    private void TAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAActionPerformed
        try {
            refreshPanels();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        layout.show(MainPanelCrd, "MemberPanel");
    }//GEN-LAST:event_TAActionPerformed

    private void TTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTActionPerformed
        try {
            refreshPanels();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        layout.show(MainPanelCrd, "TransactionPanel");
    }//GEN-LAST:event_TTActionPerformed

    private void SAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAActionPerformed
        try {
            refreshPanels();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        layout.show(MainPanelCrd, "MemberEdit");
    }//GEN-LAST:event_SAActionPerformed

    private void STActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STActionPerformed
        try {
            refreshPanels();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        layout.show(MainPanelCrd, "TransactionEdit");
    }//GEN-LAST:event_STActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        try {
            refreshPanels();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        layout.show(MainPanelCrd, "Default");
    }//GEN-LAST:event_BackActionPerformed
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Template Comment Code"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JPanel BackMainPanel;
    private javax.swing.JPanel MainPanelCrd;
    private javax.swing.JButton SA;
    private javax.swing.JButton SB;
    private javax.swing.JButton ST;
    private javax.swing.JButton TA;
    private javax.swing.JButton TB;
    private javax.swing.JButton TT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
