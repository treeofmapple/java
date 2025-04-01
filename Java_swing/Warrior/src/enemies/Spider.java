package enemies;

import base.BaseAtributes;

public class Spider extends BaseAtributes {

	private String name;
	private static final double DEFAULT_LIFE_POINTS = 25;
	private static final double DEFAULT_STAMINA = 40;
	private static final double DEFAULT_ATTACK_SPEED = 40;
	private static final double DEFAULT_HIT_DAMAGE = 4;

	private static final double[] args = { DEFAULT_LIFE_POINTS, DEFAULT_STAMINA, DEFAULT_ATTACK_SPEED,
			DEFAULT_HIT_DAMAGE };

	public Spider() {
		super(args);
	}

	public Spider(String name) {
		super(args);
		this.name = name;
	}
}
