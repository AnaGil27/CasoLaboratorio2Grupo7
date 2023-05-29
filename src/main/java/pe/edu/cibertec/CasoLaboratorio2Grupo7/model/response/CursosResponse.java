package pe.edu.cibertec.CasoLaboratorio2Grupo7.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursosResponse {
	private Boolean respuesta;
	private String mensaje;
}
