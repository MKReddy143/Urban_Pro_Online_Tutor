package com.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.demoVideo;

@Repository
public interface demoVideoRepository extends JpaRepository<demoVideo, String> {

}
