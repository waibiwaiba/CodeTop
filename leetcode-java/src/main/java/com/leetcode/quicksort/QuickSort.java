import java.util.Arrays;

public class QuickSort {

    // 1. 主函数：供外部调用
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // 2. 递归的辅助函数
    private void quickSort(int[] arr, int low, int high) {
        // 递归的终止条件：当子数组只有一个或没有元素时
        if (low < high) {
            // 调用分区函数，找到基准元素的正确位置
            int pivotIndex = partition(arr, low, high);

            // 递归地对基准左边的子数组进行快速排序
            quickSort(arr, low, pivotIndex - 1);
            // 递归地对基准右边的子数组进行快速排序
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 3. 核心的分区函数
    private int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准 (Pivot)
        int pivot = arr[high];
        
        // i 是 "小于区域" 的边界指针
        int i = (low - 1); 

        // j 是遍历指针，从 low 到 high-1
        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (arr[j] < pivot) {
                i++; // 扩大 "小于区域"
                // 将当前这个较小的元素 arr[j] 换到 "小于区域" 的末尾
                swap(arr, i, j);
            }
        }

        // 遍历结束后，将基准元素换到 "小于区域" 的下一个位置 (i+1)
        // 这个位置就是基准的最终正确位置
        swap(arr, i + 1, high);
        
        // 返回基准元素的位置索引
        return (i + 1);
    }

    // 一个简单的交换函数
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ------------------- 测试代码 -------------------
    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        
        System.out.println("原始数组: " + Arrays.toString(arr));
        
        sorter.sort(arr);
        
        System.out.println("排序后数组: " + Arrays.toString(arr));
        
        // 测试另一个例子
        int[] arr2 = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("原始数组: " + Arrays.toString(arr2));
        sorter.sort(arr2);
        System.out.println("排序后数组: " + Arrays.toString(arr2));
    }
}
