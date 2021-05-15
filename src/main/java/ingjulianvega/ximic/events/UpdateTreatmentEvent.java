package ingjulianvega.ximic.events;

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
public class UpdateTreatmentEvent implements Serializable {
    static final long serialVersionUID = -1779685999030701343L;

    private UUID visitId;
    private UUID medicineId;
    private int concentrationQuantity;
    private UUID administrationMethodId;
    private int durationQuantity;
    private UUID durationId;
    private String observations;

}
