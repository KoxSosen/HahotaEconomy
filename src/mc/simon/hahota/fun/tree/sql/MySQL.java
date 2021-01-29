package mc.simon.hahota.fun.tree.sql;

import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQL {
	
	
	private String host = "localhost";//edit these
	private String port = "3306"; // port
	private String database = "economy"; // db name
	private String username = "root"; //name
	private String password = "pass"; //passworld
	
	private java.sql.Connection connection;
	
	public boolean isConnected() {
		return (connection == null ? false : true ); // if there isn't any question it's false othervise it's false
		
	}
	
	public void connect() throws ClassNotFoundException, SQLException {
		if (!isConnected()) {
		 connection = DriverManager.getConnection("jdbc:mysql://" +
			     host + ":" + port + "/" + database + "?useSSL=false", // use ssl if possible ty
			     username, password);
		}
	}
	
	public void disconnect() {
		if (isConnected()) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public java.sql.Connection getConnection() {
		return connection;
	}
	
}
