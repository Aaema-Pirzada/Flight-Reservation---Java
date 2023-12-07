import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;  // Import the File class
import java.io.IOException; 
/**
	Plane ADT stores seat reservation info in 2D arrays, and has methods for making and cancelling reservations.
*/


public class Plane
{
	
	
	
	//instance variable/fields
	private Passenger[][] firstClassSeats;
	private Passenger[][] economyClassSeats;
	

	/**
		Constructor for Plane object. Initializes the 2D arrays storing First Class and Economy Class reseveration.
	*/
	Plane()
	{
		firstClassSeats = new Passenger[2][4]; 
		economyClassSeats = new Passenger[20][6];	
		String flightname; 
	}
	
	/**
		Method to add an individual passenger.
		@param name this is the name of the passenger to be added.
		@param serviceClass the service class for which the reservation is to be made.
		@param seatPref seat preference: W(indow), C(enter), or A(isle).
		@return true if available seat matching seat preference or if given service class is full.  
	*/
	public boolean addPassenger(String name, String serviceClass, String seatPref)
	{
		int rowNum=0, colNum=0;
	
		boolean seatFound=false;
		
		if(serviceClass.equals("Economy"))
		{
			if(this.econClassSeatCount()==0)
			{
				System.out.println("Economy class is full. Seat not reserved. Try other service class or another flight.");
				return true;
			}		
		
			if (seatPref.equals("W"))
				{
				
					System.out.println("User entered W for preference");
						
					outerloop:
					for(rowNum=0;rowNum<economyClassSeats.length;rowNum++)
					{
						for(colNum=0;colNum<=5;colNum+=5)
						{
							if(economyClassSeats[rowNum][colNum]==null)
							{
								//Seat found.
								
								economyClassSeats[rowNum][colNum] = new Passenger(name,"I","n/a,indv");
								
								System.out.println("Reservation made for "+name+" at seat: "+(rowNum+10)+column2Letter(colNum));
								
								seatFound = true;
								
								break outerloop;
								//break;
							}
							//if(seatFound==true){break;}
						}
					}
					
						//if(seatFound==true){break;
				}
			else if (seatPref.equals("A"))
				{
					System.out.println("User entered A for preference");
					outerloop:
					for(rowNum=0;rowNum<economyClassSeats.length;rowNum++)
					{
						for(colNum=2;colNum<=3;colNum++)
						{
							if(economyClassSeats[rowNum][colNum]==null)
							{
								//Seat found.
								
								economyClassSeats[rowNum][colNum] = new Passenger(name,"I","n/a,indv");
								
								System.out.println("Reservation made for "+name+" at seat: "+(rowNum+10)+column2Letter(colNum));
								
								seatFound = true;
								break outerloop;
								//break;
							}
							//if(seatFound==true){break;}
						}
					}
					//if(seatFound==true){break;}
				}		
			else if (seatPref.equals("C"))
				{
					System.out.println("User entered C for preference");
					outerloop:
					for(rowNum=0;rowNum<economyClassSeats.length;rowNum++)
					{
						for(colNum=1;colNum<=4;colNum+=3)
						{
							if(economyClassSeats[rowNum][colNum]==null)
							{
								//Seat found.
								
								economyClassSeats[rowNum][colNum] = new Passenger(name,"I","n/a,indv");
								
								System.out.println("Reservation made for "+name+" at seat: "+(rowNum+10)+column2Letter(colNum));
								
								seatFound = true;
								break outerloop;
								//break;
							}
						}
						//if(seatFound==true){break;}
					}
					//if(seatFound==true){break;}
				}
			else
				{
					System.out.println("Invalid seat preference selection.");
				}
		}
		else if(serviceClass.equals("First"))
		{
			if(this.firstClassSeatCount()==0)
			{
				System.out.println("First class is full. Seat not reserved. Try other service class or another flight.");
				return true;
			}
			
			
			if (seatPref.equals("W"))
				{
					System.out.println("User entered W for preference");
					outerloop:
					for(rowNum=0;rowNum<firstClassSeats.length;rowNum++)
					{
						for(colNum=0;colNum<=3;colNum+=3)
						{
							if(firstClassSeats[rowNum][colNum]==null)
							{
								//Seat found.
								
								firstClassSeats[rowNum][colNum] = new Passenger(name,"I","n/a,indv");
								System.out.println("Reservation made for "+name+" at seat: "+(rowNum+1)+column2Letter(colNum));
								seatFound = true;
								break outerloop;
								//break;
							}
						}
						//if(seatFound==true){break;}
					}
				}
			else if (seatPref.equals("A"))
				{
					System.out.println("User entered A for preference");
					outerloop:
					for(rowNum=0;rowNum<firstClassSeats.length;rowNum++)
					{
						for(colNum=1;colNum<=2;colNum++)
						{
							if(firstClassSeats[rowNum][colNum]==null)
							{
								//Seat found.
								
								firstClassSeats[rowNum][colNum] = new Passenger(name,"I","n/a,indv");
								System.out.println("Reservation made for "+name+" at seat: "+(rowNum+1)+column2Letter(colNum));
								seatFound = true;
								break outerloop;
								//break;
							}
						}
						//if(seatFound==true){break;}
					}
					//if(seatFound==true){break;}
				}
			else
				{
					System.out.println("Invalid seat preference selection.");
				}
					
		}
		else
		{
			System.out.println("Invalid service class selection.");
		}
		
		
		return seatFound;
		
	}
	
