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
public class RemissionListBffResponse implements Serializable {

    static final long serialVersionUID = 6320692307938266427L;

    public ArrayList<RemissionDtoBffResponse> remissionList;
}
