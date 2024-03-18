/**
* <Creates an list that stores instances of the car class and has methods to help sort and add/delete  >
*
* CSC 1351 Programming Project No <1>

* Section <2>
*
* @author <Harris Reinhardt>
* @since <3/17/24>
* */





import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class aOrderedList {
	final int SIZEINCREMENTS = 20;
	private Comparable[] oList;
	private int listSize;
	private int numObjects;
	private int curr;
	
	
	public aOrderedList() {
		numObjects = 0;
		listSize = SIZEINCREMENTS;
		oList = new Car[listSize];
	}
	
	
	
	/**
	* <Adds a car object to the oList>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	public void add(Comparable newObject) {
		if (numObjects >= listSize) {
            listSize += SIZEINCREMENTS;
            oList = Arrays.copyOf(oList, listSize);
        }
        if (newObject == null) {
            oList[numObjects] = newObject; 
        } else {
            int index = numObjects;
            
            while (index > 0 && (oList[index - 1] == null || oList[index - 1].compareTo(newObject) > 0)) {
                oList[index] = oList[index - 1];
                index--;
            }
            oList[index] = newObject;
        }
        numObjects++;
	}
	/**
	* <sorts the cars in the list based on comparable interface >
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	public void sortCars() {
		for(int i = 0 ; i < oList.length-1; i++) {
			for(int j = i+1; j < oList.length; j++ ) {
				if(oList[i].compareTo(oList[j]) > 1) {
					Comparable temp = oList[i];
					oList[i] = oList[j];
					oList[j]= temp;
				}
			}
		}
	}
	
	/**
	* <resets the current index>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	public void reset() {
		curr = 0;
	}
	
	/**
	* <gets the next object in the list>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	
	public Comparable next(){
		 if (hasNext()) {
		        curr++;
		        return oList[curr];
		    } else {
		        throw new NoSuchElementException("No more available objects.");
		    }
	}
	
	/**
	* <checks to see if there is another object in the list>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public boolean hasNext() {
		if(curr < numObjects-1) {
			return true;
		}return false;
	}
	
	/**
	* <removes the last element returned based on the current index >
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	public void remove() {
		if (curr >=0 )
		remove(curr);
	}
	
	/**
	* <Gets the size of the list>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public int size() {
		return numObjects;
	}
	
	
	/**
	* <gets the object at the specified index>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public Comparable get(int index) {
		return oList[index];
	}
	
	
	
	/**
	* <checks if the list is empty>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	
	public boolean isEmpty() {
		if(numObjects < 1) {
			return true;
		}
		return false;
	}
	
	
	/**
	* <removes the object at the specified index>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public void remove(int oldCar) {
		if(oldCar >= 0 && oldCar < numObjects ) {
			for(int i = oldCar; i < numObjects-1; i++) {
				oList[i]= oList[i+1];
			}
			oList[numObjects-1] = null;
			numObjects --;
		}
	}
	
	
	/**
	* <puts the object into string form>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public String toString() {
		if (oList.length > 0) {
			for(int i = 0; i < oList.length-1; i++) {
				return "[" + oList[i].toString() + "]";
			}
		}return "[]";
	}
	
	
	
	
	
	
}
