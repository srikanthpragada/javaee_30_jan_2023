package jpa;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, String> {
     
	 List<Job> findByTitleContainingIgnoreCase(String title);
}
