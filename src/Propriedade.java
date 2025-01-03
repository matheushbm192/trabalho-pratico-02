//subclasse de Posicao
public class Propriedade extends Posicao{
    
    //declaração das variáveis 
    protected int valorCompra;
    protected Jogador proprietario; 
    
    //construtor 
    public Propriedade(String nome, Jogador[] jogadores, int valorCompra, Jogador proprietario) {
        super(nome);
        this.valorCompra = valorCompra;
        this.proprietario = proprietario;
    }
    
    //construtor somente com nome e valor de compra da propriedade
    public Propriedade(String nome, int valorCompra) {
        super(nome);
        this.valorCompra = valorCompra;
    }
    
    //método set para alterar proprietário
    public void setProprietario(Jogador jogadorVez){
         this.proprietario = jogadorVez;
    }
    
    //método get que retorna o valor da propriedade
    public int getValorCompra() {
        return valorCompra;
    }
    
    //método para comprar uma propriedade ]
    public void comprarPropriedade(Jogador jogadorVez ){

        jogadorVez.debito(valorCompra);
        setProprietario(jogadorVez);
        jogadorVez.addPropriedade();
        System.out.println();
        System.out.println("Propriedade " + super.getNome() + " comprada pelo valor de R$" + valorCompra + "." );
        System.out.println(jogadorVez.getNome() + " seu saldo atual após a compra é : R$" + jogadorVez.getSaldo());
    }
    
}