
public class Imposto extends Posicao {

    public Imposto(String nome) {
        super(nome);
    }

    @Override
    public void acaoDado(int somaDados, Jogador jogadorVez) {
        super.acaoDado(somaDados, jogadorVez);

        double saldo = jogadorVez.getSaldo();
        if (saldo < 1903.98) {
            jogadorVez.debito( 0.0);
        } else if (saldo > 1903.99 && saldo < 2826.65) {
            jogadorVez.debito(142.80);
        } else if (saldo > 2826.66 && saldo < 3751.05) {
            jogadorVez.debito(354.80);
        } else if (saldo > 3751.06 && saldo < 4664.68) {
            jogadorVez.debito(636.13);
        } else {
            jogadorVez.debito(869.36);
        }
    }


}

