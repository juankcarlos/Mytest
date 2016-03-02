package ejemplo.edu.Pojo;

public class Usuario {
	private int Id;
	private String Nombre;
	private String Apellidos;
	private int Edad;
	private String Email;
	private String pass;
    
	public Usuario()
	{
		
	}
	public Usuario(String nombre, String apellidos, int edad, String email,
			String pass) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Edad = edad;
		Email = email;
		this.pass = pass;
	}

	public Usuario(int id, String nombre, String apellidos, int edad,
			String email, String pass) {
		super();
		Id = id;
		Nombre = nombre;
		Apellidos = apellidos;
		Edad = edad;
		Email = email;
		this.pass = pass;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
    public String toString()
    {
    	return "El nombre es: "+Nombre+" Los Apellidos son: "+Apellidos+" La Edad es: "+Edad+ "El email es: "+Email;
    }
}
