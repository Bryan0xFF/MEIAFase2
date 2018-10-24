/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Classes.IndexSecuencial;
import Classes.IndiceListaUsuario;
import Classes.Lista;
import Classes.Lista_Usuario;
import Classes.SecIndizado;
import Classes.Secuencial;
import Classes.Usuario;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author rodri
 */
public class AddToListForm extends javax.swing.JFrame {

    Lista lista = new Lista(); 
    DefaultListModel allLists = new DefaultListModel();
    public Usuario user = new Usuario(); 
    Secuencial secuencial = new Secuencial(); 
    String nombreAsociado = ""; 
     String nombreLista = ""; 
    public AddToListForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        UserForm userForm = new UserForm(); 
        user = userForm.usuario; 
        
        try {         
            allLists = lista.BuscarLista(user.getUsuario());
             
            
            List.setModel(allLists);
        }
        catch (IOException ex) {
            Logger.getLogger(AddToListForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        List = new javax.swing.JList<>();
        tfUsuario = new javax.swing.JTextField();
        lblListas = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevaLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(List);

        lblListas.setText("Listas creadas:");

        lblUsuario.setText("Usuario a agregar:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevaLista.setText("Nueva lista");
        btnNuevaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblListas)
                            .addComponent(lblUsuario))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(tfUsuario)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevaLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblListas))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            nombreLista = List.getSelectedValue();
            nombreAsociado = tfUsuario.getText();            
            Usuario asociado = new Usuario();
            asociado = secuencial.ObtenerUsuario(nombreAsociado, "Usuario");
            int count = 0;    
            
            IndiceListaUsuario indiceListaUsuario = new IndiceListaUsuario();            
            SecIndizado secuencialIndex = new SecIndizado();
            IndexSecuencial index = new IndexSecuencial();    
            
            if (asociado.getUsuario().equals(nombreAsociado)) {
              lista = lista.ObtenerLista(user.getUsuario(), nombreLista);
              count = Integer.valueOf(lista.numero_usuarios);
              count++;
              lista.numero_usuarios = String.valueOf(count);
              String overWritedList = lista.setFixedSize();
              Classes.Lista.SobreescribirLista(overWritedList, nombreLista, "lista", lista.getSize(),user.getUsuario());
              
              Lista_Usuario listaUsuario = new Lista_Usuario(nombreLista, user.getUsuario(), nombreAsociado, lista.descripcion);
              
              //Implementar aqui el metodo para el archivo indexado
              JOptionPane.showMessageDialog(null, "El usuario: " + nombreAsociado + " se ha agregado a la lista: " + nombreLista, "Agregar",WIDTH);  
            }
            else if (!asociado.equals(user)){
              JOptionPane.showMessageDialog(null, "El usuario que desea agregar no existe", "Error",WIDTH);
            }  
        }
        catch (Exception ex) {
            Logger.getLogger(AddToListForm.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "El usuario: " + nombreAsociado + " ya existe en la lista: " + nombreLista, "Error",WIDTH);
        }
       
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaListaActionPerformed
       CreateListsForm create = new CreateListsForm(); 
       create.show();
    }//GEN-LAST:event_btnNuevaListaActionPerformed

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
            java.util.logging.Logger.getLogger(AddToListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddToListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddToListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddToListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddToListForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> List;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevaLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListas;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
