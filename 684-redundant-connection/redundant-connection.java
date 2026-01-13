class Solution {
    public int find(int n, int[] parent){
        if(parent[n]==n)return parent[n];
        return parent[n]=find(parent[n],parent);
    }
    public void union(int a, int b, int[] parent){
        int parentA = find(a,parent);
        int parentB = find(b,parent);
        if(parentA==parentB)return;
        else if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            System.out.println(Arrays.toString(parent));
            if(find(a,parent)==find(b,parent)){
                return edge;
            }
            union(a,b,parent);
        }
        return new int[]{};
    }
}