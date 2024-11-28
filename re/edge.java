import java.util.*;
import java.io.*;
 
class Edge implements Comparable<Edge> {
    public final int fromNode;
    public final int toNode;
 
    // Private constructor to enforce the use of the factory method
    private Edge(int fromNode, int toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
    }
 
    // Factory method to create an instance of Edge
    public static Edge createEdge(int fromNode, int toNode) {
        return new Edge(fromNode, toNode);
    }
 
    // Override equals method to compare Edge objects based on their attributes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check if both references are to the same object
        if (o == null || getClass() != o.getClass()) return false; // Check for null and class type
        Edge edge = (Edge) o;
        return fromNode == edge.fromNode && toNode == edge.toNode; // Compare attribute values
    }
 
    // Override hashCode method to generate a hash code based on attributes
    @Override
    public int hashCode() {
        return Objects.hash(fromNode, toNode); // Use Java's Objects class for hash code generation
    }
 
    // Override toString method for string representation
    @Override
    public String toString() {
        return "From node: " + fromNode + " To node: " + toNode;
    }
 
    // Implement compareTo method for natural ordering based on fromNode and toNode
    @Override
    public int compareTo(Edge edge) {
        int compareFromNode = Integer.compare(this.fromNode, edge.fromNode);
        if (compareFromNode != 0) {
            return compareFromNode; // First compare by fromNode
        }
        return Integer.compare(this.toNode, edge.toNode); // Then compare by toNode if fromNode is equal
    }
}
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 
        String arr[];
        int numberOfQueries = Integer.parseInt(br.readLine().trim());
 
        StringBuilder sb = new StringBuilder();
 
        HashSet<Edge> set = new HashSet<>();
 
        for (int i = 1; i <= numberOfQueries; i++) {
            arr = br.readLine().trim().split(" ");
            int u = Integer.parseInt(arr[0]),
                v = Integer.parseInt(arr[1]);
            Edge edge = Edge.createEdge(u, v);
            if (set.contains(edge)) {
                continue; // Skip if edge already exists
            }
            set.add(edge); // Add unique edge to the set
            sb.append(edge.toString()).append("\n"); // Append the edge's string representation to the output
        }
 
        out.println(set.size()); // Print the number of unique edges
        out.print(sb); // Print the edges themselves
        out.flush();
        out.close();
    }
}