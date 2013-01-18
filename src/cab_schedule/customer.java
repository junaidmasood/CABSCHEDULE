package cab_schedule;
import java.io.*;
import java.util.*;

public class customer 
{
    public String pan_number;
    public String password;
    public String name;
    public String mob;
    public String address;
    public customer()
    {
	pan_number=null;
	password=null;
	name=null;
	mob=null;
	address=null;
    }
    public customer(String a, String b, String c, String d, String e)
    {
	pan_number=a;
	password=b;
	name=c;
	mob=d;
	address=e;
    }
}
