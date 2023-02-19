package com.telemed.telemed.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {

    List<Record> findByUser(User user);

    void deleteByUserId(long id);

}
