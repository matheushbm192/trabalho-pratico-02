
public class Lote extends Propriedade {
    private int valores[];
    private int statusMelhoria = 0; // é incrementado de acordo com o nivel de melhoria da propriedade // criar função parar incrementar status de melhoria
    private int valorMelhoria; // preço que o dono do lote paga para melhorar

    public Lote(String nome, int valorCompra, int[] valores, int statusMelhoria, int valorMelhoria) {
        super(nome, valorCompra);
        this.valores = valores;
        this.statusMelhoria = statusMelhoria;
        this.valorMelhoria = valorMelhoria;
    }


}

