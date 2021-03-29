package testeConexao;

import javax.persistence.EntityManager;
import Util.JPAUtil;

public class testeConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager sessao = JPAUtil.getEntityManager();
		System.out.println(sessao);
		sessao.close();

	}

}
