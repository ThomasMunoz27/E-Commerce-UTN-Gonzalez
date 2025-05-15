package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Entities.Locality;
import com.ecommerce.ecommerce.Entities.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalityRepository extends BaseRepository<Locality, Long>{
    List<Locality> findByProvinceId(Long countryId);
}
