package com.gccg.soundscape.vistas;

import com.gccg.soundscape.controlador.ArtistController;
import com.gccg.soundscape.controlador.GenereController;
import com.gccg.soundscape.controlador.SongController;
import com.gccg.soundscape.modelos.Artist;
import com.gccg.soundscape.modelos.Genere;
import com.gccg.soundscape.modelos.Song;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author UTEM
 */
public class FormularioCancion extends javax.swing.JFrame {

    private int idModificacion;
    private final SongController sc;
    private final ArtistController ac;
    private final GenereController gc;

    /**
     * Creates new form VistaPrincipal
     */
    public FormularioCancion() {
        super("Agregar canción");
        initComponents();
        this.iniciarAnnoDuracion();
        this.sc = new SongController();
        this.ac = new ArtistController();
        this.gc = new GenereController();
        List<Artist> artistList = this.ac.listarArtistas();
        this.listArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(artistList.toArray(new Artist[0])));
        List<Genere> genereList = this.gc.listarGeneros();
        this.listGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(genereList.toArray(new Genere[0])));
    }

    //Modificar
    public FormularioCancion(Song cancion, String title) throws HeadlessException {
        super(title);
        initComponents();
        this.sc = new SongController();
        this.ac = new ArtistController();
        this.gc = new GenereController();
        this.iniciarAnnoDuracion();

        this.idModificacion = cancion.getId();
        List<Artist> artistList = this.ac.listarArtistas();
        this.listArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(artistList.toArray(new Artist[0])));
        this.listArtistas.setSelectedItem(cancion.getArtista());

        List<Genere> genereList = this.gc.listarGeneros();
        System.out.println(genereList);
        this.listGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(genereList.toArray(new Genere[0])));
        this.listGeneros.setSelectedItem(cancion.getGenero());

        this.txtFldAnno.setText(Integer.toString(cancion.getAnio()));
        this.txtFldTitulo.setText(cancion.getTitulo());
        this.txtFldDuracion.setText(Integer.toString(cancion.getDuracion()));
        this.idModificacion = cancion.getId();
        this.btnLimpiar.setEnabled(false);
        this.btnAgregar.setText("Modificar");
    }

    private void atras() {
        ListaDeElementos lista = new ListaDeElementos(TipoLista.CANCION, "Canciones");
        lista.setSize(440, 320);
        lista.setLocationRelativeTo(null);
        lista.setVisible(true);
        dispose();
    }

    private void iniciarAnnoDuracion() {
        this.txtFldAnno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarContenidoAnno();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarContenidoAnno();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarContenidoAnno();
            }
        });
        this.txtFldDuracion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarContenidoDuracion();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarContenidoDuracion();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarContenidoDuracion();
            }
        });
    }

    private void verificarContenidoAnno() {
        String texto = this.txtFldAnno.getText();

        try {
            Integer.parseInt(texto);
        } catch (NumberFormatException ex) {
            if (!texto.isEmpty()) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(FormularioCancion.this, "Por favor, ingresa solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                    this.txtFldAnno.setText("");
                });
            }
        }
    }

    private void verificarContenidoDuracion() {
        String texto = this.txtFldDuracion.getText();

        try {
            Integer.parseInt(texto);
        } catch (NumberFormatException ex) {
            if (!texto.isEmpty()) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(FormularioCancion.this, "Por favor, ingresa solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                    this.txtFldDuracion.setText("");
                });
            }
        }
    }

    private boolean existenCamposVacios() {
        if (this.txtFldAnno.getText().trim().isEmpty()
                || this.txtFldDuracion.getText().trim().isEmpty()
                || this.txtFldTitulo.getText().trim().isEmpty()) {
            return true;
        } else {
            return false;
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

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFldTitulo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtFldAnno = new javax.swing.JTextField();
        listArtistas = new javax.swing.JComboBox<>();
        listGeneros = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtFldDuracion = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel11.setText("Título");

        jLabel12.setText("Artista");

        jLabel13.setText("Año");

        jLabel14.setText("Género");

        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicAgregar(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicLimpiar(evt);
            }
        });

        jLabel1.setText("Duración");

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
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(31, 31, 31)
                            .addComponent(listArtistas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14))
                                    .addGap(31, 31, 31))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(20, 20, 20)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFldDuracion)
                                .addComponent(txtFldAnno)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFldTitulo)
                                        .addComponent(listGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(68, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtFldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtFldAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(listGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(listArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAgregar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void clicAtras(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicAtras
        // TODO add your handling code here:
        this.atras();
    }//GEN-LAST:event_clicAtras

    private void clicAgregar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicAgregar
        // TODO add your handling code here:

        if (!this.existenCamposVacios()) {
            Genere genero = (Genere) this.listGeneros.getSelectedItem();
            Artist artista = (Artist) this.listArtistas.getSelectedItem();
            Song cancion = new Song(
                    this.txtFldTitulo.getText(),
                    Integer.parseInt(this.txtFldAnno.getText()),
                    Integer.parseInt(this.txtFldDuracion.getText()),
                    artista, genero
            );
            SongController sc = new SongController();
            if (this.idModificacion == 0) {
                this.sc.crearCancion(cancion);
                JOptionPane.showMessageDialog(FormularioCancion.this,
                        "Se ha creado nuevo registro de canción.",
                        "Canción creada",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.sc.actualizarCancion(this.idModificacion, cancion);
                JOptionPane.showMessageDialog(FormularioCancion.this,
                        "Se ha modificado la canción seleccionada.",
                        "Canción modificada",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            this.atras();
        } else {
            JOptionPane.showMessageDialog(FormularioCancion.this,
                    "Debe rellenar todos los campos antes de continuar.",
                    "Existen campos vacío",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_clicAgregar

    private void clicLimpiar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicLimpiar
        // TODO add your handling code here:
        this.txtFldTitulo.setText("");
        this.txtFldAnno.setText("");
        this.txtFldDuracion.setText("");
        this.listArtistas.setSelectedIndex(0);
        this.listGeneros.setSelectedIndex(0);
    }//GEN-LAST:event_clicLimpiar

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
            java.util.logging.Logger.getLogger(FormularioCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioCancion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    public javax.swing.JComboBox<Artist> listArtistas;
    public javax.swing.JComboBox<Genere> listGeneros;
    public javax.swing.JTextField txtFldAnno;
    private javax.swing.JTextField txtFldDuracion;
    public javax.swing.JTextField txtFldTitulo;
    // End of variables declaration//GEN-END:variables
}
