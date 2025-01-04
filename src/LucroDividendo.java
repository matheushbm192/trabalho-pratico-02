//subclasse de Posicao
public class LucroDividendo extends Posicao {

    //construtor
    public LucroDividendo(String nome) {
        super(nome);
    }
    @Override
    //método
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        
        //adiciona uma bonificação de 200 reais ao saldo do jogador 
        System.out.println("Você caiu no Lucros ou Dividendos!");
        System.out.println("Receba uma bonificação de R$200,00.");
        jogadorVez.setSaldo(jogadorVez.getSaldo() + 200);
        System.out.println("Saldo atual após o pagamento: R$" + jogadorVez.getSaldo());

    }
}
