/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponei.views;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ponei.dao.collectionDao;
import ponei.model.Collection;

/**
 *
 * @author Computador
 */
public class frmCollection extends javax.swing.JFrame {

    /**
     * Creates new form frmColecao
     */
    enum PHASE {
        NONE,
        NEW,
        VIEW,
        EDIT
    }

    PHASE registerPhase = PHASE.NONE;

    public frmCollection() {
        initComponents();
        this.getContentPane().setBackground(new Color(20, 20, 20));
        populateCollectionTable();
    }

    private boolean checkParameters() {
        //algum campo de texto (sem ser id)ta vazio
        if (txtName.getText().isEmpty() || txtBrand.getText().isEmpty() || txtManufacturer.getText().isEmpty() || txtYear.getText().isEmpty() || txtVolume.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algum campo está vazio.");
            return false;
        }
        //regex pra ver se os campos de ano e volume sao numeros
        if (!txtYear.getText().matches("[0-9]+") || !txtVolume.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Ano/volume apenas aceitam numeros.");
            return false;
        }
        return true;
    }

    private void populateCollectionTable() {
        DefaultTableModel model = (DefaultTableModel) tableCollection.getModel();
        model.setNumRows(0);

        collectionDao dao = new collectionDao();

        for (Collection c : dao.list()) {
            model.addRow(new Object[]{
                c.getIdCollection(),
                c.getNameCollection(),
                c.getBrandCollection(),
                c.getManufacturerCollection(),
                c.getYearCollection(),
                c.getVolumeCollection()
            });

        }
    }

    private void populateCollectionTableCustom() {
        DefaultTableModel model = (DefaultTableModel) tableCollection.getModel();
        model.setNumRows(0);

        collectionDao dao = new collectionDao();

        for (Collection c : dao.searchForValue(String.valueOf(comboSearch.getSelectedItem()), txtSearch.getText())) {
            model.addRow(new Object[]{
                c.getIdCollection(),
                c.getNameCollection(),
                c.getBrandCollection(),
                c.getManufacturerCollection(),
                c.getYearCollection(),
                c.getVolumeCollection()
            });

        }
    }

