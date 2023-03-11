package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner {
	@Autowired
	private JobRepository jobRepo;

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

	public void printJobs() {
		for (var j : jobRepo.findAll()) {
			System.out.println(j.getTitle());
		}
	}

	public void printJobById(String id) {
		var job = jobRepo.findById(id);
		if (job.isPresent())
			System.out.println(job.get().getTitle());
		else
			System.out.println("Sorry! Job id not found!");
	}

	public void updateTitle(String id, String title) {
		var entity = jobRepo.findById(id);
		if (entity.isPresent()) {
			var job = entity.get();
			job.setTitle(title);
			jobRepo.save(job);
			System.out.println("Updated Job Title");
		} else
			System.out.println("Sorry! Job id not found!");
	}

	public void deleteJob(String id) {
		var entity = jobRepo.findById(id);
		if (entity.isPresent()) {
			jobRepo.delete(entity.get());
			System.out.println("Deleted Job");
		} else
			System.out.println("Sorry! Job id not found!");
	}

	public void addJob(String id, String title) {
		var job = new Job();
		job.setId(id);
		job.setTitle(title);
		job.setMinsal(200000);
		jobRepo.save(job);
		System.out.println("Added Job");
	}

	
	public void printJobsByTitle(String title) {
		for (var j : jobRepo.findByTitleContainingIgnoreCase(title)) {
			System.out.println(j.getTitle());
		}
	}
	@Override
	public void run(String... args) throws Exception {
//		System.out.println(jobRepo.getClass());
//		printJobs();
//		printJobById("jepro");
//		updateTitle("jpro2", "Java 20 Programmer");
//		addJob("ml", "Machine Learning");
//		deleteJob("ml");
		printJobsByTitle("prog");
	}

}