package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.TreatmentList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-treatment")
@FeignClient(name = "TreatmentServiceFeignClient", url = "http://localhost:8112")
public interface TreatmentServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.TREATMENT_BY_VISIT_ID_PATH)
    ResponseEntity<TreatmentList> getByVisitId(@PathVariable(value = "visit-id") UUID visitId);

}
