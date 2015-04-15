package oleogin.simulation;

import robocode.control.events.BattleAdaptor;
import robocode.control.events.BattleCompletedEvent;

/**
 * Created by user50 on 09.04.2015.
 */
public class BattleResult extends BattleAdaptor{

    private BattleCompletedEvent event;

    @Override
    public void onBattleCompleted(BattleCompletedEvent event) {
        this.event = event;
    }
}
