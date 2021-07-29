/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.wisata;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Admin extends javax.swing.JFrame {
    Connection con = null;
    Statement st = null;
    public String id_tiket = "";
    String jenis;
    Font fontBlack, fontDefault;
    DefaultTableModel modelTiket, modelPemesanan;
    
    String userLogin;
    String no;

    /**
     * Creates new form Admin
     */
    public Admin() {
        try {
            this.fontBlack = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Font/Montserrat_Black.ttf"));
            this.fontDefault = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Font/Montserrat.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        System.out.println("Admin");
        MySQLConnection DB = new MySQLConnection();
        DB.config();
        
        con = DB.con;
        st = DB.stm;
        
        panelTiket.setVisible(true);
        panelPemesanan.setVisible(false);
        // mengeset color warna bahwa layout beranda di select
        setColor(layoutTiket);
        
        modelTiket = new DefaultTableModel();
        this.tableTiket.setModel(modelTiket);
        modelTiket.addColumn("No");
        modelTiket.addColumn("Jenis Wisata");
        modelTiket.addColumn("Lokasi Wisata");
        modelTiket.addColumn("Harga");
        
        modelPemesanan = new DefaultTableModel();
        this.tablePemesanan.setModel(modelPemesanan);
        modelPemesanan.addColumn("Kode Tiket");
        modelPemesanan.addColumn("Nama Pelanggan");
        modelPemesanan.addColumn("Tanggal");
        modelPemesanan.addColumn("Jenis");
        modelPemesanan.addColumn("Lokasi");
        modelPemesanan.addColumn("Jumlah");
        modelPemesanan.addColumn("Total Harga");
        modelPemesanan.addColumn("Status Pembayaran");
        
        this.ambildataTiket();
    }
    
    private void ambildataTiket(){
        modelTiket.getDataVector().removeAllElements();
        modelTiket.fireTableDataChanged();
        try{
            String sql = "SELECT * FROM `tbwisata`";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Object[] obj = new Object[4];
                obj[0] = rs.getString("No");
                obj[1] = rs.getString("jenisWisata");
                obj[2] = rs.getString("namaWisata");
                obj[3] = rs.getString("harga");
                modelTiket.addRow(obj);
            }
            rs.close();
            stmt.close();
            ambiltiketKlik();
        }catch(SQLException e){
            System.out.println("Terjadi Kesalahan " + e.getMessage());
        }
    }
        
    private void ambiltiketKlik(){
        int i = this.tableTiket.getSelectedRow();
        if(i == -1){
            return;
        }
        
        String jns = (String) modelTiket.getValueAt(i, 1);
        this.textFieldJenisWisata.setText(jns);
        String lok = (String) modelTiket.getValueAt(i, 2);
        this.textFieldLokasiWisata.setText(lok);
        String hrg = (String) modelTiket.getValueAt(i, 3);
        this.textFieldHarga.setText(hrg);
    }
    
    private void ambildataPemesanan(){
        modelPemesanan.getDataVector().removeAllElements();
        modelPemesanan.fireTableDataChanged();
        try{
            String sql = "SELECT * FROM `tbtiket`";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Object[] obj = new Object[8];
                obj[0] = rs.getString("id_tiket");
                obj[1] = rs.getString("username");
                obj[2] = rs.getString("tanggal_tiket");
                obj[3] = rs.getString("jenis_tiket");
                obj[4] = rs.getString("lokasi_tiket");
                obj[5] = rs.getString("jumlah_tiket");
                obj[6] = rs.getString("total_harga");
                obj[7] = rs.getString("status_pembayaran");
                modelPemesanan.addRow(obj);
            }
            rs.close();
            stmt.close();
            
        }catch(SQLException e){
            System.out.println("Terjadi Kesalahan " + e.getMessage());
        }
    }
    
    void setColor(JPanel panel) {
        panel.setBackground(new Color(99, 123, 153));
    }
    void resetColor(JPanel panel) {
        panel.setBackground(new Color(7,39,64));
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundLayout = new javax.swing.JPanel();
        leftLayout = new javax.swing.JPanel();
        layoutTiket = new javax.swing.JPanel();
        leftBgWhiteTiket = new javax.swing.JPanel();
        titleTiket = new javax.swing.JLabel();
        layoutPemesanan = new javax.swing.JPanel();
        leftBgWhitePemesanan = new javax.swing.JPanel();
        titlePemesanan = new javax.swing.JLabel();
        layoutKeluar = new javax.swing.JPanel();
        leftBgWhiteKeluar = new javax.swing.JPanel();
        titleKeluar = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        subTitle = new javax.swing.JLabel();
        contentLayout = new javax.swing.JPanel();
        panelTiket = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTiket = new javax.swing.JTable();
        labelJenisWisata = new javax.swing.JLabel();
        textFieldJenisWisata = new javax.swing.JTextField();
        labelLokasi = new javax.swing.JLabel();
        textFieldLokasiWisata = new javax.swing.JTextField();
        labelHarga = new javax.swing.JLabel();
        textFieldHarga = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        panelPemesanan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePemesanan = new javax.swing.JTable();
        titleDataPemesanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        leftLayout.setBackground(new java.awt.Color(54, 79, 107));

        layoutTiket.setBackground(new java.awt.Color(7, 39, 64));
        layoutTiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                layoutTiketMousePressed(evt);
            }
        });
        layoutTiket.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftBgWhiteTiket.setOpaque(false);

        javax.swing.GroupLayout leftBgWhiteTiketLayout = new javax.swing.GroupLayout(leftBgWhiteTiket);
        leftBgWhiteTiket.setLayout(leftBgWhiteTiketLayout);
        leftBgWhiteTiketLayout.setHorizontalGroup(
            leftBgWhiteTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        leftBgWhiteTiketLayout.setVerticalGroup(
            leftBgWhiteTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        layoutTiket.add(leftBgWhiteTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        titleTiket.setFont(fontDefault.deriveFont(14f));
        titleTiket.setForeground(new java.awt.Color(255, 255, 255));
        titleTiket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTiket.setText("Tiket");
        layoutTiket.add(titleTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 40));

        layoutPemesanan.setBackground(new java.awt.Color(7, 39, 64));
        layoutPemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                layoutPemesananMousePressed(evt);
            }
        });
        layoutPemesanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftBgWhitePemesanan.setOpaque(false);

        javax.swing.GroupLayout leftBgWhitePemesananLayout = new javax.swing.GroupLayout(leftBgWhitePemesanan);
        leftBgWhitePemesanan.setLayout(leftBgWhitePemesananLayout);
        leftBgWhitePemesananLayout.setHorizontalGroup(
            leftBgWhitePemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        leftBgWhitePemesananLayout.setVerticalGroup(
            leftBgWhitePemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        layoutPemesanan.add(leftBgWhitePemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        titlePemesanan.setFont(fontDefault.deriveFont(14f));
        titlePemesanan.setForeground(new java.awt.Color(255, 255, 255));
        titlePemesanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePemesanan.setText("Pemesanan");
        layoutPemesanan.add(titlePemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 40));

        layoutKeluar.setBackground(new java.awt.Color(7, 39, 64));
        layoutKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                layoutKeluarMousePressed(evt);
            }
        });
        layoutKeluar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftBgWhiteKeluar.setOpaque(false);

        javax.swing.GroupLayout leftBgWhiteKeluarLayout = new javax.swing.GroupLayout(leftBgWhiteKeluar);
        leftBgWhiteKeluar.setLayout(leftBgWhiteKeluarLayout);
        leftBgWhiteKeluarLayout.setHorizontalGroup(
            leftBgWhiteKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        leftBgWhiteKeluarLayout.setVerticalGroup(
            leftBgWhiteKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        layoutKeluar.add(leftBgWhiteKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        titleKeluar.setFont(fontDefault.deriveFont(14f));
        titleKeluar.setForeground(new java.awt.Color(255, 255, 255));
        titleKeluar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleKeluar.setText("Keluar");
        layoutKeluar.add(titleKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 70, 40));

        title.setFont(fontBlack.deriveFont(32f));
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("MadeTick");

        subTitle.setFont(fontDefault.deriveFont(14f));
        subTitle.setForeground(new java.awt.Color(204, 204, 204));
        subTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitle.setText("Manji Destination Ticket");

        javax.swing.GroupLayout leftLayoutLayout = new javax.swing.GroupLayout(leftLayout);
        leftLayout.setLayout(leftLayoutLayout);
        leftLayoutLayout.setHorizontalGroup(
            leftLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layoutTiket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(layoutPemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(layoutKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftLayoutLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        leftLayoutLayout.setVerticalGroup(
            leftLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayoutLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(layoutTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layoutPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layoutKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTiket.setBackground(new java.awt.Color(245, 245, 245));

        tableTiket.setFont(fontDefault.deriveFont(14f));
        tableTiket.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTiketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTiket);

        labelJenisWisata.setFont(fontDefault.deriveFont(14f));
        labelJenisWisata.setText("Jenis Wisata");

        textFieldJenisWisata.setFont(fontDefault.deriveFont(14f));

        labelLokasi.setFont(fontDefault.deriveFont(14f));
        labelLokasi.setText("Lokasi wisata");

        textFieldLokasiWisata.setFont(fontDefault.deriveFont(14f));

        labelHarga.setFont(fontDefault.deriveFont(14f));
        labelHarga.setText("Harga");

        textFieldHarga.setFont(fontDefault.deriveFont(14f));
        textFieldHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldHargaKeyTyped(evt);
            }
        });

        btnTambah.setFont(fontDefault.deriveFont(12f));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setFont(fontDefault.deriveFont(12f));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setFont(fontDefault.deriveFont(12f));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTiketLayout = new javax.swing.GroupLayout(panelTiket);
        panelTiket.setLayout(panelTiketLayout);
        panelTiketLayout.setHorizontalGroup(
            panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiketLayout.createSequentialGroup()
                .addGroup(panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTiketLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
                    .addGroup(panelTiketLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelJenisWisata)
                            .addComponent(labelLokasi)
                            .addComponent(labelHarga))
                        .addGap(103, 103, 103)
                        .addGroup(panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldLokasiWisata, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldJenisWisata, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelTiketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTiketLayout.setVerticalGroup(
            panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiketLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJenisWisata, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldJenisWisata, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldLokasiWisata, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panelPemesanan.setBackground(new java.awt.Color(245, 245, 245));

        tablePemesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablePemesanan);

        titleDataPemesanan.setFont(fontBlack.deriveFont(24f));
        titleDataPemesanan.setForeground(new java.awt.Color(63, 193, 201));
        titleDataPemesanan.setText("Data Pemesanan");

        javax.swing.GroupLayout panelPemesananLayout = new javax.swing.GroupLayout(panelPemesanan);
        panelPemesanan.setLayout(panelPemesananLayout);
        panelPemesananLayout.setHorizontalGroup(
            panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPemesananLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleDataPemesanan)
                .addGap(259, 259, 259))
        );
        panelPemesananLayout.setVerticalGroup(
            panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPemesananLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleDataPemesanan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        javax.swing.GroupLayout contentLayoutLayout = new javax.swing.GroupLayout(contentLayout);
        contentLayout.setLayout(contentLayoutLayout);
        contentLayoutLayout.setHorizontalGroup(
            contentLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
            .addGroup(contentLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTiket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayoutLayout.setVerticalGroup(
            contentLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
            .addGroup(contentLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTiket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPemesanan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayoutLayout = new javax.swing.GroupLayout(backgroundLayout);
        backgroundLayout.setLayout(backgroundLayoutLayout);
        backgroundLayoutLayout.setHorizontalGroup(
            backgroundLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayoutLayout.createSequentialGroup()
                .addComponent(leftLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayoutLayout.setVerticalGroup(
            backgroundLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void layoutTiketMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_layoutTiketMousePressed
        setColor(layoutTiket);
        resetColor(layoutPemesanan);
        resetColor(layoutKeluar);
        resetColor(layoutKeluar);

        panelTiket.setVisible(true);
        panelPemesanan.setVisible(false);
        this.ambildataTiket();
    }//GEN-LAST:event_layoutTiketMousePressed

    private void layoutPemesananMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_layoutPemesananMousePressed
        setColor(layoutPemesanan);
        resetColor(layoutTiket);
        resetColor(layoutKeluar);
        resetColor(layoutKeluar);

        panelTiket.setVisible(false);
        panelPemesanan.setVisible(true);
        
        this.ambildataPemesanan();
    }//GEN-LAST:event_layoutPemesananMousePressed

    private void layoutKeluarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_layoutKeluarMousePressed
        setColor(layoutKeluar);
        resetColor(layoutTiket);
        resetColor(layoutPemesanan);
        
        int dialog = JOptionPane.showOptionDialog(this, "Apakah anda yakin ingin keluar?" , "Keluar", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        
        
        if (dialog == JOptionPane.OK_OPTION) {
            dispose();
            SignIn login = new SignIn();
            login.setVisible(true);
        } else {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_layoutKeluarMousePressed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if("Tambah".equals(this.btnTambah.getText())){
                this.btnTambah.setText("Simpan");
                this.btnEdit.setText("Batal");
                this.btnHapus.setEnabled(false);
                this.textFieldJenisWisata.setText("");
                this.textFieldLokasiWisata.setText("");
                this.textFieldHarga.setText("");
                this.textFieldJenisWisata.requestFocus();
        
        
        }else if ("Simpan".equals(this.btnTambah.getText())){
            Boolean isEmpyField = false; 
            String jenis = textFieldJenisWisata.getText();
            String lokasi = textFieldLokasiWisata.getText();
            String harga = textFieldHarga.getText();
           
            if (jenis.isEmpty()) {
                isEmpyField = true;
                textFieldJenisWisata.requestFocus();
            } else if (lokasi.isEmpty()) {
                isEmpyField = true;
                textFieldLokasiWisata.requestFocus();
            }else if (harga.isEmpty()){
                isEmpyField = true;
                textFieldHarga.requestFocus();
            }

            if (!isEmpyField) {
                
                String sqlkode = "INSERT INTO `tbwisata`(`jenisWisata`, `namaWisata`, `harga`) "
                      + "values ('" + this.textFieldJenisWisata.getText() + "',"
                      + "'" + this.textFieldLokasiWisata.getText() + "',"    
                      + "'" + this.textFieldHarga.getText() + "')";
                try{
                    PreparedStatement p2 = (PreparedStatement) con.prepareStatement(sqlkode);
                    p2.executeUpdate();
                    p2.close();
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(this, "Terjadi Kesalahan" + ex.getMessage());
                }
            
                this.textFieldJenisWisata.setText("");
                this.textFieldLokasiWisata.setText("");
                this.textFieldHarga.setText("");
                this.btnTambah.setText("Tambah");
                this.btnEdit.setText("Edit");
                this.btnHapus.setEnabled(true);
            
            this.ambildataTiket();
                JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
            } else {
                JOptionPane.showMessageDialog(null, "Inputan tidak boleh ada yang kosong");
            }
        } else if ("Update".equals(this.btnTambah.getText())){
                Boolean isEmpyField = false; 
                String jenis = textFieldJenisWisata.getText();
                String lokasi = textFieldLokasiWisata.getText();
                String harga = textFieldHarga.getText();
           
                if (jenis.isEmpty()) {
                    isEmpyField = true;
                    textFieldJenisWisata.requestFocus();
                } else if (lokasi.isEmpty()) {
                    isEmpyField = true;
                    textFieldLokasiWisata.requestFocus();
                }else if (harga.isEmpty()){
                    isEmpyField = true;
                    textFieldHarga.requestFocus();
                }

                if (!isEmpyField) {
                
                String sqlkode = "UPDATE `tbwisata` SET `jenisWisata`='" + this.textFieldJenisWisata.getText() + "',"
                        + "`namaWisata`='" + this.textFieldLokasiWisata.getText() + "',"
                        + "`harga`='" + this.textFieldHarga.getText() + "' "
                        + "WHERE namaWisata ='" + this.textFieldLokasiWisata.getText() + "'";
                    try{
                        PreparedStatement p2 = (PreparedStatement) con.prepareStatement(sqlkode);
                        p2.executeUpdate();
                        p2.close();
                    }catch (SQLException ex){
                        JOptionPane.showMessageDialog(this, "Terjadi Kesalahan" + ex.getMessage());
                    }
                this.textFieldJenisWisata.setText("");
                this.textFieldLokasiWisata.setText("");
                this.textFieldHarga.setText("");
                this.btnTambah.setText("Tambah");
                this.btnEdit.setText("Edit");
                this.btnHapus.setEnabled(true);
                
                this.ambildataTiket();
                    JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
                } else {
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh ada yang kosong");
            }
            }
                
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if("Edit".equals(this.btnEdit.getText())){
            this.btnTambah.setText("Update");
            this.btnEdit.setText("Batal");
            this.btnHapus.setEnabled(false);
            this.textFieldJenisWisata.requestFocus();
           
        }else if("Batal".equals(this.btnEdit.getText())){
            this.textFieldJenisWisata.setText("");
            this.textFieldLokasiWisata.setText("");
            this.textFieldHarga.setText("");
            this.btnTambah.setText("Tambah");
            this.btnEdit.setText("Edit");
            this.btnHapus.setEnabled(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String sqlkode = "DELETE FROM `tbwisata` " 
                    + "WHERE namawisata ='" + this.textFieldLokasiWisata.getText() + "'";
                try{
                    PreparedStatement p2 = (PreparedStatement) con.prepareStatement(sqlkode);
                    p2.executeUpdate();
                    p2.close();
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(this, "Terjadi Kesalahan" + ex.getMessage());
                }
            
        this.textFieldJenisWisata.setText("");
        this.textFieldLokasiWisata.setText("");
        this.textFieldHarga.setText("");
            
        this.ambildataTiket();
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tableTiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTiketMouseClicked
        // TODO add your handling code here:
        this.textFieldJenisWisata.requestFocus();
        this.ambiltiketKlik();
    }//GEN-LAST:event_tableTiketMouseClicked

    private void textFieldHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldHargaKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        
        if (!Character.isDigit(a))
            evt.consume();
    }//GEN-LAST:event_textFieldHargaKeyTyped

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundLayout;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JPanel contentLayout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelJenisWisata;
    private javax.swing.JLabel labelLokasi;
    private javax.swing.JPanel layoutKeluar;
    private javax.swing.JPanel layoutPemesanan;
    private javax.swing.JPanel layoutTiket;
    private javax.swing.JPanel leftBgWhiteKeluar;
    private javax.swing.JPanel leftBgWhitePemesanan;
    private javax.swing.JPanel leftBgWhiteTiket;
    private javax.swing.JPanel leftLayout;
    private javax.swing.JPanel panelPemesanan;
    private javax.swing.JPanel panelTiket;
    private javax.swing.JLabel subTitle;
    private javax.swing.JTable tablePemesanan;
    private javax.swing.JTable tableTiket;
    private javax.swing.JTextField textFieldHarga;
    private javax.swing.JTextField textFieldJenisWisata;
    private javax.swing.JTextField textFieldLokasiWisata;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleDataPemesanan;
    private javax.swing.JLabel titleKeluar;
    private javax.swing.JLabel titlePemesanan;
    private javax.swing.JLabel titleTiket;
    // End of variables declaration//GEN-END:variables
}
