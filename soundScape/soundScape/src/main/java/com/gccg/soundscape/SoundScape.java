package com.gccg.soundscape;

import com.gccg.soundscape.vistas.MenuPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @@author Genesis C - Christopher G
 */
public class SoundScape {

    public static void main(String[] args) {
        
        SoundScape.iniciar();
        
    }
    
    public static void iniciar(){
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        System.out.println("Iniciando SoundScape");
        MenuPrincipal menu = new MenuPrincipal();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}
