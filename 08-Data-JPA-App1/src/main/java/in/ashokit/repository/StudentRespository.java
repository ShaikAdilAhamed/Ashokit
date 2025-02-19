package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Student;
import jakarta.transaction.Transactional;

//@Repository
public interface StudentRespository extends JpaRepository<Student, Integer> {

//	public List<Student> findByGender(String gender);
//	
//	public List<Student> findByGenderIsNull();
//	
//	//select * from student_dtls where student_rank >= :rank
//	public List<Student> findByRankGreaterThanEqual(Long rank);
//	
//	//select * from student_dtls where student_rank <= :rank
//	public List<Student> findByRankLessThanEqual(Long rank);
//	
//	//select * from student_dtls where student_gender : male and student_rank >= :rank
//	public List<Student> findByGenderAndRankGreaterThanEqual(String gender,Long rank);
	
	//if parameters names are same we will use @Param and match with varible name
//	//select * from student_dtls where student_gender :a and student_rank >= :b
//	public List<Student> findByGenderAndRankGreaterThanEqual(@Param("a") String gender, @Param("b") Long rank);
	
	//SQL Query
	//native query
	
//	@Query(value = "select * from student_dtls",nativeQuery = true)
//	public List<Student> getAllStudents();
	
	
	//HQL Query
//	@Query(value = "from Student")
//	public List<Student> getAllStudents();
	
	
	//HQL Query ( custom query ) to perform delete operation
//	@Query("delete from Student where id = :sid" )
//	@Modifying
//	@Transactional
//	public void deleteStudent(Integer sid);

	//HQL Query ( custom query ) to perform update operation
//	@Query("update Student set gender= :gender where id= :sid ")
//	@Modifying
//	@Transactional
//	public void updateStudent(Integer sid,String gender);
	
	
	//HQL Query ( custom query ) to perform insert operation 
	//it worked for me but sir said this will not work
//	@Query("insert into Student(id,name,gender) values (:id,:name,:gender)")
//	@Modifying
//	@Transactional
//	public void insertStudent(Integer id,String name,String gender);
	
	//SQL Query ( custom query ) to perform insert operation 
//	@Query(value = "insert into student_dtls(student_id,student_name,student_gender) values (:id,:name,:gender)",nativeQuery = true)
//	@Modifying
//	@Transactional
//	public void insertStudent(Integer id,String name,String gender);
	
	
	
	
}
