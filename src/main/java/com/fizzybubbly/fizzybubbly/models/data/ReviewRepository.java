package com.fizzybubbly.fizzybubbly.models.data;

import com.fizzybubbly.fizzybubbly.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Transactional
public interface ReviewRepository extends PagingAndSortingRepository <Review, Integer> {

    @Query(value = "SELECT * FROM review WHERE drink_id = :drinkId AND user_id = :userId", nativeQuery = true)
    List<Review> findReviewsByDrinkIdAndUserId(@Param("drinkId") Integer drinkId, @Param("userId") Integer userId);

    @Query(value = "SELECT * FROM review ORDER BY id DESC LIMIT 0,1;", nativeQuery = true)
    Integer findLatestReviewId();

    @Query(value = "SELECT IFNULL((SELECT AVG(rating) FROM review WHERE drink_id = :drinkId), 0)", nativeQuery = true)
    double getAvgRating(@Param("drinkId") Integer drinkId);

}


