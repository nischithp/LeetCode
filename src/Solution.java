import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//		printArray(ans, ans.length);
	}
	
	// 1. Two Sum ||  Solution Performance: Time: 5% (142ms) Memory: 71.37%
    public int[] twoSum(int[] nums, int target) {

        List<Integer> num = new ArrayList<>();
        
        for(int i=0; i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j]) == target){
                    if(!num.contains(i)){
                        num.add(i);
                    }
                    
                    if(!num.contains(j)){
                        num.add(j);
                    }
                }
            }
        }
        int[] array = num.stream().mapToInt(i->i).toArray();

        return array;
    }
	
//	217. Contains Duplicate  ||  Solution Performance: Time: 38.85% (8ms) Memory: 44.99%
    public boolean containsDuplicate(int[] nums) {
        Dictionary dup = new Hashtable();
        
        for(int i=0; i<nums.length; i++){
            if(dup.get(nums[i]) == null){
                dup.put(nums[i],1);
            }
            else if(dup.get(nums[i]) != null){
                return true;
            }
        }
        return false;
    }
    
    
//	242. Valid Anagram ||  Solution Performance: Time: 5.03% (68ms) Memory: 5.03%
    public boolean isAnagram(String s, String t) {
        Dictionary ans = new Hashtable();
        Dictionary cmp = new Hashtable();
        
        String[] str = s.split("");
        String[] tr = t.split("");
        
        for (int i = 0; i<str.length;i++){
            if(ans.get(str[i]) == null){
                ans.put(str[i],1);
            }
            else if(ans.get(str[i]) != null) {
                int count = Integer.parseInt(ans.get(str[i]).toString());
                count++;
                ans.put(str[i],count);
            }
        }
        
        for (int i = 0; i<tr.length;i++){
            if(cmp.get(tr[i]) == null){
                cmp.put(tr[i],1);
            }
            else if(cmp.get(tr[i]) != null) {
                int count = Integer.parseInt(cmp.get(tr[i]).toString());
                count++;
                cmp.put(tr[i],count);
            }
        }
        
        Boolean flag = false;
        if(ans.equals(cmp))
            flag = true;
        return flag;
    }
    
//	344. Reverse String ||  Solution Performance: Time: 62.78%(1ms)  Memory: 5.03%
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
	
//	 * Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	     TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	  
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        int val = root.val;
	        int sum = 0;
	        if (root== null)
	        	return sum;
	        
	        Queue<TreeNode>  q = new LinkedList<>();
	        q.add(root);

	    	while(!q.isEmpty()){

                TreeNode current = q.remove();
                // getting the sum by checking for the given range
	            if (current.val>=L && current.val<=R){
                    sum+=current.val;
                }
                
                //checking to see which direction to move the traversal in 
                if (current.val >= L && current.left != null)
                    q.add(current.left);
                if (current.val <= R && current.right != null)
                    q.add(current.right);
            }
	        return sum;
    }
	  
//	832. Flipping an Image  ||  Solution Performance: Time: 100.%(0ms)  Memory: 92.11%


    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ans = new int[A.length][A[0].length];
        int k = 0;
        for (int i = 0; i<A.length; i++){
            k = 0;
            for (int j = A[0].length-1; j>=0; j--){
                if (A[i][j] == 0)
                    ans[i][k] = 1;
                else ans[i][k] = 0;
                k++;
            }
        }
        return ans;
    }
    
//	1431. Kids With the Greatest Number of Candies  ||  Solution Performance: Time: 63.68%(1ms)  Memory: 5.22%

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) { 
        List<Boolean> ans = new ArrayList();
        // int max = Arrays.stream(candies).max().getAsInt();
        int max = candies[0];
        for (int i = 1; i<candies.length; i++){
            if(candies[i] >max)
                max = candies[i];
        }
        for (int i = 0; i<candies.length; i++){
            if (candies[i] + extraCandies >= max){
                ans.add(true);
            }
            else {
                ans.add(false);
            }
        }
        return ans;
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
