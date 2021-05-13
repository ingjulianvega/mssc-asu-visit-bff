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
public class UpdateVisitEvent implements Serializable {

    static final long serialVersionUID = -1876109010441802189L;

    private UUID id;
    private UUID patientId;
    private UUID companionId;
    private UUID visitTypeId;
    private UUID billingId;
    private String reason;
    private int height;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private int weight;
    private int heartRate;
    private float temperature;
    private UUID diseaseId;
    private String observations;

}
