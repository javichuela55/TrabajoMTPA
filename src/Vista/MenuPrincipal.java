package Vista;

import java.awt.Color;
import java.awt.Font;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controlador.Cliente;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.TipoEnvio;

/**
 * Menu con el que interactua el cliente 
 * @author Guill
 *
 */
public class MenuPrincipal extends javax.swing.JFrame {
    Socket socket;
    Jugador j;
    Cliente cliente;

    public MenuPrincipal(Socket s, Jugador j, Cliente cliente){
        this.socket=s;
        this.j=j;
        this.cliente=cliente;
        initComponents();
        this.setTitle("Pantalla principal <"+j.getNombre()+">");
     
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnRetar = new javax.swing.JButton();
        btnRetar.setFont(new Font("Monospaced", Font.PLAIN, 13));
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnSalir = new javax.swing.JButton();
        btnSalir.setFont(new Font("Monospaced", Font.PLAIN, 13));
        jScrollPane4 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("DejaVu Serif", 1, 14)); 
        btnRetar.setText("Retar");
        btnRetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(jScrollPane2, Alignment.TRAILING)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
        						.addGap(18)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(btnRetar)
        							.addComponent(btnSalir))))
        				.addComponent(jScrollPane4))
        			.addGap(610))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(63, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnRetar)
        					.addGap(31)
        					.addComponent(btnSalir))
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
                jLabel2 = new javax.swing.JLabel();
                jLabel2.setForeground(Color.BLUE);
                jScrollPane2.setColumnHeaderView(jLabel2);
                jLabel2.setFont(new Font("Monospaced", Font.PLAIN, 13));
                
                        jLabel2.setText("Ranking Jugadores");
                        listRanking = new javax.swing.JList<>();
                        jScrollPane2.setViewportView(listRanking);
                        listRanking.setFont(new Font("Monospaced", Font.PLAIN, 13));
                        
                                listRanking.setModel(new javax.swing.AbstractListModel<String>() {
                                    String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                                    public int getSize() { return strings.length; }
                                    public String getElementAt(int i) { return strings[i]; }
                                });
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(Color.BLUE);
        jLabel1.setFont(new Font("Monospaced", Font.PLAIN, 13));
        jScrollPane1.setColumnHeaderView(jLabel1);
        
                jLabel1.setText("Jugadores Conectados");
                listConectados = new javax.swing.JList<>();
                listConectados.setFont(new Font("Monospaced", Font.PLAIN, 13));
                jScrollPane1.setViewportView(listConectados);
                
                        listConectados.setModel(new javax.swing.AbstractListModel<String>() {
                            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                            public int getSize() { return strings.length; }
                            public String getElementAt(int i) { return strings[i]; }
                        });
                jLabel3 = new javax.swing.JLabel();
                jLabel3.setForeground(Color.BLUE);
                jLabel3.setFont(new Font("Monospaced", Font.PLAIN, 13));
                jScrollPane4.setColumnHeaderView(jLabel3);
                
                        jLabel3.setText("Partidas finalizadas");
                        listFinalizadas = new javax.swing.JList<>();
                        jScrollPane4.setViewportView(listFinalizadas);
                        listFinalizadas.setFont(new Font("Monospaced", Font.PLAIN, 13));
                        
                                listFinalizadas.setModel(new javax.swing.AbstractListModel<String>() {
                                    String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
                                    public int getSize() { return strings.length; }
                                    public String getElementAt(int i) { return strings[i]; }
                                });
        getContentPane().setLayout(layout);

        pack();
    }

    public void actualizarJugadoresConectados(ArrayList<Jugador> conectados){
       
       String[] lista = new String[conectados.size()];
       int i=0;
       for(Jugador j:conectados){
           lista[i]=j.getNombre();
           i++;
       }
       
       listConectados.setListData(lista);
    }
    
    public void actualizarRankingJugadores(ArrayList<Jugador> jugadores){
       String[] lista = new String[jugadores.size()];
       int i=0;
       for(Jugador j:jugadores){
           lista[i]=j.getNombre();
           i++;
       }
       listRanking.setListData(lista);
    }
    
    public void actualizarPartidasActivas(ArrayList<Partida> partidas){
       String[] lista = new String[partidas.size()];
       int i=0;
       for(Partida p:partidas){
           lista[i]=p.getJ1().getNombre()+" contra "+p.getJ2().getNombre()+" ("+
                   p.getRondasGanadasJ1()+" - "+p.getRondasGanadasJ2()+")";
           i++;
       }   
    }
    
    public void actualizarPartidasFinalizadas(ArrayList<Partida> partidas){
       String[] lista = new String[partidas.size()];
       int i=0;
       for(Partida p:partidas){
           lista[i]=p.getJ1().getNombre()+" contra "+p.getJ2().getNombre()+" ("+
                   p.getRondasGanadasJ1()+" - "+p.getRondasGanadasJ2()+")";
           i++;
       }
       listFinalizadas.setListData(lista);
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }
    private void btnRetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetarActionPerformed
        String hashtag = listConectados.getSelectedValue();
        if(hashtag==null){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un oponente");
        }else{
            if(hashtag.equals(j.getNombre())){
                JOptionPane.showMessageDialog(this, "No te puedes retar a ti mismo");
            }else{
                JOptionPane.showMessageDialog(this, "Has retado a "+hashtag);
                cliente.retar(hashtag);
            }
        }      
    }
    public int lanzarReto(Jugador retador){
        int res = JOptionPane.showConfirmDialog(this, "Te ha retado el jugador "+retador.getNombre(), "Reto", JOptionPane.YES_NO_OPTION);
        return res;
    }
    public void mostrarRespuestaReto(Jugador oponente, TipoEnvio tipo){
        if(tipo==TipoEnvio.ACEPTARETO){
            JOptionPane.showMessageDialog(this,"El jugador "+oponente.getNombre()+" ha aceptado el reto");
        }else{
            JOptionPane.showMessageDialog(this,"El jugador "+oponente.getNombre()+" NO ha aceptado el reto");
        }
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        salir();
    }  
    
    private void salir(){
        this.setVisible(false);
        cliente.desconectar();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    private javax.swing.JButton btnRetar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listConectados;
    private javax.swing.JList<String> listFinalizadas;
    private javax.swing.JList<String> listRanking;
}