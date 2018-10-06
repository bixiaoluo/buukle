package top.buukle.common.util.common;

import java.security.MessageDigest;

/**   
 * 项目名称：suprefund   
 * 类名称：MD5Util   
 * 类描述：   
 * 创建人：Linenmin   
 * 创建时间：2014-5-7 上午10:53:19   
 * 修改人：XXXX   
 * 修改时间：2014-5-7 上午10:53:19   
 * 修改备注：   
 * @version 1.0  
 */
public class MD5Util {
	private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)){
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }
            else{
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String HEXDIGITS[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "UserLoginPermissionQuery", "e", "f" };
}

