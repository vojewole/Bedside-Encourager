package com.victor.bedsideencourager.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.victor.bedsideencourager.models.PosterRecipient;


@Repository
public interface PosterRecipientRepository extends CrudRepository<PosterRecipient, Long> {
 
 List<PosterRecipient> findAll();
 
}
