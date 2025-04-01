package enemies;

import base.BaseAtributes;

public class Weeper extends BaseAtributes {

	private String name;
	private static final double DEFAULT_LIFE_POINTS = 500;
	private static final double DEFAULT_STAMINA = 20;
	private static final double DEFAULT_ATTACK_SPEED = 2;
	private static final double DEFAULT_HIT_DAMAGE = 70;

	private static final double[] args = { DEFAULT_LIFE_POINTS, DEFAULT_STAMINA, DEFAULT_ATTACK_SPEED,
			DEFAULT_HIT_DAMAGE };

	public Weeper() {
		super(args);
	}

	public Weeper(String name) {
		super(args);
		this.name = name;
	}
}
