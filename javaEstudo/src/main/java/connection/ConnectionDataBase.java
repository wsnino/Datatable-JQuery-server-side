package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Realizar a conex�o com o banco de dados
 * 
 * @author alex
 * 
 */
public class ConnectionDataBase {

	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp1?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	static {
		conectar();
	}

	public ConnectionDataBase() {
		conectar();
	}

	private static void conectar() {

		try {
			if (connection == null) {
					Class.forName("org.postgresql.Driver");
					connection = DriverManager.getConnection(banco, user, password);
			}
		} catch (Exception exception) {
			throw new RuntimeException("Erro ao conectar com o banco de dados"
					+ exception.getMessage());
		}

	}
	
	
	/**
	 * Retorna a conex�o do banco de dados 
	 * @return Connection SQL
	 */
	public static Connection getConnection(){
		return  connection;
	}
	

}
