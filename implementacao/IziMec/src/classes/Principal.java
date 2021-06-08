/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author LUISFELIPEFERREIRADE
 */

public class Principal {
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    public static void main(String args[]) {
        Scanner ler = new Scanner(System.in);
        boolean flg = true;
        int i;
        ArrayList<Mecanico> alm = new ArrayList();
        ArrayList<Produto> alp = new ArrayList();
        ArrayList<Cliente> alc = new ArrayList();
        Iterator<Mecanico> itm = alm.iterator();
        Iterator<Produto> itp = alp.iterator();
        Iterator<Cliente> itc = alc.iterator();
        do {
            System.out.println("Digite a opção:\n\n1 - Mecânicos\n2 - Clientes\n3 - Extrair inventário\n4 - Sair");
            i = ler.nextInt();

        } while (i < 1 || i > 4);

        Produto p1 = new Produto("Biela","001","07/06/2021");
        alp.add(p1);
        Produto p2 = new Produto("Rodela","002","09/06/2021");
        alp.add(p2);
        Produto p3 = new Produto("Trivela","003","07/06/2021");
        alp.add(p3);
        Produto p4 = new Produto("Manivela","004","07/05/2021");
        alp.add(p4);
        Produto p5 = new Produto("Manivela","004","07/06/2021");
        alp.add(p5);
        Produto p6 = new Produto("Manivela","004","07/07/2021");
        alp.add(p6);
        
        System.out.println(alp.get(3).dif);
        
        Mecanico mt1 = new Mecanico ("Josué Reis","111");
        Mecanico mt2 = new Mecanico ("Reis Josué","222");
        Mecanico mt3 = new Mecanico ("José Reis","333");
        Mecanico mt4 = new Mecanico ("Reis José","444");
        Mecanico mt5 = new Mecanico ("Josué Rios","555");
        Mecanico mt6 = new Mecanico ("Rios Josué","666");
        
        alm.add(mt1);
        alm.add(mt2);
        alm.add(mt3);
        alm.add(mt4);
        alm.add(mt5);
        alm.add(mt6);
        
         
        switch(i){
            case 1:
                int opt;
                do{
                    do {
                        System.out.println("\n\nMECÂNICOS\n\n====================================================\n\n"
                                + "Digite a opção:\n\n1 - Cadastrar\n2 - Editar\n3 - Remover\n4 - Pesquisar\n5 - Sair");
                        opt = ler.nextInt();

                    } while (opt < 1 || i > 5);
                    switch(opt){
                        //CADASTRAR MECÂNICO
                        case 1:
                            String nome,cpf;
                            System.out.println("\n\nDigite o nome do mecanico");
                            nome = ler.next();
                            clearBuffer(ler);
                            System.out.flush();
                            System.out.println("\n\nDigite o cpf do mecânico");
                            cpf = ler.next();
                            clearBuffer(ler);
                            System.out.flush();
                            Mecanico m = new Mecanico(nome, cpf);
                            flg = true;
                            for (int aux = 0; aux < alm.size();aux++){
                                
                                if (alm.get(aux).getCPF().equals(m.getCPF())){
                                    System.out.println("\n\nMecanico já existente!");
                                    flg = false;
                                }
                            }
                            if (flg == true)
                                alm.add(m);
                            
                            
                        break;
                        //EDITAR MECÂNICO
                        case 2:
                            System.out.flush();
                            System.out.println("\n\nDigite o cpf do mecânico a ser editado:");
                            cpf = ler.next();
                            clearBuffer(ler);
                            flg = false;
                            for (int aux = 0; aux < alm.size();aux++){                               
                                if (alm.get(aux).getCPF().equals(cpf)){
                                    System.out.println("\n\nMecânico: " + alm.get(aux).getNome());
                                    System.out.println("\nDigite o novo nome do mecanico:");
                                    nome = ler.next();
                                    clearBuffer(ler);
                                    System.out.println("\n\nDigite o novo cpf do mecânico:");
                                    cpf = ler.next();
                                    clearBuffer(ler);
                                    alm.get(aux).setCPF(cpf);
                                    alm.get(aux).setNome(nome);
                                    aux = alm.size();
                                    flg = true;
                                }
                            }
                            if(!flg)
                                System.out.println("\n\nMecânico não encontrado!");
                            
                        break;
                        //REMOVER MECÂNICO
                        case 3:
                            System.out.flush();
                            System.out.println("\n\nDigite o cpf do mecânico a ser removido:");
                            cpf = ler.next();
                            clearBuffer(ler);
                            for (int aux = 0; aux < alm.size();aux++){                               
                                if (alm.get(aux).getCPF().equals(cpf)){
                                    System.out.println("Deseja realmente remover o cadastro do mecânico " + alm.get(aux).getNome()+"?"
                                            + " 1 para sim e 2 para não.");
                                    int o = ler.nextInt();
                                    clearBuffer(ler);
                                    switch(o){
                                        case 1:
                                            alm.remove(aux);
                                            aux = alm.size();
                                            System.out.println("\n\nMecânico excluído com sucesso!");
                                        break;
                                        case 2:
                                            System.out.println("\n\nCancelando operação\n\n========================="
                                                    + "================\n\n");
                                            aux = alm.size();
                                        break;
                                        default:
                                            aux = alm.size();
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int o;
                            do{
                                System.out.println("\n\nDigite 1 para busca por nome ou 2 para busca por CPF:");
                                o = ler.nextInt();
                                clearBuffer(ler);
                            }while(o < 1 || o > 2);
                            switch(o){
                                case 1:
                                 //A PARTIR DAQUI   
                            }
                        case 5:
                            break;
                        default:
                            System.out.println("\n\nOpção inválida");

                    }
                }while(opt != 5);
        }
         
        
    }

}
