package com.apms.topicHour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicHourRepository extends JpaRepository<TopicHour, Integer> {
}
