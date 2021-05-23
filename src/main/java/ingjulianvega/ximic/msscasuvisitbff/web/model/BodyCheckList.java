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
public class BodyCheckList implements Serializable {

    static final long serialVersionUID = -1974022327701653015L;

    public ArrayList<BodyCheckDto> bodyCheckList;
}
