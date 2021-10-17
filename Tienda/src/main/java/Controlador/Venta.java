package Controlador;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentaDAO;
import Modelo.VentaDTO;

/**
 * Servlet implementation class Venta
 */
@WebServlet("/Venta")
public class Venta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Venta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    double TotalVenta,TotalIva,TotalConIva, Iva1,Iva2,Iva3,Precio1,Precio2,Precio3,
	Costo1,Costo2 = 0,Costo3 = 0;
	int Cantidad1,Cantidad2,Cantidad3;
	int codigoProducto1,codigoProducto2,codigoProducto3;
	int cedulaCliente, cedulaUsuario;
	String nombreCliente;
	String nombreProducto3;
	double precioVenta3;
	String nombreUsuario;
	String nombreProducto1;
	double precioVenta1;
	String nombreProducto2;
	double precioVenta2;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		if (request.getParameter("calcular")!=null) {
			
			Cantidad1=Integer.parseInt(request.getParameter("cantidadp1"));
			Cantidad2=Integer.parseInt(request.getParameter("cantidadp2"));
			Cantidad3=Integer.parseInt(request.getParameter("cantidadp3"));
			
			codigoProducto1=Integer.parseInt(request.getParameter("cproducto1"));
			codigoProducto2=Integer.parseInt(request.getParameter("cproducto2"));
			codigoProducto3=Integer.parseInt(request.getParameter("cproducto3"));
			
			ProductoDAO conexionProducto= new ProductoDAO();
			ProductoDTO Pro1DTO= conexionProducto.buscar(codigoProducto1);
			Iva1=Pro1DTO.getIva();
			Precio1=Pro1DTO.getPrecioVenta();
			
			ProductoDTO Pro2DTO= conexionProducto.buscar(codigoProducto2);
			Iva2=Pro2DTO.getIva();
			Precio2=Pro2DTO.getPrecioVenta();
			
			ProductoDTO Pro3DTO= conexionProducto.buscar(codigoProducto3);
			Iva3=Pro3DTO.getIva();
			Precio3=Pro3DTO.getPrecioVenta();
			
			
			Costo1=Cantidad1*Precio1;
			Costo1=Cantidad2*Precio2;
			Costo1=Cantidad3*Precio3;
			
			TotalVenta=Costo1+Costo2+Costo3;
			TotalIva=(Costo1+Iva1)+(Costo2+Iva2)+(Costo3+Iva3);
			TotalConIva=TotalVenta+TotalIva;
			
			response.sendRedirect("Venta.jsp?totalventa="+ TotalVenta+"&&totaliva="+TotalIva+"&&totalconiva="+TotalConIva+"&&cproducto3="+codigoProducto3+"&&nombreProducto3="+nombreProducto3+"&&precioVenta3="+precioVenta3+"&&cproducto2="+codigoProducto2+"&&nombreProducto2="+nombreProducto2+"&&precioVenta2="+precioVenta2+"&&cproducto1="+codigoProducto1+"&&nombreProducto1="+nombreProducto1+"&&precioVenta1="+precioVenta1+"&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario+"&&cantidad2="+Cantidad2+"&&cantidad1="+Cantidad1+"&&cantidad3="+Cantidad3);
		}	
		
		
			//boton consulta usuario
			if (request.getParameter("Consultar_usuario")!=null) {
				
				
				
				UsuarioDAO conexionusuario= new UsuarioDAO();
				cedulaUsuario=Integer.parseInt(request.getParameter("cedula_usuario"));
				UsuarioDTO user=conexionusuario.buscar(cedulaUsuario);
				if (user!=null) {
					
					nombreUsuario=user.getNombre();
					
					response.sendRedirect("Venta.jsp?cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario);
					
					
				}else {
					response.sendRedirect("Venta.jsp?men=Usuario no existe. ");
				}
			}
			
	   
			
			//boton consulta cliente
			if (request.getParameter("Consultar_cliente")!=null) {
				
				
				String consec="1";
				
				ClienteDAO conexionclientes= new ClienteDAO();
				
				cedulaCliente=Integer.parseInt(request.getParameter("cedula_cliente"));
				ClienteDTO clien=conexionclientes.buscar(cedulaCliente);
				if (clien!=null) {
					nombreCliente=clien.getNombre();
					response.sendRedirect("Venta.jsp?cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario);
					
				}else {
					response.sendRedirect("Venta.jsp?men=Cliente no existe&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario);
				}
			}
			
				//boton consulta producto 1
				if (request.getParameter("Conproducto1")!=null) {
					
					
					
					ProductoDAO conexionproducto= new ProductoDAO();
					
					codigoProducto1=Integer.parseInt(request.getParameter("cproducto1"));
					ProductoDTO proDTO=conexionproducto.buscar(codigoProducto1);
					
					if (proDTO!=null) {
						nombreProducto1= proDTO.getNombre();
						precioVenta1=proDTO.getPrecioVenta();
						
						response.sendRedirect("Venta.jsp?cproducto1="+codigoProducto1+"&&nombreProducto1="+nombreProducto1+"&&precioVenta1="+precioVenta1+"&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario);
						
					}else {
						response.sendRedirect("Venta.jsp?men=El producto no Existe&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario);
						
					}
				}
				
				
				//boton consulta producto 2
				if (request.getParameter("Conproducto2")!=null) {
					
					
					ProductoDAO conexionproducto= new ProductoDAO();
					
					codigoProducto2=Integer.parseInt(request.getParameter("cproducto2"));
					Cantidad1=Integer.parseInt(request.getParameter("cantidadp1"));
					ProductoDTO proDTO=conexionproducto.buscar(codigoProducto2);
					
					if (proDTO!=null) {
						nombreProducto2= proDTO.getNombre();
						precioVenta2=proDTO.getPrecioVenta();
						
						response.sendRedirect("Venta.jsp?cproducto2="+codigoProducto2+"&&nombreProducto2="+nombreProducto2+"&&precioVenta2="+precioVenta2+"&&cproducto1="+codigoProducto1+"&&nombreProducto1="+nombreProducto1+"&&precioVenta1="+precioVenta1+"&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario+"&&cantidad1="+Cantidad1);
						
					}else {
						response.sendRedirect("Venta.jsp?men=El producto no Existe.&&cproducto1="+codigoProducto1+"&&nombreProducto1="+nombreProducto1+"&&precioVenta1="+precioVenta1+"&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario);
						
					}
				}
				
				
				//boton consulta producto 3
				if (request.getParameter("Conproducto3")!=null) {
				
					
					ProductoDAO conexionproducto= new ProductoDAO();
					
					Cantidad2=Integer.parseInt(request.getParameter("cantidadp2"));
					


					codigoProducto3=Integer.parseInt(request.getParameter("cproducto3"));
					ProductoDTO proDTO=conexionproducto.buscar(codigoProducto3);
					
					if (proDTO!=null) {
						nombreProducto3= proDTO.getNombre();
						precioVenta3=proDTO.getPrecioVenta();
						
						response.sendRedirect("Venta.jsp?cproducto3="+codigoProducto3+"&&nombreProducto3="+nombreProducto3+"&&precioVenta3="+precioVenta3+"&&cproducto2="+codigoProducto2+"&&nombreProducto2="+nombreProducto2+"&&precioVenta2="+precioVenta2+"&&cproducto1="+codigoProducto1+"&&nombreProducto1="+nombreProducto1+"&&precioVenta1="+precioVenta1+"&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario+"&&cantidad2="+Cantidad2+"&&cantidad1="+Cantidad1);
						
					}else {
						response.sendRedirect("Venta.jsp?men=El producto no Existe.&&cproducto2="+codigoProducto2+"&&nombreProducto2="+nombreProducto2+"&&precioVenta2="+precioVenta2+"&&cproducto1="+codigoProducto1+"&&nombreProducto1="+nombreProducto1+"&&precioVenta1="+precioVenta1+"&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario+"&&cantidad1="+Cantidad1);
						
					}
				}

				
				
				//boton de confirmar
				if (request.getParameter("confirmar") != null) {
					
					cedulaCliente=Integer.parseInt(request.getParameter("cedula_cliente"));
					 cedulaUsuario=Integer.parseInt(request.getParameter("cedula_usuario"));
					 codigoProducto1=Integer.parseInt(request.getParameter("cproducto1"));
					 codigoProducto2=Integer.parseInt(request.getParameter("cproducto2"));
					 codigoProducto3=Integer.parseInt(request.getParameter("cproducto3"));
					 Cantidad1=Integer.parseInt(request.getParameter("cantidadp1"));
					 Cantidad2=Integer.parseInt(request.getParameter("cantidadp2"));
					 Cantidad3=Integer.parseInt(request.getParameter("cantidadp2"));
					
					ProductoDAO ConexionProducto= new ProductoDAO();
					ProductoDTO prod1DTO= ConexionProducto.buscar(codigoProducto1);
					 Iva1=prod1DTO.getIva();
					 Precio1= prod1DTO.getPrecioCompra();
					
					ProductoDTO prod2DTO= ConexionProducto.buscar(codigoProducto2);
					 Iva2=prod2DTO.getIva();
					 Precio2= prod2DTO.getPrecioCompra();
					
					ProductoDTO prod3DTO= ConexionProducto.buscar(codigoProducto3);
					 Iva3=prod3DTO.getIva();
					 Precio3= prod3DTO.getPrecioCompra();
					
					
					Costo1=Cantidad1*Precio1;
					Costo2=Cantidad2*Precio2;
					Costo3=Cantidad3*Precio3;
					
					double valorVenta1=Costo1+(Costo1*Iva1/100);
					double valorVenta2=Costo2+(Costo2*Iva2/100);
					double valorVenta3=Costo3+(Costo3*Iva3/100);
					
					TotalVenta=Costo1+Costo2+Costo3;
					TotalIva=(Costo1+Iva1)+(Costo2+Iva2)+(Costo3+Iva3);
					TotalConIva=TotalVenta+TotalIva;
					
					VentaDTO ven= new VentaDTO(codigoProducto1,codigoProducto2,codigoProducto3,
							cedulaCliente,cedulaUsuario,TotalIva,TotalVenta,TotalConIva,
							Precio1,Precio2,Precio3,Costo1,Costo2,Costo3,Iva1,Iva2,Iva3,Cantidad1,Cantidad2,Cantidad3);
					VentaDAO vDAO= new VentaDAO();
					boolean r=vDAO.confirmar(ven);
					if(r) {
						Conexion cnn= new Conexion();
					    Connection con= cnn.Conectar();
					    PreparedStatement ps =null;
					    ResultSet res=null;
						
						
						try {
							 
							String sql= "select max(codigoVenta) from Grupo31_Equipo_6.ventas";
							ps=con.prepareStatement(sql);
							res=ps.executeQuery();
							int cventa=0;
							
							while (res.next()) {
								cventa=res.getInt(1);
								
							}
							con.close();
							response.sendRedirect("Venta.jsp?men=Se registro la venta el consecutivo es: "+cventa);
						} catch (Exception e) {
							response.sendRedirect("Venta.jsp?men=Factura no Registrada"+e);
						} 
					}
					else {
						response.sendRedirect("Venta.jsp?men=Factura no Registrada&&totalventa="+ TotalVenta+"&&totaliva="+TotalIva+"&&totalconiva="+TotalConIva+"&&cproducto3="+codigoProducto3+"&&nombreProducto3="+nombreProducto3+"&&precioVenta3="+precioVenta3+"&&cproducto2="+codigoProducto2+"&&nombreProducto2="+nombreProducto2+"&&precioVenta2="+precioVenta2+"&&cproducto1="+codigoProducto1+"&&nombreProducto1="+nombreProducto1+"&&precioVenta1="+precioVenta1+"&&cedula_cliente="+cedulaCliente+"&&nombre_cliente="+nombreCliente+"&&cedula_usuario="+cedulaUsuario+"&&nombreUsuario="+nombreUsuario+"&&cantidad2="+Cantidad2+"&&cantidad1="+Cantidad1+"&&cantidad3="+Cantidad3);

					}
					
				}
			
		
					
					
					
				
	
	}

}
