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
public class RecommendationList implements Serializable {

    static final long serialVersionUID = 9062065051034140215L;

    public ArrayList<RecommendationDto> recommendationList;
}
