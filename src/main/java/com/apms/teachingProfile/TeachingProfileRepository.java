package com.apms.teachingProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingProfileRepository extends JpaRepository<TeachingProfile, Integer> {
}
