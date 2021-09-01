public class Tabuleiro {
    
    public char[][] matriz = new char [3][3];

     //Insere caracteres nos espaços da matriz
     
     public Tabuleiro(){
     for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            matriz[i][j] = '-';
        }
      }
    }

    //Função que preenche o tabuleiro
  public void imprimeTabuleiro() {
    System.out.println("Tabuleiro:");
    for(int i = 0; i < 3; i++) {
      //Loop para preencher as linhas do tabuleiro
      for(int j = 0; j < 3; j++) {
        System.out.print(matriz[i][j]);
      }
      //Linha de comando apenas para separar as linhas do tabuleiro
      System.out.println();

    }
  }
  public char Posicao(int lin, int col) {
    
    return matriz[lin][col];

  }

  public void Marcar(int lin, int col, char simbolo){
    
    matriz[lin][col] = simbolo;

  }

  //Função para verificar se algum dos jogadores venceu
  public char jogadorVenceu() {
    
    //Verifica cada linha
    for(int i = 0; i < 3; i++){
      if(matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] != '-') {
        return matriz[i][0];
      }
    }

    //Verifica cada coluna
    for(int j = 0; j < 3; j++) {
      if(matriz[0][j] == matriz[1][j] && matriz[1][j] == matriz[2][j] && matriz[0][j] != '-') {
        return matriz[0][j];
      }
    }

    //Verifica as diagonais
    if(matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] != '-') {
      return matriz[0][0];
    }
    if(matriz[2][0] == matriz[1][1] && matriz[1][1] == matriz[0][2] && matriz[2][0] != '-') {
      return matriz[2][0];
    }

    //Se ninguém venceu...
    return ' ';

  }

  //Função que verifica se todas as posições do tabuleiro já foram preenchidas
  public boolean tabuleiroCheio() {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(matriz[i][j] == '-') {
          return false;
        }
      }
    }
    return true;

  }

  public void facil() {

    boolean sair = false;

    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(matriz[i][j] == '-') {
          matriz[i][j] = 'o';
          sair = true;
          break;
        }
      }
    if (sair == true){
      break;
    }
    }
 }
}
  


