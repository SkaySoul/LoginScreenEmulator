package application;

import java.sql.*;



public class DatabaseHandler extends Configs{
	Connection dbConnection;
	
	public Connection getDbConnection() throws ClassNotFoundException, SQLException{
		String connectionString = "jdbc:mysql://" + dbHost+ ":" + dbPort + "/" + dbName;
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
		return dbConnection;
	}
	
	public void createUser(User user) throws ClassNotFoundException, SQLException {
		String insert = "INSERT INTO " + Const.USER_TABLE+ "(" + Const.USER_FIRSTNAME + "," + Const.USER_SURNAME +
				"," + Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," + Const.USER_EBLAN  + ")"  + "VALUES(?,?,?,?,?)";
		try(PreparedStatement prSt = getDbConnection().prepareStatement(insert);){
		prSt.setString(1, user.getFirstname());
		prSt.setString(2, user.getSurname());
		prSt.setString(3, user.getLogin());
		prSt.setString(4, user.getPassword());
		prSt.setString(5, user.getEblan());
		prSt.executeUpdate();	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getUser(User user) {
		ResultSet resset = null;
		
		String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + 
				Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";
	
		try(PreparedStatement prSt = getDbConnection().prepareStatement(select);){
			prSt.setString(1, user.getLogin());
			prSt.setString(2, user.getPassword());
			
			resset = prSt.executeQuery();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		
		return resset;
	}
}

