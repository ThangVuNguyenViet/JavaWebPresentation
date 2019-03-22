/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.helpers;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Thang
 */
public class Helper {

    public static String toUTF8(String input) {
        byte[] bytes = input.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
