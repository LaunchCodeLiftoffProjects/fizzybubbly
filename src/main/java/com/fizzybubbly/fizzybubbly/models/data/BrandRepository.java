package com.fizzybubbly.fizzybubbly.models.data;

import com.fizzybubbly.fizzybubbly.models.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {
}
