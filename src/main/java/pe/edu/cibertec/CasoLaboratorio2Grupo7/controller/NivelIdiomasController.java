package pe.edu.cibertec.CasoLaboratorio2Grupo7.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.NivelIdiomas;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.request.NivelIdiomaRequest;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.response.ResultadoResponse;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.service.NivelIdiomaService;

@Controller
@RequestMapping("/nivelidioma")
public class NivelIdiomasController {
	

	@Autowired
	private NivelIdiomaService nivelIdiomaService;
	
	@GetMapping("/frmnivelidioma")
	public String frmMantIdioma(Model model) {
		model.addAttribute("listanivelidioma", 
				nivelIdiomaService.listarNivelIdiomas());
		return "nivelidioma/frmnivelidioma";
	}
	
	@PostMapping("/registrarNivelIdioma")
	@ResponseBody
	public ResultadoResponse registrarNivelIdioma(
			@RequestBody NivelIdiomaRequest nivelIdiomaRequest
			) {
		String mensaje ="Nivel de Idioma se registro correctamente";
		Boolean respuesta = true;
		try {			
			
			NivelIdiomas objNivelIdiomas = new NivelIdiomas();
			if(nivelIdiomaRequest.getId_nivel() > 0) {
				objNivelIdiomas.setId_nivel(nivelIdiomaRequest.getId_nivel());
			}
			objNivelIdiomas.setNivel(nivelIdiomaRequest.getNivel());
			nivelIdiomaService.registrarNivelIidomas(objNivelIdiomas);
		}catch(Exception ex) {
			mensaje = "Sala no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarNivelIdioma")
	@ResponseBody
	public ResultadoResponse eliminarNivelIdioma(@RequestBody
			NivelIdiomaRequest nivelIdiomaRequest) {
		String mensaje = "Sal eliminada correctamente";
		Boolean respuesta = true;
		try {
			nivelIdiomaService.eliminarNivelIidomas(nivelIdiomaRequest.getId_nivel());
		}catch (Exception e) {
			mensaje = "Sala no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarNivelIdioma")
	@ResponseBody
	public List<NivelIdiomas> listaIdiomas(){
		return nivelIdiomaService.listarNivelIdiomas();
	}
	

}
