  package wazeApp;

import java.util.Stack;

class Path{
	Stack<Node> pathnode = new Stack<Node>();
	double cost = 0;

Node getLastNode(){
		if (!pathnode.isEmpty()){
			return pathnode.peek();
		}
		return null;
		
	}
	
}
