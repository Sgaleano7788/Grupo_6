package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;


/**
 * Servlet implementation class Cliente
 */
@WebServlet("/Cliente")
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		int cedula;
		
		String email;
		String nombre;
		String telefono;
		String direccion;
		ClienteDAO cliDAO = new ClienteDAO();
		
		
		ClienteDTO cliDTO=null;
		
		//REGISTRAR
		if(request.getParameter("Registro") !=null) { 
			cedula=Integer.parseInt(request.getParameter("cedula"));
			ClienteDTO clienteDTO=cliDAO.buscar(cedula);
			if(clienteDTO==null) {
				email=request.getParameter("email");
				nombre=request.getParameter("nombre");
				telefono=request.getParameter("telefono");
				direccion=request.getParameter("direccion");
				cliDTO= new ClienteDTO (cedula,direccion, email, nombre, telefono );
				if(cliDAO.registroCli(cliDTO))
				 {response.sendRedirect("Cliente.jsp?men=Registro Exitoso");
			}
				else { response.sendRedirect("Cliente.jsp?men=Error el cliante no se registro");
		}
				}
			else {
				response.sendRedirect("Cliente.jsp?men=El numero de la cedula ya se encuentra registrado");
			}
		}
		//BUSCAR
		else if (request.getParameter("Buscar")!=null) {
			cedula=Integer.parseInt(request.getParameter("cedula1"));
			ClienteDTO clienteDTO = cliDAO.buscar(cedula);
			if(clienteDTO!=null) {
				cedula=clienteDTO.getCedula();
				email=clienteDTO.getEmail();
				nombre=clienteDTO.getNombre();
				telefono=clienteDTO.getTelefono();
				direccion=clienteDTO.getDireccion();
				response.sendRedirect("Cliente.jsp?cedula="+cedula+"&&email="+email+"&&nombre="+nombre+"&&telefono="+telefono+"&&direccion="+direccion);
			}else {
				response.sendRedirect("Cliente.jsp?men=El cliente no existe");
			}
			
		}
				//ACTUALIZAR
				else if(request.getParameter("Actualizar")!=null) {
					cedula=Integer.parseInt(request.getParameter("cedula"));
					email=request.getParameter("email");
					nombre=request.getParameter("nombre");
					telefono=request.getParameter("telefono");
					direccion=request.getParameter("direccion");
					cliDTO=new ClienteDTO(cedula,direccion,email,nombre,telefono);
					if(cliDAO.editarCli(cliDTO)) {
						response.sendRedirect("Cliente.jsp?men=El cliente fue actualizado correctamente");
					}
					else {
						response.sendRedirect("Cliente.jsp?men=El cliente no fue actualizado");
					}
				}
				//ELIMINAR
				else if(request.getParameter("Eliminar")!=null) {
					cedula=Integer.parseInt(request.getParameter("cedula"));
					if(cliDAO.eliminar(cedula)) {
						response.sendRedirect("Cliente.jsp?men=El cliente se elimino correctamente");
					}
					else {
						response.sendRedirect("Cliente.jsp?men=El cliente no fue Eliminado");
							
		          }
			   }
	}

}
