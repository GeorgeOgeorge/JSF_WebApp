package dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import Domain.Funcionario;
import Domain.Tarefa;

public class TarefaDAOTest {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	private TarefaDAO tarefaDAO = new TarefaDAO();

	Funcionario f1 = new Funcionario(1, "junior", "988066838");
	Funcionario f2 = new Funcionario(2, "paulo", "987168938");
	Funcionario f3 = new Funcionario(3, "roberto", "123456789");

	// to usando aqui pq tem que existir um funcionario cadastrado antes de uma
	// tarefa, não faz sentido criar uma tarefa se não tem ninguem pra resolver
	// aquele problema
	@Test
	public void a() {
		Funcionario f1 = new Funcionario(null, "junior", "988066838");
		Funcionario f2 = new Funcionario(null, "paulo", "987168938");
		Funcionario f3 = new Funcionario(null, "roberto", "123456789");

		funcionarioDAO.salvar(f1);
		funcionarioDAO.salvar(f2);
		funcionarioDAO.salvar(f3);
	}

	// salvar
	@Test
	public void b() {
		Tarefa t1 = new Tarefa(null, false, "lavar a louça", "tem louça suja", "alta", LocalDate.now(), f1);
		tarefaDAO.salvar(t1);
		Tarefa t2 = new Tarefa(null, false, "varrer o chao", "o chao ta sujo", "media", LocalDate.now(), f2);
		tarefaDAO.salvar(t2);
	}

	// busca de uma tarefa
	@Test
	public void c() {
		Tarefa t = tarefaDAO.buscarTarefa(2);
		System.out.println("numero: " + t.getNumero() + "\ntitulo: " + t.getTitulo() + "\ndescricao: "
				+ t.getDescricao() + "\nprioridade: " + t.getPrioridade() + "\ndata: " + t.getDeadLine()
				+ "\nfuncionario: " + t.getFuncionario());
	}

	// listar tarefas
	@Test
	public void d() {
		List<Tarefa> tarefas = tarefaDAO.listarTarefas();
		for (Tarefa t : tarefas) {
			System.out.println("numero: " + t.getNumero() + "\ntitulo: " + t.getTitulo() + "\ndescricao: "
					+ t.getDescricao() + "\nprioridade: " + t.getPrioridade() + "\ndata: " + t.getDeadLine()
					+ "\nfuncionario: " + t.getFuncionario());
		}

	}

}
