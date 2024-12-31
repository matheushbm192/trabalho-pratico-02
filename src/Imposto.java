public class Imposto extends Posicao {

    public Imposto(String nome) {
        super(nome);
    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        
        super.acaoDado(somaDados, jogadorVez);
        System.out.println("Você caiu no imposto de renda!");
        double saldo = jogadorVez.getSaldo();
        
        if (saldo <= 1903.98) {
            System.out.println("Seu saldo é menor ou igual que R$1903,30. Portanto, não pagará taxa.");
            jogadorVez.debito( 0.0);
            
        } else if (saldo >= 1903.99 && saldo <= 2826.65) {
            System.out.println("Você deve pagar uma taxa de R$142,80");
            jogadorVez.debito(142.80);
            System.out.println("Saldo atual após o pagamento: R$" + jogadorVez.getSaldo());
            
        } else if (saldo >= 2826.66 && saldo <= 3751.05) {
            System.out.println("Você deve pagar uma taxa de R$354,80");
            jogadorVez.debito(354.80);
            System.out.println("Saldo atual após o pagamento: R$" + jogadorVez.getSaldo());
            
        } else if (saldo >= 3751.06 && saldo <= 4664.68) {
            System.out.println("Você deve pagar uma taxa de R$636,13");
            jogadorVez.debito(636.13);
            System.out.println("Saldo atual após o pagamento: R$" + jogadorVez.getSaldo());
            
        } else {
            System.out.println("Você deve pagar uma taxa de 869,36");
            jogadorVez.debito(869.36);
            System.out.println("Saldo atual após o pagamento: R$" + jogadorVez.getSaldo());
        }
    }


}


