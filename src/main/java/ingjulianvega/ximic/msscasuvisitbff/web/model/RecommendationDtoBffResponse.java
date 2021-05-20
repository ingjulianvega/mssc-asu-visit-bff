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
public class RecommendationDtoBffResponse implements Serializable {

    static final long serialVersionUID = -1206408701269368568L;

    private UUID id;
    private UUID visitId;
    private RecommendationTypeDto recommendationType;
    private String observations;

}
