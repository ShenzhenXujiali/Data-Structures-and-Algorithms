# Quicksort Algorithm Implementation in Java

## **1. Overview**

In this tutorial, we’ll explore the QuickSort algorithm in detail, focusing on its Java implementation.

We’ll also discuss its advantages and disadvantages and then analyze its time complexity.





## **2. QuickSort Algorithm**

**[Quicksort](https://www.baeldung.com/cs/the-quicksort-algorithm) is a sorting algorithm, which is leveraging the [divide-and-conquer principle](https://www.baeldung.com/cs/divide-and-conquer-strategy).** It has an average *O(n log n)* complexity and it’s one of the most used sorting algorithms, especially for big data volumes.

**It’s important to remember that Quicksort isn’t a stable algorithm.** A stable sorting algorithm is an algorithm where the elements with the same values appear in the same order in the sorted output as they appear in the input list.

（这句话的意思是：**快速排序不是一个稳定的排序算法。** 稳定的排序算法指的是在排序过程中能够保持具有相同值的元素在排序后的序列中保持它们在原始输入序列中的相对顺序不变。换句话说，如果有两个相等的元素 A 和 B，而在未排序的输入中 A 出现在 B 之前，那么在稳定排序算法处理后 A 依然会出现在 B 之前。

快速排序之所以被认为是不稳定的，是因为在排序过程中可能会改变相等元素的原始相对顺序。   

The input list is divided into two sub-lists by an element called pivot; one sub-list with elements less than the pivot and another one with elements greater than the pivot. This process repeats for each sub-list.

Finally, all sorted sub-lists merge to form the final output.



### **2.1. Algorithm Steps**

1. We choose an element from the list, called the pivot. We’ll use it to divide the list into two sub-lists.
2. We reorder all the elements around the pivot – the ones with smaller value are placed before it, and all the elements greater than the pivot after it. After this step, the pivot is in its final position. **This is the important partition step.**
3. We apply the above steps recursively to both sub-lists on the left and right of the pivot.

As we can see, **quicksort is naturally a recursive algorithm, like every divide and conquer approach.**





### **2.2. Choosing the Optimal Pivot**

The crucial point in QuickSort is to choose the best pivot. The middle element is, of course, the best, as it would divide the list into two equal sub-lists.

But finding the middle element from an unordered list is difficult and time-consuming, that is why we take as pivot the first element, the last element, the median or any other random element.



## **3. Implementation in Java**

The first method is *quickSort()* which takes as parameters the array to be sorted, the first and the last index. First, we check the indices and continue only if there are still elements to be sorted.

We get the index of the sorted pivot and use it to recursively call *partition()* method with the same parameters as the *quickSort()* method, but with different indices:



```java
public void quickSort(int arr[], int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);

        quickSort(arr, begin, partitionIndex-1);
        quickSort(arr, partitionIndex+1, end);
    }
}
```



Let’s continue with the *partition()* method. For simplicity, this function takes the last element as the pivot. Then, checks each element and swaps it before the pivot if its value is smaller.

By the end of the partitioning, all elements less then the pivot are on the left of it and all elements greater then the pivot are on the right of it. The pivot is at its final sorted position and the function returns this position:







```java
private int partition(int arr[], int begin, int end) {
    int pivot = arr[end];
    int i = (begin-1);

    for (int j = begin; j < end; j++) {
        if (arr[j] <= pivot) {
            i++;

            int swapTemp = arr[i];
            arr[i] = arr[j];
            arr[j] = swapTemp;
        }
    }

    int swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;

    return i+1;
}
```







## **4. Algorithm Analysis**

### **4.1. Time Complexity**

In the best case, the algorithm will divide the list into two equal size sub-lists. So, the first iteration of the full *n*-sized list needs *O(n)*. Sorting the remaining two sub-lists with *n/2* elements takes *2\*O(n/2)* each. As a result, the QuickSort algorithm has the complexity of *O(n log n)*.

In the worst case, the algorithm will select only one element in each iteration, so *O(n) + O(n-1) + … + O(1)*, which is equal to *O(n2)*.

On the average QuickSort has *O(n log n)* complexity, making it suitable for big data volumes.

### **4.2. QuickSort vs MergeSort**

Let’s discuss in which cases we should choose QuickSort over MergeSort.

Although both Quicksort and Mergesort have an average time complexity of *O(n log n)*, Quicksort is the preferred algorithm, as it has an *O(log(n))* [space complexity](https://www.baeldung.com/cs/space-complexity). Mergesort, on the other hand, requires *O(n)* extra storage, which makes it quite expensive for arrays.

Quicksort requires to access different indices for its operations, but this access is not directly possible in linked lists, as there are no continuous blocks; therefore to access an element we have to iterate through each node from the beginning of the linked list. Also, Mergesort is implemented without extra space for *LinkedLists.*

In such case, overhead increases for Quicksort and Mergesort is generally preferred.

## **5. Conclusion**

Quicksort is an elegant sorting algorithm that is very useful in most cases.

**It’s generally an “in-place” algorithm, with the average time complexity of \*O(n log n).\***

Another interesting point to mention is that Java’s *Arrays.sort()* method uses Quicksort for sorting arrays of primitives. The implementation uses two pivots and performs much better than our simple solution, that is why for production code it’s usually better to use library methods.

As always, the code for the implementation of this algorithm can be found over [on our GitHub repository](https://github.com/eugenp/tutorials/tree/master/algorithms-modules/algorithms-sorting).