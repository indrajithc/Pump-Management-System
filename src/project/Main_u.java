/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils; 
import static project.Utils.getAllComponents;

/**
 *
 * @author indrajith
 */
public class Main_u extends javax.swing.JFrame {

    /**
     * Creates new form Main_
     */
     Global_For_New_Ideas jok = new Global_For_New_Ideas();
    String empid = "";
    public Main_u() {
        initComponents();
        
        
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1300, 700));
    
              
             ///////////////////ful scrn
         addWindowListener(new WindowAdapter() {
public void windowOpened(WindowEvent e) {
setExtendedState(MAXIMIZED_BOTH);
}
});
/////////////////////////////////////////////////////////////////!
    /*
show the time
*/
    
    
    
    setDateAndTime();
    
        jTable1.setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getDefaultRenderer(Object.class)).setOpaque(false);

        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);

        jTable1.setShowGrid(false);
        jTable1.setEnabled(false);
        
        setSomtngBBB();
        
        
    }

    
    
    void setSomtngBBB() {
        
        try {
            
        ammountz.setOpaque(false); 
ammountz.getRootPane().setOpaque(false);
        ammountz.setBackground(new Color(TOP_ALIGNMENT, TOP_ALIGNMENT, TOP_ALIGNMENT, (float) (0.3)));
  
ammountz.setForeground(new java.awt.Color(255, 255, 255));
            
            
        } catch (Exception e) {
        }
        
        
        

    }
     
     public void setDateAndTime()
    {
        System.out.println("success 11111 1");
        Thread d=new Thread()
        {  
            public void run()
            { System.out.println("success 22222");
                for(;;)
                {
                                    ////////////////////////////////////////////////
                                                        //date                      ////
                       DateFormat dateFormat=new SimpleDateFormat("dd - MM - YYYY");    ////
                      Calendar cal=Calendar.getInstance();                          ////

                      dsptoday.setText(dateFormat.format(cal.getTime()));           ////
                                           /////////
                                                        //time                      ////
                      DateFormat timeFormat = new SimpleDateFormat("hh : mm : ss : SSS  aa");     ////
                      Calendar clo = Calendar.getInstance();                        ////
                      dsptime.setText(timeFormat.format(clo.getTime()));            ////
              //        btime.setText(timeFormat.format(clo.getTime()));   /////////////////////
                                         ////////////////////////////////////////////////  
                                                
                             try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Log_in.class.getName()).log(Level.SEVERE, null, ex);
            }                               
                                                
                }
                    

        
            }
        };
//        System.out.print(xx);
//        if(xx==0)
             d.start();
//        else
//            d.stop();
    }

     
     
     public void setForEmpId( String emp_id) {
         empid = emp_id;
         
         /*
         all aher strat up appz here 
         */
         
         
                           
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM employee WHERE  empid='"+empid+"' AND satus='employee'";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
        
 
fname1.setText(mysqlitem.rs.getString("fname")+" "+ mysqlitem.rs.getString("lname") );




mobile1.setText(""+mysqlitem.rs.getBigDecimal("mno"));




                   try {
                       int i = mysqlitem.rs.getInt("day");
                       if (i == 1) {
                           time.setText(" day ");
                       } else {
                            time.setText(" night ");
                       }
                   } catch (Exception e) {
                   }




 byte[] imagedata = mysqlitem.rs.getBytes("icon");
                ImageIcon format = null;

                outputimg = imagedata;
                format = new ImageIcon(imagedata);
                img_h.setIcon(format);
        
        
       
        
               } catch (Exception e) {
               }
 

            
               
           }
          
System.out.println("success");
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }  
         
         
         
         updateTheControls();
         
         showAllInThisClick ();
         
    
        actionAtTheForstToshow();
        
        System.err.println("ffffffffffffffffff");
     }
     
     
    
     
     void updateTheControls() {
         
         
           try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = " SELECT * FROM area WHERE selected = '1'";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                
                area.setText(""+mysqlitem.rs.getInt("id"));
                area1.setText(""+mysqlitem.rs.getString("area"));
                
                
        
                

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }
         
         
           
           
             MysqlConnect  mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM area_details WHERE `area_id`="+area.getText()+"  ORDER BY `area_details`.`date` DESC LIMIT 1";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
        
ppriz.setText(mysqlitem.rs.getFloat("p_price")+"") ;
ppriz1.setText(mysqlitem.rs.getFloat("d_price")+"") ;



lstupdt.setText(""+ mysqlitem.rs.getDate("date"));
lstupdt1.setText(""+ mysqlitem.rs.getDate("date"));

 
        
               } catch (Exception e) {
               }
 

            
               
           }
          
System.out.println("success");
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }  
 
 
 
           
 
 
 
 
 
    
        
           
         mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
 query = "SELECT * FROM fuel ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
                   if (mysqlitem.rs.getString("fuel_name").equals( "petrol")) {
                       
 
                       int a = mysqlitem.rs.getInt("capacity");
                       int b = mysqlitem.rs.getInt("availability");
  //s3d1.setText("capacity : "+a + "  Litres ");
  //s3d2.setText("availability : "+b+ "  Litres ");
 
  p_l_av.setText(b+" Litres");
  avl.setText(" "+(b * 100 /a)+" %");
 
  
                   }
        
  if (mysqlitem.rs.getString("fuel_name").equals("diesel")) {
                       
      int a = mysqlitem.rs.getInt("capacity");
                       int b = mysqlitem.rs.getInt("availability");
  //s3d6.setText("capacity : "+a+ "  Litres ");
  //s3d5.setText("availability : "+b+ "  Litres ");
 d_l_av.setText(b+" Litres");
  avl1.setText(" "+(b * 100 /a) +" %");
 
  
 
                   }
        
 
 



        
               } catch (Exception e) {
                   
                   
               }
 

               
           }
          
