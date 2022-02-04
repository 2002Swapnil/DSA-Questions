import java.util.ArrayList;
import java.util.*;

public class Solution 
{
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
		Collections.sort(stalls);

        int lo = 1;
        int n= stalls.size();
        int hi = stalls.get(n-1)-stalls.get(0);
        int ans=1;
        while(lo<=hi){
			int mid = lo+(hi-lo)/2;
            if(isPossible(stalls,k,mid)){
                ans=mid;
                lo = mid+1;           
            }
            else{
                hi = mid-1;
            }
        }
        return ans;
    }
    public static boolean isPossible(ArrayList<Integer> stalls, int k,int mid){
        int d = stalls.get(0);
        int sa =1;
        for(int i=0;i<stalls.size();i++){
            if(stalls.get(i)-d>=mid){
                sa++;
                d = stalls.get(i);
            }
            if(sa==k){
                return true;
            } 
        }
        return false;
    } 
}