    private void updateControls(PHASE phase) {
        switch (phase) {
            case NONE:
                //sem treco de texto
                txtName.setEditable(false);
                txtBrand.setEditable(false);
                txtManufacturer.setEditable(false);
                txtYear.setEditable(false);
                txtVolume.setEditable(false);
                //só novo user pode ser feito
                btNew.setEnabled(true);
                btSave.setEnabled(false);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(false);

                txtId.setText("");
                txtName.setText("");
                txtBrand.setText("");
                txtManufacturer.setText("");
                txtYear.setText("");
                txtVolume.setText("");

                break;

            case NEW:
                //pode colocar novo treco
                txtName.setEditable(true);
                txtBrand.setEditable(true);
                txtManufacturer.setEditable(true);
                txtYear.setEditable(true);
                txtVolume.setEditable(true);
                //cancelar ou criar novo
                btNew.setEnabled(false);
                btSave.setEnabled(true);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(true);
                break;

            case VIEW:
                //só vendo, veio da tabela
                //nao pode editar
                txtName.setEditable(false);
                txtBrand.setEditable(false);
                txtManufacturer.setEditable(false);
                txtYear.setEditable(false);
                txtVolume.setEditable(false);

                //deletar o usuario ou editar
                btNew.setEnabled(false);
                btSave.setEnabled(false);
                btEdit.setEnabled(true);
                btDelete.setEnabled(true);
                btCancel.setEnabled(true);
                break;

            case EDIT:
                //pode editar
                txtName.setEditable(true);
                txtBrand.setEditable(true);
                txtManufacturer.setEditable(true);
                txtYear.setEditable(true);
                txtVolume.setEditable(true);
                //salvar o user editado ou cancelar
                btNew.setEnabled(false);
                btSave.setEnabled(true);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(true);
                break;

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabcCollection = new javax.swing.JTabbedPane();
        tabCollectionReg = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        lbManufacturer = new javax.swing.JLabel();
        txtManufacturer = new javax.swing.JTextField();
        lbYear = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lbVolume = new javax.swing.JLabel();
        txtVolume = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        tabCollectionList = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        comboSearch = new javax.swing.JComboBox<>();
        btSearch = new javax.swing.JButton();
        btSearchReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCollection = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabCollectionReg.setBackground(new java.awt.Color(30, 30, 30));

        txtId.setEditable(false);

        lbId.setForeground(new java.awt.Color(153, 153, 153));
        lbId.setText("id");

        txtName.setEditable(false);

        lbName.setForeground(new java.awt.Color(153, 153, 153));
        lbName.setText("nome");

        lbBrand.setForeground(new java.awt.Color(153, 153, 153));
        lbBrand.setText("marca");

        txtBrand.setEditable(false);

        lbManufacturer.setForeground(new java.awt.Color(153, 153, 153));
        lbManufacturer.setText("fabricante");

        txtManufacturer.setEditable(false);

        lbYear.setForeground(new java.awt.Color(153, 153, 153));
        lbYear.setText("ano");

        txtYear.setEditable(false);

        lbVolume.setForeground(new java.awt.Color(153, 153, 153));
        lbVolume.setText("volume");

        txtVolume.setEditable(false);

        btSave.setText("salvar");
        btSave.setEnabled(false);
        btSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSaveMouseClicked(evt);
            }
        });

        btNew.setText("novo");
        btNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNewMouseClicked(evt);
            }
        });

        btCancel.setText("cancelar");
        btCancel.setEnabled(false);
        btCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelMouseClicked(evt);
            }
        });

        btDelete.setText("excluir");
        btDelete.setEnabled(false);
        btDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDeleteMouseClicked(evt);
            }
        });

        btEdit.setText("editar");
        btEdit.setEnabled(false);
        btEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tabCollectionRegLayout = new javax.swing.GroupLayout(tabCollectionReg);
        tabCollectionReg.setLayout(tabCollectionRegLayout);
        tabCollectionRegLayout.setHorizontalGroup(
            tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCollectionRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCollectionRegLayout.createSequentialGroup()
                        .addComponent(lbVolume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVolume))
                    .addGroup(tabCollectionRegLayout.createSequentialGroup()
                        .addComponent(lbYear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtYear))
                    .addGroup(tabCollectionRegLayout.createSequentialGroup()
                        .addComponent(lbManufacturer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtManufacturer, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                    .addGroup(tabCollectionRegLayout.createSequentialGroup()
                        .addComponent(lbBrand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrand))
                    .addGroup(tabCollectionRegLayout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabCollectionRegLayout.createSequentialGroup()
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId)))
                .addGap(20, 20, 20)
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btNew, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSave, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCancel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        tabCollectionRegLayout.setVerticalGroup(
            tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCollectionRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbId)
                    .addComponent(btNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName)
                    .addComponent(btSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBrand)
                    .addComponent(btEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbManufacturer)
                    .addComponent(btDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbYear)
                    .addComponent(btCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCollectionRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVolume))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabcCollection.addTab("cadastrar", tabCollectionReg);

        tabCollectionList.setBackground(new java.awt.Color(30, 30, 30));

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "name", "brand", "manufacturer", "year", "volume" }));

        btSearch.setText("procurar");
        btSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSearchMouseClicked(evt);
            }
        });

        btSearchReset.setText("reset");
        btSearchReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSearchResetMouseClicked(evt);
            }
        });

        tableCollection.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "marca", "fabricante", "ano", "volume"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCollection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCollectionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCollection);

        javax.swing.GroupLayout tabCollectionListLayout = new javax.swing.GroupLayout(tabCollectionList);
        tabCollectionList.setLayout(tabCollectionListLayout);
        tabCollectionListLayout.setHorizontalGroup(
            tabCollectionListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
            .addGroup(tabCollectionListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSearchReset)
                .addContainerGap())
        );
        tabCollectionListLayout.setVerticalGroup(
            tabCollectionListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabCollectionListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCollectionListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch)
                    .addComponent(btSearchReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );

        tabcCollection.addTab("listar", tabCollectionList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabcCollection, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabcCollection)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNewMouseClicked
        registerPhase = PHASE.NEW;
        updateControls(registerPhase);
    }//GEN-LAST:event_btNewMouseClicked

    private void btSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveMouseClicked
        if (checkParameters()) {
            Collection c = new Collection();
            collectionDao dao = new collectionDao();

            switch (registerPhase) {
                case NEW:
                    c.setNameCollection(txtName.getText());
                    c.setBrandCollection(txtBrand.getText());
                    c.setManufacturerCollection(txtManufacturer.getText());
                    c.setYearCollection(Integer.parseInt(txtYear.getText()));
                    c.setVolumeCollection(Integer.parseInt(txtVolume.getText()));

                    dao.create(c); //cria o treco
                    break;

                case EDIT:
                    c.setIdCollection(Integer.parseInt(txtId.getText()));
                    c.setNameCollection(txtName.getText());
                    c.setBrandCollection(txtBrand.getText());
                    c.setManufacturerCollection(txtManufacturer.getText());
                    c.setYearCollection(Integer.parseInt(txtYear.getText()));
                    c.setVolumeCollection(Integer.parseInt(txtVolume.getText()));

                    dao.update(c); //atualiza a colecao

                    break;
            }

            registerPhase = PHASE.NONE;
            updateControls(registerPhase);

            populateCollectionTable();
        }
    }//GEN-LAST:event_btSaveMouseClicked

    private void btEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditMouseClicked
        registerPhase = PHASE.EDIT;
        updateControls(registerPhase);
    }//GEN-LAST:event_btEditMouseClicked

    private void btDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteMouseClicked
        Collection c = new Collection();
        collectionDao dao = new collectionDao();

        c.setIdCollection(Integer.parseInt(txtId.getText()));
        c.setNameCollection(txtName.getText());
        c.setBrandCollection(txtBrand.getText());
        c.setManufacturerCollection(txtManufacturer.getText());
        c.setYearCollection(Integer.parseInt(txtYear.getText()));
        c.setVolumeCollection(Integer.parseInt(txtVolume.getText()));

        dao.delete(c); //deleta a colecao

        registerPhase = PHASE.NONE;
        updateControls(registerPhase);

        populateCollectionTable();
    }//GEN-LAST:event_btDeleteMouseClicked

    private void btCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelMouseClicked
        registerPhase = PHASE.NONE;
        updateControls(registerPhase);
    }//GEN-LAST:event_btCancelMouseClicked

    private void btSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseClicked
        if (txtSearch.getText() != "") {
            populateCollectionTableCustom();
        }
    }//GEN-LAST:event_btSearchMouseClicked

    private void btSearchResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchResetMouseClicked
        populateCollectionTable();
    }//GEN-LAST:event_btSearchResetMouseClicked

    private void tableCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCollectionMouseClicked

        if (tableCollection.getSelectedRow() != -1) {

            txtId.setText(tableCollection.getValueAt(tableCollection.getSelectedRow(), 0).toString());
            txtName.setText(tableCollection.getValueAt(tableCollection.getSelectedRow(), 1).toString());
            txtBrand.setText(tableCollection.getValueAt(tableCollection.getSelectedRow(), 2).toString());
            txtManufacturer.setText(tableCollection.getValueAt(tableCollection.getSelectedRow(), 3).toString());
            txtYear.setText(tableCollection.getValueAt(tableCollection.getSelectedRow(), 4).toString());
            txtVolume.setText(tableCollection.getValueAt(tableCollection.getSelectedRow(), 5).toString());

            registerPhase = PHASE.VIEW;
            updateControls(registerPhase);

            tabcCollection.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tableCollectionMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCollection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCollection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearchReset;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbManufacturer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbVolume;
    private javax.swing.JLabel lbYear;
    private javax.swing.JPanel tabCollectionList;
    private javax.swing.JPanel tabCollectionReg;
    private javax.swing.JTabbedPane tabcCollection;
    private javax.swing.JTable tableCollection;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtVolume;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
