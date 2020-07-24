import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
	

//	1486. XOR Operation in an Array  ||  Solution Performance: Time: 100%  Memory: 100%
	    public int xorOperation(int n, int start) {
	        int[] nums = new int[n] ; 
	        int xor = n;
	        for(int i=0; i<n ; i++){
	            nums[i] = start + (2*i);
	            if (i == 0){
	                xor = nums[i];
	            }
	            else {
	                xor = xor ^ nums[i];
	            }
	        } 
	        return xor;
	    }

	
//    1480. Running Sum of 1d Array ||  Solution Performance: Time: 100%  Memory: 100%
	public int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
    
	// 1470. Shuffle the Array ||  Solution Performance: Time: 100%  Memory: 100%

    public int[] shuffle(int[] nums, int n) {
        int[] ar1 = new int[nums.length/2]; 
        int[] newAr = new int[nums.length];
        System.arraycopy(nums, n, ar1, 0, n);
        int j=1,k=0;
        for(int i =0; i<n; i++){
            newAr[k] = nums[i];
            newAr[j] = ar1[i];
            j+=2;
            k+=2;;
        }
        return newAr;
    }
	
//		1282. Group the People Given the Group Size They Belong To  ||  Solution Performance: Time: 91.94%  Memory: 100%
//	    public List<List<Integer>> groupThePeople(int[] groupSizes) {
//        
//    }
//	
	
//	1323. Maximum 69 Number 

    // public int maximum69Number (int num) {
    
//  char[] arr = String.valueOf(num).toCharArray();
//  for(int i=0; i<arr.length; i++){
//      if(arr[i] == '6'){
//          arr[i] = '9';
//          break;
//      }
//  }
 
//  return Integer.parseInt(String.valueOf(arr));
//	}




public int maximum69Number (int num) {
 char[] ans= (""+ num).toCharArray();
 for(int i=0;i<ans.length;i++){
     if (ans[i] == '6'){
         ans[i] = '9';
         break;
     }
 }
 return(Integer.parseInt(new String(ans)));   
}
	
//	1460. Make Two Arrays Equal by Reversing Sub-arrays  ||  Solution Performance: Time: 85.58%  Memory: 97.73%

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target[i]){
            }
            else{
                return false;
            }
        }
        return true;
    }
	
//	1464. Maximum Product of Two Elements in an Array||  Solution Performance: Time: 75.19%  Memory: 84.70%

	public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int firstMax = nums[nums.length-1], secondMax = nums[nums.length-2];
    return ((firstMax-1)*(secondMax-1));
    }

//	1431. Kids With the Greatest Number of Candies

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) { 
        List<Boolean> ans = new ArrayList<Boolean>();
        
		return ans;
        
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
