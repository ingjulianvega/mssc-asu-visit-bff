package ingjulianvega.ximic.msscasuvisitbff.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateVisitListener {

    //private final VisitService visitService;

    //@JmsListener(destination = JmsConfig.UPDATE_VISIT_QUEUE)
    public void listen(UpdateVisitEvent event){
        log.debug("Got updateVisit " + event.toString());
        //visitService.create(event.getVisit());
    }
}
