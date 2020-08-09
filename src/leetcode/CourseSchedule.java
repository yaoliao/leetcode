package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * <p>
 * num:207
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * @author: TuGai
 * @createTime: 2020-08-07 23:33
 **/
public class CourseSchedule {

    /**
     * 关键点:***************  拓扑排序  *********************
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre))
                if (--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}
