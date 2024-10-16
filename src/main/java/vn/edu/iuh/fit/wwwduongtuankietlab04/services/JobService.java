package vn.edu.iuh.fit.wwwduongtuankietlab04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.wwwduongtuankietlab04.dao.JobDAO;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {
    private final JobDAO jobDAO;

    @Autowired
    public JobService(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
    }

    public void createJob(Job job) {
        jobDAO.create(job);
    }

    public List<Job> getAllJobs() {
        return jobDAO.getAll();
    }

    public Optional<Job> getJobById(UUID id) {
        return jobDAO.findById(id);
    }

    public void updateJob(Job job) {
        jobDAO.update(job);
    }

    public void deleteJob(UUID id) {
        jobDAO.delete(id);
    }
}
