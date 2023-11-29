package com.gccg.soundscape;

import com.gccg.soundscape.vistas.MenuPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @@author Genesis C - Christopher G
 */
public class SoundScape {

    public static void main(String[] args) {
        
        SoundScape.iniciar();
        
    }
    
    public static void iniciar(){
        System.out.println("Iniciando SoundScape");
        MenuPrincipal menu = new MenuPrincipal();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}
