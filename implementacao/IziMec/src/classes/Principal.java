package Classes;

import Repositorios.*;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author luism
 */

public class Principal {
    //variáveis para salvar as listas
    public static RepoMecanico rm = new RepoMecanico();
    public static RepoCliente rc = new RepoCliente();
    public static List<SaidaProduto> ls = new ArrayList<SaidaProduto>();

    public static void main(String args[]) {


        testarInventario();

        boolean flg, auxiliar;
        flg = auxiliar = true;
        int opt;
        do{
            do{
                opt = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção:\n\n1 - Gestão de Mecânicos\n2 - Gestão de Clientes\n3 - Sair"));
            }while(opt < 1 || opt > 3);

            switch(opt) {
                case 1:
                    int aux = 0;
                    do {
                        aux = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção:\n\n1 - Cadastrar\n2 - Alterar\n3 - Buscar\n4 - Remover\n5 - Listar todos\n6 - Sair"));
                        switch (aux) {
                            case 1:
                                Mecanico mec = new Mecanico();
                                mec.setCPF(JOptionPane.showInputDialog("Digite o CPF do mecânico: "));
                                mec.setNome(JOptionPane.showInputDialog("Digite o nome do mecânico: "));
                                mec.setEndereco(JOptionPane.showInputDialog("Digite o endereço do mecânico: "));
                                mec.setNivelOp(JOptionPane.showInputDialog("Digite o nível operacional do mecânico: "));
                                mec.setTelefone(JOptionPane.showInputDialog("Digite o telefone do mecânico: "));
                                rm.salvarMecanico(mec);
                                break;

                            case 2:
                                rm.editarMecanico(JOptionPane.showInputDialog("Digite o cpf do mecânico para editar:"));
                                break;

                            case 3:
                                BuscarMecanicoPorCPF(JOptionPane.showInputDialog("Digite o cpf do mecânico para buscar: "));
                                break;

                            case 4:
                                rm.deletarMecanicoCPF(JOptionPane.showInputDialog("Digite o cpf do mecânico para remover: "));
                                break;

                            case 5:
                                rm.listarMecanico();
                                break;

                            case 6:
                                flg = false;
                                break;
                        }
                    } while (flg);
                    break;
                case 2:
                    do {
                        aux = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção:\n\n1 - Cadastrar\n2 - Alterar\n3 - Buscar\n4 - Remover\n5 - Listar todos\n6 - Sair"));
                        switch (aux) {
                            case 1:
                                Cliente cli = new Cliente();
                                cli.setCPF(JOptionPane.showInputDialog("Digite o CPF do cliente: "));
                                cli.setNome(JOptionPane.showInputDialog("Digite o nome do cliente: "));
                                cli.setEndereco(JOptionPane.showInputDialog("Digite o endereço do cliente: "));
                                cli.setTelefone(JOptionPane.showInputDialog("Digite o telefone do cliente: "));
                                rc.salvarCliente(cli);
                                break;

                            case 2:
                                rc.editarCliente(JOptionPane.showInputDialog("Digite o cpf do cliente para editar:"));
                                break;

                            case 3:
                                BuscarClientePorCPF(JOptionPane.showInputDialog("Digite o cpf do cliente para buscar: "));
                                break;

                            case 4:
                                rc.deletarClienteCPF(JOptionPane.showInputDialog("Digite o cpf do cliente para remover: "));
                                break;

                            case 5:
                                rc.listarCliente();
                                break;

                            case 6:
                                flg = false;
                                break;
                        }
                    } while (flg);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Finalizando IziMec...");
                    auxiliar = false;
                    break;
            }
        }while(auxiliar);

    }

    //MECÂNICOS

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

    //CLIENTES

    static void testeCliente(){

        Cliente cli = new Cliente();
        Cliente cli2 = new Cliente();
        Cliente cli3 = new Cliente();
        Cliente cli4 = new Cliente();

        boolean salvo;

        cli.setCPF("9876");
        cli.setNome("José Cuervo");
        cli.setEndereco("Alameda das Glicínias, 200, Little Winging, Surrey");
        cli.setTelefone("1140028922");

        rc.salvarCliente(cli);

        cli2.setCPF("9764");
        cli2.setNome("Adjest Tiana");
        cli2.setEndereco("Alameda das Glicínias, 300, Little Winging, Surrey");
        cli2.setTelefone("1140028933");

        rc.salvarCliente(cli2);

        cli3.setCPF("9731");
        cli3.setNome("Tuatha de Danann");
        cli3.setEndereco("Alameda das Glicínias, 400, Little Winging, Surrey");
        cli3.setTelefone("1140028944");

        rc.salvarCliente(cli3);

        cli4.setCPF("8246");
        cli4.setNome("Conde Lampreia");
        cli4.setEndereco("Alameda das Glicínias, 500, Little Winging, Surrey");
        cli4.setTelefone("1140028999");

        rc.salvarCliente(cli4);
    }

    public static void BuscarClientePorCPF(String cpf){
        List<Cliente> lista;
        lista = rc.listarCliente();
        boolean flg = false;

        for(Cliente cliente : lista){
            if(cliente.getCPF().equals(cpf)) {
                JOptionPane.showMessageDialog(null,"Nome: "+cliente.getNome()+
                        "\nCPF: "+cliente.getCPF()+
                        "\nEndereço: "+cliente.getEndereco()+
                        "\nTelefone: "+cliente.getTelefone(), "Cliente", 1 );
                flg = true;
            }
        }
        if(!flg)
            JOptionPane.showMessageDialog(null,"Cliente não encontrado!","Busca",2);
    }

    public static void ListarCliente(){
        List<Cliente> lista;
        lista = rc.listarCliente();
        String x;
        int a = 1;
        for(Cliente cliente : lista){
            x = "Cliente "+String.valueOf(a);
            JOptionPane.showMessageDialog(null,"Nome: "+cliente.getNome()+
                    "\nCPF: "+cliente.getCPF()+
                    "\nEndereço: "+cliente.getEndereco()+
                    "\nTelefone: "+cliente.getTelefone(), x, 1 );
            a++;
        }
    }

    //PRODUTOS

    static void testarInventario(){
        SaidaProduto sp = new SaidaProduto();
        SaidaProduto sp2 = new SaidaProduto();

        sp.setId("12");
        sp.setNome("Biela");
        sp.setQtde(1125);
        sp.setValorTotal(sp.getQtde()*45);
        sp.setMesSaida("04");
        ls.add(sp);

        sp2.setId("13");
        sp2.setNome("Biela");
        sp2.setQtde(1485);
        sp2.setValorTotal(sp2.getQtde()*45);
        sp2.setMesSaida("05");
        ls.add(sp2);

        Inventario inv = new Inventario();

    }
}
