package com.fizzybubbly.fizzybubbly.models.data;

import com.fizzybubbly.fizzybubbly.models.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public interface ReviewRepository extends PagingAndSortingRepository <Review, Integer> {
}



