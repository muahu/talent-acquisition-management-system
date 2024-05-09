package io.fullstackbasics.careerportalservice.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, String> {
}
