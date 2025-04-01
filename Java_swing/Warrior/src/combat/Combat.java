package combat;

import java.util.ArrayList;
import java.util.List;

import base.BaseAtributes;

public class Combat {

	private static final double ATTACK_THRESHOLD = 200;
	private List<BaseAtributes> participants = new ArrayList<>();

	public void addCombantant(BaseAtributes participant) {
		participants.add(participant);
	}
	
	public void startCombat() {
		
	}
	
	private void TakeTurn(BaseAtributes attacker, BaseAtributes target) {
		if(!target.isAlive()) {
			return;
		}
		
	}
	
}
