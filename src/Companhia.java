public class Companhia extends Propriedade{
    private int fatorMultiplicacao;

    public Companhia(String nome, int valorCompra, int fatorMultiplicacao) {
        super(nome, valorCompra);
        this.fatorMultiplicacao = fatorMultiplicacao;
    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        if(super.proprietario == null){
            System.out.println("Deseja ad a Companhia");
        }else{
            if(super.proprietario != jogadorVez){
                int valorPagar = somaDados * this.fatorMultiplicacao;

                jogadorVez.setSaldo(JogadorVez.getSaldo() - valorPagar);
                super.proprietario.setSaldo(super.proprietario.getSaldo() + valorPagr);
            }
        }
    }
}
