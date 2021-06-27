package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.BillingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-billing")
@FeignClient(name = "BillingFeignClient", url = "http://localhost:8112")
public interface BillingFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.BILLING_BY_ID_PATH)
    ResponseEntity<BillingDto> getById(@PathVariable UUID id);

}