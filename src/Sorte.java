import java.util.Random;

//subclasse de Posicao
public class Sorte extends Posicao {

    //construtor
    public Sorte(String nome) {
        super(nome);
    }

    @Override
    //método
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        
        //instânciando objeto de jogador 
        Random sorteio = new Random();
        //difinindo que o sorteio vai de -80(inclusivo) a 150(exclusivo)
        int resultado = sorteio.nextInt(-80, 150);
        
        //alterando o saldo do jogador a partir do valor sorteado 
        jogadorVez.setSaldo(jogadorVez.getSaldo() + resultado);
        
        //se o resultado for negativo: 
        if(resultado < 0){
            System.out.println("Você caiu no Sorte/Revés");
            //math.abs --> retorna o valor absoluto do número (desconsidera o sinal) 
            System.out.println("Pague R$" + Math.abs(resultado));
            System.out.println("Saldo após o débito: R$" + jogadorVez.getSaldo());
            System.out.println();
         
         // se o resultado for positivo: 
        }else{
            System.out.println("Você caiu no Sorte/Revés");
            //imprimi seu valor normalmente 
            System.out.println("Receba R$" + resultado);
            System.out.println("Saldo após o acréscimo: R$" + jogadorVez.getSaldo());
            System.out.println();
        }
    }
}
