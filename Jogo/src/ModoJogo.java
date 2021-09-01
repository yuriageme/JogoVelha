import java.util.Scanner;

public class ModoJogo {

    
    public int modo;

    public String p1, p2;

    Scanner sc = new Scanner(System.in);

    public void Inicio() {
        
        
    
        System.out.println("Jogo da Velha");
        System.out.println("-------------");
        System.out.println("Escolha o modo de jogo através das opções");
        System.out.println("-------------");
        System.out.println("[1] J1 x J2");
        System.out.println("[2] J1 x PC");
        modo = sc.nextInt();
    
        if((modo != 1) && (modo!= 2)) {
        
            System.out.println("Digite um modo de jogo válido");

      }

        

    }

    public void jogadorXjogador(){

        System.out.println("Você escolheu o modo J1 x J2");
        System.out.println("Digite o nome do J1");
        sc.nextLine(); //Apenas para subtrair o /n que o nextInt do modo criou
        p1 = sc.nextLine();
        System.out.println("Digite o nome do J2");
        p2 = sc.nextLine();

        
        //Cria uma variavel do tipo tabuleiro
        Tabuleiro tab = new Tabuleiro ();

         //Cria uma var booleana pra identificar se é a vez do J1 ou J2
        boolean jogada1 = true;

        //Cria uma var booleana pra identificar se o jogo terminou
        boolean fimDeJogo = false;
        
        while(fimDeJogo == false) {

            //Desenha o tabuleiro
            tab.imprimeTabuleiro();

            //Informa de quem é a vez
            if(jogada1) {
                System.out.println("É a sua vez, " + p1 + "! Você joga com 'x'");
            } else {
                System.out.println("É a sua vez, " + p2 + "!  Você joga com 'o'");
            }

            //Cria uma var que armazena 'x' ou 'y' de acordo com o jogador
            char simbolo = '-';
            if(jogada1) {
                simbolo = 'x';
            } else {
                simbolo = 'o';
            }

            //Cria as variáveis de linha e coluna de acordo com o tabuleiro
            int linha = 0;
            int coluna = 0;

            //Só avança se o usuário digitar uma opção válida
            while(true) {

                //Pede que o usuário informe a posição onde deseja marcar seu símbolo
                System.out.println("Informe a linha desejada (1, 2 ou 3): ");
                linha = sc.nextInt() - 1;
                System.out.println("Informe a coluna desejada");
                coluna = sc.nextInt() - 1;

                //Verifica se a posição no tabuleiro é válida
                if(linha < 0 || coluna < 0 || linha > 2 || coluna > 2) {
                    System.out.println("A posição informada não é válida. Tente novamente!");

                //Verifica se a posição informada está preenchida ou não
                } else if(tab.Posicao(linha, coluna) != '-') {
                    System.out.println("A posição informada já está preenchida. Tente novamente!");

                //Senão, a posição é válida e saímos desse loop
                } else { 
                    break;
                }

            }
            
            //Definir a posição no tabuleiro na linha e coluna especificadas, na variável simbolo
            tab.Marcar(linha, coluna, simbolo);

            //Verifica se algum jogador venceu a partida
            if(tab.jogadorVenceu() == 'x') {
                System.out.println("O jogador "+ p1 + " venceu!");
                fimDeJogo = true;
            } else if(tab.jogadorVenceu() == 'o') {
                System.out.println("O jogador "+ p2 + " venceu!");
                fimDeJogo = true;
            } else {

            //Se nenhum jogador tiver vencido, verificar se o tabuleiro está totalmente preenchido, e declarar empate

            if(tab.tabuleiroCheio()) {
                System.out.println("O jogo terminou empatado!");
                fimDeJogo = true;
            } else {

            //Alterna a rodada dos jogadores
            jogada1 = !jogada1;
            }

            }

        }

        //Preenche o tabuleiro, até o jogo terminar
        tab.imprimeTabuleiro();

            
    }
    public void jogadorXpc(){

        

        System.out.println("Você escolheu o modo J1 x PC");
        System.out.println("Digite o seu nome");
        sc.nextLine(); //Apenas para subtrair o /n que o nextInt do modo criou
        p1 = sc.nextLine();
        System.out.println("Digite um modo de jogo válido");
        System.out.println("[1] fácil, [2] médio ou [3] difícil");
        int dificuldade = sc.nextInt();

         //Cria uma variavel do tipo tabuleiro
         Tabuleiro tab = new Tabuleiro ();

         //Cria uma var booleana pra identificar se é a vez do J1 ou J2
        boolean jogada1 = true;

        //Cria uma var booleana pra identificar se o jogo terminou
        boolean fimDeJogo = false;
        
        while(fimDeJogo == false) {

            //Desenha o tabuleiro
            tab.imprimeTabuleiro();

            //Cria uma var que armazena 'x' ou 'y' de acordo com o jogador
            char simbolo = '-';
            if(jogada1) {
                simbolo = 'x';
            } else {
                simbolo = 'o';
            }

            //Cria as variáveis de linha e coluna de acordo com o tabuleiro
            int linha = 0;
            int coluna = 0;

            //Informa de quem é a vez
            if(jogada1) {
                System.out.println("É a sua vez, " + p1 + "! Você joga com 'x'");
            
                //Só avança se o usuário digitar uma opção válida
                while(true) {

                    //Pede que o usuário informe a posição onde deseja marcar seu símbolo
                    System.out.println("Informe a linha desejada (1, 2 ou 3): ");
                    linha = sc.nextInt() - 1;
                    System.out.println("Informe a coluna desejada");
                    coluna = sc.nextInt() - 1;

                    //Verifica se a posição no tabuleiro é válida
                    if(linha < 0 || coluna < 0 || linha > 2 || coluna > 2) {
                        System.out.println("A posição informada não é válida. Tente novamente!");

                    //Verifica se a posição informada está preenchida ou não
                    } else if(tab.Posicao(linha, coluna) != '-') {
                        System.out.println("A posição informada já está preenchida. Tente novamente!");

                    //Senão, a posição é válida e saímos desse loop
                    } else { 
                        break;
                    }

                }
            
                //Definir a posição no tabuleiro na linha e coluna especificadas, na variável simbolo
                tab.Marcar(linha, coluna, simbolo);

            
            } else {
                System.out.println("É a vez da máquina");

                if (dificuldade == 1){
                    tab.facil();
                }else if (dificuldade == 2){
                    tab.medio();
                }
                else if (dificuldade == 3){
                    tab.dificil();
                }

                }
            

                      
            //Verifica se algum jogador venceu a partida
            if(tab.jogadorVenceu() == 'x') {
                System.out.println("O jogador "+ p1 + " venceu!");
                fimDeJogo = true;
            } else if(tab.jogadorVenceu() == 'o') {
                System.out.println("A máquina venceu!");
                fimDeJogo = true;
            } else {

            //Se nenhum jogador tiver vencido, verificar se o tabuleiro está totalmente preenchido, e declarar empate

            if(tab.tabuleiroCheio()) {
                System.out.println("O jogo terminou empatado!");
                fimDeJogo = true;
            } else {

            //Alterna a rodada dos jogadores
            jogada1 = !jogada1;
            }

            }
     
    }
    //Preenche o tabuleiro, até o jogo terminar
    tab.imprimeTabuleiro();
    
    sc.close();

    }
}
