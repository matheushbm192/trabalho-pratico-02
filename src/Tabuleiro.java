
import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro {

    private Posicao posicoes[];
    private ArrayList<Jogador> jogadores;

    public Tabuleiro() {
        
        this.jogadores = new ArrayList<>();
        this.posicoes = new Posicao[39];
        
        int[] valores1 = {8,24,240};
        int[] valores3 = {6,18,180};
        int[] valores4 = {7,21,210};
        int[] valores6 = {13,39,390};
        int[] valores8 = {11,33,330};
        int[] valores9 = {12,36,360};
        int[] valores11 = {10,30,300};
        int[] valores13 = {9,27,270};
        int[] valores14 = {10,30,300};
        int[] valores17 = {35,105,1050};
        int[] valores19 = {50,150,1500};
        int[] valores21 = {11,33,330};
        int[] valores23 = {10,30,300};
        int[] valores26 = {13,39,390};
        int[] valores28 = {15,45,450};
        int[] valores29 = {12,36,360};
        int[] valores31 = {21,63,630};
        int[] valores33 = {23,69,690};
        int[] valores34 = {23,69,690};
        int[] valores36 = {22,66,660};
        int[] valores38 = {28,84,840};
        int[] valores39 = {22,66,660};
        
        
        this.posicoes[0] = new ValorFixo("Inicio", 200);
        this.posicoes[1] = new Lote("Leblon", 80, valores1, 0, 80);
        this.posicoes[2] = new Sorte("Sorte/Revés", 0, 0);
        this.posicoes[3] = new Lote("Av. Presidente Vargas", 80, valores3, 0, 80);
        this.posicoes[4] = new Lote("Av. Nossa Senhora de Copacabana", 80, valores4, 0, 80);
        this.posicoes[5] = new Companhia("Companhia Ferroviária", 200, 50);
        this.posicoes[6] = new Lote("Av. Brigadeiro Faria Lima", 110, valores6, 0, 110);
        this.posicoes[7] = new Companhia("Companhia de Viação", 200, 40);
        this.posicoes[8] = new Lote("Av. Rebouças", 110, valores8, 0, 110);
        this.posicoes[9] = new Lote("Av. 9 de Julho", 110, valores9, 0, 110);
        this.posicoes[10] = new Cadeia("Cadeia");
        this.posicoes[11] = new Lote("Av. Europa", 100, valores11, 0, 100);
        this.posicoes[12] = new Sorte("Sorte/Revés", 0, 0);
        this.posicoes[13] = new Lote("Rua Augusta", 100, valores13, 0, 100);
        this.posicoes[14] = new Lote("Av. Pacaembu", 100, valores14, 0, 100);
        this.posicoes[15] = new Companhia("Companhia de Táxi", 200, 40);
        this.posicoes[16] = new Sorte("Sorte/Revés", 0, 0);
        this.posicoes[17] = new Lote("Interlagos", 250, valores17, 0, 250);
        this.posicoes[18] = new Sorte("Lucros ou Dividendos", 0, 0);
        this.posicoes[19] = new Lote("Morumbi", 250, valores19, 0, 250);
        this.posicoes[20] = new ParadaLivre("Parada Livre");
        this.posicoes[21] = new Lote("Bangu", 100, valores21, 0, 100);
        this.posicoes[22] = new Sorte("Sorte/Revés", 0, 0);
        this.posicoes[23] = new Lote("Botafogo", 100, valores23, 0, 100);
        this.posicoes[24] = new Imposto("Imposto de Renda");
        this.posicoes[25] = new Companhia("Companhia de Navegação", 200, 40);
        this.posicoes[26] = new Lote("Av. Brasil", 110, valores26, 0, 110);
        this.posicoes[27] = new Sorte("Sorte/Revés", 0, 0);
        this.posicoes[28] = new Lote("Av. Paulista", 110, valores28, 0, 110);
        this.posicoes[29] = new Lote("jardim Europa", 110, valores29, 0, 110);
        this.posicoes[30] = new Cadeia("Vá para a Prisão");
        this.posicoes[31] = new Lote("Copacabana", 170, valores31, 0, 170);
        this.posicoes[32] = new Companhia("Companhia de Aviação", 200, 50);
        this.posicoes[33] = new Lote("Av. Vieira Souto", 170, valores33, 0, 170);
        this.posicoes[34] = new Lote("Av. Atlântica", 170, valores34, 0, 170);
        this.posicoes[35] = new Companhia("Companhia Táxi Aéreo", 200, 50);
        this.posicoes[36] = new Lote("Ipanema", 170, valores36, 0, 170);
        this.posicoes[37] = new Sorte("Sorte/Revés", 0, 0);
        this.posicoes[38] = new Lote("Jardim Paulista", 190, valores38, 0, 190);
        this.posicoes[39] = new Lote("Brooklin", 190, valores39, 0, 190);
        
        
    }

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

    public void iniciarJogo() {
        System.out.println("Bem-vindos ao Banco IFMG!");

        //Laço que finaliza o jogo quando tiver apenas um jogador com saldo positivo
    }
}
