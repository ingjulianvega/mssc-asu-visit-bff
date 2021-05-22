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
import java.util.Optional;
import java.util.UUID;

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

    private final VisitServiceFeignClient visitServiceFeignClient;
    private final SystemCheckServiceFeignClient systemCheckServiceFeignClient;
    private final BodyCheckServiceFeignClient bodyCheckServiceFeignClient;
    private final TreatmentServiceFeignClient treatmentServiceFeignClient;
    private final RecommendationServiceFeignClient recommendationServiceFeignClient;
    private final RemissionServiceFeignClient remissionServiceFeignClient;
    private final DisabilityServiceFeignClient disabilityServiceFeignClient;
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
    public VisitListBffResponse getDetailById(UUID id) {
        log.debug("getDetailById()...");
        ResponseEntity<VisitDto> visitResponse = visitServiceFeignClient.getById(id);
        //System check
        ResponseEntity<SystemCheckList> systemCheckResponse = systemCheckServiceFeignClient.getByVisitId(id);

        //Body check
        ResponseEntity<BodyCheckList> bodyCheckResponse = bodyCheckServiceFeignClient.getByVisitId(id);

        //Treatment
        ResponseEntity<TreatmentList> treatmentResponse = treatmentServiceFeignClient.getByVisitId(id);

        //Recommendation
        ResponseEntity<RecommendationList> recommendationResponse = recommendationServiceFeignClient.getByVisitId(id);

        //Remission
        ResponseEntity<RemissionList> remissionResponse = remissionServiceFeignClient.getByVisitId(id);

        //Disability
        ResponseEntity<DisabilityList> disabilityResponse = disabilityServiceFeignClient.getByVisitId(id);
        //TODO foreach elemento of the list

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
                    .forEach(systemCheck -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_SYSTEM_CHECK_QUEUE,
                                visitBffMapper.systemCheckToUpdateSystemCheckEvent(systemCheck));
                    });
        }
        //Body check
        Optional<BodyCheckList> optBodyCheckList = Optional.of(visit.getBodyCheckList());
        if( optBodyCheckList.isPresent()){
            visit.getBodyCheckList()
                    .bodyCheckList
                    .parallelStream()
                    .forEach(bodyCheck -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_BODY_CHECK_QUEUE,
                                visitBffMapper.bodyCheckToUpdateBodyCheckEvent(bodyCheck));
                    });
        }
        //Treatment
        Optional<TreatmentList> optTreatmentList = Optional.of(visit.getTreatmentList());
        if( optTreatmentList.isPresent()){
            visit.getTreatmentList()
                    .treatmentList
                    .parallelStream()
                    .forEach(treatment -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_TREATMENT_QUEUE,
                                visitBffMapper.treatmentToUpdateTreatmentEvent(treatment));
                    });
        }
        //Recommendation
        Optional<RecommendationList> optRecommendationList = Optional.of(visit.getRecommendationList());
        if( optRecommendationList.isPresent()){
            visit.getRecommendationList()
                    .recommendationList
                    .parallelStream()
                    .forEach(recommendation -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_RECOMMENDATION_QUEUE,
                                visitBffMapper.recommendationToUpdateRecommendationEvent(recommendation));
                    });
        }
        //Remission
        Optional<RemissionList> optRemissionList = Optional.of(visit.getRemissionList());
        if( optRemissionList.isPresent()){
            visit.getRemissionList()
                    .remissionList
                    .parallelStream()
                    .forEach(remission -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_REMISSION_QUEUE,
                                visitBffMapper.remissionToUpdateRemissionEvent(remission));
                    });
        }
        //Disability
        Optional<DisabilityList> optDisabilityList = Optional.of(visit.getDisabilityList());
        if( optDisabilityList.isPresent()){
            visit.getDisabilityList()
                    .disabilityList
                    .parallelStream()
                    .forEach(disability -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_DISABILITY_QUEUE,
                                visitBffMapper.disabilityToUpdateDisabilityEvent(disability));
                    });
        }
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");

    }
}
