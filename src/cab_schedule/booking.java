//a new edit
package cab_schedule;
import java.util.*;
public class booking 
{
    public String id;
    public String pan_number;
    public String taxi_reg;
    public double x1;	//location first
    public double y1;
    public double x2;	//location second	
    public double y2;
    public Date start;
    public Date end;
    
    public booking()
    {
	id=null;
	pan_number=null;
	taxi_reg=null;
	x1=0.0; y1=0.0;
	x2=0.0; y2=0.0;
	start=null;
	end=null;
    }
    public booking(String a, String b, String c, double d, double e, double f, double g, Date d1, Date d2)
    {
	id=a;
	pan_number=b;
	taxi_reg=c;
	x1=d;
	y1=e;
	x2=f;
	y2=g;
	start=d1;
	end=d2;
    }
}
