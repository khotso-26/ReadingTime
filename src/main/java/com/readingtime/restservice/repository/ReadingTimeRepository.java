package com.readingtime.restservice.repository;

import com.readingtime.restservice.model.ReadingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReadingTimeRepository extends JpaRepository<ReadingTime, Long> {

    @Query("SELECT w FROM reading w WHERE w.words = ?1")
    Optional<ReadingTime> findWords(String words);
}
