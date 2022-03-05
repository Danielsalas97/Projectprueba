
import com.sun.prism.paint.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Daniel salas romero
 */
public class TriquiGUI extends JFrame implements ActionListener{

    //marca de los jugadores en el tablero
    static final char MARCA_O='O';
    static final char MARCA_X='X';
    static final char MARCA_VACIO=' ';
    
    char jugadorActual= MARCA_X;
   // int contJugadas= 0;
    char  T[][]= new char[3][3];
    
    JPanel panelNorte,panelCentro,panelSur;
    JButton butNuevo,butTablero[][];
    JLabel labMensaje;
    Color cx=Color.BLUE,co=Color.RED;
    
    
    //contructor
    public TriquiGUI(String titulo){
    super(titulo);
    construirGUI();
    }//fin del contructor
    
//construccion de la interfaz grafica
      private void construirGUI() {
        setLayout(new BorderLayout());
        
        panelNorte= new JPanel();
        butNuevo= new JButton("¡......Juego nuevo.......!");
        //butNuevo.setForeground(new Color(50,155,50)  );
        butNuevo.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        butNuevo.addActionListener(this);
        panelNorte.add(butNuevo);
        
        
        panelCentro= new JPanel();
        panelCentro.setLayout(new GridLayout(3,3,5,5));
        butTablero= new JButton[3][3];
        int f,c;
        Font fuente=new Font (Font.SANS_SERIF,Font.PLAIN,30);
        
        
        for(f=0; f<3;f++){
                 for(c=0; c<3;c++){
                     butTablero[f][c]=new JButton(" ");
                     T[f][c]= MARCA_VACIO;
                    butTablero[f][c].setFont(fuente);
                    panelCentro.add( butTablero[f][c]);
                       butTablero[f][c].addActionListener(this);
        }
        }
        
        panelSur=new JPanel();
        labMensaje=new JLabel("Inicia a jugar X");
        //labMensaje.setForeground(cx);
         labMensaje.setFont(fuente);
         panelSur.add( labMensaje);
        add(BorderLayout.NORTH,panelNorte);
        add(BorderLayout.CENTER,panelCentro);
        add(BorderLayout.SOUTH,panelSur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
    }//fin de la construccion de la interfaz
      //metodo limoiar tablero
      private void limpiartablero(){
      int f, c;
       for(f=0; f<2;f+=1){
                 for(c=0; c<2;c+=2){
                     T[f][c]= MARCA_VACIO;
                     butTablero[f][c].setText(" ");
       }
                 }
      }//fin metodo limppiar
      
      //metodo para ganador
      private boolean esGanador(char MJ){
      boolean sw=false;
      /**
      //las tres filas
             if((T[0][0]== MJ )&& (T[0][1]== MJ) && (T[0][2]= MJ)){
              sw=true;
             }else if(T[1][0]== MJ && T[1][1]== MJ && T[1][2]= MJ){
              sw=true;
               }else if(T[2][0]== MJ && T[2][1] == MJ && T[2][2]= MJ){
               sw=true;
                }
             //las tres columnas
              else if(T[0][0]== MJ && T[1][0]== MJ && T[2][0]= MJ){
               sw=true;
             }else if(T[0][1]== MJ && T[1][1] == MJ && T[2][1]= MJ){
               sw=true;
              }
             else if(T[0][2]== MJ && T[1][2]== MJ && T[2][2]= MJ){
             sw=true;
             }
      //la diagonal principal
       else if(T[0][0]== MJ && T[1][1]== MJ && T[2][2]= MJ){
      sw=true;
      }
      //la diagonal secundaria
       else if(T[2][0]== MJ && T[1][1]== MJ && T[0][2]= MJ){
      sw=true;
      }**/
      return sw;
      }//fin metodo ganador
      
      
      
      //clase principal
      public static void main(String argv[]){
      TriquiGUI frm= new TriquiGUI("Triqui game graphic");
      frm.setVisible(true);
      }//fin de la clase principal
              
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==butNuevo){
          limpiartablero();
          labMensaje.setForeground(java.awt.Color.BLUE);
          labMensaje.setText("....juega x....");
          jugadorActual=MARCA_X;
          
          
      }else {
      JButton b=(JButton )ae.getSource();
      char ca=b.getText().charAt(0);
      if( ca==MARCA_VACIO && jugadorActual !=  MARCA_VACIO){
          int f, c;
          boolean sw= false;
          
            for(f=0; f<2 && sw==false;f+=1){
                 for(c=0; c<2 && sw==false;c+=2){
                if(b ==butTablero[f][c]){
                     sw=true;
                       if(jugadorActual==MARCA_X){
                           butTablero[f][c].setForeground(java.awt.Color.BLUE);
                           butTablero[f][c].setText("X");
                           T[f][c]=MARCA_X;
                           if(esGanador(MARCA_X)){
                           labMensaje.setForeground(java.awt.Color.BLUE);
                           labMensaje.setText("¡...ganador X....!");
                           jugadorActual=MARCA_VACIO;
                           }else{
                             labMensaje.setForeground(java.awt.Color.RED);
                             labMensaje.setText("¡...juega O....!");
                             jugadorActual=MARCA_O;
                           }
                       }else{
                       butTablero[f][c].setForeground(java.awt.Color.RED);
                           butTablero[f][c].setText("O");
                           T[f][c]=MARCA_O;
                           if(esGanador(MARCA_O)){
                           labMensaje.setForeground(java.awt.Color.RED);
                           labMensaje.setText("¡...ganador O....!");
                           jugadorActual=MARCA_VACIO;
                           }else{
                             labMensaje.setForeground(java.awt.Color.BLUE);
                             labMensaje.setText("¡...juega X....!");
                             jugadorActual=MARCA_X;
                           }
                       }
                 }//fin if
                 }//for c
                 }//for f
      }
      }
    }//actionperdormed


}//triquiGUI
