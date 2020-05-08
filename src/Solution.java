import java.util.Arrays;
public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int count=0; 
        int[] newArray = new int[10000];
        for (int i=0; i<nums.length;i++){
            int curr = nums[i];
            for(int j=0;j<nums.length;j++){
                if(i==j){
                    break;
                }
                else if(nums[j]<= curr){
                    count++;
                }
            }
            System.out.println("Count:"+count);
            newArray[i]= count;
            count=0;
        }
		int[] a2 = Arrays.copyOf(newArray,nums.length);
        return a2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,5};
		int[] ans = smallerNumbersThanCurrent(arr);
		System.out.println("Output: ");
		printArray(ans, ans.length);
	}
	
	public static void printArray(int a[], int n)
	{
		int n1 = a.length;
		System.out.print(" | ");
		for (int i=1; i<n1; ++i)
			System.out.print(a[i] + " | ");
		System.out.println();
	}

}
