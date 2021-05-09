package ingjulianvega.ximic.msscasuvisitbff.events;

import ingjulianvega.ximic.msscasuvisitbff.web.model.RecommendationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRecommendationEvent implements Serializable {
    static final long serialVersionUID = -2725716388169029415L;

    private RecommendationDto recommendationDto;

}
