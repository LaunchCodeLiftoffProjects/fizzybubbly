package com.fizzybubbly.fizzybubbly.models.data;

import com.fizzybubbly.fizzybubbly.models.UserReviews;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public interface UserReviewsRepository extends PagingAndSortingRepository <UserReviews, Integer> {
}



