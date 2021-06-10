package Repositorios;

/**
 *
 * @author luism
 */
import java.util.*;

import Classes.Mecanico;

public interface IRepoMecanico {
    public boolean salvarMecanico(Mecanico mecanico);
    public boolean deletarMecanicoCPF (String cpf);
    public List<Mecanico> listarMecanico();
    public boolean editarMecanico (Mecanico mecanico);
}
