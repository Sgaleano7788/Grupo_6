package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;

/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
@MultipartConfig
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
       int codigo,precioCompra,iva,precioVenta,cantidad,nitProveedor;
		
		String nombre;
		
		ProductoDAO productoDAO = new ProductoDAO();
		ProductoDTO productoDTO=null;

		
		//REGISTRAR
		if(request.getParameter("Registro")!=null) { 

				nombre=request.getParameter("nombre");
				precioCompra=Integer.parseInt(request.getParameter("precioCompra"));
				iva=Integer.parseInt(request.getParameter("iva"));
				precioVenta=Integer.parseInt(request.getParameter("precioVenta"));
				cantidad=Integer.parseInt(request.getParameter("cantidad"));
				nitProveedor=Integer.parseInt(request.getParameter("nitProveedor"));
				ProveedorDAO proveedorDAO=new ProveedorDAO();
				ProveedorDTO proveedorDTO=proveedorDAO.buscar(nitProveedor);
				if(proveedorDTO!=null) {
				
					productoDTO= new ProductoDTO (0,nombre,precioCompra,iva,precioVenta,cantidad,nitProveedor);
					
				if(productoDAO.registroProducto(productoDTO))
				 {
					response.sendRedirect("Producto.jsp?men=Registro Exitoso");
			     }
				else { 
					response.sendRedirect("Producto.jsp?men=Error el producto no se registro");
	                 }
				}
				else {
					response.sendRedirect("Producto.jsp?men=El nit del proveedor no esta registrado");
				}
				
				
		}
				//BUSCAR
				else if (request.getParameter("Buscar")!=null) {
					codigo=Integer.parseInt(request.getParameter("codigo1"));
					productoDTO = productoDAO.buscar(codigo);
					if(productoDTO!=null) {
						codigo=productoDTO.getCodigo();
						nombre=productoDTO.getNombre();
						precioCompra=productoDTO.getPrecioVenta();
						iva=productoDTO.getIva();
						precioVenta=productoDTO.getPrecioVenta();
						cantidad=productoDTO.getCantidad();
						nitProveedor=productoDTO.getNitProveedor();
						response.sendRedirect("Producto.jsp?codigo="+codigo+"&&nombre="+nombre+"&&precioCompra="+precioCompra+"&&iva="+iva+"&&precioVenta="+precioVenta+"&&cantidad="+cantidad+"&&nitProveedor="+nitProveedor);
					}else {
						response.sendRedirect("Producto.jsp?men=El producto no esta registrado");

				     	}
					}
						
				
				//ACTUALIZAR
				else if(request.getParameter("Actualizar")!=null) {
					codigo=Integer.parseInt(request.getParameter("codigo"));
					nombre=request.getParameter("nombre");
					precioCompra=Integer.parseInt(request.getParameter("precioCompra"));
					iva=Integer.parseInt(request.getParameter("iva"));
					precioVenta=Integer.parseInt(request.getParameter("precioVenta"));
					cantidad=Integer.parseInt(request.getParameter("cantidad"));
					nitProveedor=Integer.parseInt(request.getParameter("nitProveedor"));
					productoDTO=new ProductoDTO(codigo,nombre,precioCompra,iva,precioVenta,cantidad,nitProveedor);
					if(productoDAO.editarProducto(productoDTO)) {
						response.sendRedirect("Producto.jsp?men=El producto fue actualizado correctamente");
					}
					else {
						response.sendRedirect("Producto.jsp?men=El producto no fue actualizo");
					}
				}
				//ELIMINAR
				else if(request.getParameter("Eliminar")!=null) {
					codigo=Integer.parseInt(request.getParameter("codigo"));
					if(productoDAO.eliminar(codigo)) {
						response.sendRedirect("Producto.jsp?men=El producto se elimino correctamente");
					}
					else {
						response.sendRedirect("Producto.jsp?men=El producto no se elimino");
					
                   }
			    }
				else if(request.getParameter("Subir")!=null) {
					Part archivo=request.getPart("archivo");
					String Url="C:/Users/ASUS/eclipse-workspace/Tienda/src/main/webapp/DocumentosCSV/";
					String nom=archivo.getSubmittedFileName();

				    if(archivo.getContentType().equals("application/vnd.ms-excel")) {
						try {
					    		InputStream file=archivo.getInputStream();
					    		File copia=new File(Url+nom);
					    		FileOutputStream escribir=new FileOutputStream(copia);
					            int num=file.read();
					            while(num!=-1) {
					            	escribir.write(num);
					            	num=file.read();
					            }
					            escribir.close();
					            file.close();
					           if(productoDAO.cargarProductos(Url+nom)) {
					        	   response.sendRedirect("Producto.jsp?men=Productos registrados correctamente");
					           }
					           else {
					        	   response.sendRedirect("Producto.jsp?men=No se registraron los productos ERROR");
					           }

	
					    }
					    catch(Exception ex){
							response.sendRedirect("Producto.jsp?men=Error al cargar el Archivo"+ex);
	
					    }
				   }
				    else {
						response.sendRedirect("Producto.jsp?men=Formato de archivo no permitido");

				    }
				
				}
		         
		
		
	}

}
