
import java.util.ArrayList;
import java.util.Random;

public class Jogador {
    private int saldo;
    private String nome;
    private int numPosicao;

    public Jogador(int saldo, String nome) {
        this.saldo = saldo;
        this.nome = nome;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public int jogarDados(){
        Random sorteio = new Random();
        return sorteio.nextInt(1, 13);
    }

    public String getNome(){
        return nome;
    }

    public void convertePosicao(int posicaoExtra){
        this.numPosicao = (numPosicao - 40) + posicaoExtra;
    }
    public void entrarPosicao(int resultadoDado){
         int posicaoFutura = numPosicao + resultadoDado;
         if(posicaoFutura < 40){
             Tabuleiro.getPosicoes()[numPosicao].entrarPosicao(this);
         } else {
             convertePosicao(posicaoFutura);
             Tabuleiro.getPosicoes()[numPosicao].entrarPosicao(this);
         }


         numPosicao =  posicaoFutura;
    }
    public void sairPosicao(){
    //todo preparar numPosicao (o jogador precisa ter a informação de qual posicao ele está)
        Tabuleiro.getPosicoes()[numPosicao].sairPosicao(this.nome);
    }


    public int getNumposicao() {
        return numPosicao;
    }
}

