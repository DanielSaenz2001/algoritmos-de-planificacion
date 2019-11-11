
import java.awt.Toolkit;
import javax.swing.JOptionPane;


/**
 *
 * @author ALEJANDRA KSTELLANOS
 */
public class vista2 extends javax.swing.JFrame {

    public CPU contenedor;
    public vista2(CPU TEMP) {
        this.contenedor = TEMP; 
        initComponents();
    }
    @Override
    public void setVisible(boolean vista){
        boolean activar = this.contenedor.activar();
        this.prioridadFil.setVisible(activar);
        this.prioridadL.setVisible(activar);
        super.setVisible(vista);
        
    }
    private void comprobar(){
        if(this.nombreFil.getText().isEmpty() || this.tiempoFil.getText().isEmpty())
        {
              JOptionPane.showMessageDialog(this, "El campo de texto está vacío");
        }
        else
        {
            this.contenedor.nuevoProceso(this.nombreFil.getText(), Integer.parseInt(this.tiempoFil.getText()),this.prioridadFil.getSelectedItem().toString().charAt(0));
            if (this.agregarMas.isSelected()) {
                this.nombreFil.setText("");
                this.tiempoFil.setText("");
                this.prioridadFil.setSelectedIndex(0);
            }else{
                this.dispose();
            }
        }
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prioridadL = new javax.swing.JLabel();
        agregarMas = new javax.swing.JCheckBox();
        agregar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        prioridadFil = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tiempoFil = new javax.swing.JTextField();
        nombreFil = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar proceso\n");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(210, 50));
        setLocationByPlatform(true);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prioridadL.setText("Prioridad");
        getContentPane().add(prioridadL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        agregarMas.setText("Agregar más");
        getContentPane().add(agregarMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        getContentPane().add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        prioridadFil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F" }));
        getContentPane().add(prioridadFil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 80, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Proceso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 65, 30));

        jLabel2.setText("Quantums");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, -1, 26));

        tiempoFil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tiempoFilKeyTyped(evt);
            }
        });
        jPanel1.add(tiempoFil, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 37, 91, 26));

        nombreFil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreFilKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreFilKeyReleased(evt);
            }
        });
        jPanel1.add(nombreFil, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 6, 91, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 180, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        this.comprobar();
    }//GEN-LAST:event_agregarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void nombreFilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreFilKeyPressed
        
    }//GEN-LAST:event_nombreFilKeyPressed

    private void tiempoFilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tiempoFilKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
             Toolkit.getDefaultToolkit().beep();
             evt.consume();
         }
    }//GEN-LAST:event_tiempoFilKeyTyped

    private void nombreFilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreFilKeyReleased
        char c = (char)0x0A;
        if (Character.compare(evt.getKeyChar(), c) == 0) {
            System.out.println("soy enter");
            this.comprobar();
        }
    }//GEN-LAST:event_nombreFilKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JCheckBox agregarMas;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreFil;
    private javax.swing.JComboBox prioridadFil;
    private javax.swing.JLabel prioridadL;
    private javax.swing.JTextField tiempoFil;
    // End of variables declaration//GEN-END:variables
}
