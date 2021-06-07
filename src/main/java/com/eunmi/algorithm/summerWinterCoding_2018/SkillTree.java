package com.eunmi.algorithm.summerWinterCoding_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class SkillTree {
    public static void main(String[] args){
        SkillTree sk = new SkillTree();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(sk.solution_by_others(skill, skill_trees));


    }
    public int solution(String skill, String[] skill_trees){
        String[] skill_set = skill.split(""); //:"C" "B" "D"
        Stack<String> stack = new Stack<String>();
        int count = 0;
        boolean isFail = false;
        for (int i = 0; i < skill_trees.length; i++) {
            //초기화
            isFail = false;
            stack.clear();

            // 스택에 추가
            for (int k = skill_set.length; k > 0; k--) {
                stack.push(skill_set[k - 1]); //"D" "B" "C"
            }

            String[] temp = skill_trees[i].split(""); //"B" "A" "C" "D" "E"
            for (int j = 0; j < temp.length; j++) {
                if (skill.indexOf(temp[j]) != -1) { // 포함여부 확인
                    if (stack.peek().equals(temp[j])) {
                        stack.pop();
                    } else {
                        isFail = true;
                        break;
                    }
                }
            }
            if (!isFail) {
                count++;
            }
        }
        return count;
    }

    public int solution_by_others(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            String replaced = it.next().replaceAll("[^" + skill + "]", "");
            System.out.println(replaced);
            if (skill.indexOf(replaced) != 0) {
                //"[^"+skill+"]" -> skill 안에 없는 글자들(not present in skill) 은 ""로 replace 해준다.
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }



}
