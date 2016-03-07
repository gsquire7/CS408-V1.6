package Model;
public class MoveEffects {
	private String name; 
	private String type; 
	private int strength; 
	private int accuracy; 
	private int pp;
	private double healthRegeneration;
	private int attackerAttack;
	private int defenderAttack;
	private int attackerDefense;
	private int defenderDefense;
	private double criticalMultiplier;
	private boolean poison;
	private boolean frozen;
	private boolean paralysed;
	private boolean confusion;
	private boolean burned;
	private boolean attackerSleep; 
	private boolean defenderSleep, sameTurn, flinch;
	private int exceptionsOdds, minTurn, maxTurn, damage;
	
	public MoveEffects(String name, String type, int strength, int accuracy, int pp,
			double healthRegeneration, int attackerAttack, int defenderAttack,
			int attackerDefense, int defenderDefense,
			double criticalMultiplier, boolean poison, boolean frozen,
			boolean paralysed, boolean confusion, boolean burned,
			boolean attackerSleep, boolean defenderSleep,
			int exceptionsOdds, int minTurn, int maxTurn,
			boolean sameTurn, boolean flinch, int damage)
	{
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.accuracy = accuracy;
		this.pp = pp;
		this.healthRegeneration = healthRegeneration;
		this.attackerAttack = attackerAttack;
		this.defenderAttack = defenderAttack;
		this.attackerDefense = attackerDefense;
		this.defenderDefense = defenderDefense;
		this.criticalMultiplier = criticalMultiplier;
		this.poison = poison;
		this.frozen = frozen;
		this.paralysed = paralysed;
		this.confusion = confusion;
		this.burned = burned;
		this.attackerSleep = attackerSleep; 
		this.defenderSleep = defenderSleep;
		this.exceptionsOdds = exceptionsOdds;
		this.minTurn = minTurn;
		this.maxTurn = maxTurn;
		this.sameTurn = sameTurn;
		this.flinch = flinch;
		this.damage = damage;
	}
	
	public String moveToString()
	{
		return name + "\t" + type + "\t" + strength + "\t" + accuracy + "\t" + pp + "\t" + healthRegeneration + "\t" + attackerAttack + "\t" + defenderAttack + "\t" + attackerDefense + "\t" + defenderDefense + "\t" + 
		 poison + "\t" + frozen + "\t" + paralysed + "\t" + confusion + "\t" + burned + "\t" + attackerSleep + "\t" + defenderSleep + "\t" + exceptionsOdds;
		
	}
	public String getName()
	{ 
		return name;
	}
	
	public String getType()
	{ 
		return type;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getAccuracy()
	{
		return accuracy;
	}
	
	public int getExceptionsOdds()
	{
		return exceptionsOdds;
	}
	public double getHealthRegeneration()
	{
		return healthRegeneration;
	}
	public int getPP()
	{
		return pp;
	}
	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getAttackerAttack() {
		return attackerAttack;
	}

	public void setAttackerAttack(int attackerAttack) {
		this.attackerAttack = attackerAttack;
	}

	public int getDefenderAttack() {
		return defenderAttack;
	}

	public void setDefenderAttack(int defenderAttack) {
		this.defenderAttack = defenderAttack;
	}

	public int getAttackerDefense() {
		return attackerDefense;
	}

	public void setAttackerDefense(int attackerDefense) {
		this.attackerDefense = attackerDefense;
	}

	public int getDefenderDefense() {
		return defenderDefense;
	}

	public void setDefenderDefense(int defenderDefense) {
		this.defenderDefense = defenderDefense;
	}
	public int getMinTurn() {
		return minTurn;
	}

	public void setminTurn(int minTurn) {
		this.minTurn = minTurn;
	}
	public int getmaxTurn() {
		return maxTurn;
	}

	public void setMaxTurn(int maxTurn) {
		this.maxTurn = maxTurn;
	}
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getCriticalMultiplier() {
		return criticalMultiplier;
	}

	public void setCriticalMultiplier(double criticalMultiplier) {
		this.criticalMultiplier = criticalMultiplier;
	}

	public boolean getPoison() {
		return poison;
	}

	public void setPoison(boolean poison) {
		this.poison = poison;
	}

	public boolean getFrozen() {
		return frozen;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	public boolean getParalysed() {
		return paralysed;
	}

	public void setParalysed(boolean paralysed) {
		this.paralysed = paralysed;
	}

	public boolean getConfusion() {
		return confusion;
	}

	public void setConfusion(boolean confusion) {
		this.confusion = confusion;
	}
	public boolean getSameTurn() {
		return sameTurn;
	}

	public void setSameTurn(boolean sameTurn) {
		this.sameTurn = sameTurn;
	}
	public boolean getFlinch() {
		return flinch;
	}

	public void setFlinch(boolean flinch) {
		this.flinch = flinch;
	}

	public boolean getBurned() {
		return burned;
	}

	public void setBurned(boolean burned) {
		this.burned = burned;
	}

	public boolean getAttackerSleep() {
		return attackerSleep;
	}

	public void setAttackerSleep(boolean attackerSleep) {
		this.attackerSleep = attackerSleep;
	}

	public boolean getDefenderSleep() {
		return defenderSleep;
	}

	public void setDefenderSleep(boolean defenderSleep) {
		this.defenderSleep = defenderSleep;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public void setHealthRegeneration(double healthRegeneration) {
		this.healthRegeneration = healthRegeneration;
	}

	public void setExceptionsOdds(int exceptionsOdds) {
		this.exceptionsOdds = exceptionsOdds;
	}
}
