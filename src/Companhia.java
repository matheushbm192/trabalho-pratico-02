import java.util.Scanner;

//subclasse de Propriedade 
public class Companhia extends Propriedade {
    //declaração de variável
    private int fatorMultiplicacao;

    Scanner entrada = new Scanner(System.in);
    
    //construtor
    public Companhia(String nome, int valorCompra, int fatorMultiplicacao) {
        super(nome, valorCompra);
        this.fatorMultiplicacao = fatorMultiplicacao;
    }


    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);
        
        //verifica se a propriedade é do jogador da vez 
        if (super.proprietario == jogadorVez) {
            System.out.println("Você caiu em sua propriedade " + this.getNome() + ". "
                    + "Portanto, nada acontecerá.");
            
          //verifica se tem proprietário
        } else if (super.proprietario == null) {
            //se não tiver proprietário, pergunta ao usuário se ele quer comprar a companhia 
            System.out.println("Deseja comprar a " + this.getNome() + "?");
            System.out.println("Valor: R$" + this.valorCompra);
            System.out.println("1 - Sim \n2 - Não");

            boolean entradaValida = false;
            
            //laço para caso o usuário não informe uma entrada válida 
            while (!entradaValida) {
                int resposta = entrada.nextInt();
                
                //verifica a resposta do usuário
                if (resposta == 1) {
                    entradaValida = true;
                    //verifica se tem saldo suficiente para efetivar a compra 
                    if (jogadorVez.getSaldo() >= this.valorCompra) {
                        //aciona o método para comprar propriedade
                        super.comprarPropriedade(jogadorVez);
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
        
        //caso tenha proprietário
        if (super.proprietario != null) {
            
            //verifica se o proprietário não é o jogador da vez 
            if (super.proprietario != jogadorVez) {
                //calcula o valor a pagar de acordo com o fator de multiplicação 
                int valorPagar = somaDados * this.fatorMultiplicacao;
                System.out.println("Você caiu na " + this.getNome() + ", que já foi comprada"
                        + ". Assim, você deve pagar ao proprietário "
                        + "(" + super.proprietario.getNome() + ") o "
                                + "valor de R$" + valorPagar + ".");
                
                //analisa se o jogador da vez tem saldo sufuciente para pagar
                if (jogadorVez.getSaldo() > valorPagar) {
                    //debita o valor do aluguel no saldo do jogador 
                    jogadorVez.debito(valorPagar);
                    System.out.println("Após o pagamento, seu saldo "
                            + "atual é R$" + jogadorVez.getSaldo());
                    //adiciona o valor pago ao saldo do proprietário 
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + valorPagar);

                } else {
                    //se o jogador não tiver saldo sufuciente ele passa ao proprietário o restante que ele tem
                    double saldoRestante = jogadorVez.getSaldo();
                    super.proprietario.setSaldo(super.proprietario.getSaldo() + saldoRestante);
                    jogadorVez.debito(saldoRestante);
                    System.out.println("Saldo insuficiente! Você "
                            + "pagou R$" + saldoRestante + " e será eliminado(a).");
                    
                    //com o saldo do jogador da vez zerado ele deve ser eliminado 
                    Tabuleiro.eliminarJogador(jogadorVez);
                }

            }
        }
    }

}