package wazeApp;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.Hashtable;
//import java.util.List;


public class DataLoader
{
    
 
     //public List<Node> nodeList = new ArrayList<>();
     public Hashtable<String, Node> nodeList = new Hashtable<String, Node> ();
     Node findNode(String name)
    {

    	 return nodeList.get(name);
    }

   void read_node(String filename){
	   try{
		    FileInputStream fstream = new FileInputStream(filename);
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    while ((strLine = br.readLine()) != null){
		    	String[] tokens = strLine.split(" ");
		    	Node node = new Node();
		    	node.name = tokens[0];
		    	node.x = Double.parseDouble(tokens[1]);
		    	node.y = Double.parseDouble(tokens[2]);
		    	nodeList.put(node.name,node);
	    	}	
		    in.close();
   			}catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }
	 }
   
   void read_edge(String filename){
	   System.out.println("Begin reading edge file...");
	   try{
		    FileInputStream fstream = new FileInputStream(filename);
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    while ((strLine = br.readLine()) != null){
		    	String[] tokens = strLine.split(" ");
		    	Edge edge = new Edge();
		    	edge.name = tokens[0];
		    	System.out.println(edge.name);
		        edge.start = findNode(tokens[1]);
		        edge.end = findNode(tokens[2]);
		        edge.len = Double.parseDouble(tokens[3]);
		        edge.start.out_list.add(edge);
		        System.out.println("start point is: " + edge.start.name);
		        
		        
		    	
	    	}	
		    in.close();
  			}catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }
	   
	   try{
		    FileInputStream fstream = new FileInputStream(filename);
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    while ((strLine = br.readLine()) != null){
		    	String[] tokens = strLine.split(" ");
		    	Edge edge = new Edge();
		    	edge.name = tokens[0];
		    	System.out.println(edge.name);
		        edge.start = findNode(tokens[2]);
		        edge.end = findNode(tokens[1]);
		        edge.len = Double.parseDouble(tokens[3]);
		        edge.start.out_list.add(edge);
		        System.out.println("start point is: " + edge.start.name);
		        
		        
		    	
	    	}	
		    in.close();
 			}catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }
   }
   
   
   
   public Hashtable<String,Node> load_data(String nodefile, String edgefile){
	   
	   read_node(nodefile);
	   read_edge(edgefile);
	   return nodeList;
	   
	   
   }
}
	

