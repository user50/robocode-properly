package oleogin.domain;

import oleogin.BrainControllingRobot;

/**
 * Created by user50 on 09.04.2015.
 */
public enum RobocodeActionParameter {
    rotateGun {
        @Override
        public void apply(Double value, BrainControllingRobot brainControllingRobot) {
            brainControllingRobot.turnGunLeftRadians(value);
        }
    },
    rotateRadar {
        @Override
        public void apply(Double value, BrainControllingRobot brainControllingRobot) {
            brainControllingRobot.turnRadarLeftRadians(value);
        }
    },
    shotPower {
        @Override
        public void apply(Double value, BrainControllingRobot brainControllingRobot) {
            brainControllingRobot.fire(value);
        }
    };

    public abstract void apply(Double value, BrainControllingRobot brainControllingRobot);
}
