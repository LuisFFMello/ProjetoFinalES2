/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LUISFELIPEFERREIRADE
 */
public class Produto {
    private String nome;
    private String id;
    private Date dataSaida;
    private Date dataAtual = new Date();
    int dif =0;

    
    
    public Produto(String nome, String id, String dataSaida) {
        this.nome = nome;
        this.id = id;
        try {
            this.dataSaida = new SimpleDateFormat ("dd/MM/yyyy").parse(dataSaida);
        } catch (ParseException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        dif = dataAtual.getMonth() - this.dataSaida.getMonth();
    }

    
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the dataSaida
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

}
