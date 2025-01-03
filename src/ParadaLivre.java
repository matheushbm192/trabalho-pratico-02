//subclasse de Posicao
public class ParadaLivre extends Posicao {
    
    //construtor
    public ParadaLivre(String nome) {
        super(nome);
    }
    
    //método
    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        System.out.println("Parada livre! Nenhuma ação ocorrerá.");
    }
}