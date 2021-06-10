package Classes;

/**
 *
 * @author luism
 */
public class Mecanico {
    private String nome;
    private String cpf;
    private String nivelOp;
    private String endereco;
    private String telefone;

    public Mecanico() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getNivelOp() {
        return nivelOp;
    }

    public void setNivelOp(String nivelOp) {
        this.nivelOp = nivelOp;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
