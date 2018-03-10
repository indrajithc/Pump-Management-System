/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import static project.Utils.getAllComponents;
/**
 *
 * @author indrajith
 */
public class Main_ extends javax.swing.JFrame {

    /**
     * Creates new form Main_
     */
    Global_For_New_Ideas jok = new Global_For_New_Ideas();
    SimpleDateFormat sdfhz = new SimpleDateFormat("yyyy-MM-dd");

    public Main_() {
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

        setAsFont();
        setDateAndTime();

        ///s how home as dflt
        replaceLayer(main_display, home);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1300, 700));

        disaplayDeatisAtHome();
        addareaToComboBox();
        
        setAtTheFirstTop();
        
        
        runAtTheStrtCirlcez();
        
        tableSetTt();
        
        
        setAbout() ;
    }

    
    
    void tableSetTt() {
        jTable1.setEnabled(false);
        jTable1.setOpaque(false);
        jTable1.setRowSelectionAllowed(false);
        jTable2.setEnabled(false);
        jTable2.setOpaque(false);
        jTable2.setRowSelectionAllowed(false);
        jTable3.setEnabled(false);
        jTable3.setOpaque(false);
//        jTable3.setRowSelectionAllowed(false);
//        jTable4.setEnabled(false);
//        jTable4.setOpaque(false);
//        jTable4.setRowSelectionAllowed(false);
        jTable5.setEnabled(false);
        jTable5.setOpaque(false);
        jTable5.setRowSelectionAllowed(false);

    }
    
    
    
    void replaceLayer(JLayeredPane per, JLayeredPane chi) {
        per.removeAll();
        per.repaint();
        per.revalidate();
        per.add(chi);
        per.repaint();
        per.revalidate();
    }

    public void setDateAndTime() {
        System.out.println("success 11111 1");
        Thread d = new Thread() {
            public void run() {
                System.out.println("success 22222");
                for (;;) {
                    ////////////////////////////////////////////////
                    //date                      ////
                    DateFormat dateFormat = new SimpleDateFormat("dd - MM - YYYY");    ////
                    Calendar cal = Calendar.getInstance();                          ////

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

    
    
    
    
    void runAtTheStrtCirlcez() {
        
        
        float amo_p = 0;
        float amo_d = 0;
        
        float amo_pa = 0;
        float amo_da = 0;
        
        
           
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM fuel ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
                     if (mysqlitem.rs.getString("fuel_name").equals( "petrol")) {
                       
 
  amo_p = mysqlitem.rs.getFloat("availability");
  amo_pa = mysqlitem.rs.getFloat("capacity");
 
  
                   }
        
  if (mysqlitem.rs.getString("fuel_name").equals("diesel")) {
                       
 
         amo_d = mysqlitem.rs.getFloat("availability");
         amo_da = mysqlitem.rs.getFloat("capacity");
 
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
 
 
 
 
 
 
 
 
 
  float a = amo_d;
 float bv = amo_p;
 
        try {
            
           amo_d = amo_d * 100;
           amo_da =   amo_d/amo_da;
        } catch (Exception e) {
        }
 
        try { 
           amo_p = amo_p * 100;
           amo_pa = amo_p/amo_pa;
        } catch (Exception e) {
        }
 
      
        
    System.err.println("     amount dsplay =========="+amo_d+" - " +amo_da +"  ====== \n" + amo_p+" - "+amo_pa);
       
     ppp1.setText(  bv + "  Litres ");
   ddd1.setText(a+ "  Litres ");
 
 
 
 setTheNewCircleshow( (int)amo_pa, (int)amo_da);
 
 
 
 
 
 mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
 query = "SELECT * FROM `stock_import` WHERE fuel_id  = 1 " +
"ORDER BY `stock_import`.`date` DESC LIMIT 1";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
  dddd2.setText( mysqlitem.rs.getDate("date")+"");
  
  
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
 query = "SELECT * FROM `stock_import` WHERE fuel_id  = 2  " +
"ORDER BY `stock_import`.`date` DESC LIMIT 1";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
  ddd3.setText( mysqlitem.rs.getDate("date")+"");
  
  
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        chooser = new javax.swing.JFileChooser();
        menu_main_a4 = new javax.swing.JLayeredPane();
        menu_word4 = new javax.swing.JLabel();
        menu_bg4 = new javax.swing.JLabel();
        add_new = new javax.swing.JDialog();
        jLabel44 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        state = new javax.swing.JTextField();
        pprice = new javax.swing.JTextField();
        area = new javax.swing.JTextField();
        dprice = new javax.swing.JTextField();
        oprice = new javax.swing.JTextField();
        to_date = new javax.swing.JTextField();
        pincd = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        show_error = new javax.swing.JDialog();
        jLayeredPane12 = new javax.swing.JLayeredPane();
        msg_img = new javax.swing.JLabel();
        msg_hhd = new javax.swing.JLabel();
        msg_dsc = new javax.swing.JTextArea();
        update_data = new javax.swing.JDialog();
        jLabel103 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        dprice1 = new javax.swing.JTextField();
        to_date1 = new javax.swing.JTextField();
        pprice1 = new javax.swing.JTextField();
        pincd1 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        oprice1 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        state1 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        area1 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        hidden_id = new javax.swing.JLabel();
        select_font = new javax.swing.JDialog();
        jLayeredPane16 = new javax.swing.JLayeredPane();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        view_fonts = new javax.swing.JLayeredPane();
        jLabel143 = new javax.swing.JLabel();
        jLayeredPane17 = new javax.swing.JLayeredPane();
        fontDi1 = new javax.swing.JLabel();
        fontDi2 = new javax.swing.JLabel();
        selected_fon = new javax.swing.JLabel();
        change_passwd = new javax.swing.JDialog();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        passwrd1 = new javax.swing.JPasswordField();
        passwrd2 = new javax.swing.JPasswordField();
        passwrd3 = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        bs_main = new javax.swing.JLayeredPane();
        main0 = new javax.swing.JLayeredPane();
        main1 = new javax.swing.JLayeredPane();
        jButton7 = new javax.swing.JButton();
        dsptime = new javax.swing.JLabel();
        dsptoday = new javax.swing.JLabel();
        HEAD = new javax.swing.JLabel();
        menu_head = new javax.swing.JLayeredPane();
        meanu_head1 = new javax.swing.JLayeredPane();
        jLabel28 = new javax.swing.JLabel();
        petrol = new javax.swing.JLabel();
        meanu_head1_1 = new javax.swing.JLabel();
        meanu_head2 = new javax.swing.JLayeredPane();
        jLabel29 = new javax.swing.JLabel();
        diesel = new javax.swing.JLabel();
        meanu_head1_2 = new javax.swing.JLabel();
        menu_main = new javax.swing.JLayeredPane();
        menu_main_a1 = new javax.swing.JLayeredPane();
        menu_word1 = new javax.swing.JLabel();
        menu_bg1 = new javax.swing.JLabel();
        menu_main_a2 = new javax.swing.JLayeredPane();
        menu_word2 = new javax.swing.JLabel();
        menu_bg2 = new javax.swing.JLabel();
        menu_main_a3 = new javax.swing.JLayeredPane();
        menu_word3 = new javax.swing.JLabel();
        menu_bg3 = new javax.swing.JLabel();
        menu_main_a5 = new javax.swing.JLayeredPane();
        menu_word5 = new javax.swing.JLabel();
        menu_bg5 = new javax.swing.JLabel();
        main_display = new javax.swing.JLayeredPane();
        staff = new javax.swing.JLayeredPane();
        jSeparator1 = new javax.swing.JSeparator();
        innr_menu_bg = new javax.swing.JLayeredPane();
        innr_menu = new javax.swing.JLayeredPane();
        innr_head_a1 = new javax.swing.JLayeredPane();
        innr_menu_a1 = new javax.swing.JLabel();
        inn_menu_bg1 = new javax.swing.JLabel();
        innr_head_a2 = new javax.swing.JLayeredPane();
        innr_menu_a2 = new javax.swing.JLabel();
        inn_menu_bg2 = new javax.swing.JLabel();
        innr_head_a3 = new javax.swing.JLayeredPane();
        innr_menu_a3 = new javax.swing.JLabel();
        inn_menu_bg3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        innr_main_menu0 = new javax.swing.JLayeredPane();
        innr_menu_main_a02 = new javax.swing.JLayeredPane();
        show_all = new javax.swing.JLayeredPane();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        show_rslt = new javax.swing.JLayeredPane();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        image_h1 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        out_date11 = new javax.swing.JLabel();
        join_date1 = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        user_name3 = new javax.swing.JLabel();
        salary1 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        dob1 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        mobile1 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        duty1 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        gender1 = new javax.swing.JLabel();
        qualification1 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        Telephone1 = new javax.swing.JLabel();
        email1 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        peaddr1 = new javax.swing.JTextArea();
        jLabel101 = new javax.swing.JLabel();
        praddr1 = new javax.swing.JTextArea();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        search_one = new javax.swing.JLayeredPane();
        jLabel64 = new javax.swing.JLabel();
        searchfield = new javax.swing.JTextField();
        show_reslut_clicabl = new javax.swing.JLayeredPane();
        jLabel81 = new javax.swing.JLabel();
        innr_menu_main_a03 = new javax.swing.JLayeredPane();
        jLabel92 = new javax.swing.JLabel();
        salary2 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        dob2 = new datechooser.beans.DateChooserCombo();
        jLabel88 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        fname1 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        join_date2 = new datechooser.beans.DateChooserCombo();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        image_h2 = new javax.swing.JLabel();
        mobile2 = new javax.swing.JTextField();
        jLayeredPane11 = new javax.swing.JLayeredPane();
        jLabel97 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        peaddr2 = new javax.swing.JTextArea();
        jLabel95 = new javax.swing.JLabel();
        path1 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        qualification2 = new javax.swing.JComboBox<>();
        email2 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Telephone2 = new javax.swing.JTextField();
        out_date2 = new datechooser.beans.DateChooserCombo();
        jLabel86 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        v3 = new javax.swing.JRadioButton();
        v4 = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        praddr2 = new javax.swing.JTextArea();
        jLabel83 = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        c3 = new javax.swing.JRadioButton();
        c4 = new javax.swing.JRadioButton();
        lname1 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        age2 = new javax.swing.JTextField();
        all_emplo = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        innr_menu_main_a01 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        path = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        c1 = new javax.swing.JRadioButton();
        c2 = new javax.swing.JRadioButton();
        dob = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        praddr = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        qualification = new javax.swing.JComboBox<>();
        salary = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        join_date = new datechooser.beans.DateChooserCombo();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        v1 = new javax.swing.JRadioButton();
        v2 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        image_h = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        peaddr = new javax.swing.JTextArea();
        out_date1 = new datechooser.beans.DateChooserCombo();
        jLabel19 = new javax.swing.JLabel();
        Telephone = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        user_name1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        stock = new javax.swing.JLayeredPane();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        dver2 = new javax.swing.JLayeredPane();
        jLabel60 = new javax.swing.JLabel();
        dver1 = new javax.swing.JLayeredPane();
        jLabel59 = new javax.swing.JLabel();
        dver3 = new javax.swing.JLayeredPane();
        jLabel61 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        main_forStk = new javax.swing.JLayeredPane();
        SALES_INFO = new javax.swing.JLayeredPane();
        dfdfdf = new javax.swing.JLayeredPane();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        dtotals = new javax.swing.JLabel();
        parea = new javax.swing.JLabel();
        pimpto = new javax.swing.JLabel();
        pseeltot = new javax.swing.JLabel();
        darea = new javax.swing.JLabel();
        dtotl = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel137 = new javax.swing.JLabel();
        pimpto1 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        pseeltot1 = new javax.swing.JLabel();
        dtotl1 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        dtotals1 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        showDate = new datechooser.beans.DateChooserCombo();
        jLabel145 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        area_id_h = new javax.swing.JLabel();
        AVAILABLE_STOCK = new javax.swing.JLayeredPane();
        jLayeredPane15 = new javax.swing.JLayeredPane();
        jLabel130 = new javax.swing.JLabel();
        s3d1 = new javax.swing.JLabel();
        s3d2 = new javax.swing.JLabel();
        s3d3 = new javax.swing.JLabel();
        s3d4 = new javax.swing.JLabel();
        s3d5 = new javax.swing.JLabel();
        s3d6 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel144 = new javax.swing.JLabel();
        IMPORTED_STOCK = new javax.swing.JLayeredPane();
        jLayeredPane13 = new javax.swing.JLayeredPane();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        deaker = new javax.swing.JTextField();
        amount1 = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLayeredPane14 = new javax.swing.JLayeredPane();
        jLabel113 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        amount2 = new javax.swing.JTextField();
        price1 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        deaker1 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        total1 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        maintop_top = new javax.swing.JLayeredPane();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        dlitr1 = new javax.swing.JLabel();
        plitr1 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        pup = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        dup = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        mesure_display = new javax.swing.JLayeredPane();
        base = new javax.swing.JLabel();
        fr1 = new javax.swing.JLabel();
        fr2 = new javax.swing.JLabel();
        home = new javax.swing.JLayeredPane();
        Each_main_b = new javax.swing.JLayeredPane();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        scroll_innr_base = new javax.swing.JLayeredPane();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        apprice = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        adprice = new javax.swing.JLabel();
        aoprice = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        aarea = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        alstpr = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        apincd = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        astate = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        select_deta_plz = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        dddd2 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        ppp1 = new javax.swing.JLabel();
        ddd3 = new javax.swing.JLabel();
        ddd1 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        about = new javax.swing.JLayeredPane();
        ffffabout = new javax.swing.JTextArea();
        jLabel135 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        bk_img = new javax.swing.JLayeredPane();
        bg_Image = new javax.swing.JLabel();

        menu_main_a4.setLayout(new javax.swing.OverlayLayout(menu_main_a4));

        menu_word4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menu_word4.setForeground(new java.awt.Color(255, 255, 255));
        menu_word4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_word4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/billing-one.png"))); // NOI18N
        menu_word4.setToolTipText("");
        menu_word4.setMaximumSize(new java.awt.Dimension(235, 50));
        menu_word4.setMinimumSize(new java.awt.Dimension(235, 50));
        menu_word4.setPreferredSize(new java.awt.Dimension(235, 50));
        menu_word4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_word4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_word4MouseEntered(evt);
            }
        });
        menu_main_a4.add(menu_word4);
        menu_main_a4.add(menu_bg4);

        add_new.setAlwaysOnTop(true);
        add_new.setBackground(new java.awt.Color(204, 204, 204));
        add_new.setMinimumSize(new java.awt.Dimension(550, 420));
        add_new.setResizable(false);
        add_new.getContentPane().setLayout(null);

        jLabel44.setBackground(new java.awt.Color(102, 204, 255));
        jLabel44.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("PETROL / GASOLINE PRICE :");
        add_new.getContentPane().add(jLabel44);
        jLabel44.setBounds(60, 90, 210, 20);

        jLabel57.setBackground(new java.awt.Color(102, 204, 255));
        jLabel57.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("STATE :");
        add_new.getContentPane().add(jLabel57);
        jLabel57.setBounds(100, 310, 170, 20);

        jLabel52.setBackground(new java.awt.Color(102, 204, 255));
        jLabel52.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("LAST PRICE UPDATED :");
        add_new.getContentPane().add(jLabel52);
        jLabel52.setBounds(100, 220, 170, 20);

        jLabel47.setText(" per litre in rupees");
        add_new.getContentPane().add(jLabel47);
        jLabel47.setBounds(280, 10, 140, 19);

        jLabel48.setBackground(new java.awt.Color(102, 204, 255));
        jLabel48.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("DIESEL PRICE :");
        add_new.getContentPane().add(jLabel48);
        jLabel48.setBounds(100, 120, 170, 20);

        jLabel42.setBackground(new java.awt.Color(102, 204, 255));
        jLabel42.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("AREA :");
        add_new.getContentPane().add(jLabel42);
        jLabel42.setBounds(100, 50, 170, 20);

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("NEW Values");
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        add_new.getContentPane().add(jLabel46);
        jLabel46.setBounds(40, 10, 190, 20);

        jLabel54.setBackground(new java.awt.Color(102, 204, 255));
        jLabel54.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("Petrol Bunk / Fuel station pincode :");
        add_new.getContentPane().add(jLabel54);
        jLabel54.setBounds(20, 270, 250, 20);

        jLabel50.setBackground(new java.awt.Color(102, 204, 255));
        jLabel50.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText(" OIL PRICE :");
        add_new.getContentPane().add(jLabel50);
        jLabel50.setBounds(100, 170, 170, 20);

        state.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });
        add_new.getContentPane().add(state);
        state.setBounds(280, 300, 230, 30);

        pprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppriceActionPerformed(evt);
            }
        });
        pprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ppriceKeyTyped(evt);
            }
        });
        add_new.getContentPane().add(pprice);
        pprice.setBounds(280, 80, 230, 30);

        area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaActionPerformed(evt);
            }
        });
        add_new.getContentPane().add(area);
        area.setBounds(280, 40, 230, 30);

        dprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        dprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpriceActionPerformed(evt);
            }
        });
        dprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dpriceKeyTyped(evt);
            }
        });
        add_new.getContentPane().add(dprice);
        dprice.setBounds(280, 120, 230, 30);

        oprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        oprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opriceActionPerformed(evt);
            }
        });
        oprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                opriceKeyTyped(evt);
            }
        });
        add_new.getContentPane().add(oprice);
        oprice.setBounds(280, 160, 230, 30);

        to_date.setEditable(false);
        to_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        to_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                to_dateActionPerformed(evt);
            }
        });
        add_new.getContentPane().add(to_date);
        to_date.setBounds(280, 210, 230, 30);

        pincd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pincd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pincdActionPerformed(evt);
            }
        });
        pincd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pincdKeyTyped(evt);
            }
        });
        add_new.getContentPane().add(pincd);
        pincd.setBounds(280, 260, 230, 30);

        jLabel43.setBackground(new java.awt.Color(102, 51, 0));
        jLabel43.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("save");
        jLabel43.setOpaque(true);
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel43MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel43MouseEntered(evt);
            }
        });
        add_new.getContentPane().add(jLabel43);
        jLabel43.setBounds(390, 350, 130, 30);

        jLabel45.setBackground(new java.awt.Color(51, 102, 0));
        jLabel45.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("remove");
        jLabel45.setOpaque(true);
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel45MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel45MouseEntered(evt);
            }
        });
        add_new.getContentPane().add(jLabel45);
        jLabel45.setBounds(260, 350, 130, 30);

        show_error.setAlwaysOnTop(true);
        show_error.setLocation(new java.awt.Point(1370, 0));
        show_error.setMinimumSize(new java.awt.Dimension(350, 90));
        show_error.setUndecorated(true);
        show_error.getContentPane().setLayout(new javax.swing.OverlayLayout(show_error.getContentPane()));

        jLayeredPane12.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane12.setOpaque(true);

        msg_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/error.png"))); // NOI18N
        jLayeredPane12.add(msg_img);
        msg_img.setBounds(10, 10, 80, 80);

        msg_hhd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        msg_hhd.setForeground(new java.awt.Color(255, 0, 0));
        jLayeredPane12.add(msg_hhd);
        msg_hhd.setBounds(100, 10, 230, 20);

        msg_dsc.setEditable(false);
        msg_dsc.setColumns(20);
        msg_dsc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        msg_dsc.setForeground(new java.awt.Color(102, 0, 0));
        msg_dsc.setLineWrap(true);
        msg_dsc.setRows(5);
        msg_dsc.setText(" ");
        msg_dsc.setBorder(null);
        msg_dsc.setEnabled(false);
        msg_dsc.setFocusable(false);
        msg_dsc.setOpaque(false);
        jLayeredPane12.add(msg_dsc);
        msg_dsc.setBounds(100, 30, 240, 60);

        show_error.getContentPane().add(jLayeredPane12);

        update_data.setAlwaysOnTop(true);
        update_data.setMinimumSize(new java.awt.Dimension(550, 420));
        update_data.getContentPane().setLayout(null);

        jLabel103.setBackground(new java.awt.Color(102, 204, 255));
        jLabel103.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel103.setText("STATE :");
        update_data.getContentPane().add(jLabel103);
        jLabel103.setBounds(100, 310, 170, 20);

        jLabel107.setBackground(new java.awt.Color(102, 204, 255));
        jLabel107.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel107.setText("AREA :");
        update_data.getContentPane().add(jLabel107);
        jLabel107.setBounds(100, 50, 170, 20);

        jLabel108.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(102, 102, 102));
        jLabel108.setText("UPDATE Values");
        jLabel108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel108MouseClicked(evt);
            }
        });
        update_data.getContentPane().add(jLabel108);
        jLabel108.setBounds(40, 10, 190, 20);

        dprice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        dprice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dprice1ActionPerformed(evt);
            }
        });
        dprice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dprice1KeyTyped(evt);
            }
        });
        update_data.getContentPane().add(dprice1);
        dprice1.setBounds(280, 120, 230, 30);

        to_date1.setEditable(false);
        to_date1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        to_date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                to_date1ActionPerformed(evt);
            }
        });
        update_data.getContentPane().add(to_date1);
        to_date1.setBounds(280, 210, 230, 30);

        pprice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pprice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pprice1ActionPerformed(evt);
            }
        });
        pprice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pprice1KeyTyped(evt);
            }
        });
        update_data.getContentPane().add(pprice1);
        pprice1.setBounds(280, 80, 230, 30);

        pincd1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pincd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pincd1ActionPerformed(evt);
            }
        });
        pincd1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pincd1KeyTyped(evt);
            }
        });
        update_data.getContentPane().add(pincd1);
        pincd1.setBounds(280, 260, 230, 30);

        jLabel105.setText(" per litre in rupees");
        update_data.getContentPane().add(jLabel105);
        jLabel105.setBounds(280, 10, 140, 19);

        oprice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        oprice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oprice1ActionPerformed(evt);
            }
        });
        oprice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oprice1KeyTyped(evt);
            }
        });
        update_data.getContentPane().add(oprice1);
        oprice1.setBounds(280, 160, 230, 30);

        jLabel111.setBackground(new java.awt.Color(102, 51, 0));
        jLabel111.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("update");
        jLabel111.setOpaque(true);
        jLabel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel111MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel111MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel111MouseEntered(evt);
            }
        });
        update_data.getContentPane().add(jLabel111);
        jLabel111.setBounds(390, 350, 130, 30);

        state1.setEditable(false);
        state1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        state1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                state1ActionPerformed(evt);
            }
        });
        update_data.getContentPane().add(state1);
        state1.setBounds(280, 300, 230, 30);

        jLabel106.setBackground(new java.awt.Color(102, 204, 255));
        jLabel106.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel106.setText("DIESEL PRICE :");
        update_data.getContentPane().add(jLabel106);
        jLabel106.setBounds(100, 120, 170, 20);

        jLabel110.setBackground(new java.awt.Color(102, 204, 255));
        jLabel110.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel110.setText(" OIL PRICE :");
        update_data.getContentPane().add(jLabel110);
        jLabel110.setBounds(100, 170, 170, 20);

        jLabel112.setBackground(new java.awt.Color(51, 102, 0));
        jLabel112.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("remove");
        jLabel112.setOpaque(true);
        jLabel112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel112MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel112MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel112MouseEntered(evt);
            }
        });
        update_data.getContentPane().add(jLabel112);
        jLabel112.setBounds(260, 350, 130, 30);

        jLabel104.setBackground(new java.awt.Color(102, 204, 255));
        jLabel104.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel104.setText("LAST PRICE UPDATED :");
        update_data.getContentPane().add(jLabel104);
        jLabel104.setBounds(100, 220, 170, 20);

        area1.setEditable(false);
        area1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        area1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area1ActionPerformed(evt);
            }
        });
        update_data.getContentPane().add(area1);
        area1.setBounds(280, 40, 230, 30);

        jLabel102.setBackground(new java.awt.Color(102, 204, 255));
        jLabel102.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel102.setText("PETROL / GASOLINE PRICE :");
        update_data.getContentPane().add(jLabel102);
        jLabel102.setBounds(60, 90, 210, 20);

        jLabel109.setBackground(new java.awt.Color(102, 204, 255));
        jLabel109.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel109.setText("Petrol Bunk / Fuel station pincode :");
        update_data.getContentPane().add(jLabel109);
        jLabel109.setBounds(20, 270, 250, 20);
        update_data.getContentPane().add(hidden_id);
        hidden_id.setBounds(340, 40, 150, 30);

        select_font.setAlwaysOnTop(true);
        select_font.setMinimumSize(new java.awt.Dimension(330, 500));
        select_font.setUndecorated(true);
        select_font.getContentPane().setLayout(new javax.swing.OverlayLayout(select_font.getContentPane()));

        jLayeredPane16.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane16.setOpaque(true);

        jButton4.setText("cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jLayeredPane16.add(jButton4);
        jButton4.setBounds(110, 460, 100, 25);

        jButton5.setText("select");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jLayeredPane16.add(jButton5);
        jButton5.setBounds(220, 460, 100, 25);

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        view_fonts.setBackground(new java.awt.Color(204, 204, 204));
        view_fonts.setOpaque(true);
        view_fonts.setPreferredSize(new java.awt.Dimension(310, 350));

        jLabel143.setBackground(new java.awt.Color(255, 255, 255));
        jLabel143.setFont(new java.awt.Font("Garuda", 0, 12)); // NOI18N
        jLabel143.setText("jLabel143");
        jLabel143.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel143.setOpaque(true);
        jLabel143.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel143MouseClicked(evt);
            }
        });
        view_fonts.add(jLabel143);
        jLabel143.setBounds(0, 0, 310, 20);

        jScrollPane10.setViewportView(view_fonts);

        jLayeredPane16.add(jScrollPane10);
        jScrollPane10.setBounds(10, 33, 310, 350);
        jScrollPane10.getVerticalScrollBar().setUI(new MyScrollBarUI());

        jLayeredPane17.setLayout(new java.awt.GridLayout(2, 0, 0, 2));

        fontDi1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLayeredPane17.add(fontDi1);
        jLayeredPane17.add(fontDi2);

        jLayeredPane16.add(jLayeredPane17);
        jLayeredPane17.setBounds(9, 390, 310, 60);
        jLayeredPane16.add(selected_fon);
        selected_fon.setBounds(70, 110, 0, 0);

        select_font.getContentPane().add(jLayeredPane16);

        change_passwd.setAlwaysOnTop(true);
        change_passwd.setLocationByPlatform(true);
        change_passwd.setMinimumSize(new java.awt.Dimension(450, 350));
        change_passwd.setResizable(false);
        change_passwd.getContentPane().setLayout(null);

        jLabel147.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 24)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(153, 153, 153));
        jLabel147.setText("Change Password");
        change_passwd.getContentPane().add(jLabel147);
        jLabel147.setBounds(10, 10, 458, 30);

        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel148.setText("Re - Password ");
        change_passwd.getContentPane().add(jLabel148);
        jLabel148.setBounds(0, 200, 120, 30);

        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel149.setText("Old Password ");
        change_passwd.getContentPane().add(jLabel149);
        jLabel149.setBounds(0, 90, 120, 30);

        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel150.setText("New Password ");
        change_passwd.getContentPane().add(jLabel150);
        jLabel150.setBounds(0, 150, 120, 30);

        passwrd1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        change_passwd.getContentPane().add(passwrd1);
        passwrd1.setBounds(140, 90, 240, 30);

        passwrd2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        change_passwd.getContentPane().add(passwrd2);
        passwrd2.setBounds(140, 150, 240, 30);

        passwrd3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        change_passwd.getContentPane().add(passwrd3);
        passwrd3.setBounds(140, 210, 240, 30);

        jButton6.setText("update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        change_passwd.getContentPane().add(jButton6);
        jButton6.setBounds(290, 270, 49, 25);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1300, 700));
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

        jButton7.setText("logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        main1.add(jButton7);
        jButton7.setBounds(1270, 30, 80, 25);

        dsptime.setFont(new java.awt.Font("Sony Sketch EF", 0, 14)); // NOI18N
        dsptime.setForeground(new java.awt.Color(255, 255, 255));
        dsptime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dsptime.setText("dsdsdas");
        main1.add(dsptime);
        dsptime.setBounds(960, 10, 190, 30);

        dsptoday.setFont(new java.awt.Font("LCD", 0, 12)); // NOI18N
        dsptoday.setForeground(new java.awt.Color(255, 255, 255));
        dsptoday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dsptoday.setText("sdasd");
        main1.add(dsptoday);
        dsptoday.setBounds(950, 40, 200, 20);

        HEAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/HEAD.jpg"))); // NOI18N
        HEAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HEADMouseClicked(evt);
            }
        });
        main1.add(HEAD);
        HEAD.setBounds(0, 0, 1635, 68);

        menu_head.setLayout(new java.awt.GridLayout(1, 2, 1, 0));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("PETROL");
        meanu_head1.add(jLabel28);
        jLabel28.setBounds(0, 10, 120, 19);

        petrol.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        petrol.setForeground(new java.awt.Color(255, 255, 255));
        petrol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        petrol.setText("23.00");
        meanu_head1.add(petrol);
        petrol.setBounds(0, 30, 120, 60);

        meanu_head1_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meanu_head1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/a1.jpg"))); // NOI18N
        meanu_head1_1.setToolTipText("");
        meanu_head1.add(meanu_head1_1);
        meanu_head1_1.setBounds(0, 0, 117, 100);

        menu_head.add(meanu_head1);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("DIESEL");
        meanu_head2.add(jLabel29);
        jLabel29.setBounds(7, 10, 110, 19);

        diesel.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        diesel.setForeground(new java.awt.Color(255, 255, 255));
        diesel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diesel.setText("23.00");
        meanu_head2.add(diesel);
        diesel.setBounds(0, 30, 120, 60);

        meanu_head1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/a1.jpg"))); // NOI18N
        meanu_head2.add(meanu_head1_2);
        meanu_head1_2.setBounds(0, 0, 117, 100);

        menu_head.add(meanu_head2);

        main1.add(menu_head);
        menu_head.setBounds(0, 70, 235, 100);

        menu_main.setLayout(new java.awt.GridLayout(5, 1, 0, 1));

        menu_main_a1.setLayout(new javax.swing.OverlayLayout(menu_main_a1));

        menu_word1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menu_word1.setForeground(new java.awt.Color(255, 255, 255));
        menu_word1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_word1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/home-one.png"))); // NOI18N
        menu_word1.setToolTipText("");
        menu_word1.setMaximumSize(new java.awt.Dimension(235, 50));
        menu_word1.setMinimumSize(new java.awt.Dimension(235, 50));
        menu_word1.setPreferredSize(new java.awt.Dimension(235, 50));
        menu_word1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_word1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_word1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_word1MouseEntered(evt);
            }
        });
        menu_main_a1.add(menu_word1);
        menu_main_a1.add(menu_bg1);

        menu_main.add(menu_main_a1);

        menu_main_a2.setLayout(new javax.swing.OverlayLayout(menu_main_a2));

        menu_word2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menu_word2.setForeground(new java.awt.Color(255, 255, 255));
        menu_word2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_word2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/staff-one.png"))); // NOI18N
        menu_word2.setToolTipText("");
        menu_word2.setMaximumSize(new java.awt.Dimension(235, 50));
        menu_word2.setMinimumSize(new java.awt.Dimension(235, 50));
        menu_word2.setPreferredSize(new java.awt.Dimension(235, 50));
        menu_word2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_word2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_word2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_word2MouseEntered(evt);
            }
        });
        menu_main_a2.add(menu_word2);
        menu_main_a2.add(menu_bg2);

        menu_main.add(menu_main_a2);

        menu_main_a3.setLayout(new javax.swing.OverlayLayout(menu_main_a3));

        menu_word3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menu_word3.setForeground(new java.awt.Color(255, 255, 255));
        menu_word3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_word3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/stock-one.png"))); // NOI18N
        menu_word3.setToolTipText("");
        menu_word3.setMaximumSize(new java.awt.Dimension(235, 50));
        menu_word3.setMinimumSize(new java.awt.Dimension(235, 50));
        menu_word3.setPreferredSize(new java.awt.Dimension(235, 50));
        menu_word3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_word3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_word3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_word3MouseEntered(evt);
            }
        });
        menu_main_a3.add(menu_word3);
        menu_main_a3.add(menu_bg3);

        menu_main.add(menu_main_a3);

        menu_main_a5.setLayout(new javax.swing.OverlayLayout(menu_main_a5));

        menu_word5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menu_word5.setForeground(new java.awt.Color(255, 255, 255));
        menu_word5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_word5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/about-one.png"))); // NOI18N
        menu_word5.setToolTipText("");
        menu_word5.setMaximumSize(new java.awt.Dimension(235, 50));
        menu_word5.setMinimumSize(new java.awt.Dimension(235, 50));
        menu_word5.setPreferredSize(new java.awt.Dimension(235, 50));
        menu_word5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_word5MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_word5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_word5MouseEntered(evt);
            }
        });
        menu_main_a5.add(menu_word5);
        menu_main_a5.add(menu_bg5);

        menu_main.add(menu_main_a5);

        main1.add(menu_main);
        menu_main.setBounds(0, 340, 235, 240);

        main_display.setBackground(new java.awt.Color(255, 51, 51));
        main_display.setLayout(new javax.swing.OverlayLayout(main_display));

        staff.add(jSeparator1);
        jSeparator1.setBounds(0, 100, 1120, 10);

        innr_menu.setLayout(new java.awt.GridLayout(1, 3, 1, 0));

        innr_head_a1.setLayout(new javax.swing.OverlayLayout(innr_head_a1));

        innr_menu_a1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        innr_menu_a1.setForeground(new java.awt.Color(255, 255, 255));
        innr_menu_a1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        innr_menu_a1.setText("add");
        innr_menu_a1.setMaximumSize(new java.awt.Dimension(708, 47));
        innr_menu_a1.setMinimumSize(new java.awt.Dimension(708, 47));
        innr_menu_a1.setPreferredSize(new java.awt.Dimension(708, 47));
        innr_menu_a1.setRequestFocusEnabled(false);
        innr_menu_a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                innr_menu_a1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                innr_menu_a1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                innr_menu_a1MouseEntered(evt);
            }
        });
        innr_head_a1.add(innr_menu_a1);
        innr_head_a1.add(inn_menu_bg1);

        innr_menu.add(innr_head_a1);

        innr_head_a2.setLayout(new javax.swing.OverlayLayout(innr_head_a2));

        innr_menu_a2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        innr_menu_a2.setForeground(new java.awt.Color(255, 255, 255));
        innr_menu_a2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        innr_menu_a2.setText("view");
        innr_menu_a2.setMaximumSize(new java.awt.Dimension(708, 47));
        innr_menu_a2.setMinimumSize(new java.awt.Dimension(708, 47));
        innr_menu_a2.setPreferredSize(new java.awt.Dimension(708, 47));
        innr_menu_a2.setRequestFocusEnabled(false);
        innr_menu_a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                innr_menu_a2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                innr_menu_a2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                innr_menu_a2MouseEntered(evt);
            }
        });
        innr_head_a2.add(innr_menu_a2);
        innr_head_a2.add(inn_menu_bg2);

        innr_menu.add(innr_head_a2);

        innr_head_a3.setLayout(new javax.swing.OverlayLayout(innr_head_a3));

        innr_menu_a3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        innr_menu_a3.setForeground(new java.awt.Color(255, 255, 255));
        innr_menu_a3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        innr_menu_a3.setText("edit");
        innr_menu_a3.setMaximumSize(new java.awt.Dimension(708, 47));
        innr_menu_a3.setMinimumSize(new java.awt.Dimension(708, 47));
        innr_menu_a3.setPreferredSize(new java.awt.Dimension(708, 47));
        innr_menu_a3.setRequestFocusEnabled(false);
        innr_menu_a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                innr_menu_a3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                innr_menu_a3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                innr_menu_a3MouseEntered(evt);
            }
        });
        innr_head_a3.add(innr_menu_a3);
        innr_head_a3.add(inn_menu_bg3);

        innr_menu.add(innr_head_a3);

        innr_menu_bg.add(innr_menu);
        innr_menu.setBounds(25, 0, 705, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/innr_menu.jpg"))); // NOI18N
        innr_menu_bg.add(jLabel2);
        jLabel2.setBounds(24, 0, 706, 40);

        staff.add(innr_menu_bg);
        innr_menu_bg.setBounds(390, 60, 730, 40);

        innr_main_menu0.setLayout(new javax.swing.OverlayLayout(innr_main_menu0));

        innr_menu_main_a02.setBackground(new java.awt.Color(204, 204, 204));
        innr_menu_main_a02.setOpaque(true);
        innr_menu_main_a02.setLayout(new javax.swing.OverlayLayout(innr_menu_main_a02));

        jLabel80.setBackground(new java.awt.Color(153, 0, 153));
        jLabel80.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("search another one");
        jLabel80.setOpaque(true);
        jLabel80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel80MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel80MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel80MouseEntered(evt);
            }
        });
        show_all.add(jLabel80);
        jLabel80.setBounds(970, 10, 150, 40);

        jTable1.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
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
        jTable1.setDragEnabled(true);
        jTable1.setFillsViewportHeight(true);
        jScrollPane5.setViewportView(jTable1);

        show_all.add(jScrollPane5);
        jScrollPane5.setBounds(10, 60, 1110, 480);

        innr_menu_main_a02.add(show_all);

        jLayeredPane9.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane9.setMaximumSize(new java.awt.Dimension(170, 190));
        jLayeredPane9.setMinimumSize(new java.awt.Dimension(170, 190));
        jLayeredPane9.setOpaque(true);
        jLayeredPane9.add(image_h1);
        image_h1.setBounds(10, 10, 150, 170);

        show_rslt.add(jLayeredPane9);
        jLayeredPane9.setBounds(880, 10, 170, 190);

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel66.setText("gender");
        show_rslt.add(jLabel66);
        jLabel66.setBounds(0, 170, 130, 19);

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel77.setText("Telephone ");
        show_rslt.add(jLabel77);
        jLabel77.setBounds(420, 100, 130, 19);

        out_date11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        out_date11.setForeground(new java.awt.Color(0, 102, 102));
        out_date11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(out_date11);
        out_date11.setBounds(470, 470, 290, 30);

        join_date1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        join_date1.setForeground(new java.awt.Color(0, 102, 102));
        join_date1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(join_date1);
        join_date1.setBounds(170, 470, 270, 30);

        age1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        age1.setForeground(new java.awt.Color(0, 102, 102));
        age1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(age1);
        age1.setBounds(140, 130, 250, 30);

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel68.setText("qualification");
        show_rslt.add(jLabel68);
        jLabel68.setBounds(0, 200, 130, 19);

        user_name3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        user_name3.setForeground(new java.awt.Color(255, 51, 51));
        user_name3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(user_name3);
        user_name3.setBounds(110, 10, 140, 30);

        salary1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        salary1.setForeground(new java.awt.Color(0, 102, 102));
        salary1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(salary1);
        salary1.setBounds(820, 470, 300, 30);

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel73.setText("mobile no");
        show_rslt.add(jLabel73);
        jLabel73.setBounds(420, 70, 130, 19);

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel63.setText(" name");
        show_rslt.add(jLabel63);
        jLabel63.setBounds(0, 70, 130, 19);

        dob1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dob1.setForeground(new java.awt.Color(0, 102, 102));
        dob1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(dob1);
        dob1.setBounds(140, 100, 300, 30);

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel72.setText("duty time");
        show_rslt.add(jLabel72);
        jLabel72.setBounds(420, 130, 130, 19);

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel70.setText("joining date");
        show_rslt.add(jLabel70);
        jLabel70.setBounds(30, 480, 130, 19);

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Present Address");
        show_rslt.add(jLabel67);
        jLabel67.setBounds(0, 250, 150, 19);

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("out date");
        show_rslt.add(jLabel71);
        jLabel71.setBounds(330, 480, 130, 19);

        mobile1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        mobile1.setForeground(new java.awt.Color(0, 102, 102));
        mobile1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(mobile1);
        mobile1.setBounds(560, 60, 300, 30);

        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel75.setText("Date of Birth ");
        show_rslt.add(jLabel75);
        jLabel75.setBounds(0, 110, 130, 19);

        duty1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        duty1.setForeground(new java.awt.Color(0, 102, 102));
        duty1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(duty1);
        duty1.setBounds(560, 120, 300, 30);

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel74.setText("e mail");
        show_rslt.add(jLabel74);
        jLabel74.setBounds(420, 40, 130, 19);

        gender1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gender1.setForeground(new java.awt.Color(0, 102, 102));
        gender1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(gender1);
        gender1.setBounds(140, 160, 300, 30);

        qualification1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        qualification1.setForeground(new java.awt.Color(0, 102, 102));
        qualification1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(qualification1);
        qualification1.setBounds(140, 190, 300, 30);

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel62.setText("user id");
        show_rslt.add(jLabel62);
        jLabel62.setBounds(0, 20, 100, 19);

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel69.setText("salary");
        show_rslt.add(jLabel69);
        jLabel69.setBounds(680, 480, 130, 19);

        Telephone1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Telephone1.setForeground(new java.awt.Color(0, 102, 102));
        Telephone1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(Telephone1);
        Telephone1.setBounds(560, 90, 300, 30);

        email1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        email1.setForeground(new java.awt.Color(0, 102, 102));
        email1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(email1);
        email1.setBounds(560, 30, 300, 30);

        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel76.setText("Permanent Address");
        show_rslt.add(jLabel76);
        jLabel76.setBounds(-20, 360, 170, 19);

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel65.setText("age");
        show_rslt.add(jLabel65);
        jLabel65.setBounds(0, 140, 130, 19);

        name2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        name2.setForeground(new java.awt.Color(0, 102, 102));
        name2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        show_rslt.add(name2);
        name2.setBounds(140, 60, 300, 30);

        peaddr1.setEditable(false);
        peaddr1.setColumns(20);
        peaddr1.setLineWrap(true);
        peaddr1.setRows(5);
        show_rslt.add(peaddr1);
        peaddr1.setBounds(160, 360, 600, 90);

        jLabel101.setBackground(new java.awt.Color(0, 153, 51));
        jLabel101.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("edit");
        jLabel101.setOpaque(true);
        jLabel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel101MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel101MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel101MouseEntered(evt);
            }
        });
        show_rslt.add(jLabel101);
        jLabel101.setBounds(880, 420, 150, 40);

        praddr1.setEditable(false);
        praddr1.setColumns(20);
        praddr1.setLineWrap(true);
        praddr1.setRows(5);
        show_rslt.add(praddr1);
        praddr1.setBounds(160, 250, 600, 90);

        jLabel78.setBackground(new java.awt.Color(0, 153, 204));
        jLabel78.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("view all");
        jLabel78.setOpaque(true);
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel78MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel78MouseEntered(evt);
            }
        });
        show_rslt.add(jLabel78);
        jLabel78.setBounds(880, 320, 150, 40);

        jLabel79.setBackground(new java.awt.Color(153, 0, 153));
        jLabel79.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("search another one");
        jLabel79.setOpaque(true);
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel79MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel79MouseEntered(evt);
            }
        });
        show_rslt.add(jLabel79);
        jLabel79.setBounds(880, 370, 150, 40);

        innr_menu_main_a02.add(show_rslt);

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/searchandzoom.png"))); // NOI18N
        search_one.add(jLabel64);
        jLabel64.setBounds(350, 20, 30, 30);

        searchfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchfieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfieldKeyReleased(evt);
            }
        });
        search_one.add(searchfield);
        searchfield.setBounds(60, 20, 320, 30);

        show_reslut_clicabl.setLayout(new java.awt.GridLayout(8, 1, 0, 2));
        search_one.add(show_reslut_clicabl);
        show_reslut_clicabl.setBounds(60, 60, 320, 500);

        jLabel81.setBackground(new java.awt.Color(0, 153, 204));
        jLabel81.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("view all");
        jLabel81.setOpaque(true);
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel81MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel81MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel81MouseEntered(evt);
            }
        });
        search_one.add(jLabel81);
        jLabel81.setBounds(380, 20, 100, 30);

        innr_menu_main_a02.add(search_one);

        innr_main_menu0.add(innr_menu_main_a02);

        innr_menu_main_a03.setBackground(new java.awt.Color(204, 204, 204));
        innr_menu_main_a03.setOpaque(true);

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel92.setText("out date");
        innr_menu_main_a03.add(jLabel92);
        jLabel92.setBounds(390, 100, 100, 19);

        salary2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        salary2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salary2KeyTyped(evt);
            }
        });
        innr_menu_main_a03.add(salary2);
        salary2.setBounds(500, 440, 240, 30);

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel98.setText("Telephone ");
        innr_menu_main_a03.add(jLabel98);
        jLabel98.setBounds(390, 500, 100, 19);

        dob2.setCalendarPreferredSize(new java.awt.Dimension(400, 200));
        dob2.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dob2OnSelectionChange(evt);
            }
        });
        dob2.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dob2OnCommit(evt);
            }
        });
        innr_menu_main_a03.add(dob2);
        dob2.setBounds(140, 190, 240, 30);
        dob.setDateFormat(sdfhz);

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel88.setText("Present Address");
        innr_menu_main_a03.add(jLabel88);
        jLabel88.setBounds(140, 330, 120, 19);

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel91.setText("joining date");
        innr_menu_main_a03.add(jLabel91);
        jLabel91.setBounds(390, 50, 100, 19);

        fname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        innr_menu_main_a03.add(fname1);
        fname1.setBounds(140, 90, 240, 30);

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel87.setText("gender");
        innr_menu_main_a03.add(jLabel87);
        jLabel87.setBounds(30, 300, 100, 19);

        jLabel99.setBackground(new java.awt.Color(51, 51, 255));
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("update");
        jLabel99.setOpaque(true);
        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel99MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel99MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel99MouseEntered(evt);
            }
        });
        innr_menu_main_a03.add(jLabel99);
        jLabel99.setBounds(870, 490, 170, 30);

        join_date2.setCalendarPreferredSize(new java.awt.Dimension(400, 200));
        innr_menu_main_a03.add(join_date2);
        join_date2.setBounds(500, 40, 240, 30);
        join_date.setDateFormat(sdfhz);

        jLayeredPane10.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane10.setMaximumSize(new java.awt.Dimension(170, 190));
        jLayeredPane10.setMinimumSize(new java.awt.Dimension(170, 190));
        jLayeredPane10.setOpaque(true);
        jLayeredPane10.add(image_h2);
        image_h2.setBounds(10, 10, 150, 170);

        innr_menu_main_a03.add(jLayeredPane10);
        jLayeredPane10.setBounds(860, 40, 170, 190);

        mobile2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        mobile2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobile2FocusLost(evt);
            }
        });
        mobile2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobile2KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobile2KeyPressed(evt);
            }
        });
        innr_menu_main_a03.add(mobile2);
        mobile2.setBounds(140, 490, 240, 30);

        jLayeredPane11.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane11.setOpaque(true);

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel97.setText("Permanent Address");
        jLayeredPane11.add(jLabel97);
        jLabel97.setBounds(0, 10, 118, 19);

        jCheckBox2.setText("Same Present Address");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jLayeredPane11.add(jCheckBox2);
        jCheckBox2.setBounds(0, 30, 240, 21);

        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));

        peaddr2.setColumns(20);
        peaddr2.setRows(5);
        peaddr2.setText("\n");
        jScrollPane7.setViewportView(peaddr2);

        jLayeredPane11.add(jScrollPane7);
        jScrollPane7.setBounds(0, 50, 240, 80);
        jScrollPane7.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane7.getHorizontalScrollBar().setUI(new MyScrollBarUI());
        //UIManager.put("ScrollBarUI", "my.package.MyScrollBarUI");

        innr_menu_main_a03.add(jLayeredPane11);
        jLayeredPane11.setBounds(500, 290, 240, 135);

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel95.setText("e mail");
        innr_menu_main_a03.add(jLabel95);
        jLabel95.setBounds(30, 450, 100, 19);

        path1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        innr_menu_main_a03.add(path1);
        path1.setBounds(860, 230, 170, 30);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel85.setText("last name");
        innr_menu_main_a03.add(jLabel85);
        jLabel85.setBounds(30, 150, 100, 19);

        qualification2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SSLC", "PLUS TWO", "DEGREE", "OTHER" }));
        qualification2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));
        innr_menu_main_a03.add(qualification2);
        qualification2.setBounds(500, 190, 240, 30);

        email2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        email2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                email2FocusLost(evt);
            }
        });
        innr_menu_main_a03.add(email2);
        email2.setBounds(140, 440, 240, 30);

        jLabel100.setBackground(new java.awt.Color(51, 51, 255));
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("cancel");
        jLabel100.setOpaque(true);
        jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel100MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel100MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel100MouseEntered(evt);
            }
        });
        innr_menu_main_a03.add(jLabel100);
        jLabel100.setBounds(870, 450, 170, 30);

        jButton2.setText("Upload Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        innr_menu_main_a03.add(jButton2);
        jButton2.setBounds(860, 260, 170, 30);

        Telephone2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        Telephone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Telephone2KeyTyped(evt);
            }
        });
        innr_menu_main_a03.add(Telephone2);
        Telephone2.setBounds(500, 490, 240, 30);

        out_date2.setCalendarPreferredSize(new java.awt.Dimension(400, 200));
        innr_menu_main_a03.add(out_date2);
        out_date2.setBounds(620, 90, 120, 30);
        out_date1.setDateFormat(sdfhz);

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel86.setText("age");
        innr_menu_main_a03.add(jLabel86);
        jLabel86.setBounds(30, 250, 100, 19);

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel94.setText("mobile no");
        innr_menu_main_a03.add(jLabel94);
        jLabel94.setBounds(30, 500, 100, 19);

        jLayeredPane8.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane8.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane8.setFocusable(false);
        jLayeredPane8.setOpaque(true);

        buttonGroup2.add(v3);
        v3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        v3.setText("day");
        v3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v3ActionPerformed(evt);
            }
        });
        jLayeredPane8.add(v3);
        v3.setBounds(30, 0, 80, 30);

        buttonGroup2.add(v4);
        v4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        v4.setText("night");
        v4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v4ActionPerformed(evt);
            }
        });
        jLayeredPane8.add(v4);
        v4.setBounds(140, 0, 80, 30);

        innr_menu_main_a03.add(jLayeredPane8);
        jLayeredPane8.setBounds(500, 140, 240, 30);

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));

        praddr2.setColumns(20);
        praddr2.setRows(5);
        jScrollPane6.setViewportView(praddr2);

        innr_menu_main_a03.add(jScrollPane6);
        jScrollPane6.setBounds(140, 350, 240, 97);
        jScrollPane6.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane6.getHorizontalScrollBar().setUI(new MyScrollBarUI());
        //UIManager.put("ScrollBarUI", "my.package.MyScrollBarUI");

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel83.setText("user id");
        innr_menu_main_a03.add(jLabel83);
        jLabel83.setBounds(30, 20, 100, 19);

        jLayeredPane7.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane7.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane7.setFocusable(false);
        jLayeredPane7.setOpaque(true);

        buttonGroup1.add(c3);
        c3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        c3.setText("male");
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });
        jLayeredPane7.add(c3);
        c3.setBounds(30, 0, 80, 30);

        buttonGroup1.add(c4);
        c4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        c4.setText("female");
        c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4ActionPerformed(evt);
            }
        });
        jLayeredPane7.add(c4);
        c4.setBounds(140, 0, 80, 30);

        innr_menu_main_a03.add(jLayeredPane7);
        jLayeredPane7.setBounds(140, 290, 240, 30);

        lname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        innr_menu_main_a03.add(lname1);
        lname1.setBounds(140, 140, 240, 30);

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel93.setText("duty time");
        innr_menu_main_a03.add(jLabel93);
        jLabel93.setBounds(390, 150, 100, 19);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel89.setText("qualification");
        innr_menu_main_a03.add(jLabel89);
        jLabel89.setBounds(390, 200, 100, 19);

        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel96.setText("Date of Birth ");
        innr_menu_main_a03.add(jLabel96);
        jLabel96.setBounds(30, 200, 100, 19);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel84.setText("first name");
        innr_menu_main_a03.add(jLabel84);
        jLabel84.setBounds(30, 100, 100, 19);

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel90.setText("salary");
        innr_menu_main_a03.add(jLabel90);
        jLabel90.setBounds(390, 450, 100, 19);

        age2.setEditable(false);
        age2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        age2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                age2MouseClicked(evt);
            }
        });
        innr_menu_main_a03.add(age2);
        age2.setBounds(140, 240, 240, 30);

        all_emplo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        all_emplo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        all_emplo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                all_emploItemStateChanged(evt);
            }
        });
        all_emplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                all_emploActionPerformed(evt);
            }
        });
        innr_menu_main_a03.add(all_emplo);
        all_emplo.setBounds(140, 10, 240, 30);

        jLabel32.setBackground(new java.awt.Color(51, 51, 255));
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("delete");
        jLabel32.setOpaque(true);
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
        });
        innr_menu_main_a03.add(jLabel32);
        jLabel32.setBounds(870, 410, 170, 30);

        jRadioButton2.setText("notspecified");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        innr_menu_main_a03.add(jRadioButton2);
        jRadioButton2.setBounds(505, 90, 120, 30);

        innr_main_menu0.add(innr_menu_main_a03);

        innr_menu_main_a01.setBackground(new java.awt.Color(204, 204, 204));
        innr_menu_main_a01.setOpaque(true);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("user id");
        innr_menu_main_a01.add(jLabel4);
        jLabel4.setBounds(0, 50, 130, 20);

        path.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        innr_menu_main_a01.add(path);
        path.setBounds(860, 230, 170, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("first name");
        innr_menu_main_a01.add(jLabel5);
        jLabel5.setBounds(0, 100, 130, 19);

        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        innr_menu_main_a01.add(fname);
        fname.setBounds(140, 90, 240, 30);

        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        innr_menu_main_a01.add(lname);
        lname.setBounds(140, 140, 240, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("last name");
        innr_menu_main_a01.add(jLabel6);
        jLabel6.setBounds(0, 150, 130, 19);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("age");
        innr_menu_main_a01.add(jLabel7);
        jLabel7.setBounds(0, 250, 130, 19);

        age.setEditable(false);
        age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ageMouseClicked(evt);
            }
        });
        innr_menu_main_a01.add(age);
        age.setBounds(140, 240, 240, 30);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("gender");
        innr_menu_main_a01.add(jLabel8);
        jLabel8.setBounds(0, 300, 130, 19);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setFocusable(false);
        jLayeredPane1.setOpaque(true);

        buttonGroup1.add(c1);
        c1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        c1.setText("male");
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(c1);
        c1.setBounds(30, 0, 80, 30);

        buttonGroup1.add(c2);
        c2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        c2.setText("female");
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(c2);
        c2.setBounds(140, 0, 80, 30);

        innr_menu_main_a01.add(jLayeredPane1);
        jLayeredPane1.setBounds(140, 290, 240, 30);

        dob.setCalendarPreferredSize(new java.awt.Dimension(400, 200));
        dob.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dobOnSelectionChange(evt);
            }
        });
        dob.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dobOnCommit(evt);
            }
        });
        innr_menu_main_a01.add(dob);
        dob.setBounds(140, 190, 240, 30);
        dob.setDateFormat(sdfhz);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Present Address");
        innr_menu_main_a01.add(jLabel9);
        jLabel9.setBounds(110, 330, 150, 19);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));

        praddr.setColumns(20);
        praddr.setRows(5);
        jScrollPane2.setViewportView(praddr);

        innr_menu_main_a01.add(jScrollPane2);
        jScrollPane2.setBounds(140, 350, 240, 97);
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollBarUI());
        //UIManager.put("ScrollBarUI", "my.package.MyScrollBarUI");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("qualification");
        innr_menu_main_a01.add(jLabel10);
        jLabel10.setBounds(380, 195, 110, 20);

        qualification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SSLC", "PLUS TWO", "DEGREE", "OTHER" }));
        qualification.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));
        innr_menu_main_a01.add(qualification);
        qualification.setBounds(500, 190, 240, 30);

        salary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        salary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salaryKeyTyped(evt);
            }
        });
        innr_menu_main_a01.add(salary);
        salary.setBounds(500, 440, 240, 30);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("salary");
        innr_menu_main_a01.add(jLabel11);
        jLabel11.setBounds(380, 445, 110, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("joining date");
        innr_menu_main_a01.add(jLabel12);
        jLabel12.setBounds(380, 45, 110, 20);

        join_date.setCalendarPreferredSize(new java.awt.Dimension(400, 200));
        innr_menu_main_a01.add(join_date);
        join_date.setBounds(500, 40, 240, 30);
        join_date.setDateFormat(sdfhz);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("out date");
        innr_menu_main_a01.add(jLabel13);
        jLabel13.setBounds(380, 95, 110, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("duty time");
        innr_menu_main_a01.add(jLabel14);
        jLabel14.setBounds(380, 145, 110, 20);

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane2.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane2.setFocusable(false);
        jLayeredPane2.setOpaque(true);

        buttonGroup2.add(v1);
        v1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        v1.setText("day");
        v1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v1ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(v1);
        v1.setBounds(30, 0, 80, 30);

        buttonGroup2.add(v2);
        v2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        v2.setText("night");
        v2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v2ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(v2);
        v2.setBounds(140, 0, 80, 30);

        innr_menu_main_a01.add(jLayeredPane2);
        jLayeredPane2.setBounds(500, 140, 240, 30);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("mobile no");
        innr_menu_main_a01.add(jLabel15);
        jLabel15.setBounds(0, 500, 130, 19);

        mobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        mobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobileFocusLost(evt);
            }
        });
        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobileKeyPressed(evt);
            }
        });
        innr_menu_main_a01.add(mobile);
        mobile.setBounds(140, 490, 240, 30);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("e mail");
        innr_menu_main_a01.add(jLabel16);
        jLabel16.setBounds(0, 450, 130, 19);

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        innr_menu_main_a01.add(email);
        email.setBounds(140, 440, 240, 30);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Date of Birth ");
        innr_menu_main_a01.add(jLabel17);
        jLabel17.setBounds(0, 200, 130, 19);

        jLayeredPane3.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane3.setMaximumSize(new java.awt.Dimension(170, 190));
        jLayeredPane3.setMinimumSize(new java.awt.Dimension(170, 190));
        jLayeredPane3.setOpaque(true);
        jLayeredPane3.add(image_h);
        image_h.setBounds(10, 10, 150, 170);

        innr_menu_main_a01.add(jLayeredPane3);
        jLayeredPane3.setBounds(860, 40, 170, 190);

        jButton1.setText("Upload Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        innr_menu_main_a01.add(jButton1);
        jButton1.setBounds(860, 260, 170, 30);

        jLayeredPane4.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane4.setOpaque(true);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Permanent Address");
        jLayeredPane4.add(jLabel18);
        jLabel18.setBounds(0, 10, 118, 19);

        jCheckBox1.setText("Same Present Address");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jLayeredPane4.add(jCheckBox1);
        jCheckBox1.setBounds(0, 30, 240, 21);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));

        peaddr.setColumns(20);
        peaddr.setRows(5);
        peaddr.setText("\n");
        jScrollPane3.setViewportView(peaddr);

        jLayeredPane4.add(jScrollPane3);
        jScrollPane3.setBounds(0, 50, 240, 80);
        jScrollPane3.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane3.getHorizontalScrollBar().setUI(new MyScrollBarUI());
        //UIManager.put("ScrollBarUI", "my.package.MyScrollBarUI");

        innr_menu_main_a01.add(jLayeredPane4);
        jLayeredPane4.setBounds(500, 290, 240, 135);

        out_date1.setCalendarPreferredSize(new java.awt.Dimension(400, 200));
        innr_menu_main_a01.add(out_date1);
        out_date1.setBounds(630, 90, 110, 30);
        out_date1.setDateFormat(sdfhz);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Telephone ");
        innr_menu_main_a01.add(jLabel19);
        jLabel19.setBounds(380, 495, 110, 20);

        Telephone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        Telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelephoneKeyTyped(evt);
            }
        });
        innr_menu_main_a01.add(Telephone);
        Telephone.setBounds(500, 490, 240, 30);

        jLabel20.setBackground(new java.awt.Color(51, 51, 255));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("save");
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
        });
        innr_menu_main_a01.add(jLabel20);
        jLabel20.setBounds(870, 490, 170, 30);

        jLabel21.setBackground(new java.awt.Color(51, 51, 255));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("cancel");
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
        });
        innr_menu_main_a01.add(jLabel21);
        jLabel21.setBounds(870, 450, 170, 30);

        user_name1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        user_name1.setForeground(new java.awt.Color(255, 51, 51));
        user_name1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        user_name1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_name1MouseClicked(evt);
            }
        });
        innr_menu_main_a01.add(user_name1);
        user_name1.setBounds(140, 40, 240, 30);

        jRadioButton1.setText("notspecified");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        innr_menu_main_a01.add(jRadioButton1);
        jRadioButton1.setBounds(505, 90, 120, 30);

        innr_main_menu0.add(innr_menu_main_a01);

        staff.add(innr_main_menu0);
        innr_main_menu0.setBounds(-1, 100, 1130, 550);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("Staff management");
        staff.add(jLabel3);
        jLabel3.setBounds(10, 70, 400, 30);

        main_display.add(staff);

        stock.setBackground(new java.awt.Color(255, 255, 255));
        stock.setOpaque(true);

        jLayeredPane6.setLayout(new java.awt.GridLayout(1, 3, 1, 0));

        dver2.setLayout(new javax.swing.OverlayLayout(dver2));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("IMPORTED STOCK");
        jLabel60.setMaximumSize(new java.awt.Dimension(200, 30));
        jLabel60.setMinimumSize(new java.awt.Dimension(200, 30));
        jLabel60.setOpaque(true);
        jLabel60.setPreferredSize(new java.awt.Dimension(200, 30));
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel60MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel60MouseEntered(evt);
            }
        });
        dver2.add(jLabel60);

        jLayeredPane6.add(dver2);

        dver1.setLayout(new javax.swing.OverlayLayout(dver1));

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("AVAILABLE STOCK");
        jLabel59.setMaximumSize(new java.awt.Dimension(200, 30));
        jLabel59.setMinimumSize(new java.awt.Dimension(200, 30));
        jLabel59.setOpaque(true);
        jLabel59.setPreferredSize(new java.awt.Dimension(200, 30));
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel59MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel59MouseEntered(evt);
            }
        });
        dver1.add(jLabel59);

        jLayeredPane6.add(dver1);

        dver3.setLayout(new javax.swing.OverlayLayout(dver3));

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("SALES INFO");
        jLabel61.setMaximumSize(new java.awt.Dimension(200, 30));
        jLabel61.setMinimumSize(new java.awt.Dimension(200, 30));
        jLabel61.setOpaque(true);
        jLabel61.setPreferredSize(new java.awt.Dimension(200, 30));
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel61MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel61MouseEntered(evt);
            }
        });
        dver3.add(jLabel61);

        jLayeredPane6.add(dver3);

        stock.add(jLayeredPane6);
        jLayeredPane6.setBounds(0, 0, 600, 30);
        stock.add(jSeparator2);
        jSeparator2.setBounds(0, 30, 1120, 3);

        main_forStk.setLayout(new javax.swing.OverlayLayout(main_forStk));

        SALES_INFO.setBackground(new java.awt.Color(203, 203, 203));
        SALES_INFO.setOpaque(true);

        dfdfdf.setBackground(new java.awt.Color(255, 255, 255));
        dfdfdf.setOpaque(true);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("total selling :");
        dfdfdf.add(jLabel49);
        jLabel49.setBounds(20, 160, 110, 20);

        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("DIESEL");
        dfdfdf.add(jLabel53);
        jLabel53.setBounds(40, 230, 59, 19);

        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("Date :");
        dfdfdf.add(jLabel55);
        jLabel55.setBounds(40, 10, 53, 19);

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel56.setText("area : ");
        dfdfdf.add(jLabel56);
        jLabel56.setBounds(60, 70, 70, 19);

        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel132.setText("total import :");
        dfdfdf.add(jLabel132);
        jLabel132.setBounds(20, 100, 110, 20);

        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel133.setText("total selling :");
        dfdfdf.add(jLabel133);
        jLabel133.setBounds(20, 320, 110, 20);

        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel134.setText("total import :");
        dfdfdf.add(jLabel134);
        jLabel134.setBounds(20, 260, 110, 20);
        dfdfdf.add(dtotals);
        dtotals.setBounds(140, 320, 200, 20);
        dfdfdf.add(parea);
        parea.setBounds(140, 70, 200, 20);
        dfdfdf.add(pimpto);
        pimpto.setBounds(140, 100, 200, 20);
        dfdfdf.add(pseeltot);
        pseeltot.setBounds(140, 160, 200, 20);
        dfdfdf.add(darea);
        darea.setBounds(200, 10, 120, 0);
        dfdfdf.add(dtotl);
        dtotl.setBounds(140, 260, 200, 20);

        jLabel136.setText("todays' selling");
        dfdfdf.add(jLabel136);
        jLabel136.setBounds(350, 20, 360, 19);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setEnabled(false);
        jTable3.setOpaque(false);
        jScrollPane9.setViewportView(jTable3);

        dfdfdf.add(jScrollPane9);
        jScrollPane9.setBounds(353, 43, 440, 330);

        jLabel137.setText("previous days");
        dfdfdf.add(jLabel137);
        jLabel137.setBounds(10, 390, 350, 19);
        dfdfdf.add(pimpto1);
        pimpto1.setBounds(140, 130, 200, 20);

        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel138.setText("price :");
        dfdfdf.add(jLabel138);
        jLabel138.setBounds(20, 130, 110, 20);

        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel139.setText("price :");
        dfdfdf.add(jLabel139);
        jLabel139.setBounds(20, 190, 110, 20);
        dfdfdf.add(pseeltot1);
        pseeltot1.setBounds(140, 190, 200, 20);
        dfdfdf.add(dtotl1);
        dtotl1.setBounds(140, 290, 200, 20);

        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel140.setText("price :");
        dfdfdf.add(jLabel140);
        jLabel140.setBounds(20, 290, 110, 20);

        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel141.setText("price:");
        dfdfdf.add(jLabel141);
        jLabel141.setBounds(20, 350, 110, 20);
        dfdfdf.add(dtotals1);
        dtotals1.setBounds(140, 350, 200, 20);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.setEnabled(false);
        jTable5.setOpaque(false);
        jTable5.setRowSelectionAllowed(false);
        jScrollPane11.setViewportView(jTable5);

        dfdfdf.add(jScrollPane11);
        jScrollPane11.setBounds(10, 413, 780, 180);

        showDate.setCalendarPreferredSize(new java.awt.Dimension(400, 200));
        showDate.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                showDateOnSelectionChange(evt);
            }
        });
        dfdfdf.add(showDate);
        showDate.setBounds(95, 5, 170, 30);

        jLabel145.setForeground(new java.awt.Color(102, 102, 102));
        jLabel145.setText("PETROL");
        dfdfdf.add(jLabel145);
        jLabel145.setBounds(40, 50, 47, 19);

        jLabel151.setBackground(new java.awt.Color(77, 166, 200));
        jLabel151.setForeground(new java.awt.Color(254, 254, 254));
        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel151.setText("refresh");
        jLabel151.setOpaque(true);
        jLabel151.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel151MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel151MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel151MouseEntered(evt);
            }
        });
        dfdfdf.add(jLabel151);
        jLabel151.setBounds(270, 5, 70, 29);

        SALES_INFO.add(dfdfdf);
        dfdfdf.setBounds(10, 10, 800, 600);

        area_id_h.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SALES_INFO.add(area_id_h);
        area_id_h.setBounds(240, 30, 110, 20);

        main_forStk.add(SALES_INFO);

        AVAILABLE_STOCK.setBackground(new java.awt.Color(203, 203, 203));
        AVAILABLE_STOCK.setOpaque(true);

        jLayeredPane15.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane15.setOpaque(true);

        jLabel130.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel130.setText("PETROL");
        jLayeredPane15.add(jLabel130);
        jLabel130.setBounds(-50, 20, 150, 20);

        s3d1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        s3d1.setForeground(new java.awt.Color(0, 102, 0));
        jLayeredPane15.add(s3d1);
        s3d1.setBounds(40, 40, 240, 30);

        s3d2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        s3d2.setForeground(new java.awt.Color(255, 51, 0));
        jLayeredPane15.add(s3d2);
        s3d2.setBounds(300, 40, 330, 30);

        s3d3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLayeredPane15.add(s3d3);
        s3d3.setBounds(650, 30, 160, 40);

        s3d4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLayeredPane15.add(s3d4);
        s3d4.setBounds(640, 100, 160, 40);

        s3d5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        s3d5.setForeground(new java.awt.Color(255, 51, 0));
        jLayeredPane15.add(s3d5);
        s3d5.setBounds(290, 110, 330, 30);

        s3d6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        s3d6.setForeground(new java.awt.Color(0, 102, 0));
        jLayeredPane15.add(s3d6);
        s3d6.setBounds(30, 110, 240, 30);

        jLabel131.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel131.setText("History");
        jLayeredPane15.add(jLabel131);
        jLabel131.setBounds(20, 160, 170, 20);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable2);

        jLayeredPane15.add(jScrollPane8);
        jScrollPane8.setBounds(20, 190, 770, 370);

        jLabel144.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel144.setText("DIESEL");
        jLayeredPane15.add(jLabel144);
        jLabel144.setBounds(-50, 90, 150, 20);

        AVAILABLE_STOCK.add(jLayeredPane15);
        jLayeredPane15.setBounds(10, 40, 810, 580);

        main_forStk.add(AVAILABLE_STOCK);

        IMPORTED_STOCK.setBackground(new java.awt.Color(203, 203, 203));
        IMPORTED_STOCK.setOpaque(true);

        jLayeredPane13.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane13.setOpaque(true);

        jLabel114.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 51, 51));
        jLabel114.setText("PETROL");
        jLayeredPane13.add(jLabel114);
        jLabel114.setBounds(20, 20, 160, 17);

        jLabel115.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 51, 51));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel115.setText("total price :");
        jLayeredPane13.add(jLabel115);
        jLabel115.setBounds(0, 230, 150, 15);

        jLabel116.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 51, 51));
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel116.setText("dealer :");
        jLayeredPane13.add(jLabel116);
        jLabel116.setBounds(0, 110, 150, 17);

        jLabel117.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 51, 51));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel117.setText("amount (in litre) :");
        jLayeredPane13.add(jLabel117);
        jLabel117.setBounds(0, 150, 150, 15);

        jLabel118.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 51, 51));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel118.setText("price (for 1 litre):");
        jLayeredPane13.add(jLabel118);
        jLabel118.setBounds(0, 190, 150, 15);

        total.setEditable(false);
        total.setBackground(new java.awt.Color(204, 204, 204));
        total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalMouseClicked(evt);
            }
        });
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jLayeredPane13.add(total);
        total.setBounds(160, 220, 170, 25);

        deaker.setBackground(new java.awt.Color(204, 204, 204));
        deaker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        deaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deakerActionPerformed(evt);
            }
        });
        jLayeredPane13.add(deaker);
        deaker.setBounds(160, 100, 170, 25);

        amount1.setBackground(new java.awt.Color(204, 204, 204));
        amount1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        amount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount1ActionPerformed(evt);
            }
        });
        amount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amount1KeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amount1KeyReleased(evt);
            }
        });
        jLayeredPane13.add(amount1);
        amount1.setBounds(160, 140, 170, 25);

        price.setBackground(new java.awt.Color(204, 204, 204));
        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceKeyTyped(evt);
            }
        });
        jLayeredPane13.add(price);
        price.setBounds(160, 180, 170, 25);

        jLabel123.setBackground(new java.awt.Color(102, 102, 102));
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("save");
        jLabel123.setOpaque(true);
        jLabel123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel123MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel123MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel123MouseEntered(evt);
            }
        });
        jLayeredPane13.add(jLabel123);
        jLabel123.setBounds(210, 270, 120, 30);

        IMPORTED_STOCK.add(jLayeredPane13);
        jLayeredPane13.setBounds(30, 30, 350, 510);

        jLayeredPane14.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane14.setOpaque(true);

        jLabel113.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 51, 51));
        jLabel113.setText("DIESEL");
        jLayeredPane14.add(jLabel113);
        jLabel113.setBounds(20, 20, 250, 15);

        jLabel125.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 51, 51));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel125.setText("amount (in litre) :");
        jLayeredPane14.add(jLabel125);
        jLabel125.setBounds(10, 150, 150, 15);

        jLabel124.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(0, 51, 51));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel124.setText("dealer :");
        jLayeredPane14.add(jLabel124);
        jLabel124.setBounds(10, 110, 150, 17);

        jLabel127.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 51, 51));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel127.setText("total price :");
        jLayeredPane14.add(jLabel127);
        jLabel127.setBounds(10, 230, 150, 15);

        amount2.setBackground(new java.awt.Color(204, 204, 204));
        amount2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        amount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount2ActionPerformed(evt);
            }
        });
        amount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amount2KeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amount2KeyReleased(evt);
            }
        });
        jLayeredPane14.add(amount2);
        amount2.setBounds(170, 140, 170, 25);

        price1.setBackground(new java.awt.Color(204, 204, 204));
        price1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        price1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                price1ActionPerformed(evt);
            }
        });
        price1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                price1KeyTyped(evt);
            }
        });
        jLayeredPane14.add(price1);
        price1.setBounds(170, 180, 170, 25);

        jLabel128.setBackground(new java.awt.Color(102, 102, 102));
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("save");
        jLabel128.setOpaque(true);
        jLabel128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel128MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel128MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel128MouseEntered(evt);
            }
        });
        jLayeredPane14.add(jLabel128);
        jLabel128.setBounds(220, 270, 120, 30);

        deaker1.setBackground(new java.awt.Color(204, 204, 204));
        deaker1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        deaker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deaker1ActionPerformed(evt);
            }
        });
        jLayeredPane14.add(deaker1);
        deaker1.setBounds(170, 100, 170, 25);

        jLabel126.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 51, 51));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel126.setText("price (for 1 litre):");
        jLayeredPane14.add(jLabel126);
        jLabel126.setBounds(10, 190, 150, 15);

        total1.setEditable(false);
        total1.setBackground(new java.awt.Color(204, 204, 204));
        total1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        total1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                total1MouseClicked(evt);
            }
        });
        total1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total1ActionPerformed(evt);
            }
        });
        jLayeredPane14.add(total1);
        total1.setBounds(170, 220, 170, 25);

        IMPORTED_STOCK.add(jLayeredPane14);
        jLayeredPane14.setBounds(440, 30, 350, 510);

        jLabel129.setFont(new java.awt.Font("DialogInput", 0, 10)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(102, 102, 102));
        jLabel129.setText("IMPORTED STOCK");
        IMPORTED_STOCK.add(jLabel129);
        jLabel129.setBounds(30, 0, 360, 30);

        main_forStk.add(IMPORTED_STOCK);

        stock.add(main_forStk);
        main_forStk.setBounds(0, 30, 830, 620);

        jLabel34.setText("PETROL");
        maintop_top.add(jLabel34);
        jLabel34.setBounds(39, 260, 90, 19);

        jLabel36.setText("DIESEL");
        maintop_top.add(jLabel36);
        jLabel36.setBounds(160, 260, 110, 19);

        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jLabel38.setText(" per litre");
        maintop_top.add(jLabel38);
        jLabel38.setBounds(190, 10, 80, 19);

        dlitr1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        dlitr1.setForeground(new java.awt.Color(0, 51, 153));
        maintop_top.add(dlitr1);
        dlitr1.setBounds(150, 280, 120, 40);

        plitr1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        plitr1.setForeground(new java.awt.Color(0, 51, 153));
        maintop_top.add(plitr1);
        plitr1.setBounds(30, 280, 120, 40);

        jLabel119.setForeground(new java.awt.Color(153, 153, 153));
        jLabel119.setText("administrative");
        maintop_top.add(jLabel119);
        jLabel119.setBounds(20, 420, 110, 19);
        maintop_top.add(jSeparator3);
        jSeparator3.setBounds(130, 430, 150, 10);

        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel120.setText("petrol");
        maintop_top.add(jLabel120);
        jLabel120.setBounds(40, 490, 110, 19);

        jLabel121.setText("capacity of tank         in litre");
        maintop_top.add(jLabel121);
        jLabel121.setBounds(20, 450, 260, 19);

        pup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pupActionPerformed(evt);
            }
        });
        pup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pupKeyTyped(evt);
            }
        });
        maintop_top.add(pup);
        pup.setBounds(160, 480, 70, 30);

        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel122.setText("diesel");
        maintop_top.add(jLabel122);
        jLabel122.setBounds(40, 530, 110, 19);

        dup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dupActionPerformed(evt);
            }
        });
        dup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dupKeyTyped(evt);
            }
        });
        maintop_top.add(dup);
        dup.setBounds(160, 520, 70, 30);

        jButton3.setText("update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        maintop_top.add(jButton3);
        jButton3.setBounds(110, 570, 120, 25);

        stock.add(maintop_top);
        maintop_top.setBounds(829, 30, 290, 620);

        base.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/new mesure img/fr_new.png"))); // NOI18N
        mesure_display.add(base);
        base.setBounds(0, 0, 290, 410);

        fr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/new mesure img/fr1_new.png"))); // NOI18N
        mesure_display.add(fr1);
        fr1.setBounds(0, -80, 290, 410);

        fr2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/new mesure img/fr2_new.png"))); // NOI18N
        mesure_display.add(fr2);
        fr2.setBounds(0, 25, 290, 410);

        stock.add(mesure_display);
        mesure_display.setBounds(828, 30, 290, 400);

        main_display.add(stock);

        home.setBackground(new java.awt.Color(204, 204, 204));
        home.setOpaque(true);

        Each_main_b.setBackground(new java.awt.Color(241, 243, 242));
        Each_main_b.setMinimumSize(new java.awt.Dimension(330, 200));
        Each_main_b.setOpaque(true);
        Each_main_b.setPreferredSize(new java.awt.Dimension(100, 200));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("HISTORY");
        Each_main_b.add(jLabel22);
        jLabel22.setBounds(50, 40, 200, 30);

        home.add(Each_main_b);
        Each_main_b.setBounds(785, 0, 330, 100);

        jScrollPane4.setBackground(new java.awt.Color(241, 243, 242));
        jScrollPane4.setBorder(null);
        jScrollPane4.setAutoscrolls(true);

        scroll_innr_base.setMinimumSize(new java.awt.Dimension(100, 800));
        jScrollPane4.setViewportView(scroll_innr_base);

        home.add(jScrollPane4);
        jScrollPane4.setBounds(785, 100, 340, 550);
        jScrollPane4.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane4.getHorizontalScrollBar().setUI(new MyScrollBarUI());
        //UIManager.put("ScrollBarUI", "my.package.MyScrollBarUI");

        jLayeredPane5.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane5.setOpaque(true);
        jLayeredPane5.add(apprice);
        apprice.setBounds(180, 90, 150, 20);

        jLabel24.setBackground(new java.awt.Color(102, 204, 255));
        jLabel24.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("PETROL / GASOLINE PRICE");
        jLayeredPane5.add(jLabel24);
        jLabel24.setBounds(0, 90, 170, 20);

        jLabel25.setText(" per litre in rupees");
        jLayeredPane5.add(jLabel25);
        jLabel25.setBounds(240, 20, 140, 19);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("TODAY'S ");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jLayeredPane5.add(jLabel26);
        jLabel26.setBounds(40, 20, 190, 20);

        jLabel27.setBackground(new java.awt.Color(102, 204, 255));
        jLabel27.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("DIESEL PRICE");
        jLayeredPane5.add(jLabel27);
        jLabel27.setBounds(0, 120, 170, 20);
        jLayeredPane5.add(adprice);
        adprice.setBounds(180, 120, 150, 20);
        jLayeredPane5.add(aoprice);
        aoprice.setBounds(180, 150, 150, 20);

        jLabel30.setBackground(new java.awt.Color(102, 204, 255));
        jLabel30.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText(" OIL PRICE :");
        jLayeredPane5.add(jLabel30);
        jLabel30.setBounds(0, 150, 170, 20);

        jLabel31.setBackground(new java.awt.Color(102, 204, 255));
        jLabel31.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("AREA :");
        jLayeredPane5.add(jLabel31);
        jLabel31.setBounds(0, 60, 170, 20);
        jLayeredPane5.add(aarea);
        aarea.setBounds(180, 60, 200, 20);

        jLabel33.setBackground(new java.awt.Color(102, 204, 255));
        jLabel33.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("LAST PRICE UPDATED :");
        jLayeredPane5.add(jLabel33);
        jLabel33.setBounds(0, 230, 170, 20);
        jLayeredPane5.add(alstpr);
        alstpr.setBounds(180, 230, 150, 20);

        jLabel35.setBackground(new java.awt.Color(102, 204, 255));
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Petrol Bunk / Fuel station pincode");
        jLayeredPane5.add(jLabel35);
        jLabel35.setBounds(0, 260, 250, 20);
        jLayeredPane5.add(apincd);
        apincd.setBounds(160, 280, 170, 20);

        jLabel37.setBackground(new java.awt.Color(102, 204, 255));
        jLabel37.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("STATE :");
        jLayeredPane5.add(jLabel37);
        jLabel37.setBounds(0, 320, 170, 20);
        jLayeredPane5.add(astate);
        astate.setBounds(180, 320, 150, 20);

        jLabel39.setBackground(new java.awt.Color(153, 0, 153));
        jLabel39.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("UPDATE new");
        jLabel39.setOpaque(true);
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel39MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel39MouseEntered(evt);
            }
        });
        jLayeredPane5.add(jLabel39);
        jLabel39.setBounds(100, 370, 150, 30);

        jLabel40.setBackground(new java.awt.Color(0, 153, 153));
        jLabel40.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("ADD  new");
        jLabel40.setOpaque(true);
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
        });
        jLayeredPane5.add(jLabel40);
        jLabel40.setBounds(100, 480, 150, 30);

        select_deta_plz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all places AND SELECTED ON TOP", "Item 2", "Item 3", "Item 4" }));
        select_deta_plz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        select_deta_plz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                select_deta_plzItemStateChanged(evt);
            }
        });
        jLayeredPane5.add(select_deta_plz);
        select_deta_plz.setBounds(40, 560, 310, 30);

        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("on view");
        jLayeredPane5.add(jLabel41);
        jLabel41.setBounds(40, 540, 120, 19);

        jLabel23.setText(":");
        jLayeredPane5.add(jLabel23);
        jLabel23.setBounds(160, 270, 20, 30);

        home.add(jLayeredPane5);
        jLayeredPane5.setBounds(20, 10, 390, 630);

        dddd2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        dddd2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dddd2.setText("show something here");
        home.add(dddd2);
        dddd2.setBounds(600, 280, 170, 15);

        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel51.setText(" amount of petrol");
        home.add(jLabel51);
        jLabel51.setBounds(600, 240, 170, 19);

        ppp1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ppp1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ppp1.setText("show something here");
        home.add(ppp1);
        ppp1.setBounds(600, 260, 170, 15);

        ddd3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        ddd3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ddd3.setText("show something here");
        home.add(ddd3);
        ddd3.setBounds(600, 590, 170, 15);

        ddd1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ddd1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ddd1.setText("show something here");
        home.add(ddd1);
        ddd1.setBounds(600, 570, 170, 15);

        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText(" amount of diesel");
        home.add(jLabel58);
        jLabel58.setBounds(600, 550, 170, 19);

        main_display.add(home);

        ffffabout.setColumns(20);
        ffffabout.setLineWrap(true);
        ffffabout.setRows(5);
        ffffabout.setText(" write someting here about this applicatin");
        ffffabout.setWrapStyleWord(true);
        ffffabout.setOpaque(false);
        ffffabout.setRequestFocusEnabled(false);
        about.add(ffffabout);
        ffffabout.setBounds(20, 80, 930, 510);

        jLabel135.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel135.setText("ABOUT");
        about.add(jLabel135);
        jLabel135.setBounds(30, 15, 190, 40);

        main_display.add(about);

        main1.add(main_display);
        main_display.setBounds(240, 70, 1120, 650);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("navigation");
        main1.add(jLabel1);
        jLabel1.setBounds(20, 310, 130, 20);

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/searchandzoom.png"))); // NOI18N
        main1.add(jLabel82);
        jLabel82.setBounds(195, 240, 30, 30);

        jLabel142.setBackground(new java.awt.Color(0, 0, 0));
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setText("Change Font");
        jLabel142.setOpaque(true);
        jLabel142.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel142MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel142MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel142MouseEntered(evt);
            }
        });
        main1.add(jLabel142);
        jLabel142.setBounds(10, 670, 210, 20);

        jTextField8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 30));
        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        main1.add(jTextField8);
        jTextField8.setBounds(10, 240, 215, 30);

        jLabel146.setBackground(new java.awt.Color(0, 0, 0));
        jLabel146.setForeground(new java.awt.Color(255, 255, 255));
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel146.setText("edit password");
        jLabel146.setOpaque(true);
        jLabel146.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel146MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel146MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel146MouseEntered(evt);
            }
        });
        main1.add(jLabel146);
        jLabel146.setBounds(10, 690, 210, 20);

        main0.add(main1);

        bs_main.add(main0);
        main0.setBounds(0, 0, 1370, 750);

        jDesktopPane1.add(bs_main);

        bk_img.setLayout(new javax.swing.OverlayLayout(bk_img));

        bg_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/MAINBG.jpg"))); // NOI18N
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

    private void menu_word1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word1MouseEntered
        // TODO add your handling code here:
        menu_bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/menu_bg.jpg")));
    }//GEN-LAST:event_menu_word1MouseEntered

    private void menu_word1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word1MouseExited
        // TODO add your handling code here:
        menu_bg1.setIcon(null);
    }//GEN-LAST:event_menu_word1MouseExited

    private void menu_word2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word2MouseEntered
        // TODO add your handling code here:
        menu_bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/menu_bg.jpg")));
    }//GEN-LAST:event_menu_word2MouseEntered

    private void menu_word2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word2MouseExited
        // TODO add your handling code here:
        menu_bg2.setIcon(null);
    }//GEN-LAST:event_menu_word2MouseExited

    private void menu_word3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word3MouseEntered
        // TODO add your handling code here:
        menu_bg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/menu_bg.jpg")));
    }//GEN-LAST:event_menu_word3MouseEntered

    private void menu_word3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word3MouseExited
        // TODO add your handling code here:
        menu_bg3.setIcon(null);
    }//GEN-LAST:event_menu_word3MouseExited

    private void menu_word4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word4MouseEntered
        // TODO add your handling code here:
        menu_bg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/menu_bg.jpg")));
    }//GEN-LAST:event_menu_word4MouseEntered

    private void menu_word4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word4MouseExited
        // TODO add your handling code here:
        menu_bg4.setIcon(null);
    }//GEN-LAST:event_menu_word4MouseExited

    private void menu_word5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word5MouseEntered
        // TODO add your handling code here:
        menu_bg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/menu_bg.jpg")));
    }//GEN-LAST:event_menu_word5MouseEntered

    private void menu_word5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word5MouseExited
        // TODO add your handling code here:
        menu_bg5.setIcon(null);
    }//GEN-LAST:event_menu_word5MouseExited

    private void menu_word1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word1MouseClicked
        // TODO add your handling code here:

        replaceLayer(main_display, home);
        disaplayDeatisAtHome();
        runAtTheStrtCirlcez();
    }//GEN-LAST:event_menu_word1MouseClicked

    private void menu_word2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word2MouseClicked
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Calendar now = Calendar.getInstance();
        try {
            Date date = new Date();
            Calendar f = Calendar.getInstance();

            join_date.setMaxDate(Calendar.getInstance());
            out_date1.setMinDate(Calendar.getInstance());
            f.add(Calendar.WEEK_OF_MONTH, -1);
            f.add(Calendar.YEAR, -18);
            dob.setSelectedDate(f);
            dob.setMaxDate(f);

        } catch (Exception e) {
        }

        replaceLayer(main_display, staff);

        replaceLayer(innr_main_menu0, innr_menu_main_a01);
    }//GEN-LAST:event_menu_word2MouseClicked

    private void innr_menu_a1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a1MouseEntered
        // TODO add your handling code here:
        inn_menu_bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/innr_menu_one.jpg"))); // NOI18N
    }//GEN-LAST:event_innr_menu_a1MouseEntered

    private void innr_menu_a1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a1MouseExited
        // TODO add your handling code here:
        inn_menu_bg1.setIcon(null); // NOI18N
    }//GEN-LAST:event_innr_menu_a1MouseExited

    private void innr_menu_a2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a2MouseEntered
        // TODO add your handling code here:
        inn_menu_bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/innr_menu_one.jpg"))); // NOI18N
    }//GEN-LAST:event_innr_menu_a2MouseEntered

    private void innr_menu_a2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a2MouseExited
        // TODO add your handling code here:
        inn_menu_bg2.setIcon(null); // NOI18N
    }//GEN-LAST:event_innr_menu_a2MouseExited

    private void innr_menu_a3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a3MouseEntered
        // TODO add your handling code here:
        inn_menu_bg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/innr_menu_one.jpg"))); // NOI18N
    }//GEN-LAST:event_innr_menu_a3MouseEntered

    private void innr_menu_a3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a3MouseExited
        // TODO add your handling code here:
        inn_menu_bg3.setIcon(null); // NOI18N
    }//GEN-LAST:event_innr_menu_a3MouseExited

    private void innr_menu_a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a1MouseClicked
        // TODO add your handling code here:
        replaceLayer(innr_main_menu0, innr_menu_main_a01);
    }//GEN-LAST:event_innr_menu_a1MouseClicked

    private void innr_menu_a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a2MouseClicked
        // TODO add your handling code here:
        
        try {
        dothisForthisClik();
        replaceLayer(innr_main_menu0, innr_menu_main_a02);
        
            
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_innr_menu_a2MouseClicked

    
    
    void dothisForthisClik() {
         
        replaceLayer(innr_menu_main_a02, search_one);

    }
    private void innr_menu_a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_innr_menu_a3MouseClicked
        // TODO add your handling code here:
        
      
        Calendar now = Calendar.getInstance();
        try {
            Date date = new Date();
            Calendar f = Calendar.getInstance();

            join_date2.setMaxDate(Calendar.getInstance());
            out_date2.setMinDate(Calendar.getInstance());
            f.add(Calendar.WEEK_OF_MONTH, -1);
            f.add(Calendar.YEAR, -18);
            dob2.setMaxDate(f);

        } catch (Exception e) {
        }
        
        //
        
        
        
        dob2.setDateFormat(sdfhz);
        join_date2.setDateFormat(sdfhz);
        out_date2.setDateFormat(sdfhz);
        
        
        addEmployeesToComboBox();
        
        
        replaceLayer(innr_main_menu0, innr_menu_main_a03);
    }//GEN-LAST:event_innr_menu_a3MouseClicked

    
    
       
      void addEmployeesToComboBox()
      {
          all_emplo.removeAllItems();          
         //getid.removeAllItems();  
          String name;
                 String query = "SELECT empid FROM employee  WHERE satus='employee'";// WHERE route_id='long'";
       MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
         System.out.println(query);
          all_emplo.addItem("select employee id");
       //   getid.addItem("select employee id");
        try {

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

              name = mysqlitem.rs.getString("empid");

                all_emplo.addItem(name);
              //  getid.addItem(name);
//      busid2.addItem(name);
//      busid3.addItem(name);
                //  busid8.addItem(name);

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
   //         System.out.println("success");
        } catch (Exception e1) {
            System.out.println("Error 1"+e1);

        }
      }
     
    
    
    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        // TODO add your handling code here:
        jLabel21.setBackground(new java.awt.Color(51, 0, 204));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        // TODO add your handling code here:
        jLabel21.setBackground(new java.awt.Color(51, 51, 255));
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
setAllInTheEmplyeeNull () ;
    }//GEN-LAST:event_jLabel21MouseClicked

    
    void setAllInTheEmplyeeNull () {
        

        user_name1.setText("");
        fname.setText("");
        lname.setText("");
        age.setText("0");
        praddr.setText("");
        email.setText("");
        mobile.setText("");
        peaddr.setText("");
        salary.setText("");
        Telephone.setText("");
        path.setText("");
        image_h.setIcon(null);  
        
      
        
        
        Calendar cou = Calendar.getInstance();
        cou.add(Calendar.DAY_OF_WEEK, -1);
        join_date.setSelectedDate  (cou);
        cou.add(Calendar.YEAR, -19);
        dob.setSelectedDate(cou);
        
        out_date1.setSelectedDate(Calendar.getInstance());
        jCheckBox1.setSelected(false);
    }
    
    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
        jLabel20.setBackground(new java.awt.Color(51, 0, 204));
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        // TODO add your handling code here:
        jLabel20.setBackground(new java.awt.Color(51, 51, 255));
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:

        submitButonAction();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        
        if(praddr.getText().length() < 1)
            jCheckBox1.setSelected(false);
        if (jCheckBox1.isSelected()) {
            peaddr.setText(praddr.getText());
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void v2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v2ActionPerformed

    private void v1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v1ActionPerformed

    private void dobOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dobOnCommit
        // TODO add your handling code here:

        try {

            Calendar fdob = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            fdob.setTime(sdf.parse(dob.getText()));// all done

            Calendar now = Calendar.getInstance();
            int year1 = now.get(Calendar.YEAR);
            int year2 = fdob.get(Calendar.YEAR);
            int age_out = year1 - year2;

            age.setText("" + age_out);
        } catch (Exception e) {
            //       jok.dispalyEroorMessage("Please fill this field", 620, 400, 5000 );

            jok.setErrorForTextField("Please fill this field", this.dob, this, 5000);
            return;
        }
    }//GEN-LAST:event_dobOnCommit

    private void dobOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dobOnSelectionChange
        // TODO add your handling code here:
        System.err.println("fffffffffff");

        try {

            Calendar fdob = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            fdob.setTime(sdf.parse(dob.getText()));// all done

            Calendar now = Calendar.getInstance();
            int year1 = now.get(Calendar.YEAR);
            int year2 = fdob.get(Calendar.YEAR);
            int age_out = year1 - year2;

            age.setText("" + age_out);
        } catch (Exception e) {
            //    jok.dispalyEroorMessage("Please fill this field", 620, 400, 5000 );

            jok.setErrorForTextField("Please fill this field", this.dob, this, 5000);
            return;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_dobOnSelectionChange

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c2ActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    private void ageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageMouseClicked
        // TODO add your handling code here:
        System.err.println("fffffffffff");

        try {

            Calendar fdob = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            fdob.setTime(sdf.parse(dob2.getText()));// all done

            Calendar now = Calendar.getInstance();
            int year1 = now.get(Calendar.YEAR);
            int year2 = fdob.get(Calendar.YEAR);
            int age_out = year1 - year2;

            age2.setText("" + age_out);
        } catch (Exception e) {
            //jok.dispalyEroorMessage("Please fill this field", 620, 400, 5000 );

            jok.setErrorForTextField("Please fill this field", dob2, this, 5000);
            return;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ageMouseClicked

    private void mobileFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileFocusLost
        // TODO add your handling code here:
        if (mobile.getText().length() > 0) {

            String geMobno = mobile.getText();
            //matches 10-digit numbers only
            String regexStr = "^[0-9]{10}$";
            if (!geMobno.matches(regexStr)) {
                //  jok.dispalyEroorMessage("Please insert a valid mobile number", 620, 700, 5000 );

                jok.setErrorForTextField("lease insert a valid mobile number", mobile, this, 5000);
                return;
            }

        }
    }//GEN-LAST:event_mobileFocusLost

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:

        if (email.getText().length() > 0) {
            String eMailVa
                    = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            String eMaiL = email.getText();
            if (!eMaiL.matches(eMailVa)) {
//     jok.dispalyEroorMessage("Please insert a valid email id", 620, 650, 5000 );

                jok.setErrorForTextField("Please insert a valid email id", email, this, 5000);
                return;
            }

        }
    }//GEN-LAST:event_emailFocusLost

    private void mobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileKeyPressed

    private void mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_mobileKeyTyped

    private void TelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelephoneKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_TelephoneKeyTyped

    private void salaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_salaryKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            selectImgOfEmployee();
        } catch (Exception ex) {
            Logger.getLogger(Main_.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        System.err.println("http://www.petroldieselprice.com/petrol-diesel-lpg-cng-fuel-oil-price/Pandalam-(Pathanamthitta)/Adur/Pathanamthitta/Kerala/689501");
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseExited
        // TODO add your handling code here:
        jLabel39.setBackground(new java.awt.Color(153, 0, 153));
    }//GEN-LAST:event_jLabel39MouseExited

    private void jLabel39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseEntered
        // TODO add your handling code here:
        jLabel39.setBackground(new java.awt.Color(204, 0, 153));
    }//GEN-LAST:event_jLabel39MouseEntered

    
    
    
    void doPriceThis() {
        petrol.setText(apprice.getText());
        diesel.setText(adprice.getText());
    }
    
    
    
    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
      
        
        
