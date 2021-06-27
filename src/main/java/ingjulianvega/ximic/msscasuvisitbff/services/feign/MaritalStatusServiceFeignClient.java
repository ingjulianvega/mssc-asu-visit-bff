package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.MaritalStatusDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-marital-status")
@FeignClient(name = "MaritalStatusServiceFeignClient", url = "http://localhost:8112")
public interface MaritalStatusServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.MARITAL_STATUS_BY_ID_PATH)
    ResponseEntity<MaritalStatusDto> getById(@PathVariable UUID id);

}