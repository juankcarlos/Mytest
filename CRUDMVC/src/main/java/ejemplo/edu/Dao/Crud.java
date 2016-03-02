package ejemplo.edu.Dao;
import java.util.*;
public interface Crud<T> {
	 public  List<T> ObtenerTodo();
	 public int Insertar(T ob);
	 public int actualizar(T ob);
	 public int  eliminar(T ob);
	 public T buscarid(T ob);
}