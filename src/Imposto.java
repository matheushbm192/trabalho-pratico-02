//subclasse de Posicao
public class Imposto extends Posicao {

    //construtor
    public Imposto(String nome) {
        super(nome);
    }

    //método
    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        //debita 200 reais do saldo do jogador 
        System.out.println("Você caiu no imposto de renda!");
        System.out.println("Deve pagar uma penalidade de R$200,00.");
        jogadorVez.debito(200);
        System.out.println("Saldo atual após o pagamento: R$" + jogadorVez.getSaldo());

    }

}
