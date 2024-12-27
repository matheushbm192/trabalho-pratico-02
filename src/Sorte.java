import java.util.Random;

public class Sorte extends Posicao {
    private int sorte;
    private int reves;

    public Sorte(String nome, int sorte, int reves) {
        super(nome);
        this.sorte = sorte;
        this.reves = reves;
    }
    
    //já descontar no saldo do jogador da vez, se possível
    public int sorteReves(){
        Random sorteio = new Random();
        return sorteio.nextInt(-80, 151);
    }
}