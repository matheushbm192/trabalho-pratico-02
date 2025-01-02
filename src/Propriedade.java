public class Propriedade extends Posicao{
    protected int valorCompra;
    protected Jogador proprietario; 
    
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
        jogadorVez.addPropriedade();
        System.out.println();
        System.out.println("Propriedade " + super.getNome() + " comprada pelo valor de R$" + valorCompra + "." );
        System.out.println(jogadorVez.getNome() + " seu saldo atual após a compra é : R$" + jogadorVez.getSaldo());
    }
    
}

