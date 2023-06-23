package Controller;

import Data.Repository.ClienteRepository;
import Model.Cliente;
import br.com.caelum.stella.validation.CPFValidator;

public class ClienteController {

    private ClienteRepository clienteRepository = new ClienteRepository();

    public void cadastrarCliente(Cliente cliente){
        if (clienteRepository.clienteJaExiste(cliente)){throw new IllegalArgumentException("Cliente já cadastrado");}
        clienteRepository.adicionarCliente(cliente);
    }
    public static boolean verificarCpf(String cpf) {
        try{
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            System.out.println("\ncpf digitado invalido!\n");
            return false;
        }
    }
    public Cliente login(String email,String senha){
        if (clienteRepository.procuraClienteEmail(email,senha)!= null) return clienteRepository.procuraClienteEmail(email,senha);
        else throw new IllegalArgumentException("Cliente não cadastrado");
    }
}
