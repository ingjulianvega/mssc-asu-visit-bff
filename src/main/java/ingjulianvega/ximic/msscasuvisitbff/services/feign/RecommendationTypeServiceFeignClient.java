package ingjulianvega.ximic.msscasuvisitbff.services.feign;

import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffServiceImpl;
import ingjulianvega.ximic.msscasuvisitbff.web.model.RecommendationTypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

//@FeignClient(name = "mssc-asu-recommendation-type")
@FeignClient(name = "RecommendationTypeServiceFeignClient", url = "http://localhost:8112")
public interface RecommendationTypeServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET,value = VisitBffServiceImpl.RECOMMENDATION_TYPE_BY_ID_PATH)
    ResponseEntity<RecommendationTypeDto> getById(@PathVariable UUID id);

}