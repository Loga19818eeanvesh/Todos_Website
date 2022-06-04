package start.springboot.web.springbootstartweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
    private User user;
	@Column(nullable = false)
    private String description;
	@Column(nullable = false)
    private Date targetDate;
	@Column(nullable = false)
    private boolean isDone;
    
    protected Todo() {
        super();
    }
    
	public Todo(String description, Date targetDate, boolean isDone) {
		super();
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Todo(User user, String desc, Date targetDate, boolean isDone) {
		super();
		this.user = user;
		this.description= desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", description=" + description + ", targetDate=" + targetDate
				+ ", isDone=" + isDone + "]";
	}

    
}
