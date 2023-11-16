package workflow.example.workflow.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.CvDto;
import workflow.example.workflow.entity.Cv;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CvConverter {

    private final FormationConverter formationConverter;
    private final CompetenceConverter competenceConverter;
    private final InteretConverter interetConverter;
    private final LangueConverter langueConverter;
    private final ExperienceConverter experienceConverter;

    public CvDto entityToDto(Cv cv){
        if (cv == null) {
            return null;
        }
        var dto = new CvDto();
        dto.setId(cv.getId());
        dto.setEmail(cv.getEmail());
        dto.setTel(cv.getTel());
        dto.setAddresse(cv.getAddresse());
        dto.setPrenom(cv.getPrenom());
        dto.setNomFamille(cv.getNomFamille());
        dto.setVille(cv.getVille());
        dto.setTitreProfil(cv.getTitreProfil());
        dto.setFormationDtos(formationConverter.entityToDto(cv.getFormations()));
        dto.setCompetenceDtos(competenceConverter.entityToDto(cv.getCompetences()));
        dto.setInteretDtos(interetConverter.entityToDto(cv.getInterets()));
        dto.setLangueDtos(langueConverter.entityToDto(cv.getLangues()));
        dto.setExperienceDtos(experienceConverter.entityToDto(cv.getExperiences()));

        return dto;
    }
    public List<CvDto> entityToDto(List<Cv> cvs)
    {
        return cvs.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
