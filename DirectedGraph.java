package _0_DataStructures.Graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DirectedGraph {  // Directed Graph

    // 'graphNodeList' is an array of ALL EDGE MAPS FOR EACH NODE
    // 'graphNodeList' is composed of edgeMaps
    public ArrayList<GraphNode> graphNodeList = new ArrayList<>();

    public int nodeCount;

    public int edgeCount;


    public class GraphNode {

        public int number;
        public LinkedHashMap<GraphNode, ArrayList<Integer>> connections;
        public ArrayList<Integer> connectionsKeyList;


        public GraphNode(){
            this.connections = new LinkedHashMap<>();
            this.connectionsKeyList = new ArrayList<>();

        }




        public void addEdge(GraphNode target, int dist, int isSource){

            if (target.number < graphNodeList.size() && target.number != this.number && !this.connections.containsKey(target)){

                ArrayList<Integer> connectionSpecs = new ArrayList<>();
                connectionSpecs.add(dist);
                connectionSpecs.add(isSource);

                this.connections.put(target, connectionSpecs);
                this.connectionsKeyList.add(target.number);

                if (isSource == 1){
                    edgeCount ++;
                    target.addEdge(this, dist, 0);
                }
            }
        }




    }



    public void printGraph() {

        for (GraphNode node : this.graphNodeList) {
            System.out.print("Node " + node.number + ": ");
            for (GraphNode key : node.connections.keySet()) {
                System.out.print(key.number + "=" + node.connections.get(key) + "; ");
            }
            System.out.println();

        }
        System.out.println();
    }



    public GraphNode addGraphNode(){
        GraphNode newGraphNode = new GraphNode();
        newGraphNode.number = nodeCount;
        this.graphNodeList.add(newGraphNode);
        this.nodeCount++;
        return newGraphNode;
    }






}
