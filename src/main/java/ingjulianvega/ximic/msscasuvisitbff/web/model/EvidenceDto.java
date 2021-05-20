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
public class EvidenceDto implements Serializable {

    static final long serialVersionUID = 6106754316483309657L;

    private UUID id;
    private UUID patientId;
    private UUID evidenceTypeId;
    private UUID diseaseId;
    private String observations;

}
