package app.persistencia;

import java.util.List;

import app.modelo.Autor;

public interface ItfzAutorDAO {
	public List<Autor> consultarAutores();
}
