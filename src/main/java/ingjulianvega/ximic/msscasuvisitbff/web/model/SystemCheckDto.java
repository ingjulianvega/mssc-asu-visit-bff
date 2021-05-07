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
public class SystemCheckDto implements Serializable {

    static final long serialVersionUID = 8528190913714022244L;

    private UUID id;
    private UUID visitId;
    private UUID systemId;
    private UUID symptomId;
    private UUID intensityId;
    private String observations;

}
