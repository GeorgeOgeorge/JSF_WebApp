package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import Domain.Funcionario;
import Domain.Tarefa;
import dao.FuncionarioDAO;
import dao.TarefaDAO;
import lombok.Data;

@Named
@Data
@ViewScoped
public class TarefaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private TarefaDAO tarefaDAO;
	private Tarefa tarefa;
	private List<Tarefa> tarefas;

	private FuncionarioDAO funcionarioDAO;
	private List<Funcionario> funcionarios;

	// me perdoem deuses da programação pela gambiarra, maldito tutorial que me
	// ensinou a fazer validação via dominio em vez de form, se der tempo vou mudar
	// de volta
	private Integer numero;
	private String titulo;
	private boolean status;
	private String prioridade;
	private Funcionario funcionario;

	@PostConstruct
	public void iniciarTarefa() {
		this.tarefaDAO = new TarefaDAO();
		this.refreshTarefa();
		this.funcionarioDAO = new FuncionarioDAO();
		this.funcionarios = funcionarioDAO.listarFuncionarios();
	}

	private void refreshTarefa() {
		this.tarefa = new Tarefa();
		this.listarTarefas();
	}

	public void listarTarefas() {
		this.tarefas = this.tarefaDAO.listarTarefas();
	}

	public void buscarTarefa(Tarefa tarefaSelecionada) {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " selecionada");
		this.tarefa = this.tarefaDAO.buscarTarefa(tarefaSelecionada.getNumero());
	}
	
	public void cadastrarTarefa() {
		this.tarefaDAO.salvar(this.tarefa);
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " cadastrada com sucesso");
		this.refreshTarefa();
	}

	public void excluirTarefa() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " removida com sucesso");
		tarefaDAO.removerTarefa(this.tarefa);
		this.refreshTarefa();
	}

	public void alterarTarefa() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " alterada com sucesso");
		tarefaDAO.alterarTarefa(this.tarefa);
		this.refreshTarefa();
	}

	public void concluirTarefa() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " concluida com sucesso");
		this.tarefa.setStatus(true);
		tarefaDAO.alterarTarefa(this.tarefa);
		this.refreshTarefa();
	}

	public void listarTarefasStatus() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " listada por Status");
		this.tarefas = this.tarefaDAO.listarTarefasStatus(this.status);
	}
	
	public void listarTarefasNumero() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " listada por Numero");
		this.tarefas = this.tarefaDAO.listarTarefasNumero(this.numero);
	}
	
	public void listarTarefasTitulo() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " listada por titulo");
		this.tarefas = this.tarefaDAO.listarTarefasTitulo(this.titulo+"");
	}
	
	public void listarTarefasPrioriade() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " listada por prioriade");
		this.tarefas = this.tarefaDAO.listarTarefasPrioridade(prioridade);
	}
	
	public void listarTarefasFuncionario() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefa.getTitulo() + " listada por Funcionario");
		this.tarefaDAO.listarTarefasFuncionario(this.funcionario);
	}

}