area1.setText(aarea.getText());
pprice1.setText(apprice.getText());
dprice1.setText(adprice.getText());
oprice1.setText(aoprice.getText());
pincd1.setText(apincd.getText());
state1.setText(astate.getText());
        
boolean b = false;

  try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = " SELECT * FROM area WHERE area = '"+aarea.getText()+"'";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                
        to_date1.setText(mysqlitem.rs.getString("date"));
        hidden_id.setText(mysqlitem.rs.getString("id"));
                
        b = true;

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }




        if (!b) {
            return;
        }
        
        update_data.setLocationRelativeTo(null);
        update_data.show();
        // update ne w value here the same add view dispalyd byt the defut locatuion is tgsis palz
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
        
        Date d = new Date();
        to_date.setText(sdfhz.format(d.getTime()));
        
        add_new.setLocationRelativeTo(null);
        add_new.show();
    }//GEN-LAST:event_jLabel40MouseClicked

    
    
    void setAtTheFirstTop( ) {
        
          try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = " SELECT * FROM area WHERE selected = '1'";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                String fff = mysqlitem.rs.getString("area");
                
        
            updateNewDisplay (fff);
            select_deta_plz.setSelectedItem(fff);

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }
    }
    
    
    
    
         void addareaToComboBox()
      {
          select_deta_plz.removeAllItems();          
         //getid.removeAllItems();  
          String name;
                 String query = "SELECT * FROM area WHERE valid = 1 ";// WHERE route_id='long'";
       MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
         System.out.println(query);
          select_deta_plz.addItem("select top priority");
       //   getid.addItem("select employee id");
        try {

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

              name = mysqlitem.rs.getString("area");

                select_deta_plz.addItem(name);
              //  getid.addItem(name);
//      busid2.addItem(name);
//      busid3.addItem(name);
                //  busid8.addItem(name);

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
   //         System.out.println("success");
        } catch (Exception e1) {
            System.out.println("Error 1"+e1);

        }
      }
     
         
         
    
         
         void empuntMesureShowsD (  int d , String val) {
             
             System.err.println(" -------------> "+ d);
             
             dlitr1.setText(val);
             
             d = 100 - d;
              show_mesu1 = (d * 170)/100;
             show_mesu1 = show_mesu1+ -80;
           
            
              Thread ts = new Thread(
                new Runnable() {
            @Override
            public void run() {
                
                 int cirrentlo = fr1.getY();
             int incr = 0;
             if (show_mesu1 > cirrentlo) {
                 incr = 1;
             } 
             if (show_mesu1 < cirrentlo) {
                 incr = -1;
             }
              if (show_mesu1 == cirrentlo) {
                return;
             }
             
                
                for( int i = cirrentlo ; i!=show_mesu1; i+= incr){
                    //System.err.println("e"+i);
                    
                       fr1.setLocation(fr1.getX(), i);
             
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
        );
                
        Timer timer = new Timer(5000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                
                 ts.stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        ts.start();
             
             
         }
           void empuntMesureShowsP (  int p, String val) {
             
             
             plitr1.setText(val);
             
             
             p = 100 - p;
              show_mesu2 = (p * 170)/100;
             show_mesu2 = show_mesu2+ -55;
           
            
              Thread ts = new Thread(
                new Runnable() {
            @Override
            public void run() {
                
                 int cirrentlo = fr1.getY();
             int incr = 0;
             if (show_mesu2 > cirrentlo) {
                 incr = 1;
             } 
             if (show_mesu2 < cirrentlo) {
                 incr = -1;
             }
              if (show_mesu2 == cirrentlo) {
                return;
             }
             
                
                for( int i = cirrentlo ; i!=show_mesu2; i+= incr){
                    //System.err.println("e"+i);
                    
                       fr2.setLocation(fr2.getX(), i);
             
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
        );
                
        Timer timer = new Timer(5000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                
                 ts.stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        ts.start();
             
             
         }
         
         
         
         
    
    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        // TODO add your handling code here:
        jLabel40.setBackground(new java.awt.Color(0, 153, 153));
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        // TODO add your handling code here:
        jLabel40.setBackground(new java.awt.Color(0, 153, 204));
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateActionPerformed

    private void ppriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppriceActionPerformed

    private void areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaActionPerformed

    private void dpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpriceActionPerformed

    private void opriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opriceActionPerformed

    private void to_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_to_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_to_dateActionPerformed

    private void pincdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pincdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pincdActionPerformed
 
    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
        // TODO add your handling code here:
        jLabel45.setBackground(new java.awt.Color(51, 153, 0));
    }//GEN-LAST:event_jLabel45MouseEntered

    private void jLabel45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseExited
        // TODO add your handling code here:
        jLabel45.setBackground(new java.awt.Color(51, 102, 0));
    }//GEN-LAST:event_jLabel45MouseExited

    private void jLabel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseEntered
        // TODO add your handling code here:
        jLabel43.setBackground(new java.awt.Color(153, 51, 0));
    }//GEN-LAST:event_jLabel43MouseEntered

    private void jLabel43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseExited
        // TODO add your handling code here:
        jLabel43.setBackground(new java.awt.Color(102, 51, 0));
    }//GEN-LAST:event_jLabel43MouseExited

    private void menu_word3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word3MouseClicked
        // TODO add your handling code here:
        actionForBilling();
        
        replaceLayer(main_forStk, IMPORTED_STOCK);
        replaceLayer(main_display, stock);

    }//GEN-LAST:event_menu_word3MouseClicked

    
    void actionForBilling() {
        
        float amo_p = 0;
        float amo_d = 0;
        
        float amo_pa = 0;
        float amo_da = 0;
        
        
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM fuel ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
                   if (mysqlitem.rs.getString("fuel_name").equals( "petrol")) {
                       
 
  amo_p = mysqlitem.rs.getFloat("availability");
  amo_pa = mysqlitem.rs.getFloat("capacity");
 
 pup.setText(""+amo_pa);
 
                   }
        
  if (mysqlitem.rs.getString("fuel_name").equals("diesel")) {
                       
 
         amo_d = mysqlitem.rs.getFloat("availability");
         amo_da = mysqlitem.rs.getFloat("capacity");
 dup.setText(""+amo_da);
 
 
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
        
 float a = amo_d;
 float bv = amo_p;
 
        System.err.println("     amount dsplay =========="+amo_d+" - " +amo_da +"  ====== \n" + amo_p+" - "+amo_pa);
       
        try {
            
           amo_d = amo_d * 100;
           amo_da =   amo_d/amo_da;
        } catch (Exception e) {
        }
 
        try { 
           amo_p = amo_p * 100;
           amo_pa = amo_p/amo_pa;
        } catch (Exception e) {
        }
 
        System.err.println("     amount dsplay =========="+amo_d+" - " +amo_da +"  ====== \n" + amo_p+" - "+amo_pa);
        
        
 empuntMesureShowsD (  (int)amo_da , a+"") ;
 
 empuntMesureShowsP (  (int)amo_pa  , bv+"") ;
 
 
 
    }
    
    
    
    
    
    
    private void jLabel59MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseExited
        // TODO add your handling code here:
        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel59MouseExited

    private void jLabel60MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseExited
        // TODO add your handling code here:
        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel60MouseExited

    private void jLabel61MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseExited
        // TODO add your handling code here:
        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel61MouseExited

    private void jLabel59MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseEntered
        // TODO add your handling code here:
        jLabel59.setBackground(new java.awt.Color(204, 204, 204));
        
    }//GEN-LAST:event_jLabel59MouseEntered

    private void jLabel60MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseEntered
        // TODO add your handling code here:
        jLabel60.setBackground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jLabel60MouseEntered

    private void jLabel61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseEntered
        // TODO add your handling code here:
        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jLabel61MouseEntered

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
        // TODO add your handling code here:
        avilablStkAction() ;
        replaceLayer(main_forStk, AVAILABLE_STOCK);
        showAllInThisClickThis();
        
    }//GEN-LAST:event_jLabel59MouseClicked

    
    
    void showAllInThisClickThis () {
        jTable2.setOpaque(false);
        ((DefaultTableCellRenderer) jTable2.getDefaultRenderer(Object.class)).setOpaque(false);
        
        jScrollPane8.setOpaque(false);
        jScrollPane8.getViewport().setOpaque(false);
        
        jTable2.setShowGrid(false);

        addDataToTableThis();//................................................................................................

        // TODO add your handling code here:
    }                                   
  void addDataToTableThis() {

        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        try {

            String query = "SELECT * FROM `stock_import` ORDER BY `stock_import`.`date` DESC ";// WHERE userid='"+tmpempid+"'";

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            System.out.println(query);

            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            jTable2.setModel(DbUtils.resultSetToTableModel(mysqlitem.rs));                                                                                    //xxxxxxxxxxxxxxx

            resizeColumnWidth(jTable2);
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
            System.out.println("success");
        } catch (Exception ob) {
            System.out.println(ob);
        }

      //  employeeId();
      
      
      
      
      int rowCont = jTable2.getRowCount();
      
      for (int i = 0; i < rowCont; i++) {
          
          
          int val = (int) jTable2.getValueAt(i, 0);
          
          if (val == 1) {
              jTable2.setValueAt("petrol", i, 0);
          }
           if (val == 2) {
              jTable2.setValueAt("diesel", i, 0);
          }
          
      }

    }
  
  
    void avilablStkAction() {
        
        
        
           
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM fuel ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
                   if (mysqlitem.rs.getString("fuel_name").equals( "petrol")) {
                       
 
                       float a = mysqlitem.rs.getFloat("capacity");
                       float b = mysqlitem.rs.getFloat("availability");
  s3d1.setText("capacity : "+a + "  Litres ");
  s3d2.setText("availability : "+b+ "  Litres ");
 float tyuo = b * 100 /a;
        String fat1 = new DecimalFormat("##.##").format(tyuo);
  s3d3.setText(" "+fat1+" %");
 
 
                   }
        
  if (mysqlitem.rs.getString("fuel_name").equals("diesel")) {
                       
      float a = mysqlitem.rs.getFloat("capacity");
                       float b = mysqlitem.rs.getFloat("availability");
  s3d6.setText("capacity : "+a+ "  Litres ");
  s3d5.setText("availability : "+b+ "  Litres ");
 
  
 float tyuo = b * 100 /a;
        String fat1 = new DecimalFormat("##.##").format(tyuo);
  s3d4.setText(" "+fat1 +" %");
 
  
 
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
    
    public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 50; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
        columnModel.getColumn(column).setPreferredWidth(width);
    }
}
    
    
    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        
        replaceLayer(main_forStk, IMPORTED_STOCK);
    }//GEN-LAST:event_jLabel60MouseClicked

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        // TODO add your handling code here:
        showDate.setDateFormat(sdfhz);
        showDate.setMaxDate(Calendar.getInstance());
        
        try {
            
         aboveClick( showDate.getText()) ;
         
        replaceLayer(main_forStk, SALES_INFO);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel61MouseClicked

    
    
    
    void aboveClick(String today_date) {
        
        
          try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = " SELECT * FROM area WHERE selected = '1'";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                darea.setText(mysqlitem.rs.getString("area"));
                area_id_h.setText(""+mysqlitem.rs.getInt("id"));
                
        
                

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
          
          
          float total_p_i = 0, total_p_p = 0, total_d_i = 0, total_d_p = 0;
          
          
          
              try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = " SELECT * FROM `stock_import` WHERE DATE(date) = '"+today_date+"'";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                
                
                if (mysqlitem.rs.getInt("fuel_id") == 1) {
                    total_p_i += mysqlitem.rs.getInt("amount");
                    total_p_p += mysqlitem.rs.getInt("total_price");
                    
                }
                
                
                if (mysqlitem.rs.getInt("fuel_id") == 2) {
                    
                    total_d_i += mysqlitem.rs.getInt("amount");
                    total_d_p += mysqlitem.rs.getInt("total_price");
                }
        
                

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        
        pimpto.setText(""+total_p_i);
        pimpto1.setText(total_p_p+"");
        
        
        dtotl.setText(""+total_d_i);
        dtotl1.setText(total_d_p+"");
        
        
        
        
        total_p_i = 0; total_p_p = 0; total_d_i = 0; total_d_p = 0;
        
        
              try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        String query = " SELECT * FROM `billing` WHERE DATE(date) = '"+today_date+"'";
              System.err.println(query);
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                
                
                if (mysqlitem.rs.getInt("fuel_id") == 1) {
                    total_p_i += mysqlitem.rs.getInt("amount");
                    total_p_p += mysqlitem.rs.getInt("total_price");
                    
                }
                
                
                if (mysqlitem.rs.getInt("fuel_id") == 2) {
                    
                    total_d_i += mysqlitem.rs.getInt("amount");
                    total_d_p += mysqlitem.rs.getInt("total_price");
                }
        
                

            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        
        
            
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        
        pseeltot.setText(""+total_p_i);
        pseeltot1.setText(total_p_p+"");
        
        
        dtotals.setText(""+total_d_i);
        dtotals1.setText(total_d_p+"");
        
        
        
        
        
        
        
        
        
        String date  = sdfhz.format(new Date());
        
        
        try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
      
        
           
           String query = "INSERT INTO `transaction` (`area_id`, `fuel_id`, `import_amount`, `import_price`, `selling_amount`, `selling_price`, `to_day`) VALUES"
                   + "("+area_id_h.getText()+", '1', "+pimpto.getText()+", "+pimpto1.getText()+", "+pseeltot.getText()+", "+pseeltot1.getText()+", '"+date+"' ) ON DUPLICATE KEY UPDATE"
                   + " `import_amount`= "+pimpto.getText()+" , `import_price` =  "+pimpto1.getText()+" , `selling_amount` = "+pseeltot.getText()+" , `selling_price` = "+pseeltot1.getText() ;
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
         //   JOptionPane.showMessageDialog(this, new String("successfully updated"));
          //  updateNewDisplay ( String area);
            
          
          


mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
         
        
        
        
        
        /*8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888*/
                
        
        
        
        
        String dates  = sdfhz.format(new Date());
        
        
         try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
      
        
           
           String query = "INSERT INTO `transaction` (`area_id`, `fuel_id`, `import_amount`, `import_price`, `selling_amount`, `selling_price`, `to_day`) VALUES"
                   + "("+area_id_h.getText()+", '2', "+dtotl.getText()+", "+dtotl1.getText()+", "+dtotals.getText()+", "+dtotals1.getText()+", '"+dates+"' ) ON DUPLICATE KEY UPDATE"
                   + " `import_amount`= "+dtotl.getText()+" , `import_price` =  "+dtotl1.getText()+" , `selling_amount` = "+dtotals.getText()+" , `selling_price` = "+dtotals1.getText() ;
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
         //   JOptionPane.showMessageDialog(this, new String("successfully updated"));
          //  updateNewDisplay ( String area);
            
          
          


mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
         
        
        
        
        
        
        
        
        
        
        showAllInThisClickThis3 () ;
         showAllInThisClickThis4();
    }
    
     void showAllInThisClickThis3 () {
        jTable3.setOpaque(false);
        ((DefaultTableCellRenderer) jTable3.getDefaultRenderer(Object.class)).setOpaque(false);

        jScrollPane9.setOpaque(false);
        jScrollPane9.getViewport().setOpaque(false);

        jTable3.setShowGrid(false);

        addDataToTableThis3();//................................................................................................

        // TODO add your handling code here:
    }                                   
  void addDataToTableThis3() {

        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        try {

            String query = "SELECT fuel_id AS fuel, amount, total_price AS price, TIME(date) AS time,"
                    + " employee_id AS 'employee id' FROM `billing` WHERE DATE(date) = CURDATE() ORDER BY `billing`.`date` DESC ";// WHERE userid='"+tmpempid+"'";

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            System.out.println(query);

            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            jTable3.setModel(DbUtils.resultSetToTableModel(mysqlitem.rs));                                                                                    //xxxxxxxxxxxxxxx

            resizeColumnWidth(jTable3);
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
            System.out.println("success");
        } catch (Exception ob) {
            System.out.println(ob);
        }

      //  employeeId();
      
      
      
      
      int rowCont = jTable3.getRowCount();
      
      for (int i = 0; i < rowCont; i++) {
          
          
          int val = (int) jTable3.getValueAt(i, 0);
          
          if (val == 1) {
              jTable3.setValueAt("petrol", i, 0);
          }
           if (val == 2) {
              jTable3.setValueAt("diesel", i, 0);
          }
          
      }

    }
  
  
  
  
  
  
  
  
   
     void showAllInThisClickThis4() {
        jTable5.setOpaque(false);
        ((DefaultTableCellRenderer) jTable5.getDefaultRenderer(Object.class)).setOpaque(false);

        jScrollPane11.setOpaque(false);
        jScrollPane11.getViewport().setOpaque(false);

        jTable5.setShowGrid(false);

        addDataToTableThis4();//................................................................................................

        // TODO add your handling code here:
    }                                   
  void addDataToTableThis4() {

        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        try {

            String query = "SELECT fuel_id AS fuel, import_amount AS 'import amount' , import_price AS 'import price ', "
                    + "selling_amount AS 'selling amount', selling_price AS 'selling price' , to_day AS date FROM `transaction` ORDER BY `transaction`.`date` DESC ";// WHERE userid='"+tmpempid+"'";

            
            
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            System.out.println(query);

            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            jTable5.setModel(DbUtils.resultSetToTableModel(mysqlitem.rs));                                                                                    //xxxxxxxxxxxxxxx

            resizeColumnWidth(jTable5);
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
            System.out.println("success");
        } catch (Exception ob) {
            System.out.println(ob);
        }

      //  employeeId();
      
      
      
      
      int rowCont = jTable5.getRowCount();
      
      for (int i = 0; i < rowCont; i++) {
          
          
          int val = (int) jTable5.getValueAt(i, 0);
          
          if (val == 1) {
              jTable5.setValueAt("petrol", i, 0);
          }
           if (val == 2) {
              jTable5.setValueAt("diesel", i, 0);
          }
          
      }

    }
  
    
    private void menu_word5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_word5MouseClicked
        // TODO add your handling code here:
        
        replaceLayer(main_display, about);
    }//GEN-LAST:event_menu_word5MouseClicked

    private void user_name1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_name1MouseClicked
        // TODO add your handling code here:
        user_idMouseClicked(evt);
    }//GEN-LAST:event_user_name1MouseClicked

    private void searchfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfieldKeyTyped

    private void searchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyReleased
        // TODO add your handling code here:
        doActionForSowSearch(searchfield.getText());
    }//GEN-LAST:event_searchfieldKeyReleased

    private void jLabel78MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseEntered
        // TODO add your handling code here:
       jLabel78.setBackground(new java.awt.Color(0, 153, 255));
    }//GEN-LAST:event_jLabel78MouseEntered

    private void jLabel78MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseExited
        // TODO add your handling code here:
        
