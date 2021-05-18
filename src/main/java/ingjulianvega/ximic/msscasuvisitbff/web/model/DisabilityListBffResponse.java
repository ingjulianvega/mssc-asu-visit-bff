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
public class DisabilityListBffResponse implements Serializable {

    static final long serialVersionUID = -5548725011885178444L;

    public ArrayList<DisabilityDtoBffResponse> disabilityList;
}
