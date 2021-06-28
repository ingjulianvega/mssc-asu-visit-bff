package ingjulianvega.ximic.msscasuvisitbff.web.model;

import ingjulianvega.ximic.msscasuvisitbff.web.model.response.DetailVisitByIdResponse;
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
public class VisitListBffResponse implements Serializable {

    static final long serialVersionUID = 6840731619737550145L;

    public ArrayList<DetailVisitByIdResponse> detailVisitByIdResponseList;
}
