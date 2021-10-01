package Modelo;

public class UsuarioDTO {
	
	 private int Cedula;
	 private String Email;
	 private String Nombre;
	 private String Password;

	 
	public UsuarioDTO(int cedula, String email, String nombre, String password) {
		super();
		Cedula = cedula;
		Email = email;
		Nombre = nombre;
		Password = password;
	
	}
	public int getCedula() {
		return Cedula;
	}
	public void setCedula(int cedula) {
		Cedula = cedula;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

 
 
}
