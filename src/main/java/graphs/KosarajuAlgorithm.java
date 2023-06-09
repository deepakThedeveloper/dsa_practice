package graphs;

// used to find strongly connected components in graph.
// strongly connnected components exists in directed graph only. In undirected graph connected components exists
// strongly connected components are those where from every vertices you can reach every vertices, consider
// this as a cycle in a graph.
//todo: will implement when will study graph.
public class KosarajuAlgorithm {
    public static void main(String[] args) {
        /**
         * Steps:
         * 1. apply DFS in directed graph and visit all the nodes based on their edges direction and as you are visiting
         * every node mark them visited.
         * once you reach a vertice from where you can't go, do backtracking but while doing backtracking add that node
         * in a stack.
         *
         * 2. create a new graph with edges in reverse direction of original graph. e.g.: A --> B (original),
         * B-->A(reverse)
         *
         * 3. Pop first element from the stack which will be your node, and traverse all its connected components in
         * newly created graph. while traversing keep popping elements from stack. Once you reach the node start point
         * then add 1 to counter. Like this continue for all the nodes in stack until stack is empty.
         *
         * Final value of counter will be total strongly connected components in graph
         */
    }
}
