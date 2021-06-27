package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.BodyPartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-body-part")
@FeignClient(name = "BodyPartServiceFeignClient", url = "http://localhost:8112")
public interface BodyPartServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.BODY_PART_BY_ID_PATH)
    ResponseEntity<BodyPartDto> getById(@PathVariable UUID id);

}
