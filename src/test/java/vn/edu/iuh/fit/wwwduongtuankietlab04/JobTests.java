package vn.edu.iuh.fit.wwwduongtuankietlab04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import vn.edu.iuh.fit.wwwduongtuankietlab04.dao.JobDAO;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Company;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class JobTests {
    private final JobDAO jobDAO;

    @Autowired
    public JobTests(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
    }

    @Test
    void create() {
        Company company = new Company(UUID.fromString("7ab4d0b4-61bd-4b04-8aee-95a6f3da48ea"));

        UUID id = UUID.randomUUID();
        Job job = new Job(id, "Desc", "Name", company);

        boolean b = jobDAO.create(job);

        if (!b)
            Assertions.fail();

        Optional<Job> jobOptional = jobDAO.findById(id);

        Assertions.assertTrue(jobOptional.isPresent());
    }

    @Test
    void getAll() {
        List<Job> jobs = jobDAO.getAll();

        Assertions.assertFalse(jobs.isEmpty());
    }

    @Test
    void findSuccessById() {
        Optional<Job> jobOptional = jobDAO.findById(UUID.fromString("bb1679a2-be16-487a-b880-7ab76fa6c4e0"));

        Assertions.assertTrue(jobOptional.isPresent());
    }

    @Test
    void findFailById() {
        Optional<Job> jobOptional = jobDAO.findById(UUID.fromString("bb1679a2-1234-487a-b880-7ab76fa6c4e0"));

        Assertions.assertTrue(jobOptional.isEmpty());
    }

    @Test
    void update() {
        UUID uuid = UUID.fromString("bb1679a2-be16-487a-b880-7ab76fa6c4e0");

        Optional<Job> jobOptional = jobDAO.findById(uuid);

        if (jobOptional.isEmpty())
            Assertions.fail();

        Job job = jobOptional.get();
        String newDesc = "New desc";

        job.setDesc(newDesc);

        boolean updated = jobDAO.update(job);

        if (!updated)
            Assertions.fail();


        Optional<Job> jobUpdatedOptional = jobDAO.findById(uuid);

        Assertions.assertTrue(jobUpdatedOptional.isPresent() && jobUpdatedOptional.get().getDesc().equals(newDesc));
    }

    //    @Test
    void delete() {
        UUID uuid = UUID.fromString("80c01b16-a15d-458d-92b9-84522e7c86c5");

        boolean deleted = jobDAO.delete(uuid);

        if (!deleted)
            Assertions.fail();

        Optional<Job> jobOptional = jobDAO.findById(uuid);

        Assertions.assertTrue(jobOptional.isEmpty());
    }
}