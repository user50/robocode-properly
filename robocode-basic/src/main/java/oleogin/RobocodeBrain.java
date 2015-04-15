package oleogin;

import oleogin.domain.RobocodeAction;
import oleogin.domain.RobocodeState;

/**
 * Created by user50 on 09.04.2015.
 */
public interface RobocodeBrain {

    public RobocodeAction askAction(RobocodeState state);

}
