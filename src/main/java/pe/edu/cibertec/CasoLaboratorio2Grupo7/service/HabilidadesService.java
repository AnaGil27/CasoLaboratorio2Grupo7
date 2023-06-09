package pe.edu.cibertec.CasoLaboratorio2Grupo7.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.Habilidades;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.repository.HabilidadesRepository;
@Service
public class HabilidadesService {
	@Autowired
	private HabilidadesRepository habilidadesRepository;
	
	public List<Habilidades> listarHabilidades(){
		return habilidadesRepository.findAll();
	}
	
	public void registrarHabilidades(Habilidades habilidades) {
		habilidadesRepository.save(habilidades);
	}
	
	public void eliminarHabilidades(Integer id_habilidades) {
		habilidadesRepository.deleteById(id_habilidades);
	}
}