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
public class BodyCheckListBffResponse implements Serializable {

    static final long serialVersionUID = -8207983944467339770L;

    public ArrayList<BodyCheckDtoBffResponse> bodyCheckList;
}
