package databaseService;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.io.ObjectInputStream;
import cab_schedule.booking;

public class bookingService 
{
    public void insertbooking(booking c)
    {
	try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "INSERT INTO booking (id, pan_number, taxi_reg, x1, y1, x2, y2, start, end ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
	    statement.setString(1, c.id);
            statement.setString(2, c.pan_number);
	    statement.setString(3, c.taxi_reg);
	    statement.setDouble(4, c.x1);
	    statement.setDouble(5, c.y1);
	    statement.setDouble(6, c.x2);
	    statement.setDouble(7, c.y2);
	    
	    //assigning the start date..
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	    String todayStr = fmt.format(c.start);
	    java.sql.Date dt = java.sql.Date.valueOf(new String(todayStr));
	    statement.setDate(8, dt);
	    
	    //assigning the end date.
	    todayStr=fmt.format(c.end);
	    dt = java.sql.Date.valueOf(new String(todayStr));
	    statement.setDate(9, dt);
	    
            statement.executeUpdate();
            
            con.close();
         }
         catch(Exception e){ e.printStackTrace(); }
    }
    public void updatebooking(booking c)
    {
	try
	{
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "UPDATE booking SET pan_number = ?" +", taxi_reg = ? , x1 = ? , y1 = ?, x2 = ?, y2 = ?, start = ?, end = ?  WHERE id = ?");
            
            statement.setString(1, c.id);
            statement.setString(2, c.pan_number);
	    statement.setString(3, c.taxi_reg);
	    statement.setDouble(4, c.x1);
	    statement.setDouble(5, c.y1);
	    statement.setDouble(6, c.x2);
	    statement.setDouble(7, c.y2);
	    
	    //assigning the start date..
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	    String todayStr = fmt.format(c.start);
	    java.sql.Date dt = java.sql.Date.valueOf(new String(todayStr));
	    statement.setDate(8, dt);
	    
	    //assigning the end date.
	    todayStr=fmt.format(c.end);
	    dt = java.sql.Date.valueOf(new String(todayStr));
	    statement.setDate(9, dt);
	    
            statement.executeUpdate();
        }
        catch(Exception e){e.printStackTrace(); }
    }
    public void deletebooking(booking c)
    {
	try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "DELETE FROM booking WHERE id = ?");
	    statement.setString(1, c.id);
	    statement.executeUpdate();
	}
        catch(Exception e){e.printStackTrace(); }
    }
    public  List<booking> getbooking() throws IOException
    {
        try {
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
	    Statement statement = con.createStatement();
            List<booking> list;
	    ResultSet result = statement.executeQuery("SELECT * FROM booking");
	    list = new ArrayList<booking>();
	    
            while(result.next())
	    {
                    booking c=new booking();
                    c.id=result.getString("id");
		    c.pan_number=result.getString("pan_number");
		    c.taxi_reg=result.getString("taxi_reg");
		    c.x1=result.getDouble("x1");
		    c.y1=result.getDouble("y1");
		    c.x2=result.getDouble("x2");
		    c.y2=result.getDouble("y2");
		    c.start=result.getDate("start");
                    c.end=result.getDate("end");
                    list.add(c); 
                }
          return list;    
        }
	catch (SQLException exception)
	{
            exception.printStackTrace();
            return null;
	}
    }
    public List<booking> getSearch_id(String keyword) throws IOException
    {
        try {
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "SELECT * FROM booking WHERE id LIKE  ? ");
            statement.setString(1, "%"+keyword+"%");
            List<booking> list = new ArrayList<booking>();
	    ResultSet result = statement.executeQuery();
            while (result.next()) 
	    {
                    booking c = new booking();
                    c.id=result.getString("id");
		    c.pan_number=result.getString("pan_number");
		    c.taxi_reg=result.getString("taxi_reg");
		    c.x1=result.getDouble("x1");
		    c.y1=result.getDouble("y1");
		    c.x2=result.getDouble("x2");
		    c.y2=result.getDouble("y2");
		    c.start=result.getDate("start");
		    c.end=result.getDate("end");
                    
                    list.add(c); 
            }

            return list;
        } catch (SQLException exception) 
	{
            exception.printStackTrace();
            return null;
        } 
    }
    public List<booking> getSearch_pan_number(String keyword) throws IOException
    {
        try {
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "SELECT * FROM booking WHERE pan_number LIKE  ? ");
            statement.setString(1, "%"+keyword+"%");
            List<booking> list = new ArrayList<booking>();
	    ResultSet result = statement.executeQuery();
            while (result.next()) 
	    {
                    booking c = new booking();
                    c.id=result.getString("id");
		    c.pan_number=result.getString("pan_number");
		    c.taxi_reg=result.getString("taxi_reg");
		    c.x1=result.getDouble("x1");
		    c.y1=result.getDouble("y1");
		    c.x2=result.getDouble("x2");
		    c.y2=result.getDouble("y2");
                    c.start=result.getDate("start");
                    c.end=result.getDate("end");
		    
                    list.add(c); 
	    }
            return list;
        } 
	catch (SQLException exception) 
	{
            exception.printStackTrace();
            return null;
        } 
    }
}
