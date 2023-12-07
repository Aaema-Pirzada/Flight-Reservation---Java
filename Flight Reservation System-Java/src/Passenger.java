import java.util.Scanner;

/**
	Passenger ADT contains information for each passenger.
*/
public class Passenger
{
	//Instance variables/fields.
	private String type; //G for group; I for individual.
	private String groupName = null; //group name (n/a for individual passengers).
	private String name = null;
	
	
	/**
		Constructor for Passenger.
		@param newName the name of the new passenger created
		@param newType the type Individual (I) or Group (G) of the passenger
		@param newGroup	the groupName of the new passenger (leave as null if individual passenger)
	*/
	public Passenger(String newName, String newType, String gName)
	{
		this.name = newName;
		this.type = newType;
		this.groupName = gName;
	}
	
	
	/**
		Get the name of the passenger (accessor).
		@return name of the passenger.
	*/
	public String getName()
	{
		return name;
	}
	
	
	/**
		Get the group name of the group the passenger belongs to, as applicable.
		@return the group name of the group the passenger belongs to.
	*/
	public String getGroup()
	{
		return groupName;
	}
	
	/**
		Get the type - [I]ndividual or [G]roup for the passenger.
		@return the type [I]ndividual or [G]roup the passenger falls under.
	*/
	public String getType()
	{
		return type;
	}

	/**
		Mutator method for setting the name of a passenger.
		@param name name of the passenger.
	*/
	public void setName(String name)
	{
		this.name= name;
	}
	
	/**
		Mutator method for setting the group name of a passenger belonging to a group.
		@param name group name of for which the passenger belongs to.
	*/
	public void setGroup(String name)
	{
		this.groupName = name;
	}
	
	/**
		Mutator method for setting the type - [I]ndividual or [G]roup for the passenger.
		@param type type - [I]ndividual or [G]roup the passenger's reservation falls under.
	*/
	public void setType(String type)
	{
		this.type = type;
	}
	
}