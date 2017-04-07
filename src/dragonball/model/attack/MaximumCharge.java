package dragonball.model.attack;

import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.exceptions.AlreadyTransformedException;

public class MaximumCharge extends SuperAttack {
	public MaximumCharge() {
		super("Maximum Charge", 0);
	}

	@Override
	public int getAppliedDamage(BattleOpponent attacker) {
		return 0;
	}

	@Override
	public void onUse(BattleOpponent attacker, BattleOpponent defender, boolean defenderBlocking) throws AlreadyTransformedException {
		Fighter attackerFighter = (Fighter) attacker;
		attackerFighter.setKi(attackerFighter.getKi() + 3);
	}
}
