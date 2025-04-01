package enemies;

import base.BaseAtributes;

public class Skeleton extends BaseAtributes {

	private String name;
	private static final double DEFAULT_LIFE_POINTS = 60;
	private static final double DEFAULT_STAMINA = 20;
	private static final double DEFAULT_ATTACK_SPEED = 10;
	private static final double DEFAULT_HIT_DAMAGE = 20;

	private static final double[] args = { DEFAULT_LIFE_POINTS, DEFAULT_STAMINA, DEFAULT_ATTACK_SPEED,
			DEFAULT_HIT_DAMAGE };

	public Skeleton() {
		super(args);
	}

	public Skeleton(String name) {
		super(args);
		this.name = name;
	}
}
