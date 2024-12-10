public class Propriedade extends Posicao{
    private int valorCompra;
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

}