jLabel78.setBackground(new java.awt.Color(0, 153, 204));

    }//GEN-LAST:event_jLabel78MouseExited

    private void jLabel79MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseEntered
        // TODO add your handling code here:
        jLabel79.setBackground(new java.awt.Color(204, 0, 204));
    }//GEN-LAST:event_jLabel79MouseEntered

    private void jLabel79MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseExited
        // TODO add your handling code here:
        jLabel79.setBackground(new java.awt.Color(153, 0, 153));
    }//GEN-LAST:event_jLabel79MouseExited

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        // TODO add your handling code here:
        
        jLabel79.setBackground(new java.awt.Color(153, 0, 153));
          dothisForthisClik();
          searchfield.setText("");
          
           show_reslut_clicabl.removeAll();
          show_reslut_clicabl.repaint();
           show_reslut_clicabl.revalidate();
    }//GEN-LAST:event_jLabel79MouseClicked

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        // TODO add your handling code here:
           replaceLayer(innr_menu_main_a02, show_all);
          searchfield.setText("");
           
jLabel78.setBackground(new java.awt.Color(0, 153, 204));
showAllInThisClick ();

    }//GEN-LAST:event_jLabel78MouseClicked

    private void jLabel80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseClicked
        // TODO add your handling code here:
        
          
        jLabel80.setBackground(new java.awt.Color(153, 0, 153));
          dothisForthisClik();
          searchfield.setText("");
          
           show_reslut_clicabl.removeAll();
          show_reslut_clicabl.repaint();
           show_reslut_clicabl.revalidate();
    }//GEN-LAST:event_jLabel80MouseClicked

    private void jLabel80MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseExited
        // TODO add your handling code here:
        jLabel80.setBackground(new java.awt.Color(153, 0, 153));
    }//GEN-LAST:event_jLabel80MouseExited

    private void jLabel80MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseEntered
                jLabel80.setBackground(new java.awt.Color(204, 0, 204));
    }//GEN-LAST:event_jLabel80MouseEntered

    private void jLabel81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
           replaceLayer(innr_menu_main_a02, show_all);
          searchfield.setText("");
           
