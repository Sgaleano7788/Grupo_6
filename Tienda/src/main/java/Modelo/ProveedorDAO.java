package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Controlador.Conexion;

public class ProveedorDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public ProveedorDTO buscar(int nitProveedor) {
		ProveedorDTO proveedorDTO=null;
		try {
			String sql="select nitProveedor,nombre,ciudad,direccion,telefono from proveedores where nitProveedor=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, nitProveedor);
			res=ps.executeQuery();
			while(res.next()) {
				proveedorDTO= new ProveedorDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
			con.close();
			}catch(SQLException ex) {
				proveedorDTO=null;
			}
		return proveedorDTO;
		
	}
	  public boolean registroProveedor(ProveedorDTO pro) {
		  Connection con=cnn.Conectar();
		  
	    	boolean resultado=false;
	    	try {
	    		String sql="insert into proveedores (nitProveedor,ciudad,direccion,nombre,telefono) values(?,?,?,?,?)";
	    	    ps=con.prepareStatement(sql);
	    	    ps.setInt(1, pro.getNitProveedor());
	    	    ps.setString(2, pro.getCiudad());
	    	    ps.setString(3, pro.getDireccion());
	    	    ps.setString(4, pro.getNombre());
	    	    ps.setString(5, pro.getTelefono());
	    	    resultado=ps.executeUpdate()>0;
	    	    con.close();
	    		
	    	}catch(SQLException ex) {
	    		resultado=false;
	    	}
	    	return resultado;    	
	    }
	  public boolean editarProveedor(ProveedorDTO proDTO) {
	    	boolean resultado=false;
	    	try {
	    	      String sql="update  proveedores set ciudad=?,direccion=?,nombre=?,telefono=? where nitProveedor=?";	
	    	      ps=con.prepareStatement(sql);
	    	      ps.setString(1, proDTO.getCiudad());
	              ps.setString(2, proDTO.getDireccion());
	              ps.setString(3, proDTO.getNombre());
	              ps.setString(4, proDTO.getTelefono());
	              ps.setInt(5, proDTO.getNitProveedor());
	              resultado=ps.executeUpdate()>0;
	              con.close();
	    	}catch(SQLException ex) {
	    		resultado=false;
	    	}
	      return resultado;
	    }
	  
	  public boolean eliminar(int nitProveedor) {
			boolean resultado=false;
			try {
				String sql="delete from proveedores where nitProveedor=?";
			    ps=con.prepareStatement(sql);
			    ps.setInt(1, nitProveedor);
			    resultado=ps.executeUpdate()>0;
				con.close();
			}catch(SQLException ex) {
				resultado=false;
			}
			return resultado;
		}

	
	
}
