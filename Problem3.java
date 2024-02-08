
package LabExam;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
 
public class Problem3
{
    private int          distances[];//store the distance of the node's
    private Set<Integer> settled;//set the information of the node
    private Set<Integer> unsettled;//unsetelled set of the node
    private int          number_of_nodes;//number of nodes
    private int          adjacencyMatrix[][];//matrix as graoh
 
    private static int m;//must visited
    
    public Problem3(int number_of_nodes)
    {
        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];//memory allocated
    }
 
    public void dijkstra_algorithm(int adjacency_matrix[][], int source)
    {
        int evaluationNode;
        for (int i = 1; i <= number_of_nodes; i++)
            
            for (int j = 1; j <= number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
 
        for (int i = 1; i <= number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;//declare the ditance as infinity
        }
 
        unsettled.add(source);//set the source as 0
        distances[source] = 0;//distance of the source is 0
        while (!unsettled.isEmpty())//while we not visited all the vertices
        {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();//get the minimum weighted node
            unsettled.remove(evaluationNode);//remove it form the set
            settled.add(evaluationNode);//add it into the visited set
            evaluateNeighbours(evaluationNode);//explore all the neighbour of the source
        }
    }
 //this function the min vertex
    private int getNodeWithMinimumDistanceFromUnsettled()
    {
        int min;
        int node = 0;
 //iterated the unsetelld set
        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];//store the first node as primary
        
         for (int i = 1; i <= distances.length; i++)
        {
            if (unsettled.contains(i))//if it contains in the set
            {
                if (distances[i] <= min)//if it is less than the primary
                {
                    min = distances[i];//change the value of min
                    node = i;//set the index
                }
            }
        }
        return node;//finally set the index
    }
 
    private void evaluateNeighbours(int evaluationNode)
    {
        int edgeDistance = -1;//set the bth distance as -1
        int newDistance = -1;
 
        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
        {
            if (!settled.contains(destinationNode))
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)//check if has path or not
                {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                        
                 //using distra algorthom here       
                         {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);//set it as unsetteld
                }
            }
        }
    }
 
    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.println("Enter the number of vertices");
            number_of_vertices = scan.nextInt();
            adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
 
            System.out.println("Enter the Weighted Matrix for the graph");
            for (int i = 1; i <= number_of_vertices; i++)
            {
                for (int j = 1; j <= number_of_vertices; j++)
                {
                    adjacency_matrix[i][j] = scan.nextInt();
                        
           if (i == j)
                    {
                        adjacency_matrix[i][j] = 0;
                        continue;
                    }
                    if (adjacency_matrix[i][j] == 0)
                    {
                        adjacency_matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
 
            System.out.println("Enter the source ");
            source = scan.nextInt();
 
            System.out.println("Enter the destination ");
            destination = scan.nextInt();
 
            System.out.println("enter the node: ");
            
            m=scan.nextInt();
            
            System.out.println("enter the another node: ");
            
            int y=scan.nextInt();
            
            adjacency_matrix[m][y]+=20;
            
            System.out.println("after that the matrix is: ");
            
            for(int i=1;i<=number_of_vertices;i++){
                
                for(int j=1;j<=number_of_vertices;j++){
                    
                    System.out.print(adjacency_matrix[i][j]+"    ");
                    
                }
                
                System.out.println();
                
            }
            
            Problem3 dijkstrasAlgorithm = new Problem3(
                    number_of_vertices);
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
 
            System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
            {
                if (i == destination)
                    System.out.println(source + " to " + i + " is "
                            
            + dijkstrasAlgorithm.distances[i]);
            }
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
}                 
        
            
/*4 4
1 2 24
1 4 20
3 1 3
4 3 12
1*/

/*6 8
1 2 2
1 3 4
2 4 7
2 3 1
3 5 3
5 4 2
5 6 5
4 6 1
1*/

/*5 8
1 2 -1
1 3 4
2 3 3
2 4 2
2 5 2
4 3 5
4 2 1
5 4 -3
1*/