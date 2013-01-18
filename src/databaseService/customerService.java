package databaseService;
import java.sql.*;
import java.io.*;
import java.util.*;
import cab_schedule.customer;

public class customerService 
{
    public void insertcustomer(customer c)
    {
	try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "INSERT INTO customer (pan_number, password, name, mob, address ) values (?, ?, ?, ?, ?)");
            statement.setString(1, c.pan_number);
            statement.setString(2, c.password);
	    statement.setString(3, c.name);
	    statement.setString(4, c.mob);
	    statement.setString(5, c.address);
            statement.executeUpdate();
            
            con.close();
         }
         catch(Exception e){ e.printStackTrace(); }
    }
    public void updatecustomer(customer c)
    {
	try
	{
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "UPDATE customer SET password = ?" +", name = ? , mob = ? , address = ? WHERE pan_number = ?");
            
            statement.setString(1, c.pan_number);
	    statement.setString(2, c.password);
            statement.setString(3, c.name);
	    statement.setString(4, c.mob);
	    statement.setString(5, c.address);
	    
            statement.executeUpdate();
        }
        catch(Exception e){e.printStackTrace(); }
    }
    public void deletecustomer(customer c)
    {
	try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "DELETE FROM customer WHERE pan_number = ?");
	    statement.setString(1, c.pan_number);
	    statement.executeUpdate();
	}
        catch(Exception e){e.printStackTrace(); }
    }
    public  List<customer> getcustomer() throws IOException
    {
        try {
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
	    Statement statement = con.createStatement();
            List<customer> list;
	    ResultSet result = statement.executeQuery("SELECT * FROM customer");
	    list = new ArrayList<customer>();
	    
            while(result.next())
	    {
                    customer c=new customer();
                    c.pan_number=result.getString("pan_number");
		    c.password=result.getString("password");
		    c.name=result.getString("name");
		    c.mob=result.getString("mob");
		    c.address=result.getString("address");
                    
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
    public List<customer> getSearch_name(String keyword) throws IOException
    {
        try {
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "SELECT * FROM customer WHERE name LIKE  ? ");
            statement.setString(1, "%"+keyword+"%");
            List<customer> list = new ArrayList<customer>();
	    ResultSet result = statement.executeQuery();
            while (result.next()) 
	    {
                    customer t = new customer();
                    t.pan_number = result.getString("pan_number");
                    t.password=result.getString("password");
		    t.name=result.getString("name");
		    t.mob=result.getString("mob");
		    t.address=result.getString("address");
                    
                    list.add(t); 
            }

            return list;
        } catch (SQLException exception) 
	{
            exception.printStackTrace();
            return null;
        } 
    }
    public List<customer> getSearch_pan_number(String keyword) throws IOException
    {
        try {
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
            PreparedStatement statement=con.prepareStatement(
                    "SELECT * FROM customer WHERE pan_number LIKE  ? ");
            statement.setString(1, "%"+keyword+"%");
            List<customer> list = new ArrayList<customer>();
	    ResultSet result = statement.executeQuery();
            while (result.next()) 
	    {
                    customer t = new customer();
                    t.pan_number = result.getString("pan_number");
                    t.password=result.getString("password");
		    t.name=result.getString("name");
		    t.mob=result.getString("mob");
		    t.address=result.getString("address");
                    
                    list.add(t); 
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
