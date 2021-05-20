package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.MedicineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "mssc-asu-medicine")
public interface MedicineServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.MEDICINE_BY_ID_PATH)
    ResponseEntity<MedicineDto> getById(@PathVariable UUID id);

}