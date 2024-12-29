public class ValorFixo extends Posicao {
    private int valorRegra;

    public ValorFixo(String nome, int valorRegra) {
        super(nome);
        this.valorRegra = valorRegra;
        
    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        //valor tirado do alem, não tinha o valor nas instruçoes
        jogadorVez.debito(valorRegra);
    }
}
