package Design;
import databaseService.taxiService;
import cab_schedule.taxi ;
import java.util.*;
import java.io.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.event.*;
import java.awt.event.*;
import java.lang.String;
import Tables.taxiTable;
public class taxiForm extends javax.swing.JFrame 
{
    private taxiTable t = new taxiTable();
    private taxiService service=new taxiService();
    String c[] = {"Available","Not Available"};
    String d[] = {"AC and 3 wheeler", "Non AC and 3 wheeler", "AC and 4 wheeler", "Non AC and 4 wheeler"};
    /** Creates new form bookForm */
    public taxiForm()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
        //int x = (dim.width-this.getWidth())/3;
        //int y = (dim.height-this.getHeight())/3;
	int x= dim.width/7;
	int y=dim.height/8;
	setLocation(x, y);
	this.service = service;
        try {
            t.setData(service.gettaxi());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
	initComponents();
	jTable1.setModel(t);
	
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

           
            @Override
            public void valueChanged(ListSelectionEvent e) 
	    {
                int row = jTable1.getSelectedRow();
                if (row != -1) {
                    taxi tx = t.get(row);
                    jTextField2.setText(tx.reg_no);
                    jTextField4.setText(String.valueOf(tx.capacity));
		    jTextField3.setText(tx.driver);
                    double a=tx.x;
		    double b=tx.y;
		    
		    try{
			Scanner s=new Scanner(new File("landmarks.txt"));
			 while(s.hasNextInt())
			   {
				   int aa=s.nextInt();
				   int bb=s.nextInt();
				   String str=s.next();
				   if((int)a==aa && (int)b==bb)
				   {
				       jTextField5.setText(str);
				   }
			   }
			}
		    catch(IOException ee){}
		    
		    jTextArea1.setText(tx.maintenance);
		    jTextField7.setText(String.valueOf(tx.reading));
		    
		    if(tx.status==0)
		    {
			jComboBox1.setSelectedItem(0);
		    }
		    else
		    {
			jComboBox1.setSelectedItem(1);
		    }
		    if(tx.type=="ac" && tx.wheeler==3)
		    {
			jComboBox2.setSelectedItem(0);
		    }
		    else if(tx.type=="non_ac" && tx.wheeler==3)
		    {
			jComboBox2.setSelectedItem(1);
		    }
		    else if(tx.type=="ac" && tx.wheeler==4)
		    {
			jComboBox2.setSelectedItem(2);
		    }
		    else if(tx.type=="non_ac" && tx.wheeler==4)
		    {
			jComboBox2.setSelectedItem(3);
		    }
                }
            }
        });
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 180, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SEARCH BY REG_NO.");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 180, 30));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TAXI LIST");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 190, 30));

        jTextField2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reg No.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 80, 20));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Availability");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 359, 100, 30));

        jTextField3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 140, 30));

        jComboBox1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Not Available" }));
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.setEditor(null);
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seating Capacity");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 399, 130, 30));

        jTextField4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Driver Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 289, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Type");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 34, 30));

        jComboBox2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC and 3 wheelers", "Non AC and 3 wheeler", "AC and 4 wheeler", "Non AC and 4 wheeler" }));
        jComboBox2.setBorder(null);
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2.setEditor(null);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 240, -1));

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Maintenance Detail");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 140, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 170, 120));

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Location");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 90, -1));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("City Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 100, 30));

        jTextField5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 150, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("INSERT");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 90, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 90, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DELETE");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 90, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("REFRESH");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 90, 30));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 910, 210));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Reading per Km");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 449, 120, 30));

        jTextField7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 150, 30));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("BACK");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, 90, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("SEARCH BY DRIVER");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 160, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Apple-Wood.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
	dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
	try{
	List<taxi> l=service.gettaxi();
	t.setData(l);
	jTextField1.setText(null);
	jTextField2.setText(null);
        jTextField4.setText(null);
	jTextField3.setText(null);
        jTextField5.setText(null);
	jTextArea1.setText(null);
	jTextField7.setText(null);
	jComboBox1.setSelectedItem(0);
	jComboBox2.setSelectedItem(0);
	}
    catch(Exception e){ e.printStackTrace();}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
	String keyword = jTextField1.getText();
        List<taxi> list = new ArrayList<taxi>();
      try {
            list = service.getSearch_reg_no(keyword);
        } 
      catch (Exception e) 
	{
        }
	t.setData(list);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
	String keyword = jTextField1.getText();
        List<taxi> list = new ArrayList<taxi>();
      try {
            list = service.getSearch_driver(keyword);
        } 
      catch (Exception e) 
	{
        }
	t.setData(list);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
	try {
            taxi tt = new taxi();
	    tt.reg_no=jTextField2.getText();
	    tt.capacity=Integer.parseInt(jTextField4.getText());
	tt.driver=jTextField3.getText();
        String from=jTextField5.getText();
	    try{
			Scanner s=new Scanner(new File("landmarks.txt"));
			 while(s.hasNextInt())
			   {
				   int aa=s.nextInt();
				   int bb=s.nextInt();
				   String str=s.next();
				   if(str.equals(from))
				   {
				       tt.x=(double)aa;
				       tt.y=(double)bb;
				   }
			   }
		}
	    catch(IOException ee){}
	
	
	tt.maintenance=jTextArea1.getText();
	tt.reading=Integer.parseInt(jTextField7.getText());
	//String c[] = {"Available","Not Available"};
   // String d[] = {"AC and 3 wheeler", "Non AC and 3 wheeler", "AC and 4 wheeler", "Non AC and 4 wheeler"};
	if(jComboBox1.getSelectedItem()=="Available")
	{
	    tt.status=0;
	}
	else
	{
	    tt.status=1;
	}
	
	if(jComboBox2.getSelectedItem()=="AC and 3 wheeler")
	{
	    tt.type="ac";
	    tt.wheeler=3;
	}
	else if(jComboBox2.getSelectedItem()=="Non AC and 3 wheeler")
	{
	    tt.type="non_ac";
	    tt.wheeler=3;
	}
	else if(jComboBox2.getSelectedItem()=="AC and 4 wheeler")
	{
	    tt.type="ac";
	    tt.wheeler=4;
	}
	else
	{
	    tt.type="non_ac";
	    tt.wheeler=4;
	}
            
	    service.inserttaxi(tt);
            t.insert(tt);

            try {
                List<taxi> list = service.gettaxi();
                t.setData(list);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
	List<taxi> l=new ArrayList<taxi>();
	try{
	    taxi tt = new taxi();
	    tt.reg_no=jTextField2.getText();
	    tt.capacity=Integer.parseInt(jTextField4.getText());
	tt.driver=jTextField3.getText();
	
        String from=jTextField5.getText();
	    try{
			Scanner s=new Scanner(new File("landmarks.txt"));
			 while(s.hasNextInt())
			   {
				   int aa=s.nextInt();
				   int bb=s.nextInt();
				   String str=s.next();
				   if(str.equals(from))
				   {
				       tt.x=(double)aa;
				       tt.y=(double)bb;
				   }
			   }
		}
	    catch(IOException ee){}
	
	tt.maintenance=jTextArea1.getText();
	tt.reading=Integer.parseInt(jTextField7.getText());
	//String c[] = {"Available","Not Available"};
   // String d[] = {"AC and 3 wheeler", "Non AC and 3 wheeler", "AC and 4 wheeler", "Non AC and 4 wheeler"};
	if(jComboBox1.getSelectedItem()=="Available")
	{
	    tt.status=0;
	}
	else
	{
	    tt.status=1;
	}
	
	if(jComboBox2.getSelectedItem()=="AC and 3 wheeler")
	{
	    tt.type="ac";
	    tt.wheeler=3;
	}
	else if(jComboBox2.getSelectedItem()=="Non AC and 3 wheeler")
	{
	    tt.type="non_ac";
	    tt.wheeler=3;
	}
	else if(jComboBox2.getSelectedItem()=="AC and 4 wheeler")
	{
	    tt.type="ac";
	    tt.wheeler=4;
	}
	else
	{
	    tt.type="non_ac";
	    tt.wheeler=4;
	}    
	service.updatetaxi(tt);
	int row = jTable1.getSelectedRow();
            if (row == -1)
                return;
            t.update(row, tt);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
	try{
	    taxi tt=new taxi();
	    tt.reg_no=jTextField2.getText();
	    tt.capacity=Integer.parseInt(jTextField4.getText());
	    tt.driver=jTextField3.getText();
	    
	    String from=jTextField5.getText();
	    try{
			Scanner s=new Scanner(new File("landmarks.txt"));
			 while(s.hasNextInt())
			   {
				   int aa=s.nextInt();
				   int bb=s.nextInt();
				   String str=s.next();
				   if(str.equals(from))
				   {
				       tt.x=(double)aa;
				       tt.y=(double)bb;
				   }
			   }
		}
	    catch(IOException ee){}
	    
	    tt.maintenance=jTextArea1.getText();
	    tt.reading=Integer.parseInt(jTextField7.getText());
	    if(jComboBox1.getSelectedItem()=="Available")
	    tt.status=0;
	    else
	    tt.status=1;
	
	    if(jComboBox2.getSelectedItem()=="AC and 3 wheeler")
	    {
		tt.type="ac";
	        tt.wheeler=3;
	    }
	    else if(jComboBox2.getSelectedItem()=="Non AC and 3 wheeler")
	    {
		tt.type="non_ac";
	        tt.wheeler=3;
	    }
	    else if(jComboBox2.getSelectedItem()=="AC and 4 wheeler")
	    {
		tt.type="ac";
	        tt.wheeler=4;
	    }
	    else
	    {
		tt.type="non_ac";
	        tt.wheeler=4;
	    }   
	    service.deletetaxi(tt);
	    List<taxi> list = service.gettaxi();
            t.setData(list);
	}
	catch(Exception e){
	     e.printStackTrace();
	}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new taxiForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
