package enemies;

import base.BaseAtributes;

public class Zombie extends BaseAtributes {

	private String name;
	private static final double DEFAULT_LIFE_POINTS = 120;
	private static final double DEFAULT_STAMINA = 20;
	private static final double DEFAULT_ATTACK_SPEED = 5;
	private static final double DEFAULT_HIT_DAMAGE = 40;

	private static final double[] args = { DEFAULT_LIFE_POINTS, DEFAULT_STAMINA, DEFAULT_ATTACK_SPEED,
			DEFAULT_HIT_DAMAGE };

	public Zombie() {
		super(args);
	}

	public Zombie(String name) {
		super(args);
		this.name = name;
	}
}
