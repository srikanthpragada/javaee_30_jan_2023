package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

	
	public void printJobsByMinsal() {
		for (var j : jobRepo.findByMinsalBetween(500000,1000000)) {
			System.out.println(j.getTitle());
		}
	}
	public void printJobsByTitle(String title) {
		for (var j : jobRepo.findByTitleContainingIgnoreCase(title)) {
			System.out.println(j.getTitle());
		}
	}
	
	public void printTop3Jobs() {
		for (var j : jobRepo.findTop3ByOrderByMinsalDesc()) {
			System.out.printf("%-30s %d\n",j.getTitle(), j.getMinsal());
		}
	}
	
	public void printLargeTitles() {
		for (var j : jobRepo.getLargeTitles()) {
			System.out.println(j.getTitle());
		}
	}
	
	public void printTitlesByLength(int length) {
		for (var j : jobRepo.getTitlesByLength(length)) {
			System.out.println(j.getTitle());
		}
	}
	
	public void printJobsInUse() {
		for (var j : jobRepo.getJobsInUse() ){
			System.out.println(j.getTitle());
		}
	}
	
	public void printSecondPage() {
		var page = jobRepo.findAll(PageRequest.of(0, 3)); // 1nd page with 3 rows per page
		System.out.println(page);
		for (var j : page){   
			System.out.println(j.getTitle());
		}
	}
	
	public void printFirstPageByMinsal() {
		for (var j : jobRepo.findAll(PageRequest.of(0, 3, Sort.by("minsal").descending()))){   // 2nd page with 3 rows per page
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
		//printJobsByTitle("prog");
		//printJobsByMinsal();
		//printTop3Jobs();
		//printLargeTitles();
		//printTitlesByLength(15);
		//printJobsInUse();
		//printSecondPage();
		printFirstPageByMinsal();
	}

}