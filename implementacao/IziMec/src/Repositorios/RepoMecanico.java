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
        if(!lista.isEmpty()) {
            for (Mecanico mecanico : lista) {
                if (mecanico.getCPF().equals(cpf)) {
                    String opt = JOptionPane.showInputDialog("Deseja excluir o(a) mecânico(a) " +
                            "" + mecanico.getNome() + "?\n\n1 - Sim\n2 - Não");
                    if (opt.equals("1")) {
                        try {
                            listarMecanico.remove(lista.indexOf(mecanico));
                            JOptionPane.showMessageDialog(null, "Mecânico excluído com sucesso!");
                            return true;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                            return false;
                        }
                    } else if (opt.equals("2")) {
                        JOptionPane.showMessageDialog(null, "Abortando operação!");
                        return false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mecânico não encontrado!");
                    return false;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Não há mecânicos cadastrados!");
            return false;
        }
        return true;
    }

    @Override
    public List<Mecanico> listarMecanico() {
        if(listarMecanico.isEmpty())
            JOptionPane.showMessageDialog(null,"Não há mecânicos cadastrados!");
        return listarMecanico;
    }

    @Override
    public boolean editarMecanico(String cpf) {
        List<Mecanico> lista;
        lista = Classes.Principal.rm.listarMecanico();
        for(Mecanico mecanico : lista){
            if(mecanico.getCPF().equals(cpf)) {
                String opt = JOptionPane.showInputDialog("Deseja editar o(a) mecânico(a) " +
                        ""+mecanico.getNome()+"?\n\n1 - Sim\n2 - Não");
                if(opt.equals("1")){
                    try{
                        int idx = lista.indexOf(mecanico);
                        listarMecanico.remove(lista.indexOf(mecanico));
                        Mecanico m = new Mecanico();
                        // nome;
                        // cpf;
                        // nivelOp;
                        // endereco;
                        // telefone;
                        m.setNome(JOptionPane.showInputDialog("Digite o nome do(a) mecânico(a):"));
                        m.setCPF(JOptionPane.showInputDialog("Digite o CPF do(a) mecânico(a):"));
                        m.setNivelOp(JOptionPane.showInputDialog("Digite o nível operacional do(a) mecânico(a):"));
                        m.setEndereco(JOptionPane.showInputDialog("Digite o endereço do(a) mecânico(a):"));
                        m.setTelefone(JOptionPane.showInputDialog("Digite o telefone do(a) mecânico(a):"));
                        listarMecanico.add(idx, m);
                        JOptionPane.showMessageDialog(null,"Mecânico editado com sucesso!");
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

}
