package ingjulianvega.ximic.msscasuvisitbff.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendationListBffResponse implements Serializable {

    static final long serialVersionUID = -974055125007457605L;

    public ArrayList<RecommendationDtoBffResponse> recommendationList;
}
