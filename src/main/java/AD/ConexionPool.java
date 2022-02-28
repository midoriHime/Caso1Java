/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/**
 *
 * @author Kelly Villalobos Baez
 */
public class ConexionPool {
   


	private final String databaseUrl;
	private final String userName;
	private final String password;
	private int maxPoolSize;
	private int connNum = 0;
        private static final String SQL_VERIFYCONN = "select 1";


	Stack<Connection> freePool = new Stack<>();
	Set<Connection> occupiedPool = new HashSet<>();

	/**
	 * Constructor
	 * 	
	 * @param maxSize
	 *            Tamano maximo del Pool
	 */
	public ConexionPool(int maxSize) {
		this.databaseUrl =  "jdbc:sqlserver://NEWPORT\\SQLEXPRESS01:55860;database=ASENI; ";
		this.userName = "sa";
		this.password = "1234";
		this.maxPoolSize = maxSize;
	}

	/**
	 * Optiene una conexion disponible del Pool
	 */
	public synchronized Connection getConnection() throws SQLException {
		Connection conn = null;

		if (isFull()) {
			throw new SQLException("El pool de conexiones esta lleno.");
		}
                //Obtiene una conexion del Pool de conexiones
		conn = getConnectionFromPool();
		// Si no hay conexion libre se crea una
		if (conn == null) {
			conn = createNewConnectionForPool();
		}
		//Verifica que la conexion se encuentre activa
		conn = makeAvailable(conn);
		return conn;
	}

	/**
	 * Saca una conexion del pool de ocupadas y la registra en el pool de libre
	 * 
	 * @param conn: Conexion a liberar
	 *            
	 * @throws SQLException
	 *             When the connection is returned already or it isn't gotten
	 *             from the pool.
	 */
	public synchronized void liberaConexion(Connection conn)
			throws SQLException {
		if (conn == null) {
			throw new NullPointerException();
		}
		if (!occupiedPool.remove(conn)) {
			throw new SQLException(
					"The connection is returned already or it isn't for this pool");
		}
		freePool.push(conn);
	}

	/**
	 * Verify if the connection is full.
	 * 
	 * @return if the connection is full
	 */
	private synchronized boolean isFull() {
		return ((freePool.size() == 0) && (connNum >= maxPoolSize));
	}

	/**
	 * Create a connection for the pool
	 * 
	 * @return the new created connection
	 * @throws SQLException
	 *             When fail to create a new connection.
	 */
	private Connection createNewConnectionForPool() throws SQLException {
		Connection conn = createNewConnection();
		connNum++;
		occupiedPool.add(conn);
		return conn;
	}

	/**
	 * Crate a new connection
	 * 
	 * @return the new created connection
	 * @throws SQLException
	 *             When fail to create a new connection.
	 */
	private Connection createNewConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(databaseUrl, userName, password);
		return conn;
	}

	/**
	 * Get a connection from the pool. If there is no free connection, return
	 * null
	 * 
	 * @return the connection.
	 */
	private Connection getConnectionFromPool() {
		Connection conn = null;
		if (!freePool.isEmpty()) {
			conn = freePool.pop();
			occupiedPool.add(conn);
		}
		return conn;
	}

	/**
	 * Make sure the connection is available now. Otherwise, reconnect it.
	 * 
	 * @param conn
	 *            The connection for verification.
	 * @return the available connection.
	 * @throws SQLException
	 *             Fail to get an available connection
	 */
	private Connection makeAvailable(Connection conn) throws SQLException {
		if (isConnectionAvailable(conn)) {
			return conn;
		}

		// If the connection is't available, reconnect it.
		occupiedPool.remove(conn);
		connNum--;
		conn.close();

		conn = createNewConnection();
		occupiedPool.add(conn);
		connNum++;
		return conn;
	}

	/**
	 * By running a sql to verify if the connection is available
	 * 
	 * @param conn
	 *            The connection for verification
	 * @return if the connection is available for now.
	 */
	private boolean isConnectionAvailable(Connection conn) {
		try (Statement st = conn.createStatement()) {
			st.executeQuery(SQL_VERIFYCONN);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
     
        
      

}

