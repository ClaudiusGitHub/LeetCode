package claudius.leetcode.question56;

import java.util.LinkedList;
import java.util.List;

/**
 * 给一些区间序列，让重复区间进行组合，最后输出结果
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList<Interval> list = new LinkedList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(1, 3));
//        list.add(new Interval(8, 10));
//        list.add(new Interval(15, 18));
        for (Interval interval : solution.merge(list)) {
            System.out.println(interval);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        LinkedList<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        intervals.sort((o1, o2) -> (o1.start - o2.start));
        Interval temp = intervals.get(0);
        for (Interval interval : intervals) {
            if (interval == temp)
                continue;
            if (interval.start <= temp.end) {
                if (temp.end < interval.end)
                    temp.end = interval.end;
            } else {
                result.add(temp);
                temp = interval;
            }
        }
        result.add(temp);
        return result;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
