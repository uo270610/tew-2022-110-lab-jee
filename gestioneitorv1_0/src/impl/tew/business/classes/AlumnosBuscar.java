package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;
import com.tew.persistence.AlumnoDao;

public class AlumnosBuscar {

	public Alumno find(Long id) throws EntityNotFoundException {
		AlumnoDao dao = Factories.persistence.createAlumnoDao();
		Alumno a = dao.findById(id);
		if ( a == null) {
			throw new EntityNotFoundException("No se ha encontrado el alumno");
		}
		
		return a;
	}

}
