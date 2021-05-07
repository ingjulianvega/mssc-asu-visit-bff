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
public class DisabilityDto implements Serializable {

    static final long serialVersionUID = -1824191913057064269L;

    private UUID id;
    private UUID visitId;
    private UUID disabilityTypeId;
    private int durationQuantity;
    private UUID durationId;
    private String observations;

}
