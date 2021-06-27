package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.ConcentrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-concentration")
@FeignClient(name = "ConcentrationServiceFeignClient", url = "http://localhost:8112")
public interface ConcentrationServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.CONCENTRATION_BY_ID_PATH)
    ResponseEntity<ConcentrationDto> getById(@PathVariable UUID id);

}