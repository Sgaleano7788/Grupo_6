package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario, password;
		if(request.getParameter("enviar")!=null) {
			usuario=request.getParameter("Usuario");
			password=request.getParameter("Pass");
			if (usuario.equals("admininicial")&& password.equals("admin123456")) {
				response.sendRedirect("menu.jsp?men=Bienvenido Administrador");
			}else {
				response.sendRedirect("index.jsp?men=Datos incorrectos");
			}
		}
	}

}
