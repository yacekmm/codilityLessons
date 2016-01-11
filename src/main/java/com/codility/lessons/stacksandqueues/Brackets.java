package com.codility.lessons.stacksandqueues;

import java.util.Stack;

/*
Determine whether a given string of parentheses is properly nested.



A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

        S is empty;
        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

    class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

        N is an integer within the range [0..200,000];
        string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

Complexity:

        expected worst-case time complexity is O(N);
        expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

 */

public class Brackets {
    public int solution(String S) {

        Stack<Character> stack = new Stack<>();

        if(S == null){
            return 0;
        }else{
            for (char c: S.toCharArray()) {
                if(isClosingBracket(c)){
                    if(stack.isEmpty()){
                        return 0;
                    }else if(!bracketsMatch(stack.pop(), c)){
                        return 0;
                    }
                }else{
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                return 1;
            }else{
                return 0;
            }
        }
    }

    private boolean bracketsMatch(char opening, char closing) {
        return  (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}') ||
                (opening == '(' && closing == ')');
    }

    private boolean isClosingBracket(char c) {
        return  c == ']' ||
                c == '}' ||
                c == ')';
    }
}
