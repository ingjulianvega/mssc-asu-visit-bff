package ingjulianvega.ximic.msscasuvisitbff.web.Mappers;


import ingjulianvega.ximic.events.*;
import ingjulianvega.ximic.msscasuvisitbff.web.model.*;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface VisitBffMapper {

    UpdateVisitEvent visitToUpdateVisitEvent(Visit visit);

    UpdateSystemCheckEvent systemCheckDtoToUpdateSystemCheckEvent(SystemCheckDto systemCheckDto);

    UpdateBodyCheckEvent bodyCheckDtoToUpdateBodyCheckEvent(BodyCheckDto bodyCheckDto);

    UpdateTreatmentEvent treatmentDtoToUpdateTreatmentEvent(TreatmentDto treatmentDto);

    UpdateRecommendationEvent recommendationDtoToUpdateRecommendationEvent(RecommendationDto recommendationDto);

    UpdateRemissionEvent remissionDtoToUpdateRemissionEvent(RemissionDto remissionDto);

    UpdateDisabilityEvent disabilityDtoToUpdateDisabilityEvent(DisabilityDto disabilityDto);

}