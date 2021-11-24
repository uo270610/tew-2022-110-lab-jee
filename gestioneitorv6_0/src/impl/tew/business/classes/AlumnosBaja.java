package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.persistence.AlumnoDao;
import com.tew.persistence.exception.NotPersistedException;

public class AlumnosBaja {

	public void delete(Long id) throws EntityNotFoundException {
		AlumnoDao dao = Factories.persistence.createAlumnoDao();
		try {
			dao.delete(id);
		}
		catch (NotPersistedException ex) {
			throw new EntityNotFoundException("Alumno no eliminado " + id, ex);
		}
	}
}
