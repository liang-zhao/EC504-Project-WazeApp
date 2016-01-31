package wazeApp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
//import java.util.Collections;
//import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
import java.util.Stack;

class Algorithm
{
    
   @SuppressWarnings("unchecked")  
   		ArrayList<Path> getShortestPath(String start, String target, Hashtable<String, Node> table){
		List<Path> pathList = new ArrayList <Path>();
		Node s = table.get(start);
		Node t = table.get(target);
		int k =3; //find 3 shortest paths
		
		Path p_u = new Path(); //build a new path
		p_u.pathnode.push(s); //add start node into the path
		
		PathComparator pc = new PathComparator();
		PriorityQueue<Path> pathQ = new PriorityQueue<Path>(1000,pc);//build a priority queue
		
		pathQ.add(p_u); //add the path to the pQ
		
		while(!pathQ.isEmpty() && t.count < k){ //if the pQ is not empty and the count of target node does not reach 3
			p_u = pathQ.poll(); //poll the path with least cost out of the pQ
			Node u = p_u.getLastNode(); //find the last node of the path
			u.count++;    //increase the count
			
			if (u.name.equals(t.name)){ //if the last node of the path is the target
				pathList.add(p_u); //add this path to the array list
				System.out.println("Path added!");
				
			}
			
			else if (u.count <= k){ //else if the node count has not exceed 3
				for (Edge e : u.out_list){ // for every edge in its adjacent list
					if(!p_u.pathnode.contains(e.end)){ //if the end node of the edge has not appeared in the path
					Node v = e.end; 
					Path p_v = new Path();					
					p_v.pathnode = (Stack<Node>) p_u.pathnode.clone(); 
					p_v.pathnode.push(v); //add the node to form a new path
//					for(int i = 0; i<p_v.pathnode.size(); i++){
//						System.out.print(p_v.pathnode.get(i).name+" ");
//					}
					p_v.cost = p_u.cost + e.len; //add the length of edge into the cost of the new path
					System.out.println("cost: "+ p_v.cost + "  t.count = " + t.count + " u.count = " + u.count);
					pathQ.add(p_v); //add the path to the pQ
					
					}
				} 
			}
		}
		return (ArrayList<Path>) pathList;
   }
   
   	String getNodeName(ArrayList<Path> pathList){
   		String sss = "";
   		if(!pathList.isEmpty()){

   			for (Path p : pathList){
   				
   				String[] idList = new String [p.pathnode.size()];
   				int i = 0;
   				for(Node n : p.pathnode){
   					idList[i] = n.name;
   					i++;	
   					
   				}
   				String id = Arrays.toString(idList);
   				//System.out.println("\n cost: " + p.cost+ "   "+ id);
   				sss=sss+id+"\n";
   				
   				
   			}
   			
   			int j = 0;
   			String []costList = new String[3];
   			for(Path p : pathList){
   				costList[j] = keepTwoDecimal(p.cost);
   				j++;
   			}
   			String cost = Arrays.toString(costList);
   			sss=sss+cost;
   			System.out.println(sss);
   			return sss;	
   			
   			
   		}
		return ("No path for this route!");
   	}
   	
	
	 class PathComparator implements Comparator<Path> {

		@Override
		public int compare(Path x, Path y){ 
			
		
		if (x.cost < y.cost)
			return -1;
		if (x.cost > y.cost)
			return 1;
		return 0;
		
	}
  }
	 
	 public static String keepTwoDecimal(double d) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }
	 
	
}

