package wazeApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test {

	public static void main(String[] args) {
	    BufferedReader br = null;
	    //String[] characters = new String[21693];
	    ArrayList<String[]> edgeList = new ArrayList<String[]>();

	    try {

	        String sCurrentLine;
	        br = new BufferedReader(new FileReader("VertexEdge.txt"));
	        

	        //int i=0;
	        while ((sCurrentLine = br.readLine()) != null) {
	            String[] arr = sCurrentLine.split(" ");
	            //for the first line it'll print
	            //System.out.println("arr[0] = " + arr[0]);
	            //System.out.println("arr[1] = " + arr[1]); 
	            //System.out.println("arr[2] = " + arr[2]); 
	            //if(arr.length == 4){
	                //System.out.println("arr[3] = " + arr[3]);
	            //}

	            
	            //characters[i] = arr[0];
	            
	            // names[1] = arr[1]
	            edgeList.add(arr);
	            //i++;
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (br != null)br.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    //System.out.println(Arrays.toString(list.get(55)));
	    Vertex [] vertexList = new Vertex[21048];
	    int ii=0;
	    for (ii=0; ii<vertexList.length; ii++){
	    	vertexList[ii] = new Vertex(Integer.toString(ii));
	    }
	    ii = 0;
	    for (ii=0; ii<vertexList.length; ii++){
	    	
	    	System.out.println(Integer.toString(ii));
	    	LinkedList <Edge> edges = new LinkedList<Edge>(); 
	    	int jj = 0;
	    	for (jj=0; jj<edgeList.size(); jj++){
	    		if (edgeList.get(jj)[1].equals(Integer.toString(ii))){
	    			edges.add(new Edge(vertexList[Integer.parseInt(edgeList.get(jj)[2])], Double.parseDouble(edgeList.get(jj)[3])));
	    			//System.out.println(list.get(jj)[1] + "----" + list.get(jj)[2]);
	    			System.out.println(edgeList.get(jj)[1] + "----" + Integer.toString(ii));
	    			
	    		}
	    		//else System.out.println(list.get(jj)[1] + "----" + Integer.toString(ii));
	    	}
	    	
	    	 vertexList[ii].adjacencies = edges.toArray(new Edge[edges.size()]);
	    	//System.out.println(edges.toArray(new Edge[edges.size()])); 
	    	//Edge[] temp = edges.toArray(new Edge[edges.size()]);
	    	//vertexList[ii].adjacencies = temp;
	    	
	    }
	    
	    Dijkstra.computePaths(vertexList[1033]);
	    System.out.println("Distance to : distination is: " + vertexList[1066].minDistance);
	    List<Vertex> path = Dijkstra.getShortestPathTo(vertexList[1066]);
	    System.out.println("Path: " + path);

	}

}
