package labs.prob8;


/**
 * @author KidusMT
 * Date: 4/11/2021
 * StdID: 612361
 */
public  class Trader{
	
	private String name;
	private String city;

	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}

	public String getName(){
		return this.name;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String newCity){
		this.city = newCity;
	}

	public String toString(){
		return "labs.prob8.Trader:"+this.name + " in " + this.city;
	}
}