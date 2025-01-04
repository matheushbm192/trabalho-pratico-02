
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem-vindos ao Banco IFMG!");

        //instânciando objeto de tabuleiro
        Tabuleiro tabuleiro = new Tabuleiro();
        //chama função que realiza cadastro dos jogadores
        tabuleiro.realizaCadastro();
        //cria um arraylist do tipo Jogador que armazena as informações de cada jogador
        ArrayList<Jogador> listaJogadores = Tabuleiro.getJogadores();

        //laço que roda enquanto a quantidade de jogadores no tabuleiro for maior que 1
        while (Tabuleiro.getQntJogadores() > 1) {

            //laço que passa por cada index do arrayList de jogadores
            for (int i = 0; i < listaJogadores.size(); i++) {
                //atribuindo a variável jogadorVez o conteúdo presente no index i do array
                Jogador jogadorVez = listaJogadores.get(i);

                //analisando se o saldo do jogador está menor ou igual a zero
                if (jogadorVez.getSaldo() <= 0.0) {
                    //se estiver aparece uma mensagem de erro
                    System.out.println("Jogador(a) " + jogadorVez.getNome() + " foi eliminado(a): Saldo zerado.");

                } else {
                    //imprime as informações do jogador da vez
                    System.out.println();
                    System.out.println("******************************************");
                    System.out.println("Informações do jogador da vez: ");
                    System.out.println("Nome: " + jogadorVez.getNome());
                    System.out.println("Posição Atual: " + jogadorVez.getNumposicao());
                    System.out.println("Saldo Atual: " + jogadorVez.getSaldo());
                    System.out.println();

                    //chama o método para sair de posição
                    jogadorVez.sairPosicao();

                    //variável que guarda o valor da soma dos dados que foram "jogados"
                    int resultado = jogadorVez.jogarDados();
                    System.out.println("Resultado da soma dos Dados: " + resultado);

                    //chama a função entrarPosicao fazendo com que o jogador ande pelo tabuleiro
                    jogadorVez.entrarPosicao(resultado);
                    //imprimi sua nova posição
                    System.out.println("Nova Posição: " + jogadorVez.getNumposicao());
                    System.out.println();

                    //chama o método acaoDado de acordo com a posição que o jogador da vez está
                    Tabuleiro.getPosicao(jogadorVez.getNumposicao()).acaoDado(resultado, jogadorVez);

                }
                //verifica se o saldo do jogador è menor ou igual a zero
                if (jogadorVez.getSaldo() <= 0.0) {
                    //se for, chama a função eliminarJogador
                    Tabuleiro.eliminarJogador(jogadorVez);
                }

            }
        }
    }
}