System.out.println("success");
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }  
         
     }
     
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        show_error = new javax.swing.JDialog();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        msg_img = new javax.swing.JLabel();
        msg_dsc = new javax.swing.JTextArea();
        msg_hhd = new javax.swing.JLabel();
        settBGimg = new javax.swing.JFileChooser();
        change_passwd = new javax.swing.JDialog();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        passwrd1 = new javax.swing.JPasswordField();
        passwrd2 = new javax.swing.JPasswordField();
        passwrd3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        bs_main = new javax.swing.JLayeredPane();
        main0 = new javax.swing.JLayeredPane();
        main1 = new javax.swing.JLayeredPane();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        dsptime = new javax.swing.JLabel();
        dstatus = new javax.swing.JLabel();
        pstatus = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        ussr = new javax.swing.JTextField();
        ammountz = new javax.swing.JTextField();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lorp = new javax.swing.JLabel();
        tota = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        total_mi = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        l = new javax.swing.JRadioButton();
        p = new javax.swing.JRadioButton();
        stus_text = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dsptoday = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        p_l_av = new javax.swing.JLabel();
        d_l_av = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ppriz = new javax.swing.JLabel();
        avl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lstupdt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ppriz1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lstupdt1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        avl1 = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        area1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        img_h = new javax.swing.JLabel();
        fname1 = new javax.swing.JLabel();
        mobile1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel30 = new javax.swing.JLabel();
        imageofpast = new javax.swing.JLabel();
        mobile2 = new javax.swing.JLabel();
        empiddd = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        fname2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        v_loginT0me = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        v_logouttime = new javax.swing.JLabel();
        v_pl = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        v_dl = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        vpr = new javax.swing.JLabel();
        v_dp = new javax.swing.JLabel();
        bk_img = new javax.swing.JLayeredPane();
        bg_Image = new javax.swing.JLabel();

        show_error.setMinimumSize(new java.awt.Dimension(350, 90));
        show_error.setUndecorated(true);
        show_error.getContentPane().setLayout(new javax.swing.OverlayLayout(show_error.getContentPane()));

        jLayeredPane9.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane9.setOpaque(true);

        msg_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/error.png"))); // NOI18N
        msg_img.setText("jLabel16");
        jLayeredPane9.add(msg_img);
        msg_img.setBounds(10, 0, 80, 90);

        msg_dsc.setColumns(20);
        msg_dsc.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        msg_dsc.setForeground(new java.awt.Color(102, 0, 0));
        msg_dsc.setLineWrap(true);
        msg_dsc.setRows(5);
        msg_dsc.setBorder(null);
        msg_dsc.setOpaque(false);
        jLayeredPane9.add(msg_dsc);
        msg_dsc.setBounds(100, 30, 230, 50);

        msg_hhd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        msg_hhd.setForeground(new java.awt.Color(255, 0, 0));
        jLayeredPane9.add(msg_hhd);
        msg_hhd.setBounds(100, 10, 200, 20);

        show_error.getContentPane().add(jLayeredPane9);

        change_passwd.setAlwaysOnTop(true);
        change_passwd.setMinimumSize(new java.awt.Dimension(450, 350));
        change_passwd.getContentPane().setLayout(null);

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 153, 153));
        jLabel34.setText("Change Password");
        change_passwd.getContentPane().add(jLabel34);
        jLabel34.setBounds(10, 10, 390, 40);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("New Password ");
        change_passwd.getContentPane().add(jLabel36);
        jLabel36.setBounds(10, 140, 110, 19);

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Re - Password ");
        change_passwd.getContentPane().add(jLabel37);
        jLabel37.setBounds(10, 190, 110, 19);

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Old Password ");
        change_passwd.getContentPane().add(jLabel39);
        jLabel39.setBounds(10, 90, 110, 19);

        passwrd1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        change_passwd.getContentPane().add(passwrd1);
        passwrd1.setBounds(140, 80, 230, 30);

        passwrd2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        change_passwd.getContentPane().add(passwrd2);
        passwrd2.setBounds(140, 130, 230, 30);

        passwrd3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        change_passwd.getContentPane().add(passwrd3);
        passwrd3.setBounds(140, 180, 230, 30);

        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        change_passwd.getContentPane().add(jButton1);
        jButton1.setBounds(264, 270, 110, 25);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jDesktopPane1.setMinimumSize(new java.awt.Dimension(1300, 700));
        jDesktopPane1.setLayout(new javax.swing.OverlayLayout(jDesktopPane1));

        bs_main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bs_mainMouseEntered(evt);
            }
        });

        main0.setPreferredSize(new java.awt.Dimension(1360, 768));
        main0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                main0MouseEntered(evt);
            }
        });
        main0.setLayout(new javax.swing.OverlayLayout(main0));

        main1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        main1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                main1MouseEntered(evt);
            }
        });

        jLayeredPane8.setBackground(new java.awt.Color(0, 0, 0, 200));
        jLayeredPane8.setOpaque(true);

        dsptime.setFont(new java.awt.Font("Sony Sketch EF", 1, 18)); // NOI18N
        dsptime.setForeground(new java.awt.Color(255, 255, 255));
        dsptime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dsptime.setText("dsd");
        dsptime.setToolTipText("");
        jLayeredPane8.add(dsptime);
        dsptime.setBounds(10, 10, 420, 30);

        dstatus.setBackground(new java.awt.Color(0, 255, 0));
        dstatus.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        dstatus.setForeground(new java.awt.Color(255, 255, 255));
        dstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dstatus.setText("DIESEL");
        dstatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dstatusMouseClicked(evt);
            }
        });
        jLayeredPane8.add(dstatus);
        dstatus.setBounds(230, 50, 200, 30);

        pstatus.setBackground(new java.awt.Color(0, 255, 0));
        pstatus.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        pstatus.setForeground(new java.awt.Color(255, 255, 255));
        pstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pstatus.setText("PETROL");
        pstatus.setOpaque(true);
        pstatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pstatusMouseClicked(evt);
            }
        });
        jLayeredPane8.add(pstatus);
        pstatus.setBounds(10, 50, 200, 30);

        jLabel14.setFont(new java.awt.Font("Sony Sketch EF", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("total price :");
        jLabel14.setToolTipText("");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLayeredPane6.add(jLabel14);
        jLabel14.setBounds(20, 420, 90, 40);

        ussr.setText("user");
        ussr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        ussr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ussrActionPerformed(evt);
            }
        });
        jLayeredPane6.add(ussr);
        ussr.setBounds(120, 490, 280, 30);

        ammountz.setEditable(false);
        ammountz.setFont(new java.awt.Font("Sony Sketch EF", 0, 48)); // NOI18N
        ammountz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        ammountz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ammountzActionPerformed(evt);
            }
        });
        jLayeredPane6.add(ammountz);
        ammountz.setBounds(20, 60, 380, 70);

        jLayeredPane10.setLayout(new java.awt.GridLayout(4, 3, 3, 3));

        jLabel17.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel17.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("7");
        jLabel17.setOpaque(true);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel17);

        jLabel18.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel18.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("8");
        jLabel18.setOpaque(true);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel18);

        jLabel19.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel19.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("9");
        jLabel19.setOpaque(true);
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel19);

        jLabel20.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel20.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("4");
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel20);

        jLabel21.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel21.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("5");
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel21);

        jLabel22.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel22.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("6");
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel22);

        jLabel23.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel23.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("1");
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel23);

        jLabel24.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel24.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("2");
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel24);

        jLabel25.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel25.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("3");
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel25);

        jLabel26.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel26.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("c");
        jLabel26.setOpaque(true);
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel26);

        jLabel27.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel27.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("0");
        jLabel27.setOpaque(true);
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel27);

        jLabel28.setBackground(new java.awt.Color(153, 153, 153, 200));
        jLabel28.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("=");
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        jLayeredPane10.add(jLabel28);

        jLayeredPane6.add(jLayeredPane10);
        jLayeredPane10.setBounds(20, 140, 380, 260);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("price calculated by ");
        jLayeredPane6.add(jLabel15);
        jLabel15.setBounds(130, 150, 150, 0);

        lorp.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lorp.setForeground(new java.awt.Color(255, 255, 255));
        lorp.setText("P");
        jLayeredPane6.add(lorp);
        lorp.setBounds(320, 140, 70, 0);

        tota.setEditable(false);
        tota.setFont(new java.awt.Font("Sony Sketch EF", 0, 36)); // NOI18N
        tota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        tota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totaActionPerformed(evt);
            }
        });
        jLayeredPane6.add(tota);
        tota.setBounds(120, 420, 280, 60);

        jLabel16.setFont(new java.awt.Font("Sony Sketch EF", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("user :");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLayeredPane6.add(jLabel16);
        jLabel16.setBounds(20, 490, 90, 30);
        jLayeredPane6.add(total_mi);
        total_mi.setBounds(99, 490, 300, 30);

        jLabel29.setBackground(new java.awt.Color(51, 255, 255, 100));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("FINISH");
        jLabel29.setOpaque(true);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
        });
        jLayeredPane6.add(jLabel29);
        jLabel29.setBounds(20, 540, 380, 40);

        jLayeredPane8.add(jLayeredPane6);
        jLayeredPane6.setBounds(10, 120, 420, 580);

        buttonGroup1.add(l);
        l.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        l.setForeground(new java.awt.Color(255, 255, 255));
        l.setText("amount");
        l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lActionPerformed(evt);
            }
        });
        jLayeredPane8.add(l);
        l.setBounds(60, 90, 150, 27);

        buttonGroup1.add(p);
        p.setFont(new java.awt.Font("Sony Sketch EF", 1, 24)); // NOI18N
        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setSelected(true);
        p.setText("price");
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });
        jLayeredPane8.add(p);
        p.setBounds(210, 90, 150, 27);

        stus_text.setForeground(new java.awt.Color(255, 255, 255));
        stus_text.setText("PETROL");
        jLayeredPane8.add(stus_text);
        stus_text.setBounds(240, 60, 110, 0);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("fuel :");
        jLayeredPane8.add(jLabel13);
        jLabel13.setBounds(110, 60, 60, 0);

        main1.add(jLayeredPane8);
        jLayeredPane8.setBounds(10, 10, 440, 710);

        jLayeredPane5.setBackground(new java.awt.Color(0, 0, 0, 200));
        jLayeredPane5.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("history");
        jLayeredPane5.add(jLabel12);
        jLabel12.setBounds(10, 20, 140, 20);

        jTable1.setForeground(new java.awt.Color(255, 255, 255));
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
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        jLayeredPane5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 53, 280, 440);

        dsptoday.setFont(new java.awt.Font("Sony Sketch EF", 1, 18)); // NOI18N
        dsptoday.setForeground(new java.awt.Color(255, 255, 255));
        dsptoday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dsptoday.setText("dsd");
        dsptoday.setToolTipText("");
        dsptoday.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLayeredPane5.add(dsptoday);
        dsptoday.setBounds(130, 10, 150, 30);

        main1.add(jLayeredPane5);
        jLayeredPane5.setBounds(460, 10, 300, 500);

        jLayeredPane2.setBackground(new java.awt.Color(0, 0, 0, 200));
        jLayeredPane2.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText(" fuel details");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLayeredPane2.add(jLabel2);
        jLabel2.setBounds(10, 30, 140, 30);

        jLayeredPane4.setBackground(new java.awt.Color(0, 0, 3, 200));
        jLayeredPane4.setOpaque(true);

        p_l_av.setForeground(new java.awt.Color(214, 209, 229));
        p_l_av.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        p_l_av.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLayeredPane4.add(p_l_av);
        p_l_av.setBounds(150, 110, 120, 30);

        d_l_av.setForeground(new java.awt.Color(214, 209, 229));
        d_l_av.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        d_l_av.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLayeredPane4.add(d_l_av);
        d_l_av.setBounds(150, 310, 120, 30);

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PETROL");
        jLayeredPane4.add(jLabel1);
        jLabel1.setBounds(10, 10, 70, 15);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("PETROL  PRICE :");
        jLayeredPane4.add(jLabel5);
        jLabel5.setBounds(20, 40, 120, 19);

        ppriz.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ppriz.setForeground(new java.awt.Color(255, 255, 255));
        ppriz.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLayeredPane4.add(ppriz);
        ppriz.setBounds(150, 30, 120, 30);

        avl.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        avl.setForeground(new java.awt.Color(204, 102, 0));
        avl.setText("0.0");
        avl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLayeredPane4.add(avl);
        avl.setBounds(150, 150, 120, 40);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText(" available :");
        jLayeredPane4.add(jLabel8);
        jLabel8.setBounds(20, 110, 120, 19);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("last updated :");
        jLayeredPane4.add(jLabel9);
        jLabel9.setBounds(20, 70, 120, 15);

        lstupdt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lstupdt.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane4.add(lstupdt);
        lstupdt.setBounds(150, 70, 120, 20);

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DIESEL");
        jLayeredPane4.add(jLabel7);
        jLabel7.setBounds(10, 210, 70, 15);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DIESEL  PRICE :");
        jLayeredPane4.add(jLabel6);
        jLabel6.setBounds(20, 240, 120, 19);

        ppriz1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ppriz1.setForeground(new java.awt.Color(255, 255, 255));
        ppriz1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLayeredPane4.add(ppriz1);
        ppriz1.setBounds(150, 230, 120, 30);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("last updated :");
        jLayeredPane4.add(jLabel10);
        jLabel10.setBounds(30, 270, 110, 15);

        lstupdt1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lstupdt1.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane4.add(lstupdt1);
        lstupdt1.setBounds(150, 270, 120, 20);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText(" available :");
        jLayeredPane4.add(jLabel11);
        jLabel11.setBounds(20, 310, 120, 19);

        avl1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        avl1.setForeground(new java.awt.Color(0, 153, 0));
        avl1.setText("0.0");
        avl1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLayeredPane4.add(avl1);
        avl1.setBounds(140, 350, 120, 40);

        jLayeredPane2.add(jLayeredPane4);
        jLayeredPane4.setBounds(10, 60, 280, 430);

        area.setForeground(new java.awt.Color(102, 102, 102));
        area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        area.setText("area");
        jLayeredPane2.add(area);
        area.setBounds(220, 70, 40, 20);

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText(" per litre in rupees");
        jLayeredPane2.add(jLabel4);
        jLabel4.setBounds(150, 10, 140, 19);

        area1.setForeground(new java.awt.Color(204, 204, 204));
        area1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        area1.setText("area");
        jLayeredPane2.add(area1);
        area1.setBounds(190, 30, 100, 30);

        main1.add(jLayeredPane2);
        jLayeredPane2.setBounds(770, 10, 300, 500);

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0, 200));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.add(img_h);
        img_h.setBounds(50, 50, 170, 210);

        fname1.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        fname1.setForeground(new java.awt.Color(255, 255, 255));
        fname1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fname1.setText("ggfgf");
        jLayeredPane1.add(fname1);
        fname1.setBounds(80, 280, 180, 20);

        mobile1.setForeground(new java.awt.Color(255, 255, 255));
        mobile1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLayeredPane1.add(mobile1);
        mobile1.setBounds(80, 310, 180, 30);

        time.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        time.setText("fdfdf");
        jLayeredPane1.add(time);
        time.setBounds(100, 360, 150, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" personal details");
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(10, 10, 210, 20);

        jButton2.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jButton2.setText("change image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton2);
        jButton2.setBounds(40, 410, 190, 20);

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("mobile :");
        jLayeredPane1.add(jLabel31);
        jLabel31.setBounds(0, 320, 90, 19);

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("name :");
        jLayeredPane1.add(jLabel32);
        jLabel32.setBounds(10, 280, 80, 19);

        jButton3.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jButton3.setText("change password");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton3);
        jButton3.setBounds(40, 440, 190, 20);

        jButton4.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jButton4.setText("logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton4);
        jButton4.setBounds(40, 470, 190, 20);

        main1.add(jLayeredPane1);
        jLayeredPane1.setBounds(1080, 10, 270, 500);

        jLayeredPane3.setBackground(new java.awt.Color(0, 0, 3, 200));
        jLayeredPane3.setOpaque(true);

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("previous login details");
        jLayeredPane3.add(jLabel30);
        jLabel30.setBounds(710, 0, 180, 19);
        jLayeredPane3.add(imageofpast);
        imageofpast.setBounds(10, 10, 160, 180);

        mobile2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mobile2.setForeground(new java.awt.Color(255, 255, 255));
        mobile2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLayeredPane3.add(mobile2);
        mobile2.setBounds(180, 100, 160, 30);

        empiddd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        empiddd.setForeground(new java.awt.Color(255, 255, 255));
        empiddd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empiddd.setText("ggfgf");
        jLayeredPane3.add(empiddd);
        empiddd.setBounds(180, 20, 160, 30);

        time1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        time1.setText("fdfdf");
        jLayeredPane3.add(time1);
        time1.setBounds(180, 140, 160, 30);

        fname2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fname2.setForeground(new java.awt.Color(255, 255, 255));
        fname2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fname2.setText("ggfgf");
        jLayeredPane3.add(fname2);
        fname2.setBounds(180, 60, 160, 30);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jLayeredPane3.add(jSeparator1);
        jSeparator1.setBounds(390, 12, 10, 180);

        jLabel33.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("login time : ");
        jLayeredPane3.add(jLabel33);
        jLabel33.setBounds(400, 30, 120, 18);

        v_loginT0me.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        v_loginT0me.setForeground(new java.awt.Color(255, 255, 255));
        v_loginT0me.setText("time");
        jLayeredPane3.add(v_loginT0me);
        v_loginT0me.setBounds(520, 30, 190, 18);

        jLabel35.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("logout time : ");
        jLayeredPane3.add(jLabel35);
        jLabel35.setBounds(400, 50, 120, 18);

        v_logouttime.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        v_logouttime.setForeground(new java.awt.Color(255, 255, 255));
        v_logouttime.setText("time");
        jLayeredPane3.add(v_logouttime);
        v_logouttime.setBounds(520, 50, 190, 18);

        v_pl.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        v_pl.setForeground(new java.awt.Color(255, 255, 255));
        v_pl.setText("time");
        jLayeredPane3.add(v_pl);
        v_pl.setBounds(510, 90, 170, 17);

        jLabel38.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("PETROL");
        jLayeredPane3.add(jLabel38);
        jLabel38.setBounds(420, 90, 100, 17);

        v_dl.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        v_dl.setForeground(new java.awt.Color(255, 255, 255));
        v_dl.setText("time");
        jLayeredPane3.add(v_dl);
        v_dl.setBounds(510, 110, 170, 17);

        jLabel40.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("DIESEL");
        jLayeredPane3.add(jLabel40);
        jLabel40.setBounds(420, 110, 100, 17);

        vpr.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        vpr.setForeground(new java.awt.Color(255, 255, 255));
        vpr.setText("time");
        jLayeredPane3.add(vpr);
        vpr.setBounds(690, 90, 170, 17);

        v_dp.setFont(new java.awt.Font("DejaVu Serif", 1, 14)); // NOI18N
        v_dp.setForeground(new java.awt.Color(255, 255, 255));
        v_dp.setText("time");
        jLayeredPane3.add(v_dp);
        v_dp.setBounds(690, 110, 170, 17);

        main1.add(jLayeredPane3);
        jLayeredPane3.setBounds(460, 520, 890, 200);

        main0.add(main1);

        bs_main.add(main0);
        main0.setBounds(0, 0, 1370, 750);

        jDesktopPane1.add(bs_main);

        bk_img.setLayout(new javax.swing.OverlayLayout(bk_img));

        bg_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/bg_image.jpg"))); // NOI18N
        bk_img.add(bg_Image);

        jDesktopPane1.add(bk_img);

        jScrollPane1.setViewportView(jDesktopPane1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollBarUI());
        //UIManager.put("ScrollBarUI", "my.package.MyScrollBarUI");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void main1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main1MouseEntered

        // TODO add your handling code here:
    }//GEN-LAST:event_main1MouseEntered

    private void main0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main0MouseEntered

        // TODO add your handling code here:
    }//GEN-LAST:event_main0MouseEntered

    private void bs_mainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bs_mainMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bs_mainMouseEntered

    private void dstatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dstatusMouseClicked
        // TODO add your handling code here:
        
