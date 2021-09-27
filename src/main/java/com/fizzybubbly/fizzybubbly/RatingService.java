package com.fizzybubbly.fizzybubbly;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private static ReviewRepository reviewRepository;

    public static double getAvgRating(Drink drink) {
        if (reviewRepository == null) {
            return 1;
        } else {
            return reviewRepository.getAvgRating(drink.getId());
        }
    }
}
