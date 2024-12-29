import java.util.Random;

public class Sorte extends Posicao {


    public Sorte(String nome) {
        super(nome);

    }
    
    //já descontar no saldo do jogador da vez, se possível

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);

        Random sorteio = new Random();
        double resultado = sorteio.nextDouble(-80.0, 151.0);
        jogadorVez.setSaldo(jogadorVez.getSaldo() + resultado);
    }
}