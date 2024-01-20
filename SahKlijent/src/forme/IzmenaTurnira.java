/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Turnir;
import logika.KontrolerKlijent;

/**
 *
 * @author Milena Kutch
 */ 
public class IzmenaTurnira extends javax.swing.JDialog {
Turnir t;
    /**
     * Creates new form IzmenaTurnira
     */
    public IzmenaTurnira(java.awt.Frame parent, boolean modal, Turnir turnir) {
        super(parent, modal);
        initComponents();
        KontrolerKlijent.getInstance().setTurnirinovi(this);
        txtnaziv.setText(turnir.getNaziv());
        txtmesto.setText(turnir.getMesto());
        cmbtempo.setSelectedItem(turnir.getTempo());
        cmbtip.setSelectedItem(turnir.getTip());
        cmbRegion.setSelectedItem(turnir.getRegion());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnaziv = new javax.swing.JTextField();
        txtmesto = new javax.swing.JTextField();
        cmbtip = new javax.swing.JComboBox<>();
        cmbtempo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbRegion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv turnira");

        jLabel2.setText("Mesto odrzavanja");

        jLabel3.setText("Tip");

        jLabel4.setText("Tempo");

        txtnaziv.setEditable(false);
        txtnaziv.setText("jTextField1");

        txtmesto.setText("jTextField2");

        cmbtip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kategorni", "rejtingovan", "nerejtingovan" }));

        cmbtempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "redovan", "ubrzani", "brzopotezni" }));

        jButton1.setText("Otkazi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Azuriraj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Status");

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aktivan", "zavrsen" }));

        jLabel6.setText("Region");

        cmbRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "drzavno", "evropsko", "svetsko", "opstinsko", "balkansko" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(txtnaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmesto)
                                    .addComponent(cmbtip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbtempo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1)
                        .addGap(84, 84, 84)
                        .addComponent(jButton2)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtnaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtmesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbtip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbtempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setT(Turnir t) {
        this.t = t;
    }

    public Turnir getT() {
        return t;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      KontrolerKlijent.getInstance().izmenaTurnira();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRegion;
    private javax.swing.JComboBox<String> cmbtempo;
    private javax.swing.JComboBox<String> cmbtip;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> txtStatus;
    private javax.swing.JTextField txtmesto;
    private javax.swing.JTextField txtnaziv;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox<String> getCmbtempo() {
        return cmbtempo;
    }

    public void setCmbtempo(javax.swing.JComboBox<String> cmbtempo) {
        this.cmbtempo = cmbtempo;
    }

    public javax.swing.JComboBox<String> getCmbtip() {
        return cmbtip;
    }

    public void setCmbtip(javax.swing.JComboBox<String> cmbtip) {
        this.cmbtip = cmbtip;
    }

    public javax.swing.JTextField getTxtmesto() {
        return txtmesto;
    }

    public void setTxtmesto(javax.swing.JTextField txtmesto) {
        this.txtmesto = txtmesto;
    }

    public javax.swing.JTextField getTxtnaziv() {
        return txtnaziv;
    }

    public void setTxtnaziv(javax.swing.JTextField txtnaziv) {
        this.txtnaziv = txtnaziv;
    }

    public javax.swing.JComboBox<String> getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(javax.swing.JComboBox<String> txtStatus) {
        this.txtStatus = txtStatus;
    }

    public javax.swing.JComboBox<String> getCmbRegion() {
        return cmbRegion;
    }

    public void setCmbRegion(javax.swing.JComboBox<String> cmbRegion) {
        this.cmbRegion = cmbRegion;
    }
}