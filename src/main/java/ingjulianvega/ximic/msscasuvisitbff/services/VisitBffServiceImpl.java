package ingjulianvega.ximic.msscasuvisitbff.services;


import ingjulianvega.ximic.events.*;
import ingjulianvega.ximic.msscasuvisitbff.configuration.JmsConfig;
import ingjulianvega.ximic.msscasuvisitbff.web.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final JmsTemplate jmsTemplate;

    /*private final BillingRepository billingRepository;
    private final BillingMapper billingMapper;


    @Cacheable(cacheNames = "billingListCache")
    @Override
    public BillingList get() {
        log.debug("get()...");
        return BillingList
                .builder()
                .billingDtoList(billingMapper.billingEntityListToBillingDtoList(billingRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "billingCache")
    @Override
    public BillingDto getById(UUID id) {
        log.debug("getById()...");
        return billingMapper.billingEntityToBillingDto(
                billingRepository.findById(id)
                        .orElseThrow(() -> new BillingException(ErrorCodeMessages.BILLING_NOT_FOUND, "")));
    }

    @Override
    public void create(Billing billing) {
        log.debug("create()...");
        billingMapper.billingEntityToBillingDto(
                billingRepository.save(
                        billingMapper.billingDtoToBillingEntity(
                                BillingDto
                                        .builder()
                                        .paymentMethod(billing.getPaymentMethod())
                                        .quantity(billing.getQuantity())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Billing billing) {
        log.debug("updateById...");
        BillingEntity billingEntity = billingRepository.findById(id)
                .orElseThrow(() -> new BillingException(ErrorCodeMessages.BILLING_NOT_FOUND, ""));

        billingEntity.setPaymentMethod(billing.getPaymentMethod());
        billingEntity.setQuantity(billing.getQuantity());
        billingRepository.save(billingEntity);
    }*/

    @Override
    public VisitList getSummaryByPatientId(UUID patientId) {
        log.debug("getSummaryByPatientId()...");
        return null;
    }

    @Override
    public VisitList getSummaryByDate(OffsetDateTime date) {
        log.debug("getSummaryByDate()...");
        return null;
    }

    @Override
    public VisitList getSummaryByDisease(UUID diseaseId) {
        log.debug("getSummaryByDisease()...");
        return null;
    }

    @Override
    public VisitDto getDetailById(UUID id) {
        log.debug("getDetailById()...");
        return null;
    }

    @Transactional
    @Override
    public void updateById(UUID id, Visit visit) {
        log.debug("updateById()...");
        //Visit
        jmsTemplate.convertAndSend(JmsConfig.UPDATE_VISIT_QUEUE, UpdateVisitEvent
                .builder()
                .id(id)
                .patientId(visit.getPatientId())
                .companionId(visit.getCompanionId())
                .visitTypeId(visit.getVisitTypeId())
                .billingId(visit.getBillingId())
                .reason(visit.getReason())
                .height(visit.getHeight())
                .systolicBloodPressure(visit.getSystolicBloodPressure())
                .diastolicBloodPressure(visit.getDiastolicBloodPressure())
                .weight(visit.getWeight())
                .heartRate(visit.getHeartRate())
                .temperature(visit.getTemperature())
                .diseaseId(visit.getDiseaseId())
                .observations(visit.getObservations())
                .build());
        //System check
        Optional<SystemCheckList> optSystemCheckList = Optional.of(visit.getSystemCheckList());
        if( optSystemCheckList.isPresent()){
            visit.getSystemCheckList()
                    .systemCheckDtoList
                    .parallelStream()
                    .forEach(systemCheckDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_SYSTEM_CHECK_QUEUE, UpdateSystemCheckEvent
                                .builder()
                                .visitId(id)
                                .systemId(systemCheckDto.getSystemId())
                                .symptomId(systemCheckDto.getSymptomId())
                                .intensityId(systemCheckDto.getIntensityId())
                                .observations(systemCheckDto.getObservations())
                                .build());
                    });
        }
        //Body check
        Optional<BodyCheckList> optBodyCheckList = Optional.of(visit.getBodyCheckList());
        if( optBodyCheckList.isPresent()){
            visit.getBodyCheckList()
                    .bodyCheckDtoList
                    .parallelStream()
                    .forEach(bodyCheckDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_BODY_CHECK_QUEUE,new UpdateBodyCheckEvent(bodyCheckDto));
                    });
        }
        //Treatment
        Optional<TreatmentList> optTreatmentList = Optional.of(visit.getTreatmentList());
        if( optTreatmentList.isPresent()){
            visit.getTreatmentList()
                    .treatmentDtoList
                    .parallelStream()
                    .forEach(treatmentDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_TREATMENT_QUEUE,new UpdateTreatmentEvent(treatmentDto));
                    });
        }
        //Recommendation
        Optional<RecommendationList> optRecommendationList = Optional.of(visit.getRecommendationList());
        if( optRecommendationList.isPresent()){
            visit.getRecommendationList()
                    .recommendationDtoList
                    .parallelStream()
                    .forEach(recommendationDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_RECOMMENDATION_QUEUE,new UpdateRecommendationEvent(recommendationDto));
                    });
        }
        //Remission
        Optional<RemissionList> optRemissionList = Optional.of(visit.getRemissionList());
        if( optRemissionList.isPresent()){
            visit.getRemissionList()
                    .remissionDtoList
                    .parallelStream()
                    .forEach(remissionDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_REMISSION_QUEUE,new UpdateRemissionEvent(remissionDto));
                    });
        }
        //Disability
        Optional<DisabilityList> optDisabilityList = Optional.of(visit.getDisabilityList());
        if( optDisabilityList.isPresent()){
            visit.getDisabilityList()
                    .disabilityDtoList
                    .parallelStream()
                    .forEach(disabilityDto -> {
                        jmsTemplate.convertAndSend(JmsConfig.UPDATE_DISABILITY_QUEUE,new UpdateDisabilityEvent(disabilityDto));
                    });
        }
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");

    }
}
