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
public class TreatmentListBffResponse implements Serializable {

    static final long serialVersionUID = 5639428306186487040L;

    public ArrayList<TreatmentDtoBffResponse> treatmentList;
}
