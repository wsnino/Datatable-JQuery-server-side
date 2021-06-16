package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Realizar a conex�o com o banco de dados
 * Conex�o Mysql para o banco aprendendojsp
 * @author alex
 * 
 */
public class ConnectionDataBaseMySQL {

	private static String banco = "jdbc:mysql://localhost:3306/aprendendojsp?autoReconnect=true";
	private static String password = "1234";
	private static String user = "root";
	private static Connection connection = null;

	static {
		conectar();
	}

	public ConnectionDataBaseMySQL() {
		conectar();
	}

	private static void conectar() {

		try {
			if (connection == null) {
					Class.forName("com.mysql.jdbc.Driver");
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
