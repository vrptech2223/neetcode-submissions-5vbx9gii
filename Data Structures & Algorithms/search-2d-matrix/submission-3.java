class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       int row=0;
       for(int i=0;i<matrix.length;i++)
       {
          if(target >= matrix[i][0]  && matrix[i][matrix[i].length-1] >= target)
          {
            row = i ;
          }
       }

        int l=0;
        int r=matrix[row].length - 1;
        while(l <= r )
        {
            int mid = (l + r) / 2;
            int found = matrix[row][mid];
            if(found==target){
                return true;
            } else if (found > target )
            {
                r=mid-1;
            } else if ( found < target)
            {
                l = mid + 1;
            }


        }

        return false;
    }
}
