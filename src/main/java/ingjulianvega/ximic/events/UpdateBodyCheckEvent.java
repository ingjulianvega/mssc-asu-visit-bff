package ingjulianvega.ximic.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBodyCheckEvent implements Serializable {
    static final long serialVersionUID = -3434643162985140175L;

    private UUID visitId;
    private UUID bodyPartId;
    private String observations;

}
