/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class Tela_login extends javax.swing.JFrame {

    /**
     * Creates new form Tela_login
     */
    public Tela_login() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        input_usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        input_senha = new javax.swing.JPasswordField();
        button_ok = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de login");
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Biblioteca Senac");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 10, 240, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Informe seu usuário:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 50, 210, 26);

        input_usuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        input_usuario.setForeground(new java.awt.Color(51, 51, 51));
        input_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(input_usuario);
        input_usuario.setBounds(80, 80, 280, 30);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 120, 80, 26);

        input_senha.setForeground(new java.awt.Color(51, 51, 51));
        input_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_senhaActionPerformed(evt);
            }
        });
        getContentPane().add(input_senha);
        input_senha.setBounds(140, 150, 150, 30);

        button_ok.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button_ok.setForeground(new java.awt.Color(51, 51, 51));
        button_ok.setText("OK");
        button_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_okActionPerformed(evt);
            }
        });
        getContentPane().add(button_ok);
        button_ok.setBounds(160, 200, 110, 27);

        setSize(new java.awt.Dimension(462, 299));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void input_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_usuarioActionPerformed
       input_usuario.setBackground(new java.awt.Color(0,0,0,0));
    }//GEN-LAST:event_input_usuarioActionPerformed

    private void input_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_senhaActionPerformed

    private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed
         //pega o valor adicionado em usuário e senha. 
     //input_senha = nome da variavel
     //getText = pega o valor
     //equals = igualando/igual
     // || = ou
     // if = "Se"
    if(input_usuario.getText().equals("") || input_senha.getText().equals("")){
        
        //se os valores estiverem em branco vai aparecer a mensagem
        
                JOptionPane.showMessageDialog(null,"Informe Usuário ou Senha!");
                //seta o valor que tem q conter em usuario e senha 
    } else if (input_usuario.getText().equals("Guilherme") && input_senha.getText().equals("12345678")){
        
        
            Professor telaProf = new Professor();
            telaProf.setSize(515, 248);
            telaProf.setVisible(true);
            this.setVisible(false);
        
    } else if (input_usuario.getText().equals("Aluno") && input_senha.getText().equals("12345678")) {
    

        Aluno telaAluno = new Aluno();
        telaAluno.setSize(740, 400);
        telaAluno.setVisible(true);
        this.setVisible(false);
    } else {
        //caso nenhuma das alternativas forem sanadas aparece a mensagem.
            JOptionPane.showMessageDialog(null, "Usuário ou Senha inválido!");
    }                                             

    }//GEN-LAST:event_button_okActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton button_ok;
    private javax.swing.JPasswordField input_senha;
    private javax.swing.JTextField input_usuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
