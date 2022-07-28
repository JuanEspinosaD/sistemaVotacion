package Vistas;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsMensaje;
import Controladores.CtlCandidato;
import Controladores.CtlEleccion;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Espinosa
 */
public class VistaGestorElecciones extends javax.swing.JFrame {

    CtlEleccion controlador = new CtlEleccion();
    LinkedList<ClsEleccion> listaElecciones;
    CtlCandidato controladorCandidato;
    LinkedList<ClsCandidato> listaCandidatos;
    JFrame menuPrincipal;

    /**
     * Creates new form VistaGestorElecciones
     */
    public VistaGestorElecciones(JFrame menuPrincipal) {
        initComponents();
        this.controlador = new CtlEleccion();
        this.listaElecciones = new LinkedList<>();
        this.listaCandidatos = new LinkedList<>();
        this.obtenerElecciones();
        this.controladorCandidato = new CtlCandidato();
        this.obtenerCandidatos();
        this.menuPrincipal = menuPrincipal;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboCantidato = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        botonAsociarCandidato = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCandidatosEleccion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        campoFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        campoFechaFin = new com.toedter.calendar.JDateChooser();
        botonVolver = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaElecciones = new javax.swing.JScrollPane();
        tablaElecciones1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Gestionar elección");

        jPanel2.setBackground(java.awt.Color.lightGray);

        comboCantidato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setText("Candidato");

        botonAsociarCandidato.setText("Asociar candidato");
        botonAsociarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsociarCandidatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAsociarCandidato)
                    .addComponent(jLabel5)
                    .addComponent(comboCantidato, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCantidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAsociarCandidato)
                .addGap(20, 20, 20))
        );

        botonEliminar.setText("Eliminar");

        botonEditar.setText("Editar");

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setText("Candidatos");

        tablaCandidatosEleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número de documento", "Nombre", "Partido"
            }
        ));
        jScrollPane1.setViewportView(tablaCandidatosEleccion);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setText("Categoría");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Presidencial", "Congreso", "Alcaldes", "Gobernadores" }));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("Fecha inicio");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("Fecha fin");

        botonVolver.setText("Volver al menú principal");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar");

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        tablaElecciones1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Elección", "Fecha inicio", "Fecha fin", "Estado", "Ganador"
            }
        ));
        tablaElecciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaElecciones1MouseClicked(evt);
            }
        });
        tablaElecciones.setViewportView(tablaElecciones1);

        jScrollPane2.setViewportView(tablaElecciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(230, 230, 230))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(324, 324, 324)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonActualizar)
                                    .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(156, 156, 156))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEliminar)
                            .addComponent(botonEditar)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(botonVolver))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(botonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonActualizar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEditar)
                        .addGap(7, 7, 7)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed

        String nombre = this.campoNombre.getText();
        String categoria = this.comboCategoria.getSelectedItem().toString();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        String fechaInicio = formato.format(this.campoFechaInicio.getDate());
        String fechaFin = formato.format(this.campoFechaFin.getDate());

        String[] arrayFecha = fechaInicio.split("-", 2);

        String idEleccion = nombre + arrayFecha[0] + "-" + categoria;

        ClsEleccion eleccionNueva = new ClsEleccion(idEleccion, nombre,
                fechaInicio, fechaFin, categoria);

        ClsMensaje mensaje = this.controlador.agregarEleccion(eleccionNueva);

        if (mensaje.getTipo().equals(ClsMensaje.OK)) {

            obtenerElecciones();
        }

        JOptionPane.showMessageDialog(rootPane, mensaje.getTexto());
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonAsociarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsociarCandidatoActionPerformed

        int columna = 0;
        int fila = this.tablaElecciones1.getSelectedRow();
        String idEleccion = this.tablaElecciones1.getValueAt(fila, columna).toString();

        String[] partesCombo = this.comboCantidato.getSelectedItem().toString().split("-");

        String idCandidato = partesCombo[1];

        ClsMensaje mensaje = this.controlador.asociarCandidato(idCandidato, idEleccion);

        if (mensaje.getTipo().equals(ClsMensaje.OK)) {

            this.obtenerCandidatosPorEleccion(idEleccion);
        }
    }//GEN-LAST:event_botonAsociarCandidatoActionPerformed

    private void tablaElecciones1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaElecciones1MouseClicked
        int columna = 0;
        int fila = this.tablaElecciones1.getSelectedRow();
        String idEleccion = this.tablaElecciones1.getValueAt(fila, columna).toString();
        this.obtenerCandidatosPorEleccion(idEleccion);
    }//GEN-LAST:event_tablaElecciones1MouseClicked

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.setVisible(false);
        this.menuPrincipal.setVisible(true);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void obtenerCandidatosPorEleccion(String idEleccion) {

        LinkedList<ClsCandidato> candidatos = this.controlador.obtenerCandidatosEleccion(idEleccion);
        this.actualizarTablaCandidatos(candidatos);

    }

    private void actualizarTablaCandidatos(LinkedList<ClsCandidato> lista) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaCandidatosEleccion.getModel();
        modelo.setRowCount(0);

        for (ClsCandidato c : lista) {

            Object[] fila = {
                c.getNumeroCedula(),
                c.getNombre(),
                c.getPartido()
            };

            modelo.addRow(fila);

        }

    }

    private void obtenerElecciones() {

        this.listaElecciones = this.controlador.obtenerElecciones();
        this.actualizarTabla(listaElecciones);
    }

    private void obtenerCandidatos() {

        this.listaCandidatos = this.controladorCandidato.obtenerCandidatos();
        this.actualizarCombo(listaCandidatos);
    }

    private void actualizarCombo(LinkedList<ClsCandidato> lista) {

        DefaultComboBoxModel model = (DefaultComboBoxModel) this.comboCantidato.getModel();
        model.removeAllElements();

        for (ClsCandidato candidato : lista) {
            model.addElement(candidato.getNombre() + "-" + candidato.getNumeroCedula());
        }

        this.comboCantidato.setModel(model);
    }

    private void actualizarTabla(LinkedList<ClsEleccion> lista) {

        DefaultTableModel modelo = (DefaultTableModel) this.tablaElecciones1.getModel();
        modelo.setRowCount(0);

        for (ClsEleccion c : lista) {
            Object[] fila = {
                c.getIdEleccion(),
                c.getDescripcion(),
                c.getFechaInicio(),
                c.getFechaFin(),
                c.getEstado(),
                ""
            };
            modelo.addRow(fila);

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaGestorElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestorElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestorElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestorElecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestorElecciones(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAsociarCandidato;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonVolver;
    private com.toedter.calendar.JDateChooser campoFechaFin;
    private com.toedter.calendar.JDateChooser campoFechaInicio;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> comboCantidato;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCandidatosEleccion;
    private javax.swing.JScrollPane tablaElecciones;
    private javax.swing.JTable tablaElecciones1;
    // End of variables declaration//GEN-END:variables
}
