package ejemplo.edu.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import ejemplo.edu.Pojo.Usuario;

;
public class DaoUsuario implements Crud<Usuario> {
	private Conexion c = new Conexion();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	Connection cox;

	public DaoUsuario() {

	}

	public List<Usuario> ObtenerTodo() {
		Usuario us;
		List<Usuario> coleccion = new ArrayList<Usuario>();
		try {
			cox = c.GetConnection();
			String sql = "Select * from usuario";
			pstm = cox.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				us = new Usuario();
				us.setId(rs.getInt("id"));
				us.setNombre(rs.getString("nombre"));
				us.setApellidos(rs.getString("apellidos"));
				us.setEdad(rs.getInt("edad"));
				us.setEmail(rs.getString("email"));
				us.setApellidos(rs.getString("password"));
				coleccion.add(us);
			}
			return coleccion;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			return null;
		}
		
	}

	public int Insertar(Usuario us) {
		try {
			cox = c.GetConnection();
			String query = "INSERT INTO usuario(id,nombre,apellidos,edad,email,password) VALUES(?,?,?,?,?,?)";
			pstm = cox.prepareStatement(query);
			pstm.setInt(1, 0);
			pstm.setString(2, us.getNombre());
			pstm.setString(3, us.getApellidos());
			pstm.setInt(4, us.getEdad());
			pstm.setString(5, us.getEmail());
			pstm.setString(6, us.getPass());
			int r = pstm.executeUpdate();
			return r;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			return 0;
		}
	}

	public int actualizar(Usuario us) {
		try {
			String query = "Update usuario set nombre=?, apellidos=? , edad=? ,email=?, password=? where id=?";
		    cox=c.GetConnection();
		    pstm=cox.prepareStatement(query);
		    pstm.setString(1,us.getNombre() );
		    pstm.setString(2,us.getApellidos() );
		    pstm.setInt(3,us.getEdad() );
		    pstm.setString(4,us.getEmail() );
		    pstm.setString(5,us.getPass());
		    pstm.setInt(6, us.getId());
		    int r=pstm.executeUpdate();
		    return r;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
			return 0;
		}
	}

	public int eliminar(Usuario us) {
		try
		{
			String query="DELETE FROM usuario where id=?";
			cox=c.GetConnection();
			pstm=cox.prepareStatement(query);
			pstm.setInt(1,us.getId());
			int r=pstm.executeUpdate();
			return r;
		}catch(SQLException e)
		{
			System.out.println(e.getStackTrace());
			return 0;
		}
	}
	public Usuario buscarid(Usuario us)
	{
		try
		{
			cox=c.GetConnection();
			String query="SELECT * FROM usuario WHERE id=?";
			pstm=cox.prepareStatement(query);
			pstm.setInt(1,us.getId());
			rs=pstm.executeQuery();
			us = new Usuario();
			rs.next();
			us.setId(rs.getInt("id"));
			us.setNombre(rs.getString("nombre"));
			us.setApellidos(rs.getString("apellidos"));
			us.setEdad(rs.getInt("edad"));
			us.setEmail(rs.getString("email"));
			us.setApellidos(rs.getString("password"));
			
			return us;
		}catch(SQLException e)
		{
			System.out.println(e.getStackTrace());
			return null;
		}
	}

}
