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
public class UpdateRecommendationEvent implements Serializable {
    static final long serialVersionUID = -2869001350441726828L;

    private UUID visitId;
    private UUID recommendationTypeId;
    private String observations;

}
