package start.springboot.web.springbootstartweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import start.springboot.web.springbootstartweb.model.Todo;
import start.springboot.web.springbootstartweb.model.User;
import start.springboot.web.springbootstartweb.repository.TodosRepository;
import start.springboot.web.springbootstartweb.repository.UserRepository;
import start.springboot.web.springbootstartweb.service.TodoService;


@Controller
//@SessionAttributes("name")
public class TodoController {
	@Autowired
	private TodosRepository todosRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String username=getLoggedInUserName();
		model.put("todos", todosRepository.retrieveTodosOfUser(username));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		model.addAttribute("todo",new Todo("",new Date(),false));
		return "add-todo";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addTodo(ModelMap model,Todo todo,BindingResult result) {
		if (result.hasErrors()) {
			return "add-todo";
		}
		String name=getLoggedInUserName();
		todosRepository.AddTodoToUser(name, todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegister(ModelMap model) {
		model.addAttribute("user",new User("", "", "", true, "ROLE_USER"));
		return "register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(ModelMap model,User user,BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		userRepository.save(user);
		return "redirect:/";
	}
	
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todosRepository.deleteTodoById(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(ModelMap model,@RequestParam int id) {
		Todo todo = todosRepository.retrieveTodoById(id);
		model.put("todo",todo);
		return "add-todo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,Todo todo,BindingResult result,@RequestParam int id) {
		if (result.hasErrors()) {
			return "add-todo";
		}
		String username=getLoggedInUserName();
		User user = todosRepository.retriveUser(username);
		todo.setUser(user);
		todosRepository.updateTodo(todo);
		
		return "redirect:/list-todos";
	}
	
}
