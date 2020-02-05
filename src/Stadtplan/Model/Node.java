package Stadtplan.Model;
/*
* Node class.
* Steet sections are spanned between two nodes.
 */
public class Node {

	private int[] position = new int[2];
	
	public Node(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public int[] getCoordinates() {
		return this.position;
	}

	public int getX() {
		return position[0];
	}

	public void setX(int x) {
		position[0] = x;
	}

	public int getY() {
		return position[1];
	}

	public void setY(int y) {
		position[1] = y;
	}
}

