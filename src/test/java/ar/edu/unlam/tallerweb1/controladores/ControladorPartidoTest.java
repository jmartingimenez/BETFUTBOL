package ar.edu.unlam.tallerweb1.controladores;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;

public class ControladorPartidoTest {

	@Mock
	private ServicioPartido servicioPartido;
	
	@Mock
	private Partido partido;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpSession session;
	
	@InjectMocks
	private ControladorPartido controladorPartido;
	
	@InjectMocks
	private ControladorABMPartido controladorABMPartido;
	
	@Before
	public void inyeccionMocksInicializada() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testQueVerificaQueElPartidoSeaValido() {
		when(request.getSession()).thenReturn(session);
		when(servicioPartido.consultarPartido(any(Partido.class))).thenReturn(partido);
		when(partido.getLocal()).thenCallRealMethod();
		when(partido.getVisitante()).thenCallRealMethod();
		
		ModelAndView modelo = controladorPartido.validarPartido(partido);
		
		assertThat(modelo.getViewName()).isEqualTo("redirect:/partido");
		assertThat(modelo.getModel()).isEmpty();
		verify(session , times(1)).setAttribute("LOCAL", "PARTIDO");
		
	}
	
	@Test
	public void testQuePuedaCrearUnEquipoValido() {
		when(request.getSession()).thenReturn(session);
		when(servicioPartido.consultarPartido(any(Partido.class))).thenReturn(partido);
		
		ModelAndView modelo = controladorABMPartido.crearPartido(partido, request);
		
		assertThat(modelo.getViewName()).isEqualTo("redirect:/");
		assertThat(modelo.getModel()).isEmpty();
		verify(session , times(1));
	}

}
