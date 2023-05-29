package pe.edu.cibertec.CasoLaboratorio2Grupo7.model.request;

import java.sql.Date;

import lombok.Data;

@Data
public class CursosRequest {
	private Integer idcurso;
	private String ingreso_Usu;
	private String curso;
	private String centro_estudios;
	private Date fecha_inicio;
	private Date fecha_fin;
}
