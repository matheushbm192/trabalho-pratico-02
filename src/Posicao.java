public class Posicao {
    //variáveis 
    private String nome;
    private Jogador jogadores[];
    
    //construtor
    public Posicao(String nome) {
        this.nome = nome;
        this.jogadores = new Jogador[6];
    }
    
    //método base para as subclasses 
    public void acaoDado(int somaDados, Jogador jogadorVez){

    }
    
    //método get para acessar nome da posição 
    public String getNome(){
        return this.nome;
    }
    
    //método para tirar jogador do array de uma determinada posição 
    public void sairPosicao(String nome){
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] != null){
                if (jogadores[i].getNome().equals(nome)){
                    jogadores[i] = null;
                }
            }


        }
    }
    
    //método que coloca jogador no array de uma determinada posição 
    public void entrarPosicao(Jogador jogador) {
        for (int i = 0; i < jogadores.length; i++) {
            if(jogadores[i] == null){
                jogadores[i] = jogador;
                //finaliza o método para não fazer outras verificações desnecessárias;
                break;
            }
        }
    }
}

