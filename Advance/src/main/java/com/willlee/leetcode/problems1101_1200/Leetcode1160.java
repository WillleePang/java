package com.willlee.leetcode.problems1101_1200;

public class Leetcode1160 {
    public int countCharacters(String[] words, String chars) {
        int[] charArray = new int[26];
        int ans = 0;
        for (char c : chars.toCharArray()) {
            charArray[c - 'a']++;
        }
        for (String word : words) {
            int[] tempCharArray = new int[26];
            for (char c : word.toCharArray()) {
                tempCharArray[c - 'a']++;
            }

            boolean flag = true;
            for (int i = 0; i < tempCharArray.length; i++) {
                if (tempCharArray[i] > charArray[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                ans += word.length();
        }
        return ans;
    }

    public int countCharacters1(String[] words, String chars) {
        int[] c = new int[26];
        for (char cc : chars.toCharArray()) {
            c[(int) (cc - 'a')] += 1;
        }
        int res = 0;
        a: for (String word : words) {
            int[] w = new int[26];
            for (char ww : word.toCharArray()) {
                w[(int) (ww - 'a')] += 1;
            }
            for (int i = 0; i < 26; i++) {
                if (w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1160 a = new Leetcode1160();
        int countCharacters = a.countCharacters(
                new String[] {
                        "dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
                        "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
                        "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
                        "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
                        "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
                        "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
                        "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl",
                        "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
                        "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv",
                        "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
                        "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
                        "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
                        "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob",
                        "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
                        "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs" },
                "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp");
        System.out.println(countCharacters);
    }
}
