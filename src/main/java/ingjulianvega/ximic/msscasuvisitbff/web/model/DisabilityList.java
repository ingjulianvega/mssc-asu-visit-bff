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
public class DisabilityList implements Serializable {

    static final long serialVersionUID = 5746396784595787828L;

    public ArrayList<DisabilityDto> disabilityDtoList;
}
