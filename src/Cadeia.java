public class Cadeia extends Posicao{
    int diasPreso = 3; 

    public Cadeia(String nome) {
        super(nome);
    }
    
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        
        System.out.println("Você caiu na cadeia. Deve pagar uma fiança de R$400.");
        jogadorVez.setSaldo(jogadorVez.getSaldo() - 400);
        System.out.println("Saldo após pagamento: R$"+ jogadorVez.getSaldo());
    }

    
    
    
}
