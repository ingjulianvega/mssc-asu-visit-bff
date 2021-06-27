package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.OccupationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-occupation")
@FeignClient(name = "OccupationServiceFeignClient", url = "http://localhost:8112")
public interface OccupationServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.OCCUPATION_BY_ID_PATH)
    ResponseEntity<OccupationDto> getById(@PathVariable UUID id);

}