dstatus.setOpaque(true);

pstatus.setOpaque(false);



pstatus.repaint();
pstatus.revalidate();
dstatus.repaint();
dstatus.revalidate();
selected_item  = "DIESEL";
stus_text.setText(selected_item);
        actionForSetThis();
    }//GEN-LAST:event_dstatusMouseClicked

    private void pstatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pstatusMouseClicked
        // TODO add your handling code here:
        dstatus.setOpaque(false);

pstatus.setOpaque(true);

pstatus.repaint();
pstatus.revalidate();
dstatus.repaint();
dstatus.revalidate();
selected_item  = "PETROL";
stus_text.setText(selected_item);
        actionForSetThis();
    }//GEN-LAST:event_pstatusMouseClicked

    private void ussrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ussrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ussrActionPerformed

    private void ammountzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ammountzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ammountzActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        // TODO add your handling code here:
        
        tota.setText("");
        lorp.setText("P");
        actionForSetThis();
    }//GEN-LAST:event_pActionPerformed

    private void lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lActionPerformed
        // TODO add your handling code here:
        lorp.setText("L");
        tota.setText("");
        actionForSetThis();
    }//GEN-LAST:event_lActionPerformed

    private void totaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totaActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
         
         updateTheControls();
         
         showAllInThisClick ();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  try {
            // TODO add your handling code here:

            selectBgimg();
        } catch (Exception ex) {
            Logger.getLogger(Log_in.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
        JLabel jLable =  (JLabel) evt.getSource();
jLable.setBackground(new java.awt.Color(204, 204, 204, 200));
     

        actionForSetThis();
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
JLabel jLable =  (JLabel) evt.getSource();
jLable.setBackground(new java.awt.Color(153, 153, 153, 200));
        // TODO add your handling code here:
        
        actionForSetThis();
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
 if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;   
        
        return;
        }
        
        try {
            
        ammountz.setText(ammountz.getText()+"7");
            
        } catch (Exception e) {
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
      if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" error ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
         
        try {
            
        ammountz.setText(ammountz.getText()+"8");
            
        } catch (Exception e) {
        }
                   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
  if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
         
        try {
            
        ammountz.setText(ammountz.getText()+"9");
            
        } catch (Exception e) {
        }
                    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
  if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
         
        try {
            
        ammountz.setText(ammountz.getText()+"4");
            
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
  if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
         
        try {
            
        ammountz.setText(ammountz.getText()+"5");
            
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
      if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
         
        try {
            
        ammountz.setText(ammountz.getText()+"6");
            
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

        if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
         
        try {
            
        ammountz.setText(ammountz.getText()+"1");
            
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
     if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
      
        try {
            
        ammountz.setText(ammountz.getText()+"2");
            
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked

        if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
      
        try {
            
        ammountz.setText(ammountz.getText()+"2");
            
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
   try {
            
        String g = ammountz.getText();
        ammountz.setText(g.substring(0, (g.length())-1));
        
        } catch (Exception e) {
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked

        if (lorp.getText().length() < 1) {
            
        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
        
        return;
        }
         try {
            
        ammountz.setText(ammountz.getText()+"0");
            
        } catch (Exception e) {
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked

//        if (lorp.getText().length() < 1) {
//            
//        showAnEroorNotificatinOnDesktop(" drror ",  " select a price calculated type ", 5000 ) ;
//        
//        return;
//        }
//        
//
//        if (bb12.isSelected()) {
//            tota.setText(ammountz.getText());
//        }
//        
//         actIforCalcu();

        if (transactioncount>6) {
            showAnEroorNotificatinOnDesktop(" overflow error "," can't add this bill press finish, and take a new one", 5000 ) ;
            
        
            return;
        }


 submittActionPerform();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked

        
        for (int i = 0; i < transactioncount; i++) {
            
            for (int j = 0; j < 4; j++) {
                System.err.println(" "+ total[i][j]);
            }
            System.err.println("\n");
        }
        
        
        
        
        
         try {
            // TODO add your handling code here:
            printThis(ussr.getText(),  empid);
        } catch (Exception ex) {
            Logger.getLogger(Main_u.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            tota.setText("");
            
              JOptionPane.showMessageDialog(this, new String("successfully updated"));
                      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered

        jLabel29.setBackground(new java.awt.Color(153, 255, 255, 100));
        // TODO add your handling code here:
        
        actionForSetThis();
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited

jLabel29.setBackground(new java.awt.Color(51, 255, 255, 100));
        // TODO add your handling code here:
        
        actionForSetThis();
    }//GEN-LAST:event_jLabel29MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 change_passwd.setLocationRelativeTo(null);
           passwrd1.setText("");
         passwrd2.setText("");
         passwrd3.setText("");
          
        
        change_passwd.show();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

          if (passwrd1.getText().length() < 1) {

                //jok.dispalyEroorMessage("Please fill this field", 620, 250, 5000 );
                jok.setErrorForTextField("Please fill this field", passwrd1, this, 5000);
             return;
            }
            
          if (passwrd2.getText().length() < 1) {

                //jok.dispalyEroorMessage("Please fill this field", 620, 250, 5000 );
                jok.setErrorForTextField("Please fill this field", passwrd2, this, 5000);
             return;
            }
            
          if (passwrd3.getText().length() < 1) {

                //jok.dispalyEroorMessage("Please fill this field", 620, 250, 5000 );
                jok.setErrorForTextField("Please fill this field", passwrd3, this, 5000);
             return;
            }
            

           String passwrd = "";
             
        
                      
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM login WHERE  user_name = '"+empid+"' ; ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           while( mysqlitem.rs.next()){ 
               try {
                  
     
                   
           passwrd = mysqlitem.rs.getString("password");

 

                   
               } catch (Exception e) {
               }
                

               
           }
          
System.out.println("success");
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }  
        
        
        if (passwrd.equals(passwrd1.getText())) {
            
            if (passwrd2.getText().equals(passwrd3.getText())) {
                
                 try {
            
         mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
            query = " UPDATE `login` SET `password` = '"+passwrd3.getText()+"' WHERE user_name = '"+empid+"' ; ";
           
      
            System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
        
 change_passwd.hide();
            
         
            JOptionPane.showMessageDialog(this, new String("successfully updated"));

         passwrd1.setText("");
         passwrd2.setText("");
         passwrd3.setText("");
          
        
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
                
                
            } else {
           JOptionPane.showMessageDialog(this,
    "password mismatch",
    "Inane error",
    JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            
                   JOptionPane.showMessageDialog(this,
    "Password is incorrect.",
    "Inane error",
    JOptionPane.ERROR_MESSAGE);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

Log_in log_in = new Log_in();
log_in.show();
this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
 
    void selectBgimg() throws Exception
    {
       
        
        try {
 //JFileChooser chooser =  new javax.swing.JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter(
    "Image files", ImageIO.getReaderFileSuffixes());
        settBGimg.setFileFilter(imageFilter);
        
        settBGimg.showOpenDialog(null);
        File f = settBGimg.getSelectedFile();
        
        String filename = f.getAbsolutePath();
            System.err.println(filename);
            File inputFile = new File(filename);
            BufferedImage inputImage = ImageIO.read(inputFile);
//jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/100 Amazing Mixed Wallpapers 85 (18).jpg")));     
        
        Path s_sou = Paths.get(f.getAbsolutePath());
        File currentDirFile = new File(".");
         String helper = currentDirFile.getAbsolutePath();
         
        Path d_desti = Paths.get(helper+"/src/project/images/bg_image.jpg");
            try { 
                java.nio.file.Files.copy(s_sou, d_desti, StandardCopyOption.REPLACE_EXISTING);
                
            } catch (Exception e) {
                e.getMessage();
            }


String image_name ="";












            
            
              if(!((inputImage.getWidth()>= bg_Image.getWidth())&&( inputImage.getHeight()>= bg_Image.getHeight())))
            {  
                JOptionPane.showMessageDialog(this, new String("not a valid image "));
                return;
            } 

            BufferedImage outputImage = resizeImage(inputImage, inputImage.getWidth(), inputImage.getHeight(), bg_Image.getWidth(), bg_Image.getHeight());

        
            ImageIcon format = null;
            format = new ImageIcon(outputImage);
            bg_Image.setIcon(format);

            
//            
//        try {  
//   ImageIcon icon = new ImageIcon(helper+"/src/project/images/bg_image.jpg");
//icon.getImage().flush();
//bg_Image.setIcon( icon );
//   
//   
//   bk_img.add(bg_Image);
//   
//           image_name = bg_Image.getName();
//                
//            } catch (Exception e) {
//            }
//            System.err.println(image_name);
//
//            

            
            
            
            bg_Image.repaint();
            bg_Image.revalidate();
            
            
            
        } catch (Exception e) {
        }

//        inserIntoMysql();
    } 
   
    
    void printThis( String user,  String empid) throws IOException {
        
        
        
        Document document = new Document();
        String path = "bill.pdf";
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
         
         
            com.itextpdf.text.Rectangle pageSize;
          pageSize =  new com.itextpdf.text.Rectangle(460,550);
          
          document.setPageSize(pageSize);
        document.setMargins(2, 2, 2, 2);
         
         document.open();
         PdfContentByte canvas = writer.getDirectContent();
        
         
         document.add(new Paragraph(path));
         
        
         CMYKColor magentaColor = new CMYKColor(1.f, 1.f, 1.f, 1.f);
        canvas.setColorStroke(magentaColor);
        canvas.setLineWidth(2);
        //460,151
        canvas.moveTo(2, 550 - 150);
        canvas.lineTo(458, 550 -150);
        
        canvas.moveTo(2, 550 - 180);
        canvas.lineTo(458, 550 -180);
        
        canvas.moveTo(2, 550 - 220);
        canvas.lineTo(458, 550 -220);
        
        canvas.moveTo(2, 550 - 440);
        canvas.lineTo(458, 550 -440);
        
        canvas.moveTo(2, 550 - 480);
        canvas.lineTo(458, 550 -480);
        
        
        canvas.moveTo(340, 550 - 180);
        canvas.lineTo(340, 550 -480);
        
        canvas.moveTo(420, 550 - 220);
        canvas.lineTo(420, 550 -480);
        
        canvas.moveTo(280, 550 - 180);
        canvas.lineTo(280, 550 -480);
        
        
        
        canvas.moveTo(210, 550 - 180);
        canvas.lineTo(210, 550 -440);
        
        
       
        
 BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
       
canvas.beginText();

canvas.moveText(350, 550 - 15);
canvas.setFontAndSize(bf, 14);
canvas.showText("Tel.:9567979616");
canvas.endText();

canvas.beginText();
canvas.moveText(180, 550 - 40);
canvas.setFontAndSize(bf, 12);
canvas.showText("Cash-Memo");
canvas.endText();


//pump management system


canvas.beginText();
canvas.moveText(95, 550 - 100);
canvas.setFontAndSize(bf, 13);
canvas.showText("S C 34-47 New Link Road, ADV dnagar, Adoor");
canvas.endText();


canvas.beginText();
canvas.moveText(190, 550 - 115);
canvas.setFontAndSize(bf, 13);
canvas.showText("Pathanamthitta  691555");
canvas.endText();



canvas.beginText();
canvas.moveText(330, 550 - 135);
canvas.setFontAndSize(bf, 13);
canvas.showText("No.");
canvas.endText();

///////////////////////////////////////////////////////////////////////////
  

     

canvas.beginText();
canvas.moveText(10, 550 - 175);
canvas.setFontAndSize(bf, 16);
canvas.showText("Veh ID / No :");
canvas.endText();

/////////////////////////////////////////////////////////////////


 canvas.beginText();
canvas.moveText(280, 550 - 175);
canvas.setFontAndSize(bf, 16);
canvas.showText("Date");
canvas.endText();

//////////////////////////////////////////////////////////////////////////////////////////////////////////



canvas.beginText();
canvas.moveText(80, 550 - 210);
canvas.setFontAndSize(bf, 14);
canvas.showText(" Description");
canvas.endText();


canvas.beginText();
canvas.moveText(235, 550 - 210);
canvas.setFontAndSize(bf, 14);
canvas.showText("Qty");
canvas.endText();


canvas.beginText();
canvas.moveText(295, 550 - 210);
canvas.setFontAndSize(bf, 14);
canvas.showText("Rate");
canvas.endText();


canvas.beginText();
canvas.moveText(370, 550 - 200);
canvas.setFontAndSize(bf, 14);
canvas.showText("Amount");
canvas.endText();




canvas.beginText();
canvas.moveText(380, 550 - 216);
canvas.setFontAndSize(bf, 14);
canvas.showText("Rs");
canvas.endText();



canvas.beginText();
canvas.moveText(430, 550 - 216);
canvas.setFontAndSize(bf, 14);
canvas.showText("Ps");
canvas.endText();



canvas.beginText();
canvas.moveText(285, 550 - 473);
canvas.setFontAndSize(bf, 15);
canvas.showText("TOTAL");
canvas.endText();





canvas.beginText();
canvas.moveText(355, 550 - 520);
canvas.setFontAndSize(bf, 15);
canvas.showText("Salesman");
canvas.endText();




/////////////////////////////////////////////////


  bf = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

canvas.beginText();
canvas.moveText(50, 550 - 80);
canvas.setFontAndSize(bf, 25);
canvas.showText("PUMP MANAGEMENT SYSTEM");
canvas.endText();



  bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

  magentaColor = new CMYKColor(0, 93, 100, 0);
  
  canvas.setCMYKColorFillF(0, 93, 100, 0);
        
  
  int count = 1000;
          try {
              
  count += countResult("select count(*) FROM `billing` WHERE DATE(date) = CURDATE()");
          } catch (Exception e) {
          }
canvas.beginText();
canvas.moveText(355, 550 - 135);
canvas.setFontAndSize(bf, 20);
canvas.showText(""+count);
canvas.endText();
      

  canvas.setCMYKColorFillF(0, 93, 100, 100);

      


 bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

    SimpleDateFormat sdfhu = new SimpleDateFormat("dd/MM/yyyy");

canvas.beginText();
canvas.moveText(320, 550 - 175);
canvas.setFontAndSize(bf, 15);
canvas.showText(sdfhu.format(new Date()));
canvas.endText();


bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);


canvas.beginText();
canvas.moveText(10, 550 - 510);
canvas.setFontAndSize(bf, 13);
canvas.showText(empid);
canvas.endText();


     sdfhu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a , E");

canvas.beginText();
canvas.moveText(10, 550 - 530);
canvas.setFontAndSize(bf, 13);
canvas.showText(sdfhu.format( new Date()));
canvas.endText();


bf = BaseFont.createFont(BaseFont.TIMES_ITALIC, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);


canvas.beginText();
canvas.moveText(120, 550 - 175);
canvas.setFontAndSize(bf, 18);
canvas.showText(user);
canvas.endText();






bf = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);


//
//
//
//canvas.beginText();
//canvas.moveText(30, 550 - 260);
//canvas.setFontAndSize(bf, 18);
//canvas.showText("user  ");
//canvas.endText();
//
//canvas.beginText();
//canvas.moveText(350, 550 - 260);
//canvas.setFontAndSize(bf, 14);
//canvas.showText("Rs");
//canvas.endText();
//
//canvas.beginText();
//canvas.moveText(425, 550 - 260);
//canvas.setFontAndSize(bf, 14);
//canvas.showText("Ps");
//canvas.endText();


int loc  = 240;
float totd = 0;
          for (int i = 0; i < transactioncount; i++) {
              
              
              System.err.println(" i= "+1+"\n  = "+transactioncount+" \n");

canvas.beginText();
canvas.moveText(30, 550 - loc);
canvas.setFontAndSize(bf, 18);
canvas.showText(""+total[i][0]);
canvas.endText();


canvas.beginText();
canvas.moveText(235, 550 - loc);
canvas.setFontAndSize(bf, 14);
canvas.showText(""+total[i][1]);
canvas.endText();


canvas.beginText();
canvas.moveText(295, 550 - loc);
canvas.setFontAndSize(bf, 14);
canvas.showText(""+total[i][2]);
canvas.endText();


float valuea= Float.parseFloat(total[i][3]);
String value= ""+valuea;

totd+=Float.parseFloat(value);


              System.err.println("=== >"+value);
      
              String mai = "";
              String sub = "";
              try {
              mai = value.substring(0, value.indexOf("."));
              sub = value.substring(value.indexOf("."));
                  
              } catch (Exception e) {
              }
canvas.beginText();
canvas.moveText(350, 550 - loc);
canvas.setFontAndSize(bf, 14);
canvas.showText(mai);
canvas.endText();

canvas.beginText();
canvas.moveText(425, 550 - loc);
canvas.setFontAndSize(bf, 14);
canvas.showText(sub);
canvas.endText();
    

loc+=20;



              
              
              
          }

//totd
String value = ""+totd;

tota.setText(value);


  String mai = "";
              String sub = "";
              try {
              mai = value.substring(0, value.indexOf("."));
              sub = value.substring(value.indexOf("."));
                  
              } catch (Exception e) {
              } 
   canvas.beginText();
canvas.moveText(350, 550 - 473);
canvas.setFontAndSize(bf, 14);
canvas.showText(mai);
canvas.endText();

canvas.beginText();
canvas.moveText(425, 550 - 473);
canvas.setFontAndSize(bf, 14);
canvas.showText(sub);
canvas.endText();







        
        canvas.closePathStroke();
        
          try {
              
         writer.close();
         
         
         document.close();
         
         
          } catch (Exception e) {
          }
         
          
transactioncount = 0;
     

         
         
         
         if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File(path);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
        
    }
    
    
    
    
    
    boolean isPosibl( ) {
        boolean f = false;
        
           float avilbl_p = 0, capa = 0;
           
           
           
        int fu_id = 1;
        float one_prix = 0;
        
            if (stus_text.getText().equals("PETROL")) {
                fu_id = 1;
                one_prix = Float.parseFloat(ppriz.getText());
            }
        
            if (stus_text.getText().equals("DIESEL")) {
                fu_id = 2;
                one_prix = Float.parseFloat(ppriz1.getText());
            }
        
        
                  
  try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = "SELECT * FROM `fuel` WHERE id = "+fu_id+"";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                  
            
                
       avilbl_p = mysqlitem.rs.getFloat("availability");
       capa = mysqlitem.rs.getFloat("capacity");
        
            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }


  
        
      
        
        
        float pa = 0, pp = 0 ;
        
      
        if (lorp.getText().equals("P")) {
            
            pp  = Integer.parseInt(ammountz.getText());
            
            
            pa = (pp/one_prix);
            
            
            
            
        } else  if (lorp.getText().equals("L")) {
            
            
            pa  = Integer.parseInt(ammountz.getText());
            
            
            pp =  (pa*one_prix);
            
            
            
            
            
        }
        
        
        System.err.println(" -----------------------------------------------"+capa +"======="+avilbl_p+"======="+pp);
        
        
        if (avilbl_p >=   pa) {
            f = true;
        }
        
        
        
        
        
        return f;
    }
    
    
    
    
    
         int countResult(String table) throws Exception {

        int u=0;
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        String query = (String)table;
        System.out.println(query);
        try {

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {
               u=mysqlitem.rs.getInt(1);
            }
  System.out.println("success in mmmmmmmmmmmmmmmmmmmmmmmmmmmm uo");
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
        }
        return (u);
    }
  
    
    void actIforCalcu() {
        
        
        
        if (ammountz.getText().length() <1) {
            
            showAnEroorNotificatinOnDesktop(" insert value",  " enter a value for calculation", 5000);
            
            return;
        }
        
        
        
        if (!isPosibl( )) {
            
            showAnEroorNotificatinOnDesktop("empty",  " fuel empty", 5000);
            return;
        }
        
        
      
        int fu_id = 1;
        float one_prix = 0;
        
            if (stus_text.getText().equals("PETROL")) {
                fu_id = 1;
                one_prix = Float.parseFloat(ppriz.getText());
            }
        
            if (stus_text.getText().equals("DIESEL")) {
                fu_id = 2;
                one_prix = Float.parseFloat(ppriz1.getText());
            }
        
        
        
        
        
        if (lorp.getText().equals("P")) {
            
            int inpu  = Integer.parseInt(ammountz.getText());
            
            
            total_mi.setText(""+ (inpu/one_prix));
            
            tota.setText(""+inpu);
            
        } else  if (lorp.getText().equals("L")) {
            
            
            int inpu  = Integer.parseInt(ammountz.getText());
            
            
            tota.setText(""+ (inpu*one_prix));
            
            total_mi.setText(""+inpu);
            
            
            
        }
        
        
        System.err.println("---------"+total_mi.getText()+" ---------  "+tota.getText());
        
        
    }
    
    
    
    
    
    
    void submittActionPerform() {
        actIforCalcu() ;
        
        
        if (p.isSelected()) {
            tota.setText(ammountz.getText());
        } else {
            
            
            
        }
        
        
        
        if (tota.getText().length() <1) {
            actIforCalcu() ;
        }
        if (total_mi.getText().length() <1) {
            actIforCalcu() ;
        }
        
        
        
        
        if (ussr.getText().length() <1) {
            
            showAnEroorNotificatinOnDesktop(" name",  " enter a name ", 5000);
            
           
            return;
        }
        
        
        
        if (total_mi.getText().length() <1) {
            
            showAnEroorNotificatinOnDesktop(" insert value",  " enter a value for calculation", 5000);
            
           
            return;
        }
        
        
        if (total_mi.getText().length() <1) {
            
            showAnEroorNotificatinOnDesktop(" insert value",  " enter a value for calculation", 5000);
            
           
            return;
        }
        
        
        
        
        
         int fu_id = 1;
        float one_prix = 0;
        
            if (stus_text.getText().equals("PETROL")) {
                fu_id = 1;
                one_prix = Float.parseFloat(ppriz.getText());
            }
        
            if (stus_text.getText().equals("DIESEL")) {
                fu_id = 2;
                one_prix = Float.parseFloat(ppriz1.getText());
            }
        
        
        
        
        
        
        
        double final_amo = Float.parseFloat(total_mi.getText());
        String op_1 = new DecimalFormat("##.##").format(final_amo);
        
        final_amo = Float.parseFloat(tota.getText());
         String op_2 = new DecimalFormat("##.##").format(final_amo);
        
         
         String op_3= new DecimalFormat("##.##").format(one_prix);
        
        
         float forFirthr = Float.parseFloat(op_1);
         
         
         
         boolean b = false;
        
        String guser =  ussr.getText() ;
        
        try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
      
        
       
        
           
           String query = "INSERT INTO `billing` (`fuel_id`, `employee_id`, `user`, `amount`, `price_for_one`, `total_price` ) VALUES "
                   + "("+fu_id+", '"+empid+"', '"+ussr.getText()+"', "+op_1+", "+op_3+", "+op_2+")";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
         
           
            b = true;
            
            
            
             total [transactioncount][0] =stus_text.getText();
             
             total [transactioncount][1] = op_1;
             
             total [transactioncount][2] = op_3;
             
             total [transactioncount][3]= op_2;
            
            
          ammountz.setText("");
//        tota.setText("");
//        total_mi.setText("");
        
        

          


mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
         
        
        
        
        
        
        
        if (b) {
            
           float avilbl_p = 0;
            
            
            
            
  try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = "SELECT * FROM `fuel` WHERE id = "+fu_id+"";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                  
            
                
       avilbl_p = mysqlitem.rs.getFloat("availability");
        
            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }


            
           
            
            
            
            
                try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           double  op = avilbl_p - forFirthr;
                    System.err.println(" ---------"+avilbl_p+" ==========="+forFirthr+" ---- "+op);
           
           op_2 = new DecimalFormat("##.##").format(op);
           
           String query = " UPDATE `fuel` SET `availability` = "+op_2+" WHERE fuel_name = '"+stus_text.getText()+"'; ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();
           
          updateTheControls();
         
         showAllInThisClick ();
              
              
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        
          
            
            
        }
        
        transactioncount ++;
        
      
                
        
         
        
    }
    
    
    
    
       void showAllInThisClick () {
        jTable1.setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getDefaultRenderer(Object.class)).setOpaque(false);

        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);

        jTable1.setShowGrid(false);

        addDataToTable();//................................................................................................

        // TODO add your handling code here:
    }                                   
  void addDataToTable() {

        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        try {

            String query = "SELECT fuel_id AS fuel, amount, total_price AS price, TIME(date) AS time FROM `billing` WHERE DATE(date) = CURDATE()" +
"ORDER BY `billing`.`date` DESC";// WHERE userid='"+tmpempid+"'";

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            System.out.println(query);

            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            jTable1.setModel(DbUtils.resultSetToTableModel(mysqlitem.rs));                                                                                    //xxxxxxxxxxxxxxx

            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
            System.out.println("success");
        } catch (Exception ob) {
            System.out.println(ob);
        }

      //  employeeId();
      
      
      
         int rowCont = jTable1.getRowCount();
      
      for (int i = 0; i < rowCont; i++) {
          
          
          int val = (int) jTable1.getValueAt(i, 0);
          
          if (val == 1) {
              jTable1.setValueAt("petrol", i, 0);
          }
           if (val == 2) {
              jTable1.setValueAt("diesel", i, 0);
          }
          
      }

    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());  
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_u.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_u.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_u.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_u.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_u().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ammountz;
    private javax.swing.JLabel area;
    private javax.swing.JLabel area1;
    private javax.swing.JLabel avl;
    private javax.swing.JLabel avl1;
    private javax.swing.JLabel bg_Image;
    private javax.swing.JLayeredPane bk_img;
    private javax.swing.JLayeredPane bs_main;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog change_passwd;
    private javax.swing.JLabel d_l_av;
    private javax.swing.JLabel dsptime;
    private javax.swing.JLabel dsptoday;
    private javax.swing.JLabel dstatus;
    private javax.swing.JLabel empiddd;
    private javax.swing.JLabel fname1;
    private javax.swing.JLabel fname2;
    private javax.swing.JLabel imageofpast;
    private javax.swing.JLabel img_h;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton l;
    private javax.swing.JLabel lorp;
    private javax.swing.JLabel lstupdt;
    private javax.swing.JLabel lstupdt1;
    private javax.swing.JLayeredPane main0;
    private javax.swing.JLayeredPane main1;
    private javax.swing.JLabel mobile1;
    private javax.swing.JLabel mobile2;
    private javax.swing.JTextArea msg_dsc;
    private javax.swing.JLabel msg_hhd;
    private javax.swing.JLabel msg_img;
    private javax.swing.JRadioButton p;
    private javax.swing.JLabel p_l_av;
    private javax.swing.JPasswordField passwrd1;
    private javax.swing.JPasswordField passwrd2;
    private javax.swing.JPasswordField passwrd3;
    private javax.swing.JLabel ppriz;
    private javax.swing.JLabel ppriz1;
    private javax.swing.JLabel pstatus;
    private javax.swing.JFileChooser settBGimg;
    private javax.swing.JDialog show_error;
    private javax.swing.JLabel stus_text;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    private javax.swing.JTextField tota;
    private javax.swing.JLabel total_mi;
    private javax.swing.JTextField ussr;
    private javax.swing.JLabel v_dl;
    private javax.swing.JLabel v_dp;
    private javax.swing.JLabel v_loginT0me;
    private javax.swing.JLabel v_logouttime;
    private javax.swing.JLabel v_pl;
    private javax.swing.JLabel vpr;
    // End of variables declaration//GEN-END:variables



    String filename;
    byte[] person_image;
    byte[] outputimg;
    
    String selected_item  = "PETROL";
    
    
    int transactioncount = 0;
   String[][] total = new String[6][4]; 
    
    
    
    
    
    
    
    
    void showAnEroorNotificatinOnDesktop(String msg,  String dis, int time ) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
       // double height = screenSize.getHeight();
       
  msg_hhd.setText(msg);
  msg_dsc.setText(dis);
  
    msg_dsc.setBackground(new Color(0,0,0,0));
       
           
        
         Timer timer = new Timer(time, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                show_error.setVisible(false);
                 
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        try {
//            
//     String bip = "oringz-w431.mp3";
////Media hit = new Media(bip);
//Media hit = new Media(new File(bip).toURI().toString());
//MediaPlayer mediaPlayer = new MediaPlayer(hit);
//
//mediaPlayer.play(); 

        } catch (Exception e) {
        }
        
          
        int ds = (int) (width-360);
        show_error.setLocation(ds, 10);
        show_error.setVisible(true);
        
        
    }
    
           public static BufferedImage resizeImage(final Image image, int width, int height, int targetw, int targeth) {

        /////////////////////////////////////
//    if (width > height)targetw = 112;
//    else targetw = 50;
        do {
            if (width > targetw) {
                width /= 2;
                if (width < targetw) {
                    width = targetw;
                }
            }

            if (height > targeth) {
                height /= 2;
                if (height < targeth) {
                    height = targeth;
                }
            }
        } while (width != targetw || height != targeth);
        /////////////////////////////////

        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();

        return bufferedImage;
    }
//bk0

           
                 void actionForSetThis() {
          
java.util.List<Component> comps = getAllComponents((Container) this) ;

        for (Component c : comps) {

            

        
            
        try {
            
    c.repaint();
    c.revalidate();
        } catch (Exception e) {
          
            
        }
        
        }
        
                    

    }
                 
               
                 
                 void setnull() {
                     v_dl.setText("");
                     v_dp.setText("");
                     v_loginT0me.setText("");
                     v_logouttime.setText("");
                     v_pl.setText("");
                     vpr.setText("");
                 }
                 
     void actionAtTheForstToshow() {
         
         setnull();
        String status_id = "";
        String myLoinTime = "";
 try{    
     MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM `actions` ORDER BY date DESC LIMIT 1 ";
 System.out.println(query);
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
                   
                   
                   if (mysqlitem.rs.getDate("logout") == null) {
                       status_id = ""+mysqlitem.rs.getInt("no");
                       myLoinTime = mysqlitem.rs.getString("login")+"";
                   }

                   
       
        
               } catch (Exception e) {
               }
 

            
               
           }
          
System.out.println("success");
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
        }
        
 String pastEmpid = "";
 String pastLoginTime = "";
 String pastlogOtTime = "";
   
 try{    
     MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM `actions` ORDER BY date DESC LIMIT 2 ";
 System.out.println(query);
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           String atime = "";
             
           while( mysqlitem.rs.next()){ 
               try {
                   
                   System.err.println(""+status_id);
                   
                    if ((mysqlitem.rs.getInt("no")+"").equals(status_id)) {
                       atime = ""+mysqlitem.rs.getString("login");
                   } else {
                   //     System.err.println(mysqlitem.rs.getString("logout")+ " - "+atime);
                        
                    if ((mysqlitem.rs.getString("logout")+"").equals(atime)) {
                       pastEmpid = ""+mysqlitem.rs.getString("empid");
                       pastLoginTime = ""+mysqlitem.rs.getString("login");
                       pastlogOtTime =  ""+mysqlitem.rs.getString("logout");
                   }
                   
                    }
                   
//                   if (mysqlitem.rs.getDate("logout")+"". null) {
//                       status_id = ""+mysqlitem.rs.getInt("no");
//                   }

                   
       
        
               } catch (Exception e) {
               }
 

            
               
           }
          
System.out.println("success");
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
        }
        
         
 
 try{
   MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM employee WHERE  empid='"+pastEmpid+"' AND satus='employee'";
 System.out.println(query);
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           
           while( mysqlitem.rs.next()){ 
               try {
                   
         empiddd.setText(pastEmpid);
                   
fname2.setText(mysqlitem.rs.getString("fname")+" "+ mysqlitem.rs.getString("lname") );




mobile2.setText(""+mysqlitem.rs.getBigDecimal("mno"));




                   try {
                       int i = mysqlitem.rs.getInt("day");
                       if (i == 1) {
                           time1.setText(" day ");
                       } else {
                            time1.setText(" night ");
                       }
                   } catch (Exception e) {
                   }




 byte[] imagedata = mysqlitem.rs.getBytes("icon");
                ImageIcon format = null;

                outputimg = imagedata;
                format = new ImageIcon(imagedata);
                imageofpast.setIcon(format);
        
        
       
        
               } catch (Exception e) {
               }
 

            
               
           }
          
System.out.println("success");
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }  
         
         
         
                     v_loginT0me.setText(""+pastLoginTime);
                     v_logouttime.setText(""+pastlogOtTime);
//    v_dl.setText("");
//                     v_dp.setText("");
//                     v_pl.setText("");
//                     vpr.setText("");
 
float total_qq1 = 0, total_ammo1 = 0; 

float total_qq2 = 0, total_ammo2 = 0; 

  try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = "SELECT * FROM `billing` "
                + " WHERE date BETWEEN '"+pastLoginTime+"' AND '"+pastlogOtTime+"' "
                + "ORDER BY `billing`.`date` DESC ";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                 if (mysqlitem.rs.getInt("fuel_id") == 1) {
                    total_qq1 += mysqlitem.rs.getFloat("amount");
                    total_ammo1 += mysqlitem.rs.getFloat("total_price");
                    
                }
                
                
                if (mysqlitem.rs.getInt("fuel_id") == 2) {
                    
                    total_qq2 += mysqlitem.rs.getFloat("amount");
                    total_ammo2 += mysqlitem.rs.getFloat("total_price");
                }
        
                
            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }


          
 
     v_dl.setText(total_qq2+" litres");
                     v_dp.setText(total_ammo2+" rupees");
                     v_pl.setText(total_qq1+" litres");
                     vpr.setText(total_ammo1+" rupees");
 
 
 
     }            
                 
                 
                 
                 
                 
}
