package Leetcode.Java_code;

import java.util.Arrays;

public class sort {
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //冒泡
    public void bubble_up(int[] arr){
        boolean flag;
        for(int i = 0; i < arr.length; i++){
            flag = false;
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }
    public void bubble_up(int[] arr, int start, int end){
        if(start > end){
            quickprint.println("ERROR:start should be less than end!");
            return;
        }
        boolean flag;
        for(int i = start; i < end; i++){
            flag = false;
            for(int j = end - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }
    public void bubble_down(int[] arr){
        boolean flag;
        for(int i = 0; i < arr.length; i++){
            flag = false;
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] > arr[j - 1]){
                    swap(arr, j, j - 1);
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }
    public void bubble_down(int[] arr, int start, int end){
        if(start > end){
            quickprint.println("ERROR:start should be less than end!");
            return;
        }
        boolean flag;
        for(int i = start; i < end; i++){
            flag = false;
            for(int j = end - 1; j > i; j--){
                if(arr[j] > arr[j - 1]){
                    swap(arr, j, j - 1);
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }
    //插入排序
    public void insert_up(int[] arr) {
        //将a[]按升序排列
        for (int i = 1; i < arr.length; i++) {
            //将a[i]插入到a[i-1]，a[i-2]，a[i-3]……之中
            for(int j = i; j > 0 && (arr[j] < arr[j - 1]); j--){
                swap(arr, j, j - 1);
            }
        }
    }
    public void insert_down(int[] arr) {
        //将a[]按降序排列
        for (int i = 1; i < arr.length; i++) {
            //将a[i]插入到a[i-1]，a[i-2]，a[i-3]……之中
            for(int j = i; j > 0 && (arr[j] > arr[j - 1]); j--){
                swap(arr, j, j - 1);
            }
        }
    }
    //快速排序
    public void quicksort_up(int[] arr, int start, int end){
        int low = start, high = end;
        if(low < high){
            while(low < high){
                while (low < high){
                    while (arr[low] <= arr[start] && low < end)
                        low++;//满足小于基准的条件，指针右移
                    while (arr[high] >= arr[start] && high > start)
                        high--;//满足大于基准的条件，指针左移
                    if (low < high)
                        swap(arr, start, high);//交换两个不满足条件的元素
                    else
                        break;
                }
                swap(arr, start, high);//插入基准元素
                quicksort_up(arr, start, high - 1);
                quicksort_up(arr, high + 1, end);
            }
        }
    }


    public static void main(String[] args){
        int[] arr = new int[]{11,9,5,6,8,7};
        new sort().quicksort_up(arr, 0, arr.length - 1);
        quickprint.println(Arrays.toString(arr));
    }
}
