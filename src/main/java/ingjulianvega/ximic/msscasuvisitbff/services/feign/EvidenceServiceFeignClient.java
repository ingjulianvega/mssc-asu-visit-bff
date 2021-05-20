package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.EvidenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "mssc-asu-evidence")
public interface EvidenceServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.EVIDENCE_BY_ID_PATH)
    ResponseEntity<EvidenceDto> getById(@PathVariable UUID id);

}