import java.util.Random;

public class Sorte extends Posicao {


    public Sorte(String nome) {
        super(nome);

    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);

        Random sorteio = new Random();
        int resultado = sorteio.nextInt(-80, 151);
        jogadorVez.setSaldo(jogadorVez.getSaldo() + resultado);
        
        if(resultado < 0){
            System.out.println("Você caiu no Sorte/Revés");
            System.out.println("Pague R$" + Math.abs(resultado));
            System.out.println("Saldo após o débito: R$" + jogadorVez.getSaldo());
            System.out.println();
        }else{
            System.out.println("Você caiu no Sorte/Revés");
            System.out.println("Receba R$" + resultado);
            System.out.println("Saldo após o acréscimo: R$" + jogadorVez.getSaldo());
            System.out.println();
        }
    }
}
