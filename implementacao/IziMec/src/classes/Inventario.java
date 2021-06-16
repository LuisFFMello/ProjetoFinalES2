package Classes;

import java.text.DecimalFormat;

import static Classes.Principal.*;

public class Inventario {
    Inventario(){
        DecimalFormat df = new DecimalFormat("##0.00");
        double pct;
        String var;
        pct = (1.0 - ls.get(1).getValorTotal() / ls.get(0).getValorTotal());
        var = df.format(pct);
        System.out.println("ID produto: "+ls.get(0).getId());
        System.out.println("Nome produto: "+ls.get(0).getNome());
        System.out.println("Variação qtde: "+(ls.get(0).getQtde()-ls.get(1).getQtde()));
        System.out.println("Variação R$: "+(ls.get(0).getValorTotal()-ls.get(1).getValorTotal()));
        System.out.println("Variação percentual: "+var+"%");
    }

}