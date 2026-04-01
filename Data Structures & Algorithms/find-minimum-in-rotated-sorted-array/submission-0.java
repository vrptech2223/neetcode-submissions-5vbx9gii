class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid =  (right + left) / 2;

            // If mid element is greater than right,
            // minimum must be in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum is at mid or in left half
                right = mid;
            }
        }

        return nums[left];
    }
}