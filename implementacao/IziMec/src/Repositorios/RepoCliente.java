package Repositorios;

import Classes.*;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author luism
 */


public class RepoCliente implements IRepoCliente {

    List<Cliente> listarCliente = new ArrayList<Cliente>();

    @Override
    public boolean salvarCliente(Cliente cliente) {
        try{
            listarCliente.add(cliente);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deletarClienteCPF(String cpf) {
        List<Cliente> lista;
        lista = Classes.Principal.rc.listarCliente();
        if(!lista.isEmpty()){
            for(Cliente cliente : lista){
                if(cliente.getCPF().equals(cpf)) {
                    String opt = JOptionPane.showInputDialog("Deseja excluir o(a) Cliente?" +
                            ""+cliente.getNome()+"?\n\n1 - Sim\n2 - Não");
                    if(opt.equals("1")){
                        try{
                            listarCliente.remove(lista.indexOf(cliente));
                            JOptionPane.showMessageDialog(null,"Cliente excluído com sucesso!");
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
                }else{
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                    return false;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Não há clientes cadastrados!");
            return false;
        }
        return true;
    }

    @Override
    public List<Cliente> listarCliente() {
        if(listarCliente.isEmpty())
            JOptionPane.showMessageDialog(null,"Não há clientes cadastrados!");
        return listarCliente;
    }

    @Override
    public boolean editarCliente(String cpf) {
        List<Cliente> lista;
        lista = Classes.Principal.rc.listarCliente();
        for(Cliente cliente : lista){
            if(cliente.getCPF().equals(cpf)) {
                String opt = JOptionPane.showInputDialog("Deseja editar o(a) Cliente " +
                        ""+cliente.getNome()+"?\n\n1 - Sim\n2 - Não");
                if(opt.equals("1")){
                    try{
                        int idx = lista.indexOf(cliente);
                        listarCliente.remove(lista.indexOf(cliente));
                        Cliente c = new Cliente();
                        c.setNome(JOptionPane.showInputDialog("Digite o nome do(a) Cliente:"));
                        c.setCPF(JOptionPane.showInputDialog("Digite o CPF do(a) Cliente:"));
                        c.setEndereco(JOptionPane.showInputDialog("Digite o endereço do(a) Cliente:"));
                        c.setTelefone(JOptionPane.showInputDialog("Digite o telefone do(a) Cliente:"));
                        listarCliente.add(idx, c);
                        JOptionPane.showMessageDialog(null,"Cliente editado com sucesso!");
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
