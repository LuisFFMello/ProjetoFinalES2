package Classes;

import Repositorios.RepoMecanico;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author luism
 */

public class Principal {
    //variável estática global para salvar as listas
    public static RepoMecanico rm = new RepoMecanico();

    public static void main(String args[]) {

        testeMecanicos();
        ListarMecanicos();
        //BuscarMecanicoPorCPF(JOptionPane.showInputDialog("Digite o cpf do mecânico para buscar: "));
        //rm.deletarMecanicoCPF(JOptionPane.showInputDialog("Digite o cpf do mecânico para remover: "));
        rm.editarMecanico(JOptionPane.showInputDialog("Digite o cpf do mecânico para editar:"));
        ListarMecanicos();
    }

    static void testeMecanicos(){

        Mecanico mec = new Mecanico();
        Mecanico mec2 = new Mecanico();
        Mecanico mec3 = new Mecanico();
        Mecanico mec4 = new Mecanico();

        boolean salvo;

        mec.setCPF("1236");
        mec.setNome("Juarez da Tekpix");
        mec.setEndereco("Rua das Magnolias, 112, Little Winging, Surrey");
        mec.setNivelOp("Pleno");
        mec.setTelefone("1140028922");

        rm.salvarMecanico(mec);

        mec2.setCPF("1632");
        mec2.setNome("Aracy TopTherm");
        mec2.setEndereco("Rua das Magnolias, 418, Little Winging, Surrey");
        mec2.setNivelOp("Junior");
        mec2.setTelefone("1140028933");

        rm.salvarMecanico(mec2);

        mec3.setCPF("6321");
        mec3.setNome("By Ano");
        mec3.setEndereco("Rua das Magnolias, 4544, Little Winging, Surrey");
        mec3.setNivelOp("Senior");
        mec3.setTelefone("1140028944");

        rm.salvarMecanico(mec3);

        mec4.setCPF("8543");
        mec4.setNome("Lampião");
        mec4.setEndereco("Rua das Magnolias, 1454, Little Winging, Surrey");
        mec4.setNivelOp("Senior");
        mec4.setTelefone("1140028999");

        rm.salvarMecanico(mec4);
    }

    public static void ListarMecanicos(){
        List<Mecanico> lista;
        lista = rm.listarMecanico();
        String x = "a";
        int a = 1;
        for(Mecanico mecanico : lista){
            x = "Mecanico "+String.valueOf(a);
            JOptionPane.showMessageDialog(null,"Nome: "+mecanico.getNome()+
            "\nCPF: "+mecanico.getCPF()+
            "\nNivel Operacional: "+mecanico.getNivelOp()+
            "\nEndereço: "+mecanico.getEndereco()+
            "\nTelefone: "+mecanico.getTelefone(), x, 1 );
            a++;
            //System.out.println("=========================================================");
        }
    }

    public static void BuscarMecanicoPorCPF(String cpf){
        List<Mecanico> lista;
        lista = rm.listarMecanico();
        boolean flg = false;

        for(Mecanico mecanico : lista){
            if(mecanico.getCPF().equals(cpf)) {
                JOptionPane.showMessageDialog(null,"Nome: "+mecanico.getNome()+
                        "\nCPF: "+mecanico.getCPF()+
                        "\nNivel Operacional: "+mecanico.getNivelOp()+
                        "\nEndereço: "+mecanico.getEndereco()+
                        "\nTelefone: "+mecanico.getTelefone(), "Mecânico", 1 );
                flg = true;
            }
        }
        if(!flg)
            JOptionPane.showMessageDialog(null,"Mecânico não encontrado!","Busca",2);
    }
}
