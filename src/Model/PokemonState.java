package Model;


public class PokemonState {
	
	/*
	 * Object class for creating every pokemon playable in the game
	 * 
	 * getting and setting the data towards a pokemon.
	 * this will be used for every party pokemon
	 * in particular this should help control how moves affect the pokemon
	 * */
	private int id, level, xp, xpMax, hp, hpMax, attack, defense, PP[], PPMax[];
	private boolean poison, frozen, paralysed, confused, burned, sleeping;
	private String pokemon, name, type, moves [], frontPic, backPic;
	private PokemonState pkmn;
	
	public PokemonState(int id, String pokemon, String name, int level, String type, 
			int xp, int xpMax, int hp, int hpMax, int attack, int defense,
			String move1, String move2, String move3, 
			String move4, int move1PPMax, int move2PPMax, int move3PPMax,
			int move4PPMax, int move1PP, int move2PP, int move3PP, int move4PP, 
			boolean poison, boolean frozen, boolean paralysed, boolean confused, boolean burned,
			boolean sleeping, String frontPic, String backPic)
	{
		this.id = id;
		this.pokemon = pokemon;
		this.name = name;
		this.level = level;
		this.type = type;
		this.xp = xp;
		this.xpMax = xpMax;
		this.hp = hp;
		this.hpMax = hpMax;
		this.attack = attack;
		this.defense = defense;
		String[] moves1 = {move1, move2, move3, move4};
		moves = moves1.clone();
		int[] pp1 = {move1PP, move2PP, move3PP, move4PP};
		PP = pp1.clone();
		int[] ppm1 = {move1PPMax, move2PPMax, move3PPMax, move4PPMax};
		PPMax = ppm1.clone();
		this.poison = poison;
		this.frozen = frozen;
		this.paralysed = paralysed;
		this.confused = confused;
		this.burned = sleeping;
		this.sleeping = sleeping;
		this.frontPic = frontPic;
		this.backPic = backPic;
	}
	
	public String toString()
	{
		String x = id + " " + pokemon + " " + name + " " + level + " " + type + " " + 
		xp + " " + xpMax + " " + hp + " " + hpMax + " " + attack + " " + defense + " " + moves[0] + " " + moves[1] + " " + moves[2] + " " + 
		moves[3] + " " + PPMax[0] + " " + PPMax[1] + " " + PPMax[2] + " " +
		PPMax[3] + " " + PP[0] + " " + PP[1] + " " + PP[2] + " " + PP[3] + " " + 
		poison + " " + frozen + " " + paralysed + " " + confused + " " + burned + " " +
		sleeping + " " + frontPic + " " + backPic;
		
		return x;
	}
	public PokemonState clone(PokemonState x) {
	    this.pkmn = x.pkmn; // you can access 
	    return pkmn;
	  }
	public String getMove(int x)
	{
		return moves[x];
	}
	
	public void setMove(int x, String y)
	{
		moves[x] = y;
	}
	public int getMovePP(int x)
	{
		return PP[x];
	}
	
	public void setMovePP(int x, int y)
	{
		PP[x] = y;
	}
	public void decrementMovePP(int x)
	{
		PP[x] = PP[x] -1;
	}
	public int getMovePPMax(int x)
	{
		return PPMax[x];
	}
	
	public void setMovePPMax(int x, int y)
	{
		PPMax[x] = y;
	}
	public int getId()
	{
		return id;
	}
	public String getPokemon()
	{
		return pokemon;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String x)
	{
		name = x;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int newLevel)
	{
		level = newLevel;
	}
	public int getXP()
	{
		return xp;
	}
	public void addXP(int experience)
	{
		xp = xp + experience;
	}
	public String getType()
	{
		return type;
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public void setHP(int x)
	{
		hp = x;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public void setAttack(int x)
	{
		attack = x;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public void setDefence(int x)
	{
		defense = x;
	}
	
	public boolean getPoison()
	{
		return poison;
	}
	
	public void setPoison(boolean x)
	{
		poison = x;
	}
	public boolean getFrozen()
	{
		return frozen;
	}
	
	public void setFrozen(boolean x)
	{
		frozen = x;
	}
	public boolean getParalysed()
	{
		return paralysed;
	}
	
	public void setParalysed(boolean x)
	{
		paralysed = x;
	}
	public boolean getConfused()
	{
		return confused;
	}
	
	public void setConfused(boolean x)
	{
		confused = x;
	}
	public boolean getBurned()
	{
		return burned;
	}
	
	public void setBurned(boolean x)
	{
		burned = x;
	}
	public boolean getSleeping()
	{
		return sleeping;
	}
	
	public void setSleeping(boolean x)
	{
		sleeping = x;
	}
	public int getHPTotal() {
		return hpMax;
	}
	public void setHPTotal(int x) {
		hpMax = x;
	}
	public int getXPTotal() {
		return xpMax;
	}
	public void setXPTotal(int x) {
		xpMax = x;
	}
	
	public String getFrontPic()
	{
		return frontPic;
	}
	public String getBackPic()
	{
		return backPic;
	}
}
