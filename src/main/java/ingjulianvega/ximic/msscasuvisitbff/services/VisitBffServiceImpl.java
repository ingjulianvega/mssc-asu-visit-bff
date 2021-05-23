package ingjulianvega.ximic.msscasuvisitbff.services;


import ingjulianvega.ximic.events.UpdateVisitEvent;
import ingjulianvega.ximic.msscasuvisitbff.configuration.JmsConfig;
import ingjulianvega.ximic.msscasuvisitbff.services.feign.*;
import ingjulianvega.ximic.msscasuvisitbff.web.Mappers.VisitBffMapper;
import ingjulianvega.ximic.msscasuvisitbff.web.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class VisitBffServiceImpl implements VisitBffService {

    public static final String VISIT_BY_ID_PATH = "/asu/v1/visit/{id}";
    public static final String VISIT_BY_PATIENT_ID_PATH = "/asu/v1/visit/patient-id/{patient-id}";
    public static final String VISIT_BY_DATE_PATH = "/asu/v1/visit/created-date/{created-date}";
    public static final String VISIT_BY_DISEASE_ID_PATH = "/asu/v1/visit/disease/{disease-id}";
    public static final String SYSTEM_CHECK_BY_VISIT_ID_PATH = "/asu/v1/system-check/visit-id/{visit-id}";
    public static final String BODY_CHECK_BY_VISIT_ID_PATH = "/asu/v1/body-check/visit-id/{visit-id}";
    public static final String TREATMENT_BY_VISIT_ID_PATH = "/asu/v1/treatment/visit-id/{visit-id}";
    public static final String RECOMMENDATION_BY_VISIT_ID_PATH = "/asu/v1/recommendation/visit-id/{visit-id}";
    public static final String REMISSION_BY_VISIT_ID_PATH = "/asu/v1/remission/visit-id/{visit-id}";
    public static final String DISABILITY_BY_VISIT_ID_PATH = "/asu/v1/disability/visit-id/{visit-id}";
    public static final String DOCUMENT_TYPE_BY_ID_PATH = "/asu/v1/document-type/{id}";
    public static final String MARITAL_STATUS_BY_ID_PATH = "/asu/v1/marital-status/{id}";
    public static final String GENDER_BY_ID_PATH = "/asu/v1/gender/{id}";
    public static final String OCCUPATION_BY_ID_PATH = "/asu/v1/occupation/{id}";
    public static final String EPS_BY_ID_PATH = "/asu/v1/eps/{id}";
    public static final String ARL_BY_ID_PATH = "/asu/v1/arl/{id}";
    public static final String COMPANION_BY_ID_PATH = "/asu/v1/companion/{id}";
    public static final String EVIDENCE_BY_ID_PATH = "/asu/v1/evidence/{id}";
    public static final String EVIDENCE_TYPE_BY_ID_PATH = "/asu/v1/evidence-type/{id}";
    public static final String DISEASE_BY_ID_PATH = "/asu/v1/evidence-type/{id}";
    public static final String SYSTEM_BY_ID_PATH = "/asu/v1/system/{id}";
    public static final String SYMPTOM_BY_ID_PATH = "/asu/v1/symptom/{id}";
    public static final String INTENSITY_BY_ID_PATH = "/asu/v1/intensity/{id}";
    public static final String BODY_PART_BY_ID_PATH = "/asu/v1/body-part/{id}";
    public static final String MEDICINE_BY_ID_PATH = "/asu/v1/medicine/{id}";
    public static final String CONCENTRATION_BY_ID_PATH = "/asu/v1/concentration/{id}";
    public static final String ADMINISTRATION_METHOD_BY_ID_PATH = "/asu/v1/administration-method/{id}";
    public static final String DURATION_BY_ID_PATH = "/asu/v1/duration/{id}";
    public static final String RECOMMENDATION_TYPE_BY_ID_PATH = "/asu/v1/recommendation-type/{id}";
    public static final String VISIT_TYPE_BY_ID_PATH = "/asu/v1/visit-type/{id}";
    public static final String DISABILITY_TYPE_BY_ID_PATH = "/asu/v1/disability-type/{id}";
    public static final String REMISSION_TYPE_BY_ID_PATH = "/asu/v1/remission-type/{id}";
    public static final String PATIENT_BY_ID_PATH = "/asu/v1/patient/{id}";


    private final VisitServiceFeignClient visitServiceFeignClient;
    private final SystemCheckServiceFeignClient systemCheckServiceFeignClient;
    private final BodyCheckServiceFeignClient bodyCheckServiceFeignClient;
    private final TreatmentServiceFeignClient treatmentServiceFeignClient;
    private final RecommendationServiceFeignClient recommendationServiceFeignClient;
    private final RemissionServiceFeignClient remissionServiceFeignClient;
    private final DisabilityServiceFeignClient disabilityServiceFeignClient;
    private final PatientServiceFeignClient patientServiceFeignClient;
    private final DocumentTypeServiceFeignClient documentTypeServiceFeignClient;
    private final MaritalStatusServiceFeignClient maritalStatusServiceFeignClient;
    private final GenderServiceFeignClient genderServiceFeignClient;
    private final OccupationServiceFeignClient occupationServiceFeignClient;
    private final EpsServiceFeignClient epsServiceFeignClient;
    private final ArlServiceFeignClient arlServiceFeignClient;
    private final CompanionServiceFeignClient companionServiceFeignClient;
    private final SystemServiceFeignClient systemServiceFeignClient;
    private final SymptomServiceFeignClient symptomServiceFeignClient;
    private final IntensityServiceFeignClient intensityServiceFeignClient;
    private final BodyPartServiceFeignClient bodyPartServiceFeignClient;
    private final MedicineServiceFeignClient medicineServiceFeignClient;
    private final ConcentrationServiceFeignClient concentrationServiceFeignClient;
    private final AdministrationMethodServiceFeignClient administrationMethodServiceFeignClient;
    private final DurationServiceFeignClient durationServiceFeignClient;
    private final RecommendationTypeServiceFeignClient recommendationTypeServiceFeignClient;
    private final RemissionTypeServiceFeignClient remissionTypeServiceFeignClient;
    private final DisabilityTypeServiceFeignClient disabilityTypeServiceFeignClient;


    private final JmsTemplate jmsTemplate;
    private final VisitBffMapper visitBffMapper;

    @Override
    public VisitListBffResponse getSummaryByPatientId(UUID patientId) {
        log.debug("getSummaryByPatientId()...");
        ResponseEntity<VisitList> responseEntity = visitServiceFeignClient.getByPatientId(patientId);
        return null;
    }

    @Override
    public VisitListBffResponse getSummaryByDate(OffsetDateTime date) {
        log.debug("getSummaryByDate()...");
        ResponseEntity<VisitList> responseEntity = visitServiceFeignClient.getByDate(date);
        return null;
    }

    @Override
    public VisitListBffResponse getSummaryByDisease(UUID diseaseId) {
        log.debug("getSummaryByDisease()...");
        ResponseEntity<VisitList> responseEntity = visitServiceFeignClient.getByDiseaseId(diseaseId);
        return null;
    }

    @Override
    public VisitBffResponse getDetailById(UUID id) {
        log.debug("getDetailById()...");
        ResponseEntity<VisitDto> visitDtoResponse = visitServiceFeignClient.getById(id);

        //Patient
        ResponseEntity<PatientDto> patientDtoResponse = patientServiceFeignClient.getById(visitDtoResponse.getBody().getPatientId());

        //DocumentType
        ResponseEntity<DocumentTypeDto> documentTypeDtoResponse = documentTypeServiceFeignClient.getById(patientDtoResponse.getBody().getDocumentTypeId());

        //MaritalStatus
        ResponseEntity<MaritalStatusDto> maritalStatusDtoResponse = maritalStatusServiceFeignClient.getById(patientDtoResponse.getBody().getMaritalStatusId());

        //Gender
        ResponseEntity<GenderDto> genderDtoResponse = genderServiceFeignClient.getById(patientDtoResponse.getBody().getGenderId());

        //Occupation
        ResponseEntity<OccupationDto> occupationDtoResponse = occupationServiceFeignClient.getById(patientDtoResponse.getBody().getOccupationId());

        //Eps
        ResponseEntity<EpsDto> epsDtoResponse = epsServiceFeignClient.getById(patientDtoResponse.getBody().getEpsId());

        //Arl
        ResponseEntity<ArlDto> arlDtoResponse = arlServiceFeignClient.getById(patientDtoResponse.getBody().getArlId());

        //Companion
        ResponseEntity<CompanionDto> companionDtoResponse = companionServiceFeignClient.getById(visitDtoResponse.getBody().getCompanionId());

        //CompanionDocumentType
        ResponseEntity<DocumentTypeDto> companionDocumentTypeDtoResponse = documentTypeServiceFeignClient.getById(companionDtoResponse.getBody().getDocumentTypeId());

        //System check
        ResponseEntity<SystemCheckList> systemCheckResponse = systemCheckServiceFeignClient.getByVisitId(id);
        //TODO if not null

        SystemCheckListBffResponse systemCheckListBffResponse = SystemCheckListBffResponse
                .builder()
                .systemCheckList(systemCheckResponse
                        .getBody()
                        .getSystemCheckList()
                        .parallelStream()
                        .map(systemCheckDto -> {
                            //System
                            ResponseEntity<SystemDto> systemDtoResponse = systemServiceFeignClient.getById(systemCheckDto.getSystemId());
                            //Symptom
                            ResponseEntity<SymptomDto> symptomDtoResponse = symptomServiceFeignClient.getById(systemCheckDto.getSymptomId());
                            //Intensity
                            ResponseEntity<IntensityDto> intensityDtoResponse = intensityServiceFeignClient.getById(systemCheckDto.getIntensityId());

                            return SystemCheckDtoBffResponse
                                    .builder()//TODO Does not have id?
                                    .visitId(id)
                                    .system(systemDtoResponse.getBody())
                                    .symptom(symptomDtoResponse.getBody())
                                    .intensity(intensityDtoResponse.getBody())
                                    .observations(systemCheckDto.getObservations())
                                    .build();
                        })
                        .collect(Collectors
                                .toCollection(ArrayList::new)))
                .build();


        //Body check
        ResponseEntity<BodyCheckList> bodyCheckResponse = bodyCheckServiceFeignClient.getByVisitId(id);

        //TODO if not null
        BodyCheckListBffResponse bodyCheckListBffResponse = BodyCheckListBffResponse
                .builder()
                .bodyCheckList(bodyCheckResponse
                        .getBody()
                        .getBodyCheckList()
                        .parallelStream()
                        .map(bodyCheckDto -> {
                            //BodPart
                            ResponseEntity<BodyPartDto> bodyPartDtoResponse = bodyPartServiceFeignClient.getById(bodyCheckDto.getBodyPartId());

                            return BodyCheckDtoBffResponse
                                    .builder()//TODO Does not have id?
                                    .visitId(id)
                                    .bodyPart(bodyPartDtoResponse.getBody())
                                    .observations(bodyCheckDto.getObservations())
                                    .build();
                        })
                        .collect(Collectors
                                .toCollection(ArrayList::new)))
                .build();


        //Treatment
        ResponseEntity<TreatmentList> treatmentResponse = treatmentServiceFeignClient.getByVisitId(id);

        TreatmentListBffResponse treatmentListBffResponse = TreatmentListBffResponse
                .builder()
                .treatmentList(treatmentResponse
                        .getBody()
                        .getTreatmentList()
                        .parallelStream()
                        .map(treatmentDto -> {
                            //Medicine
                            ResponseEntity<MedicineDto> medicineDtoResponse = medicineServiceFeignClient.getById(treatmentDto.getMedicineId());

                            //Concentration
                            ResponseEntity<ConcentrationDto> concentrationDtoResponse = concentrationServiceFeignClient.getById(treatmentDto.getConcentrationId());

                            //AdministrationMethod
                            ResponseEntity<AdministrationMethodDto> administrationMethodDtoResponse = administrationMethodServiceFeignClient.getById(treatmentDto.getAdministrationMethodId());

                            //DurationId
                            ResponseEntity<DurationDto> durationDtoResponse = durationServiceFeignClient.getById(treatmentDto.getDurationId());

                            return TreatmentDtoBffResponse
                                    .builder()
                                    .id(treatmentDto.getId())
                                    .visitId(id)
                                    .medicine(medicineDtoResponse.getBody())
                                    .concentrationQuantity(treatmentDto.getConcentrationQuantity())
                                    .concentration(concentrationDtoResponse.getBody())
                                    .administrationMethod(administrationMethodDtoResponse.getBody())
                                    .durationQuantity(treatmentDto.getDurationQuantity())
                                    .duration(durationDtoResponse.getBody())
                                    .observations(treatmentDto.getObservations())
                                    .build();
                        })
                        .collect(Collectors
                                .toCollection(ArrayList::new)))
                .build();


        //Recommendation
        ResponseEntity<RecommendationList> recommendationResponse = recommendationServiceFeignClient.getByVisitId(id);

        RecommendationListBffResponse recommendationListBffResponse = RecommendationListBffResponse
                .builder()
                .recommendationList(recommendationResponse
                        .getBody()
                        .getRecommendationList()
                        .parallelStream()
                        .map(recommendationDto -> {
                            //RecommendationType
                            ResponseEntity<RecommendationTypeDto> recommendationTypeDtoResponse = recommendationTypeServiceFeignClient.getById(recommendationDto.getRecommendationTypeId());

                            return RecommendationDtoBffResponse
                                    .builder()
                                    .id(recommendationDto.getId())
                                    .visitId(id)
                                    .recommendationType(recommendationTypeDtoResponse.getBody())
                                    .observations(recommendationDto.getObservations())
                                    .build();
                        })
                        .collect(Collectors
                                .toCollection(ArrayList::new)))
                .build();

        //Remission
        ResponseEntity<RemissionList> remissionResponse = remissionServiceFeignClient.getByVisitId(id);

        RemissionListBffResponse remissionListBffResponse = RemissionListBffResponse
                .builder()
                .remissionList(remissionResponse
                        .getBody()
                        .getRemissionList()
                        .parallelStream()
                        .map(remissionDto -> {
                            //RemissionType
                            ResponseEntity<RemissionTypeDto> remissionTypeDtoResponse = remissionTypeServiceFeignClient.getById(remissionDto.getRemissionTypeId());

                            return RemissionDtoBffResponse
                                    .builder()
                                    .id(remissionDto.getId())
                                    .visitId(id)
                                    .remissionType(remissionTypeDtoResponse.getBody())
                                    .observations(remissionDto.getObservations())
                                    .build();
                        })
                        .collect(Collectors
                                .toCollection(ArrayList::new)))
                .build();

        //Disability
        ResponseEntity<DisabilityList> disabilityResponse = disabilityServiceFeignClient.getByVisitId(id);

        DisabilityListBffResponse disabilityListBffResponse = DisabilityListBffResponse
                .builder()
                .disabilityList(disabilityResponse
                        .getBody()
                        .getDisabilityList()
                        .parallelStream()
                        .map(disabilityDto -> {
                            //DisabilityType
                            ResponseEntity<DisabilityTypeDto> disabilityTypeDtoResponse = disabilityTypeServiceFeignClient.getById(disabilityDto.getDisabilityTypeId());

                            //DurationId
                            ResponseEntity<DurationDto> durationDtoResponse = durationServiceFeignClient.getById(disabilityDto.getDurationId());

                            return DisabilityDtoBffResponse
                                    .builder()
                                    .id(disabilityDto.getId())
                                    .visitId(id)
                                    .disabilityType(disabilityTypeDtoResponse.getBody())
                                    .durationQuantity(disabilityDto.getDurationQuantity())
                                    .duration(durationDtoResponse.getBody())
                                    .observations(disabilityDto.getObservations())
                                    .build();
                        })
                        .collect(Collectors
                                .toCollection(ArrayList::new)))
                .build();

        VisitBffResponse
                .builder()
                .patient(PatientDtoBffResponse
                        .builder()
                        .id(visitDtoResponse.getBody().getPatientId())
                        .documentType(documentTypeDtoResponse.getBody())
                        .documentNumber(patientDtoResponse.getBody().getDocumentNumber())
                        .name(patientDtoResponse.getBody().getName())
                        .firstLastName(patientDtoResponse.getBody().getFirstLastName())
                        .secondLastName(patientDtoResponse.getBody().getSecondLastName())
                        .homePhone(patientDtoResponse.getBody().getHomePhone())
                        .mobilePhone(patientDtoResponse.getBody().getMobilePhone())
                        .email(patientDtoResponse.getBody().getEmail())
                        .birthDate(patientDtoResponse.getBody().getBirthDate())
                        .hand(patientDtoResponse.getBody().getHand())
                        .address(patientDtoResponse.getBody().getAddress())
                        .maritalStatus(maritalStatusDtoResponse.getBody())
                        .gender(genderDtoResponse.getBody())
                        .occupation(occupationDtoResponse.getBody())
                        .eps(epsDtoResponse.getBody())
                        .arl(arlDtoResponse.getBody())
                        .build())
                .companion(CompanionDtoBffResponse
                        .builder()
                        .id(companionDtoResponse.getBody().getId())
                        .documentType(companionDocumentTypeDtoResponse.getBody())
                        .name(companionDtoResponse.getBody().getName())
                        .firstLastName(companionDtoResponse.getBody().getFirstLastName())
                        .secondLastName(companionDtoResponse.getBody().getSecondLastName())
                        .homePhone(companionDtoResponse.getBody().getHomePhone())
                        .mobilePhone(companionDtoResponse.getBody().getMobilePhone())
                        .email(companionDtoResponse.getBody().getEmail())
                        .build())
                .visit(VisitTypeDto
                        .builder()
                        .build())
                .billing(BillingDto
                        .builder()
                        .build())
                .disease(DiseaseDto
                        .builder()
                        .build())
                .reason(visitDtoResponse.getBody().getReason())
                .height(visitDtoResponse.getBody().getHeight())
                .systolicBloodPressure(visitDtoResponse.getBody().getSystolicBloodPressure())
                .diastolicBloodPressure(visitDtoResponse.getBody().getDiastolicBloodPressure())
                .weight(visitDtoResponse.getBody().getWeight())
                .heartRate(visitDtoResponse.getBody().getHeartRate())
                .temperature(visitDtoResponse.getBody().getTemperature())
                .observations(visitDtoResponse.getBody().getObservations())
                .systemCheckList(SystemCheckListBffResponse
                        .builder()
                        .build())
                .bodyCheckList(BodyCheckListBffResponse
                        .builder()
                        .build())
                .treatmentList(TreatmentListBffResponse
                        .builder()
                        .build())
                .recommendationList(RecommendationListBffResponse
                        .builder()
                        .build())
                .disabilityList(DisabilityListBffResponse
                        .builder()
                        .build())
                .remissionList(RemissionListBffResponse
                        .builder()
                        .build())
                .build();
        return null;
    }

    @Transactional
    @Override
    public void updateById(UUID id, Visit visit) {
        log.debug("updateById()...");
        //Visit
        UpdateVisitEvent updateVisitEvent = visitBffMapper.visitToUpdateVisitEvent(visit);
        updateVisitEvent.setId(id);
        jmsTemplate.convertAndSend(JmsConfig.UPDATE_VISIT_QUEUE, updateVisitEvent);
        //System check
        Optional<SystemCheckList> optSystemCheckList = Optional.of(visit.getSystemCheckList());
        if( optSystemCheckList.isPresent()){
            visit.getSystemCheckList()
                    .systemCheckList
                    .parallelStream()
                    .forEach(systemCheckDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_SYSTEM_CHECK_QUEUE,
                                visitBffMapper.systemCheckDtoToUpdateSystemCheckEvent(systemCheckDto));
                    });
        }
        //Body check
        Optional<BodyCheckList> optBodyCheckList = Optional.of(visit.getBodyCheckList());
        if( optBodyCheckList.isPresent()){
            visit.getBodyCheckList()
                    .bodyCheckList
                    .parallelStream()
                    .forEach(bodyCheckDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_BODY_CHECK_QUEUE,
                                visitBffMapper.bodyCheckDtoToUpdateBodyCheckEvent(bodyCheckDto));
                    });
        }
        //Treatment
        Optional<TreatmentList> optTreatmentList = Optional.of(visit.getTreatmentList());
        if( optTreatmentList.isPresent()){
            visit.getTreatmentList()
                    .treatmentList
                    .parallelStream()
                    .forEach(treatmentDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_TREATMENT_QUEUE,
                                visitBffMapper.treatmentDtoToUpdateTreatmentEvent(treatmentDto));
                    });
        }
        //Recommendation
        Optional<RecommendationList> optRecommendationList = Optional.of(visit.getRecommendationList());
        if( optRecommendationList.isPresent()){
            visit.getRecommendationList()
                    .recommendationList
                    .parallelStream()
                    .forEach(recommendationDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_RECOMMENDATION_QUEUE,
                                visitBffMapper.recommendationDtoToUpdateRecommendationEvent(recommendationDto));
                    });
        }
        //Remission
        Optional<RemissionList> optRemissionList = Optional.of(visit.getRemissionList());
        if( optRemissionList.isPresent()){
            visit.getRemissionList()
                    .remissionList
                    .parallelStream()
                    .forEach(remissionDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_REMISSION_QUEUE,
                                visitBffMapper.remissionDtoToUpdateRemissionEvent(remissionDto));
                    });
        }
        //Disability
        Optional<DisabilityList> optDisabilityList = Optional.of(visit.getDisabilityList());
        if( optDisabilityList.isPresent()){
            visit.getDisabilityList()
                    .disabilityList
                    .parallelStream()
                    .forEach(disabilityDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_DISABILITY_QUEUE,
                                visitBffMapper.disabilityDtoToUpdateDisabilityEvent(disabilityDto));
                    });
        }
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");

    }
}