jLabel81.setBackground(new java.awt.Color(0, 153, 204));
showAllInThisClick ();
    }//GEN-LAST:event_jLabel81MouseClicked

    private void jLabel81MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseExited
        // TODO add your handling code here:
                
jLabel81.setBackground(new java.awt.Color(0, 153, 204));
    }//GEN-LAST:event_jLabel81MouseExited

    private void jLabel81MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseEntered
        // TODO add your handling code here:
       jLabel81.setBackground(new java.awt.Color(0, 153, 255));
    }//GEN-LAST:event_jLabel81MouseEntered

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
        if (jTextField8.getText().length() < 2) {
            return;
        }
          jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

          main1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

      
        replaceLayer(main_display, staff);

        replaceLayer(innr_main_menu0, innr_menu_main_a02);
        
        replaceLayer(innr_menu_main_a02, search_one);
        
        searchfield.setText(jTextField8.getText());
        jTextField8.setText("");
        doActionForSowSearch(searchfield.getText());
        
        
        
jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
main1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        
        
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void age2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_age2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_age2MouseClicked

    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c3ActionPerformed

    private void c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c4ActionPerformed

    private void dob2OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dob2OnSelectionChange



        // TODO add your handling code here:
        
        
        
        
      System.err.println("fffffffffff");

        try {

            Calendar fdob = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            fdob.setTime(sdf.parse(dob2.getText()));// all done

            Calendar now = Calendar.getInstance();
            int year1 = now.get(Calendar.YEAR);
            int year2 = fdob.get(Calendar.YEAR);
            int age_out = year1 - year2;

            age2.setText("" + age_out);
        } catch (Exception e) {
            //    jok.dispalyEroorMessage("Please fill this field", 620, 400, 5000 );

            jok.setErrorForTextField("Please fill this field", this.dob2, this, 5000);
            return;
        }
    }//GEN-LAST:event_dob2OnSelectionChange

    private void dob2OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dob2OnCommit
        // TODO add your handling code here:
        
        
  try {

            Calendar fdob = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            fdob.setTime(sdf.parse(dob2.getText()));// all done

            Calendar now = Calendar.getInstance();
            int year1 = now.get(Calendar.YEAR);
            int year2 = fdob.get(Calendar.YEAR);
            int age_out = year1 - year2;

            age2.setText("" + age_out);
        } catch (Exception e) {
            //       jok.dispalyEroorMessage("Please fill this field", 620, 400, 5000 );

            jok.setErrorForTextField("Please fill this field", this.dob2, this, 5000);
            return;
        }



    }//GEN-LAST:event_dob2OnCommit

    private void salary2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salary2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_salary2KeyTyped

    private void v3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v3ActionPerformed

    private void v4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v4ActionPerformed

    private void mobile2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobile2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile2FocusLost

    private void mobile2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobile2KeyTyped
        // TODO add your handling code here:
              char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_mobile2KeyTyped

    private void mobile2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobile2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile2KeyPressed

    private void email2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_email2FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        
        try {
            //JFileChooser chooser =  new javax.swing.JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();
            path1.setText(filename);
            File inputFile = new File(filename);
            BufferedImage inputImage = ImageIO.read(inputFile);

            if (!((inputImage.getWidth() >= image_h2.getWidth()) && (inputImage.getHeight() >= image_h2.getHeight()))) {
                JOptionPane.showMessageDialog(this, new String("not a valid image "));
                return;
            }

            BufferedImage outputImage = resizeImage(inputImage, inputImage.getWidth(), inputImage.getHeight(), image_h2.getWidth(), image_h2.getHeight());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String j = String.valueOf(inputImage.getType());
            ImageIO.write(outputImage, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            outputimg = imageInByte;
            baos.close();
            ImageIcon format = null;
            format = new ImageIcon(imageInByte);
            image_h2.setIcon(format);

        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        
        
     // TODO add your handling code here:
        
        if(praddr2.getText().length() < 1)
            jCheckBox2.setSelected(false);
        if (jCheckBox2.isSelected()) {
            peaddr2.setText(praddr2.getText());
        }



        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void Telephone2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Telephone2KeyTyped
        // TODO add your handling code here:
              char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_Telephone2KeyTyped

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        // TODO add your handling code here:
        updateButonAction();
        
    }//GEN-LAST:event_jLabel99MouseClicked

    
    
    
      void updateButonAction() {

        int xcptn_chk = 1;
        ///////today
        ////////////////

        /////////////////////////////////////////////////////////////// submitButonAction
        String stringsdate = "";
        String morfv = "";
        //String dob_s = "";
        String enddate = "";
        String dobout = "";
        int todayint = 0;
        int dobint = 0;
        int tmp = 0;
        
        String emailL = "NULL";
        String land = "NULL";
        
            String dorn = "";
        Boolean bv = true;
        try {

            
            
            
            // fdob.add(Calendar.YEAR,56);
            
           //  fdob.add(Calendar.YEAR,-18); 
             
            
           
                 
             Calendar sddate1 = Calendar.getInstance();
             sddate1.setTime(sdfhz.parse(join_date2.getText()));
              
             Calendar sddate2 = Calendar.getInstance();
             sddate2.setTime(sdfhz.parse(out_date2.getText()));
             
           
             sddate1.add(Calendar.MONTH,1); 
             
            
             
            
             
            
            
            
            

            if (c3.isSelected() == true) {
                System.out.println("true");
                morfv = "M";
            }
            if (c4.isSelected() == true) {
                System.out.println("flse");
                morfv = "F";
            }


            if (v3.isSelected() == true) {
                dorn = "1";
            }
            if (v4.isSelected() == true) {
                dorn = "0";
            }

            // jok.setErrorForTextField("String message", fname, this, 5000);
//            if (user_name1.getText().length() == 0) {
//
//                //jok.dispalyEroorMessage("Please fill this field", 620, 250, 5000 );
//                jok.setErrorForTextField("Please fill this field", user_name1, this, 5000);
//                bv = false;
//
//            }
            /* else */ if (fname1.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 300, 5000 );
                jok.setErrorForTextField("Please fill this field", fname1, this, 5000);
                bv = false;

            }
            /* else */ if (lname1.getText().length() == 0) {

                // jok.dispalyEroorMessage("Please fill this field", 620, 350, 5000 );
                jok.setErrorForTextField("Please fill this field", lname1, this, 5000);
                bv = false;

            }
            /* else */ if (age2.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 400, 5000 );
                jok.setErrorForTextField("Please fill this field", this.dob2, this, 5000);
                bv = false;

            }
            /* else */ if (morfv.length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 500, 5000 );
                jok.setErrorForTextField("Please fill this field", jLayeredPane7, this, 5000);
                bv = false;

            }
            /* else */ if (praddr2.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 560, 5000 );
                jok.setErrorForTextField("Please fill this field", jScrollPane6, this, 5000);
                bv = false;

            }
            /* else */ if (peaddr2.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 980, 500, 5000 );
                jok.setErrorForTextField("Please fill this field", jScrollPane7, this, 5000);
                bv = false;

            }
            /* else */ if (email2.getText().length() == 0) {
//  jok.dispalyEroorMessage("Please fill this field", 620, 650, 5000 );

             //   jok.setErrorForTextField("Please fill this field", email2, this, 5000);
               // bv = false;

            } else 
                emailL = "'"+email2.getText()+"'";
            
            /* else */ if (mobile2.getText().length() == 0) {
//  jok.dispalyEroorMessage("Please fill this field", 620, 700, 5000 );

                jok.setErrorForTextField("Please fill this field", mobile2, this, 5000);
                bv = false;

            }
            /* else */ if (Telephone2.getText().length() == 0) {

                //jok.dispalyEroorMessage("Please fill this field", 980, 700, 5000 );
               // jok.setErrorForTextField("Please fill this field", Telephone2, this, 5000);
             //   bv = false;

            } else 
                land = Telephone2.getText();
            /* else */ if (dorn.length() == 0) {

//    jok.dispalyEroorMessage("Please select one", 980, 350, 5000 );
                jok.setErrorForTextField("Please select one", jLayeredPane8, this, 5000);
                bv = false;

            }
            /* else */ if (salary2.getText().length() == 0) {
                //jok.dispalyEroorMessage("Please fill this field", 980, 650, 5000 );

                jok.setErrorForTextField("Please fill this field", salary2, this, 5000);
                bv = false;

            }
            /* else */ if (path1.getText().length() == 0) {

//  jok.dispalyEroorMessage("Please select an image", 1130, 480, 5000 );
              //  jok.setErrorForTextField("Please select an image", path1, this, 5000);
              //  bv = false;
            }