	/**
		Method for adding a group of passengers.
		@param groupName name of the group to be seated.
		@param allNames list of names of all members in the group. Names MUST be seperated by comma follow by space ", ".
		@param serviceClass the service class (Economy/First) where the group is to be seated.
	*/
	public void addGroup(String groupName,String allNames,String serviceClass)
	{
			//System.out.println("Group Name:"+groupName);
			//System.out.println("Names: "+allNames); //correctly store entire line
			//System.out.println("Service Class: "+serviceClass);
			
		String[] arr;
		String delimeter =", ";
		arr = allNames.split(delimeter);
		int groupSize = arr.length;
		
		ArrayList<Passenger> sList = new ArrayList<>(); 
		
		
		for(int i=0;i<arr.length;i++)
		{
				sList.add(new Passenger(arr[i],"G",groupName));
		}
		
	
		//System.out.println(sList.remove(0)); //works/behaves as expected.
		//System.out.println("number of passengers added to arrayList:" +sList.size());
		//added all passengers stored in array arr to ArrayList. Confirmed. Size Matches.
		//System.out.println("Number of members in group equals:"+arr.length);
		// System.out.println("List of group members:");
		// for(int i=0; i<arr.length;i++){
			// System.out.println(arr[i]);
		// }
		
		if(serviceClass.equalsIgnoreCase("Economy"))
		{
			if(groupSize>this.econClassSeatCount())
			{
				System.out.println("Available seat left is less than group size. Group reservation not made.");
				return;
			}
			
			//algorithm to seat members of the group.
			//count the number of available adjacent seat in each row
						
				int counter = 0;
				
				//Tracking info for the largest cluster of adjacent seats

				//this loop is for finding row that can accomodate whole group.
				if(groupSize<=6)
				{
					outerloop:
					for(int i=0;i<20;i++)
					{
						counter=0;
						for(int j=0;j<6;j++)
						{
							if(economyClassSeats[i][j]!=null)
							{counter=0;}
							else
							{
								counter++;
								if(counter==groupSize)
								{
									// MaxClustSize=counter;
									// MaxClustRow=i;
									// MaxClustColEnd=j;
									System.out.println("Following reservations made for the group:");
									
									int startIdx =j-counter+1;
									int endIdx = startIdx+groupSize-1;
									
									for(int k=startIdx;k<=endIdx;k++)
									{
										economyClassSeats[i][k]=sList.remove(0);
										System.out.println((i+10)+column2Letter(k)+", "+economyClassSeats[i][k].getName());
									}
									break outerloop;
									
									
								}
							}
						}	
					}
				}
				else //now we iteratively find the row with the largest empty cluster
				{
					
					while(sList.size()!=0){//test this in your other code.
					
						int MaxClustSize=0; //size of the cluster
						int MaxClustRow=0; //row of the cluster
						int MaxClustCol=0; //index of first element in cluster.	
						
						for(int i=0;i<20;i++)
						{
							counter =0;
							for(int j=0;j<6;j++)
							{
								if(economyClassSeats[i][j]!=null)
								{counter=0;}
								else
								{
									counter++;
									if(counter>MaxClustSize)
									{
										MaxClustSize=counter;
										MaxClustRow = i;
										MaxClustCol = j-counter+1; //index of first element in cluster.
									}
								}
							}		
						}
						
						//System.out.println("the largest empty cluser is size:" +MaxClustSize+", it starts at:");
						//System.out.print("row="+MaxClustRow+", ");
						//System.out.println("col="+MaxClustCol);
						System.out.println("Following reservations made for the group:");
						
						
						int endIdx = MaxClustCol+MaxClustSize-1;
						if(MaxClustSize>sList.size()){endIdx=MaxClustCol+sList.size()-1;}
						
						for(int k=MaxClustCol;k<=endIdx;k++)
						{
							economyClassSeats[MaxClustRow][k]=sList.remove(0);
							System.out.println((MaxClustRow+10)+column2Letter(k)+", "+economyClassSeats[MaxClustRow][k].getName());
						}
						
						System.out.println("sList.size()="+sList.size());
						
					
					}
				}
		
			
		}
		
		
		//now do the same for first class case
		if(serviceClass.equalsIgnoreCase("First"))
		{
			if(groupSize>this.firstClassSeatCount())
			{
				System.out.println("Available seat left is less than group size.");
				return;
			}
			
			//algorithm to seat members of the group.
			
			//count the number of available adjacent seat in each row
			
				int counter = 0;
				
				//Tracking info for the largest cluster of adjacent seats

				
				
				//this loop is for finding row that can accomodate whole group.
				if(groupSize<=4)
				{
					outerloop:
					for(int i=0;i<2;i++)
					{
						counter=0;
						for(int j=0;j<4;j++)
						{
							if(firstClassSeats[i][j]!=null)
							{counter=0;}
							else
							{
								counter++;
								if(counter==groupSize)
								{
									// MaxClustSize=counter;
									// MaxClustRow=i;
									// MaxClustColEnd=j;
									System.out.println("Following reservations made for the group:");
									
									int startIdx =j-counter+1;
									int endIdx = startIdx+groupSize-1;
									
									for(int k=startIdx;k<=endIdx;k++)
									{
										firstClassSeats[i][k]=sList.remove(0);
										System.out.println((i+1)+column2Letter(k)+", "+firstClassSeats[i][k].getName());
									}
									break outerloop;
									
									
								}
							}
						}	
					}
				}
				else //now we iteratively find the row with the largest empty cluster
				{
					
					while(sList.size()!=0){ //test this in your other code.
					
						int MaxClustSize=0; //size of the cluster
						int MaxClustRow=0; //row of the cluster
						int MaxClustCol=0; //index of first element in cluster.	
						
						for(int i=0;i<2;i++)
						{
							counter =0;
							for(int j=0;j<4;j++)
							{
								if(firstClassSeats[i][j]!=null)
								{counter=0;}
								else
								{
									counter++;
									if(counter>MaxClustSize)
									{
										MaxClustSize=counter;
										MaxClustRow = i;
										MaxClustCol = j-counter+1; //index of first element in cluster.
									}
								}
							}		
						}
						
						//System.out.println("the largest empty cluser is size:" +MaxClustSize+", it starts at:");
						//System.out.print("row="+MaxClustRow+", ");
						//System.out.println("col="+MaxClustCol);
						
						
						int endIdx = MaxClustCol+MaxClustSize-1;
						if(MaxClustSize>sList.size()){endIdx=MaxClustCol+sList.size()-1;}
						
						System.out.println("Following reservations made for the group:");
						
						for(int k=MaxClustCol;k<=endIdx;k++)
						{
							firstClassSeats[MaxClustRow][k]=sList.remove(0);
							System.out.println((MaxClustRow+1)+column2Letter(k)+", "+firstClassSeats[MaxClustRow][k].getName());
						}
						
						System.out.println("sList.size()="+sList.size());
						
					}
					
				}
			
		}		
			
	}
	
