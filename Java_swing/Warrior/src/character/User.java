package character;

import base.BaseAtributes;

public class User extends BaseAtributes {

	private String name;
	private static final double DEFAULT_LIFE_POINTS = 100;
	private static final double DEFAULT_STAMINA = 20;
	private static final double DEFAULT_ATTACK_SPEED = 20;
	private static final double DEFAULT_HIT_DAMAGE = 15;

	private static final double[] args = { DEFAULT_LIFE_POINTS, DEFAULT_STAMINA, DEFAULT_ATTACK_SPEED,
			DEFAULT_HIT_DAMAGE };

	public User(String name) {
		super(args);
		this.name = name;
	}

}
