package Repositorios;

/**
 *
 * @author luism
 */
import java.util.*;

import Classes.Cliente;

public interface IRepoCliente {
    public boolean salvarCliente(Cliente cliente);
    public boolean deletarClienteCPF (String cpf);
    public List<Cliente> listarCliente();
    public boolean editarCliente (String cpf);
}
