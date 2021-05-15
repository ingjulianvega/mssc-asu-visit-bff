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

    static final long serialVersionUID = -8344936584836055182L;

    private UUID id;
    private UUID visitId;
    private UUID medicineId;
    private int concentrationQuantity;
    private UUID administrationMethodId;
    private int durationQuantity;
    private UUID durationId;
    private String observations;

}
