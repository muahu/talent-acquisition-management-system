package io.fullstackbasics.careerportalservice.query.service;

import io.fullstackbasics.careerportalservice.query.dto.JobPostQueryResponseDTO;
import io.fullstackbasics.careerportalservice.query.query.FindAllJobPostsQuery;
import io.fullstackbasics.careerportalservice.query.query.FindJobPostByJobPostIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class JobPostQueryService {

    private final QueryGateway queryGateway;

    public JobPostQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public ResponseEntity findAllJobPosts(){
        FindAllJobPostsQuery findAllJobPostsQuery = new FindAllJobPostsQuery();

        List<JobPostQueryResponseDTO> jobPostQueryResponseDTOList =
                queryGateway.query(findAllJobPostsQuery, ResponseTypes.multipleInstancesOf(JobPostQueryResponseDTO.class)).join();

        return new ResponseEntity(jobPostQueryResponseDTOList, HttpStatus.OK);
    }

    public ResponseEntity findJobPostByJobPostId(String jobPostId) throws ExecutionException, InterruptedException {
        FindJobPostByJobPostIdQuery findJobPostByJobPostIdQuery = new FindJobPostByJobPostIdQuery(jobPostId);

        JobPostQueryResponseDTO jobPostQueryResponseDTO =
                queryGateway.query(findJobPostByJobPostIdQuery, ResponseTypes.instanceOf(JobPostQueryResponseDTO.class)).get();

        return new ResponseEntity(jobPostQueryResponseDTO, HttpStatus.OK);

    }
}
