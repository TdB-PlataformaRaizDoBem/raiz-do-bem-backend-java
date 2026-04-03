package RaizDoBem.model.bo;

import RaizDoBem.model.dao.BeneficiarioDAO;
import RaizDoBem.model.vo.Beneficiario;

import java.util.List;

public class BeneficiarioBO {
    BeneficiarioDAO dao = new BeneficiarioDAO();
    Beneficiario beneficiario = new Beneficiario();

    public void adicionar(Beneficiario beneficiario){
        if(beneficiario!=null){
            dao.adicionar(beneficiario);
        }
        else{
            throw new RuntimeException("Endereço inválido!!!");
        }
    }

    public Beneficiario buscaPorCpf(String cpf){
        return dao.buscarPorCpf(cpf);
    }
    public List<Beneficiario> listarBeneficiarios() {
        return dao.listarTodos();
    }

    public List<Beneficiario> listagemPorCidade(String cidade){
        return dao.listarPorCidade(cidade);
    }

    public List<Beneficiario> listagemPorPrograma(int idPrograma){
        return dao.buscarPorPrograma(idPrograma);
    }

    public void atualizarBeneficiario(String cpf, Beneficiario beneficiarioAtualizado){
        beneficiario = dao.buscarPorCpf(cpf);

        if(beneficiario != null){
            dao.atualizar(cpf, beneficiarioAtualizado);
        }
        throw new RuntimeException("Beneficiário não encontrado!!!");
    }

    public void excluirBeneficiario(String cpf){
        beneficiario = dao.buscarPorCpf(cpf);
        if(beneficiario != null){
            dao.excluir(cpf);
        }
        else{
            throw new RuntimeException("Beneficiário não encontrado!!!");
        }
    }

    public Boolean validarCpf(String cpf){
        return(cpf != null && cpf.length() == 11);
    }
}
