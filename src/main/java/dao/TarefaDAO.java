package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Domain.Funcionario;
import Domain.Tarefa;
import Util.JPAUtil;

public class TarefaDAO {

	public void salvar(Tarefa tarefa) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(tarefa);
		transacao.commit();
		sessao.close();
	}

	public Tarefa buscarTarefa(Integer numero) {
		EntityManager sessao = JPAUtil.getEntityManager();
		return sessao.find(Tarefa.class, numero);
	}

	public List<Tarefa> listarTarefas() {
		String jpql = "select t from Tarefa t order by numero";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefa> tarefas = consulta.getResultList();
		return tarefas;
	}
	
	public void removerTarefa(Tarefa tarefa) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.remove(sessao.find(Tarefa.class, tarefa.getNumero()));
		transacao.commit();
		sessao.close();
	}
	
	public void alterarTarefa(Tarefa tarefa) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(tarefa);
		transacao.commit();
		sessao.close();
	}
	
	public List<Tarefa> listarTarefasNumero(Integer numero) {
		String jpql = "select t from Tarefa t where t.numero="+numero+" order by numero";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefa> tarefas = consulta.getResultList();
		return tarefas;
	}
	
	public List<Tarefa> listarTarefasStatus(boolean status) {
		String jpql = "select t from Tarefa t where t.status="+status+" order by numero";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefa> tarefas = consulta.getResultList();
		return tarefas;
	}
	
	public List<Tarefa> listarTarefasTitulo(String titulo) {
		String jpql = "select t from Tarefa t where t.titulo like '%"+titulo+"%' order by numero";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefa> tarefas = consulta.getResultList();
		return tarefas;
	}
	
	public List<Tarefa> listarTarefasPrioridade(String prioridade) {
		String jpql = "select t from Tarefa t where t.prioridade like "+prioridade+" order by numero";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefa> tarefas = consulta.getResultList();
		return tarefas;
	}
	
	public List<Tarefa> listarTarefasFuncionario(Funcionario funcionario) {
		String jpql = "select t from Tarefa t where t.funcionario_idfuncionario="+funcionario.getIdFuncionario()+" order by numero";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefa> tarefas = consulta.getResultList();
		return tarefas;
	}
	
}
