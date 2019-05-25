/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author UNI
 */
public class OpenFile {
    
    public static void main(String[] args) {
        
    Desktop desktop = null;

    File file = new File("/home/UNI/NetBeansProjects/Clinica/Expedientes/Nuvia Sanchez");
    if (Desktop.isDesktopSupported()) {
      desktop = Desktop.getDesktop();
    }
    try {
      desktop.open(file);
    }
    catch (IOException e){  }
  }
    
    
}
