import java.util.Arrays;

public class MergeSort {

    // 1. 主函数：供外部调用
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    // 2. 递归的分解函数 (Divide)
    private void mergeSort(int[] arr, int left, int right) {
        // 递归的终止条件：当子数组只有一个或没有元素时
        if (left < right) {
            // 找到中间点，将数组分成两半
            // 使用 (left + right) / 2 也可以，但这种写法可以防止在left和right都很大时发生整数溢出
            int mid = left + (right - left) / 2;

            // 递归地对左半部分进行分解
            mergeSort(arr, left, mid);
            // 递归地对右半部分进行分解
            mergeSort(arr, mid + 1, right);

            // 当左右两半都已经排好序后，调用合并函数
            merge(arr, left, mid, right);
        }
    }

    // 3. 核心的合并函数 (Conquer)
    private void merge(int[] arr, int left, int mid, int right) {
        // 计算两个子数组的大小
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时的左右子数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 将原始数据拷贝到临时子数组中
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // --- 开始合并 ---
        // 初始化左右子数组的指针
        int i = 0, j = 0;
        // 初始化合并后大数组的指针
        int k = left;

        // 比较左右子数组的元素，将较小的放入原始数组
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // --- 收尾工作 ---
        // 如果左子数组还有剩余元素，将它们全部拷贝到原始数组
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // 如果右子数组还有剩余元素，将它们全部拷贝到原始数组
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // ------------------- 测试代码 -------------------
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        
        System.out.println("原始数组: " + Arrays.toString(arr));
        
        sorter.sort(arr);
        
        System.out.println("排序后数组: " + Arrays.toString(arr));
    }
}