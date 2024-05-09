package fullstackbasics.io.tamscoreapi.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class CandidateSkills {

    @Enumerated(EnumType.STRING)
    private CoreSkill coreSkill;
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;
}
