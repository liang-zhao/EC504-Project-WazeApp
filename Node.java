package wazeApp;

import java.util.LinkedList;
import java.util.List;

class Node {
	
	double	x;
	double	y;
	List<Edge> 	out_list = new LinkedList<Edge>();	/* edges that start from this node */
	String	name;
	int count = 0;

}
