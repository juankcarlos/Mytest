package ejemplo.edu.Controladores;

import java.util.*;

import ejemplo.edu.Pojo.Usuario;
import ejemplo.edu.Controladores.UsuarioController;

;
public class Principal {
	private static UsuarioController usc = new UsuarioController();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean con=true;
		do{
			
			System.out.println("\t--EJEMPLO MVC JAVA--");
			System.out.println("\tCRUD DE USUARIOS");
			System.out.println("\t--MENU DE OPCIONES--");
			System.out.println("0)Salir \n1)Ver Usuarios\n2)Insertar Usuarios\n3)Actualizar Usuario\n4)eliminar Usuario\n5)Buscar Usuario por id)");
			System.out.println("Ingrese su opcion");
			int op=in.nextInt();
			switch(op)
			{
			case 0:
			  con=false;
				break;
			case 1:
				Principal.Todos();
				break;
			case 2:
				Principal.Insertarus();
				break;
			case 3:
				Principal.actualizar();
				break;
			case 4:
				Principal.eliminar();
				break;
			case 5:
				Principal.buscar();
				break;
			}
			System.out.println("\n");
		}while(con);
		
	}

	public static void Todos() {
		List<Usuario> l = usc.Listar();
		for (Usuario la : l) {
			System.out.println(la.toString());
		}

	}

	public static void Insertarus() {
		System.out.println("Ingrese su Nombre");
		String nombre=in.next();
		System.out.println("Ingrese sus Apellidos");
		String apellidos=in.next();
		System.out.println("Ingrese su Edad");
		int edad=in.nextInt();
		System.out.println("Ingrese sus Email");
		String email=in.next();
		System.out.println("Ingrese sus Contaseña");
		String pass=in.next();
		Usuario us=new Usuario(nombre,apellidos,edad,email,pass);
		if(usc.verificarRegistro(us))
		{
			System.out.println("Registro exitoso");
		}else{
			System.out.println("Registro fallido");
		}
		
	}
	public static void actualizar()
	{
		Usuario us=new Usuario();
		System.out.println("--Actualizar Usuario--");
		System.out.println("Ingrese el Id");
		int id=in.nextInt();
		us.setId(id);
		System.out.println("Ingrese su Nombre");
		String nombre=in.next();
		System.out.println("Ingrese sus Apellidos");
		String apellidos=in.next();
		System.out.println("Ingrese su Edad");
		int edad=in.nextInt();
		System.out.println("Ingrese sus Email");
		String email=in.next();
		System.out.println("Ingrese sus Contaseña");
		String pass=in.next();
		us.setNombre(nombre);
		us.setApellidos(apellidos);
		us.setEdad(edad);
		us.setEmail(email);
		us.setPass(pass);
		if(usc.actualizarUsuario(us))
		{
			System.out.println("Usuario Actualizado");
		}else
		{
			System.out.println("Id no encontrado ingrese un id valido");
		}
	}
	public static void eliminar()
	{
		Usuario us=new Usuario();
		System.out.println("Ingrese el Id");
		int id=in.nextInt();
		us.setId(id);
		if(usc.eliminarUsuario(us))
		{
			System.out.println("Usuario eliminado exitosamente");
		}else
		{
			System.out.println("Id no encontrado ingrese un id valido");
		}
	}
	
	public static void buscar()
	{
		Usuario us=new Usuario();
		System.out.println("Ingrese el Id del Usuario a encontrar");
		int id=in.nextInt();
		us.setId(id);
		
		if(usc.buscar(us)!=null)
		{
			Usuario us2=usc.buscar(us);
			System.out.println(us2.toString());
		}else{
			System.out.println("Identificador de Usuario no Existe");
		}
	}
}