//            Calendar f_c1 = Calendar.getInstance();
//            Calendar f_c2 = Calendar.getInstance();
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//            f_c1.setTime(sdf.parse(join_date2.getText()));// all done
//            f_c2.setTime(sdf.parse(out_date2.getText()));// all done
//            System.err.println("" + f_c1.getTime());
//            System.err.println("" + f_c2.getTime());
//
//            if (f_c2.getTime().before(f_c1.getTime())) {
//               jok.setErrorForTextField("Date of Birth :date of birth error", this.dob2, this, 5000);
//                //  jok.dispalyEroorMessage("Date of Birth :date of birth error", 980, 30, 5000 );
//                
//                bv = false;
//                return;
//            }

            if (!bv) {
                return;

            } else {

                String geMobno = mobile2.getText();
//matches 10-digit numbers only
                String regexStr = "^[0-9]{10}$";
                if (!geMobno.matches(regexStr)) {
//     jok.dispalyEroorMessage("Please insert a valid mobile number", 620, 700, 5000 );
                    jok.setErrorForTextField("Please insert a valid mobile number", mobile2, this, 5000);

                    return;
                }

                String eMailVa
                        = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String eMaiL = email2.getText();
                if(!emailL.equals("NULL"))
                if (!eMaiL.matches(eMailVa)) {
//     jok.dispalyEroorMessage("Please insert a valid email id", 620, 650, 5000 );

                    jok.setErrorForTextField("Please insert a valid email id", email2, this, 5000);
                    return;
                }

                int salaa = Integer.parseInt(salary2.getText());
                if (salaa > 100000) //    jok.dispalyEroorMessage("invalid salary", 980, 650, 5000 );
                {
                    jok.setErrorForTextField("invalid salary", salary2, this, 5000);
                }

                 if(!land.equals("NULL"))
                if (!(Telephone2.getText().length() >= 10)) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("invalid Telephone number", Telephone2, this, 5000);
                    return;
                }
                           if (jRadioButton2.isSelected()) {
                   
        } else {
                 
           
                  if(sddate2.getTime().before(sddate1.getTime())) {
                
                jok.setErrorForTextField("Please enter a valid date and/or select at least one month", out_date2, this, 5000);
                
                return;
            }
                           }
            
                   if (mobile2.getText().equals(Telephone2.getText())) {
//     jok.dispalyEroorMessage("Please insert a valid mobile number", 620, 700, 5000 );
                    jok.setErrorForTextField("Please, mobile and Telephone numbers are same", mobile2, this, 5000);

                    return;
                }
                  
                  

            }

            
            
            
            
            

          

 /////////////////////////////////////////////////////////////////////////////////////////////////////
 
 
 
	
         } catch (Exception e) {
        }

       
        
        String userid= "";
        
        
          try {
             userid =  all_emplo.getSelectedItem().toString();
          } catch (Exception e) {
          }
        
        
          if (userid.length() < 1) {
              return;
          }
          
          String ddf = "NULL";
         if (jRadioButton2.isSelected()) {
            ddf = "NULL";
        } else {
             ddf = "'"+out_date2.getText()+"'";
         }
          
          
          
        String query="";
        ///////////////////////panno1.
        //    c
        try {
           MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
        
           query = "UPDATE `employee` SET `fname`='" + fname1.getText() + "',`lname`='" + lname1.getText() + "',`gender`= '"+morfv+"',`age`= "+ age2.getText() 
                   + ",`dob`='"+dob2.getText() + "',`praddress`= '"+praddr2.getText()+"',`peaddress`= '"+peaddr2.getText()+"',`mno`="+mobile2.getText()
                   +",`lno`="+land+",`email`="+emailL+",`qualification`='"+qualification2.getSelectedItem().toString()
                   +"',`day`='"+dorn+"',`sdate`='"+join_date2.getText()+"',`edate`="+ddf+",`salary`='"+salary2.getText()+"',`icon`= ? WHERE  empid = '"+userid+"'";
           
           
           
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);

            mysqlitem.p.setBytes(1, outputimg);

            int rs = mysqlitem.p.executeUpdate();

     
   xcptn_chk = 0;
            JOptionPane.showMessageDialog(this, new String("successfully added"));
            
            
