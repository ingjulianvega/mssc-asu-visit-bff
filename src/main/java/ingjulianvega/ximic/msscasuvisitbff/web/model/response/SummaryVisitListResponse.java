package ingjulianvega.ximic.msscasuvisitbff.web.model.response;

import ingjulianvega.ximic.msscasuvisitbff.web.model.response.DetailedVisitResponse;
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
public class SummaryVisitListResponse implements Serializable {

    static final long serialVersionUID = 6840731619737550145L;

    public ArrayList<SummaryVisitResponse> detailedVisitResponseList;
}
