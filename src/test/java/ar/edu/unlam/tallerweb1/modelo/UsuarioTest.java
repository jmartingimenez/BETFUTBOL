package ar.edu.unlam.tallerweb1.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import static org.assertj.core.api.Assertions.*;

public class UsuarioTest extends SpringTest {
	
	private Usuario usuario1 , usuario2;
	private List<Usuario> listaDeUsuarios;
	private Session sesion;
	
	@Before
	public void inicializacion() {
		usuario1 = new Usuario();
		usuario2 = new Usuario();
		sesion = getSession();
		listaDeUsuarios = new ArrayList<Usuario>();
	}

	@SuppressWarnings("unchecked")
	@Test(expected = Exception.class)
	@Transactional
	@Rollback(true)
	public void testQueAlCrearUnNuevoUsuarioYaExistaYDevuelvaUnError() throws Exception {
		usuario1.setNombreYApellido("Juan Perez");
		usuario1.setEmail("juanp@hotmail.com");
		usuario1.setPassword("123456");
		
		usuario2.setNombreYApellido("Raul Gomez");
		usuario2.setEmail("juanp@hotmail.com");
		usuario2.setPassword("123456");
		
		
		if(this.usuario1.getEmail().equals(this.usuario2)) {
			throw new Exception("Ya existe un usuario con ese email , por favor elija otro");
		} else {
			System.out.println("Usuario valido");
		}
		
		getSession().save(usuario1);
		getSession().save(usuario2);
		
		
		listaDeUsuarios = sesion.createCriteria(Usuario.class)
						  .add(Restrictions.and(Restrictions.eq("email", "email") , Restrictions.eq("password", "password"))).list();
		
		assertThat(listaDeUsuarios.get(0).getEmail()).isEqualTo(usuario1.getEmail()).isNotNull();
		assertThat(listaDeUsuarios).hasSize(1);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = Exception.class)
	@Transactional
	@Rollback(true)
	public void testQueAlCrearUnUsuarioNoEscribaSuPasswordYDevuelvaUnError() throws Exception {
		Usuario usuario1 = new Usuario();
		
	}

}