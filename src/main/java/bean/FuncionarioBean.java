package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import Domain.Funcionario;
import dao.FuncionarioDAO;
import lombok.Data;

@Named
@Data
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private FuncionarioDAO funcionarioDAO;

	@PostConstruct
	public void instanciarFuncionario() {
		this.funcionarioDAO = new FuncionarioDAO();
		this.refreshFuncionario();
	}

	private void refreshFuncionario() {
		this.funcionario = new Funcionario();
		this.listarFuncionarios();
	}

	public void listarFuncionarios() {
		this.funcionarios = this.funcionarioDAO.listarFuncionarios();
	}

	public void buscarFuncionario(Funcionario funcionarioSelecionado) {
		this.funcionario = this.funcionarioDAO.buscar(funcionarioSelecionado.getIdFuncionario());
	}

	public void cadastrarFuncionario() {
		this.funcionarioDAO.salvar(this.funcionario);
		Messages.addFlashGlobalInfo("Funcionari@ " + funcionario.getNome() + " cadastrad@ com sucesso");
		this.refreshFuncionario();
	}

	public void removerFuncionario() {
		Messages.addFlashGlobalInfo("Funcionari@ " + this.funcionario.getNome() + " removid@ com sucesso");
		this.funcionarioDAO.excluirFuncionario(this.funcionario);
		this.refreshFuncionario();
	}

	public void alterarFuncionario() {
		Messages.addFlashGlobalInfo("Funcionari@ com id " + this.funcionario.getIdFuncionario() + " alterad@ com sucesso");
		this.funcionarioDAO.alterarFuncionario(this.funcionario);
		this.refreshFuncionario();
	}

}
