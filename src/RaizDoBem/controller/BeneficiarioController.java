package RaizDoBem.controller;

import RaizDoBem.model.dao.BeneficiarioDAO;
import RaizDoBem.model.vo.Beneficiario;

import java.util.List;

/**
 *
 */
public class BeneficiarioController {
    private final BeneficiarioDAO beneficiarioDAO;
    Beneficiario beneficiarioEncontrado = new Beneficiario();
    public BeneficiarioController() {
        this.beneficiarioDAO = new BeneficiarioDAO();
    }

    public void adicionar(Beneficiario beneficiario){
        if(beneficiario!=null){
            beneficiarioDAO.adicionar(beneficiario);
            System.out.println("Beneficiário criado e adicionado com sucesso!!");
        }
    }

    public Beneficiario buscaPorCpf(String cpf){
        return beneficiarioDAO.buscarPorCpf(cpf);
    }
    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioDAO.listarTodos();
    }

    public List<Beneficiario> listagemPorCidade(String cidade){
        return beneficiarioDAO.listarPorCidade(cidade);
    }

    public List<Beneficiario> listagemPorPrograma(int idPrograma){
        return beneficiarioDAO.buscarPorPrograma(idPrograma);
    }

    public void atualizarBeneficiario(String cpf, Beneficiario beneficiarioAtualizado){
        beneficiarioEncontrado = beneficiarioDAO.buscarPorCpf(cpf);

        if(beneficiarioEncontrado == null){
            System.out.println("Beneficiário não encontrado!!!");
            return;
        }
        beneficiarioDAO.atualizar(cpf, beneficiarioAtualizado);
    }

    public void excluirBeneficiario(String cpf){
        beneficiarioEncontrado = beneficiarioDAO.buscarPorCpf(cpf);
        if(beneficiarioEncontrado == null){
            System.out.println("Beneficiário não encontrado!!!");
            return;
        }
        beneficiarioDAO.excluir(cpf);
    }

    public Boolean validarCpf(String cpf){
        return(cpf != null && cpf.length() == 11);
    }
    public Boolean validarSexo(int idSexo){
        return(idSexo >0 && idSexo<4);
    }
}
