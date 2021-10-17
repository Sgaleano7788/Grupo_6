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


import Modelo.VentaDAO;
import Modelo.VentaDTO;

/**
 * Servlet implementation class ReporteVentas
 */
@WebServlet("/ReporteVentas")
public class ReporteVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteVentas() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida=response.getWriter();
		Gson datos=new Gson();
		
		VentaDAO ventaDao=new VentaDAO();
		ArrayList<VentaDTO> lista=new ArrayList<VentaDTO>();
		lista=ventaDao.listar();
		salida.println(datos.toJson(lista));
	}

}