// addInTheScrollPaneInMain(user_id.getText(),lname.getText(),fname.getText(),mphn.getText(),outputimg);
// addEmployeeToTheEmployeeShown();
 
setAllInTheEmplyeeNull4Edit() ;
all_emplo.setSelectedItem("select employee id");
               mysqlitem.p.close();
           mysqlitem.con.close();
       
            
        } catch (Exception e1) {
            if(xcptn_chk==1)
            {
                 xcptn_chk = 1;
            System.out.println("Eroarmmmmmmmmmmmmmme");
            System.out.println(e1);
            String error = String.valueOf(e1);
        
           // addError(error);//            ........................................................................................>>>>>>>>>>>>>>                       
                    
            }
           
            //JOptionPane.showMessageDialog(this,new String("Please fill in all fields"));
        }

        
      
        
//        addDataToTable();//........................................................................................>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
        // TODO add your handling code here:displayDetailsmakeDispayEmployee
    }

    
      void setAllInTheEmplyeeNull4Edit () {
        
 
        fname1.setText("");
        lname1.setText("");
        praddr2.setText("");
        email2.setText("");
        mobile2.setText("");
        peaddr2.setText("");
        salary2.setText("");
        Telephone2.setText("");
        path1.setText("");
        image_h2.setIcon(null);  
        
      
        
        
        Calendar cou = Calendar.getInstance();
        cou.add(Calendar.DAY_OF_WEEK, -1);
        join_date2.setSelectedDate  (cou);
        cou.add(Calendar.YEAR, -19);
        dob2.setSelectedDate(cou);
        
        out_date2.setSelectedDate(Calendar.getInstance());
        jCheckBox2.setSelected(false);
        
        age2.setText("");
    }
   
    
    
    private void jLabel99MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseExited
        // TODO add your handling code here:
        jLabel99.setBackground(new java.awt.Color(51, 51, 255));
    }//GEN-LAST:event_jLabel99MouseExited

    private void jLabel99MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseEntered
        // TODO add your handling code here:
        jLabel99.setBackground(new java.awt.Color(51, 0, 204));
    }//GEN-LAST:event_jLabel99MouseEntered

    private void jLabel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseClicked
        // TODO add your handling code here:
        
        setAllInTheEmplyeeNull4Edit();
        
all_emplo.setSelectedItem("select employee id");
    }//GEN-LAST:event_jLabel100MouseClicked

    private void jLabel100MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseExited
        // TODO add your handling code here:
        jLabel100.setBackground(new java.awt.Color(51, 51, 255));
    }//GEN-LAST:event_jLabel100MouseExited

    private void jLabel100MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseEntered
        // TODO add your handling code here:
        jLabel100.setBackground(new java.awt.Color(51, 0, 204));
    }//GEN-LAST:event_jLabel100MouseEntered

    private void all_emploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_all_emploActionPerformed
        // TODO add your handling code here:
        
        System.err.println(" iterm    ");
        
       
    }//GEN-LAST:event_all_emploActionPerformed

    private void all_emploItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_all_emploItemStateChanged
        // TODO add your handling code here:
        System.err.println(" do man "); 
        String s = "";
        try {
            
            s= all_emplo.getSelectedItem().toString();
            
            
        } catch (Exception e) {
        }
        
        
        if(s.length() > 1)
        displayForEdit ( s ) ;
        
    }//GEN-LAST:event_all_emploItemStateChanged

    private void jLabel101MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseEntered
        // TODO add your handling code here:
        
jLabel101.setBackground(new java.awt.Color(0, 204, 51));
    }//GEN-LAST:event_jLabel101MouseEntered

    private void jLabel101MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseExited
        // TODO add your handling code here:
        
jLabel101.setBackground(new java.awt.Color(0, 153, 51));
    }//GEN-LAST:event_jLabel101MouseExited

    private void jLabel101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseClicked
        // TODO add your handling code here:
        
        
        
jLabel101.setBackground(new java.awt.Color(0, 153, 51));


           Calendar now = Calendar.getInstance();
        try {
            Date date = new Date();
            Calendar f = Calendar.getInstance();

            join_date2.setMaxDate(Calendar.getInstance());
            out_date2.setMinDate(Calendar.getInstance());
            f.add(Calendar.WEEK_OF_MONTH, -1);
            f.add(Calendar.YEAR, -18);
            dob2.setMaxDate(f);

        } catch (Exception e) {
        }
        
        //
        
        
        
        dob2.setDateFormat(sdfhz);
        join_date2.setDateFormat(sdfhz);
        out_date2.setDateFormat(sdfhz);
        
        
        addEmployeesToComboBox();
        
        
        
        

    System.err.println(" do man "); 
        String s = "";
        try {
            
            s= user_name3.getText();
            
            
        } catch (Exception e) {
        }
        
        
        
        
        try {
            
            
            if(s.length() > 1) {
                
                all_emplo.setSelectedItem(s);

                displayForEdit ( s ) ;
                replaceLayer(innr_main_menu0, innr_menu_main_a03);
        
        
            }
            
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_jLabel101MouseClicked

    private void HEADMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HEADMouseClicked

        showAnEroorNotificatinOnDesktop( " test "," notification test ", 5000 );
        setAsFont();
// TODO add your handling code here:
    }//GEN-LAST:event_HEADMouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        // TODO add your handling code here:
        area.setText("");
pprice.setText("");
dprice.setText("");
oprice.setText("");
pincd.setText("");
state.setText("");

    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        // TODO add your handling code here:
        int d = 0;
         try {
                    d = countResult("select count(*) from area where area.area = '"+area.getText()+"'");
        } catch (Exception e) {
        }
        
        if (d > 0) {
            showAnEroorNotificatinOnDesktop("duplicate entry ", " area already inserted", 7000);
            return;
        }
        
        if (pincd.getText().length() != 6) {
            
            
                jok.setErrorForTextField("Please insert a valid pincode", pincd, this, 5000);
            return;
        }
        
        
         if (Integer.parseInt(dprice.getText()) < 10) {
            
            
                jok.setErrorForTextField("Please insert a valid DIESEL PRICE ", dprice, this, 5000);
            return;
        }
          if (Integer.parseInt(pprice.getText()) < 10) {
            
            
                jok.setErrorForTextField("Please insert a valid PETROL PRICE ", dprice, this, 5000);
            return;
        }
           if (Integer.parseInt(oprice.getText()) < 5) {
            
            
                jok.setErrorForTextField("Please insert a valid  OIL PRICE :", dprice, this, 5000);
            return;
        }
           
        
        
        Date date =  new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = format.format(date);
        
        
        
        
        try {
                  MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
        
        
          String query = "INSERT INTO `area` ( `area`, `selected`, `pin`, `state`,  `date`) VALUES "
                  + "( '"+area.getText()+"', '0', "+pincd.getText()+", '"+state.getText()+"', ' "+timestamp+"'); ";
           
           
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

     
            
            
        } catch (Exception e) {
            
            // error 8052
            return;
        }
        
        
        
        String area_id = "";
          MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM area WHERE  date = '"+timestamp+"' ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
        
 
area_id = mysqlitem.rs.getString("id") ;



        
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
        
 
        if ( area_id.length() < 1) {
            
            return;
            
        }
        
        
        
        
        
        
           try {
                   mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
        
        
           query = "INSERT INTO `area_details` (`area_id`, `p_price`, `d_price`, `o_price` ) "
                   + "VALUES ('"+area_id+"', '"+pprice.getText()+"', '"+dprice.getText()+"', '"+oprice.getText()+"');";
           
           
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);

            

            int rs = mysqlitem.p.executeUpdate();

     
        area.setText("");
pprice.setText("");
dprice.setText("");
oprice.setText("");
pincd.setText("");
state.setText("");
add_new.hide();
disaplayDeatisAtHome();
            
addareaToComboBox();
setAtTheFirstTop( );
            JOptionPane.showMessageDialog(this, new String("successfully added"));
        } catch (Exception e) {
            
            // error 8052
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jLabel43MouseClicked

    private void pincdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pincdKeyTyped
        // TODO add your handling code here:
               char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_pincdKeyTyped

    private void opriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_opriceKeyTyped
        // TODO add your handling code here:
               char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_opriceKeyTyped

    private void dpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpriceKeyTyped
        // TODO add your handling code here:
               char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_dpriceKeyTyped

    private void ppriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ppriceKeyTyped
        // TODO add your handling code here:
               char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_ppriceKeyTyped

    private void select_deta_plzItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_select_deta_plzItemStateChanged
        // TODO add your handling code here:
        
        String s = "";
        
        try {
            s = select_deta_plz.getSelectedItem().toString();
        } catch (Exception e) {
        }
        
        if (s.length() > 1  ) {
            
            
            if (!s.equals("select top priority")) {
                
            updateewTop( s);
            }
        }
        
    }//GEN-LAST:event_select_deta_plzItemStateChanged

    private void jLabel108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel108MouseClicked

    private void state1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_state1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_state1ActionPerformed

    private void pprice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pprice1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pprice1ActionPerformed

    private void pprice1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pprice1KeyTyped
        // TODO add your handling code here:
                   char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_pprice1KeyTyped

    private void area1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_area1ActionPerformed

    private void dprice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dprice1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dprice1ActionPerformed

    private void dprice1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dprice1KeyTyped
        // TODO add your handling code here:
                   char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_dprice1KeyTyped

    private void oprice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oprice1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oprice1ActionPerformed

    private void oprice1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oprice1KeyTyped
        // TODO add your handling code here:
                   char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_oprice1KeyTyped

    private void to_date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_to_date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_to_date1ActionPerformed

    private void pincd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pincd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pincd1ActionPerformed

    private void pincd1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pincd1KeyTyped
        // TODO add your handling code here:
                   char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_pincd1KeyTyped

    private void jLabel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseClicked
        // TODO add your handling code here:
  
        
        
     
        //   showAnEroorNotificatinOnDesktop("duplicate entry ", " area already inserted", 7000);
        
        System.err.println(" --- "+pincd1.getText().length());
        if (pincd1.getText().length() != 6) {
            
            
                jok.setErrorForTextField("Please insert a valid pincode", pincd1, this, 5000);
            return;
        }
        
        
         if (Float.parseFloat(dprice1.getText()) < 10) {
            
            
                jok.setErrorForTextField("Please insert a valid DIESEL PRICE ", dprice1, this, 5000);
            return;
        }
          if (Float.parseFloat(pprice1.getText()) < 10) {
            
            
                jok.setErrorForTextField("Please insert a valid PETROL PRICE ", dprice1, this, 5000);
            return;
        }
           if (Float.parseFloat(oprice1.getText()) < 5) {
            
            
                jok.setErrorForTextField("Please insert a valid  OIL PRICE :", dprice1, this, 5000);
            return;
        }
           
        
        
        
        
        try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
      
        
           
           String query = "INSERT INTO `area_details` (`area_id`, `p_price`, `d_price`, `o_price`) VALUES "
                   + "("+hidden_id.getText()+", "+pprice1.getText()+", "+dprice1.getText()+", "+oprice1.getText()+") ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
         //   JOptionPane.showMessageDialog(this, new String("successfully updated"));
          //  updateNewDisplay ( String area);
            
          
        
        
        
area1.setText("");
pprice1.setText("");
dprice1.setText("");
oprice1.setText("");
pincd1.setText("");
state1.setText("");
    
update_data.hide();


pprice1.setText(pprice1.getText());
dprice1.setText(dprice1.getText());
oprice1.setText(oprice1.getText());

doPriceThis();


disaplayDeatisAtHome();



            try {
                updateNewDisplay (select_deta_plz.getSelectedItem().toString()) ;
            } catch (Exception e) {
            }
    


mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
         
        
        
    }//GEN-LAST:event_jLabel111MouseClicked

    private void jLabel111MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseExited
        // TODO add your handling code here:
        
        jLabel111.setBackground(new java.awt.Color(102, 51, 0));
    }//GEN-LAST:event_jLabel111MouseExited

    private void jLabel111MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseEntered
        
        jLabel111.setBackground(new java.awt.Color(153, 51, 0));
    }//GEN-LAST:event_jLabel111MouseEntered

    private void jLabel112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseClicked
        // TODO add your handling code here:
        
        
area1.setText("");
pprice1.setText("");
dprice1.setText("");
oprice1.setText("");
pincd1.setText("");
state1.setText("");
        
    }//GEN-LAST:event_jLabel112MouseClicked

    private void jLabel112MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseExited
        // TODO add your handling code here:
        jLabel112.setBackground(new java.awt.Color(51, 102, 0));
    }//GEN-LAST:event_jLabel112MouseExited

    private void jLabel112MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseEntered
        // TODO add your handling code here:
        
        jLabel112.setBackground(new java.awt.Color(51, 153, 0));
    }//GEN-LAST:event_jLabel112MouseEntered

    private void jLabel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseExited
        // TODO add your handling code here:
        
jLabel32.setBackground(new java.awt.Color(51, 51, 255));
    }//GEN-LAST:event_jLabel32MouseExited

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
        // TODO add your handling code here:
         jLabel32.setBackground(new java.awt.Color(51, 0, 204));
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
        
           System.err.println(" do man "); 
        String s = "";
        try {
            
            s= all_emplo.getSelectedItem().toString();
            if (s.equals("select employee id")) {
                s="";
            }
            
            
        } catch (Exception e) {
        }
        
        
        if(s.length() > 1){
            
            
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "are you sure you want to delete employee id "+s+" ?","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){
    
      try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
           String query = " UPDATE `employee` SET `satus` = 'deleted' WHERE empid = '"+s+"'; ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

        setAllInTheEmplyeeNull4Edit();
        
all_emplo.setSelectedItem("select employee id");
            
          try {
              
all_emplo.removeItem(s);

          } catch (Exception e) {
          }
       
         
            JOptionPane.showMessageDialog(this, new String("successfully deleted"));

         
          
        
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        
}
            
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jLabel32MouseClicked

    private void pupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pupActionPerformed

    private void dupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dupActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "are you sure you want to update ?","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){
    
    
            
    
    
    
 try{
     
      MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM `fuel`";
 System.out.println(query);
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
 
                   if (mysqlitem.rs.getInt("id") == 1) {
                       
                       if (mysqlitem.rs.getFloat("availability") > Float.parseFloat(pup.getText())) {
                           actionForBilling();
                           return;
                           
                       }
                   }
        if (mysqlitem.rs.getInt("id") == 2) {
                        if (mysqlitem.rs.getFloat("availability") > Float.parseFloat(dup.getText())) {
                           actionForBilling();
                           return;
                           
                       }
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
        
    
    
    
    
        
        
        
          try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
           String query = " UPDATE `fuel` SET `capacity` = "+pup.getText()+" WHERE fuel_name = 'petrol' ; ";
           
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
        
        
          
              try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
           String query = " UPDATE `fuel` SET `capacity` = "+dup.getText()+" WHERE fuel_name = 'diesel'; ";
           
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
              
              
        
            actionForBilling();
}
          
          
          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pupKeyTyped
        // TODO add your handling code here:
                    char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_pupKeyTyped

    private void dupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dupKeyTyped
        // TODO add your handling code here:
        
                    char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_dupKeyTyped

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void deakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deakerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deakerActionPerformed

    private void amount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amount1ActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void jLabel123MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel123MouseEntered
        // TODO add your handling code here:

        jLabel123.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_jLabel123MouseEntered

    private void jLabel123MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel123MouseExited
        // TODO add your handling code here:
        
jLabel123.setBackground(new java.awt.Color(102, 102, 102));

    }//GEN-LAST:event_jLabel123MouseExited

    private void deaker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deaker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deaker1ActionPerformed

    private void amount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amount2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amount2ActionPerformed

    private void price1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_price1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price1ActionPerformed

    private void total1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total1ActionPerformed

    private void jLabel128MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel128MouseExited
        // TODO add your handling code here:
