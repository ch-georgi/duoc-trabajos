package com.gccg.soundscape.vistas;

import com.gccg.soundscape.controlador.ArtistController;
import com.gccg.soundscape.controlador.GenereController;
import com.gccg.soundscape.controlador.SongController;
import com.gccg.soundscape.modelos.Artist;
import com.gccg.soundscape.modelos.Genere;
import com.gccg.soundscape.modelos.Song;
import static com.gccg.soundscape.vistas.TipoLista.ARTISTA;
import static com.gccg.soundscape.vistas.TipoLista.CANCION;
import static com.gccg.soundscape.vistas.TipoLista.GENERO;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Myriam
 */
enum TipoLista {
    CANCION,
    ARTISTA,
    GENERO
}

public class ListaDeElementos extends javax.swing.JFrame {

    /**
     * Creates new form ListaDeCanciones
     */
    private TipoLista tipo;

    public ListaDeElementos() {
        initComponents();
    }

    public ListaDeElementos(TipoLista tipo, String title) throws HeadlessException {
        super(title);
        initComponents();
        this.tipo = tipo;

        switch (this.tipo) {
            case ARTISTA:
                this.tituloListaElementos.setText("Lista de artistas");
                break;
            case CANCION:
                this.tituloListaElementos.setText("Lista de canciones");
                break;
            case GENERO:
                this.tituloListaElementos.setText("Lista de generos");
                break;
            default:
                break;
        }
        this.recargarLista();

    }

    private void recargarLista(Object[] lista) {
        this.listElementos.setListData(lista);
        this.listElementos.revalidate();
        this.listElementos.repaint();
    }

