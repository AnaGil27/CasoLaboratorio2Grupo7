package pe.edu.cibertec.CasoLaboratorio2Grupo7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.Cursos;
import pe.edu.cibertec.CasoLaboratorio2Grupo7.repository.CursosRepository;

@Service
public class CursosService {
	@Autowired
	private CursosRepository CursosRepository;
	
	public List<Cursos> listarCursos(){
		return CursosRepository.findAll();
	}
	
	public void registrarCursos(Cursos cursos) {
		CursosRepository.save(cursos);
	}
	
	public void eliminarSala(Integer idcurso) {
		CursosRepository.deleteById(idcurso);
	}
}
