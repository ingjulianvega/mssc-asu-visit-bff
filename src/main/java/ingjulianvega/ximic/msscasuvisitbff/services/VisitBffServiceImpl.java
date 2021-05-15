package ingjulianvega.ximic.msscasuvisitbff.services;


import ingjulianvega.ximic.events.*;
import ingjulianvega.ximic.msscasuvisitbff.configuration.JmsConfig;
import ingjulianvega.ximic.msscasuvisitbff.web.Mappers.VisitBffMapper;
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
    private final VisitBffMapper visitBffMapper;


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
