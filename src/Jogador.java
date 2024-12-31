import java.util.ArrayList;
import java.util.Random;

public class Jogador {

    private double saldo;
    private String nome;
    private int numPosicao;
    private ArrayList<String> indexPropriedades; 

    public Jogador(double saldo, String nome) {
        this.saldo = saldo;
        this.nome = nome;
        this.indexPropriedades = new ArrayList<>();
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int jogarDados() {
        Random sorteio = new Random();
        return sorteio.nextInt(2, 13);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getIndexPropriedades() {
        return indexPropriedades;
    }

    public void setIndexPropriedades(ArrayList<String> indexPropriedades) {
        this.indexPropriedades = indexPropriedades;
    }
    
    

    public void convertePosicao(int resulatadoDado) {
        this.saldo += 200;
        this.numPosicao = (numPosicao + resulatadoDado) - 40;
    }

    public void entrarPosicao(int resultadoDado) {
        int posicaoFutura = numPosicao + resultadoDado;
        if (posicaoFutura < 40) {
            Tabuleiro.getPosicao(numPosicao).entrarPosicao(this);
            numPosicao = posicaoFutura;
        } else {
            convertePosicao(resultadoDado);
            Tabuleiro.getPosicao(this.numPosicao).entrarPosicao(this);
            System.out.println();
            System.out.println("Você completou uma volta pelo tabuleiro. Receba um prêmio de 200 reais!");
            System.out.println("Seu saldo atual agora é de: R$" + this.saldo);
            System.out.println();
        }

    }

    public void sairPosicao() {
        Tabuleiro.getPosicoes()[numPosicao].sairPosicao(this.nome);

    }

    public int getNumposicao() {
        return numPosicao;
    }

    public void debito(double valorCompra) { 
        this.saldo -= valorCompra;
    }
}