	/**
	Method to cancel reservations.
	@param type the type ([I]ndividual or [G]roup) the cancellation is for. 
	@param name this is the passenger name for individual cancellation, or group name for group cancellation.
	*/
	public void cancelReservations(String type, String name)
	{
		if(type.equals("I"))
		{
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(economyClassSeats[i][j]==null)
						{/*do nothing. Seat is empty already.*/}
					else if(economyClassSeats[i][j].getName().equalsIgnoreCase(name))
						{economyClassSeats[i][j]=null;System.out.println("Reservation Cancelled");}
					else
						{/*do nothing. Not a matching name.*/}
				}
			}
			
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(firstClassSeats[i][j]==null)
						{/*do nothing. Seat is empty already.*/}
					else if(firstClassSeats[i][j].getName().equalsIgnoreCase(name))
						{firstClassSeats[i][j]=null;System.out.println("Reservation Cancelled");}
					else
						{/*do nothing. Not a matching name.*/}
				}
			}
		}
		else if(type.equals("G"))
		{
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(economyClassSeats[i][j]==null)
						{/*do nothing. Seat is empty already.*/}
					else if(economyClassSeats[i][j].getGroup().equalsIgnoreCase(name))
						{economyClassSeats[i][j]=null;}
					else
						{/*do nothing. Not a matching name.*/}
				}
			}
			
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(firstClassSeats[i][j]==null)
						{/*do nothing. Seat is empty already.*/}
					else if(firstClassSeats[i][j].getGroup().equalsIgnoreCase(name))
						{firstClassSeats[i][j]=null;}
					else
						{/*do nothing. Not a matching name.*/}
				}
			}			
			System.out.println("Reservations Cancelled");
		
		}
		else
		{
			System.out.println("Invalid type entered. Please enter I or G.");
		}
		
	}
	
	/**
	Print the Seating Availability Chart
	@param serviceClass the service class for which the seating availability chart is desired.
	*/
	public void printSeatAvailChart(String serviceClass)
	{
		if(serviceClass.equalsIgnoreCase("First"))
		{			
			System.out.println("First Class Seat Availability Chart: \n");
			
				for(int i=0;i<2;i++)
				{
					System.out.printf("row: %3d |",(i+1));
					for(int j=0;j<4;j++)
					{
						if(firstClassSeats[i][j]==null)
						{
							System.out.print(" [EMPTY]");
							System.out.printf(",%2d",(i+1));
							System.out.print(column2Letter(j)+" ");
						}
						else
						{
							//System.out.printf(" %8s ",firstClassSeats[i][j].name);
							System.out.print(" [RESERVED]  ");
						}
					}
					System.out.println();
				}
		}
		else if(serviceClass.equalsIgnoreCase("Economy"))
		{	
			System.out.println();
			System.out.println("Economy Class Seat Availability Chart: \n");
		
				for(int i=0;i<20;i++)
				{
					System.out.printf("row: %3d |",(i+10));
					for(int j=0;j<6;j++)
					{
						if(economyClassSeats[i][j]==null)
						{
							System.out.print(" [EMPTY]");
							System.out.printf(",%2d",(i+10));
							System.out.print(column2Letter(j)+" ");
						}
						else
						{
							//System.out.printf(" %8s ",economyClassSeats[i][j].name);
							System.out.print(" [RESERVED]  ");
						}					
					}
					System.out.println();
				}	
		}
		else
		{
			System.out.println("Invalid service class selection entered.");
		}
	}
	
	/**
	Prints the flight manifest.
	@param serviceClass the service class for which the manifest is desired.
	*/
	public void printManifest(String serviceClass)
	{
		if(serviceClass.equalsIgnoreCase("First"))
		{
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(firstClassSeats[i][j]!=null)
					{
						System.out.print(firstClassSeats[i][j].getName()+", ");
						System.out.print((i+1)+column2Letter(j)+"\n");
					}
				}
			}
		}
		else if(serviceClass.equalsIgnoreCase("Economy"))
		{
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(economyClassSeats[i][j]!=null)
					{
						System.out.print(economyClassSeats[i][j].getName()+", ");
						System.out.print((i+10)+column2Letter(j)+"\n");
					}
				}
			}
		}
		else
		{
			System.out.println("Invalid service class entered.");
		}
		
		
	}
	
	/**
	Writes existing reservation data to file and save befofore exit for the [Q]uit option in main menu.
	@param flightName flight number as entered in command line argument (no extension).
	*/
	public void saveData2File(String flightName) throws FileNotFoundException
	{
		PrintWriter outputStream = new PrintWriter(new FileOutputStream(flightName+".txt"));
		
		outputStream.println("First 1-2, Left: A-B, Right: C-D; Economy 10-29, Left: A-C, Right: D-F");
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(firstClassSeats[i][j]!=null)
				{
					Passenger temp = firstClassSeats[i][j];
					
					outputStream.print((i+1)); //row number as 1-2 (starting at 1)
					outputStream.print(column2Letter(j)+", "); //seat letter A,B,C,D
					outputStream.print(temp.getType()+", "); //type, I or G.
					if(temp.getType().equalsIgnoreCase("G"))  //group name, if applicabl
						{outputStream.print(temp.getGroup()+", ");}
					outputStream.print(temp.getName());
					outputStream.println();
				}					
			}
		}
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<6;j++)
			{
				if(economyClassSeats[i][j]!=null)
				{
					Passenger temp = economyClassSeats[i][j];
					
					outputStream.print((i+10)); //row number as 1-2 (starting at 1)
					outputStream.print(column2Letter(j)+", "); //seat letter A,B,C,D
					outputStream.print(temp.getType()+", "); //type, I or G.
					if(temp.getType().equalsIgnoreCase("G"))  //group name, if applicabl
						{outputStream.print(temp.getGroup()+", ");}
					outputStream.print(temp.getName());
					outputStream.println();
				}
			}
		}
		
		outputStream.close();
		
	}
	
	
	/**
	Helping method used to conver a seat designation letter to a column index (starting at 0)
	@param s2 the seat designation letter (A,B,C,D,etc) to be converted to a column index.
	*/
	public static int letter2Column(String s2)
	{
				int colNumber=0;
				
				if(s2.equals("A")){colNumber=0;}
				else if(s2.equals("B")){colNumber=1;}
				else if(s2.equals("C")){colNumber=2;}
				else if(s2.equals("D")){colNumber=3;}
				else if(s2.equals("E")){colNumber=4;}
				else if(s2.equals("F")){colNumber=5;}
				else{System.out.println("Invalid seat designation letter, cannot convert to column index.");}	
				
				return colNumber;
	}
	
	/**
	Helping method used to convert a column index (starting at 0) to a seat designation letter.
	@param c the column index to be converted to a seat designation letter (A,B,C,D,etc).
	*/
	public static String column2Letter(int c)
	{
		String sdl=" ";
		if(c==0){sdl="A";}
		else if(c==1){sdl="B";}
		else if(c==2){sdl="C";}
		else if(c==3){sdl="D";}
		else if(c==4){sdl="E";}
		else if(c==5){sdl="F";}
		else{System.out.println("Invalid column number, cannot convert to seat designation letter.");}
		
		return sdl;
	}
	
	/**
	Output the number of avaialble seats in Economy Class. For checking if there's enough seat available for reservation.
	*/
	public int econClassSeatCount()
	{
		int count=0;
		for(int i=0; i<20;i++)
		{
			for(int j=0;j<6;j++){
				if(economyClassSeats[i][j]==null){count++;}
				
			}
		}
		return count;
	}
	
	/**
	Output number of available seats in First Class. For checking if there's enough seat available for reservation.
	*/
	public int firstClassSeatCount()
	{
		int count=0;
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<4;j++){
				if(firstClassSeats[i][j]==null){count++;}
			}
		}
		return count;
	}
	

	/**
	Helping method used to add a passenger to the data structure when importing information from existing file.
	@param prevPass Passenger object of the previous passenger from file to be added to data structure.
	@param rowN row number to which the passenger is to be added in the 2D array (indexing convention is that of .txt file imported).
	@param colN col number to which the passenger is to be added in the 2D array (indexing starts at 0 for row A, 1 for row B, etc).
	*/
	public void addFromFile(Passenger prevPass,int rowN, int colN)
	{
		if(rowN>1)
		{
			this.economyClassSeats[rowN-9][colN]=prevPass;	
		}
		else if(rowN<=1)
		{
			this.firstClassSeats[rowN][colN]=prevPass;
		}
		else
		{
			System.out.println("invalide row number");
		}
		
	}
	
		
}