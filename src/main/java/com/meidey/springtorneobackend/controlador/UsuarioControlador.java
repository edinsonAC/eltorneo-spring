package com.meidey.springtorneobackend.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meidey.springtorneobackend.dao.ITipoUsuarioDao;
import com.meidey.springtorneobackend.modelo.Usuario;
import com.meidey.springtorneobackend.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioControlador {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private ITipoUsuarioDao tipoUsuarioDao;

	@GetMapping(value = "/listarUsuarios")
	public List<Usuario> listarUsuarios(Model model) {
		return usuarioService.listarUsuarios();
	}

	@RequestMapping(value = "/registrar-usuario")
	public String registrar(Model model) {
		Usuario usuario = new Usuario();

		model.addAttribute("usuario", usuario);

		return "registrar-usuario";
	}

	@RequestMapping(value = "/registrar-usuario", method = RequestMethod.GET)
	public String listarTipoUsuario(Model model) {
		model.addAttribute("nombre", "Listado de tipos de usuario");
		model.addAttribute("tipoUsuarios", tipoUsuarioDao.listarTipoUsuario());
		Usuario usuario = new Usuario();

		model.addAttribute("usuario", usuario);
		return "registrar-usuario";
	}

	@RequestMapping(value = "/registrar-usuario", method = RequestMethod.POST)
	public String guardar(HttpServletRequest inRequest) {
		inRequest.getParameter("usuario");
		Usuario usuario = new Usuario();
		System.out.println("este usuario llega al controlador " + inRequest.getParameter("usuario"));
		usuarioService.registrarUsuario(usuario);
		return "redirect:listarUsuarios";
	}

}
