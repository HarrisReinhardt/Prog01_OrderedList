/**
* <Car class which has attributes that describe the car >
*
* CSC 1351 Programming Project No <1>

* Section <2>
*
* @author <Harris Reinhardt>
* @since <3/17/2024>
* */
public class Car implements Comparable<Car> {
	private String make;
	private int year;
	private int price;
	
	
	public Car(String make, int year, int price) {
		this.make = make;
		this.year = year;
		this.price = price;
	}
	
	/**
	* <gets the make of the car>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public String getMake() {
		return make;
	}
	
	
	/**
	* <gets the year of the car>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	
	public int getYear() {
		return year;
	}
	
	/**
	* <gets the price of the car>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public int getPrice() {
		return price;
	}
	
	/**
	* <compares the car based on make and year if needed>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public int compareTo(Car other) {
		if(this.make.equals(other.make)) {
			return Integer.compare(this.year, other.year);
		}else {
			return this.make.compareTo(other.make);
		}
	/**
	* <outputs the array into string form to see it>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
		
		
	}
	public String toString() {
		return "Make: " + make + ", Year : " + year + ", Price: " + price + ";";
	}
	
}
