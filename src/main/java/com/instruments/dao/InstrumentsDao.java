package com.instruments.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.instruments.model.Instrument;

public class InstrumentsDao {

	private static ResultSet result = null;

	public int addProduct(Instrument instrument) throws ClassNotFoundException {
		String INSERT_Instrument_SQL = "INSERT INTO instruments" + "  ( Iname, price, des, category, warrenty) VALUES "
				+ " ( ?, ?, ?, ?,?);";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/instruments?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");
//        		jdbc:mysql://localhost:3306/?user=root

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Instrument_SQL)) {
//            preparedStatement.setInt(1, 1);
			preparedStatement.setString(1, instrument.getName());
			preparedStatement.setString(2, instrument.getPrice());
			preparedStatement.setString(3, instrument.getDes());
			preparedStatement.setString(4, instrument.getCategory());
			preparedStatement.setString(5, instrument.getWarrenty());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;
	}

	public static ArrayList<Instrument> viewAllInstruments() throws ClassNotFoundException {
		
		ArrayList<Instrument> arti=new ArrayList<>();

			Class.forName("com.mysql.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/instruments?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456")){

					Statement stat=connection.createStatement();
					String sql4 = "SELECT * FROM instruments";
					result=stat.executeQuery(sql4);

					while(result.next())
					{
						int ID = result.getInt(1);
						String name = result.getString(2);
						String price = result.getString(3);
						String description = result.getString(4);
						String category = result.getString(5);
						String warrenty = result.getString(6);

						Instrument a = new Instrument(ID, name, price, description, category, warrenty);
						arti.add(a);

					}

			} catch (SQLException e) {
				// process sql exception
				printSQLException(e);
			}

	

	return arti;

	}
	
	public boolean deleteInstrument(String id) throws ClassNotFoundException {
		
		int convertedID=Integer.parseInt(id);
		boolean isSuccess = false;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/instruments?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456")){

				Statement stat=connection.createStatement();
				String sql4 = "delete from instruments where id='"+convertedID+"'";
				int result=stat.executeUpdate(sql4);

				if(result>0) {
					isSuccess =true;
				}
				else {
					isSuccess=false;
				}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		
		return isSuccess;

	}
	
	public static Instrument getInstrument(String id) throws ClassNotFoundException {
		
		int convertedID=Integer.parseInt(id);
		boolean isSuccess = false;
		
		Instrument a = null;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/instruments?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456")){

				Statement stat=connection.createStatement();
				String sql4 = "select * from instruments where id='"+convertedID+"'";
				result=stat.executeQuery(sql4);

				while(result.next())
				{
					int ID = result.getInt(1);
					String name = result.getString(2);
					String price = result.getString(3);
					String description = result.getString(4);
					String category = result.getString(5);
					String warrenty = result.getString(6);

					 a = new Instrument(ID, name, price, description, category, warrenty);

				}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		
		return a;
		
	}
	
	public boolean updateInstrument(int id, String name, String price, String des, String category, String warrenty) throws ClassNotFoundException  {
		
		boolean isSuccess=false;
		
		
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/instruments?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456")){

				Statement stat=connection.createStatement();
				String sql4 = "update instruments set Iname='"+name+"', price='"+price+"', des='"+des+"',category='"+category+"' , warrenty ='"+warrenty+"'"+"where ID='"+id+"'";
				int result=stat.executeUpdate(sql4);

				if(result>0) {
					isSuccess =true;
				}
				else {
					isSuccess=false;
				}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		
		return isSuccess;
		
	}

	private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
