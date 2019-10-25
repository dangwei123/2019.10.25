1.
传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装
载包裹。我们装载的重量不会超过船的最大运载重量。返回能在 D 天内将传送带上的
所有包裹送达的船的最低运载能力。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int shipWithinDays(int[] weights, int D) {
       int max=weights[0];
       int sum=0;
        for(int i:weights){
            if(i>max){
                max=i;
            }
            sum+=i;
        }
        int l=max;
        int r=sum;
        int mid=0;
        while(l<r){
            mid=l+(r-l)/2;
            if(canShip(weights, D, mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean canShip(int[] weights,int D,int mid){
           int tmp=mid;
           for(int i=0;i<weights.length;i++){
               tmp-=weights[i];
               if(tmp<0){
                   D--;
                   tmp=mid-weights[i];
               }
           }
        return D>0;
    }
}

2.
珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。

珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

 

示例 1：

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/koko-eating-bananas
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l=1;
        int r=piles[0];
        for(int x:piles){
            if(x>r){
                r=x;
            }
        }
        while(l<r){
            int mid=l+(r-l)/2;
            if(canEat(piles,H,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean canEat(int[] piles,int H,int mid){
        int time=0;
        for(int x: piles){
            time+=x/mid;
            if(x%mid!=0){
                time++;
            }
        }
        return time<=H;
    } 
    
}

3.
给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。

h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/h-index-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        int l=0;
        int r=citations.length;
        int mid=0;
        while(l<r){
            mid=l+(r-l)/2;
           if(citations[mid]<citations.length-mid){
               l=mid+1;
           }else{
               r=mid;
           }
        }
        return citations.length-l;
    }
}