jLabel128.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_jLabel128MouseExited

    private void jLabel128MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel128MouseEntered
        // TODO add your handling code here:
        jLabel128.setBackground(new java.awt.Color(51, 51, 51));
        
    }//GEN-LAST:event_jLabel128MouseEntered

    private void amount1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amount1KeyTyped
        // TODO add your handling code here:
                         char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
        
        
        
        
    }//GEN-LAST:event_amount1KeyTyped

    private void priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyTyped
        // TODO add your handling code here:
                         char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_priceKeyTyped

    private void price1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_price1KeyTyped
        // TODO add your handling code here:
                         char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_price1KeyTyped

    private void amount2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amount2KeyTyped
        // TODO add your handling code here:
                         char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_amount2KeyTyped

    private void jLabel123MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel123MouseClicked
        // TODO add your handling code here:
        
        
        
        
                if (deaker.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", deaker, this, 5000);
                    return;
                }
                
        
        
        
                
                
        
                if (amount1.getText().trim().length() <1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", amount1, this, 5000);
                    return;
                }
                
        
        
        
                if (price.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", price, this, 5000);
                    return;
                }
                
        
        
        
                if (total.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", total, this, 5000);
                    return;
                }
                
        
        
        
        
        
        
        boolean b =  false;
        
        
        
    MysqlConnect mysqlitem = new MysqlConnect();
        
                try {
 System.out.println("vvvvvvv");
                 mysqlitem.crearedatabase();
                String query = "INSERT INTO `stock_import` (`fuel_id`, `dealer`, `amount`, `price_litre`, `total_price`) VALUES "
                        + "('1', '"+deaker.getText()+"', "+amount1.getText()+","+price.getText()+", "+total.getText()+");";
                
                System.out.println("vvvvvvv    nn    " + query);
                    mysqlitem.p = mysqlitem.con.prepareStatement(query);
                    mysqlitem.p.executeUpdate();

                    
                    b = true;
                    System.err.println(b); 
                    
                 mysqlitem.rs.close();
                   mysqlitem.p.close();
                mysqlitem.con.close();
                   // maleNullAddEmployee();//............,,,,,,,,,
                } catch (Exception e1) {
                   
                    

                }
        
        
                if (b) {
            
                    
                    
                      try {
            
         mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        
        float dfg = Float.parseFloat(plitr1.getText());
        
        float dff = Float.parseFloat(amount1.getText());
        
        
           
           String query = " UPDATE `fuel` SET `availability` = "+(dfg+dff)+" WHERE fuel_name = 'petrol'; ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();
            
            
            
                    deaker.setText("");
                    amount1.setText("");
                    price.setText("");
                    total.setText("");
            
                    
                      actionForBilling();
                      
                        JOptionPane.showMessageDialog(this, new String("successfully updated"));
                  
        
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
                    
        }
                
                
                
    }//GEN-LAST:event_jLabel123MouseClicked

    private void jLabel128MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel128MouseClicked
        // TODO add your handling code here:
        
        
        
        
                if (deaker1.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", deaker1, this, 5000);
                    return;
                }
                
        
        
        
                
                
        
                if (amount2.getText().trim().length() <1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", amount2, this, 5000);
                    return;
                }
                
        
        
        
                if (price1.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", price1, this, 5000);
                    return;
                }
                
        
        
        
                if (total1.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", total1, this, 5000);
                    return;
                }
                
        
        
        
        boolean b = false;
        
        
        
        
        
        
        
                try {
 System.out.println("vvvvvvv");
    MysqlConnect mysqlitem = new MysqlConnect();
                 mysqlitem.crearedatabase();
                String query = "INSERT INTO `stock_import` (`fuel_id`, `dealer`, `amount`, `price_litre`, `total_price`) VALUES "
                        + "('2', '"+deaker1.getText()+"', "+amount2.getText()+","+price1.getText()+", "+total1.getText()+");";
                
                System.out.println("vvvvvvv    nn    " + query);
                    mysqlitem.p = mysqlitem.con.prepareStatement(query);
                    mysqlitem.p.executeUpdate();

                  
                    b = true;
                    
                    
                    
                 mysqlitem.rs.close();
                 
                   mysqlitem.p.close();
                mysqlitem.con.close();
                   // maleNullAddEmployee();//............,,,,,,,,,
                } catch (Exception e1) {
                   
                    

                }
        
                
                
                
                
                
                
                
                if (b) {
            
                    
                    
                      try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
        
        
            
        float dfg = Float.parseFloat(dlitr1.getText());
        
        float dff = Float.parseFloat(amount2.getText());
        
        
        
           
           String query = " UPDATE `fuel` SET `availability` = "+(dfg+dff)+" WHERE fuel_name = 'diesel'; ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();
            
            
                    deaker1.setText("");
                    amount2.setText("");
                    price1.setText("");
                    total1.setText("");
                    
                      actionForBilling();
            
                    JOptionPane.showMessageDialog(this, new String("successfully updated"));
                    
        
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
                    
        }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
    }//GEN-LAST:event_jLabel128MouseClicked

    private void totalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalMouseClicked
        // TODO add your handling code here:
        
        setThetotal();
    }//GEN-LAST:event_totalMouseClicked

    private void total1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_total1MouseClicked
        // TODO add your handling code here:
        setThetotal1();
    }//GEN-LAST:event_total1MouseClicked

    private void amount1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amount1KeyReleased
        // TODO add your handling code here:
        
        try {
            
        float fg = Float.parseFloat(plitr1.getText());
        float fj = Float.parseFloat(amount1.getText());
        float fu = Float.parseFloat(pup.getText());
        
        
        if (fu < (fg+fj) )  {
            
            jok.setErrorForTextField("error , fuel overflow", amount1, this, 5000);
                
                    
                
            amount1.setText("");
            
            
        }
        
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_amount1KeyReleased

    private void amount2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amount2KeyReleased
        // TODO add your handling code here:
           
        try {
              
        float fg = Float.parseFloat(dlitr1.getText());
        float fj = Float.parseFloat(amount2.getText());
        float fu = Float.parseFloat(dup.getText());
        
        
        if (fu < (fg+fj) )  {
            
            jok.setErrorForTextField("error , fuel overflow", amount2, this, 5000);
                
                    
                
            amount2.setText("");
            
            
        }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_amount2KeyReleased

    private void jLabel142MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel142MouseEntered

jLabel142.setBackground(new java.awt.Color(51, 51, 51));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel142MouseEntered

    private void jLabel142MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel142MouseExited

jLabel142.setBackground(new java.awt.Color(0, 0, 0));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel142MouseExited

    private void jLabel142MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel142MouseClicked
 selectFontHere();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel142MouseClicked

    private void jLabel143MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel143MouseClicked
    JLabel jLabel =  (JLabel)evt.getSource();
  
    selected_fon.setText("");
    
    jLayeredPane17.removeAll();
    jLayeredPane17.repaint();
    jLayeredPane17.revalidate();
    
    JLabel fontDi1 =  new JLabel();
    JLabel fontDi2 =  new JLabel();
    
        fontDi1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N

    
        System.err.println("ssssssssssssssssssssssssssssssssssss"+jLabel.getText());
        fontDi1.setFont(new java.awt.Font(jLabel.getText(), 0, 14)); // NOI18N
        fontDi2.setFont(new java.awt.Font(jLabel.getText(), 0, 14)); // NOI18N
        fontDi1.setText("abcdefghijklmnopqrstuvwxyz");
        fontDi2.setText("abcdefghijklmnopqrstuvwxyz".toUpperCase());
       
        
        jLayeredPane17.add(fontDi1);
        jLayeredPane17.add(fontDi2);
        
        
    jLayeredPane17.repaint();
    jLayeredPane17.revalidate();
    
    jLayeredPane17.repaint();
    jLayeredPane17.revalidate();
    
    selected_fon.setText(jLabel.getText());
           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel143MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
select_font.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         System.err.println(""+ selected_fon.getText());
        select_font.hide();
        try {
            
         actionForSetThis(this, new javax.swing.plaf.FontUIResource(selected_fon.getText(), Font.ITALIC, 12));
        } catch (Exception e) {
        }
        
        createAsettingFile(selected_fon.getText()) ;
        
        showRestrt();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void showDateOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_showDateOnSelectionChange
   try {
            aboveClick(showDate.getText());    
     
        } catch (Exception e) {
        }
// TODO add your handling code here:
    }//GEN-LAST:event_showDateOnSelectionChange

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

            out_date1.setEnabled(true);
        if (jRadioButton1.isSelected()) {
            out_date1.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
         out_date2.setEnabled(true);
        if (jRadioButton2.isSelected()) {
            out_date2.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jLabel146MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel146MouseClicked
      
        change_passwd.setLocationRelativeTo(null);
           passwrd1.setText("");
         passwrd2.setText("");
         passwrd3.setText("");
          
        
        change_passwd.show();
        

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel146MouseClicked

    
    
    
    private void jLabel146MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel146MouseExited
     jLabel146.setBackground(new java.awt.Color(0, 0, 0));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel146MouseExited

    private void jLabel146MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel146MouseEntered
jLabel146.setBackground(new java.awt.Color(51, 51, 51));
           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel146MouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

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
String query = "SELECT * FROM login WHERE  user_name ='admin'  ";
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
       
           
            query = " UPDATE `login` SET `password` = '"+passwrd3.getText()+"' WHERE user_name = 'admin' ; ";
           
      
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
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

Log_in log_in = new Log_in();
log_in.show();
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel151MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel151MouseClicked
 try {
            aboveClick(showDate.getText());    
     
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel151MouseClicked

    private void jLabel151MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel151MouseEntered

jLabel151.setBackground(new java.awt.Color(77, 166, 200));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel151MouseEntered

    private void jLabel151MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel151MouseExited
//77,166,250     

jLabel151.setBackground(new java.awt.Color(77,166,250));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel151MouseExited

    
    
   void showRestrt() {
       
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "retart this application","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){
    
       try {
       restartApplication();
       
       } catch (Exception e) {
       
           }
}
   }
    void selectFontHere() {
        view_fonts.removeAll();
        view_fonts.repaint();
        view_fonts.revalidate();
        String fonts[] = 
      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
int y = 0;



view_fonts.setPreferredSize(new java.awt.Dimension(310, (fonts.length * 22)));


        
    for ( int i = 0; i < fonts.length; i++ ) {
      //System.out.println(fonts[i]);
        
        
        
        view_fonts.setBackground(new java.awt.Color(204, 204, 204));
        view_fonts.setOpaque(true);
JLabel jLabel143 = new JLabel();
        jLabel143.setBackground(new java.awt.Color(255, 255, 255));
        jLabel143.setFont(new java.awt.Font(fonts[i]+"", 0, 12)); // NOI18N
        jLabel143.setText(fonts[i]);
        jLabel143.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel143.setOpaque(true);
        jLabel143.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel143MouseClicked(evt);
            }
        });
        view_fonts.add(jLabel143);
        jLabel143.setBounds(0, y, 310, 20);

        
        view_fonts.setBounds(10,0, 310, 370);
        
        
        y+=22;
        
        
        
    }  
        
    
    
        view_fonts.repaint();
        view_fonts.revalidate();
        
        select_font.setLocationRelativeTo(null);
    select_font.show();
    
    }
    
    void setThetotal() {
        
         if (amount1.getText().trim().length() <1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", amount1, this, 5000);
                    return;
                }
                
        
        
        
                if (price.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", price, this, 5000);
                    return;
                }
                
        int fd = Integer.parseInt( amount1.getText());
        int fg = Integer.parseInt( price.getText());
        
        total.setText(""+fd * fg);
    }
     void setThetotal1() {
          if (amount2.getText().trim().length() <1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", amount2, this, 5000);
                    return;
                }
                
        
        
        
                if (price1.getText().trim().length() < 1) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("Please fill this field", price1, this, 5000);
                    return;
                }
                
        int fd = Integer.parseInt( amount2.getText());
        int fg = Integer.parseInt( price1.getText());
        
        total1.setText(""+fd * fg);
    }
    
    
    void  updateewTop( String ffs) {
        
         boolean b =  false ;
        try {
             
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
           String query = " UPDATE `area` SET `selected` = '0' ; ";
           
           //UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"' 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
         //   JOptionPane.showMessageDialog(this, new String("successfully updated"));
          //  updateNewDisplay ( String area);
            
          b =  true;
          
        
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        
        if (b) {
            
        
          try {
            
        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
           String query = " UPDATE `area` SET `selected` = '1' WHERE `area` = '"+ffs+"'";
           
           // 
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            

            int rs = mysqlitem.p.executeUpdate();

            
         //   JOptionPane.showMessageDialog(this, new String("successfully updated"));
          //  updateNewDisplay ( String area);
            
            updateNewDisplay (ffs);
        
mysqlitem.rs.close();
mysqlitem.p.close();
            mysqlitem.con.close();
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        }
    }
    
    
    void updateNewDisplay ( String area) {
        
        int a_a = 0;
        String a_area = "";
        float a_pprice = 0;
        float a_dprice = 0;
        float a_oprice = 0;
        
        String a_lastupdate = "";
        String a_pincode = "";
        String a_state = "";
        
        
        aarea.setText("");
        apprice.setText("");
        adprice.setText("");
        aoprice.setText("");
        alstpr.setText("");
        apincd.setText("");
        astate.setText("");
        
        
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM area WHERE `area`='"+area+"' AND valid='1'";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
        
a_a = mysqlitem.rs.getInt("id") ;
a_area=  mysqlitem.rs.getString("area");
a_pincode=  mysqlitem.rs.getString("pin");
a_state=  mysqlitem.rs.getString("state");


 
        
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
        
        
        
        System.err.println(" eee    "+a_a);
        
        if (a_a <= 0) {
            
            return;
        }
 
 
        
         mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
 query = "SELECT * FROM area_details WHERE `area_id`="+a_a+"  ORDER BY `area_details`.`date` DESC LIMIT 1";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
        
a_pprice = mysqlitem.rs.getFloat("p_price") ;
a_dprice = mysqlitem.rs.getFloat("d_price") ;
a_oprice = mysqlitem.rs.getFloat("o_price") ;

a_lastupdate = mysqlitem.rs.getString("date");

 
        
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
 
 
 
 
// int a_a = 0;
//        String a_area = "";
//        float a_pprice = 0;
//        float a_dprice = 0;
//        float a_oprice = 0;
//        
//        String a_lastupdate = "";
//        String a_pincode = "";
//        String a_state = "";
     
        
        aarea.setText(a_area);
        apprice.setText(""+a_pprice);
        adprice.setText(""+a_dprice);
        aoprice.setText(""+a_oprice);
        alstpr.setText(""+a_lastupdate);
        apincd.setText(""+a_pincode);
        astate.setText(""+a_state);
        
           
 doPriceThis();


        
    }
    
    
    void displayForEdit ( String id ) {
        
        setAllInTheEmplyeeNull4Edit ();
                   
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM employee WHERE  empid='"+id+"' AND satus='employee'";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
        
 
fname1.setText(mysqlitem.rs.getString("fname") );
lname1.setText( mysqlitem.rs.getString("lname"));



            Calendar c= Calendar.getInstance();
                    c.setTime(sdfhz.parse(""+mysqlitem.rs.getDate("dob")));// all done
           
dob2.setSelectedDate(c);

age2.setText(""+mysqlitem.rs.getInt("age"));
praddr2.setText(mysqlitem.rs.getString("praddress"));
email2.setText(mysqlitem.rs.getString("email"));
mobile2.setText(""+mysqlitem.rs.getBigDecimal("mno"));

 c.setTime(sdfhz.parse(""+mysqlitem.rs.getDate("sdate")));// all done

join_date2.setSelectedDate(c);



     try {
                       c.setTime(sdfhz.parse(""+mysqlitem.rs.getDate("edate")));// all done

out_date2.setSelectedDate(c);


                   } catch (Exception e) {
                       jRadioButton2.setSelected(true);
                   }


peaddr2.setText(mysqlitem.rs.getString("peaddress"));
salary2.setText(""+mysqlitem.rs.getInt("salary"));

Telephone2.setText(""+mysqlitem.rs.getBigDecimal("lno"));

                   if (Telephone2.getText().trim().equals("null")) {
                       Telephone2.setText("");
                   }

qualification2.setSelectedItem(mysqlitem.rs.getString("qualification"));



                   try {
                       int i = mysqlitem.rs.getInt("day");
                       if (i == 1) {
                           v3.setSelected(true);
                       } else {
                            v4.setSelected(true);
                       }
                   } catch (Exception e) {
                   }


                   

                   
                   try {
                       String i = mysqlitem.rs.getString("gender");
                       if (i.equals("M")) {
                           c3.setSelected(true);
                       } else {
                           c4.setSelected(true);
                       }
                   } catch (Exception e) {
                   }

                   


 byte[] imagedata = mysqlitem.rs.getBytes("icon");
                ImageIcon format = null;

                outputimg = imagedata;
                format = new ImageIcon(imagedata);
                image_h2.setIcon(format);
        
        
       
        
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
    
    
    
    
    
    
    
    void showAllInThisClick () {
        jTable1.setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getDefaultRenderer(Object.class)).setOpaque(false);

        jScrollPane5.setOpaque(false);
        jScrollPane5.getViewport().setOpaque(false);

        jTable1.setShowGrid(false);

        addDataToTable();//................................................................................................

        // TODO add your handling code here:
    }                                   
  void addDataToTable() {

        MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        try {

            String query = "SELECT "
                    + " `empid` AS 'EMP ID', CONCAT(`fname`,' ',`lname`) AS ' NAME', `gender` AS 'GENDER' , `age` AS 'AGE', `dob` AS 'DOB', `praddress` AS 'PRESENT ADDRESS',"
                  //  + " `peaddress` AS 'PERMANENT ADDRESS', "
                    + " `mno` AS 'MOBILE', `lno` AS 'LAND LINE', `email` AS 'EMAIL', `qualification` AS 'QUALIFI:',`sdate` AS 'START DATE', `edate` AS 'END DATE', `salary` AS 'SALARY'"
                    + " FROM employee  WHERE satus='employee'";// WHERE userid='"+tmpempid+"'";

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            System.out.println(query);

            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            jTable1.setModel(DbUtils.resultSetToTableModel(mysqlitem.rs));                                                                                    //xxxxxxxxxxxxxxx

            resizeColumnWidth(jTable1);
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
            System.out.println("success");
        } catch (Exception ob) {
            System.out.println(ob);
        }

      //  employeeId();

    }
    
    
    
    void doActionForSowSearch( String usearch ) {
        
      
        
        
           show_reslut_clicabl.removeAll();
          show_reslut_clicabl.repaint();
           show_reslut_clicabl.revalidate();
           
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM employee WHERE (fname= '"+searchfield.getText()+"' OR lname='"+searchfield.getText()+"' OR empid='"+searchfield.getText()+"' ) AND satus='employee'";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           
           int y=10;
           
             JLabel sw_user_id;
             JLabel sw_img ;
             JLabel sw_no;
             JLabel sw_name ;
             JLabel sw_othr ; 
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
          javax.swing.JLayeredPane show_onz;
 show_onz = new javax.swing.JLayeredPane();
 show_onz.setBackground(new java.awt.Color(255, 255, 255));
        show_onz.setOpaque(true);

        
         sw_user_id =  new JLabel();
               sw_img =  new JLabel();
               sw_no =  new JLabel();
               sw_name =  new JLabel();
               sw_othr =  new JLabel(); 
        
        
        
        
             sw_user_id.setText(mysqlitem.rs.getString("empid"));
        sw_user_id.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        sw_user_id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        
        
        
sw_user_id.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        sw_user_idMouseClicked(evt);
    }
});

        
        
        
        show_onz.add(sw_user_id);
        sw_user_id.setBounds(0, 0, 320, 60);
        
        //sw_img

        
        show_onz.add(sw_img);
        sw_img.setBounds(265, 5, 50, 50);

        sw_no.setText(mysqlitem.rs.getString("mno"));
        show_onz.add(sw_no);
        sw_no.setBounds(10, 40, 120, 15);

        sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
        show_onz.add(sw_name);
        sw_name.setBounds(10, 20, 120, 15);
        
        String day = " ";
                   try {
                       int i = Integer.parseInt(mysqlitem.rs.getString("day"));
                       if (i == 1) {
                           day = "day";
                       } else {
                           day = "night";
                       }
                   } catch (Exception e) {
                   }

        sw_othr.setText(day);
        show_onz.add(sw_othr);
        sw_othr.setBounds(160, 20, 59, 15);

        
                   
                   
          
        show_reslut_clicabl.add(show_onz);         
                   
        
                   System.err.println("ddddd"+day);
                   
        
        
        
         
//show_onz.setBounds(0, 0, 320, 60);
 


sw_user_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

sw_user_id.setForeground(new java.awt.Color(255,51,0));

sw_name.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N

sw_name.setForeground(new java.awt.Color(0,0,153));
        
sw_no.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

sw_no.setForeground(new java.awt.Color(153,0,153));
        
sw_othr.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N

sw_othr.setForeground(new java.awt.Color(0,102,102));
        




byte[] imagedata = mysqlitem.rs.getBytes("icon");
                ImageIcon format = null;

                outputimg = imagedata;
                
InputStream in = new ByteArrayInputStream(imagedata);
                
                BufferedImage inputImage = ImageIO.read(in );

            
                

            BufferedImage outputImage = resizeImage(inputImage, inputImage.getWidth(), inputImage.getHeight(), sw_img.getWidth(), sw_img.getHeight());

            
            
            format = new ImageIcon(outputImage);
            sw_img.setIcon(format);
            
            
            
            
            
        
            
            
            
          show_reslut_clicabl.repaint();
           show_reslut_clicabl.revalidate();
        
       
        
               } catch (Exception e) {
               }
 

               
y+=23;
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
    
    
    
    
    
    
    void sw_user_idMouseClicked(MouseEvent evt) {
        
        JLabel jLabel = null;
        
        try {
            jLabel  = (JLabel) evt.getSource(); 
        } catch (Exception e) {
        }
        
        String actual_id = jLabel.getText();
        
        System.err.println(" the is selcted "+actual_id);
        viewThisIdDetails(actual_id );
    }
             
    
    
    
    
    void viewThisIdDetails( String id ) {
        
             
        MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT * FROM employee WHERE  empid='"+id+"' AND satus='employee'";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);
           

           
             
           while( mysqlitem.rs.next()){ 
               try {
                   
         
                   

 //       sw_name.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
 
        
user_name3.setText(mysqlitem.rs.getString("empid"));
name2.setText(mysqlitem.rs.getString("fname")+" "+mysqlitem.rs.getString("lname"));
dob1.setText(""+mysqlitem.rs.getDate("dob"));
age1.setText(""+mysqlitem.rs.getInt("age"));
praddr1.setText(mysqlitem.rs.getString("praddress"));
email1.setText(mysqlitem.rs.getString("email"));
mobile1.setText(""+mysqlitem.rs.getBigDecimal("mno"));
join_date1.setText(""+mysqlitem.rs.getDate("sdate"));
out_date11.setText(""+mysqlitem.rs.getDate("edate"));


peaddr1.setText(mysqlitem.rs.getString("peaddress"));
salary1.setText(""+mysqlitem.rs.getInt("salary"));
Telephone1.setText(""+mysqlitem.rs.getBigDecimal("lno"));
qualification1.setText(mysqlitem.rs.getString("qualification"));


String day = " not assigned ";
                   try {
                       int i = mysqlitem.rs.getInt("day");
                       if (i == 1) {
                           day = "day";
                       } else {
                           day = "night";
                       }
                   } catch (Exception e) {
                   }

duty1.setText(day);

day = " not assigned ";
                   try {
                       String i = mysqlitem.rs.getString("gender");
                       if (i.equals("M")) {
                           day = "male";
                       } else {
                           day = "female";
                       }
                   } catch (Exception e) {
                   }

gender1.setText(day);


 byte[] imagedata = mysqlitem.rs.getBytes("icon");
                ImageIcon format = null;

                outputimg = imagedata;
                format = new ImageIcon(imagedata);
                image_h1.setIcon(format);
        
        
       
        replaceLayer(innr_menu_main_a02, show_rslt);
        
        
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
      
      private void user_idMouseClicked(java.awt.event.MouseEvent evt) {                                     
   
        try {
            int ifany=0;
              // SessionIdentifierGenerator h=new SessionIdentifierGenerator();
        boolean quk=true;
  String g="PMAD";
        while(quk)
        {
             int d=0;
        try {
                    d = countResult("select count(*) from employee");
        } catch (Exception e) {
        }
         finally
        {
               Random rand = new Random(); 
            g="pmAD"+(d+1)+rand.nextInt(9)+rand.nextInt(99);
            
            
         MysqlConnect mysqlitem = new MysqlConnect();
           mysqlitem.crearedatabase();
String query = "SELECT empid FROM employee WHERE satus='employee'";// WHERE empid= '"++"' AND status='employee'";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.con.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);

           int y=10;
           while( mysqlitem.rs.next()){ 
      
System.out.println("success 1 :"+g+"success 2 :"+mysqlitem.rs.getString("empid"));         
              if(g.equals(mysqlitem.rs.getString("empid")))
                 quk=false; 
             }

           
           if(quk)
               break;
           ifany++;
           
System.out.println("success");
mysqlitem.rs.close();
               mysqlitem.p.close();
            mysqlitem.con.close();
            
            
           if(ifany>30)
               break; 
 }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }
        }
       
        }
        
user_name1.setText(g);

        } catch (Exception e) {
        }
        finally
        {
            
        }

// TODO add your handling code here: // // // /  ////viewallbusid
    }                                    

     
    
    void submitButonAction() {

        int xcptn_chk = 1;
        ///////today
        ////////////////

        /////////////////////////////////////////////////////////////// submitButonAction
        String stringsdate = "";
        String morfv = "";
        //String dob_s = "";
        String enddate = "";
        String dobout = "";
        int todayint = 0;
        int dobint = 0;
        int tmp = 0;
        
        String emailL = "NULL";        
        String land = "NULL";
        
        
            String dorn = "";
        Boolean bv = true;
            String outdt = "NULL";
        try {

            
            
              if (jRadioButton1.isSelected()) {
                  outdt = "NULL";
        } else {
                  outdt= "'"+out_date1.getText()+"'";
              }
            
            
            // fdob.add(Calendar.YEAR,56);
            
           //  fdob.add(Calendar.YEAR,-18); 
             
            
           
                 
             Calendar sddate1 = Calendar.getInstance();
             sddate1.setTime(sdfhz.parse(join_date.getText()));
              
             Calendar sddate2 = Calendar.getInstance();
             sddate2.setTime(sdfhz.parse(out_date1.getText()));
             
           
             sddate1.add(Calendar.MONTH,1); 
             
            
             
            
             
            
            
            
            

            if (c1.isSelected() == true) {
                System.out.println("true");
                morfv = "M";
            }
            if (c2.isSelected() == true) {
                System.out.println("flse");
                morfv = "F";
            }


            if (v1.isSelected() == true) {
                dorn = "1";
            }
            if (v2.isSelected() == true) {
                dorn = "0";
            }

            // jok.setErrorForTextField("String message", fname, this, 5000);
            if (user_name1.getText().length() == 0) {

                //jok.dispalyEroorMessage("Please fill this field", 620, 250, 5000 );
                jok.setErrorForTextField("Please fill this field", user_name1, this, 5000);
                bv = false;

            }
            /* else */ if (fname.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 300, 5000 );
                jok.setErrorForTextField("Please fill this field", fname, this, 5000);
                bv = false;

            }
            /* else */ if (lname.getText().length() == 0) {

                // jok.dispalyEroorMessage("Please fill this field", 620, 350, 5000 );
                jok.setErrorForTextField("Please fill this field", lname, this, 5000);
                bv = false;

            }
            /* else */ if (age.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 400, 5000 );
                jok.setErrorForTextField("Please fill this field", this.dob, this, 5000);
                bv = false;

            }
            /* else */ if (morfv.length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 500, 5000 );
                jok.setErrorForTextField("Please fill this field", jLayeredPane1, this, 5000);
                bv = false;

            }
            /* else */ if (praddr.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 620, 560, 5000 );
                jok.setErrorForTextField("Please fill this field", jScrollPane2, this, 5000);
                bv = false;

            }
            /* else */ if (peaddr.getText().length() == 0) {

//    jok.dispalyEroorMessage("Please fill this field", 980, 500, 5000 );
                jok.setErrorForTextField("Please fill this field", jScrollPane3, this, 5000);
                bv = false;

            }
            /* else */ if (email.getText().length() == 0) {
//  jok.dispalyEroorMessage("Please fill this field", 620, 650, 5000 );

              //  jok.setErrorForTextField("Please fill this field", email, this, 5000);
               // bv = false;

            } else 
                emailL = "'"+email.getText()+"'";
            
            /* else */ if (mobile.getText().length() == 0) {
//  jok.dispalyEroorMessage("Please fill this field", 620, 700, 5000 );

                jok.setErrorForTextField("Please fill this field", mobile, this, 5000);
                bv = false;

            }
            /* else */ if (Telephone.getText().length() == 0) {

                //jok.dispalyEroorMessage("Please fill this field", 980, 700, 5000 );
               // jok.setErrorForTextField("Please fill this field", Telephone, this, 5000);
             //   bv = false;

            } else 
                land = "'"+ Telephone.getText()+"'";
            
            /* else */ if (dorn.length() == 0) {

//    jok.dispalyEroorMessage("Please select one", 980, 350, 5000 );
                jok.setErrorForTextField("Please select one", jLayeredPane2, this, 5000);
                bv = false;

            }
            /* else */ if (salary.getText().length() == 0) {
                //jok.dispalyEroorMessage("Please fill this field", 980, 650, 5000 );

                jok.setErrorForTextField("Please fill this field", salary, this, 5000);
                bv = false;

            }
            /* else */ if (path.getText().length() == 0) {

//  jok.dispalyEroorMessage("Please select an image", 1130, 480, 5000 );
                jok.setErrorForTextField("Please select an image", path, this, 5000);
                bv = false;
            }

//            Calendar f_c1 = Calendar.getInstance();
//            Calendar f_c2 = Calendar.getInstance();
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//            f_c1.setTime(sdf.parse(join_date.getText()));// all done
//            f_c2.setTime(sdf.parse(out_date1.getText()));// all done
//            System.err.println("" + f_c1.getTime());
//            System.err.println("" + f_c2.getTime());
//
//            if (f_c2.getTime().before(f_c1.getTime())) {
//
//                //  jok.dispalyEroorMessage("Date of Birth :date of birth error", 980, 30, 5000 );
//                jok.setErrorForTextField("Date of Birth :date of birth error", this.dob, this, 5000);
//                bv = false;
//                return;
//            }

            if (!bv) {
                return;

            } else {

                String geMobno = mobile.getText();
//matches 10-digit numbers only
                String regexStr = "^[0-9]{10}$";
                if (!geMobno.matches(regexStr)) {
//     jok.dispalyEroorMessage("Please insert a valid mobile number", 620, 700, 5000 );
                    jok.setErrorForTextField("Please insert a valid mobile number", mobile, this, 5000);

                    return;
                }

                String eMailVa
                        = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String eMaiL = email.getText();
                if(!emailL.equals("NULL"))
                if (!eMaiL.matches(eMailVa)) {
//     jok.dispalyEroorMessage("Please insert a valid email id", 620, 650, 5000 );

                    jok.setErrorForTextField("Please insert a valid email id", email, this, 5000);
                    return;
                }

                int salaa = Integer.parseInt(salary.getText());
                if (salaa > 100000) //    jok.dispalyEroorMessage("invalid salary", 980, 650, 5000 );
                {
                    jok.setErrorForTextField("invalid salary", salary, this, 5000);
                }

                if(!land.equals("NULL"))
                 if (!(Telephone.getText().length() >= 10)) {

//    jok.dispalyEroorMessage("invalid Telephone number", 980, 700, 5000 );
                    jok.setErrorForTextField("invalid Telephone number", Telephone, this, 5000);
                    return;
                }
                
                   if (jRadioButton1.isSelected()) {
                   
        } else {
                 
                if(sddate2.getTime().before(sddate1.getTime())) {
                
                jok.setErrorForTextField("Please enter a valid date and/or select at least one month", out_date1, this, 5000);
                
                return;
            }
 }
               
            
                   if (mobile.getText().equals(Telephone.getText())) {
//     jok.dispalyEroorMessage("Please insert a valid mobile number", 620, 700, 5000 );
                    jok.setErrorForTextField("Please, mobile and Telephone numbers are same", mobile, this, 5000);

                    return;
                }
                  
                  

            }

            
            
            
            
            

          

 /////////////////////////////////////////////////////////////////////////////////////////////////////
 
 
 
	
         } catch (Exception e) {
        }

       
        
        String userid=user_name1.getText();
        String query="";
        ///////////////////////panno1.
        //    c
        try {
           MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
       
           
           query = "INSERT INTO `employee` "
                   +" (`empid`, `fname`, `lname`, `gender`, `age`, `dob`, `praddress`, `peaddress`, `mno`, `lno`, `email`, `qualification`, `day`, `sdate`, `edate`, `salary`, `icon` , `satus`)"
                   +" VALUES ('"+user_name1.getText()+"', '" + fname.getText() + "', '" + lname.getText() + "', '"+morfv+"', '" + age.getText()
                   + "', '"+dob.getText() + "', '"+praddr.getText()+"', '"+peaddr.getText()+"', '"+mobile.getText()
                   +"', "+land+", "+emailL+", '"+qualification.getSelectedItem().toString()+"', '"+dorn+"','"+join_date.getText()
                   +"', "+outdt+", '"+salary.getText()+"',?, 'employee')";
           
           
        System.out.println("       p "+query);

            mysqlitem.p = mysqlitem.con.prepareStatement(query);

            mysqlitem.p.setBytes(1, outputimg);

            int rs = mysqlitem.p.executeUpdate();

     
   xcptn_chk = 0;
            JOptionPane.showMessageDialog(this, new String("successfully added"));
            
            
// addInTheScrollPaneInMain(user_id.getText(),lname.getText(),fname.getText(),mphn.getText(),outputimg);
// addEmployeeToTheEmployeeShown();
 
setAllInTheEmplyeeNull() ;
               mysqlitem.p.close();
           mysqlitem.con.close();
       
            
        } catch (Exception e1) {
            if(xcptn_chk==1)
            {
                 xcptn_chk = 1;
            System.out.println("Eroarmmmmmmmmmmmmmme");
            System.out.println(e1);
            String error = String.valueOf(e1);
        
           // addError(error);//            ........................................................................................>>>>>>>>>>>>>>                       
                    
            }
           
            //JOptionPane.showMessageDialog(this,new String("Please fill in all fields"));
        }

        
            
        int gg=0;
        
        if (xcptn_chk == 0) {
           
            
                try {
 System.out.println("vvvvvvv");
    MysqlConnect mysqlitem = new MysqlConnect();
                 mysqlitem.crearedatabase();
                query = ""
                        + "INSERT INTO `login` (`user_name`, `password`, `type`) "
                        + "VALUES('" +userid+ "','employee','0')";
                
                System.out.println("vvvvvvv    nn    " + query);
                    mysqlitem.p = mysqlitem.con.prepareStatement(query);
                    mysqlitem.p.executeUpdate();

                    gg=1;
                    System.out.println("vvvvvvv    nn    ");
                 mysqlitem.rs.close();
                   mysqlitem.p.close();
                mysqlitem.con.close();
                   // maleNullAddEmployee();//............,,,,,,,,,
                } catch (Exception e1) {
                    if(gg==0)
                    {
                        System.out.println("error for login" +userid);
                    System.out.println(e1);
                    String error = String.valueOf(e1);
                    // addError(error);//            ........................................................................................>>>>>>>>>>>>>>                       
                    }
                    

                }

           
        }

        
        System.err.println(" las this action success or not bt it last ----------------------------- ****");
        
