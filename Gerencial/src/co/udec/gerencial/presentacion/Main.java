package co.udec.gerencial.presentacion;

import co.udec.gerencial.logica.CobroTelepeaje;
import co.udec.gerencial.logica.ConectarDB;
import co.udec.gerencial.logica.Consultas;
import co.udec.gerencial.logica.RecargaTelepeaje;
import co.udec.gerencial.logica.Vehiculo;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    PanelNuevoCarro nuevo = new PanelNuevoCarro();
    PanelRecarga recarga = new PanelRecarga();
    PanelCobro cobro = new PanelCobro();

    ConectarDB conectaDB;
    public static Connection con;

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);

        this.add(nuevo);
        this.add(recarga);
        this.add(cobro);

        nuevo.setVisible(false);
        recarga.setVisible(false);
        cobro.setVisible(false);

        conectaDB = new ConectarDB();
        con = conectaDB.getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoCarro = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        recargar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        cobrar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        NumVehCategoria = new javax.swing.JMenuItem();
        SaldoPorCategoria = new javax.swing.JMenuItem();
        CantDineroRecaudoporCategoria = new javax.swing.JMenuItem();
        DineroRecargEnFecha = new javax.swing.JMenuItem();
        TotalRecaudo = new javax.swing.JMenuItem();
        DineroporCategoria = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(657, 465));
        setMinimumSize(new java.awt.Dimension(657, 465));
        setResizable(false);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.BorderLayout(50, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(207, 200, 200));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Telepeaje");
        container.add(jLabel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Nuevo");

        nuevoCarro.setText("Nuevo Carro");
        nuevoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoCarroActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoCarro);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Recargas");

        recargar.setText("Recargar");
        recargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarActionPerformed(evt);
            }
        });
        jMenu2.add(recargar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cobros");

        cobrar.setText("Realizar cobro");
        cobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrarActionPerformed(evt);
            }
        });
        jMenu3.add(cobrar);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Resultados");

        NumVehCategoria.setText("Número de vehículos por categoría");
        NumVehCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumVehCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(NumVehCategoria);

        SaldoPorCategoria.setText("Saldo por categoría");
        SaldoPorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoPorCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(SaldoPorCategoria);

        CantDineroRecaudoporCategoria.setText("Fechas con mayor recargas");
        CantDineroRecaudoporCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantDineroRecaudoporCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(CantDineroRecaudoporCategoria);

        DineroRecargEnFecha.setText("Dinero recargado en una fecha");
        DineroRecargEnFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineroRecargEnFechaActionPerformed(evt);
            }
        });
        jMenu4.add(DineroRecargEnFecha);

        TotalRecaudo.setText("Valor total recaudado por el peaje");
        TotalRecaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalRecaudoActionPerformed(evt);
            }
        });
        jMenu4.add(TotalRecaudo);

        DineroporCategoria.setText("Cantidad de dinero recaudada por categoria");
        DineroporCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineroporCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(DineroporCategoria);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoCarroActionPerformed
        container.removeAll();
        container.add(nuevo);
        container.repaint();

        nuevo.setVisible(true);
    }//GEN-LAST:event_nuevoCarroActionPerformed

    private void recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarActionPerformed
        container.removeAll();
        container.add(recarga);
        container.repaint();

        recarga.setVisible(true);
    }//GEN-LAST:event_recargarActionPerformed

    private void cobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrarActionPerformed
        container.removeAll();
        container.add(cobro);
        container.repaint();

        cobro.setVisible(true);
    }//GEN-LAST:event_cobrarActionPerformed

    private void NumVehCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumVehCategoriaActionPerformed

        JFreeChart chart;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos = Consultas.busquedaVehiculo(con);
        int tamaño = vehiculos.size();

        for (int i = 0; i < tamaño; i++) {
            dataset.addValue(Integer.parseInt(vehiculos.get(i).getPlaca()), "" + i, "" + vehiculos.get(i).getCategoria());
            System.out.println(""+vehiculos.get(i).getCategoria());
        }

        chart = ChartFactory.createBarChart3D(
                "Vehiculos por categoría", //titulo de la grafica
                "Categoría", //eje x
                "Cantidad de vehículos", //eje y
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );

        ChartFrame frame = new ChartFrame("Vehículos por categoría", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        int numeromenor , categoria = 0;
        numeromenor = Integer.parseInt(vehiculos.get(0).getPlaca());

        for (int i = 0; i < tamaño; i++) {
            if (Integer.parseInt(vehiculos.get(0).getPlaca()) <= numeromenor) {
                numeromenor = Integer.parseInt(vehiculos.get(i).getPlaca());
                categoria = vehiculos.get(i).getCategoria();
            }
        }
               
        JOptionPane.showMessageDialog(null, "la categoria "+categoria+" es la de menos capacidad", "Numero de vehiculo ", JOptionPane.DEFAULT_OPTION);


    }//GEN-LAST:event_NumVehCategoriaActionPerformed


    private void SaldoPorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoPorCategoriaActionPerformed

        JFreeChart chart;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos = Consultas.saldoPorCategoria(con);
        int tamaño = vehiculos.size();
        System.out.println("" + vehiculos);
        for (int i = 0; i < tamaño; i++) {
            dataset.addValue(vehiculos.get(i).getSaldo(), "" + i, "" + vehiculos.get(i).getCategoria());

        }
        chart = ChartFactory.createBarChart3D(
                "Saldo por categoría",
                "Categoría",
                "Saldo",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        ChartFrame frame = new ChartFrame("Saldo por categoría", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        float numeromenor ; 
        int categoria = 0;
        numeromenor = vehiculos.get(0).getSaldo();

        for (int i = 0; i < tamaño; i++) {
            if (vehiculos.get(0).getSaldo() <= numeromenor) {
                numeromenor = vehiculos.get(i).getSaldo();
                categoria = vehiculos.get(i).getCategoria();
            }
        }
               
        JOptionPane.showMessageDialog(null, "la categoria "+categoria+" es la de menor Saldo", "Saldo por categoria ", JOptionPane.DEFAULT_OPTION);
/*
        if (vehiculos.get(0).getSaldo() <= vehiculos.get(1).getSaldo()
                && vehiculos.get(0).getSaldo() <= vehiculos.get(2).getSaldo()) {
            JOptionPane.showMessageDialog(null, "Se debe implementar para tener mas saldos en categoria 1", "Saldo por categoria 1", JOptionPane.DEFAULT_OPTION);

        } else if (vehiculos.get(1).getSaldo() < vehiculos.get(0).getSaldo()
                && vehiculos.get(1).getSaldo() <= vehiculos.get(2).getSaldo()) {
            JOptionPane.showMessageDialog(null, "Se debe implementar para tener mas saldos en categoria 2", "Saldo por categoria 2", JOptionPane.DEFAULT_OPTION);
        } else if (vehiculos.get(2).getSaldo() < vehiculos.get(0).getSaldo()
                && vehiculos.get(2).getSaldo() <= vehiculos.get(1).getSaldo()) {
            JOptionPane.showMessageDialog(null, "Se debe implementar para tener mas saldos en categoria 3", "Saldo por categoria 3", JOptionPane.DEFAULT_OPTION);
        }*/
    }//GEN-LAST:event_SaldoPorCategoriaActionPerformed

    private void CantDineroRecaudoporCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantDineroRecaudoporCategoriaActionPerformed

        JFreeChart chart;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<RecargaTelepeaje> recargas = new ArrayList<>();

        recargas = Consultas.fechasConMayorRecarga(con);
        int tamaño = recargas.size();

        for (int i = 0; i < tamaño; i++) {
            dataset.addValue(recargas.get(i).getValor(), "" + i, "" + recargas.get(i).getFechaRecarga());

        }

        chart = ChartFactory.createBarChart3D(
                "Fechas con más recargas",
                "Fechas",
                "Valor de las recargas",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        ChartFrame frame = new ChartFrame("Fechas con más recargas", chart);
        frame.pack();
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        float numeromenor ; 
       // SimpleDateFormat fecharecarga = new SimpleDateFormat("yyyy-mm-dd");
        
        numeromenor = recargas.get(0).getValor();

        for (int i = 0; i < tamaño; i++) {
            if (recargas.get(0).getValor() <= numeromenor) {
                numeromenor = recargas.get(i).getValor();
               
            }
        }
               
        JOptionPane.showMessageDialog(null, "tener mas en cuenta las recargas , FECHAS BAJAS ", "Recargas ", JOptionPane.DEFAULT_OPTION);
       /*
        if (recargas.get(0).getValor() <= recargas.get(1).getValor()) {
            JOptionPane.showMessageDialog(null, "Se debe recargas mas en esta fecha", "Recargas 1", JOptionPane.DEFAULT_OPTION);

        } else if (recargas.get(1).getValor() < recargas.get(0).getValor()) {
            JOptionPane.showMessageDialog(null, "Revisar recarga fecha 2", "Saldo por categoria 2", JOptionPane.DEFAULT_OPTION);
        }*/
    }//GEN-LAST:event_CantDineroRecaudoporCategoriaActionPerformed

    private void DineroRecargEnFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DineroRecargEnFechaActionPerformed

        JFreeChart chart;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String fecha = javax.swing.JOptionPane.showInputDialog("Digite una fecha en formato aaaa-mm-dd: ");
        ArrayList<RecargaTelepeaje> recargas = new ArrayList<>();

        recargas = Consultas.cantidadRecargada(con, fecha);
        int tamaño = recargas.size();

        for (int i = 0; i < tamaño; i++) {
            dataset.addValue(recargas.get(i).getValor(), "" + i, "" + recargas.get(i).getFechaRecarga());

        }

        chart = ChartFactory.createBarChart3D(
                "Valor total recargado el " + fecha,
                "Fecha",
                "Valor total de recarga",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        ChartFrame frame = new ChartFrame("Valor total recargado el " + fecha, chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_DineroRecargEnFechaActionPerformed

    private void TotalRecaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalRecaudoActionPerformed

        JFreeChart chart;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        ArrayList<CobroTelepeaje> valor = new ArrayList<>();

        valor = Consultas.dineroTotalRecaudado(con);
        int tamaño = valor.size();

        for (int i = 0; i < tamaño; i++) {
            dataset.addValue(valor.get(i).getValorCT(), "" + i, "");

        }

        chart = ChartFactory.createBarChart3D(
                "Dinero total recaudado",
                "Cobro",
                "Dinero recaudado",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        ChartFrame frame = new ChartFrame("Dinero total recaudado", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        do {

            JOptionPane.showMessageDialog(null, "El saldo no es cero , SALDO ES: " + valor.get(0).getValorCT(), "SALDO TOTAL", JOptionPane.DEFAULT_OPTION);
        } while (!((valor.get(0).getValorCT()) > 0));


    }//GEN-LAST:event_TotalRecaudoActionPerformed

    private void DineroporCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DineroporCategoriaActionPerformed

        JFreeChart chart;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        ArrayList<CobroTelepeaje> valor = new ArrayList<>();

        valor = Consultas.dineroRecaudadoPorCategoria(con);
        int tamaño = valor.size();

        for (int i = 0; i < tamaño; i++) {
            dataset.addValue(valor.get(i).getValorCT(), "" + i, "" + valor.get(i).getCategoria());
        }

        chart = ChartFactory.createBarChart3D(
                "Dinero total recaudado por categoría",
                "Categoría",
                "Dinero recaudado",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        ChartFrame frame = new ChartFrame("Dinero total recaudado por categoría", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
          float numeromenor ; 
        int categoria = 0;
        numeromenor = valor.get(0).getValorCT();

        for (int i = 0; i < tamaño; i++) {
            if (valor.get(0).getValorCT() <= numeromenor) {
                numeromenor = valor.get(i).getValorCT();
                categoria = valor.get(i).getCategoria();
            }
        }
               
        JOptionPane.showMessageDialog(null, "la categoria "+categoria+" es la de menor Saldo", "Saldo por categoria ", JOptionPane.DEFAULT_OPTION);
/*
        if (valor.get(0).getValorCT() >= valor.get(1).getValorCT()
                && valor.get(0).getValorCT() >= valor.get(2).getValorCT()
                && valor.get(0).getValorCT() >= valor.get(3).getValorCT()
                && valor.get(0).getValorCT() >= valor.get(4).getValorCT()) {
            JOptionPane.showMessageDialog(null, "Categoria 1 mas alta en recaudo", "Saldo por categoria 1", JOptionPane.DEFAULT_OPTION);

        } else if (valor.get(1).getValorCT() > valor.get(0).getValorCT()
                && valor.get(1).getValorCT() >= valor.get(2).getValorCT()
                && valor.get(1).getValorCT() > valor.get(3).getValorCT()
                && valor.get(1).getValorCT() > valor.get(4).getValorCT()) {
            JOptionPane.showMessageDialog(null, "categoria 2  mas alta en recaudo", "Saldo por categoria 2", JOptionPane.DEFAULT_OPTION);

        } else if (valor.get(2).getValorCT() > valor.get(0).getValorCT()
                && valor.get(2).getValorCT() >= valor.get(1).getValorCT()
                && valor.get(2).getValorCT() > valor.get(3).getValorCT()
                && valor.get(2).getValorCT() > valor.get(4).getValorCT()) {
            JOptionPane.showMessageDialog(null, "Categoria 3 mas alta en recaudo", "Saldo por categoria 3", JOptionPane.DEFAULT_OPTION);

        } else if (valor.get(3).getValorCT() > valor.get(0).getValorCT()
                && valor.get(3).getValorCT() >= valor.get(1).getValorCT()
                && valor.get(3).getValorCT() > valor.get(2).getValorCT()
                && valor.get(3).getValorCT() > valor.get(4).getValorCT()) {
            JOptionPane.showMessageDialog(null, "Categoria 4 mas alta en recaudo", "Saldo por categoria 3", JOptionPane.DEFAULT_OPTION);

        } else if (valor.get(4).getValorCT() > valor.get(0).getValorCT()
                && valor.get(4).getValorCT() >= valor.get(1).getValorCT()
                && valor.get(4).getValorCT() > valor.get(2).getValorCT()
                && valor.get(4).getValorCT() > valor.get(3).getValorCT()) {
            JOptionPane.showMessageDialog(null, "Categoria 5 mas alta en recaudo", "Saldo por categoria 3", JOptionPane.DEFAULT_OPTION);

        }
*/
    }//GEN-LAST:event_DineroporCategoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CantDineroRecaudoporCategoria;
    private javax.swing.JMenuItem DineroRecargEnFecha;
    private javax.swing.JMenuItem DineroporCategoria;
    private javax.swing.JMenuItem NumVehCategoria;
    private javax.swing.JMenuItem SaldoPorCategoria;
    private javax.swing.JMenuItem TotalRecaudo;
    private javax.swing.JMenuItem cobrar;
    public static javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem nuevoCarro;
    private javax.swing.JMenuItem recargar;
    // End of variables declaration//GEN-END:variables
}
