package net.java.clinicsystem.repository;

import net.java.clinicsystem.model.Attack;
import net.java.clinicsystem.model.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttackRepository extends JpaRepository<Attack, Long> {
    Attack findFirstByParticipantOrderByAttackDateTimeDesc(Participant participant);

    @Query(value = "select * from attack where participant_id = ?1 order by attack_datetime desc", nativeQuery = true)
    Page<Attack> findByParticipantIdOrderByAttackDateTime(Long participant_id, Pageable pageable);

}
