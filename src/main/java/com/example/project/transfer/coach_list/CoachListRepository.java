package com.example.project.transfer.coach_list;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachListRepository extends JpaRepository<CoachList, Long> {

    // یافتن مربیان بر اساس ملیت
    List<CoachList> findByNationality(String nationality);

    // یافتن مربیان بر اساس سطح مدرک
    List<CoachList> findByQualificationLevel(String qualificationLevel);
}

