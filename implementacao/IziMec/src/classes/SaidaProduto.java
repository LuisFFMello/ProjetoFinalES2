package Classes;

public class SaidaProduto {
    private String id;
    private String nome;
    private int qtde;
    private double valorTotal;
    private String mesSaida;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMesSaida() {
        return mesSaida;
    }

    public void setMesSaida(String mesSaida) {
        this.mesSaida = mesSaida;
    }
}
