

    // Graph is represented using adjacency list. Every
// node of adjacency list contains vertex number of
// the vertex to which edge connects. It also
// contains weight of the edge
    public class AdjListNode {
        int v;
        int weight;

        AdjListNode(int _v, int _w)
        {
            v = _v;
            weight = _w;
        }
        int getV() { return v; }
        int getWeight() { return weight; }
    }



