/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Component;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import jdk.nashorn.internal.ir.Statement;






























 class MysqlConnect{


    public Connection con = null;
 
    public String dbName = "pumpdb";
  
    public String userName = "root"; 
    public String password = "athira";
    public PreparedStatement p;
    public Statement stmt;
    public ResultSet rs;


    public void crearedatabase(){

        try {

        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            System.out.println("success 1");

        System.out.println("Connected to the database");
        Statement stmt=(Statement)con.createStatement();

    } catch (Exception e) {
        System.out.println("Error!!!");
    }


    }
} 



class Global_For_New_Ideas {
    
    
    
    
        
    ///////////////////////////////////////////////////////////////////////////////// spacial function 
    
    void setBackgroundScalableImage(String loca, JLabel jLabel, JFrame frame) {
        
         try {
             Image  img = new ImageIcon(loca).getImage();
             img  = getScaledImage( img, frame.getWidth(), frame.getHeight());
             jLabel.setIcon(new javax.swing.ImageIcon(img)); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    private void setScalableImage(String loca, JLabel jLabel) {
        if (loca.length() < 1) 
            return;
        //System.out.println("test_layers.TestResize02.setScalableImage()"+ jLabel.getWidth()+"-"+ jLabel.getHeight());
         try {
             Image  img = new ImageIcon(loca).getImage();
             img  = getScaledImage( img, jLabel.getWidth(), jLabel.getHeight());
             jLabel.setIcon(new javax.swing.ImageIcon(img)); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
    
    /*
     how to caal this function
    
    create an object of the class and call the function with passing the 3 parmz
    
    setErrorForTextField( jTextField1.getText(), jTextField1, this);
    
    */
    
     ///////////////////////////////////////////////////////////////////////////////// spacial function ends
    
    
    
    
    /*
    *
    * for error display     
    *
    */
    
     
    public void setErrorForTextField(String message, Component field, JFrame frame, int time) {
       
        Point pt = new Point(field.getLocationOnScreen()); 
        
        double globalX = pt.getX();
        double globalY = pt.getY();
        
        int x_0 = 0;
        int y_0 = 0;
        int width_0 = field.getWidth();
        int height_0 = field.getHeight();
        
        int targetX = 0;
        int targetY = 0;
        
        height_0 = (int)height_0/2;
       
        targetX = (int) (x_0+width_0+3+globalX);
        targetY = (int) (y_0-height_0+globalY);
        
       // System.err.println(""+ pt+"\n"+targetX+"="+targetY);
        
        //System.err.println(targetX +"----"+targetY);
        dispalyEroorMessage( message, targetX, targetY, time );
        
    }
    
    public void dispalyEroorMessage(String message, int x, int y, int time ) {
        
    try {
        Thread.sleep(90);
    } catch (Exception e) {
    }
        javax.swing.JDialog error_show;
        JLabel  error_message, error_bg;
        error_show = new javax.swing.JDialog();
        error_message =  new JLabel();
        error_bg = new JLabel();
        error_show.setAlwaysOnTop(true);
        error_show.setUndecorated(true);
        error_show.setResizable(false);
        error_show.getContentPane().setLayout(new javax.swing.OverlayLayout(error_show.getContentPane()));

        error_message.setFont(new java.awt.Font("Arial", 1, 12));
        error_message.setForeground(new java.awt.Color(255, 255, 255));
       error_show.getContentPane().add(error_message);

        error_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/error_bg_1.png")));
        error_show.getContentPane().add(error_bg);
        
        Border border = error_message.getBorder();
        Border margin = new EmptyBorder(0,15,0,0);
        error_message.setBorder(new CompoundBorder(border, margin));

        int string_length = message.length();
        //System.err.println(""+string_length);
        int bou = 20+(string_length*6)+10;
        if ( bou > 600 )
            bou = 600;
        error_message.setText(message);
        error_show.setBackground(new java.awt.Color(0, 0, 0, 0));        
        error_show.setBounds(0, 0,bou , 45);
        
        //error_show.setLocation(x, y);   
        // fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        Thread ts = new Thread(
                new Runnable() {
            @Override
            public void run() {
                for( int i = 200; i>3; i--){
                    //System.err.println("e"+i);
                     error_show.setLocation(x+i, y);   
                    try {
                        Thread.sleep((int)12-(i/20));
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
        );
                
        Timer timer = new Timer(time, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                error_show.setVisible(false);
                 ts.stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
        error_show.setVisible(true);
        ts.start();
       
                
    }
    
     
    
    
    
    /************************** end the function *********************************/
    
}


/**
 *
 * @author indrajith
 */
public class Log_in extends javax.swing.JFrame {

    /**
     * Creates new form Log_in
     */
    public Log_in() {
        initComponents();
        
        
            
        
        
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
        replaceLayer( login_, user_log) ;

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
                      DateFormat timeFormat = new SimpleDateFormat("hh : mm : ss  aa");     ////
                      Calendar clo = Calendar.getInstance();                        ////
                      dsptime.setText(timeFormat.format(clo.getTime()));            ////
              //        btime.setText(timeFormat.format(clo.getTime()));   /////////////////////
                                         ////////////////////////////////////////////////  
                                                
                             try {
                Thread.sleep(1000);
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

     
     void replaceLayer( JLayeredPane per, JLayeredPane chi) {
        per.removeAll();
        per.repaint();
        per.revalidate();
        per.add(chi);
        per.repaint();
        per.revalidate();  
     }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        bs_main = new javax.swing.JLayeredPane();
        main0 = new javax.swing.JLayeredPane();
        main1 = new javax.swing.JLayeredPane();
        dsptoday = new javax.swing.JLabel();
        dsptime = new javax.swing.JLabel();
        login_ = new javax.swing.JLayeredPane();
        user_log = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_user_name = new javax.swing.JTextField();
        user_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        admin_log = new javax.swing.JLayeredPane();
        admin_user_name = new javax.swing.JTextField();
        admin_password = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        bk_img = new javax.swing.JLayeredPane();
        bg_Image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 500));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
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

        dsptoday.setFont(new java.awt.Font("LCD", 1, 18)); // NOI18N
        dsptoday.setForeground(new java.awt.Color(255, 255, 255));
        dsptoday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        main1.add(dsptoday);
        dsptoday.setBounds(1140, 680, 200, 40);

        dsptime.setFont(new java.awt.Font("LCD", 1, 18)); // NOI18N
        dsptime.setForeground(new java.awt.Color(255, 255, 255));
        dsptime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        main1.add(dsptime);
        dsptime.setBounds(1130, 640, 210, 40);

        login_.setBackground(new java.awt.Color(0, 0, 0, 130));
        login_.setLayout(new javax.swing.OverlayLayout(login_));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PASSWORD");
        user_log.add(jLabel3);
        jLabel3.setBounds(10, 200, 80, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USER NAME");
        user_log.add(jLabel2);
        jLabel2.setBounds(10, 130, 80, 30);

        user_user_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        user_user_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_user_nameFocusGained(evt);
            }
        });
        user_log.add(user_user_name);
        user_user_name.setBounds(100, 130, 270, 30);

        user_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        user_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_passwordFocusGained(evt);
            }
        });
        user_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_passwordActionPerformed(evt);
            }
        });
        user_log.add(user_password);
        user_password.setBounds(100, 200, 270, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("user");
        user_log.add(jLabel4);
        jLabel4.setBounds(10, 0, 120, 30);

        jLabel1.setBackground(new java.awt.Color(255, 102, 51));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("login");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });
        user_log.add(jLabel1);
        jLabel1.setBounds(290, 270, 80, 30);

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("admin");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        user_log.add(jLabel8);
        jLabel8.setBounds(290, 20, 80, 20);

        jLabel9.setBackground(new java.awt.Color(102, 51, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("clear");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
        });
        user_log.add(jLabel9);
        jLabel9.setBounds(210, 270, 80, 30);

        error1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 0));
        user_log.add(error1);
        error1.setBounds(30, 90, 340, 30);

        login_.add(user_log);

        admin_user_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        admin_user_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                admin_user_nameFocusGained(evt);
            }
        });
        admin_log.add(admin_user_name);
        admin_user_name.setBounds(100, 130, 270, 30);

        admin_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        admin_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                admin_passwordFocusGained(evt);
            }
        });
        admin_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_passwordActionPerformed(evt);
            }
        });
        admin_log.add(admin_password);
        admin_password.setBounds(100, 200, 270, 30);

        jLabel13.setBackground(new java.awt.Color(255, 102, 51));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("login");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
        });
        admin_log.add(jLabel13);
        jLabel13.setBounds(290, 270, 80, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("USER NAME");
        admin_log.add(jLabel11);
        jLabel11.setBounds(10, 130, 80, 30);

        jLabel14.setBackground(new java.awt.Color(0, 102, 102));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("user");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        admin_log.add(jLabel14);
        jLabel14.setBounds(290, 20, 80, 20);

        jLabel15.setBackground(new java.awt.Color(102, 51, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("clear");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.setOpaque(true);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
        });
        admin_log.add(jLabel15);
        jLabel15.setBounds(210, 270, 80, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PASSWORD");
        admin_log.add(jLabel10);
        jLabel10.setBounds(10, 200, 80, 30);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("admin");
        admin_log.add(jLabel12);
        jLabel12.setBounds(10, 10, 120, 30);

        error2.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 0));
        admin_log.add(error2);
        error2.setBounds(20, 90, 350, 30);

        login_.add(admin_log);

        main1.add(login_);
        login_.setBounds(150, 210, 390, 470);

        main0.add(main1);

        bs_main.add(main0);
        main0.setBounds(0, 0, 1370, 750);

        jDesktopPane1.add(bs_main);

        bk_img.setLayout(new javax.swing.OverlayLayout(bk_img));

        bg_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/dd.jpg"))); // NOI18N
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

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
        /***************** 
         * 
         * 
         * this is the function for rsize thebackground image  
         * but not using in this project 
         * 
         * 
         *
         ******************/
        
        /*
        Global_For_New_Ideas for_New_Ideas= new Global_For_New_Ideas();
        String loString ="/home/indrajith/NetBeansProjects/Test_Layers/src/images/100 Amazing Mixed Wallpapers 85 (11).jpg";
        for_New_Ideas.setBackgroundScalableImage(loString, bg_Image, this);
       
        
        */

        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void user_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_passwordActionPerformed

    private void admin_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_passwordActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        replaceLayer( login_, admin_log);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        replaceLayer( login_, user_log);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jLabel9.setBackground(new java.awt.Color(102, 51, 255));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jLabel9.setBackground(new java.awt.Color(51, 0, 204));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setBackground(new java.awt.Color(255, 102, 51));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setBackground(new java.awt.Color(255, 51, 0));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
        jLabel15.setBackground(new java.awt.Color(102, 51, 255));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        jLabel15.setBackground(new java.awt.Color(51, 0, 204));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
        jLabel13.setBackground(new java.awt.Color(255, 102, 51));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        jLabel13.setBackground(new java.awt.Color(255, 51, 0));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        admin_user_name.setText("");
        admin_password.setText("");
        setErrorEmpty();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        user_user_name.setText("");
        user_password.setText("");
        setErrorEmpty();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        
        //user
        String user_n = user_user_name.getText();
        String iser_p = user_password.getText();
        if(user_n.length() <1) {
            error1.setText("enter the user name");
        } else if(iser_p.length() <1) {
            
            error1.setText("enter the password");
        } else {
            chek_this_login( user_n, iser_p, 0);
            
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    void setErrorEmpty(){
        
        
       error1.setText("");
       error2.setText("");
    }
    private void admin_user_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_user_nameFocusGained
        // TODO add your handling code here:
        setErrorEmpty();
        System.err.println("jjj");
    }//GEN-LAST:event_admin_user_nameFocusGained

    private void admin_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_passwordFocusGained
        // TODO add your handling code here:
        
       setErrorEmpty();
    }//GEN-LAST:event_admin_passwordFocusGained

    private void user_user_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_user_nameFocusGained
        // TODO add your handling code here:
        setErrorEmpty();
    }//GEN-LAST:event_user_user_nameFocusGained

    private void user_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_passwordFocusGained
        // TODO add your handling code here:
        setErrorEmpty();
    }//GEN-LAST:event_user_passwordFocusGained

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
           // TODO add your handling code here:
           String user_n = admin_user_name.getText();
        String iser_p = admin_password.getText();
        if(user_n.length() <1) {
            error2.setText("enter the user name");
        } else if(iser_p.length() <1) {
            
            error2.setText("enter the password");
        } else {
            chek_this_login( user_n, iser_p, 1);
            
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    
    
       
      void chek_this_login( String user_name, String password, int status)
    {
        
        
        String query ="";
        String f="";
        String gh="";
           try {
         
                    
query= "SELECT user_name, password FROM login WHERE user_name= '"+user_name
        +"' AND password= '"+password+"'  AND type="+status;

        } catch (Exception e) {
           
        }
               
        
        

 System.out.println(query);
 try{
     MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
          
           
           
             while( mysqlitem.rs.next()){
                    f= mysqlitem.rs.getString("user_name");
                    gh = mysqlitem.rs.getString("password");
                    }
             
             
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
System.out.println("success");
        }
        catch(Exception e1){
            System.out.println("Error");
             
           
        }

      
 
 if(f.length()<=0)
 {
       System.err.println("error");
       error1.setText("username or password is incorrect");
       error2.setText("username or password is incorrect");
//         error.removeAll();
//            error.repaint();
//            error.revalidate();
//              error.add(errorop);
//            error.repaint();
//            error.revalidate();
     return;
 }
        if( f.equals(user_name) && gh.equals(password)) {
            
            System.err.println("success");
            
            if(status == 1) {
                Main_ main_ = new Main_();
                
                main_.show();
                this.dispose();
                
            } else if (status == 0) {
                Main_u main_ = new Main_u();
                
                insertTheTable( user_name);
                main_.setForEmpId(user_name );
                main_.show();
                this.dispose();
            }
            
            
        } else {
            System.err.println("error");
            
       error1.setText("username or password is incorrect");
       error2.setText("username or password is incorrect");
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
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane admin_log;
    private javax.swing.JPasswordField admin_password;
    private javax.swing.JTextField admin_user_name;
    private javax.swing.JLabel bg_Image;
    private javax.swing.JLayeredPane bk_img;
    private javax.swing.JLayeredPane bs_main;
    private javax.swing.JLabel dsptime;
    private javax.swing.JLabel dsptoday;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane login_;
    private javax.swing.JLayeredPane main0;
    private javax.swing.JLayeredPane main1;
    private javax.swing.JLayeredPane user_log;
    private javax.swing.JPasswordField user_password;
    private javax.swing.JTextField user_user_name;
    // End of variables declaration//GEN-END:variables

           
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
   
      
    private void insertTheTable(String user_name) {
       
        String status_id = "";
            MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM `actions` ORDER BY date DESC LIMIT 1 ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
                   
                   
                   if (mysqlitem.rs.getDate("logout") == null) {
                       status_id = ""+mysqlitem.rs.getInt("no");
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
        
        
        
        if (status_id.length() > 0) {
            
            try {
                
                
                     
         mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
            query = " UPDATE `actions` SET `logout` = CURRENT_TIMESTAMP WHERE no = "+status_id+"; ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

       
            
            
        
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
            } catch (Exception e) {
            }
        }
 
 
        
        
        
        int d=0;
        try {
                    d = countResult("select count(*) from actions");
        } catch (Exception e) {
        }
        
        Random ds = new Random();
        int u= ds.nextInt(999);
        d= 10000+d+u;
        
           try {
            
         mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
      
        
           
            query = "INSERT INTO `actions` (`no`, `empid`, `login`, `logout`, `date`) VALUES "
                   + "("+d+", '"+user_name+"', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP); ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
          
    


mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
         
    }
}
