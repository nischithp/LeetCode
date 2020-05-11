import java.util.Arrays;
public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 24;
		int ans = subtractProductAndSum(num);
		
		
		System.out.println("Output: "+ans);
//		printArray(ans, ans.length);
	}
	
	
	// 1295. Find Numbers with Even Number of Digits  ||  Solution Performance: Time: 91.94%  Memory: 100%

    public int findNumbers(int[] nums) {
        int countInside = 0, countOutside=0; 
        for (int i=0; i<nums.length;i++){
            countInside = 0;
            int num = nums[i]; 
            while(num > 0){
                num = num/10;
                countInside++;
            }
            if(countInside %2 == 0){
                countOutside ++;
            }            
        }
        return countOutside;
    }
	
	// 1313. Decompress Run-Length Encoded List ||  Solution Performance: Time: 95.49%  Memory: 100%

    public static int[] decompressRLElist(int[] nums) {
        int[] decomArray = new int[10000]; 
        int currAI = 0;
        for(int i=0; i<nums.length; i=i+2){
            int times = nums[i], number = nums[i+1],  newAI;
            newAI = currAI + times;
            for(int j = currAI; j< newAI; j++){
                decomArray[j] = number;  
            }
            currAI = newAI;
        }
    int[] nums2 = Arrays.copyOf(decomArray,currAI);
    return nums2;
    }
	
	// 1281. Subtract the Product and Sum of Digits of an Integer ||  Solution Performance: Time: 100% Memory: 100%

    public static int subtractProductAndSum(int n) {
        // int[] newAr = new int[100];
        int i=0, prod = 1, sum = 0, digit;
        if (n == 0)
            return 0;
        while(n > 0){
            digit = n%10;
            prod = prod * digit;
            sum+=digit;
            n=n/10;
        }
        return (prod-sum);
    }
	
	
	// 1365. How Many Numbers Are Smaller Than the Current Number  ||  Solution Performance: Time: 49.84% Memory: 100%
	
    public static int[] smallerNumbersThanCurrent(int[] nums) { 
        int count=0; 
        int[] newArray = new int[10000];
        for (int i=0; i<nums.length;i++){
            int curr = nums[i];
            for(int j=0;j<nums.length;j++){
                if(nums[j] < curr){
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


	public static void printArray(int a[], int n)
	{
		int n1 = a.length;
		System.out.print(" | ");
		for (int i=1; i<n1; ++i)
			System.out.print(a[i] + " | ");
		System.out.println();
	}

}
