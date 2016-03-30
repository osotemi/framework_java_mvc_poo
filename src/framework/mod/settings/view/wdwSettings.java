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
public class wdwSettings extends javax.swing.JFrame {

    /**
     * Creates new form wdwSettings
     */
    public wdwSettings() {
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

        TABgen = new javax.swing.JTabbedPane();
        TABdecimal = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JSP_decimals = new javax.swing.JSpinner();
        TABfdate = new javax.swing.JPanel();
        JCB_formatDate = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        TABfileType = new javax.swing.JPanel();
        btn_confJSON = new javax.swing.JButton();
        btn_confTXT = new javax.swing.JButton();
        btn_confXML = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TABlookNfeel = new javax.swing.JPanel();
        TABlanguage = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JP_currEuro = new javax.swing.JPanel();
        btn_currEuro = new javax.swing.JButton();
        JP_currPound = new javax.swing.JPanel();
        btn_currPound = new javax.swing.JButton();
        JP_currDolar = new javax.swing.JPanel();
        btn_currDolar = new javax.swing.JButton();
        TABcurrency = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JP_langES = new javax.swing.JPanel();
        btn_spain = new javax.swing.JButton();
        JP_langGZ = new javax.swing.JPanel();
        btn_galiza = new javax.swing.JButton();
        JP_langUK = new javax.swing.JPanel();
        btn_unitedk = new javax.swing.JButton();
        JP_langVLC = new javax.swing.JPanel();
        btn_valencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Decimales");

        javax.swing.GroupLayout TABdecimalLayout = new javax.swing.GroupLayout(TABdecimal);
        TABdecimal.setLayout(TABdecimalLayout);
        TABdecimalLayout.setHorizontalGroup(
            TABdecimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABdecimalLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSP_decimals, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        TABdecimalLayout.setVerticalGroup(
            TABdecimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABdecimalLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(TABdecimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSP_decimals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        TABgen.addTab("Decimal", TABdecimal);

        JCB_formatDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd" }));

        jLabel3.setText("Formato de fecha");

        javax.swing.GroupLayout TABfdateLayout = new javax.swing.GroupLayout(TABfdate);
        TABfdate.setLayout(TABfdateLayout);
        TABfdateLayout.setHorizontalGroup(
            TABfdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TABfdateLayout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addGroup(TABfdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(JCB_formatDate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(177, 177, 177))
        );
        TABfdateLayout.setVerticalGroup(
            TABfdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABfdateLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCB_formatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        TABgen.addTab("Date Format", TABfdate);

        btn_confJSON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/format/format_json.jpeg"))); // NOI18N
        btn_confJSON.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confJSON.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confJSON.setMaximumSize(new java.awt.Dimension(102, 102));
        btn_confJSON.setMinimumSize(new java.awt.Dimension(102, 102));
        btn_confJSON.setPreferredSize(new java.awt.Dimension(102, 102));

        btn_confTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/format/format_txt.jpeg"))); // NOI18N
        btn_confTXT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confTXT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confTXT.setMaximumSize(new java.awt.Dimension(102, 102));
        btn_confTXT.setMinimumSize(new java.awt.Dimension(102, 102));
        btn_confTXT.setPreferredSize(new java.awt.Dimension(102, 102));

        btn_confXML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/format/format_xml.jpeg"))); // NOI18N
        btn_confXML.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confXML.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confXML.setMaximumSize(new java.awt.Dimension(102, 102));
        btn_confXML.setMinimumSize(new java.awt.Dimension(102, 102));
        btn_confXML.setPreferredSize(new java.awt.Dimension(102, 102));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel1");

        javax.swing.GroupLayout TABfileTypeLayout = new javax.swing.GroupLayout(TABfileType);
        TABfileType.setLayout(TABfileTypeLayout);
        TABfileTypeLayout.setHorizontalGroup(
            TABfileTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABfileTypeLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btn_confJSON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_confTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btn_confXML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TABfileTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TABfileTypeLayout.setVerticalGroup(
            TABfileTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TABfileTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(TABfileTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_confTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_confXML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_confJSON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        TABgen.addTab("File Type", TABfileType);

        javax.swing.GroupLayout TABlookNfeelLayout = new javax.swing.GroupLayout(TABlookNfeel);
        TABlookNfeel.setLayout(TABlookNfeelLayout);
        TABlookNfeelLayout.setHorizontalGroup(
            TABlookNfeelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        TABlookNfeelLayout.setVerticalGroup(
            TABlookNfeelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        TABgen.addTab("Look & Feel", TABlookNfeel);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel1");

        btn_currEuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/currency/money_euro.png"))); // NOI18N
        btn_currEuro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_currEuro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_currEuro.setMaximumSize(new java.awt.Dimension(100, 100));
        btn_currEuro.setMinimumSize(new java.awt.Dimension(100, 100));
        btn_currEuro.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout JP_currEuroLayout = new javax.swing.GroupLayout(JP_currEuro);
        JP_currEuro.setLayout(JP_currEuroLayout);
        JP_currEuroLayout.setHorizontalGroup(
            JP_currEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_currEuroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_currEuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_currEuroLayout.setVerticalGroup(
            JP_currEuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_currEuroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_currEuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_currPound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/currency/money_pounds.png"))); // NOI18N
        btn_currPound.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_currPound.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_currPound.setMaximumSize(new java.awt.Dimension(100, 100));
        btn_currPound.setMinimumSize(new java.awt.Dimension(100, 100));
        btn_currPound.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout JP_currPoundLayout = new javax.swing.GroupLayout(JP_currPound);
        JP_currPound.setLayout(JP_currPoundLayout);
        JP_currPoundLayout.setHorizontalGroup(
            JP_currPoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_currPoundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_currPound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_currPoundLayout.setVerticalGroup(
            JP_currPoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_currPoundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_currPound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_currDolar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/currency/money_dolar.png"))); // NOI18N
        btn_currDolar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_currDolar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_currDolar.setMaximumSize(new java.awt.Dimension(100, 100));
        btn_currDolar.setMinimumSize(new java.awt.Dimension(100, 100));
        btn_currDolar.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout JP_currDolarLayout = new javax.swing.GroupLayout(JP_currDolar);
        JP_currDolar.setLayout(JP_currDolarLayout);
        JP_currDolarLayout.setHorizontalGroup(
            JP_currDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_currDolarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btn_currDolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JP_currDolarLayout.setVerticalGroup(
            JP_currDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_currDolarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_currDolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TABlanguageLayout = new javax.swing.GroupLayout(TABlanguage);
        TABlanguage.setLayout(TABlanguageLayout);
        TABlanguageLayout.setHorizontalGroup(
            TABlanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABlanguageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TABlanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TABlanguageLayout.createSequentialGroup()
                        .addComponent(JP_currEuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(JP_currPound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(JP_currDolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        TABlanguageLayout.setVerticalGroup(
            TABlanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABlanguageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(TABlanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JP_currDolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_currEuro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_currPound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        TABgen.addTab("Currency", TABlanguage);

        TABcurrency.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        btn_spain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/flags/flag_ES.png"))); // NOI18N
        btn_spain.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_spain.setBorderPainted(false);
        btn_spain.setContentAreaFilled(false);
        btn_spain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_spain.setMaximumSize(new java.awt.Dimension(120, 91));
        btn_spain.setMinimumSize(new java.awt.Dimension(120, 91));
        btn_spain.setPreferredSize(new java.awt.Dimension(120, 91));

        javax.swing.GroupLayout JP_langESLayout = new javax.swing.GroupLayout(JP_langES);
        JP_langES.setLayout(JP_langESLayout);
        JP_langESLayout.setHorizontalGroup(
            JP_langESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langESLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_spain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_langESLayout.setVerticalGroup(
            JP_langESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langESLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_spain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_galiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/flags/flag_GZ.png"))); // NOI18N
        btn_galiza.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_galiza.setBorderPainted(false);
        btn_galiza.setContentAreaFilled(false);
        btn_galiza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_galiza.setMaximumSize(new java.awt.Dimension(120, 91));
        btn_galiza.setMinimumSize(new java.awt.Dimension(120, 91));
        btn_galiza.setPreferredSize(new java.awt.Dimension(120, 91));

        javax.swing.GroupLayout JP_langGZLayout = new javax.swing.GroupLayout(JP_langGZ);
        JP_langGZ.setLayout(JP_langGZLayout);
        JP_langGZLayout.setHorizontalGroup(
            JP_langGZLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langGZLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_galiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_langGZLayout.setVerticalGroup(
            JP_langGZLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langGZLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_galiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_unitedk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/flags/flag_UK.png"))); // NOI18N
        btn_unitedk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_unitedk.setBorderPainted(false);
        btn_unitedk.setContentAreaFilled(false);
        btn_unitedk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_unitedk.setMaximumSize(new java.awt.Dimension(120, 91));
        btn_unitedk.setMinimumSize(new java.awt.Dimension(120, 91));
        btn_unitedk.setPreferredSize(new java.awt.Dimension(120, 91));

        javax.swing.GroupLayout JP_langUKLayout = new javax.swing.GroupLayout(JP_langUK);
        JP_langUK.setLayout(JP_langUKLayout);
        JP_langUKLayout.setHorizontalGroup(
            JP_langUKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langUKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_unitedk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_langUKLayout.setVerticalGroup(
            JP_langUKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langUKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_unitedk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_valencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/flags/flag_VLC.png"))); // NOI18N
        btn_valencia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_valencia.setBorderPainted(false);
        btn_valencia.setContentAreaFilled(false);
        btn_valencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_valencia.setMaximumSize(new java.awt.Dimension(120, 91));
        btn_valencia.setMinimumSize(new java.awt.Dimension(120, 91));
        btn_valencia.setPreferredSize(new java.awt.Dimension(120, 91));

        javax.swing.GroupLayout JP_langVLCLayout = new javax.swing.GroupLayout(JP_langVLC);
        JP_langVLC.setLayout(JP_langVLCLayout);
        JP_langVLCLayout.setHorizontalGroup(
            JP_langVLCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langVLCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_valencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_langVLCLayout.setVerticalGroup(
            JP_langVLCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_langVLCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_valencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TABcurrencyLayout = new javax.swing.GroupLayout(TABcurrency);
        TABcurrency.setLayout(TABcurrencyLayout);
        TABcurrencyLayout.setHorizontalGroup(
            TABcurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABcurrencyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TABcurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TABcurrencyLayout.createSequentialGroup()
                        .addComponent(JP_langES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JP_langGZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JP_langUK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JP_langVLC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TABcurrencyLayout.setVerticalGroup(
            TABcurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TABcurrencyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TABcurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_langES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JP_langGZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JP_langUK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JP_langVLC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        TABgen.addTab("Languange", TABcurrency);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TABgen)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TABgen)
                .addContainerGap())
        );

        TABgen.getAccessibleContext().setAccessibleName("generalTAB");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(wdwSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wdwSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wdwSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wdwSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wdwSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> JCB_formatDate;
    public static javax.swing.JPanel JP_currDolar;
    public static javax.swing.JPanel JP_currEuro;
    public static javax.swing.JPanel JP_currPound;
    public static javax.swing.JPanel JP_langES;
    public static javax.swing.JPanel JP_langGZ;
    public static javax.swing.JPanel JP_langUK;
    public static javax.swing.JPanel JP_langVLC;
    public static javax.swing.JSpinner JSP_decimals;
    public static javax.swing.JPanel TABcurrency;
    public static javax.swing.JPanel TABdecimal;
    public static javax.swing.JPanel TABfdate;
    public static javax.swing.JPanel TABfileType;
    public static javax.swing.JTabbedPane TABgen;
    public static javax.swing.JPanel TABlanguage;
    public static javax.swing.JPanel TABlookNfeel;
    public static javax.swing.JButton btn_confJSON;
    public static javax.swing.JButton btn_confTXT;
    public static javax.swing.JButton btn_confXML;
    public static javax.swing.JButton btn_currDolar;
    public static javax.swing.JButton btn_currEuro;
    public static javax.swing.JButton btn_currPound;
    public static javax.swing.JButton btn_galiza;
    public static javax.swing.JButton btn_spain;
    public static javax.swing.JButton btn_unitedk;
    public static javax.swing.JButton btn_valencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}