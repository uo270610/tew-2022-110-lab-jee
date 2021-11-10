package impl.tew.business.classes;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;
import com.tew.persistence.AlumnoDao;
import com.tew.persistence.exception.AlreadyPersistedException;

public class AlumnosAlta {

	public void save(Alumno alumno) throws EntityAlreadyExistsException {
		AlumnoDao dao = Factories.persistence.createAlumnoDao();
		try {
			dao.save(alumno);
		}
		catch (AlreadyPersistedException ex) {
			throw new EntityAlreadyExistsException("Alumno ya existe " + alumno, ex);
		}
	}

}
