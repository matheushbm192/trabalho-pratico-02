//subclasse de Posicao
public class Cadeia extends Posicao{
    
    //construtor
    public Cadeia(String nome) {
        super(nome);
    }
    
    //método 
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        
        System.out.println("Você caiu na cadeia. Deve pagar uma fiança de R$400.");
        //debita do saldo do jogador da vez um valor de 400 reais, que representa a fiança 
        jogadorVez.debito(400);
        System.out.println("Saldo após pagamento: R$"+ jogadorVez.getSaldo());
    }

    
    
    
}
