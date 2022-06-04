package start.springboot.web.springbootstartweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String userName;
	private String password;
	private boolean active;
	private String roles;
	@OneToMany(mappedBy="user")
	private List<Todo> todos = new ArrayList<>();
	
	
	public User() {
		super();
	}
	
	public User(String name, String userName, String password, boolean active, String roles) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
	
	public List<Todo> getTodos() {
		return todos;
	}

	public void addTodos(Todo todo) {
		this.todos.add(todo);
	}
	
	public void deleteTodos(Todo todo) {
		this.todos.remove(todo);
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", active="
				+ active + ", roles=" + roles + "]";
	}
	
	
}
