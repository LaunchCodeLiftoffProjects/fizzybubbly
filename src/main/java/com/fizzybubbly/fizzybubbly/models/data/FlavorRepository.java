package com.fizzybubbly.fizzybubbly.models.data;

import com.fizzybubbly.fizzybubbly.models.Flavor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public interface FlavorRepository extends PagingAndSortingRepository<Flavor, Integer> {
}
