package com.readingtime.restservice.repository;

import com.readingtime.restservice.model.readingtime.ReadingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingTimeRepository extends JpaRepository<ReadingTime, Long> {

}
