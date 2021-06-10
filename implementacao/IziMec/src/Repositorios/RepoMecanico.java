package Repositorios;

import Classes.Mecanico;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author luism
 */


public class RepoMecanico implements IRepoMecanico {

    List<Mecanico> listarMecanico = new ArrayList<Mecanico>();

    @Override
    public boolean salvarMecanico(Mecanico mecanico) {
        try{
            listarMecanico.add(mecanico);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deletarMecanicoCPF(String cpf) {
        List<Mecanico> lista;
        lista = Classes.Principal.rm.listarMecanico();
        for(Mecanico mecanico : lista){
            if(mecanico.getCPF().equals(cpf)) {
                String opt = JOptionPane.showInputDialog("Deseja excluir o(a) mecânico(a) " +
                        ""+mecanico.getNome()+"?\n\n1 - Sim\n2 - Não");
                if(opt.equals("1")){
                    try{
                        listarMecanico.remove(lista.indexOf(mecanico));
                        JOptionPane.showMessageDialog(null,"Mecânico excluído com sucesso!");
                        return true;
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
                        return false;
                    }
                }else if(opt.equals("2")){
                    JOptionPane.showMessageDialog(null,"Abortando operação!");
                    return false;
                }else{
                    JOptionPane.showMessageDialog(null,"Opção inválida!");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<Mecanico> listarMecanico() {
        return listarMecanico;
    }

    @Override
    public boolean editarMecanico(Mecanico mecanico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
