package ingjulianvega.ximic.msscasuvisitbff.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisabilityDtoBffResponse implements Serializable {

    static final long serialVersionUID = 1922248729335176544L;

    private UUID id;
    private UUID visitId;
    private DisabilityTypeDtoBffResponse disabilityType;
    private int durationQuantity;
    private DurationDtoBffResponse duration;
    private String observations;

}
