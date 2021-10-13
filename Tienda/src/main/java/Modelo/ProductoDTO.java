package Modelo;

public class ProductoDTO {
	
	private int codigo;
	private String nombre;
	private int precioCompra;
	private int iva;
	private int precioVenta;
	private int cantidad;
	private int nitProveedor;
	
	
	
	public ProductoDTO(int codigo, String nombre, int precioCompra, int iva, int precioVenta, int cantidad,
			int nitProveedor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.iva = iva;
		this.precioVenta = precioVenta;
		this.cantidad = cantidad;
		this.nitProveedor = nitProveedor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	
	

}
