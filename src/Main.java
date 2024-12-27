import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jogador> listaJogadores = Tabuleiro.getJogadores();

        while(true){
            for (int i = 0; i < Tabuleiro.getQntJogadores(); i++) {
                Jogador jogadorVez = listaJogadores.get(i);
                jogadorVez.sairPosicao();
                //Criara interação para jogar o dado
                int resultado = jogadorVez.jogarDados();
                //todo: mover o jogador para uma posicao
                jogadorVez.entrarPosicao(resultado);
                //questionar o jogador de acordo com a posição, oque ele quer fazer
                //acessa o tabuleiro e depois a posicao que o jogador está, e acessa o metodo açao dado
                Tabuleiro.getPosicao(jogadorVez.getNumposicao()).acaoDado(resultado, jogadorVez); ;
                //todo: realizar caminho diferente para cadeia
                //todo: sobrescrever o metodo acaoDado nas classes
            }
        }
    }
}