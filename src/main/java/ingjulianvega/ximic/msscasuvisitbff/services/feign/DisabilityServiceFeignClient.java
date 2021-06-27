package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.DisabilityList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-disability")
@FeignClient(name = "DisabilityServiceFeignClient", url = "http://localhost:8112")
public interface DisabilityServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.DISABILITY_BY_VISIT_ID_PATH)
    ResponseEntity<DisabilityList> getByVisitId(@PathVariable(value = "visit-id") UUID visitId);

}
