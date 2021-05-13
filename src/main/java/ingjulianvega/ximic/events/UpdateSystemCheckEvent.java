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
public class UpdateSystemCheckEvent implements Serializable {
    static final long serialVersionUID = -665180147118242193L;

    private UUID visitId;
    private UUID systemId;
    private UUID symptomId;
    private UUID intensityId;
    private String observations;

}
