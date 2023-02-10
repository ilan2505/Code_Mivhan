package GenericComparable;
public class Shape{
	protected String color;
	public Shape(){
		this.color = "black";
	}
	public Shape( String color){
		this.color = color;
	}
	public String getColor( ) {
		return this.color;
	}
	public String toString( ) {
		return "color: "+color;
	}
	public boolean equals(Object o){
		if (o instanceof Shape){
			return this.color.equals(((Shape)o).color);
		}
		return false;
	}
}
