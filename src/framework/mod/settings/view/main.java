/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.view;

import framework.mod.user.admin.view.main_Admin;
import static framework.mod.user.admin.view.main_Admin.DC_formAdm_borndate;
import static framework.mod.user.admin.view.main_Admin.DC_formAdm_singdate;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static framework.mod.user.admin.view.main_Admin.PNL_drawForm;

/**
 *
 * @author osotemi
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        //un();
        
        //
        ///
    }
    /*
    private void run() {
        Image icono = null;
        this.setTitle("Servicios farmace�ticos");
	this.setLocationRelativeTo(null);//centrado
	//this.setSize(525,425);//ancho x alto
        try {
            icono=Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + "/src/framework/img/medical_help.png");
        } catch (IOException e) {
            
        }
            
        this.setIconImage(icono);
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        Pnl_head = new javax.swing.JPanel();
        btn_conf = new javax.swing.JButton();
        Pnl_body = new javax.swing.JPanel();
        btn_AdminGOTO_mainAdmin = new javax.swing.JButton();
        btn_RegGOTO_mainReg = new javax.swing.JButton();
        btn_ClientGOTO_mainClient = new javax.swing.JButton();
        panelImage4 = new org.edisoncor.gui.panel.PanelImage();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelImage3Layout.setVerticalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1370, 780));
        getContentPane().setLayout(new java.awt.BorderLayout(1, 0));

        panelImage2.setBackground(new java.awt.Color(255, 255, 255));
        panelImage2.setAlignmentX(0.0F);
        panelImage2.setAlignmentY(0.0F);
        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/Green-and-Blue-Abstract-Backgrounds-1024x768.jpg"))); // NOI18N
        panelImage2.setMaximumSize(new java.awt.Dimension(1562, 465));

        Pnl_head.setMaximumSize(new java.awt.Dimension(1562, 535));
        Pnl_head.setOpaque(false);

        btn_conf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/sett_icons.png"))); // NOI18N
        btn_conf.setText("Configuracion");
        btn_conf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_conf.setOpaque(false);

        javax.swing.GroupLayout Pnl_headLayout = new javax.swing.GroupLayout(Pnl_head);
        Pnl_head.setLayout(Pnl_headLayout);
        Pnl_headLayout.setHorizontalGroup(
            Pnl_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_headLayout.createSequentialGroup()
                .addComponent(btn_conf)
                .addGap(0, 1040, Short.MAX_VALUE))
        );
        Pnl_headLayout.setVerticalGroup(
            Pnl_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_headLayout.createSequentialGroup()
                .addComponent(btn_conf, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        Pnl_body.setMaximumSize(new java.awt.Dimension(1562, 535));
        Pnl_body.setOpaque(false);

        btn_AdminGOTO_mainAdmin.setBackground(new java.awt.Color(0, 153, 0));
        btn_AdminGOTO_mainAdmin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_AdminGOTO_mainAdmin.setText("Admin");
        btn_AdminGOTO_mainAdmin.setAlignmentY(0.0F);
        btn_AdminGOTO_mainAdmin.setBorderPainted(false);
        btn_AdminGOTO_mainAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AdminGOTO_mainAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_AdminGOTO_mainAdmin.setMinimumSize(new java.awt.Dimension(70, 25));
        btn_AdminGOTO_mainAdmin.setPreferredSize(new java.awt.Dimension(70, 25));

        btn_RegGOTO_mainReg.setBackground(new java.awt.Color(0, 153, 0));
        btn_RegGOTO_mainReg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_RegGOTO_mainReg.setText("Registered user");
        btn_RegGOTO_mainReg.setAlignmentY(0.0F);
        btn_RegGOTO_mainReg.setBorderPainted(false);
        btn_RegGOTO_mainReg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RegGOTO_mainReg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_RegGOTO_mainReg.setMinimumSize(new java.awt.Dimension(70, 25));
        btn_RegGOTO_mainReg.setPreferredSize(new java.awt.Dimension(70, 25));

        btn_ClientGOTO_mainClient.setBackground(new java.awt.Color(0, 153, 0));
        btn_ClientGOTO_mainClient.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_ClientGOTO_mainClient.setText("Client");
        btn_ClientGOTO_mainClient.setAlignmentY(0.0F);
        btn_ClientGOTO_mainClient.setBorderPainted(false);
        btn_ClientGOTO_mainClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ClientGOTO_mainClient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ClientGOTO_mainClient.setMinimumSize(new java.awt.Dimension(70, 25));
        btn_ClientGOTO_mainClient.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout Pnl_bodyLayout = new javax.swing.GroupLayout(Pnl_body);
        Pnl_body.setLayout(Pnl_bodyLayout);
        Pnl_bodyLayout.setHorizontalGroup(
            Pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_bodyLayout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addGroup(Pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ClientGOTO_mainClient, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(btn_RegGOTO_mainReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_AdminGOTO_mainAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(539, Short.MAX_VALUE))
        );
        Pnl_bodyLayout.setVerticalGroup(
            Pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_AdminGOTO_mainAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ClientGOTO_mainClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_RegGOTO_mainReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        btn_AdminGOTO_mainAdmin.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Pnl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pnl_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelImage2, java.awt.BorderLayout.CENTER);

        panelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/4809986809_aa94ea96b3_o.jpg"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(153, 255, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Aviso legal");
        jLabel4.setToolTipText("");

        jLabel5.setForeground(new java.awt.Color(153, 255, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Powered by @osblue");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout panelImage4Layout = new javax.swing.GroupLayout(panelImage4);
        panelImage4.setLayout(panelImage4Layout);
        panelImage4Layout.setHorizontalGroup(
            panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage4Layout.createSequentialGroup()
                .addContainerGap(678, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        panelImage4Layout.setVerticalGroup(
            panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(panelImage4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Pnl_body;
    public static javax.swing.JPanel Pnl_head;
    public static javax.swing.JButton btn_AdminGOTO_mainAdmin;
    public static javax.swing.JButton btn_ClientGOTO_mainClient;
    public static javax.swing.JButton btn_RegGOTO_mainReg;
    public static javax.swing.JButton btn_conf;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static org.edisoncor.gui.panel.PanelImage panelImage2;
    public static org.edisoncor.gui.panel.PanelImage panelImage3;
    public static org.edisoncor.gui.panel.PanelImage panelImage4;
    // End of variables declaration//GEN-END:variables
}
