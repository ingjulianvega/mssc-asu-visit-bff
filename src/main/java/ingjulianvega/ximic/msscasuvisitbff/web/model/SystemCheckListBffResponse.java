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
public class SystemCheckListBffResponse implements Serializable {

    static final long serialVersionUID = -212416712970952218L;

    public ArrayList<SystemCheckBffResponse> systemCheckList;
}
