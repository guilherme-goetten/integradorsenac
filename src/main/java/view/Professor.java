/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author guilh
 */
public class Professor extends javax.swing.JFrame {

    /**
     * Creates new form Professor
     */
    public Professor() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_addLivro = new javax.swing.JToggleButton();
        button_editarLivro = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        button_addLivro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button_addLivro.setText("Adicionar Livro");
        button_addLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addLivroActionPerformed(evt);
            }
        });
        getContentPane().add(button_addLivro);
        button_addLivro.setBounds(40, 100, 150, 40);

        button_editarLivro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button_editarLivro.setText("Editar/Excluir Livro");
        button_editarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editarLivroActionPerformed(evt);
            }
        });
        getContentPane().add(button_editarLivro);
        button_editarLivro.setBounds(310, 100, 150, 40);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Biblioteca Senac");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 10, 190, 26);

        setSize(new java.awt.Dimension(531, 287));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_addLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addLivroActionPerformed
               
        Tela_add telaAdd = new Tela_add();
        telaAdd.setSize(523,590);
        telaAdd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_button_addLivroActionPerformed

    private void button_editarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editarLivroActionPerformed
                
        Tela_exclusao telaExclusao = new Tela_exclusao();
        telaExclusao.setSize(662, 480);
        telaExclusao.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_button_editarLivroActionPerformed

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
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Professor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton button_addLivro;
    private javax.swing.JToggleButton button_editarLivro;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
