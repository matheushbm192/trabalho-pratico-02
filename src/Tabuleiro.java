public class Tabuleiro {
    private Posicao posicoes[];

    public Tabuleiro() {
        this.posicoes = new Posicao[39];

        this.posicoes[0] = new ValorFixo("Inicio", 200);
        int[] valores = {10,150,100,150,4};
        this.posicoes[1] = new Lote("Maisa", 200, valores, 180, 200);
        this.posicoes[3] = new Sorte("sorte 1", 180, -90);
    }
}

public void iniciarJogo(){
    //Criar jogadores
    //Laço que finaliza o jogo quando tiver apenas um jogador com saldo positivo
}
