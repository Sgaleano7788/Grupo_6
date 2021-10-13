package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;



/**
 * Servlet implementation class ReporteClientes
 */
@WebServlet("/ReporteClientes")
public class ReporteClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteClientes() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter salida=response.getWriter();
		Gson datos=new Gson();
		
		ClienteDAO clienteDao=new ClienteDAO();
		ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
		lista=clienteDao.listar();
		salida.println(datos.toJson(lista));	
	
	}

}
