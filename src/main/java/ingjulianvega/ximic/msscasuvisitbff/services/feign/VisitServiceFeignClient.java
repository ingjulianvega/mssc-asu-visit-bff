package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.OffsetDateTime;
import java.util.UUID;

@FeignClient(name = "mssc-asu-visit")
public interface VisitServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.VISIT_BY_ID_PATH)
    ResponseEntity<VisitDto> getById(@PathVariable UUID id);

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.VISIT_BY_PATIENT_ID_PATH)
    ResponseEntity<VisitList> getByPatientId(@PathVariable UUID patientId);

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.VISIT_BY_DISEASE_ID_PATH)
    ResponseEntity<VisitList> getByDiseaseId(@PathVariable UUID diseaseId);

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.VISIT_BY_DATE_PATH)
    ResponseEntity<VisitList> getByDate(@PathVariable OffsetDateTime createdDate);

}
