package ingjulianvega.ximic.msscasuvisitbff.web.Mappers;


import ingjulianvega.ximic.events.*;
import ingjulianvega.ximic.msscasuvisitbff.web.model.*;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface VisitBffMapper {

    UpdateVisitEvent visitToUpdateVisitEvent(Visit visit);

    UpdateSystemCheckEvent systemCheckToUpdateSystemCheckEvent(SystemCheck systemCheck);

    UpdateBodyCheckEvent bodyCheckToUpdateBodyCheckEvent(BodyCheck bodyCheck);

    UpdateTreatmentEvent treatmentToUpdateTreatmentEvent(Treatment treatment);

    UpdateRecommendationEvent recommendationToUpdateRecommendationEvent(Recommendation recommendation);

    UpdateRemissionEvent remissionToUpdateRemissionEvent(Remission remission);

    UpdateDisabilityEvent disabilityToUpdateDisabilityEvent(Disability disability);

}