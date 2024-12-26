
public class Imposto extends Posicao {

    public Imposto(String nome) {
        super(nome);
    }

    public double valorImposto(double saldo) {
        double valorImposto;

        if (saldo < 1903.98) {
            return valorImposto = 0.0;
        } else if (saldo > 1903.99 && saldo < 2826.65) {
            return valorImposto = 142.80;
        } else if (saldo > 2826.66 && saldo < 3751.05) {
            return valorImposto = 354.80;
        } else if (saldo > 3751.06 && saldo < 4664.68) {
            return valorImposto = 636.13;
        } else {
            return valorImposto = 869.36;
        }
    }
}

