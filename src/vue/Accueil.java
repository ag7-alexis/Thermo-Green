package vue;

import controleur.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import modele.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.date.DateUtilities;

/**
 * @author Alexis GUAY
 * @version 1.0.0 01/12/2019 -- Création
 */
public class Accueil extends javax.swing.JFrame {

    private final Main main;
    private ArrayList<Zone> lesZones;
    private ArrayList<Zone> listProvi;

    /**
     * Creates new form Accueil
     */
    public Accueil(Main link_main) {
        main = link_main;
        lesZones = main.getLesZones();
        listProvi = new ArrayList<>();

        for (Zone uneZone : lesZones) {
            listProvi.add(uneZone);
        }
        initComponents();

        B_ZoneA.setBackground(Color.green);
        B_ZoneB.setBackground(Color.green);
        B_ZoneC.setBackground(Color.green);
        B_ZoneD.setBackground(Color.green);

        DefaultTableModel tm = (DefaultTableModel) TableReleve.getModel();

        jSpinner_min.setValue(0);
        jSpinner_max.setValue(20);
        Choose_DateDeb.setDate(main.getDateActuelle());
        Choose_DateFin.setDate(main.getDateActuelle());

        initData(listProvi, Choose_DateDeb.getDate(), Choose_DateFin.getDate(), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString()));

    }

    private Accueil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableReleve = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Label_min = new javax.swing.JLabel();
        Label_max = new javax.swing.JLabel();
        Label_moyenne = new javax.swing.JLabel();
        panel_graph = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Label_alerte = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinner_min = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jSpinner_max = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        B_ZoneA = new javax.swing.JButton();
        B_ZoneB = new javax.swing.JButton();
        B_ZoneC = new javax.swing.JButton();
        B_ZoneD = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Button_24h = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Choose_DateDeb = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        Choose_DateFin = new com.toedter.calendar.JDateChooser();
        Button_rechercher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accueil Thermo Green");

        TableReleve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Heure", "Température"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableReleve);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Releve minimal : ");

        jLabel2.setText("Releve max : ");

        jLabel3.setText("Température moyenne : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_min))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_max))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_moyenne)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Label_min))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Label_max))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Label_moyenne))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_graph.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout panel_graphLayout = new javax.swing.GroupLayout(panel_graph);
        panel_graph.setLayout(panel_graphLayout);
        panel_graphLayout.setHorizontalGroup(
            panel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_graphLayout.setVerticalGroup(
            panel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Les alertes");

        jLabel5.setText("Alerte minima : ");

        jLabel6.setText("Alerte maximal : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner_min, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner_max, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Label_alerte, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinner_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label_alerte, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon("E:\\SLAM5\\guay_alexis\\doc\\img\\vinci.png")); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Choix des zones");

        B_ZoneA.setText("Zone A");
        B_ZoneA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ZoneAActionPerformed(evt);
            }
        });

        B_ZoneB.setText("Zone B");
        B_ZoneB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ZoneBActionPerformed(evt);
            }
        });

        B_ZoneC.setText("Zone C");
        B_ZoneC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ZoneCActionPerformed(evt);
            }
        });

        B_ZoneD.setText("Zone D");
        B_ZoneD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ZoneDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(B_ZoneB, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B_ZoneD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(B_ZoneA, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B_ZoneC, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_ZoneA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_ZoneC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_ZoneB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_ZoneD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Choix de la période");

        Button_24h.setText("24 dernières heures");
        Button_24h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_24hActionPerformed(evt);
            }
        });

        jLabel7.setText("Date debut : ");

        Choose_DateDeb.setDateFormatString("yyyy-MM-dd");

        jLabel8.setText("Date fin :");

        Choose_DateFin.setDateFormatString("yyyy-MM-dd");

        Button_rechercher.setText("Rechercher");
        Button_rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_rechercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(Button_24h)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Choose_DateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(Button_rechercher))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Choose_DateDeb, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Button_rechercher)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_24h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(Choose_DateDeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(Choose_DateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_graph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(114, 114, 114))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_graph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_ZoneDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ZoneDActionPerformed

        if (listProvi.contains(main.getZone("D"))) {
            listProvi.remove(main.getZone("D"));
            B_ZoneD.setBackground(Color.gray);
        } else {
            listProvi.add(main.getZone("D"));
            B_ZoneD.setBackground(Color.green);
        }
        initData(listProvi, Choose_DateDeb.getDate(), Choose_DateFin.getDate(), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString()));

    }//GEN-LAST:event_B_ZoneDActionPerformed

    private void B_ZoneAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ZoneAActionPerformed

        if (listProvi.contains(main.getZone("A"))) {
            listProvi.remove(main.getZone("A"));
            B_ZoneA.setBackground(Color.gray);
        } else {
            listProvi.add(main.getZone("A"));
            B_ZoneA.setBackground(Color.green);
        }

        initData(listProvi, Choose_DateDeb.getDate(), Choose_DateFin.getDate(), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString()));

    }//GEN-LAST:event_B_ZoneAActionPerformed

    private void B_ZoneCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ZoneCActionPerformed

        if (listProvi.contains(main.getZone("C"))) {
            listProvi.remove(main.getZone("C"));
            B_ZoneC.setBackground(Color.gray);
        } else {
            listProvi.add(main.getZone("C"));
            B_ZoneC.setBackground(Color.green);
        }
        initData(listProvi, Choose_DateDeb.getDate(), Choose_DateFin.getDate(), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString()));

    }//GEN-LAST:event_B_ZoneCActionPerformed

    private void Button_rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_rechercherActionPerformed

        initData(listProvi, Choose_DateDeb.getDate(), Choose_DateFin.getDate(), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString()));

    }//GEN-LAST:event_Button_rechercherActionPerformed

    private void Button_24hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_24hActionPerformed
        Choose_DateDeb.setDate(main.getDateActuelle());
        Choose_DateFin.setDate(main.getDateActuelle());

        initData(listProvi, Choose_DateDeb.getDate(), Choose_DateFin.getDate(), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString()));
    }//GEN-LAST:event_Button_24hActionPerformed

    private void B_ZoneBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ZoneBActionPerformed

        if (listProvi.contains(main.getZone("B"))) {
            listProvi.remove(main.getZone("B"));
            B_ZoneB.setBackground(Color.gray);
        } else {
            listProvi.add(main.getZone("B"));
            B_ZoneB.setBackground(Color.green);
        }

        initData(listProvi, Choose_DateDeb.getDate(), Choose_DateFin.getDate(), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString()));
    }//GEN-LAST:event_B_ZoneBActionPerformed

    public void initData(ArrayList<Zone> lesZones, Date dateMin, Date dateMax, Float alerteMin, Float alertMax) {
        if (lesZones.size() != 0) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList<Releve> Releves = new ArrayList<>();
            if (format.format(dateMin).equals(format.format(main.getDateActuelle())) && format.format(dateMax).equals(format.format(main.getDateActuelle()))) {
                Releves = main.getReleve(lesZones);
            } else {
                Releves = main.getReleve(lesZones, dateMin, dateMax);
            }

            DefaultTableModel tm = (DefaultTableModel) TableReleve.getModel();
            JTableHeader HEADER = TableReleve.getTableHeader();
            TableColumn tc = TableReleve.getColumnModel().getColumn(2);
            if (listProvi.size() < 2) {
                
                tc.setHeaderValue("température");
            }else{
                tc.setHeaderValue("température moyenne");
            }
            tm.setRowCount(0);

            ArrayList<ArrayList<Releve>> ListStats = new ArrayList<>();

            ListStats = main.getListStats(Releves);
            for (ArrayList<Releve> list : ListStats) {
                if (list.size() != 0) {
                    tm.addRow(new Object[]{list.get(0).getDate_relev(), list.get(0).getHeure_relev(), main.getMoyenneTemperature(list)});
                }
            }

            Label_min.setText(main.getMinTemperature(Releves).getTemp_relev() + "°c dans la zone " + main.getMinTemperature(Releves).getLaZone().getId_zone());
            Label_max.setText(main.getMaxTemperature(Releves).getTemp_relev() + "°c dans la zone " + main.getMaxTemperature(Releves).getLaZone().getId_zone());
            Label_moyenne.setText(main.getMoyenneTemperature(Releves) + "°c");

            Label_alerte.setText(main.getAlerte(main.getReleve(lesZones, dateMin, dateMax), new Float(jSpinner_min.getValue().toString()), new Float(jSpinner_max.getValue().toString())).size() + " alertes trouvé");

            
            creatGraph(main.getListStats(Releves));

            HEADER.repaint();
        }
    }

    public XYDataset createDataset(ArrayList<ArrayList<Releve>> lesReleves) {
        TimeSeriesCollection dataset = new TimeSeriesCollection();

        TimeSeries series = new TimeSeries("Température");
        for (ArrayList<Releve> list : lesReleves) {
            if (list.size() != 0) {
                series.add(new Hour(list.get(0).getHeure_relev(), new Day(list.get(0).getDate_relev())), main.getMoyenneTemperature(list));
            }
        }

        dataset.addSeries(series);

        return dataset;
    }

    public void creatGraph(ArrayList<ArrayList<Releve>> lesReleves) {

        XYDataset dataset = createDataset(lesReleves);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Evolution de la température",
                "Heures",
                "Températures",
                dataset,
                true, true, false);

        ChartPanel panel = new ChartPanel(chart);
        chart.getPlot().setBackgroundPaint(new ChartColor(220, 220, 220));

        panel_graph.setLayout(new java.awt.BorderLayout());
        panel_graph.add(panel, BorderLayout.CENTER);
        panel_graph.validate();

    }

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_ZoneA;
    private javax.swing.JButton B_ZoneB;
    private javax.swing.JButton B_ZoneC;
    private javax.swing.JButton B_ZoneD;
    private javax.swing.JButton Button_24h;
    private javax.swing.JButton Button_rechercher;
    private com.toedter.calendar.JDateChooser Choose_DateDeb;
    private com.toedter.calendar.JDateChooser Choose_DateFin;
    private javax.swing.JLabel Label_alerte;
    private javax.swing.JLabel Label_max;
    private javax.swing.JLabel Label_min;
    private javax.swing.JLabel Label_moyenne;
    private javax.swing.JTable TableReleve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_max;
    private javax.swing.JSpinner jSpinner_min;
    private javax.swing.JPanel panel_graph;
    // End of variables declaration//GEN-END:variables
}