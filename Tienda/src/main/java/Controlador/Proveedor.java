package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Proveedor
 */
@WebServlet("/Proveedor")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		 PrintWriter salida=response.getWriter();
			
		
		int nitProveedor;
		 String nombre, ciudad,direccion,telefono;
		 ProveedorDTO proveedorDTO=null;
		 ProveedorDAO proveedorDAO=new ProveedorDAO();
		 
		if(request.getParameter("Registro")!=null) {
			nitProveedor=Integer.parseInt(request.getParameter("nitProveedor"));
			proveedorDTO=proveedorDAO.buscar(nitProveedor);
			if(proveedorDTO==null) {
				nombre=request.getParameter("nombre");
				ciudad=request.getParameter("ciudad");
				direccion=request.getParameter("direccion");
				telefono=request.getParameter("telefono");

		        proveedorDTO=new ProveedorDTO(nitProveedor,nombre,ciudad,direccion,telefono);
				if(proveedorDAO.registroProveedor(proveedorDTO))
				{
					response.sendRedirect("Proveedor.jsp?men=Registro Exitoso");
				}
				else 
				{
					response.sendRedirect("Proveedor.jsp?men=Error el proveedor no se registro");
				}
			}
			else {
				response.sendRedirect("Proveedor.jsp?men=El nit de la empresa ya se encuentra registrado");
			}
	    }
		else if(request.getParameter("Buscar")!=null) {
			nitProveedor=Integer.parseInt(request.getParameter("nitProveedor1"));
			proveedorDTO=proveedorDAO.buscar(nitProveedor);
			if(proveedorDTO!=null) {
				nitProveedor=proveedorDTO.getNitProveedor();
				nombre=proveedorDTO.getNombre();
				ciudad=proveedorDTO.getCiudad();
				direccion=proveedorDTO.getDireccion();
				telefono=proveedorDTO.getTelefono();
				response.sendRedirect("Proveedor.jsp?nitProveedor="+nitProveedor+"&&nombre="+nombre+"&&ciudad="+ciudad+"&&direccion="+direccion+"&&telefono="+telefono);
			}else {
				response.sendRedirect("Proveedor.jsp?men=El proveedor no esta registrado");
			}
			
		}
		else if(request.getParameter("Actualizar")!=null) {
			nitProveedor=Integer.parseInt(request.getParameter("nitProveedor"));
			nombre=request.getParameter("nombre");
			ciudad=request.getParameter("ciudad");
			direccion=request.getParameter("direccion");
			telefono=request.getParameter("telefono");
			proveedorDTO=new ProveedorDTO(nitProveedor,nombre,ciudad,direccion,telefono);
			if(proveedorDAO.editarProveedor(proveedorDTO)) {
				response.sendRedirect("Proveedor.jsp?men=El proveedor fue actualizo correctamente");
			}
			else {
				response.sendRedirect("Proveedor.jsp?men=El proveedor no se actualizo");

			}
		}
		
		else if(request.getParameter("Eliminar")!=null) {
			nitProveedor=Integer.parseInt(request.getParameter("nitProveedor"));
			if(proveedorDAO.eliminar(nitProveedor)) {
				response.sendRedirect("Proveedor.jsp?men=El proveedor se elimino correctamente");
			}
			else {
				response.sendRedirect("Proveedor.jsp?men=El proveedor no se elimino");
			}
		}

 }
	
	
}