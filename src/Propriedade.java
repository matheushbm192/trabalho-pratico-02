public class Propriedade extends Posicao{
    protected int valorCompra;
    protected Jogador proprietario; // se um proprietario é null, então a propriedade esta a venda

    public Propriedade(String nome, Jogador[] jogadores, int valorCompra, Jogador proprietario) {
        super(nome);
        this.valorCompra = valorCompra;
        this.proprietario = proprietario;
    }

    public Propriedade(String nome, int valorCompra) {
        super(nome);
        this.valorCompra = valorCompra;
    }

    public void setProprietario(Jogador jogadorVez){
        this.proprietario = jogadorVez;
    }

    public int getValorCompra() {
        return valorCompra;
    }

    public void comprarPropriedade(Jogador jogadorVez ){

        jogadorVez.debito(valorCompra);
        setProprietario(jogadorVez);
    }
}