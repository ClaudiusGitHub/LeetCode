package DiDi;

import java.util.Scanner;

/**
 * 求第k大数，用最小堆排序，先插入K个数，然后以最小堆排序
 * 后面比较每个值与堆顶值大小，如果大于堆顶值，那么更新堆顶，然后adjust
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int index = in.nextInt();
        String[] strs = s.split(" ");
        compute(strs, index);
    }

    public static void compute(String[] strs, int index) {
        int length = strs.length;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int[] heap = new int[index];
        for (int i = 0; i < index; i++) {
            heap[i] = nums[i];
        }
        adjustUp(heap);

        for (int i = index; i < length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                adjust(heap, 0);
            }
        }
        System.out.println(heap[0]);
    }


    public static void adjustUp(int[] heap) {
        int length = heap.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(heap, i);
        }
    }

    /**
     * 从父节点开始adjust
     *
     * @param heap
     * @param fatherIndex
     */
    public static void adjust(int[] heap, int fatherIndex) {
        int length = heap.length;
        while (true) {
            int sonIndex = fatherIndex * 2 + 1;
            if (sonIndex >= length)
                break;
            if (sonIndex < length - 1 && heap[sonIndex] > heap[sonIndex + 1]) {
                sonIndex = sonIndex + 1;
            }
            if (heap[fatherIndex] > heap[sonIndex]) {
                int temp = heap[sonIndex];
                heap[sonIndex] = heap[fatherIndex];
                heap[fatherIndex] = temp;
                fatherIndex = sonIndex;
            } else {
                break;
            }
        }
    }
}
