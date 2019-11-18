package com.nrsc.elegant.util;

import java.util.LinkedList;

/**
 * @author : Sun Chuan
 * @date : 2019/11/18 20:13
 * Description:
 */
public class FormatStringUtils {

    private FormatStringUtils() {
    }

    /***
     * 将字符串  我是{},你是{},他是{} ----> 转成 我是{0},你是{1},他是{2}
     * @param message
     * @param prefix
     * @param suffix
     * @return
     */
    public static String formatMessage(String message, char prefix, char suffix) {
        LinkedList<Character> chars = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < message.length(); i++) {
            if (prefix == message.charAt(i) && suffix == message.charAt(i + 1)) {
                chars.add(prefix);
                chars.add(Character.forDigit(j, 10));
                j++;
            } else {
                chars.add(message.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            sb.append(chars.get(i));
        }
        return sb.toString();
    }
}
