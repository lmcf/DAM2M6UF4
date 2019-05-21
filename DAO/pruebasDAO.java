import java.awt.Label;

public class pruebasDAO {
	public static void debug(String mensaje, Boolean comprobar) {
		System.out.printf(mensaje + "%n", comprobar);
	}

	public static void main(String[] args) {
		DepartamentoDAO departamentoDAO = new DepartamentoImpl();

		// Genero un departamento
		Departamento departamento = new Departamento(17, "CONTENIDO", "LA RIJA");

		/* 1-- Inserta un nuevo departamento */
		// TRUE -> Ha sido insertado | FALSE -> Ya existe
		debug("Departamento Insertado (%s)%n", departamentoDAO.InsertarDep(departamento));

		/* 2-- Consulta el nuevo departamento */
		Departamento departConsultado = departamentoDAO.ConsultarDep(departamento.getDeptno());

		if (departConsultado != null) {
			System.out.printf("DEPARTAMENTO %n" + "Nº %d%n" + "DNAME: %s%n" + "LOC: %s%n%n",
					departConsultado.getDeptno(), departConsultado.getDnombre(), departConsultado.getLoc());
		}

		/* 3-- Modifica algunos valores del nuevo departamento */
		// He cambiado la localidad la primera vez pone LA RIJA, ahora lo pone "bien"
		Departamento departModificado = new Departamento(17, "CONTABILIDAD", "LA RIOJA");

		// TRUE -> Ha sido modificado | False -> EL departamento a modificar no existe
		debug("Departamento Modificado (%s)%n", departamentoDAO.ModificarDep(17, departModificado));
		
		// Consultamos para ver que se ha mnodificado
		Departamento departConsultado1 = departamentoDAO.ConsultarDep(departamento.getDeptno());

		if (departConsultado1 != null) {
			System.out.printf("DEPARTAMENTO %n" + "Nº %d%n" + "DNAME: %s%n" + "LOC: %s%n%n",
					departConsultado1.getDeptno(), departConsultado1.getDnombre(), departConsultado1.getLoc());
		}

		/* 4-- Elimina el departamento creado */

		debug("Departamento ELiminado (%s)%n", departamentoDAO.EliminarDep(departamento.getDeptno()));

		// Consultamos que no existe ya
		Departamento departConsultado2 = departamentoDAO.ConsultarDep(departamento.getDeptno());

		if (departConsultado2 != null) {
			System.out.printf("DEPARTAMENTO %n" + "Nº %d%n" + "DNAME: %s%n" + "LOC: %s%n",
					departConsultado2.getDeptno(), departConsultado2.getDnombre(), departConsultado2.getLoc());
		}
	}
}
