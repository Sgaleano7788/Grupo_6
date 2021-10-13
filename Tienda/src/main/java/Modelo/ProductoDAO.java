package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProductoDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public ProductoDTO buscar(int codigo) {
		ProductoDTO productoDTO=null;
		try {
			String sql="select codigoProducto,nombre,precioCompra,ivaCompra,precioVenta, cantidad,nitProveedor from productos where codigoProducto=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, codigo);
			res=ps.executeQuery();
			while(res.next()) {
				productoDTO= new ProductoDTO(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6),res.getInt(7));
			}
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"error al buscar: "+ex);
			}
		return productoDTO;
		
	}
	 public boolean registroProducto(ProductoDTO pro) {
	    	
	    	boolean resultado=false;
	    	try {
	    		String sql="insert into productos (nombre,precioCompra,ivaCompra,precioVenta,cantidad,nitProveedor) values(?,?,?,?,?,?)";
	    	    ps=con.prepareStatement(sql);
	    	    ps.setString(1, pro.getNombre());
	    	    ps.setInt(2, pro.getPrecioCompra());
	    	    ps.setInt(3, pro.getIva());
	    	    ps.setInt(4, pro.getPrecioVenta());
	    	    ps.setInt(5, pro.getCantidad());
	    	    ps.setInt(6, pro.getNitProveedor());
	    	    resultado=ps.executeUpdate()>0;
	    		
	    	}catch(SQLException ex) {
	    		resultado=false;
	    	}
	    	return resultado;    	
	    }
	  public boolean editarProducto(ProductoDTO productoDTO) {
	    	boolean resultado=false;
	    	try {
	    	      String sql="update  productos set nombre=?,precioCompra=?,ivaCompra=?,precioVenta=?,cantidad=?,nitProveedor=? where codigoProducto=?";	
	    	      ps=con.prepareStatement(sql);
	    	      ps.setString(1, productoDTO.getNombre());
	              ps.setInt(2, productoDTO.getPrecioCompra());
	              ps.setInt(3, productoDTO.getIva());
	              ps.setInt(4, productoDTO.getPrecioVenta());
	              ps.setInt(5, productoDTO.getCantidad());
	              ps.setInt(6, productoDTO.getNitProveedor());
	              ps.setInt(7, productoDTO.getCodigo());
	              resultado=ps.executeUpdate()>0;
	    	}catch(SQLException ex) {
	    		resultado=false;
	    	}
	      return resultado;
	    }
	  
	  public boolean eliminar(int codigo) {
			boolean resultado=false;
			try {
				String sql="delete from productos where codigoProducto=?";
			    ps=con.prepareStatement(sql);
			    ps.setInt(1, codigo);
			    resultado=ps.executeUpdate()>0;
				
			}catch(SQLException ex) {
				resultado=false;
			}
			return resultado;
		}
	  public boolean cargarProductos(String url) {
		  boolean resultado=false;
		  try {
				String sql="load data infile '"+url+"' into table productos fields terminated by ',' lines terminated by '\n'";
			    ps=con.prepareStatement(sql);
			    resultado=ps.executeUpdate()>0;
				
			}catch(SQLException ex) {
		
				resultado=false;
			}
		  return resultado;
	  }

	
}
