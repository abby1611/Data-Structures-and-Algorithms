class Solution
{
    public int findMaximumUtil(int arr[], int low, int high)
    {

        /case1- Only one element is present in arr[low..high]*/
        if (low == high) 
        return arr[low];

        /* If there are two elements and first is greater then
            the first element is maximum */
        if ((high == low + 1) && arr[low] >= arr[high])
        return arr[low];

        /* If there are two elements and second is greater then
            the second element is maximum */
        if ((high == low + 1) && arr[low] < arr[high]) return arr[high];

        int mid = (low + high) / 2; /*low + (high - low)/2;*/

        /* If we reach a point where arr[mid] is greater than both of
            its adjacent elements arr[mid-1] and arr[mid+1], then arr[mid]
            is the maximum element*/
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return arr[mid];

        /* If arr[mid] is greater than the next
            element and smaller than the previous
            element then maximum lies on left side of mid */
        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
            return findMaximumUtil(arr, low, mid - 1);

        // when arr[mid] is greater than arr[mid-1]
        // and smaller than arr[mid+1]
        else
            return findMaximumUtil(arr, mid + 1, high);
    }
    public int findMaximum(int arr[], int n)
    {
        return findMaximumUtil(arr, 0, n - 1);
    }
}
