/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.helpers;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Thang
 */
public class NewClass {

    // Mang cac ky tu goc co dau
    private static char[] SOURCE_CHARACTERS = {'À', 'Á', 'Â', 'Ã', 'È', 'É',
        'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â',
        'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý',
        'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ',
        'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ',
        'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ',
        'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ',
        'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
        'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ',
        'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ',
        'ữ', 'Ự', 'ự',};

    // Mang cac ky tu thay the khong dau
    private static char[] DESTINATION_CHARACTERS = {'A', 'A', 'A', 'A', 'E',
        'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
        'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
        'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
        'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
        'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
        'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
        'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
        'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
        'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
        'U', 'u', 'U', 'u',};

    public static void main(String[] args) {
        //1 An Giang -> AN_GIANG("An Giang")
        StringTokenizer tokenizer = new StringTokenizer("1 An Giang\n"
                + "2 Bà Rịa-Vũng Tàu\n"
                + "3 Bạc Liêu\n"
                + "4 Bắc Kạn\n"
                + "5 Bắc Giang\n"
                + "6 Bắc Ninh\n"
                + "7 Bến Tre\n"
                + "8 Bình Dương\n"
                + "9 Bình Định\n"
                + "10 Bình Phước\n"
                + "11 Bình Thuận\n"
                + "12 Cà Mau\n"
                + "13 Cao Bằng\n"
                + "14 Cần Thơ (TP)\n"
                + "15 Đà Nẵng (TP)\n"
                + "16 Đắk Lắk\n"
                + "17 Đắk Nông\n"
                + "18 Điện Biên\n"
                + "19 Đồng Nai\n"
                + "20 Đồng Tháp\n"
                + "21 Gia Lai\n"
                + "22 Hà Giang\n"
                + "23 Hà Nam\n"
                + "24 Hà Nội (TP)\n"
                + "25 Hà Tây\n"
                + "26 Hà Tĩnh\n"
                + "27 Hải Dương\n"
                + "28 Hải Phòng (TP)\n"
                + "29 Hòa Bình\n"
                + "30 Hồ Chí Minh (TP)\n"
                + "31 Hậu Giang\n"
                + "32 Hưng Yên\n"
                + "33 Khánh Hòa\n"
                + "34 Kiên Giang\n"
                + "35 Kon Tum\n"
                + "36 Lai Châu\n"
                + "37 Lào Cai\n"
                + "38 Lạng Sơn\n"
                + "39 Lâm Đồng\n"
                + "40 Long An\n"
                + "41 Nam Định\n"
                + "42 Nghệ An\n"
                + "43 Ninh Bình\n"
                + "44 Ninh Thuận\n"
                + "45 Phú Thọ\n"
                + "46 Phú Yên\n"
                + "47 Quảng Bình\n"
                + "48 Quảng Nam\n"
                + "49 Quảng Ngãi\n"
                + "50 Quảng Ninh\n"
                + "51 Quảng Trị\n"
                + "52 Sóc Trăng\n"
                + "53 Sơn La\n"
                + "54 Tây Ninh\n"
                + "55 Thái Bình\n"
                + "56 Thái Nguyên\n"
                + "57 Thanh Hóa\n"
                + "58 Thừa Thiên - Huế\n"
                + "59 Tiền Giang\n"
                + "60 Trà Vinh\n"
                + "61 Tuyên Quang\n"
                + "62 Vĩnh Long\n"
                + "63 Vĩnh Phúc\n"
                + "64 Yên Bái", "\n");
        while (tokenizer.hasMoreTokens()) {
            String value = tokenizer.nextToken().replaceFirst("\\d+ ", ""); //Yen Bai
            value = removeAccent(value);
            String strInUppercase = removeAccent(value).toUpperCase(); //YEN BAI
            String cons = strInUppercase.replaceAll("-", " ").replaceAll(" ", "_").replaceAll("_+", "_");//YEN_BAI -> YEN_BAI("Yen Bai");
            System.out.println(cons + "(\"" + value + "\"),");
        }
    }

    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    /**
     * Bo dau 1 chuoi
     *
     * @param s
     * @return
     */
    public static String removeAccent(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }
}
