package ingjulianvega.ximic.msscasuvisitbff.events;

import ingjulianvega.ximic.msscasuvisitbff.web.model.DisabilityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDisabilityEvent implements Serializable {
    static final long serialVersionUID = -2303605203336833465L;

    private DisabilityDto disabilityDto;

}
