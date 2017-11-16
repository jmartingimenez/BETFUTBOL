package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Apuesta;
import ar.edu.unlam.tallerweb1.modelo.RankingDTO;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRanking;

@Controller
public class ControladorRanking {	
	//Si no se lo injecta, no lo reconoce como servicio, sino como una clase normal
	@Inject private ServicioRanking servicioRanking;
	
	@RequestMapping(path = "/ranking", method = RequestMethod.GET)
	public ModelAndView irARanking(@RequestParam(value = "filtro", required = false) String filtro) {		
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		
		if(filtro == null){
			List<RankingDTO> ranking = servicioRanking.traerRankingGeneral();
			modelo.put("ranking", ranking);
			
			modelo.put("usuario",usuario);
			return new ModelAndView("ranking", modelo);			
		}
		List<RankingDTO> ranking = servicioRanking.traerRankingGeneralPorNombreDeEvento(filtro);
		modelo.put("ranking", ranking);
	
		modelo.put("usuario",usuario);
	
		
		return new ModelAndView("ranking", modelo);
	}	
}