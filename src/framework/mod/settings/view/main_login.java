/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.view;

/**
 *
 * @author osotemi
 */
public class main_login extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main_login() {
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
        Pnl_body = new javax.swing.JPanel();
        pnl_login = new javax.swing.JPanel();
        lbl_userName = new javax.swing.JLabel();
        lbl_passWord = new javax.swing.JLabel();
        txt_userName = new javax.swing.JTextField();
        txt_pass = new javax.swing.JTextField();
        btn_conf = new javax.swing.JButton();
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

        javax.swing.GroupLayout Pnl_headLayout = new javax.swing.GroupLayout(Pnl_head);
        Pnl_head.setLayout(Pnl_headLayout);
        Pnl_headLayout.setHorizontalGroup(
            Pnl_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1168, Short.MAX_VALUE)
        );
        Pnl_headLayout.setVerticalGroup(
            Pnl_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        Pnl_body.setMaximumSize(new java.awt.Dimension(1562, 535));
        Pnl_body.setOpaque(false);

        pnl_login.setBackground(new java.awt.Color(255, 255, 255));
        pnl_login.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Login", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        pnl_login.setMaximumSize(new java.awt.Dimension(1767, 1267));

        lbl_userName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_userName.setText("_");

        lbl_passWord.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_passWord.setText("_");

        txt_userName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_pass.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_conf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/sett_icons.png"))); // NOI18N
        btn_conf.setText("Configuracion");
        btn_conf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_conf.setOpaque(false);

        javax.swing.GroupLayout pnl_loginLayout = new javax.swing.GroupLayout(pnl_login);
        pnl_login.setLayout(pnl_loginLayout);
        pnl_loginLayout.setHorizontalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_conf, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_passWord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_userName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_loginLayout.setVerticalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btn_conf, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout Pnl_bodyLayout = new javax.swing.GroupLayout(Pnl_body);
        Pnl_body.setLayout(Pnl_bodyLayout);
        Pnl_bodyLayout.setHorizontalGroup(
            Pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pnl_bodyLayout.setVerticalGroup(
            Pnl_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pnl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pnl_head, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addContainerGap(594, Short.MAX_VALUE)
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
    public static javax.swing.JButton btn_conf;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel lbl_passWord;
    public static javax.swing.JLabel lbl_userName;
    public static org.edisoncor.gui.panel.PanelImage panelImage2;
    public static org.edisoncor.gui.panel.PanelImage panelImage3;
    public static org.edisoncor.gui.panel.PanelImage panelImage4;
    public static javax.swing.JPanel pnl_login;
    public static javax.swing.JTextField txt_pass;
    public static javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
