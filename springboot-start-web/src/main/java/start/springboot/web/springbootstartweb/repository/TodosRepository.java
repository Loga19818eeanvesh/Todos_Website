package start.springboot.web.springbootstartweb.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import start.springboot.web.springbootstartweb.model.Todo;
import start.springboot.web.springbootstartweb.model.User;

@Repository
@Transactional
public class TodosRepository {
	@Autowired
	private EntityManager entityManager;
	
	public Todo retrieveTodoById(int id) {
		return entityManager.find(Todo.class, id);
	}
	
	public List<Todo> retrieveTodosOfUser(String username) {
        TypedQuery<User> query = entityManager.createQuery("Select u from User u where u.userName = "+username, User.class);
        User user = query.getSingleResult();
        return user.getTodos();
    }
	
	public Todo updateTodo(Todo todo) {
		return entityManager.merge(todo);
	}
	
	public void deleteTodoById(int id) {
		Todo todo = retrieveTodoById(id);
		entityManager.remove(todo);
	}
	
	public void AddTodoToUser(String username,Todo todo) {
		TypedQuery<User> query = entityManager.createQuery("Select u from User u where u.userName = "+username, User.class);
        User user = query.getSingleResult();
		todo.setUser(user);
		todo.setDone(false);
		user.addTodos(todo);
		entityManager.persist(todo);
	}
}
