package com.bjpowernode.niuke;

/**
 * @李永琪
 * @create 2020-10-03 21:13
 */
public class ReverseSentence {

    public static void main(String[] args) {
        String str = "   ";
        String s = reverseSentence(str);
        System.out.println(s);
    }
    //牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
    // 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
    // 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
    // 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
    public static String reverseSentence(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        String[] strs = str.split(" ");
        if(strs.length == 0){
            return str;
        }
        String[] resStrs = new String[strs.length];
        int count = 0;
        for (int i = strs.length - 1; i >= 0; i--) {
            resStrs[count] = strs[i];
            count++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < resStrs.length; i++) {
            if(i == resStrs.length - 1){
                stringBuilder.append(resStrs[i]);
            }else{
                stringBuilder.append(resStrs[i] + " ");
            }
        }

        return stringBuilder.toString();
    }

}
