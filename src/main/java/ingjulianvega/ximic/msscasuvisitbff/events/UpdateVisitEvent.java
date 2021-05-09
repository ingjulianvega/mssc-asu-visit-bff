package ingjulianvega.ximic.msscasuvisitbff.events;

import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateVisitEvent implements Serializable {
    static final long serialVersionUID = 8721756290445221053L;

    private Visit visit;

}
