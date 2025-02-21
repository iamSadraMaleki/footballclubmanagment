package com.example.project.transfer.coach_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachListService {

    @Autowired
    private CoachListRepository coachListRepository;

    // افزودن مربی جدید
    public CoachList addCoach(CoachList coach) {
        return coachListRepository.save(coach);
    }

    // دریافت لیست همه مربیان
    public List<CoachList> getAllCoaches() {
        return coachListRepository.findAll();
    }

    // دریافت جزئیات مربی بر اساس ID
    public CoachList getCoachById(Long id) {
        return coachListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("مربی یافت نشد"));
    }

    // ویرایش اطلاعات مربی
    public CoachList updateCoach(Long id, CoachList updatedCoach) {
        CoachList existingCoach = getCoachById(id);

        existingCoach.setFirstName(updatedCoach.getFirstName());
        existingCoach.setLastName(updatedCoach.getLastName());
        existingCoach.setAge(updatedCoach.getAge());
        existingCoach.setNationality(updatedCoach.getNationality());
        existingCoach.setRole(updatedCoach.getRole());
        existingCoach.setQualificationLevel(updatedCoach.getQualificationLevel());
        existingCoach.setContractDuration(updatedCoach.getContractDuration());
        existingCoach.setContractAmount(updatedCoach.getContractAmount());

        return coachListRepository.save(existingCoach);
    }

    // حذف مربی
    public void deleteCoachById(Long id) {
        if (!coachListRepository.existsById(id)) {
            throw new RuntimeException("مربی یافت نشد");
        }
        coachListRepository.deleteById(id);
    }
}
