package co.udec.gerencial.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Consultas {
    
    
    /**
     * Agrega un vehículo digitado por el usuario en la base de datos.
     * @param conexion Conexión a la base de datos.
     * @param vehiculo Vehículo del usuario. Este tiene como caracteristicas una placa, una categoria y un saldo inicial.
     * @throws SQLException si la conexión a la base de datos es fallida.
     */
    public static void agregarVehiculo(Connection conexion, Vehiculo vehiculo) throws SQLException {
        String consulta;
        consulta = "INSERT INTO vehiculo(placa,categoria,saldo) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            
            ps.setString(1, vehiculo.getPlaca());
            ps.setInt(2, vehiculo.getCategoria());
            ps.setFloat(3, vehiculo.getSaldo());
            
            int n = ps.executeUpdate();
            if (n > 0) System.out.println("¡Vehículo agregado exitosamente!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    /**
     * Realiza el cobro a un vehículo que pasa por el peaje, teniendo en cuenta su placa.
     * @param conexion Conexión a la base de datos.
     * @param cobro Cobro realizado a un vehículo.
     * @throws SQLException si la conexión a la base de datos es fallida.
     */
    public static void cobrarTelepeaje(Connection conexion, CobroTelepeaje cobro) throws SQLException {
        //FECHA, ID Y HAY QUE GUARDAR LA CATEGORIA EN LA TABLA ESTA
        String consulta, cons;
        Calendar fecha = new GregorianCalendar();
        
        String fecha1 = fecha.get(Calendar.YEAR) + "-" + (fecha.get(Calendar.MONTH) + 1) + "-" + fecha.get(Calendar.DAY_OF_MONTH);
        consulta = "INSERT INTO cobrotelepeaje(valor, Vehiculo_placa, fechaCobro, categoriacarro) VALUES (?,?,?,?)";

        cons = "UPDATE vehiculo SET saldo = saldo - ? WHERE placa = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            PreparedStatement sp = conexion.prepareStatement(cons);
            
            ps.setFloat(1, cobro.getValorCT());
            ps.setString(2, cobro.getPlacacarro());
            ps.setString(3, fecha1);
            ps.setInt(4, cobro.getCategoria());
            
            sp.setFloat(1, cobro.getValorCT());
            sp.setString(2, cobro.getPlacacarro());
            
            ps.executeUpdate();
            sp.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 1: "+e.getMessage());
        }

    }
    
    /**
     * Realiza una recarga a un vehiculo por medio de su placa.
     * @param conexion Conexión a la base de datos.
     * @param recarga Valor recargado a un vehículo.
     */
    public static void recargarTelepeaje(Connection conexion, RecargaTelepeaje recarga) {
        String consulta, cons;
        Calendar fecha = new GregorianCalendar();
        
        String fecha1 = fecha.get(Calendar.YEAR) + "-" + (fecha.get(Calendar.MONTH) + 1) + "-" + fecha.get(Calendar.DAY_OF_MONTH);
        consulta = "INSERT INTO recargatelepeaje(valor,"
                + "Vehiculo_placa, fechaRecarga) VALUES (?,?,?)";
        cons = "UPDATE vehiculo SET saldo = saldo + ? WHERE placa = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            PreparedStatement sp = conexion.prepareStatement(cons);
            
            ps.setFloat(1, recarga.getValor());
            ps.setString(2, recarga.getPlacacarro());
            ps.setString(3, fecha1);
            
            sp.setFloat(1, recarga.getValor());
            sp.setString(2, recarga.getPlacacarro());
            
            ps.executeUpdate();
            sp.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 2: "+e.getMessage());
        }
        
    }
    
    /**
     * Retorna la cantidad de vehículos que existen por cada categoría.
     * @param conexion Conexión a la base de datos.
     * @return Cantidad de vehículos por categoría.
     */
    public static ArrayList<Vehiculo> busquedaVehiculo(Connection conexion) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        String consulta = "SELECT categoria, COUNT(placa) as placa FROM vehiculo GROUP BY categoria";
        try {
            
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vehiculos.add(new Vehiculo (rs.getString("placa"),rs.getInt("categoria")));
            }
            
            vehiculos.forEach((v) -> {
                System.out.println(v);
            });
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 3: "+e.getMessage());
        }
        return vehiculos;
    }
    
    /**
     * Retorna el saldo total existente por cada categoría de vehiculos.
     * @param conexion Conexión a la base de datos.
     * @return Saldo total existente por categoria.
     */
    public static ArrayList<Vehiculo> saldoPorCategoria(Connection conexion){        
        ArrayList<Vehiculo> saldoPorCategoria = new ArrayList<>();
        String consulta = "SELECT categoria, SUM(saldo) as saldo FROM vehiculo GROUP BY categoria";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                saldoPorCategoria.add(new Vehiculo(rs.getInt("categoria"), rs.getFloat("saldo")));
            }
            
            saldoPorCategoria.forEach((v) -> {
                System.out.println(v);
            });
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 4: "+e.getMessage());
        }
        
        return saldoPorCategoria;
    }
    
    /**
     * Retorna las 5 primeras fechas en las que se ha efectuado mayores recarga.
     * @param conexion Conexión a la base de datos.
     * @return Primeras 5 fechas de mayores recargas.
     */
    public static ArrayList<RecargaTelepeaje> fechasConMayorRecarga(Connection conexion){        
        ArrayList<RecargaTelepeaje> fechasRecargadas = new ArrayList<>();        
        String consulta = "SELECT fechaRecarga, SUM(valor) AS valor FROM recargatelepeaje GROUP BY fechaRecarga "+
                          "ORDER BY valor DESC LIMIT 5";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                fechasRecargadas.add(new RecargaTelepeaje(rs.getFloat("valor"), rs.getDate("fechaRecarga")));
            }
            
            fechasRecargadas.forEach((v) -> {
                System.out.println(v);
            });
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 5: "+e.getMessage());
        }
        
        return fechasRecargadas;
    }
    
    /**
     * Retorna la cantidad de dinero total que se ha recargado en una fecha.
     * @param conexion Conexión a la base de datos.
     * @param fecha Fecha en la que se hace el recargo.
     * @return Dinero total recargado en la fecha.
     */
    public static ArrayList<RecargaTelepeaje> cantidadRecargada(Connection conexion, String fecha){        
        ArrayList<RecargaTelepeaje> valorEnFecha = new ArrayList<>();
        String consulta = "SELECT fechaRecarga, SUM(valor) AS valor FROM recargatelepeaje "+
                          "WHERE fechaRecarga = "+fecha+" GROUP BY fechaRecarga";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                valorEnFecha.add(new RecargaTelepeaje(rs.getFloat("valor"), rs.getDate("fechaRecarga")));
            }
            
            valorEnFecha.forEach((v) -> {
                System.out.println(v);
            });
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 6: "+e.getMessage());
        }
        
        return valorEnFecha;       
    }
    
    /**
     * Retorna todo el dinero recaudado por el telepeaje hasta la fecha.
     * @param conexion Conexión a la base de datos.
     * @return Dinero total recaudado.
     */
    public static ArrayList<CobroTelepeaje> dineroTotalRecaudado(Connection conexion){
        ArrayList<CobroTelepeaje> valorRecaudado = new ArrayList<>();
        String consulta = "SELECT SUM(valor) AS valor FROM cobrotelepeaje";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                valorRecaudado.add(new CobroTelepeaje(rs.getFloat("valor")));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 7: "+e.getMessage());
        }
        
        return valorRecaudado;
    }
    
    /**
     * Retorna la cantidad de dinero recaudado en cada categoria por el telepeaje.
     * @param conexion Conexión a la base de datos.
     * @return Dinero recaudado por categoría.
     */
    public static ArrayList<CobroTelepeaje> dineroRecaudadoPorCategoria(Connection conexion){
        ArrayList<CobroTelepeaje> valorCategoria = new ArrayList<>();
        String consulta = "SELECT categoriacarro, SUM(valor) AS valor FROM cobrotelepeaje GROUP BY categoriacarro";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                valorCategoria.add(new CobroTelepeaje(rs.getInt("categoriacarro"), rs.getFloat("valor")));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 8: "+e.getMessage());
        }
        
        return valorCategoria;
    }
    
}
