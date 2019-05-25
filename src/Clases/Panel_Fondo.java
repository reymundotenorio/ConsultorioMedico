/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author UNI
 */
public class Panel_Fondo extends JDesktopPane{
 
       private  Image IMG=new ImageIcon(getClass().getResource("/Images/historia-clinica.jpg")).getImage();
 
       @Override
        public void paintChildren(Graphics g){
            g.drawImage(IMG, 0, 0, getWidth(), getHeight(), this);
            super.paintChildren(g);
        }
}
