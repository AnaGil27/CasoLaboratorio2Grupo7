package pe.edu.cibertec.CasoLaboratorio2Grupo7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.Pais;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.repository.PaisRepository;


@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	public List<Pais> listarPais() {
		return paisRepository.findAll();
	}
	public void registrarPais(Pais pais) {
		paisRepository.save(pais);
	}
	
	public void eliminarPais(Integer id_pais) {
		paisRepository.deleteById(id_pais);
	}
	

}
