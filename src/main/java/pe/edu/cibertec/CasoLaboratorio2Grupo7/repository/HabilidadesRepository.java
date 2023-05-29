package pe.edu.cibertec.CasoLaboratorio2Grupo7.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.CasoLaboratorio2Grupo7.model.bd.Habilidades;

@Repository
public interface HabilidadesRepository 
	extends JpaRepository<Habilidades, Integer> {
}
