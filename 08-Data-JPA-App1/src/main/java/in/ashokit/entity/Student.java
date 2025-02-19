package in.ashokit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT_DTLS")  //@Table is Optional if we don't write this it will take class name as table name
public class Student {
    @Id
    @Column(name="student_id") //@Column is  Optional if we don't write this it will take varible name. 
	private Integer id;
    
    @Column(name="student_name")
	private String name;
	
    @Column(name="student_rank")
    private Long rank;
    
    @Column(name="student_gender")
	private String gender;

    @CreationTimestamp
    @Column(name="CREATED_DATE",updatable = false)
    private LocalDateTime createdDate;
    
    @UpdateTimestamp
    @Column(name="UPDATED_DATE",insertable = false)
    private LocalDateTime updatedDate;
    
    @Column(name="ACTIVE_SW")
	private String active_sw;
	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getActive_sw() {
		return active_sw;
	}

	public void setActive_sw(String active_sw) {
		this.active_sw = active_sw;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rank=" + rank + ", gender=" + gender + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", active_sw=" + active_sw + "]";
	}

	public Student() {
		
	}

	public Student(Integer id, String name, Long rank, String gender, String active_sw) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
		this.gender = gender;
		this.active_sw = active_sw;
	}

	
	
	
    
}
