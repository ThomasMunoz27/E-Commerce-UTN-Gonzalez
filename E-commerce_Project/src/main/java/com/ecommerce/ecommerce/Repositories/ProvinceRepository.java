package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Entities.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends BaseRepository<Province,Long>{
    List<Province> findByCountryId(Long countryId);
}
