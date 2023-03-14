package jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job, String> {
	 List<Job> findByTitleContainingIgnoreCase(String title);
	 List<Job> findByMinsalBetween(int min, int max);
	 List<Job> findTop3ByOrderByMinsalDesc();
	 
	 @Query("from Job j where length(j.title) > 10")  // JPQL
	 List<Job> getLargeTitles();
	 
	 @Query("from Job j where length(j.title) > ?1")  // JPQL
	 List<Job> getTitlesByLength(int len);
	 
	 @Query(value = "select * from jobs where id in (select job from employees) ", nativeQuery = true)  // JPQL
	 List<Job> getJobsInUse();
}
