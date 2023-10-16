/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.ui;


import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ma.beans.Client;
import ma.beans.Service;
import ma.service.ClientService;
import ma.service.ServiceService;


/**
 *
 * @author Lachgar
 */
public class ClientForm extends javax.swing.JInternalFrame {
    
   private DefaultTableModel clientTableModel = null ;
   private ClientService cs = new ClientService() ;
   private ServiceService ss = new ServiceService() ;
   private DefaultComboBoxModel<String> serviceComboBoxModel;
   static int id=0 ;
    private Object connection;
    /**
     * Creates new form ClientForm
     */
    public ClientForm() {
        
        initComponents(); 
        clientTableModel = (DefaultTableModel) tableClient.getModel();
        loadClient();
        loadService() ;
    }
    
    
     private void loadClient() {
         
       clientTableModel.setRowCount(0);
        for (Client cl : cs.findAll()) {
            clientTableModel.addRow(new Object[]{
                cl.getId(),
                cl.getNom(),
                cl.getPrenom(),
                cl.getDate(),
                cl.getService() // Afficher le nom du service
            });
        }
    }
    
     public void loadService(){
         
        serviceBox.addItem("Selectionner un service");
        for(Service s :ss.findAll() ){
           serviceBox.addItem(s);
           
        }
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomTxt = new javax.swing.JTextField();
        prenomTxt = new javax.swing.JTextField();
        datechoser = new com.toedter.calendar.JDateChooser();
        serviceBox = new javax.swing.JComboBox();
        Ajouter = new javax.swing.JButton();
        Supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClient = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des Clients"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion des Clients");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Informations Clients"));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Nom :");

        jLabel3.setText("Prénom :");

        jLabel4.setText("Service :");

        jLabel5.setText("Date :");

        nomTxt.setToolTipText("");
        nomTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTxtActionPerformed(evt);
            }
        });

        prenomTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomTxt)
                    .addComponent(prenomTxt)
                    .addComponent(datechoser, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(serviceBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prenomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(serviceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datechoser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Ajouter.setText("Ajouter");
        Ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AjouterMouseClicked(evt);
            }
        });
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        Supprimer.setText("Supprimer");
        Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprimerMouseClicked(evt);
            }
        });
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });

        modifier.setText("Modifier");
        modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifierMouseClicked(evt);
            }
        });
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Liste Clients"));

        tableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prénom", "Date", "Service"
            }
        ));
        tableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableClient);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(Ajouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Supprimer))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTxtActionPerformed
        String nom = nomTxt.getText().toString();
    }//GEN-LAST:event_nomTxtActionPerformed

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
      
    String nom = nomTxt.getText();
    String prenom = prenomTxt.getText();

    // Vérifier si un client avec les mêmes coordonnées (nom et prénom) existe déjà
    if (clientExiste(nom, prenom)) {
        JOptionPane.showMessageDialog(this, "Un client avec les mêmes coordonnées existe déjà.");
    } else {
        // Ajouter le client uniquement si aucun client avec les mêmes coordonnées n'existe
        cs.create(new Client(nom, prenom, datechoser.getDate(), (Service) serviceBox.getSelectedItem()));
        JOptionPane.showMessageDialog(this, "Client ajouté avec succès.");
        loadClient();
    }
}

// Méthode pour vérifier si un client avec les mêmes coordonnées existe déjà
private boolean clientExiste(String nom, String prenom) {
    for (Client client : cs.findAll()) {
        if (client.getNom().equals(nom) && client.getPrenom().equals(prenom)) {
            return true; // Un client avec les mêmes coordonnées existe déjà
        }
    }
    return false; // Aucun client avec les mêmes coordonnées n'existe

// TODO add your handling code here:
    }//GEN-LAST:event_AjouterActionPerformed



    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
 
           String nom = nomTxt.getText();
          String prenom = prenomTxt.getText();
          Date date = datechoser.getDate();
         Service service =  (Service) serviceBox.getSelectedItem(); 
        Client c= new Client(id,nom,prenom,date,service);
       
try {
    int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment modifier cet enregistrement ? ");
    if (id != -1) {
        if (reponse == 0) {
            if (cs.update(c)) {
                JOptionPane.showMessageDialog(this, "La modification est faite !");
                loadClient();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner un client à mettre à jour");
    }
} catch (Exception ex) {
    // Gestion de l'exception : Affichez un message d'erreur ou enregistrez l'exception dans des logs
    ex.printStackTrace(); // Affichez la trace de l'exception pour le débogage
    JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de la modification du client.");
}
              
        
//        try {
//        if (serviceBox.getSelectedItem().equals("Selectionner un service")) {
//        
//
//            
//            // Appeler la méthode de mise à jour en passant le service existant
//            cs.update(cs.findById(id), nomTxt.getText(), prenomTxt.getText(), datechoser.getDate(), cs.findById(id).getService());
//            
//            // Afficher un message de confirmation
//            JOptionPane.showMessageDialog(this, "Client mis à jour avec le même service.");
//        } else {
//            // Obtenir le nouveau service sélectionné
//            Service serv = (Service) serviceBox.getSelectedItem();
//            
//            // Appeler la méthode de mise à jour en passant le nouveau service
//            cs.update(cs.findById(id), nomTxt.getText(), prenomTxt.getText(), datechoser.getDate(), serv);
//            
//            // Afficher un message de confirmation
//            JOptionPane.showMessageDialog(this, "Client mis à jour avec un nouveau service.");
//        }
//        
//        // Recharger la liste des clients mise à jour
//        loadClient();
//    } catch (Exception e) {
////        JOptionPane.showMessageDialog(this, "Veuillez compléter tous les champs.");
//        System.out.println(e);
//    }
//        
    }//GEN-LAST:event_modifierActionPerformed

    private void prenomTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomTxtActionPerformed
        String Prenom = prenomTxt.getText().toString();
    }//GEN-LAST:event_prenomTxtActionPerformed

    private void AjouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjouterMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AjouterMouseClicked

    private void SupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupprimerMouseClicked
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer ce client ?");
        if(reponse == 0){
            cs.delete(cs.findById(id));
            loadClient();
    }//GEN-LAST:event_SupprimerMouseClicked
    }
    private void tableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientMouseClicked

          id = Integer.parseInt(tableClient.getValueAt( tableClient.getSelectedRow(), 0).toString());
        datechoser.setDate(cs.findById(id).getDate());
        nomTxt.setText(cs.findById(id).getNom());
         prenomTxt.setText(cs.findById(id).getPrenom());
             loadClient() ;
        
    }//GEN-LAST:event_tableClientMouseClicked

    private void modifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifierMouseClicked
   
    }//GEN-LAST:event_modifierMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajouter;
    private javax.swing.JButton Supprimer;
    private com.toedter.calendar.JDateChooser datechoser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField nomTxt;
    private javax.swing.JTextField prenomTxt;
    private javax.swing.JComboBox serviceBox;
    private javax.swing.JTable tableClient;
    // End of variables declaration//GEN-END:variables

}
