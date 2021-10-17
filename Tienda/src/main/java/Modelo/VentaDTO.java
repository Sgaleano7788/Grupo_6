package Modelo;

public class VentaDTO {

	private int cedula;
	private String Nombre;
	private int TotalVentas;
	
	int CodigoProducto1,CodigoProducto2,CodigoProducto3;
	int CedulaCliente,CedulaUsuario;
	Double TotalIva, TotalVenta, TotalConIva,ValorProducto1,ValorProducto2,ValorProducto3,Valor_VentaDet1,Valor_VentaDet2,Valor_VentaDet3,
	IvaProducto1,IvaProducto2,IvaProducto3;
	int Cantidad1,Cantidad2,Cantidad3;
	public VentaDTO(int codigoProducto1, int codigoProducto2, int codigoProducto3, int cedulaCliente, int cedulaUsuario, Double totalIva, Double totalVenta, Double totalConIva, Double valorProducto1,Double valorProducto2, Double valorProducto3, Double valor_VentaDet1, Double valor_VentaDet2,Double valor_VentaDet3, Double ivaProducto1, Double ivaProducto2, Double ivaProducto3, int cantidad1, int cantidad2, int cantidad3) {
		super();
		CodigoProducto1 = codigoProducto1;
		CodigoProducto2 = codigoProducto2;
		CodigoProducto3 = codigoProducto3;
		CedulaCliente = cedulaCliente;
		CedulaUsuario = cedulaUsuario;
		TotalIva = totalIva;
		TotalVenta = totalVenta;
		TotalConIva = totalConIva;
		ValorProducto1 = valorProducto1;
		ValorProducto2 = valorProducto2;
		ValorProducto3 = valorProducto3;
		Valor_VentaDet1 = valor_VentaDet1;
		Valor_VentaDet2 = valor_VentaDet2;
		Valor_VentaDet3 = valor_VentaDet3;
		IvaProducto1 = ivaProducto1;
		IvaProducto2 = ivaProducto2;
		IvaProducto3 = ivaProducto3;
		Cantidad1 = cantidad1;
		Cantidad2 = cantidad2;
		Cantidad3 = cantidad3;
	}
	public long getCodigoProducto1() {
		return CodigoProducto1;
	}
	public void setCodigoProducto1(int codigoProducto1) {
		CodigoProducto1 = codigoProducto1;
	}
	public long getCodigoProducto2() {
		return CodigoProducto2;
	}
	public void setCodigoProducto2(int codigoProducto2) {
		CodigoProducto2 = codigoProducto2;
	}
	public long getCodigoProducto3() {
		return CodigoProducto3;
	}
	public void setCodigoProducto3(int codigoProducto3) {
		CodigoProducto3 = codigoProducto3;
	}
	public int getCedulaCliente() {
		return CedulaCliente;
	}
	public void setCedulaCliente(int cedulaCliente) {
		CedulaCliente = cedulaCliente;
	}
	public int getCedulaUsuario() {
		return CedulaUsuario;
	}
	public void setCedulaUsuario(int cedulaUsuario) {
		CedulaUsuario = cedulaUsuario;
	}
	public Double getTotalIva() {
		return TotalIva;
	}
	public void setTotalIva(Double totalIva) {
		TotalIva = totalIva;
	}
	public Double getTotalVenta() {
		return TotalVenta;
	}
	public void setTotalVenta(Double totalVenta) {
		TotalVenta = totalVenta;
	}
	public Double getTotalConIva() {
		return TotalConIva;
	}
	public void setTotalConIva(Double totalConIva) {
		TotalConIva = totalConIva;
	}
	public Double getValorProducto1() {
		return ValorProducto1;
	}
	public void setValorProducto1(Double valorProducto1) {
		ValorProducto1 = valorProducto1;
	}
	public Double getValorProducto2() {
		return ValorProducto2;
	}
	public void setValorProducto2(Double valorProducto2) {
		ValorProducto2 = valorProducto2;
	}
	public Double getValorProducto3() {
		return ValorProducto3;
	}
	public void setValorProducto3(Double valorProducto3) {
		ValorProducto3 = valorProducto3;
	}
	public Double getValor_VentaDet1() {
		return Valor_VentaDet1;
	}
	public void setValor_VentaDet1(Double valor_VentaDet1) {
		Valor_VentaDet1 = valor_VentaDet1;
	}
	public Double getValor_VentaDet2() {
		return Valor_VentaDet2;
	}
	public void setValor_VentaDet2(Double valor_VentaDet2) {
		Valor_VentaDet2 = valor_VentaDet2;
	}
	public Double getValor_VentaDet3() {
		return Valor_VentaDet3;
	}
	public void setValor_VentaDet3(Double valor_VentaDet3) {
		Valor_VentaDet3 = valor_VentaDet3;
	}
	public Double getIvaProducto1() {
		return IvaProducto1;
	}
	public void setIvaProducto1(Double ivaProducto1) {
		IvaProducto1 = ivaProducto1;
	}
	public Double getIvaProducto2() {
		return IvaProducto2;
	}
	public void setIvaProducto2(Double ivaProducto2) {
		IvaProducto2 = ivaProducto2;
	}
	public Double getIvaProducto3() {
		return IvaProducto3;
	}
	public void setIvaProducto3(Double ivaProducto3) {
		IvaProducto3 = ivaProducto3;
	}
	public int getCantidad1() {
		return Cantidad1;
	}
	public void setCantidad1(int cantidad1) {
		Cantidad1 = cantidad1;
	}
	public int getCantidad2() {
		return Cantidad2;
	}
	public void setCantidad2(int cantidad2) {
		Cantidad2 = cantidad2;
	}
	public int getCantidad3() {
		return Cantidad3;
	}
	public void setCantidad3(int cantidad3) {
		Cantidad3 = cantidad3;
	}
	

	public VentaDTO(int cedula, String nombre, int totalVentas) {
		super();
		this.cedula = cedula;
		Nombre = nombre;
		TotalVentas = totalVentas;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getTotalVentas() {
		return TotalVentas;
	}
	public void setTotalVenta(int totalVenta) {
		TotalVentas = totalVenta;
	}
	
	
}
