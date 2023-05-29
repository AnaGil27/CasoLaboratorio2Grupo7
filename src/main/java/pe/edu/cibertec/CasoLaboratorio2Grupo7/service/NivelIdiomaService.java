package pe.edu.cibertec.CasoLaboratorio2Grupo7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.NivelIdiomas;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.repository.NivelIdiomasRepository;


@Service
public class NivelIdiomaService {
	@Autowired
	private NivelIdiomasRepository nivelIdiomasRepository;
	
	public List<NivelIdiomas> listarNivelIdiomas(){
		return nivelIdiomasRepository.findAll();
	}
	
	public void registrarNivelIidomas( NivelIdiomas nivelidiomas) {
		nivelIdiomasRepository.save(nivelidiomas);
	}
	public void eliminarNivelIidomas(Integer  id_nivel) {
		nivelIdiomasRepository.deleteById( id_nivel);
	}
}