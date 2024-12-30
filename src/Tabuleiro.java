
import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro {

    private static Posicao[] posicoes;
    private static ArrayList<Jogador> jogadores;

    public Tabuleiro() {
        
        this.jogadores = new ArrayList<>();
        this.posicoes = new Posicao[40];

        //valor das estadias
        int[] valores1 = {8,24,240};
        int[] valores3 = {6,18,180};
        int[] valores4 = {7,21,210};
        int[] valores6 = {13,39,390};
        int[] valores8 = {11,33,330};
        int[] valores9 = {12,36,360};
        int[] valores11 = {10,30,300};
        int[] valores13 = {9,27,270};
        int[] valores17 = {35,105,1050};
        int[] valores19 = {50,150,1500};
        int[] valores28 = {15,45,450};
        int[] valores31 = {21,63,630};
        int[] valores33 = {23,69,690};
        int[] valores36 = {22,66,660};
        int[] valores38 = {28,84,840};

        
        
        posicoes[0] = new ValorFixo("Inicio", 200);
        posicoes[1] = new Lote("Leblon", 80, valores1);
        posicoes[2] = new Sorte("Sorte/Revés");
        posicoes[3] = new Lote("Av. Presidente Vargas", 80, valores3);
        posicoes[4] = new Lote("Av. Nossa Senhora de Copacabana", 80, valores4);
        posicoes[5] = new Companhia("Companhia Ferroviária", 200, 50);
        posicoes[6] = new Lote("Av. Brigadeiro Faria Lima", 110, valores6);
        posicoes[7] = new Companhia("Companhia de Viação", 200, 40);
        posicoes[8] = new Lote("Av. Rebouças", 110, valores8);
        posicoes[9] = new Lote("Av. 9 de Julho", 110, valores9);
        posicoes[10] = new Cadeia("Cadeia");
        posicoes[11] = new Lote("Av. Europa", 100, valores11);
        posicoes[12] = new Sorte("Sorte/Revés");
        posicoes[13] = new Lote("Rua Augusta", 100, valores13);
        posicoes[14] = new Lote("Av. Pacaembu", 100, valores11);
        posicoes[15] = new Companhia("Companhia de Táxi", 200, 40);
        posicoes[16] = new Sorte("Sorte/Revés");
        posicoes[17] = new Lote("Interlagos", 250, valores17);
        posicoes[18] = new Sorte("Lucros ou Dividendos");
        posicoes[19] = new Lote("Morumbi", 250, valores19);
        posicoes[20] = new ParadaLivre("Parada Livre");
        posicoes[21] = new Lote("Bangu", 100, valores8);
        posicoes[22] = new Sorte("Sorte/Revés");
        posicoes[23] = new Lote("Botafogo", 100, valores11);
        posicoes[24] = new Imposto("Imposto de Renda");
        posicoes[25] = new Companhia("Companhia de Navegação", 200, 40);
        posicoes[26] = new Lote("Av. Brasil", 110, valores6);
        posicoes[27] = new Sorte("Sorte/Revés");
        posicoes[28] = new Lote("Av. Paulista", 110, valores28);
        posicoes[29] = new Lote("jardim Europa", 110, valores9);
        posicoes[30] = new Cadeia("Vá para a Prisão");
        posicoes[31] = new Lote("Copacabana", 170, valores31);
        posicoes[32] = new Companhia("Companhia de Aviação", 200, 50);
        posicoes[33] = new Lote("Av. Vieira Souto", 170, valores33);
        posicoes[34] = new Lote("Av. Atlântica", 170, valores33);
        posicoes[35] = new Companhia("Companhia Táxi Aéreo", 200, 50);
        posicoes[36] = new Lote("Ipanema", 170, valores36);
        posicoes[37] = new Sorte("Sorte/Revés");
        posicoes[38] = new Lote("Jardim Paulista", 190, valores38);
        posicoes[39] = new Lote("Brooklin", 190, valores36);

        
    }

    public static Posicao[] getPosicoes() {
        return posicoes;
    }
    public static Posicao getPosicao(int index){return  posicoes[index];}

    public void realizaCadastro() {
        System.out.println("Para iniciar o jogo, informe o número de participantes (mínimo 2 - máximo 6):");
        Scanner entrada = new Scanner(System.in);
        
        int quantJogadores;
        quantJogadores = entrada.nextInt();
        
        if(quantJogadores > 6 || quantJogadores < 2) {
            System.out.println("Quantidade de jogadores inválida! Tente novamente.");
            realizaCadastro();
        }else{
            int aux = 0; 
            while(aux < quantJogadores){
            System.out.println("Informe o nome do jogador: ");
            Jogador jogadorVez = new Jogador(1500, entrada.next());
            jogadores.add(jogadorVez); 
            aux++;
            }
        }
    }

    public static ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public static int getQntJogadores(){
        return jogadores.size();
    }


    public void iniciarJogo() {
        System.out.println("Bem-vindos ao Banco IFMG!");

        //Laço que finaliza o jogo quando tiver apenas um jogador com saldo positivo
    }
}
