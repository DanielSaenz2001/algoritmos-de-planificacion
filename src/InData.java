
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class InData extends javax.swing.JFrame {
    public VPU ListProcess;
//    inicializamos nuestro creador de procesos
    public InData(VPU Data) {
        this.ListProcess = Data;
        
        this.setVisible(true);
        initComponents();
    }
//    creamos un nuevo proceso con los datos ingresados en los campos correspondientes
    public Proceso addData(){
        return new Proceso(this.name.getText(), Integer.parseInt(this.time.getText()) , Integer.parseInt(this.priori.getText()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLa = new javax.swing.JLabel();
        timeLa = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        priori = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        addMore = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        timeLa1 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proceso");
        setResizable(false);

        nameLa.setText("Nombre");

        timeLa.setText("Tiempo");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        agregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                agregarKeyTyped(evt);
            }
        });

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        priori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prioriActionPerformed(evt);
            }
        });
        priori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prioriKeyTyped(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        addMore.setText("Agragar mas");

        jLabel1.setText("Agregar un nuevo proceso");

        timeLa1.setText("Prioridad");

        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });
        time.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addMore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(agregar))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeLa1)
                    .addComponent(timeLa)
                    .addComponent(nameLa))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(name)
                    .addComponent(priori)
                    .addComponent(time)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLa)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLa)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLa1)
                    .addComponent(priori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(cancel)
                    .addComponent(addMore)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
//      destruimos el creador de procesos actual
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed
//si no se ha agregado texto no podras agregar tus datos
//    si esta seleccionado el checkbox, la ventana no se cerrara hasta que des-elecciones este
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if(this.time.getText().isEmpty() || this.name.getText().isEmpty() || this.priori.getText().isEmpty())
        {
              JOptionPane.showMessageDialog(this, "El campo de texto está vacío");
        }
        else
        {
            this.ListProcess.nuevoProceso(this.name.getText(), Integer.parseInt(this.time.getText()), Integer.parseInt(this.priori.getText()));
            if (this.addMore.isSelected()) {
                this.name.setText("");
                this.time.setText("");
                this.priori.setText("");
            }else{
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_agregarActionPerformed
// por falta de tiempo no lo quite
    private void agregarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agregarKeyTyped

    }//GEN-LAST:event_agregarKeyTyped
// si los datos ingresados en el campo de los cuantums no son correctos, este no los leera
    private void prioriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prioriKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
             Toolkit.getDefaultToolkit().beep();
             evt.consume();
         }
    }//GEN-LAST:event_prioriKeyTyped

    private void timeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_timeKeyTyped

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void prioriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prioriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prioriActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox addMore;
    private javax.swing.JButton agregar;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLa;
    private javax.swing.JTextField priori;
    private javax.swing.JTextField time;
    private javax.swing.JLabel timeLa;
    private javax.swing.JLabel timeLa1;
    // End of variables declaration//GEN-END:variables
}
