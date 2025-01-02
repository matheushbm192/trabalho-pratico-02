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

        if (super.proprietario == null) {
            System.out.println("Deseja comprar o Lote " + this.getNome() + "?");
            System.out.println("Valor: R$" + this.valorCompra);
            System.out.println("1 - Sim \n2 - Não");

            boolean entradaValida = false;

            while (!entradaValida) {
                int resposta = entrada.nextInt();

                if (resposta == 1) {
                    entradaValida = true;
                    if (jogadorVez.getSaldo() >= this.valorCompra) {
                        super.comprarPropriedade(jogadorVez);
                    } else {
                        System.out.println("Não há saldo suficiente para completar a compra.");
                    }
                } else if (resposta == 2) {
                    entradaValida = true;
                    System.out.println("Você optou por não comprar o Lote.");
                } else {
                    System.out.println("Valor inválido. Por favor, digite 1 - Sim ou 2 - Não.");
                }
            }
        } else if (super.proprietario == jogadorVez && this.statusMelhoria == 3) {
            System.out.println("Você caiu em sua propriedade " + this.getNome() + ". "
                    + "Ela já chegou no mais alto nível de melhoria. Portanto, nada acontecerá.");

        } else if (super.proprietario == jogadorVez && this.statusMelhoria < 3) {
            System.out.println("Deseja melhorar o Lote " + this.getNome() + " para nivel " + (this.statusMelhoria + 1) + "?");
            System.out.println("Valor: R$" + super.valorCompra);
            System.out.println("1 - Sim \n2 - Não");

            boolean entradaValida = false;

            while (!entradaValida) {
                int resposta2 = entrada.nextInt();

                if (resposta2 == 1) {
                    entradaValida = true;
                    if (jogadorVez.getSaldo() >= this.valorCompra) {
                        this.statusMelhoria += 1;
                        jogadorVez.debito(super.valorCompra);
                        System.out.println("Lote melhorado para o nível " + this.statusMelhoria + ".");
                        System.out.println("Seu saldo atual após a melhoria é de R$" + jogadorVez.getSaldo());
                    } else {
                        System.out.println("Não há saldo suficiente para melhorar o Lote.");
                    }
                } else if (resposta2 == 2) {
                    entradaValida = true;
                    System.out.println("Você decidiu não melhorar o Lote.");
                } else {
                    System.out.println("Valor inválido. Por favor, digite 1 - Sim ou 2 - Não.");
                }
            }
        }
        if (super.proprietario != null) {
            if (super.proprietario != jogadorVez) {
                int index = statusMelhoria - 1;
                int valorPagar = valores[index];


                System.out.println("Você caiu na propriedade " + this.getNome() + ", que já foi comprada e está no nível " + statusMelhoria +
                   ". Assim, você deve pagar ao proprietário (" + super.proprietario.getNome() + ") o valor de R$" + valorPagar + ".");

                if (jogadorVez.getSaldo() >= valorPagar) {
                    jogadorVez.debito(valorPagar);
                    System.out.println("Após o pagamento, seu saldo atual é R$" + jogadorVez.getSaldo());
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + valorPagar);
                } else {
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + jogadorVez.getSaldo());
                    jogadorVez.debito(jogadorVez.getSaldo());

                }
            }
        }
    }
}

