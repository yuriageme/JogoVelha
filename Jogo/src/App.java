

public class App {
    public static void main(String[] args) throws Exception {

     ModoJogo partida = new ModoJogo();

     partida.Inicio();

     if (partida.modo == 1){

      partida.jogadorXjogador();

     }else if (partida.modo == 2){

      partida.jogadorXpc();
 
     }
    }
}



  