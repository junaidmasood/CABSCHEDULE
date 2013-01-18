package Design;

class Dijk{
	 private static long INFINITY = Long.MAX_VALUE;
	  
	    private long[] dist;
	    private int[] pred;
 
	    public long distance(int s, int d) {
	        	        return dist[d];
	    }
	 // Dijkstra's algorithm to find shortest path from s to d
	    public void dijkstra(int s, int d, long[][]dist2) {
	        int V = dist2.length;
 
	        // initialize
	        dist = new long[V];
	        pred = new int[V];
	        for (int v = 0; v < V; v++) dist[v] = INFINITY;
	        for (int v = 0; v < V; v++) pred[v] = -1;
 
	        // priority queue
	        IndexPQ pq = new IndexPQ(V);
	        for (int v = 0; v < V; v++) pq.insert(v, dist[v]);
 
	        // set distance of source
	        dist[s] = 0;
	        pred[s] = s;
	        pq.change(s, dist[s]);
 
	        // run Dijkstra's algorithm
	        while (!pq.isEmpty()) {
	            int v = pq.delMin();
	            //// System.out.println("process " + v + " " + dist[v]);
 
	            // v not reachable from s so stop
	            if (pred[v] == -1) break;
 
	            // scan through all nodes w adjacent to v
	            for(int i=0;i<V;i++) {
	                int w = i;
	                if (dist[v] +dist2[v][w] < dist[w]) {
	                    dist[w] = dist[v] + dist2[v][w];
	                    pq.change(w, dist[w]);
	                    pred[w] = v;
	                    //// System.out.println("    lower " + w + " to " + dist[w]);
	                }
	            }
	        }
	    }	    
}

class IndexPQ {
    private int N;              // number of elements on PQ
    private int[] pq;           // binary heap
    private int[] qp;           //
    private long[] priority;  // priority values
 
    public IndexPQ(int NMAX) {
        pq = new int[NMAX + 1];
        qp = new int[NMAX + 1];
        priority = new long[NMAX + 1]; 
        N = 0;
    }
 
    public boolean isEmpty() { return N == 0; }
 
    // insert element k with given priority
    public void insert(int k, long value) {
        N++;
        qp[k] = N;
        pq[N] = k;
        priority[k] = value;
        fixUp(pq, N);
    }
 
    // delete and return the minimum element
    public int delMin() { 
        exch(pq[1], pq[N]); 
        fixDown(pq, 1, --N); 
        return pq[N+1]; 
    }
 
    // change the priority of element k to specified value
    public void change(int k, long value) {
        priority[k] = value;
        fixUp(pq, qp[k]);
        fixDown(pq, qp[k], N);
    }
 
 
   /**************************************************************
    * General helper functions
    **************************************************************/
    private boolean greater(int i, int j) {
        return priority[i] > priority[j];
    }
 
    private void exch(int i, int j) {
        int t = qp[i]; qp[i] = qp[j]; qp[j] = t;
        pq[qp[i]] = i; pq[qp[j]] = j;
    }
 
 
   /**************************************************************
    * Heap helper functions
    **************************************************************/
    private void fixUp(int[] a, int k)  {
        while (k > 1 && greater(a[k/2], a[k])) {
            exch(a[k], a[k/2]);
            k = k/2;
        }
    }
 
    private void fixDown(int[] a, int k, int N) {
        int j;
        while (2*k <= N) {
            j = 2*k;
            if (j < N && greater(a[j], a[j+1])) j++;
            if (!greater(a[k], a[j])) break;
            exch(a[k], a[j]);
            k = j;
        }
    }
 
 
}