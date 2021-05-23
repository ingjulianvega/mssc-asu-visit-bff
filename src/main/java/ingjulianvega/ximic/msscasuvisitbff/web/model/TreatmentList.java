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
public class TreatmentList implements Serializable {

    static final long serialVersionUID = -3719448499559364843L;

    public ArrayList<TreatmentDto> treatmentList;
}
