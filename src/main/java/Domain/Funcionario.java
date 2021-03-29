package Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFuncionario;

	@Column(nullable = false, length = 50)
	@NotBlank(message = "Informar nome do funcionario")
	private String nome;

	@Column(nullable = false, length = 9)
	@NotBlank(message = "Informar telefone do funcionario")
	private String Telefone;
}
