package com.eunmi.algorithm.category.kruskal;

//합집합 찾기
public class UnionFind {
    static int getParent(int parent[], int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = getParent(parent, parent[x]); //재귀 함수를 사용한다.
    }

    //각 부모 노드를 합친다.
    static void unionParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) { //더 작은 쪽으로 합친다.
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    //같은 부모 노드를 가지는지 확인한다.
    static boolean findParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        int[] parent = new int[11];
        for(int i =1; i<= 10; i++){
            parent[i] = i; //모든 값이 자기 자신을 가르키도록 만든다.
        }

        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 4, 7);
        unionParent(parent, 5, 6);

        System.out.println(findParent(parent, 2, 6));
        System.out.println(getParent(parent, 3));


    }

}
