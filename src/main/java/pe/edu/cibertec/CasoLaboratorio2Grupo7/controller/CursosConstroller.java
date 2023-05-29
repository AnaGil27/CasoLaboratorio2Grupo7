package pe.edu.cibertec.CasoLaboratorio2Grupo7.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.Cursos;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.request.CursosRequest;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.response.CursosResponse;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.service.CursosService;

@Controller
@RequestMapping("/cursos")
public class CursosConstroller {
	@Autowired
	private CursosService CursosService;
	
	@GetMapping("/frmcursos")
	public String frmMantSala(Model model) {
		model.addAttribute("listacursos", 
				CursosService.listarCursos());
		return "cursos/frmcursos";
	}
	
	public CursosResponse registrarCursos(@RequestBody CursosRequest cursosRequest) {
		String mensaje ="Curso registrado correctamente";
		Boolean respuesta = true;
		try {
			Cursos objCurso = new Cursos();
			if(cursosRequest.getIdcurso() > 0) {
				objCurso.setIdcurso(cursosRequest.getIdcurso());
			}
			objCurso.setIngreso_Usu(cursosRequest.getIngreso_Usu());
			objCurso.setCurso(cursosRequest.getCurso());
			objCurso.setCentro_estudios(cursosRequest.getCentro_estudios());
			objCurso.setFecha_inicio(cursosRequest.getFecha_inicio());
			objCurso.setFecha_fin(cursosRequest.getFecha_fin());
		}catch(Exception ex){
			mensaje = "Curso no registrado";
			respuesta = false;
		}
		return CursosResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarCurso")
	@ResponseBody
	public CursosResponse eliminarCurso(@RequestBody CursosRequest cursosRequest) {
		String mensaje = "Curso eliminado correctamente";
		Boolean respuesta = true;
		try {
			CursosService.eliminarSala(cursosRequest.getIdcurso());
		} catch (Exception e) {
			mensaje = "Sala no eliminada";
			respuesta = false;
		}
		return CursosResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarCursos")
	@ResponseBody
	public List<Cursos> listarSalas(){
		return CursosService.listarCursos();
	}
}

