
import java.util.Random;

public class Jogador {
    private double saldo;
    private String nome;
    private int numPosicao;

    public Jogador(double saldo, String nome) {
        this.saldo = saldo;
        this.nome = nome;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int jogarDados(){
        Random sorteio = new Random();

        return sorteio.nextInt(2, 13);
    }

    public String getNome(){
        return nome;
    }

    public void convertePosicao(int resulatadoDado){
        this.saldo += 200;
        this.numPosicao = (numPosicao + resulatadoDado) - 40 ;
    }// 36 + 10 = 46

    public void entrarPosicao(int resultadoDado){
         int posicaoFutura = numPosicao + resultadoDado;
        System.out.println("dado: " + resultadoDado);
        System.out.println("numposicao: "+numPosicao);
        System.out.println("futura: "+ posicaoFutura);
         if(posicaoFutura < 40){
             Tabuleiro.getPosicao(numPosicao).entrarPosicao(this);
             numPosicao =  posicaoFutura;
         } else {
             convertePosicao(resultadoDado);
             System.out.println("teste: " + numPosicao);
             Tabuleiro.getPosicao(this.numPosicao).entrarPosicao(this);
         }



    }
    public void sairPosicao(){
        Tabuleiro.getPosicoes()[numPosicao].sairPosicao(this.nome);
    }


    public int getNumposicao() {
        return numPosicao;
    }

    public void debito(double valorCompra) {
        this.saldo -= valorCompra;
    }
}

