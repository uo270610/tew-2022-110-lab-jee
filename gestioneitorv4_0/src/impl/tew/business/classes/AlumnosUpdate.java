package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;
import com.tew.persistence.AlumnoDao;
import com.tew.persistence.exception.NotPersistedException;

public class AlumnosUpdate {

	public void update(Alumno alumno) throws EntityNotFoundException {
		AlumnoDao dao = Factories.persistence.createAlumnoDao();
		try {
			dao.update(alumno);
		}
		catch (NotPersistedException ex) {
			throw new EntityNotFoundException("Alumno no eliminado " + alumno, ex);
		}
	}

}
