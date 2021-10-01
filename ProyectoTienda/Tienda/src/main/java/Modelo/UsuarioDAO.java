package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class UsuarioDAO {
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conectar();
	PreparedStatement ps=null;
    ResultSet res=null;
    
    
    
    public boolean registroUsu(UsuarioDTO usu) {
    	boolean resultado=false;
    	try {
    		String sql="insert into usuarios(cedula,email,nombre,password) values(?,?,?,?)";
    	    ps=con.prepareStatement(sql);
    	    ps.setInt(1, usu.getCedula());
    	    ps.setString(2, usu.getEmail());
    	    ps.setString(3, usu.getNombre());
    	    ps.setString(4, usu.getPassword());
    	    resultado=ps.executeUpdate()>0;
    		
    	}catch(SQLException ex) {
    		resultado=false;
    	}
    	return resultado;
    }
    public boolean editarUsu(UsuarioDTO usuDto) {
    	boolean resultado=false;
    	try {
    	      String sql="update usuarios set email=?,nombre=?,password=? where cedula=?";	
    	      ps=con.prepareStatement(sql);
    	      ps.setString(1, usuDto.getEmail());
              ps.setString(2, usuDto.getNombre());
              ps.setString(3, usuDto.getPassword());
              ps.setInt(4, usuDto.getCedula());
              resultado=ps.executeUpdate()>0;
    	}catch(SQLException ex) {
    		resultado=false;
    	}
      return resultado;
    }
    public UsuarioDTO buscar(int cedula) {
    	UsuarioDTO usuDTO=null;
    	try {
    	String sql="select *from usuarios where cedula=?";
    	ps=con.prepareStatement(sql);
    	ps.setInt(1, cedula);
    	res=ps.executeQuery();
    	while(res.next()) {
    		usuDTO= new UsuarioDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
    	}
    	}catch(SQLException ex) {
    		JOptionPane.showMessageDialog(null,"error al buscar: "+ex);
    	}
    	return usuDTO;
    	
    }
    public boolean eliminar(int cedula) {
    	boolean resultado=false;
    	try {
    		String sql="delete from usuarios where cedula=?";
    	    ps=con.prepareStatement(sql);
    	    ps.setInt(1, cedula);
    	    resultado=ps.executeUpdate()>0;
    		
    	}catch(SQLException ex) {
    		resultado=false;
    	}
    	return resultado;
    }
}