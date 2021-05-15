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
public class RemissionList implements Serializable {

    static final long serialVersionUID = -3708365960319182086L;

    public ArrayList<Remission> remissionList;
}
