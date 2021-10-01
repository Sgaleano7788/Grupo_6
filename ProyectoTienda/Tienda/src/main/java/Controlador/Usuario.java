package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter salida=response.getWriter();
		
		int cedula;
        String email, nombre, password;
		UsuarioDAO usuDAO=new UsuarioDAO();
		UsuarioDTO usuDTO=null;
       
		if(request.getParameter("Registro")!=null) {
			cedula=Integer.parseInt(request.getParameter("cedula"));
			UsuarioDTO usuarioDTO=usuDAO.buscar(cedula);
			if(usuarioDTO==null) {
				email=request.getParameter("email");
				nombre=request.getParameter("nombre");
				password=request.getParameter("password");
		        usuDTO=new UsuarioDTO(cedula,email,nombre,password);
				if(usuDAO.registroUsu(usuDTO))
				{
					response.sendRedirect("Usuario.jsp?men=Registro Exitoso");
				}
				else 
				{
					response.sendRedirect("Usuario.jsp?men=Error el usuario no se registro");
				}
			}
			else {
				response.sendRedirect("Usuario.jsp?men=El numero de la cedula ya se encuentra registrado");
			}
			
		}
		else if(request.getParameter("Buscar")!=null) {
			cedula=Integer.parseInt(request.getParameter("cedula1"));
			 UsuarioDTO usuarioDTO=usuDAO.buscar(cedula);
			if(usuarioDTO!=null) {
				cedula=usuarioDTO.getCedula();
				email=usuarioDTO.getEmail();
				nombre=usuarioDTO.getNombre();
				password=usuarioDTO.getPassword();
				response.sendRedirect("Usuario.jsp?cedula="+cedula+"&&email="+email+"&&nombre="+nombre+"&&password="+password);
			}else {
				salida.print("El usuario no esta registrado");
			}
		}
		else if(request.getParameter("Actualizar")!=null) {
			cedula=Integer.parseInt(request.getParameter("cedula"));
			email=request.getParameter("email");
			nombre=request.getParameter("nombre");
			password=request.getParameter("password");
			usuDTO=new UsuarioDTO(cedula,email,nombre,password);
			if(usuDAO.editarUsu(usuDTO)) {
				response.sendRedirect("Usuario.jsp?men=El usuario fue actualizo correctamente");
			}
			else {
				salida.print("El usuario no se actualizo");
			}
		}
		else if(request.getParameter("Eliminar")!=null) {
			cedula=Integer.parseInt(request.getParameter("cedula"));
			if(usuDAO.eliminar(cedula)) {
				response.sendRedirect("Usuario.jsp?men=El usuario se elimino correctamente");
			}
			else {
				salida.print("El usuario no se elimino");
			}
		}
	}

}
