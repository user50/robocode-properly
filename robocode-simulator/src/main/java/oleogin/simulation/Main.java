package oleogin.simulation;

import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;

import java.io.File;

/**
 * Created by user50 on 08.04.2015.
 */
public class Main {

    public static void main(String[] args) {
        RobocodeEngine engine = new RobocodeEngine(new File("d:\\programs\\robocode"));

        BattleResult battleResult = new BattleResult();
        engine.addBattleListener(battleResult);

        BattleSpecification specification = new BattleSpecification(1, new BattlefieldSpecification(800, 600), engine.getLocalRepository("sample.RamFire, samplesentry.BorderGuard"));

        engine.runBattle(specification);

        engine.waitTillBattleOver();
    }
}