    private void recargarLista() {
        switch (this.tipo) {
            case ARTISTA:
                ArtistController ac = new ArtistController();
                Object[] artistArray = ac.listarArtistas().toArray();
                this.listElementos.setListData(artistArray);
                this.listElementos.revalidate();
                this.listElementos.repaint();
                break;
            case CANCION:
                SongController sc = new SongController();
                Object[] songArray = sc.listarCanciones().toArray();
                this.listElementos.setListData(songArray);
                this.listElementos.revalidate();
                this.listElementos.repaint();
                break;
            case GENERO:
                GenereController gc = new GenereController();
                Object[] genereArray = gc.listarGeneros().toArray();
                this.listElementos.setListData(genereArray);
                this.listElementos.revalidate();
                this.listElementos.repaint();
                break;
            default:
                break;
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

        tituloListaElementos = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtFldBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        listElementos = new javax.swing.JList<>();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tituloListaElementos.setBackground(new java.awt.Color(102, 102, 102));
        tituloListaElementos.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        tituloListaElementos.setText("Titulo");
        tituloListaElementos.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicModificar(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicEliminar(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicAgregar(evt);
            }
        });

        txtFldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teclaEnterBuscar(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicBuscar(evt);
            }
        });

        listElementos.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listElementos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(listElementos);

        btnAtras.setText("Atrás");
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicAtras(evt);
            }
        });
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(tituloListaElementos))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(40, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(tituloListaElementos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void clicModificar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicModificar
        if (this.listElementos.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(ListaDeElementos.this,
                    "Por favor, selecciona un elemento a modificar.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            switch (this.tipo) {
                case ARTISTA:
                    Artist selectedArtist = (Artist) this.listElementos.getSelectedValue();
                    FormularioArtista formArts = new FormularioArtista("Modificando artista "
                            + selectedArtist.getNombre(), selectedArtist);
                    formArts.setLocationRelativeTo(null);
                    formArts.setVisible(true);
                    dispose();
                    break;
                case CANCION:
                    Song selectedSong = (Song) this.listElementos.getSelectedValue();
                    FormularioCancion formCanc = new FormularioCancion(selectedSong,
                            "Modificando cancion '"
                            + selectedSong.getTitulo() + "'");
                    formCanc.setLocationRelativeTo(null);
                    formCanc.setVisible(true);
                    dispose();
                    break;
                case GENERO:
                    Genere selectedGenere = (Genere) this.listElementos.getSelectedValue();
                    FormularioGenero formGen = new FormularioGenero("Modificando genero "
                            + selectedGenere.getGenero(), selectedGenere);
                    formGen.setLocationRelativeTo(null);
                    formGen.setVisible(true);
                    dispose();
                    break;
                default:
                    break;
            }
        }

    }//GEN-LAST:event_clicModificar

    private void clicEliminar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicEliminar
        // TODO add your handling code here:
        if (this.listElementos.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(ListaDeElementos.this,
                    "Por favor, selecciona un elemento a eliminar.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            switch (this.tipo) {
                case ARTISTA:
                    Artist selectedArtist = (Artist) this.listElementos.getSelectedValue();
                    ArtistController ac = new ArtistController();
                    ac.eliminarArtista(selectedArtist.getId());
                    break;
                case CANCION:
                    Song selectedSong = (Song) this.listElementos.getSelectedValue();
                    SongController sc = new SongController();
                    sc.eliminarCancion(selectedSong.getId());
                    break;
                case GENERO:
                    Genere selectedGenere = (Genere) this.listElementos.getSelectedValue();
                    GenereController gc = new GenereController();
                    gc.eliminarGenero(selectedGenere.getId());
                    break;
                default:
                    break;
            }
            this.recargarLista();
            JOptionPane.showMessageDialog(ListaDeElementos.this,
                    "Se ha eliminado el elemento seleccionado.",
                    "Elemento eliminado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_clicEliminar

    private void clicAgregar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicAgregar
        // TODO add your handling code here:
        switch (this.tipo) {
            case ARTISTA:
                FormularioArtista formArts = new FormularioArtista();
                formArts.setLocationRelativeTo(null);
                formArts.setVisible(true);
                dispose();
                break;
            case CANCION:
                FormularioCancion formCanc = new FormularioCancion();
                formCanc.setLocationRelativeTo(null);
                formCanc.setVisible(true);
                dispose();
                break;
            case GENERO:
                FormularioGenero formGen = new FormularioGenero();
                formGen.setLocationRelativeTo(null);
                formGen.setVisible(true);
                dispose();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_clicAgregar

    private void buscar(String termino) {
        if (termino.trim().isEmpty()) {
            this.recargarLista();
        } else {
            switch (this.tipo) {
                case ARTISTA:
                    ArtistController ac = new ArtistController();
                    List<Artist> artistas = ac.buscarArtistasPorNombre(termino.trim());
                    if (!artistas.isEmpty() && artistas != null) {
                        this.recargarLista(artistas.toArray());
                    } else {
                        this.listElementos.setListData(new Object[0]);
                        this.listElementos.revalidate();
                        this.listElementos.repaint();
                    }
                    break;
                case CANCION:
                    SongController sc = new SongController();
                    List<Song> canciones = sc.buscarCancionPorTitulo(termino.trim());
                    if (!canciones.isEmpty() && canciones != null) {
                        this.recargarLista(canciones.toArray());
                    } else {
                        this.listElementos.setListData(new Object[0]);
                        this.listElementos.revalidate();
                        this.listElementos.repaint();
                    }
                    break;
                case GENERO:
                    GenereController gc = new GenereController();
                    List<Genere> generos = gc.buscarGeneroPorNombre(termino.trim());
                    if (!generos.isEmpty() && generos != null) {
                        this.recargarLista(generos.toArray());
                    } else {
                        this.listElementos.setListData(new Object[0]);
                        this.listElementos.revalidate();
                        this.listElementos.repaint();
                    }
                    break;
                default:
                    break;
            }
        }

    }
    private void clicBuscar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicBuscar
        // TODO add your handling code here:
        this.buscar(this.txtFldBuscar.getText());
    }//GEN-LAST:event_clicBuscar

    private void teclaEnterBuscar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teclaEnterBuscar
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.buscar(this.txtFldBuscar.getText());
        }
    }//GEN-LAST:event_teclaEnterBuscar

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void clicAtras(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicAtras
        // TODO add your handling code here:
        MenuPrincipal menu = new MenuPrincipal();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_clicAtras

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaDeElementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDeElementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDeElementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDeElementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDeElementos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JList<Object> listElementos;
    private javax.swing.JLabel tituloListaElementos;
    private javax.swing.JTextField txtFldBuscar;
    // End of variables declaration//GEN-END:variables
}
