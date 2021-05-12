package ingjulianvega.ximic.events;

import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateVisitEvent {
    private Visit visit;

}
