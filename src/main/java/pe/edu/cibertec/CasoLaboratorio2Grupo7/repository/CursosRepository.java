package pe.edu.cibertec.CasoLaboratorio2Grupo7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Integer>{
	
}
