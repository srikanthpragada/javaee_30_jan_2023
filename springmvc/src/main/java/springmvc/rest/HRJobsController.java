package springmvc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import springmvc.entities.Job;
import springmvc.entities.JobRepository;

@RestController
public class HRJobsController {
	@Autowired
	JobRepository jobRepo;

	@GetMapping("/rest/jobs")
	public List<Job> getAllJobs() {
		List<Job> jobs = jobRepo.findAll();
		return jobs;
	}

	@GetMapping("/rest/jobs/{id}")
	public Job getJobById(@PathVariable("id") String id) {
		var entity = jobRepo.findById(id);
		if (entity.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return entity.get();
	}

	@PostMapping("/rest/jobs")
	public Job processNewJob(@RequestBody Job job) {
		try {
			jobRepo.save(job);
			return job;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/rest/jobs/{id}")
	public void processEditJob(@PathVariable("id") String id, @RequestBody Job newJob) {
		try {
			var job = jobRepo.findById(id);
			if (job.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			else {
				var jobEntity = job.get();
				jobEntity.setTitle(newJob.getTitle());
				jobEntity.setMinsal(newJob.getMinsal());
				jobRepo.save(jobEntity);
			}
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/rest/jobs/{id}")
	public void deleteJob(@PathVariable("id") String id) {
		var entity = jobRepo.findById(id);
		if (entity.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		try {
			jobRepo.deleteById(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
