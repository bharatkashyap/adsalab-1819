import java.util.*;

class Heapsort {
  public static void buildMaxHeap(int[] arr) {
    int n = arr.length;
    for(int i=n/2-1; i>=0; i--) { // Starting from last non-leaf node, as leaf nodes already satisfy max-heap property of child nodes being smaller than parent node
      maxHeapify(arr, i, n);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void maxHeapify(int[] arr, int root, int heapSize) {
    int left = 2*root+1;
    int right = 2*root+2;
    int largest = root;

    if(left<heapSize && arr[left]>arr[largest])
      largest = left;
    if(right<heapSize  && arr[right]>arr[largest])
      largest = right;

    if(largest != root) {
      swap(arr, largest, root);
      maxHeapify(arr, largest, heapSize);
    }
  }

  public static void heapSort(int[] arr) {
    int heapSize = arr.length;

    buildMaxHeap(arr);
    for(int i=heapSize-1; i>=0; i--) {
      swap(arr, 0, i);
      heapSize = heapSize - 1;
      maxHeapify(arr, 0, heapSize);
    }
  }

public static void print(int[] arr) {
  for(int i=0; i<arr.length; i++) {
    System.out.print(arr[i] + " ");
  }
  System.out.print("\n");
}

  public static void main(String[] args) {
    int[] arr = {10,9,6,7,3,4,2,2,1};
    print(arr);
    heapSort(arr);
    print(arr);
  }
}
