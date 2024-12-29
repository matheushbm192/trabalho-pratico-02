public class ParadaLivre extends Posicao {

    public ParadaLivre(String nome) {
        super(nome);
    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        System.out.println("Nada acontece!");
    }
}