//        addDataToTable();//........................................................................................>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
        // TODO add your handling code here:displayDetailsmakeDispayEmployee
    }

    void selectImgOfEmployee() throws Exception {
        // TODO add your handling code here:

        try {
            //JFileChooser chooser =  new javax.swing.JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();
            path.setText(filename);
            File inputFile = new File(filename);
            BufferedImage inputImage = ImageIO.read(inputFile);

            if (!((inputImage.getWidth() >= image_h.getWidth()) && (inputImage.getHeight() >= image_h.getHeight()))) {
                JOptionPane.showMessageDialog(this, new String("not a valid image "));
                return;
            }

            BufferedImage outputImage = resizeImage(inputImage, inputImage.getWidth(), inputImage.getHeight(), image_h.getWidth(), image_h.getHeight());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String j = String.valueOf(inputImage.getType());
            ImageIO.write(outputImage, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            outputimg = imageInByte;
            baos.close();
            ImageIcon format = null;
            format = new ImageIcon(imageInByte);
            image_h.setIcon(format);

        } catch (Exception e) {
        }

//        inserIntoMysql();
    }

    void disaplayDeatisAtHome() {

        scroll_innr_base.setMinimumSize(new java.awt.Dimension(100, 800));

        scroll_innr_base.setPreferredSize(new java.awt.Dimension(100, 800));

        int height_ = 0;

        scroll_innr_base.removeAll();
        scroll_innr_base.repaint();
        scroll_innr_base.revalidate();

        
        
        
       
        
        
         String query = "SELECT * FROM `area_details` ORDER BY `area_details`.`date` DESC ";// WHERE route_id='long'";
       MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        
         System.out.println(query);
         
        try {

            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                
              

        
        
              

            javax.swing.JLayeredPane Each_main_b, setThisOne;

            Each_main_b = new javax.swing.JLayeredPane();
            JLabel jLabellbw2, jLabellbw3, jLabellbw4, jLabellbw5, jLabellbw6, jLabellbwTop;

            setThisOne = new javax.swing.JLayeredPane();
            jLabellbw2 = new javax.swing.JLabel();
            jLabellbw3 = new javax.swing.JLabel();
            jLabellbw4 = new javax.swing.JLabel();
            jLabellbw5 = new javax.swing.JLabel();
            jLabellbw6 = new javax.swing.JLabel();
            jLabellbwTop = new javax.swing.JLabel();

            Each_main_b.setMinimumSize(new java.awt.Dimension(330, 200));

            Each_main_b.setPreferredSize(new java.awt.Dimension(100, 200));
            Each_main_b.setLayout(new javax.swing.OverlayLayout(Each_main_b));

            setThisOne.setOpaque(true);
            setThisOne.setBackground(new Color(241,243,242));

            setThisOne.add(jLabellbw2);
            jLabellbw2.setBounds(0, 0, 70, 100);

           jLabellbw2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/ethoe.jpg"))); // NOI18N

            
            
            
            jLabellbw3.setText(mysqlitem.rs.getString("d_price"));
            setThisOne.add(jLabellbw3);
            jLabellbw3.setBounds(70, 70, 200, 20);
 
            jLabellbw4.setText(mysqlitem.rs.getString("date"));
            setThisOne.add(jLabellbw4);
            jLabellbw4.setBounds(70, 10, 200, 10);

            jLabellbw5.setText(mysqlitem.rs.getString("p_price"));
            setThisOne.add(jLabellbw5);
            jLabellbw5.setBounds(70, 50, 200, 20);

            jLabellbw6.setText(returnName (mysqlitem.rs.getInt("area_id")));
            setThisOne.add(jLabellbw6);
            jLabellbw6.setBounds(70, 30, 200, 20);

            
            jLabellbw4.setFont(new java.awt.Font("Arial", 0, 11)); 
            jLabellbw4.setForeground(new java.awt.Color(102, 102, 102));
            
            jLabellbw6.setFont(new java.awt.Font("Arial", 1, 15)); 
            jLabellbw6.setForeground(new java.awt.Color(51, 51, 52));
            
            
            
            Each_main_b.add(setThisOne);

            setThisOne.add(jLabellbwTop);
            jLabellbwTop.setBounds(0, 0, 330, 100);

            scroll_innr_base.add(Each_main_b);
            Each_main_b.setBounds(0, height_, 330, 100);

            height_ += 100;
            //   

            jLabellbwTop.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    mouseExitActionForView(evt, setThisOne,  jLabellbw2, jLabellbw6);
                }

                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    mouseEnteredActionForView(evt, setThisOne,  jLabellbw2, jLabellbw6); // NOI18N

                }
                
                 public void mouseClicked(java.awt.event.MouseEvent evt) {
                    mouseClickActionForView(evt, "");
                }
            });

            
            
            jLabellbw2.setMaximumSize(new java.awt.Dimension(80, 100));
            jLabellbw2.setMinimumSize(new java.awt.Dimension(80, 100));
            jLabellbw2.setPreferredSize(new java.awt.Dimension(80, 100));
            
           
            
        
        
            }

 mysqlitem.rs.close();
   mysqlitem.p.close();
mysqlitem.con.close();
        } catch (Exception e1) {
            System.out.println("Error 1"+e1);

        }
        
        
        
        

        scroll_innr_base.repaint();
        scroll_innr_base.revalidate();
        jScrollPane4.setViewportView(scroll_innr_base);

        
        
    }
    
    
    String returnName ( int id ) {
        
        String name = "";
         MysqlConnect mysqlitem = new MysqlConnect();
        mysqlitem.crearedatabase();
        try {

            String query = "SELECT * FROM area  WHERE id= "+id;// WHERE userid='"+tmpempid+"'";

           
            mysqlitem.p = mysqlitem.con.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {

                name = mysqlitem.rs.getString("area");
            }
            
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.con.close();
            System.out.println("success");
        } catch (Exception ob) {
            System.out.println(ob);
        }
        
        
        return name;
        
    }

    void mouseEnteredActionForView(java.awt.event.MouseEvent evt, JLayeredPane jLabel, JLabel img, JLabel img2) {
        try {

            jLabel.setBackground(new Color(77, 166, 200));
             img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/new-one.jpg"))); // NOI18N

            img2.setForeground(new java.awt.Color(255, 255, 255));
        } catch (Exception e) {
        }

        System.err.println("enteredddd");
    }

    void mouseExitActionForView(java.awt.event.MouseEvent evt, JLayeredPane jLabel, JLabel img, JLabel img2) {
        try {
            jLabel.setBackground(new Color(241,243,242));
             img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System_files/ethoe.jpg"))); // NOI18N
             
            img2.setForeground(new java.awt.Color(51, 51, 52));


        } catch (Exception e) {
        }
    }
    
    void mouseClickActionForView(java.awt.event.MouseEvent evt, String value) {
        System.err.println("error hog");
    }
    
    
    
    void  setTheNewCircleshow( int a, int b) {
        System.err.println(a+"test colr"+b);

      
//        //  load1.revalidate();

        // 
        Color c =  new Color(209,99,125);
        showFirstThisForLoad(440, 30, 200, 200, a, c);
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main_.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         c =  new Color(217,115,83);
        showFirstThisForLoad(440, 340, 200, 200, b, c);
        
    }
    
    
    void showFirstThisForLoad( int x, int y, int width, int height, int pers, Color col) {
        
        
        
        
        
       
           BufferedImage surface;
    
        surface = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);
        JLabel load1 = new JLabel(new ImageIcon(surface));
        
        
        load1.setMaximumSize(new java.awt.Dimension(200, 200));
        load1.setMinimumSize(new java.awt.Dimension(200, 200));
        load1.setOpaque(true);
        load1.setPreferredSize(new java.awt.Dimension(200, 200));
        home.add(load1);
        load1.setBounds(x, y, width, height);
        Graphics2D g_forLadT = (Graphics2D) surface.getGraphics();
        
        
        
        
        
        threadHthread= new Thread(
        new Runnable() {
            @Override
            public void run() {
                
                for (int i = 0; i <= pers; i+=5) {
                    
        drawAloadingCircle(g_forLadT, load1, pers-(pers-i), pers-(pers-i), " String belwMsg", col);
        
                    
                    try {
                        Thread.sleep(pers-i);
                    } catch (InterruptedException ex) {
                        
                    }
                }
                 g_forLadT.dispose();
                 load1.repaint();
//                 load1.repaint();
                 
                 threadHthread.stop();
                        }
        });
        threadHthread.start();
    }
    
    
    
    void drawAloadingCircle( Graphics2D g, JLabel load1, int persent, int pers_st,  String belwMsg, Color colour) {
        
        
//String  = " to days message is ";

float resu = (persent * 360)/100;
        System.err.println(pers_st);
        
   
    
         g.setColor(new Color(204,204,204));
        g.fillRect(400,400,200,200);
         
         
        
         g.setColor(new Color(212,216,223));
         
    Shape inner = new Ellipse2D.Double(405,405, 190, 190);
    Shape outer = new Arc2D.Double(400, 400, 200, 200, 10, 360, Arc2D.PIE);
    Area area0 = new Area(outer);
    area0.subtract(new Area(inner));
          g.draw(area0);
          g.fill(area0);
        
         g.setColor(new Color(156,167,172));
          g.setFont(new Font("Arial", 1, 12)); 
          g.drawString(belwMsg, 445, 540);
          
          
         g.setColor(new Color(63,80,89));
          g.setFont(new Font("Arial", 0, 60)); 
          g.drawString(pers_st+"%", 445, 520);
        
         g.setColor(colour);
         
         
      inner = new Ellipse2D.Double(410,410, 180, 180);
      outer = new Arc2D.Double(400, 400, 200, 200, 90, resu, Arc2D.PIE);
    Area area = new Area(outer);
    area.subtract(new Area(inner));
          g.draw(area);
          g.fill(area);
         
       // g.dispose();
        
        
        load1.repaint();
        
        
        
        //212,216,223
        
        //209,99,125
        
        //217,115,83
        
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
            java.util.logging.Logger.getLogger(Main_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane AVAILABLE_STOCK;
    private javax.swing.JLayeredPane Each_main_b;
    private javax.swing.JLabel HEAD;
    private javax.swing.JLayeredPane IMPORTED_STOCK;
    private javax.swing.JLayeredPane SALES_INFO;
    private javax.swing.JTextField Telephone;
    private javax.swing.JLabel Telephone1;
    private javax.swing.JTextField Telephone2;
    private javax.swing.JLabel aarea;
    private javax.swing.JLayeredPane about;
    private javax.swing.JDialog add_new;
    private javax.swing.JLabel adprice;
    private javax.swing.JTextField age;
    private javax.swing.JLabel age1;
    private javax.swing.JTextField age2;
    private javax.swing.JComboBox<String> all_emplo;
    private javax.swing.JLabel alstpr;
    private javax.swing.JTextField amount1;
    private javax.swing.JTextField amount2;
    private javax.swing.JLabel aoprice;
    private javax.swing.JLabel apincd;
    private javax.swing.JLabel apprice;
    private javax.swing.JTextField area;
    private javax.swing.JTextField area1;
    private javax.swing.JLabel area_id_h;
    private javax.swing.JLabel astate;
    private javax.swing.JLabel base;
    private javax.swing.JLabel bg_Image;
    private javax.swing.JLayeredPane bk_img;
    private javax.swing.JLayeredPane bs_main;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton c1;
    private javax.swing.JRadioButton c2;
    private javax.swing.JRadioButton c3;
    private javax.swing.JRadioButton c4;
    private javax.swing.JDialog change_passwd;
    private javax.swing.JFileChooser chooser;
    private javax.swing.JLabel darea;
    private javax.swing.JLabel ddd1;
    private javax.swing.JLabel ddd3;
    private javax.swing.JLabel dddd2;
    private javax.swing.JTextField deaker;
    private javax.swing.JTextField deaker1;
    private javax.swing.JLayeredPane dfdfdf;
    private javax.swing.JLabel diesel;
    private javax.swing.JLabel dlitr1;
    private datechooser.beans.DateChooserCombo dob;
    private javax.swing.JLabel dob1;
    private datechooser.beans.DateChooserCombo dob2;
    private javax.swing.JTextField dprice;
    private javax.swing.JTextField dprice1;
    private javax.swing.JLabel dsptime;
    private javax.swing.JLabel dsptoday;
    private javax.swing.JLabel dtotals;
    private javax.swing.JLabel dtotals1;
    private javax.swing.JLabel dtotl;
    private javax.swing.JLabel dtotl1;
    private javax.swing.JTextField dup;
    private javax.swing.JLabel duty1;
    private javax.swing.JLayeredPane dver1;
    private javax.swing.JLayeredPane dver2;
    private javax.swing.JLayeredPane dver3;
    private javax.swing.JTextField email;
    private javax.swing.JLabel email1;
    private javax.swing.JTextField email2;
    private javax.swing.JTextArea ffffabout;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fname1;
    private javax.swing.JLabel fontDi1;
    private javax.swing.JLabel fontDi2;
    private javax.swing.JLabel fr1;
    private javax.swing.JLabel fr2;
    private javax.swing.JLabel gender1;
    private javax.swing.JLabel hidden_id;
    private javax.swing.JLayeredPane home;
    private javax.swing.JLabel image_h;
    private javax.swing.JLabel image_h1;
    private javax.swing.JLabel image_h2;
    private javax.swing.JLabel inn_menu_bg1;
    private javax.swing.JLabel inn_menu_bg2;
    private javax.swing.JLabel inn_menu_bg3;
    private javax.swing.JLayeredPane innr_head_a1;
    private javax.swing.JLayeredPane innr_head_a2;
    private javax.swing.JLayeredPane innr_head_a3;
    private javax.swing.JLayeredPane innr_main_menu0;
    private javax.swing.JLayeredPane innr_menu;
    private javax.swing.JLabel innr_menu_a1;
    private javax.swing.JLabel innr_menu_a2;
    private javax.swing.JLabel innr_menu_a3;
    private javax.swing.JLayeredPane innr_menu_bg;
    private javax.swing.JLayeredPane innr_menu_main_a01;
    private javax.swing.JLayeredPane innr_menu_main_a02;
    private javax.swing.JLayeredPane innr_menu_main_a03;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane11;
    private javax.swing.JLayeredPane jLayeredPane12;
    private javax.swing.JLayeredPane jLayeredPane13;
    private javax.swing.JLayeredPane jLayeredPane14;
    private javax.swing.JLayeredPane jLayeredPane15;
    private javax.swing.JLayeredPane jLayeredPane16;
    private javax.swing.JLayeredPane jLayeredPane17;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField8;
    private datechooser.beans.DateChooserCombo join_date;
    private javax.swing.JLabel join_date1;
    private datechooser.beans.DateChooserCombo join_date2;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lname1;
    private javax.swing.JLayeredPane main0;
    private javax.swing.JLayeredPane main1;
    private javax.swing.JLayeredPane main_display;
    private javax.swing.JLayeredPane main_forStk;
    private javax.swing.JLayeredPane maintop_top;
    private javax.swing.JLayeredPane meanu_head1;
    private javax.swing.JLabel meanu_head1_1;
    private javax.swing.JLabel meanu_head1_2;
    private javax.swing.JLayeredPane meanu_head2;
    private javax.swing.JLabel menu_bg1;
    private javax.swing.JLabel menu_bg2;
    private javax.swing.JLabel menu_bg3;
    private javax.swing.JLabel menu_bg4;
    private javax.swing.JLabel menu_bg5;
    private javax.swing.JLayeredPane menu_head;
    private javax.swing.JLayeredPane menu_main;
    private javax.swing.JLayeredPane menu_main_a1;
    private javax.swing.JLayeredPane menu_main_a2;
    private javax.swing.JLayeredPane menu_main_a3;
    private javax.swing.JLayeredPane menu_main_a4;
    private javax.swing.JLayeredPane menu_main_a5;
    private javax.swing.JLabel menu_word1;
    private javax.swing.JLabel menu_word2;
    private javax.swing.JLabel menu_word3;
    private javax.swing.JLabel menu_word4;
    private javax.swing.JLabel menu_word5;
    private javax.swing.JLayeredPane mesure_display;
    private javax.swing.JTextField mobile;
    private javax.swing.JLabel mobile1;
    private javax.swing.JTextField mobile2;
    private javax.swing.JTextArea msg_dsc;
    private javax.swing.JLabel msg_hhd;
    private javax.swing.JLabel msg_img;
    private javax.swing.JLabel name2;
    private javax.swing.JTextField oprice;
    private javax.swing.JTextField oprice1;
    private datechooser.beans.DateChooserCombo out_date1;
    private javax.swing.JLabel out_date11;
    private datechooser.beans.DateChooserCombo out_date2;
    private javax.swing.JLabel parea;
    private javax.swing.JPasswordField passwrd1;
    private javax.swing.JPasswordField passwrd2;
    private javax.swing.JPasswordField passwrd3;
    private javax.swing.JTextField path;
    private javax.swing.JTextField path1;
    private javax.swing.JTextArea peaddr;
    private javax.swing.JTextArea peaddr1;
    private javax.swing.JTextArea peaddr2;
    private javax.swing.JLabel petrol;
    private javax.swing.JLabel pimpto;
    private javax.swing.JLabel pimpto1;
    private javax.swing.JTextField pincd;
    private javax.swing.JTextField pincd1;
    private javax.swing.JLabel plitr1;
    private javax.swing.JLabel ppp1;
    private javax.swing.JTextField pprice;
    private javax.swing.JTextField pprice1;
    private javax.swing.JTextArea praddr;
    private javax.swing.JTextArea praddr1;
    private javax.swing.JTextArea praddr2;
    private javax.swing.JTextField price;
    private javax.swing.JTextField price1;
    private javax.swing.JLabel pseeltot;
    private javax.swing.JLabel pseeltot1;
    private javax.swing.JTextField pup;
    private javax.swing.JComboBox<String> qualification;
    private javax.swing.JLabel qualification1;
    private javax.swing.JComboBox<String> qualification2;
    private javax.swing.JLabel s3d1;
    private javax.swing.JLabel s3d2;
    private javax.swing.JLabel s3d3;
    private javax.swing.JLabel s3d4;
    private javax.swing.JLabel s3d5;
    private javax.swing.JLabel s3d6;
    private javax.swing.JTextField salary;
    private javax.swing.JLabel salary1;
    private javax.swing.JTextField salary2;
    private javax.swing.JLayeredPane scroll_innr_base;
    private javax.swing.JLayeredPane search_one;
    private javax.swing.JTextField searchfield;
    private javax.swing.JComboBox<String> select_deta_plz;
    private javax.swing.JDialog select_font;
    private javax.swing.JLabel selected_fon;
    private datechooser.beans.DateChooserCombo showDate;
    private javax.swing.JLayeredPane show_all;
    private javax.swing.JDialog show_error;
    private javax.swing.JLayeredPane show_reslut_clicabl;
    private javax.swing.JLayeredPane show_rslt;
    private javax.swing.JLayeredPane staff;
    private javax.swing.JTextField state;
    private javax.swing.JTextField state1;
    private javax.swing.JLayeredPane stock;
    private javax.swing.JTextField to_date;
    private javax.swing.JTextField to_date1;
    private javax.swing.JTextField total;
    private javax.swing.JTextField total1;
    private javax.swing.JDialog update_data;
    private javax.swing.JTextField user_name1;
    private javax.swing.JLabel user_name3;
    private javax.swing.JRadioButton v1;
    private javax.swing.JRadioButton v2;
    private javax.swing.JRadioButton v3;
    private javax.swing.JRadioButton v4;
    private javax.swing.JLayeredPane view_fonts;
    // End of variables declaration//GEN-END:variables

    String filename;
    byte[] person_image;
    byte[] outputimg;
     Thread  threadHthread ;

     int show_mesu1 = 0, show_mesu2 = 0 ;
     
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
            
     String bip = "oringz-w431.mp3";
//Media hit = new Media(bip);
Media hit = new Media(new File(bip).toURI().toString());
MediaPlayer mediaPlayer = new MediaPlayer(hit);

mediaPlayer.play(); 

        } catch (Exception e) {
        }
        
          
        int ds = (int) (width-360);
        show_error.setLocation(ds, 10);
        show_error.setVisible(true);
        
        
    }
    
    
    
    private void updateComponent(Component c, FontUIResource resource) {
    if (c == null) {
        return;
    }
    if (c instanceof JComponent) {
        JComponent jc = (JComponent) c;
        jc.updateUI();
        JPopupMenu jpm = jc.getComponentPopupMenu();
        if (jpm != null) {
            updateComponent(jpm, resource);
        }
    }
    Component[] children = null;
    if (c instanceof JMenu) {
        children = ((JMenu) c).getMenuComponents();
    }
    else if (c instanceof Container) {
        children = ((Container) c).getComponents();
    }
    if (children != null) {
        for (Component child : children) {
            if (child instanceof Component) {
                updateComponent(child, resource);
            }
        }
    }
    int style = Font.PLAIN;
    Font f = c.getFont();
    if (f == null) {
        f = getFontUIResource(16); // default
    }
    if (f.isBold()) {
        style = Font.BOLD;
    }
    else if (f.isItalic()) {
        style = Font.ITALIC;
    } 
      int sizz = 12;
              try {
 sizz = f.getSize();            
        } catch (Exception e) {
        }
    if (c instanceof JEditorPane) {
        ((JEditorPane) c).putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    }
    
        try {
            
    c.setFont(resource.deriveFont(style, sizz));
        } catch (Exception e) {
             c.setFont(resource.deriveFont(style));
        }
    
}
    
        private FontUIResource getFontUIResource(int size) {
            return new FontUIResource(new Font("Arial", Font.PLAIN, size));
        }
    
        
            void actionForSetThis(Component cThis, FontUIResource resource) {
          
java.util.List<Component> comps = getAllComponents((Container) cThis) ;

        for (Component c : comps) {

            

            try {
                 int style = Font.PLAIN;
    Font f = c.getFont();
    if (f == null) {
        f = getFontUIResource(16); // default
    }
    if (f.isBold()) {
        style = Font.BOLD;
    }
    else if (f.isItalic()) {
        style = Font.ITALIC;
    } 
      int sizz = 12;
              try {
 sizz = f.getSize();            
        } catch (Exception e) {
        }
    if (c instanceof JEditorPane) {
        ((JEditorPane) c).putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    }
    
        try {
            
    c.setFont(resource.deriveFont(style, sizz));
        } catch (Exception e) {
             c.setFont(resource.deriveFont(style));
        }
    
            } catch (Exception e) {
            }
        }
        

    }
    
  void createAsettingFile(String font) {
      try {
          
          FileOutputStream out = new FileOutputStream("font.settings");
          String s = font;
          byte buf[] = s.getBytes();
          try {
              
out.write(buf);
          } catch (Exception e) {
          }
          finally{
              
out.close();
          }

      } catch (Exception e) {
      }
  }
  
  void setAsFont() { 
     String everything = "";
     

      try {
          
        

      BufferedReader br = new BufferedReader(new FileReader("font.settings"));
try {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
     everything = sb.toString();
} finally {
    br.close();
}
      } catch (Exception e) {
      }

      
      System.err.println(" ne font is "+everything);
     
      
       try {
            
           updateComponent(jDesktopPane1, new javax.swing.plaf.FontUIResource(everything.trim(), Font.ITALIC, 12));
        // actionForSetThis(this, new javax.swing.plaf.FontUIResource(everything, Font.ITALIC, 12));
        } catch (Exception e) {
        }
  }
  
  
  
  public void restartApplication() throws URISyntaxException, IOException
{
    
          StringBuilder cmd = new StringBuilder();
            cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
            for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
                cmd.append(jvmArg + " ");
            }
            cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
            cmd.append(Window.class.getName()).append(" ");

            try {
                Runtime.getRuntime().exec(cmd.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.exit(0);
    
}
  
  
  
  
  
  
    void setAbout() { 
     String everything = "";
     

      try {
          
        

      BufferedReader br = new BufferedReader(new FileReader("about.settings"));
try {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
     everything = sb.toString();
} finally {
    br.close();
}
      } catch (Exception e) {
      }

      
      System.err.println(" ne font is "+everything);
     
      
       try {
            
         ffffabout.setText(everything);
           
        // actionForSetThis(this, new javax.swing.plaf.FontUIResource(everything, Font.ITALIC, 12));
        } catch (Exception e) {
        }
  }
  
  
}
