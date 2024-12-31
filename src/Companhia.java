import java.util.Scanner;

public class Companhia extends Propriedade {

    private int fatorMultiplicacao;

    Scanner entrada = new Scanner(System.in);

    public Companhia(String nome, int valorCompra, int fatorMultiplicacao) {
        super(nome, valorCompra);
        this.fatorMultiplicacao = fatorMultiplicacao;
    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);

        if (super.proprietario == jogadorVez) {
            System.out.println("Você caiu em sua propriedade " + this.getNome() + ". "
                    + "Portanto, nada acontecerá.");

        } else if (super.proprietario == null) {
            System.out.println("Deseja comprar a " + this.getNome() + "?");
            System.out.println("Valor: R$" + this.valorCompra);
            System.out.println("1 - Sim \n2 - Não");

            boolean entradaValida = false;

            while (!entradaValida) {
                int resposta = entrada.nextInt();

                if (resposta == 1) {
                    entradaValida = true;
                    if (jogadorVez.getSaldo() >= this.valorCompra) {
                        super.comprarPropriedade(jogadorVez);
                        jogadorVez.getIndexPropriedades().add(this.getNome());
                    } else {
                        System.out.println("Não há saldo suficiente para completar a compra.");
                    }
                } else if (resposta == 2) {
                    entradaValida = true;
                    System.out.println("Você optou por não comprar a propriedade.");
                } else {
                    System.out.println("Valor inválido. Por favor, digite 1 - Sim ou 2 - Não.");
                }
            }
        }

        if (super.proprietario != null) {

            if (super.proprietario != jogadorVez) {
                int valorPagar = somaDados * this.fatorMultiplicacao;
                System.out.println("Você caiu na " + this.getNome() + ", que já foi comprada"
                        + ". Assim, você deve pagar ao proprietário (" + super.proprietario.getNome() + ") o valor de R$" + valorPagar + ".");

                if (jogadorVez.getSaldo() >= valorPagar) {
                    jogadorVez.debito(valorPagar);
                    System.out.println("Após o pagamento, seu saldo atual é R$" + jogadorVez.getSaldo());
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + valorPagar);

                } else {
                    double saldoRestante = jogadorVez.getSaldo();
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + saldoRestante);
                    jogadorVez.debito(saldoRestante);
                    System.out.println("Saldo insuficiente! Você pagou R$" + saldoRestante + " e será eliminado(a).");

                    Tabuleiro.eliminarJogador(jogadorVez);
                }

            }
        }
    }

}
