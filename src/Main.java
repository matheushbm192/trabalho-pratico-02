
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem-vindos ao Banco IFMG!");

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.realizaCadastro();
        tabuleiro.iniciarJogo();
        ArrayList<Jogador> listaJogadores = Tabuleiro.getJogadores();

        while (Tabuleiro.getQntJogadores() > 1) {


            for (int i = 0; i < listaJogadores.size(); i++) {
                Jogador jogadorVez = listaJogadores.get(i);
                if (jogadorVez.getSaldo() <= 0.0) {
                    System.out.println("Jogador(a) " + jogadorVez.getNome() + " foi eliminado(a): Saldo zerado.");

                } else {
                    System.out.println();
                    System.out.println("******************************************");
                    System.out.println("Informações do jogador da vez: ");
                    System.out.println("Nome: " + jogadorVez.getNome());
                    System.out.println("Posição Atual: " + jogadorVez.getNumposicao());
                    System.out.println("Saldo Atual: " + jogadorVez.getSaldo());
                    System.out.println();

                    jogadorVez.sairPosicao();

                    int resultado = jogadorVez.jogarDados();
                    System.out.println("Resultado da soma dos Dados: " + resultado);

                    jogadorVez.entrarPosicao(resultado);
                    System.out.println("Nova Posição: " + jogadorVez.getNumposicao());
                    System.out.println();

                    Tabuleiro.getPosicao(jogadorVez.getNumposicao()).acaoDado(resultado, jogadorVez);

                }
                
                if (jogadorVez.getSaldo() <= 0.0) {
                    Tabuleiro.eliminarJogador(jogadorVez);
                    listaJogadores.remove(i);
                }

            }
        }
    }
}

