package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class meeting_rooms {
	
	public class Interval{
		public  int start;
		public int end;
	}
	public int minMeetingRooms(Interval[] intervals) {
	    if(intervals==null||intervals.length==0)
	        return 0;
	 
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            return i1.end-i2.end;
	        }
	    });
	 
	    Queue<Integer> queue = new LinkedList<Integer>();
	    int count=1;
	    queue.offer(intervals[0].end);
	 
	    for(int i=1; i<intervals.length; i++){
	        if(intervals[i].start<queue.peek()){
	            count++;
	 
	        }else{
	            queue.poll();
	        }
	 
	        queue.offer(intervals[i].end);
	    }
	 
	    return count;
	}
	
	public static void main(String[] args){
		meeting_rooms mr=new meeting_rooms();
		Scanner sc=new Scanner(System.in);
		Interval[] intervals=new Interval[3];
		for(int i=0;i<intervals.length;i++){
			intervals[i].start = sc.nextInt();
			intervals[i].end = sc.nextInt();
		}
		
		int counter= mr.minMeetingRooms(intervals);
		System.out.println(counter);
	}
}
