public class Posicao {
    private String nome;
    private Jogador jogadores[];

    public Posicao(String nome) {
        this.nome = nome;
        this.jogadores = new Jogador[6];
    }

    public void acaoDado(int somaDados, Jogador jogadorVez){

    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void sairPosicao(String nome){
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] != null){
                if (jogadores[i].getNome().equals(nome)){
                    jogadores[i] = null;
                }
            }


        }
    }

    public void entrarPosicao(Jogador jogador) {
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] == null){
                jogadores[i] = jogador;
                return;
            }
        }
    }
}