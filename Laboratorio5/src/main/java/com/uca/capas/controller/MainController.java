package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {

	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/listado")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes=estudianteService.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		
		return mav;
	}
	
	@RequestMapping("/ingresar")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/validar")
	public ModelAndView validar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(!result.hasErrors()) {
			try {
				estudianteService.insert(estudiante);
			}catch(Exception e) {
				e.printStackTrace();
			}
			estudiante = new Estudiante();
			mav.addObject("estudiante", estudiante);
		}
		mav.setViewName("index");
		
		return mav;
	}
	
	//delete
	@RequestMapping(value="/borrar",method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="c_usuario") int c_usuario) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudianteService.delete(c_usuario);
			estudiantes = estudianteService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		
		return mav;
		
	}
}
