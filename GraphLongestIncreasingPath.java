class Solution {
    
    
    //use method of dfs and cache stratagy
    public int longestIncreasingPath(int[][] matrix) {
        int row=matrix.length;
        int column = matrix[0].length;
        int[][] result = new int[row][column];
        int re=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int len=dfs(matrix,i,j,result);
                if(len>re){
                    re=len;
                }
            }
        }
        return re;
        
        
        
        
        
    }
    int[] rDiffer={0,1,-1,0};
    int[] cDiffer={1,0,0,-1};
    
    int dfs(int[][] matrix,int r,int c,int[][] result){
        if(result[r][c]>0){
            return result[r][c];
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int re=1;
        for(int i=0;i<4;i++){
            int rNeibor=r+rDiffer[i];
            int cNeibor=c+cDiffer[i];
            if(rNeibor<0||rNeibor>=m||cNeibor<0||cNeibor>=n || matrix[rNeibor][cNeibor]<=matrix[r][c]){
                continue;
            }
            int val=0;
            if(result[r][c]>0){
                val= result[rNeibor][cNeibor];
            }else{
                val=dfs(matrix,rNeibor,cNeibor,result);
            }

            if((1+val) > re){
                re=1+val;
            }
        }
        //cache
        result[r][c]=re;
        return result[r][c];
        
    }
    
   
}
