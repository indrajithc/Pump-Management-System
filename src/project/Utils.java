/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author indrajith
 */
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
/**
 * Encapsulates various utilities for windows (ie: <code>Frame</code> and
 * <code>Dialog</code> objects and descendants, in particular).
 *
 * @author Richard Bair
 */
public class Utils {
  public static List<Component> getAllComponents(final Container c) {
    Component[] comps = c.getComponents();
    List<Component> compList = new ArrayList<Component>();
    for (Component comp : comps) {
      compList.add(comp);
      if (comp instanceof Container) {
        compList.addAll(getAllComponents((Container) comp));
      }
    }
    return compList;
  }

}