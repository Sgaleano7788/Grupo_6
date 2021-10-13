package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ClienteDAO {
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps=null;
	ResultSet res=null;

//REGISTRO
	  public boolean registroCli(ClienteDTO cli) {
	    	
	    	boolean resultado=false;
	    	try {
	    		String sql="insert into clientes (cedula,email,nombre,telefono,direccion) values(?,?,?,?,?)";
	    	    ps=con.prepareStatement(sql);
	    	    ps.setInt(1, cli.getCedula());
	    	    ps.setString(2, cli.getEmail());
	    	    ps.setString(3, cli.getNombre());
	    	    ps.setString(4, cli.getTelefono());
	    	    ps.setString(5, cli.getDireccion());
	    	    resultado=ps.executeUpdate()>0;
	    		
	    	}catch(SQLException ex) {
	    		resultado=false;
	    	}
	    	return resultado;    	
	    }

//EDITAR
	   public boolean editarCli(ClienteDTO cliDto) {
	    	boolean resultado=false;
	    	try {
	    	      String sql="update clientes set email=?,nombre=?,telefono=?,direccion=? where cedula=?";	
	    	      ps=con.prepareStatement(sql);
	    	      ps.setString(1, cliDto.getEmail());
	              ps.setString(2, cliDto.getNombre());
	              ps.setString(3, cliDto.getTelefono());
	              ps.setString(4, cliDto.getDireccion());
	              ps.setInt(5, cliDto.getCedula());
	              resultado=ps.executeUpdate()>0;
	    	}catch(SQLException ex) {
	    		resultado=false;
	    	}
	      return resultado;
	    }
	    
//BUSCAR
public ClienteDTO buscar(int cedula) {
	ClienteDTO cliDTO=null;
	try {
	String sql="select *from clientes where cedula=?";
	ps=con.prepareStatement(sql);
	ps.setInt(1, cedula);
	res=ps.executeQuery();
	while(res.next()) {
		cliDTO= new ClienteDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
	}
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"error al buscar: "+ex);
	}
	return cliDTO;
}

//ELIMINAR
public boolean eliminar(int cedula) {
	boolean resultado=false;
	try {
		String sql="delete from clientes where cedula=?";
	    ps=con.prepareStatement(sql);
	    ps.setInt(1, cedula);
	    resultado=ps.executeUpdate()>0;
		
	}catch(SQLException ex) {
		resultado=false;
	}
	return resultado;
}

public ArrayList<ClienteDTO> listar(){
	ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
	ClienteDTO clienteDto=null;
	try {
		String sql="select *from clientes";
		ps=con.prepareStatement(sql);
		res=ps.executeQuery();
		while(res.next()) {
			clienteDto= new ClienteDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			lista.add(clienteDto);
    	}
		
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"error al buscar: "+ex);
	}
	return lista;
}
}
