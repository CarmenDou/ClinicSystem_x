package net.java.clinicsystem.service;

import net.java.clinicsystem.model.Attack;
import net.java.clinicsystem.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttackService {
    @Autowired
    private AttackRepository attackRepository;

    public List<Attack> getReportsForLastSevenDays(Long participantId){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sevenDaysAgo = now.minusDays(7);
        return attackRepository.findByParticipantIdAndAttackDateTime(participantId, sevenDaysAgo, now);
    }
}
