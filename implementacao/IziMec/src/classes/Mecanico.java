/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author LUISFELIPEFERREIRADE
 */
public class Mecanico {
    private String nome;
    private String cpf;
    
    public Mecanico() {
    }

    public Mecanico(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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
    
    public boolean testaCPF(String cpf){
        return this.cpf.equals(cpf);
    }
}
