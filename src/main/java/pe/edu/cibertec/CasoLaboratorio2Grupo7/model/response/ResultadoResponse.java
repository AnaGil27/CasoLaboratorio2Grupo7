package pe.edu.cibertec.CasoLaboratorio2Grupo7.model.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResultadoResponse {
	private Boolean respuesta;
	private String mensaje;
}
