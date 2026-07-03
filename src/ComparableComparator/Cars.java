package ComparableComparator;

public class Cars{// implements Comparable<Cars> {
    int price;
    int speed;
    String color;

    public Cars(int price, int speed, String color) {
        this.price = price;
        this.speed = speed;
        this.color = color;
    }

    @Override
    public String toString() {
        return "P :" + this.price +
               " S :" + this.speed +
               " C :" + this.color;
    }

//	@Override
//	public int compareTo(Cars o) {
//		// speed (high to low)
////		return o.speed - this.speed;
//		
//		// speed (low to high)
//		//return this.speed - o.speed;
//		
//		// alphabetical order Colour based sort
////		return this.color.compareTo(o.color);
//		
//		//price (low to high)
//		return this.price - o.price;
//	}
}