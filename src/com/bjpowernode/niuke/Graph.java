package com.bjpowernode.niuke;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @李永琪
 * @create 2020-10-07 14:35
 */
public class Graph {

    private List<String> vertexes;
    private int[][] edges;
    private int numberOfEdges;
    boolean[] isVisited;

    //构造器
    public Graph(int n){
        vertexes = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    //添加图的节点
    public void addVertex(String s){
        vertexes.add(s);
    }

    //添加图的边数
    public void addEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }

    //显示临界矩阵
    public void show(){
        for (int i = 0; i < edges.length; i++) {
            System.out.println(Arrays.toString(edges[i]));
        }
    }

    //根据下标获取节点的值
    public String getVertex(int i){
        return vertexes.get(i);
    }

    //获取边的权重的值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //得到第一个邻接点的下标
    public int getFirstneighbor(int index){
        for (int i = 0; i < vertexes.size(); i++) {
            if(edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接点的下标获取下一个临界点
    public int getNextNeighbor(int v1, int v2){
        for (int i = v2 + 1; i < vertexes.size(); i++) {
            if(edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //深度有限遍历算法
    //i第一次为0
    public void dfs(boolean[] isVisited,int i){
        //首先我们访问该节点进行输出
        System.out.println(getVertex(i) + "-->");
        //将节点设置为已经访问
        isVisited[i] = true;
        //查找节点i的第一个邻接节点
        int w = getFirstneighbor(i);
        while (w != -1){
            //说明有
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果节点节点已经北方问过了
            w = getNextNeighbor(i,w);
        }
    }

    //对dfs进行一个重载
    public void dfs(){
        isVisited = new boolean[vertexes.size()];
        //遍历所有的节点进行回溯
        for (int i = 0; i < vertexes.size(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //测试
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] strs = {"A","B","C","D","E"};
        for (int i = 0; i < strs.length; i++) {
            graph.addVertex(strs[i]);
        }
        //添加边 A-C A-B B-C B-D B-E
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);

        //显示
        graph.show();
    }

}
