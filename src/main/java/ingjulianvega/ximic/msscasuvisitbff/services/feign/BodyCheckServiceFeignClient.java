package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.BodyCheckList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-body-check")
@FeignClient(name = "simple-client1000", url = "http://localhost:8112")
public interface BodyCheckServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.BODY_CHECK_BY_VISIT_ID_PATH)
    ResponseEntity<BodyCheckList> getByVisitId(@PathVariable(value = "visit-id")  UUID visitId);

}
