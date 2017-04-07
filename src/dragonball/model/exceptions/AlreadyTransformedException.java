package dragonball.model.exceptions;

import dragonball.model.character.fighter.Saiyan;

public class AlreadyTransformedException extends DragonBallException {
	
	private Saiyan fighter ;

	public Saiyan getFighter() {
		return fighter;
	}
	
	public AlreadyTransformedException(Saiyan fighter)
	{
		super("Already Transformed"+fighter.getName());
		this.fighter = fighter ;
		
	}
	public AlreadyTransformedException(String message , Saiyan fighter)
	{
		super(message);
		this.fighter= fighter;
	}
	
	
	

}
