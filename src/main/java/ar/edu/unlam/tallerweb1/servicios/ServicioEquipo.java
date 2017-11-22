package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;


public interface ServicioEquipo {
	
	List<Equipo> listarTodosLosEquipos();
	List<Equipo> insertarEquipo(Equipo equipo);
	void guardarEquipo(Equipo equipo);
	void eliminarEquipo(Equipo equipo);
	void actualizarEquipo(Equipo equipo);
	Equipo buscarPorId(Long id);
	Equipo consultarEquipo(Equipo equipo);

}
