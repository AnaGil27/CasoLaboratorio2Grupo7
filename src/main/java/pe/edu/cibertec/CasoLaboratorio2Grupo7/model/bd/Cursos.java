package pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="tb_cursos")
public class Cursos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcurso;
	@Column(name = "curso")
	private String ingreso_Usu;
	@Column(name = "ingreso_Usus")
	private String curso;
	@Column(name = "centro_estudios")
	private String centro_estudios;
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	@Column(name = "fecha_fin")
	private Date fecha_fin;
	
	
}
