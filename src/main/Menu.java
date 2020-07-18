 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import barang.BarangForm;
import database.ControlReport;
import database.Koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pembelian.PembelianForm;
import pembelian_item.PembelianItemForm;
import penjualan.PenjualanForm;
import penjualan_item.PenjualanItemForm;
import sales.SalesForm;
import supplier.SupplierForm;
import user.UserForm;

/**
 *
 * @author USER
 */
public class Menu extends javax.swing.JFrame {
    
    int waktumulai =0;
    static String s, b, c;
    ControlReport Report = new ControlReport();
    Koneksi koneksi = new Koneksi();
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();

        setLocationRelativeTo(null);
        setVisible(true);
        setTitle(" MENU ");
        aksesLogout();
        setExtendedState(MAXIMIZED_BOTH);
        lab.hide();
        
        ActionListener ac = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                s = lab.getText();
                b = s.substring(0, 1);
                c = s.substring(1, s.length());
                lab.setText(c + b);
            }
        };
        new javax.swing.Timer(300, ac).start();
        lab.show();
 
    
        new Thread(){
            @Override
            public void run(){
              while(waktumulai == 0){
                Calendar kalender = new GregorianCalendar();
                    int jam = kalender.get(Calendar.HOUR);
                    int menit = kalender.get(Calendar.MINUTE);
                    int detik = kalender.get(Calendar.SECOND);
                    int AM_PM = kalender.get(Calendar.AM_PM);
                    String siang_malam ="";
             if(AM_PM == 1){
                    siang_malam="PM"; 
             }else{
                    siang_malam = "AM";   
                  }
             String waktu = jam + ":" + menit + ":" + detik + " " + siang_malam;
             Datawaktu.setText(waktu);               
              }  
            }
        }.start();
    }

    public void aksesLogout() {
        DataMaster.setEnabled(false);
        DataTransaksi.setEnabled(false);
        DataPembelian.setEnabled(false);
        Datalaporan.setEnabled(false);
        Menulogout.setEnabled(false);
        MenuLogin.setEnabled(true);
    }
    
    public void reportBarang(){
      try {
            JasperReport report;
            JasperPrint print;
            JasperDesign design;
            HashMap parameters = new HashMap();
            parameters = null;
            Koneksi kon = new Koneksi();
            File file = new File("src\\report\\Barang.jrxml");

            design = JRXmlLoader.load(file);
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, parameters, koneksi.getkoneksi());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reportUser(){
      try {
            JasperReport report;
            JasperPrint print;
            JasperDesign design;
            HashMap parameters = new HashMap();
            parameters = null;
            Koneksi kon = new Koneksi();
            File file = new File("src\\report\\User.jrxml");

            design = JRXmlLoader.load(file);
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, parameters, koneksi.getkoneksi());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reportSupplier(){
      try {
            JasperReport report;
            JasperPrint print;
            JasperDesign design;
            HashMap parameters = new HashMap();
            parameters = null;
            Koneksi kon = new Koneksi();
            File file = new File("src\\report\\Supplier.jrxml");

            design = JRXmlLoader.load(file);
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, parameters, koneksi.getkoneksi());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void reportSales(){
      try {
            JasperReport report;
            JasperPrint print;
            JasperDesign design;
            HashMap parameters = new HashMap();
            parameters = null;
            Koneksi kon = new Koneksi();
            File file = new File("src\\report\\Sales.jrxml");

            design = JRXmlLoader.load(file);
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, parameters, koneksi.getkoneksi());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reportPenjualan(){
      try {
            JasperReport report;
            JasperPrint print;
            JasperDesign design;
            HashMap parameters = new HashMap();
            parameters = null;
            Koneksi kon = new Koneksi();
            File file = new File("src\\report\\Penjualan.jrxml");

            design = JRXmlLoader.load(file);
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, parameters, koneksi.getkoneksi());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reportPembelian(){
      try {
            JasperReport report;
            JasperPrint print;
            JasperDesign design;
            HashMap parameters = new HashMap();
            parameters = null;
            Koneksi kon = new Koneksi();
            File file = new File("src\\report\\Pembelian.jrxml");

            design = JRXmlLoader.load(file);
            report = JasperCompileManager.compileReport(design);
            print = JasperFillManager.fillReport(report, parameters, koneksi.getkoneksi());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lab = new javax.swing.JLabel();
        desktopPaneImage1 = new icon.DesktopPaneImage();
        time = new javax.swing.JMenuBar();
        Datawaktu = new javax.swing.JMenu();
        MenuAkses = new javax.swing.JMenu();
        MenuLogin = new javax.swing.JMenuItem();
        Menulogout = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        DataMaster = new javax.swing.JMenu();
        menuBarang = new javax.swing.JMenuItem();
        menuSuplier = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menusupplier = new javax.swing.JMenuItem();
        DataTransaksi = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        DataPembelian = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Datalaporan = new javax.swing.JMenu();
        MenuLaporanBrg = new javax.swing.JMenuItem();
        laporanUser = new javax.swing.JMenuItem();
        laporanSupplier = new javax.swing.JMenuItem();
        laporansales = new javax.swing.JMenuItem();
        laporanpenjualan = new javax.swing.JMenuItem();
        laporanpembelian = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lab.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        lab.setForeground(new java.awt.Color(255, 255, 255));
        lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab.setText("<< Selamat Datang Di Penjualan Laptop >> ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lab, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desktopPaneImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(desktopPaneImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
        );

        time.setBackground(new java.awt.Color(0, 204, 204));
        time.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Datawaktu.setBackground(new java.awt.Color(0, 204, 204));
        Datawaktu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Datawaktu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clock_48px.png"))); // NOI18N
        Datawaktu.setText("waktu");
        time.add(Datawaktu);

        MenuAkses.setBackground(new java.awt.Color(0, 204, 204));
        MenuAkses.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MenuAkses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home_48px.png"))); // NOI18N
        MenuAkses.setText("Akses");

        MenuLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MenuLogin.setBackground(new java.awt.Color(0, 204, 204));
        MenuLogin.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        MenuLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Password_24px.png"))); // NOI18N
        MenuLogin.setText("Login");
        MenuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLoginActionPerformed(evt);
            }
        });
        MenuAkses.add(MenuLogin);

        Menulogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        Menulogout.setBackground(new java.awt.Color(0, 204, 204));
        Menulogout.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        Menulogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Unlock_24px.png"))); // NOI18N
        Menulogout.setText("Logout");
        Menulogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenulogoutActionPerformed(evt);
            }
        });
        MenuAkses.add(Menulogout);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setBackground(new java.awt.Color(0, 204, 204));
        jMenuItem6.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Close Window_24px.png"))); // NOI18N
        jMenuItem6.setText("Exit");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        MenuAkses.add(jMenuItem6);

        time.add(MenuAkses);

        DataMaster.setBackground(new java.awt.Color(0, 204, 204));
        DataMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DataMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Folder_48px.png"))); // NOI18N
        DataMaster.setText("Data Master");

        menuBarang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        menuBarang.setBackground(new java.awt.Color(0, 204, 204));
        menuBarang.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        menuBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Empty Box_24px.png"))); // NOI18N
        menuBarang.setText("Data Barang");
        menuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarangActionPerformed(evt);
            }
        });
        DataMaster.add(menuBarang);

        menuSuplier.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSuplier.setBackground(new java.awt.Color(0, 204, 204));
        menuSuplier.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        menuSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delivery_24px.png"))); // NOI18N
        menuSuplier.setText("Data Sales");
        menuSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSuplierActionPerformed(evt);
            }
        });
        DataMaster.add(menuSuplier);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setBackground(new java.awt.Color(0, 204, 204));
        jMenuItem3.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Online Support_24px.png"))); // NOI18N
        jMenuItem3.setText("Data User");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        DataMaster.add(jMenuItem3);

        menusupplier.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menusupplier.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        menusupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Truck_24px.png"))); // NOI18N
        menusupplier.setText("Data Supplier");
        menusupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menusupplierActionPerformed(evt);
            }
        });
        DataMaster.add(menusupplier);

        time.add(DataMaster);

        DataTransaksi.setBackground(new java.awt.Color(0, 204, 204));
        DataTransaksi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DataTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Handshake_48px.png"))); // NOI18N
        DataTransaksi.setText("Transakasi Penjualan");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuItem1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MasterCard_24px.png"))); // NOI18N
        jMenuItem1.setText("penjualan");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        DataTransaksi.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setBackground(new java.awt.Color(0, 204, 204));
        jMenuItem2.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Buy_24px.png"))); // NOI18N
        jMenuItem2.setText("PenjualanItem");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        DataTransaksi.add(jMenuItem2);

        time.add(DataTransaksi);

        DataPembelian.setBackground(new java.awt.Color(0, 204, 204));
        DataPembelian.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DataPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Money Bag_48px.png"))); // NOI18N
        DataPembelian.setText("Transaksi Pebemlian");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MasterCard_24px.png"))); // NOI18N
        jMenuItem4.setText("pembelian");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        DataPembelian.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Buy_24px.png"))); // NOI18N
        jMenuItem5.setText("pembelianItem");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        DataPembelian.add(jMenuItem5);

        time.add(DataPembelian);

        Datalaporan.setBackground(new java.awt.Color(0, 204, 204));
        Datalaporan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Datalaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Document_48px.png"))); // NOI18N
        Datalaporan.setText("Laporan");

        MenuLaporanBrg.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        MenuLaporanBrg.setBackground(new java.awt.Color(0, 204, 204));
        MenuLaporanBrg.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        MenuLaporanBrg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics_24px.png"))); // NOI18N
        MenuLaporanBrg.setText("Laporan Barang");
        MenuLaporanBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLaporanBrgActionPerformed(evt);
            }
        });
        Datalaporan.add(MenuLaporanBrg);

        laporanUser.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        laporanUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics_24px.png"))); // NOI18N
        laporanUser.setText("Laporan User");
        laporanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanUserActionPerformed(evt);
            }
        });
        Datalaporan.add(laporanUser);

        laporanSupplier.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        laporanSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics_24px.png"))); // NOI18N
        laporanSupplier.setText("Laporan Supplier");
        laporanSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanSupplierActionPerformed(evt);
            }
        });
        Datalaporan.add(laporanSupplier);

        laporansales.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        laporansales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics_24px.png"))); // NOI18N
        laporansales.setText("Laporan Sales");
        laporansales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporansalesActionPerformed(evt);
            }
        });
        Datalaporan.add(laporansales);

        laporanpenjualan.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        laporanpenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics_24px.png"))); // NOI18N
        laporanpenjualan.setText("Laporan Penjualan");
        laporanpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanpenjualanActionPerformed(evt);
            }
        });
        Datalaporan.add(laporanpenjualan);

        laporanpembelian.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        laporanpembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics_24px.png"))); // NOI18N
        laporanpembelian.setText("Laporan Pembelian");
        laporanpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanpembelianActionPerformed(evt);
            }
        });
        Datalaporan.add(laporanpembelian);

        time.add(Datalaporan);
        time.add(jMenu1);

        setJMenuBar(time);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarangActionPerformed
        // TODO add your handling code here:
        new BarangForm().setVisible(true);
    }//GEN-LAST:event_menuBarangActionPerformed

    private void menuSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSuplierActionPerformed
        // TODO add your handling code here:
        new SalesForm().setVisible(true);
    }//GEN-LAST:event_menuSuplierActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new PenjualanItemForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new PenjualanForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new UserForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void MenuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLoginActionPerformed
        // TODO add your handling code here:
           new auth.AuthForm().setVisible(true);
           MenuAkses.setVisible(true);
    }//GEN-LAST:event_MenuLoginActionPerformed

    private void MenulogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenulogoutActionPerformed
        // TODO add your handling code here:
        aksesLogout();
    }//GEN-LAST:event_MenulogoutActionPerformed

    private void MenuLaporanBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLaporanBrgActionPerformed
        // TODO add your handling code here:
       reportBarang();
    }//GEN-LAST:event_MenuLaporanBrgActionPerformed

    private void menusupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menusupplierActionPerformed
        // TODO add your handling code here:
        new SupplierForm().setVisible(true);
    }//GEN-LAST:event_menusupplierActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        new PembelianForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new PembelianItemForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void laporanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanUserActionPerformed
        // TODO add your handling code here:
        reportUser();
    }//GEN-LAST:event_laporanUserActionPerformed

    private void laporanSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanSupplierActionPerformed
        // TODO add your handling code here:
        reportSupplier();
    }//GEN-LAST:event_laporanSupplierActionPerformed

    private void laporansalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporansalesActionPerformed
        // TODO add your handling code here:
        reportSales();
    }//GEN-LAST:event_laporansalesActionPerformed

    private void laporanpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanpenjualanActionPerformed
        // TODO add your handling code here:
        reportPenjualan();
    }//GEN-LAST:event_laporanpenjualanActionPerformed

    private void laporanpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanpembelianActionPerformed
        // TODO add your handling code here:
        reportPembelian();
    }//GEN-LAST:event_laporanpembelianActionPerformed
   
   
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Large-Font", "Java Swing", "");
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            new Menu().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu DataMaster;
    public static javax.swing.JMenu DataPembelian;
    public static javax.swing.JMenu DataTransaksi;
    public static javax.swing.JMenu Datalaporan;
    private javax.swing.JMenu Datawaktu;
    public static javax.swing.JMenu MenuAkses;
    private javax.swing.JMenuItem MenuLaporanBrg;
    public static javax.swing.JMenuItem MenuLogin;
    public static javax.swing.JMenuItem Menulogout;
    private icon.DesktopPaneImage desktopPaneImage1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lab;
    private javax.swing.JMenuItem laporanSupplier;
    private javax.swing.JMenuItem laporanUser;
    private javax.swing.JMenuItem laporanpembelian;
    private javax.swing.JMenuItem laporanpenjualan;
    private javax.swing.JMenuItem laporansales;
    private javax.swing.JMenuItem menuBarang;
    private javax.swing.JMenuItem menuSuplier;
    private javax.swing.JMenuItem menusupplier;
    private javax.swing.JMenuBar time;
    // End of variables declaration//GEN-END:variables
}
