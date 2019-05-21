import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.*;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class DepartamentoImpl implements DepartamentoDAO {
	private static ODB db;

	public DepartamentoImpl() {
		// TODO Auto-generated constructor stub
		if (db == null) {
			db = ODBFactory.open("Depart.DB");
		}
	}

	@Override
	public boolean InsertarDep(Departamento dep) {
		if (dep != null) {
			ICriterion critery = Where.equal("deptno", dep.getDeptno());
			IQuery sentence = new CriteriaQuery(Departamento.class, critery);
			Objects<Departamento> depart = db.getObjects(sentence);
			if (depart.size() != 0) {
				return false;
			} else {
				db.store(dep);
				return true;
			}

		}
		return false;
	}

	@Override
	public boolean EliminarDep(int deptno) {
		ICriterion critery = Where.equal("deptno", deptno);
		IQuery sentence = new CriteriaQuery(Departamento.class, critery);
		Objects<Departamento> depart = db.getObjects(sentence);

		if (deptno != 0 && depart.size() != 0) {
			// Sin .getFirst() me da error al eliminar cree que no existe
			db.delete(depart.getFirst());
			db.commit();
			return true;
		}

		return false;

	}

	@Override
	public boolean ModificarDep(int deptno, Departamento dep) {
		Departamento DEPaEditar = ConsultarDep(deptno);

		if (DEPaEditar != null) {
			DEPaEditar.setDeptno(dep.getDeptno());
			DEPaEditar.setDnombre(dep.getDnombre());
			DEPaEditar.setLoc(dep.getLoc());
			db.store(DEPaEditar);
			return true;

		}
		return false;
	}

	@Override
	public Departamento ConsultarDep(int deptno) {
		ICriterion critery = Where.equal("deptno", deptno);
		IQuery sentence = new CriteriaQuery(Departamento.class, critery);
		Objects<Departamento> depart = db.getObjects(sentence);

		if (depart != null && depart.size() != 0) {
			// Si no pongo .getFirst() no puede hacer el cast
			Departamento depTemp = (Departamento) depart.getFirst();
			return depTemp;
		} else {
			System.out.printf("El departamento Nº %s no existe ", deptno);
		}
		return null;
	}

}
