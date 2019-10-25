1.
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：

装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/water-and-jug-problem
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(y==0&&x!=0){
            return z%x==0;
        }if(y!=0&&x==0){
            return z%y==0;
        }if(y==0&&x==0&&z==0){
            return true;
        }if(x+y<z){
            return false;
        } 
        while(x%y!=0){
            int tmp=x%y;
            x=y;
            y=tmp;
        }
        return z%y==0;
    }
}

2.
给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/continuous-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int flag=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]&&nums[i]==0){
                flag=1;
            }
        }
        if(flag==1&&k==0){
            return true;
        }if(k==0||nums.length<2){
            return false;
        }
        for(int i=0;i<nums.length-1;i++){
            int sum=nums[i];
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum%k==0){
                    return true;
                }
            }
        }
        return false;
    }
}

3.
给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/h-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        int l=0;
        int r=citations.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(citations[mid]<citations.length-mid){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return citations.length-l;
    }
}

