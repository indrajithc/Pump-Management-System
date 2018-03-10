/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author digital
 */

public class MyScrollBarUI extends BasicScrollBarUI {

 

 @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle r) {}
      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar)c;
        if(!sb.isEnabled() || r.width>r.height) {
          return;
        }else if(isDragging) {
          color = new Color(0,0,0,200);
        }else if(isThumbRollover()) {
          color = new Color(77,166,200,200);
        }else {
          color = new Color(31,40,45,200);
        }
 
        g2.setPaint(color);
        g2.fillRoundRect(r.x+4,r.y,r.width-9,r.height,0,0);
        g2.setPaint(Color.WHITE);
        g2.drawRoundRect(r.x+4,r.y,r.width-9,r.height,0,0);
        g2.dispose();
      }
      @Override
      protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
      }
}