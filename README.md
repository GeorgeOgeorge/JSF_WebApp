# Projeto_ESIG
Essa aplicação Java-Web de gerenciamento de dados foi implementada como requisito de participação em uma seleção de vagas de estágio para a ESIG. Nela foram utilizados conceitos do desenvolvimento em três camadas em conjunto com a implementação web, que por sua vez utiliza as tecnologias JSF e JPA .

## Programas, aplicações, bibliotecas e dependencias utilizadas

### [Java-8.0](https://www.java.com/pt-BR/download/help/whatis_java.html)
Linguagem de programação utilizada

### [Maven](https://maven.apache.org/index.html)
Gerenciador de projetos que ajuda o desenvolvedor com o controle e manejamento das:
-> *Dependencias*
-> Bilds
-> Documentação
-> Etc

### [PostgreSQL](https://www.postgresql.org/)
PostgreSQL é um sistema gerenciador de banco de dados objeto relacional.

### [TomCat Apache](http://tomcat.apache.org/)
O Tomcat é um servidor Java-Web, que implementa as tecnologias Java Servlet e JavaServer Pages, permitindo assim, que a aplicação esteja disponivel para coneção em Navegador. 

### [Lombok](https://projectlombok.org/)
Biblioteca que agiliza muitas das implementações que seriam realizadas 
*write less code more*

### [PrimeFaces](https://www.primefaces.org/)
O PrimeFaces é uma biblioteca de componentes de interface de usuário de código-fonte aberto para aplicativos baseados em JavaServer Faces

### [dependencias utilizadas](https://github.com/GeorgeOgeorge/Projeto_Esig/blob/master/pom.xml)
-> hibernate-core 5.4.12.Final  

-> postgresql 42.2.19  

-> junit 4.13.2  

-> lombok 1.18.18  

-> javax.faces 2.4.0  

-> primefaces 8.0  

-> weld-servlet-core 3.1.4.Final  

-> omnifaces 3.5  

-> javax.validation validation-api 2.0.1.Final  

-> hibernate-validator 6.0.13.Final  

## Telas e funcionalidades
O Sistema possui quatro telas para que ocorra a manipulação dos dados, todas elas, disponiveis ao acesso por meio de uma barra de navegação

### Tela de cadastro e manipulação de funcionarios

#### Cadastro
Nesta tela é possível fazer o cadastro de um funcionário para que ele seja responsável por uma tarefa. O usuário deve informar um nome e telefone de um funcionário para cadastra-lo no sistema. O usuário não deve preocupar-se com a digitação de uma matrícula ou identificador, pois o próprio sistema ficará responsavel para garantir que dois funcionários não possuam o mesmo identificador. 

#### Relatorio dos funcionarios cadastrados
Sera possivel conferir todos os funcionarios cadastrados no sistema.

#### Alterar e Excluir 
Caso um dos funcionários exibidos na tabela, seja selecionado, o usuário poderá alterar os dados nas caixas de texto ou excluir o funcionário assim que o usuário pressione um dos botões.

### Tela de cadastro de uma tarefa
Nessa tela o usuário poderá cadastrar uma tarefa, assim como no funcionário, o controle do número de identificação fica por conta do sistema, assim como o estado de uma tarefa, que por sua vez sempre é *Em andamento* quando criada.

### Tela de manipulação de uma tarefa
Tal qual a tabela de funcionários, o usuário poderá alterar os dados e excluir uma tarefa assim que selecionada, porem, o usuário também poderá marcar uma tarefa como *concluida*.  

### Tela de relatorios das tarefas
Nessa tela o usuário poderá utilizar os campos disponíveis para filtrar tarefas específicas.