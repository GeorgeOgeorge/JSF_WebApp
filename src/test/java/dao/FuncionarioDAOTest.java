package dao;

import java.util.List;
import org.junit.Test;
import Domain.Funcionario;

public class FuncionarioDAOTest {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	// salvar funcionario no banco
	@Test
	public void a() {
		// null porque ele auto incrementa e nao precisa mandar um valor, ele se vira
		Funcionario f1 = new Funcionario(null, "junior", "988066838");
		Funcionario f2 = new Funcionario(null, "paulo", "98716893");
		Funcionario f3 = new Funcionario(null, "roberto", "1233123");

		funcionarioDAO.salvar(f1);
		funcionarioDAO.salvar(f2);
		funcionarioDAO.salvar(f3);
	}

	// buscar um funcionario especifico
	@Test
	public void b() {
		Funcionario f = funcionarioDAO.buscar(1);
		System.out.println(
				"IdFuncionario: " + f.getIdFuncionario() + "\nnome: " + f.getNome() + "\ntelefone: " + f.getTelefone());
	}

	// listar funcionarios
	@Test
	public void c() {
		List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
		for (Funcionario f : funcionarios) {
			System.out.println("\nIdFuncionario: " + f.getIdFuncionario() + "\nnome: " + f.getNome() + "\ntelefone: "
					+ f.getTelefone());
		}
	}

}
