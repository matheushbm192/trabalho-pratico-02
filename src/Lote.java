import java.util.Scanner;

public class Lote extends Propriedade {
    private int valores[];
    private int statusMelhoria = 1; // é incrementado de acordo com o nivel de melhoria da propriedade // criar função parar incrementar status de melhoria

    Scanner entrada = new Scanner(System.in);
    public Lote(String nome, int valorCompra, int[] valores) {
        super(nome, valorCompra);
        this.valores = valores;

        
    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);

        if(super.proprietario == null){
            System.out.println("Deseja comprar o Lote: " + this.getNome() + "?");
            System.out.println("1 - Sim \n2-Não");
            if(entrada.nextInt() == 1) {
                super.comprarPropriedade(jogadorVez);
            }
        } else if (super.proprietario == jogadorVez && this.statusMelhoria < 3) {
            System.out.println("Deseja melhorar o Lote para nivel: " + (this.statusMelhoria + 1) + "?");
            System.out.println("1 - Sim \n2-Não");

            if(entrada.nextInt() == 1){
                this.statusMelhoria += 1;
                jogadorVez.debito(super.valorCompra);
            }
        }
        if(super.proprietario != null) {
            if (super.proprietario != jogadorVez) {
                int index = statusMelhoria - 1;
                int valorPagar = valores[index];

                jogadorVez.debito(valorPagar);
                super.proprietario.setSaldo(super.proprietario.getSaldo() + valorPagar);
            }
        }
    }
}

