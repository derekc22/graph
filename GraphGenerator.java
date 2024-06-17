package _0_DataStructures.Graph;
import _0_DataStructures.Graph.DirectedGraph.GraphNode;
import java.util.concurrent.ThreadLocalRandom;

public class GraphGenerator {

    DirectedGraph graph;
    int numOfNodes;
    int numOfEdges;
    int maxDist;



    public GraphGenerator(int numOfNodes, int numOfEdges, int maxDist){
        this.numOfNodes = numOfNodes;
        this.numOfEdges = numOfEdges;
        this.maxDist = maxDist;
    }


    public GraphNode genTargetNode(int originNum) {

        int targetNum;
        do { targetNum = ThreadLocalRandom.current().nextInt(0, numOfNodes);
        } while (targetNum == originNum);

        return this.graph.graphNodeList.get(targetNum);
    }


    public GraphNode genOriginNode() {

        int originNum = ThreadLocalRandom.current().nextInt(0, numOfNodes);
        return this.graph.graphNodeList.get(originNum);
    }

    public int genEdgeWeight(){
        return ThreadLocalRandom.current().nextInt(1, maxDist + 1);
    }












    public DirectedGraph genDirectedGraph(){

        DirectedGraph graph = new DirectedGraph();
        this.graph = graph;

        // This formula comes from the sum of natural numbers
        int maxNumOfEdges = ((this.numOfNodes-1) * ( (this.numOfNodes-1) + 1))/2;
        if (this.numOfEdges > maxNumOfEdges){
            this.numOfEdges = maxNumOfEdges;
        }

        while (this.graph.nodeCount < this.numOfNodes){
            graph.addGraphNode();
        }


        while (graph.edgeCount < numOfEdges){

            GraphNode originNode = genOriginNode();
            GraphNode targetNode = genTargetNode(originNode.number);
            int edgeWeight = genEdgeWeight();

            originNode.addEdge(targetNode, edgeWeight, 1);

        }



        graph.printGraph();
        return graph;

    }
}

