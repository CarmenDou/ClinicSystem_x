package net.java.clinicsystem.controller;

import net.java.clinicsystem.model.Attack;
import net.java.clinicsystem.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class AttackController {
    @Autowired
    private AttackRepository attackRepository;

    @GetMapping("/attacks/{participantId}")
    public Page<Attack> getAttacksByParticipantId(@PathVariable Long participantId, Pageable pageable) {
        Page<Attack> attacks = attackRepository.findByParticipantIdOrderByAttackDateTime(participantId, pageable);
        System.out.println(attacks.getTotalPages());
        return attackRepository.findByParticipantIdOrderByAttackDateTime(participantId, pageable);
    }
}