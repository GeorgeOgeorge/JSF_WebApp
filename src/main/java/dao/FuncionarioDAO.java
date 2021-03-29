package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Domain.Funcionario;
import Util.JPAUtil;

public class FuncionarioDAO {

	public void salvar(Funcionario funcionario) {
		// abre uma nova sessao de conexao
		EntityManager sessao = JPAUtil.getEntityManager();
		// cria uma transacao
		EntityTransaction transacao = sessao.getTransaction();
		// iniciando a transacao
		transacao.begin();
		// armazena um objeto funcionario numa tabela do banco
		sessao.persist(funcionario);
		// confirmando a operação
		transacao.commit();
		// fechando a sessao
		sessao.close();
	}

	public Funcionario buscar(Integer id) {
		// criando sessao para a busca OBS: nao estamos usando o transaction pq ele so
		// precisa ser usando quando se que alterar dados da tabela
		EntityManager sessao = JPAUtil.getEntityManager();
		return sessao.find(Funcionario.class, id);
	}

	public List<Funcionario> listarFuncionarios() {
		// string mistura de slq com jpa pra consultar as coisas
		String jpql = "select f from Funcionario f order by idFuncionario";
		// entidade pra acessar a sessao, como não ta alterando os dados nao precissa de
		// transaction
		EntityManager sessao = JPAUtil.getEntityManager();
		// uma query pra poder pegar o resultado da consulta
		Query consulta = sessao.createQuery(jpql);
		// uma lista de funcionarios pra poder enviar todos os funcionarios de uma vez
		// so
		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios = consulta.getResultList();
		return funcionarios;
	}
	
	//fazer metodo teste 
	public void excluirFuncionario(Funcionario funcionario) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.remove(sessao.find(Funcionario.class, funcionario.getIdFuncionario()));
		transacao.commit();
		sessao.close();
	}
	
	
	//fazer metodo teste 
	public void alterarFuncionario(Funcionario funcionario) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(funcionario);
		transacao.commit();
		sessao.close();
	}
}
