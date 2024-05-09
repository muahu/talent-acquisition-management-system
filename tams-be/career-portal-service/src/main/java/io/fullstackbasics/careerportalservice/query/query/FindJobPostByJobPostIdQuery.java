package io.fullstackbasics.careerportalservice.query.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindJobPostByJobPostIdQuery {

    private String jobPostId;
}
