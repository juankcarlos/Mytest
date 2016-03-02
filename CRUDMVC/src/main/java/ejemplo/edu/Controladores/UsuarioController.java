package ejemplo.edu.Controladores;
import java.util.*;
import ejemplo.edu.Pojo.Usuario;
import ejemplo.edu.Dao.DaoUsuario;
public class UsuarioController {
	private DaoUsuario dos;
	private DaoUsuario ds=new DaoUsuario(); 
	public List<Usuario> Listar()
	{
		List<Usuario> ls=new ArrayList<Usuario>();
		ls=ds.ObtenerTodo();
		return ls;
	}
	public boolean verificarRegistro(Usuario us)
	{
		if(ds.Insertar(us)==1)
		{
			return true;
		}else
		{
			return false;
		}
	}

	public boolean eliminarUsuario(Usuario us)
	{
		if(ds.eliminar(us)==1)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public boolean actualizarUsuario(Usuario us)
	{
		if(ds.actualizar(us)==1)
		{
			return true;
		}else{
			return false;
		}
	}
	public Usuario buscar(Usuario us)
	{
		Usuario uss=ds.buscarid(us);
		return uss;
	}
}
