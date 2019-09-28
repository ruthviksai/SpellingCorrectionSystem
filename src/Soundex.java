public class Soundex {

    public static String getSoundexCode(String s) {
        char[] ch = s.toUpperCase().toCharArray();

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == 'B' || ch[i] == 'F' || ch[i] == 'P' || ch[i] == 'V') {
                ch[i] = '1';
            } else if (ch[i] == 'C' || ch[i] == 'G' || ch[i] == 'J' || ch[i] == 'K' || ch[i] == 'Q' ||
                    ch[i] == 'S' || ch[i] == 'X' || ch[i] == 'Z') {
                ch[i] = '2';
            } else if (ch[i] == 'D' || ch[i] == 'T') {
                ch[i] = '3';
            } else if(ch[i] == 'L') {
                ch[i] = '4';
            } else if (ch[i] == 'M' || ch[i] == 'N') {
                ch[i] = '5';
            } else if (ch[i] == 'R') {
                ch[i] = '6';
            } else  {
                ch[i] = '0';
            }
        }

        String code = "" + ch[0];
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] != '0' && ch[i] != ch[i-1]) {
                code += ch[i];
            }
        }
        code += "0000";
        code = code.substring(0, 4);
        return code;
    }
}
