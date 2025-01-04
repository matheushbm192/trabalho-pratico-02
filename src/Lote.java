import java.util.Scanner;

//subclasse de Prorpiedade
public class Lote extends Propriedade {

    //declaração de variáveis
    //array que guarda os valores dos alugueis de acordo com as melhorias
    private int valores[];
    //variável que armazena o status da melhoria
    private int statusMelhoria = 1;
    Scanner entrada = new Scanner(System.in);

    //construtor
    public Lote(String nome, int valorCompra, int[] valores) {
        super(nome, valorCompra);
        this.valores = valores;

    }

    @Override
    //método
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);

        //variável index para servir de aux
        int index = statusMelhoria - 1;
        //armazena o valor a pagar de acordo com a melhoria
        int valorPagar = valores[index];

        //verifica se não tem proprietário
        if (super.proprietario == null) {
            //Oferece ao usuário a oportunidade de comprar o lote
            System.out.println("Deseja comprar o Lote " + this.getNome() + "?");
            System.out.println("Valor: R$" + this.valorCompra);
            System.out.println("1 - Sim \n2 - Não");

            boolean entradaValida = false;

            //laço que repete ate a resposta do usuário ser válida
            while (!entradaValida) {
                int resposta = entrada.nextInt();

                if (resposta == 1) {
                    entradaValida = true;
                    //avalia se o jogador tem saldo suficiente para efetivar a compra
                    if (jogadorVez.getSaldo() >= this.valorCompra) {
                        //se tiver, aciona o método comprarPropriedade
                        super.comprarPropriedade(jogadorVez);
                        jogadorVez.getIndexPropriedades().add(this.getNome());
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
            //verifica se o proprietário é o jogador da vez e se a melhoria já está no seu máximo (3)
        } else if (super.proprietario == jogadorVez && this.statusMelhoria == 3) {
            System.out.println("Você caiu em sua propriedade " + this.getNome() + ". "
                    + "Ela já chegou no mais alto nível de melhoria. Portanto, nada acontecerá.");

            //se não tiver, oferece ao proprietário para realizar melhorias em seu lote
        } else if (super.proprietario == jogadorVez && this.statusMelhoria < 3) {
            System.out.println("Deseja melhorar o Lote " + this.getNome() + " para nivel " + (this.statusMelhoria + 1) + "?");
            System.out.println("Valor: R$" + valorPagar);
            System.out.println("1 - Sim \n2 - Não");

            boolean entradaValida = false;

            //laço que roda enquanto a resposta for inválida
            while (!entradaValida) {
                int resposta2 = entrada.nextInt();

                if (resposta2 == 1) {
                    entradaValida = true;
                    if (jogadorVez.getSaldo() >= this.valorCompra) {
                        //aumenta o status de melhoria do lote
                        this.statusMelhoria += 1;
                        //debita do saldo do jogador o valor da melhoria do lote
                        jogadorVez.debito(valorPagar);
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
        //verifica se tem proprietário
        if (super.proprietario != null) {
            //verifica se o proprietário não é o jogador da vez
            if (super.proprietario != jogadorVez) {

                System.out.println("Você caiu na propriedade " + this.getNome() + ", que já foi comprada e está no nível " + statusMelhoria
                        + ". Assim, você deve pagar ao proprietário (" + super.proprietario.getNome() + ") o valor de R$" + valorPagar + ".");

                //verifica se o jogador da vez tem saldo suficiente para pagar o aluguel
                if (jogadorVez.getSaldo() > valorPagar) {
                    //debita o valor do aluguel do saldo
                    jogadorVez.debito(valorPagar);
                    System.out.println("Após o pagamento, seu saldo atual é R$" + jogadorVez.getSaldo());
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + valorPagar);
                } else {

                    //se o jogador não tiver saldo sufuciente ele passa ao proprietário o restante que ele tem
                    double saldoRestante = jogadorVez.getSaldo();
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + saldoRestante);
                    jogadorVez.debito(saldoRestante);
                    System.out.println("Saldo insuficiente! Você "
                            + "pagou R$" + saldoRestante + " e será eliminado(a).");


                }
            }
        }
    }
}
