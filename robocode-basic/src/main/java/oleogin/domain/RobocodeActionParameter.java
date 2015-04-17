package oleogin.domain;

import oleogin.BaseRobot;

/**
 * Created by user50 on 09.04.2015.
 */
public enum RobocodeActionParameter {
    rotateGun {
        @Override
        public void apply(Double value, BaseRobot baseRobot) {
            baseRobot.turnGunLeftRadians(value);
        }
    },
    rotateRadar {
        @Override
        public void apply(Double value, BaseRobot baseRobot) {
            baseRobot.turnRadarLeftRadians(value);
        }
    },
    shotPower {
        @Override
        public void apply(Double value, BaseRobot baseRobot) {
            baseRobot.fire(value);
        }
    };

    public abstract void apply(Double value, BaseRobot baseRobot);
}
