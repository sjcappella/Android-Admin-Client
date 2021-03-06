package my.test;
import javax.swing.*;
import java.io.*;

//Class to view all the active connections
public class ActiveConnections extends javax.swing.JFrame {
    BufferedReader in;
    PrintWriter out;
    DefaultListModel clientModel = new DefaultListModel();
    DefaultListModel adminModel = new DefaultListModel();
    /** Creates new form ActiveConnections */
    public ActiveConnections(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
        //Intialize components
        initComponents();
        //Get the active connections
        getActiveConnections();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList(adminModel);
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList(clientModel);
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        adminConnectionsLabel = new javax.swing.JLabel();
        clientConnectionsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jList2);

        jLabel1.setText("Active Connections");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        adminConnectionsLabel.setText("Admin Connections");

        clientConnectionsLabel.setText("Client Connections");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 465, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(backButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(40, 40, 40)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                            .add(refreshButton)))
                    .add(layout.createSequentialGroup()
                        .add(121, 121, 121)
                        .add(adminConnectionsLabel)
                        .add(447, 447, 447)
                        .add(clientConnectionsLabel))
                    .add(layout.createSequentialGroup()
                        .add(439, 439, 439)
                        .add(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(39, 39, 39)
                        .add(adminConnectionsLabel))
                    .add(clientConnectionsLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(backButton)
                    .add(refreshButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Back button to go back a screen
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        MoreOptions moreOptions = new MoreOptions(in, out);
        moreOptions.setLocation(this.getX(), this.getY());
        this.setVisible(false);
        moreOptions.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    //Regresh all the active connectoins
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        getActiveConnections();
    }//GEN-LAST:event_refreshButtonActionPerformed

    //Get all the active connections
    private void getActiveConnections(){
        //Remove old connections
        adminModel.removeAllElements();
        clientModel.removeAllElements();
        //Send command to the server
        out.println("GET_SERVER_STATUS");
        out.flush();
        int numberOfConnections;
        String readIn;
        try{
            //Get how many connectoins are comming in
            numberOfConnections = Integer.parseInt(in.readLine());
            for(int x = 0; x < numberOfConnections; x++){
                readIn = in.readLine();
                //Look for admin connections
                if(readIn.contains("Admin")){
                    adminModel.addElement(readIn);
                }else{
                    //If not admin, its a client
                    clientModel.addElement(readIn);
                }
            }
            
        }catch(Exception e){
            //Handle the error
        }
    }

    /**
    * @param args the command line arguments
    */
    public void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActiveConnections(in, out).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminConnectionsLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel clientConnectionsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables

}
