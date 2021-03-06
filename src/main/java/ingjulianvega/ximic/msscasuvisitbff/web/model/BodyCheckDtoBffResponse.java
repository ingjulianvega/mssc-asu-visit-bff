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
public class BodyCheckDtoBffResponse implements Serializable {

    static final long serialVersionUID = -7238205791641982838L;

    private UUID visitId;
    private BodyPartDto bodyPart;
    private String observations;

}
