package Domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@Column(nullable = false)
	private boolean status = false;

	@Column(nullable = false, length = 50)
	@NotBlank(message = "Informar titulo da tarefa")
	private String titulo;

	@Column(nullable = false)
	@NotBlank(message = "Informar descrição da tarefa")
	private String Descricao;

	@Column(nullable = false)
	@NotBlank(message = "Informar a prioridade da tarefa")
	private String prioridade;

	@Column(nullable = false)
	@Future(message = "Infomar uma data a partir de amanhã para a tarefa")
	private LocalDate deadLine;

	@ManyToOne
	@JoinColumn(nullable = false)
	@NotNull(message = "informar funcionario responsavel pela tarefa")
	private Funcionario funcionario;

}
