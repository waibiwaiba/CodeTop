class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<2){
            return;
        }
        int insertPos = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        for(int i=insertPos;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}

// class Solution {
//     /**
//      * 将数组中的所有 0 移动到末尾，同时保持非零元素的相对顺序。
//      * @param nums 整数数组
//      */
//     public void moveZeroes(int[] nums) {
//         // 如果数组为空或只有一个元素，无需操作
//         if (nums == null || nums.length < 2) {
//             return;
//         }

//         // `insertPos` 指针表示下一个非零元素应该被放置的位置
//         int insertPos = 0;

//         // 第一次遍历：将所有非零元素移动到数组的前面
//         for (int i = 0; i < nums.length; i++) {
//             // 如果当前元素不是 0
//             if (nums[i] != 0) {
//                 // 就把它放到 insertPos 的位置
//                 nums[insertPos] = nums[i];
//                 // 然后将 insertPos 后移一位
//                 insertPos++;
//             }
//         }

//         // 第二次遍历：将 `insertPos` 之后的所有位置填充为 0
//         // 此时，所有非零元素都已移动完毕，`insertPos` 就是第一个0应该在的位置
//         while (insertPos < nums.length) {
//             nums[insertPos] = 0;
//             insertPos++;
//         }
//     }
// }