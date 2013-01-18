package Design;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.sql.*;

public class CityMap {
	MyFrame frame = new MyFrame();
	 public void mmm()
	 {
	 EventQueue.invokeLater(new Runnable()
	 {
	 public void run()
	 {
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 }
	 });
	 }
     }

		
class MyFrame extends JFrame
		 {
		 public MyFrame()
		 {
		 setTitle("CityMap");
		 setSize(1200, 600);
		 MyComponent component = new MyComponent();
		 add(component);
		}
	
		 }
		
		class MyComponent extends JComponent
		 {
			 
	    private static final int SIDELENGTH = 10;
        private ArrayList<Rectangle2D> squares;
	    private Rectangle2D current;
	    private LandMarks lm;
	    public ArrayList<Line2D> linelist=new ArrayList<Line2D>();
	    private ArrayList<LandMarks> marks=new ArrayList<LandMarks>();
	    final JButton button = new JButton("Press to Connect LandMarks");
	    final JButton button1=new JButton("Press to Delete Roads");
	    final JButton button2=new JButton("Refresh");
	    public double[][] connections=new double[100][4];
	    static int i=0;
	    boolean temp=false,temp1=false;
	    public Line2D z;
	    public static ArrayList<taxi> taxilist;
	    BufferedImage img,img1,img2,img3;
	 
	    
	    public MyComponent()
	    {
	    	{int k=0;
			 try {
				 
				Scanner s=new Scanner(new File("connections.txt"));
		
				while(s.hasNextInt())
				{  
					Line2D line = new Line2D.Double( s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt());
				    linelist.add(line);
					
					k++;
					
				}
				i=k;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		 squares = new ArrayList<Rectangle2D>();
		 current = null;
		 lm=null;
		  setLayout(new BorderLayout());
		 JPanel buttonPane = new JPanel();	 
		 buttonPane.add(button);
		 buttonPane.add(button1);
		 buttonPane.add(button2);
		add(buttonPane, BorderLayout.PAGE_END);
		
		 
		
	    try{ 
			   Scanner s=new Scanner(new File("landmarks.txt"));
			   
			   while(s.hasNextInt())
			   {
				   Point2D p=null;
				   p=new Point2D.Double(s.nextInt(),s.nextInt());
				   add(p,s.nextLine());
			   }
		 }
			   catch(IOException e){}
		 
		 addMouseListener(new MouseHandler());
		 addMouseMotionListener(new MouseMotionHandler());
		 
		 button.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e)
			   {
				 button.setEnabled(false);
			  
			   }
		   });
		 button1.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e)
			   {
                 button1.setEnabled(false);
			  
			   }
		   });
		 button2.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e)
			   {
	        try {
		gettaxi();
	       } catch (IOException e1) {	e1.printStackTrace();
	       }
			  getBooking();
			  repaint();
			   }
		   });
	    	}
	    	
	    	try {
				img=ImageIO.read(new File("cx.png"));
				img1=ImageIO.read(new File("green.png"));
				img2=ImageIO.read(new File("raj.gif"));
				img3=ImageIO.read(new File("capture.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	REFRESH();
	    	
	    	
		 }
		
	    
	    
	    public void REFRESH()
	    {
	    	try {
				gettaxi();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	getBooking();
	    	
	    	
	    	repaint();
	    	
	    	
	    }
	    
		 public void paintComponent(Graphics g)
		 {
			 
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setColor(Color.WHITE);
         

		 g2.fillRect(0, 0, getWidth(), getHeight());
		 g2.drawImage(img2,0,0,getWidth(),getHeight(),null); 
		 g2.drawImage(img3,getWidth()-200,getHeight()-150,150,100,null); 
		 Iterator<taxi> it=taxilist.iterator();
		 int[] temp=new int[20];
		 int i=0;
		 while(it.hasNext())
		 {
			 taxi t=it.next();
			 temp[i]++;
		
			 Iterator<taxi> it1=taxilist.iterator();
			 int k=0;
			 boolean b=false;
			 while(k<=i)
			 {  
				
				taxi y=it1.next();
				
			if(y.x==t.x&&y.y==t.y&&b==false)
			 {b=true;
			 if(t.status==1)
			 {   
				 g2.drawImage(img,(int)(t.x)-40*temp[k],(int)(t.y)-40,35,35,null);
				 
			 }
			 else 
				 g2.drawImage(img1,(int)(t.x)-40*temp[k]-3,(int)(t.y)-40-6,43,42,null); 
			 temp[k]++;
			 }
			 k++;
			 }
		
			 i++;
		 }
		 /*
		 Iterator<taxi> it2=taxilist.iterator();
		 while(it2.hasNext())
		 {
			 taxi t=it2.next();
			 if(t.status==1)
				 g2.drawImage(img,(int)(t.x)-40,(int)(t.y)-40,40,40,null);
			 else 
				 g2.drawImage(img1,(int)(t.x)-40,(int)(t.y)-40,40,40,null); 
		 }
		 */
		 g2.setColor(getForeground());
		 for (Rectangle2D r : squares)
			 
		 {  Color col=new Color(56, 142, 142);
			 g2.setStroke(new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
		 g2.setColor(Color.black);
			 g2.drawRoundRect((int)r.getX(),(int) r.getY(),13, 13, 2, 2);
			  }
	
		 g2.setStroke(new BasicStroke(4, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
		 Color col=new Color(81, 81, 81);
	    g2.setColor(col);
		 for(Line2D l: linelist)
		 g2.draw(l);
		 try {
			gettaxi();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		   
		 
		   
		   
	     }
		
	     
		 
		 
		 
		 public static void gettaxi() throws IOException
		    {
		        try {
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
			    Statement statement = con.createStatement();
		            
			    ResultSet result = statement.executeQuery("SELECT * FROM taxi");
			    taxilist = new ArrayList<taxi>();
			    
		            while(result.next())
			    {
		                    taxi t = new taxi();
		                    t.reg_no = result.getString("reg_no");
		                    t.status= result.getInt("status");
		                    t.driver=result.getString("driver");
		                    t.capacity= result.getInt("capacity");
		                    t.type=result.getString("type");
				    t.reading=result.getInt("reading");
				    t.wheeler=result.getInt("wheeler");
				    t.maintenance=result.getString("maintenance");
				    t.x=result.getDouble("x");
				    t.y=result.getDouble("y");
		                    
		                    taxilist.add(t); 
		                
		                }
		           
		        }
			catch (SQLException exception)
			{
		            exception.printStackTrace();
			}
		        
		    } 
		 
		 
		 public static void getBooking()
		 {
			try {
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
				    Statement statement = con.createStatement();
			            
				    ResultSet result = statement.executeQuery("SELECT * FROM booking");
				  
				    
			            while(result.next())
				    {
			                    booking t = new booking();
			                    t.reg_num = result.getString("taxi_reg");
			                    t.x1= result.getDouble("x1");
			                    t.y1=result.getDouble("y1");
			                    t.x2= result.getDouble("x2");
			                    t.y2= result.getDouble("y2");
					    t.start=result.getDate("start");
					    t.end=result.getDate("end");
					    
					    
					    Calendar date = Calendar.getInstance();
					    Date date1=new Date();
					    int y=t.end.getYear()+1900;
					    int d=t.end.getDate();
					    int m=t.end.getMonth();
					    int month = date1.getMonth();
					    int day = date1.getDate();
					    int year = date1.getYear()+1900;
					 int y1=t.start.getYear()+1900;
                                           int d1=t.start.getDate();
                                           int m1=t.start.getMonth();
					    
	                    if((year==y&&month<=m&&day<=d&&day>=d1)||(year==y&&month>=m1&&day>=d1&&day<=d))
			                    {
					    	
					    	
					    	
					    	Iterator<taxi> it=taxilist.iterator();
					    	while(it.hasNext())
					    	{
					    		taxi z=it.next();
					    	    if(z.reg_no.equals(t.reg_num))
					    	    {
					    	    	
					    	    	
					    	    	
					    	    	
					    	    	
								    	  Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
										  Statement statement1 = con1.createStatement();
									      ResultSet result1 = statement1.executeQuery("SELECT * FROM taxi");
								         while(result1.next())
								    {
							                    taxi k = new taxi();
							           
							            {   k.reg_no = result1.getString("reg_no");
							                    k.status= result1.getInt("status");
							                    k.driver=result1.getString("driver");
							                    k.capacity= result1.getInt("capacity");
							                    k.type=result1.getString("type");
									    k.reading=result1.getInt("reading");
									    k.wheeler=result1.getInt("wheeler");
									    k.maintenance=result1.getString("maintenance");
									    k.x=result1.getDouble("x");
									    k.y=result1.getDouble("y");
							                   
									    if(k.reg_no.equals(z.reg_no))
							                { Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
							                PreparedStatement statement2=con2.prepareStatement(
							   "UPDATE taxi SET status = ?" +", driver = ? , capacity = ? , type = ?, reading = ?, wheeler = ?, maintenance = ?, x = ?, y = ? WHERE reg_no = ?");
							               
							                statement2.setInt(1, 1);
							                statement2.setString(2, k.driver);
							                statement2.setInt(3, k.capacity );
							                statement2.setString(4, k.type);
							                statement2.setInt(5, k.reading);
							                statement2.setInt(6, k.wheeler);
							                statement2.setString(7, k.maintenance);
							                statement2.setDouble(8, t.x2);
							                statement2.setDouble(9, t.y2);
							    	        statement2.setString(10, k.reg_no);
							    	        statement2.executeUpdate();
							                }
								    }}
								    }
								         
					    	}
			                    }
	                    else
	                    {

					    	Iterator<taxi> it=taxilist.iterator();
					    	while(it.hasNext())
					    	{
					    		taxi z=it.next();
					    	    if(z.reg_no.equals(t.reg_num))
					    	    {
					    	    	
					    	    	
					    	    	
					    	    	
					    	    	
								    	  Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
										  Statement statement1 = con1.createStatement();
									      ResultSet result1 = statement1.executeQuery("SELECT * FROM taxi");
								         while(result1.next())
								    {
							                    taxi k = new taxi();
							           
							            {   k.reg_no = result1.getString("reg_no");
							                    k.status= result1.getInt("status");
							                    k.driver=result1.getString("driver");
							                    k.capacity= result1.getInt("capacity");
							                    k.type=result1.getString("type");
									    k.reading=result1.getInt("reading");
									    k.wheeler=result1.getInt("wheeler");
									    k.maintenance=result1.getString("maintenance");
									    k.x=result1.getDouble("x");
									    k.y=result1.getDouble("y");
							                    
									    if(k.reg_no.equals(z.reg_no))
							                { Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab","root","");
							                PreparedStatement statement2=con2.prepareStatement(
							   "UPDATE taxi SET status = ?" +", driver = ? , capacity = ? , type = ?, reading = ?, wheeler = ?, maintenance = ?, x = ?, y = ? WHERE reg_no = ?");
							                
							                statement2.setInt(1, 0);
							                statement2.setString(2, k.driver);
							                statement2.setInt(3, k.capacity );
							                statement2.setString(4, k.type);
							                statement2.setInt(5, k.reading);
							                statement2.setInt(6, k.wheeler);
							                statement2.setString(7, k.maintenance);
							                statement2.setDouble(8, k.x);
							                statement2.setDouble(9, k.y);
							    	        statement2.setString(10, k.reg_no);
							    	        statement2.executeUpdate();
							                }
								    }}
								        
								    }
								         
					    	}
	                    }
	                    
	                   
				    }
			}
					    	    	
					    	    	
					    	    	
					    	    	
					catch (SQLException exception)
				{
			            exception.printStackTrace();
				}
			 
			 try {
				gettaxi();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			
			 
			 }
		 
		
		 
	
		
		 public LandMarks find(Point2D p)
		 {
		 
		 for (Rectangle2D r : squares)
		 {
		 if (r.contains(p))
		 {
			 for(LandMarks m : marks)
			 {
				 if(m.getX()==r.getCenterX()&&m.getY()==r.getCenterY())
					 return m;
			 }
		 }
			 ;
	     }
		 return null;
		 }
	
		 public void add(Point2D p,String s)
		 {
	
		 double x = p.getX();
		 double y = p.getY();
		
		 current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH,
		 SIDELENGTH);
		 squares.add(current);
		 lm=new LandMarks(x,y,s);
		 marks.add(lm);
		 repaint();
		 }
		 
	
	     
		  
		 private class MouseHandler extends MouseAdapter
		  {  
			 
		  public void mousePressed(final MouseEvent event)
		 {
			
			  
			  
			while(button.isEnabled()==false&&find(event.getPoint())!=null)
		{
			
		   if(find(event.getPoint())!=null&&temp==false)
			{
			   
		    connections[i][0]=(find(event.getPoint()).getX());
		    connections[i][1]=(find(event.getPoint()).getY());
		    temp=true;
		    break;
			}

			if(find(event.getPoint())!=null&&temp==true)
			{
				connections[i][2]=(find(event.getPoint()).getX());
			    connections[i][3]=(find(event.getPoint()).getY());
			    temp=false;
			    try {
					PrintWriter out = new PrintWriter(new FileOutputStream(new File("connections.txt"), true));
					out.append((int)connections[i][0]+" "+ (int)connections[i][1] +" " + 
					(int)connections[i][2]+ " " + (int)connections[i][3]);
					out.append("\n");
					out.close();
					Line2D z=new Line2D.Double((int)connections[i][0], (int)connections[i][1],
							(int)connections[i][2],(int)connections[i][3]);
					linelist.add(z);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				button.setEnabled(true);
				i++;
				repaint();
				
			}
	
		}
		try{	if(button1.isEnabled()==false)
			{
			for( Line2D l  : linelist )
			 {   String k=(int)l.getX1()+" "+(int)l.getY1()+" " +(int)l.getX2()+" "+(int)l.getY2();
			     String k1=(int)l.getX2()+" "+(int)l.getY2()+" " +(int)l.getX1()+" "+(int)l.getY1();
				if( l.getBounds().contains(event.getPoint()) )
	              { 
				          try {
	                    	  File file = new  File("connections.txt");
	                    	  File temp=new File("temp.txt");
	                    	  Scanner scanner = new Scanner(file);
	                    	  PrintWriter out = new PrintWriter(new FileOutputStream(temp), true);
	                    	    while (scanner.hasNextLine()) 
	                    	    	{   
	                    	    		String line = scanner.nextLine().trim();
	                    	    		if((!line.equals(k)
	                    	    			))
	                    	    		
	                    	    		{
	                    	    			out.append(line);
	                    	    			out.append("\n");
	                    	    			}
	                    	    	}
	                    	       out.close();
	                    	   Scanner s=new Scanner(temp);
	                    	   PrintWriter w = new PrintWriter(file);
	                    	   while(s.hasNextLine())
	                    	   {
	                    		   String line=s.nextLine();
	                    		   w.append(line);
	                    		   w.append("\n");
	                    	   }
	                    	   w.close();
	                    	
	                    	       linelist.remove(l);
	                    	       button1.setEnabled(true);
	  	                           repaint();
	  	                         
	                    	    }
				           catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
	                  }
			 }
			}
			else if((button1.isEnabled()==false&&button.isEnabled()==false&&temp1==false)||
					(button1.isEnabled()==true&&button.isEnabled()==true))
			{
				final TextField f=new TextField();
				temp1=true;
		 f.setBounds(event.getX(),event.getY(),60,15);
		 if (find(event.getPoint()) == null)
         add(f);
         
		 f.addKeyListener(new KeyListener()
		
		 {
		 public void keyPressed(KeyEvent e)
		 {
		 if(e.getKeyCode() == KeyEvent.VK_ENTER)
		 {
			 String t=f.getText();
			  if (find(event.getPoint()) == null) {
				  
				  add(event.getPoint(),t);
			  
			 
			   try {
					 PrintWriter out = new PrintWriter(new FileOutputStream(new File("landmarks.txt"), true));
					 out.append(Integer.toString(event.getX()) + " " + 
					 Integer.toString(event.getY())+" "+ t);
					 out.append("\n");
					 out.close();
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				}	
	     f.setVisible(false);
	     temp1=false;
	     
		 }	 
		 }
		public void keyReleased(KeyEvent arg0) {
			}
        public void keyTyped(KeyEvent arg0) {
			}
		 });
		 System.out.println(f.getText());
	
			}
		 
		 }catch(Exception e){}
		  }
		  }
		  private class MouseMotionHandler implements MouseMotionListener
		  {
		  
		  public void mouseMoved(MouseEvent event)
		  {  
			  
			  LandMarks l=find(event.getPoint());
			  if (find(event.getPoint()) != null) 
			  setToolTipText(l.getName() + " - " + "("+ Double.toString(l.getX())+ " E, " + 
			  Double.toString(l.getY())+" S)");
	      }
        
	
		public void mouseDragged(MouseEvent e) {
			if(find(e.getPoint())!=null)
			{
			
			}
         
          }
		  }
		 
		  class LandMarks
		 {
			 double x,y;
			 String s;
			public LandMarks(double a,double b, String c)
			 {
				 x=a;
				 y=b;
				 s=c;
			 }
			public double getX()
		     {
				return x;
			 }
			public double getY()
			{
				return y;
			}
			public String getName()
			{
				return s;
			}
			
	     }
		 }
		
		class booking
		{
			public double x1,x2,y1,y2;
			public String reg_num;
			public Date start,end;
			
		}
		
		
		 class taxi
		 {
		     public String reg_no;
		     public int status;      //booked or not.
		     public String driver;
		     public int capacity;    // number of people atmax
		     public String type;     //ac or not
		     public int reading;     //km reading per day
		     public int wheeler;     // 3 or 4
		     public String maintenance;  //put detail
		     public double x;
		     public double y;
		     public taxi(String reg_no, int status, String driver, int capacity,
		    		 String type, int reading, int wheeler, String maintenance, double x, double y )
		     {
		         this.reg_no=reg_no;
		         this.status=status;
		         this.driver=driver;
		         this.capacity=capacity;
		         this.type=type;
		         this.reading=reading;
		         this.wheeler=wheeler;
		         this.maintenance=maintenance;
		         this.x=x;
		         this.y=y;
		     }
		     public taxi()
		     {
		         reg_no=null;
		         status=0;
		         driver=null;
		         capacity=0;
		         type=null;
		         reading=0;
		         wheeler=0;
		         maintenance=null;
		         x=0.0;
		         y=0.0;
		     }
		 }
		  


		 