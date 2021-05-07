package ingjulianvega.ximic.msscasuvisitbff.services;

import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class VisitBffServiceImpl implements VisitBffService {

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

    @Override
    public void updateById(UUID id, Visit visit) {
        log.debug("updateById()...");
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");

    }
}
