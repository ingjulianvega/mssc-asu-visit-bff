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
public class TreatmentDto implements Serializable {

    static final long serialVersionUID = -1782737991594654483L;

    private UUID id;
    private UUID visitId;
    private UUID medicineId;
    private int concentrationQuantity;
    private UUID concentrationId;
    private UUID administrationMethodId;
    private int durationQuantity;
    private UUID durationId;
    private String observations;

}
