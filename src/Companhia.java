import java.util.Scanner;

public class Companhia extends Propriedade{
    private int fatorMultiplicacao;

    Scanner entrada = new Scanner(System.in);
    public Companhia(String nome, int valorCompra, int fatorMultiplicacao) {
        super(nome, valorCompra);
        this.fatorMultiplicacao = fatorMultiplicacao;
    }


    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);


        if(super.proprietario == null){
            System.out.println("Deseja comprar a Companhia: " + this.getNome() + "?");
            System.out.println("1 - Sim \n2-Não");
            if(entrada.nextInt() == 1) {
              super.comprarPropriedade(jogadorVez);
            }

        }
        if(super.proprietario != null){
            if(super.proprietario != jogadorVez){

                int valorPagar = somaDados * this.fatorMultiplicacao;

                jogadorVez.debito(valorPagar);
                super.proprietario.setSaldo(super.proprietario.getSaldo() + valorPagar);
            }
        }

    }
}


