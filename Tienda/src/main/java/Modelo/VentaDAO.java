package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class VentaDAO {

	Conexion cnn=new Conexion();
	Connection con=cnn.Conectar();
	PreparedStatement ps=null;
    ResultSet res=null;
    
    
    public ArrayList<VentaDTO> listar(){
    	ArrayList<VentaDTO> lista=new ArrayList<VentaDTO>();
    	VentaDTO ventaDto=null;
    	try {
    		String sql="select clientes.cedula, clientes.nombre, sum(totalVenta) ValorTotal  from ventas inner join clientes  on ventas.cedulaCliente=clientes.cedula group by ventas.cedulaCliente";
    		ps=con.prepareStatement(sql);
    		res=ps.executeQuery();
    		while(res.next()) {

    			
        		ventaDto=new VentaDTO(res.getInt(1), res.getString(2), res.getInt(3));
        		lista.add(ventaDto);
        	    
        	}
	
    	}catch(SQLException ex) {
    		JOptionPane.showMessageDialog(null,"error al buscar: "+ex);
    	}
    	return lista;
    }

	
	public boolean confirmar(VentaDTO p) {
		
		boolean resul=false;
		int cventa;
		try {
			String sql= "insert into ventas(cedulaCliente, cedulaUsuario, ivaVenta, totalVenta, valorVenta) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, p.getCedulaCliente());
			ps.setDouble(2, p.getCedulaUsuario());
			ps.setDouble(3, p.getTotalIva());
			ps.setDouble(4, p.getTotalVenta());
			ps.setDouble(5, p.getTotalConIva());
			resul= ps.executeUpdate()>0;

			if (resul) {
				sql="select max(codigoVenta) from tiendagenerica.ventas";
				ps=con.prepareStatement(sql);
				res=ps.executeQuery();
				cventa=0;
				while(res.next()) {
					cventa=res.getInt(1);
				}
				
				sql="insert into detalleventas(cantidadProducto, codigoProducto, codigoVenta, valorTotal, valorVenta, valorIva) values(?,?,?,?,?,?)";
				ps= con.prepareStatement(sql);
				ps.setFloat(1, p.getCantidad1());
				ps.setLong(2, p.getCodigoProducto1());
				ps.setLong(3, cventa);
				ps.setDouble(4, p.getValorProducto1());
				ps.setDouble(5, p.getValor_VentaDet1());
				ps.setDouble(6, p.getIvaProducto1());
				resul=ps.executeUpdate()>0;
				
				sql="insert into detalleventas(cantidadProducto, codigoProducto, codigoVenta, valorTotal, valorVenta, valorIva) values(?,?,?,?,?,?)";
				ps= con.prepareStatement(sql);
				ps.setFloat(1, p.getCantidad2());
				ps.setLong(2, p.getCodigoProducto2());
				ps.setLong(3, cventa);
				ps.setDouble(4, p.getValorProducto2());
				ps.setDouble(5, p.getValor_VentaDet2());
				ps.setDouble(6, p.getIvaProducto2());
				resul=ps.executeUpdate()>0;
				
				sql="insert into detalleventas(cantidadProducto, codigoProducto, codigoVenta, valorTotal, valorVenta, valorIva) values(?,?,?,?,?,?)";
				ps= con.prepareStatement(sql);
				ps.setFloat(1, p.getCantidad3());
				ps.setLong(2, p.getCodigoProducto3());
				ps.setLong(3, cventa);
				ps.setDouble(4, p.getValorProducto3());
				ps.setDouble(5, p.getValor_VentaDet3());
				ps.setDouble(6, p.getIvaProducto3());
				resul=ps.executeUpdate()>0;
				
			}
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al confirmar: "+ex);
		}
		
		return resul;
	}
}
