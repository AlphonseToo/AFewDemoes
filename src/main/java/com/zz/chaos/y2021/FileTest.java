package com.zz.chaos.y2021;

/**
 * FileTest
 *
 * @author Alphonse
 * @version 1.0
 **/
public class FileTest {

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\DELL\\Desktop\\role.zip";
//        String s = MD5Util.getFileMD5(filePath).toLowerCase();
//        System.out.println(s);
        System.out.println("5785fb24c413b4c44ac018fced07b565");

        String zipPath = "C:\\Users\\DELL\\Desktop\\role.zip";
        try {
//            AutoScanApi autoScanApi = new AutoScanApi("127.0.0.1", 22, "sunyard02");
//            String returnMsg = autoScanApi.ScanImageFile("UWC", zipPath);
//            System.out.println("returnMsg == " + returnMsg);
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }
}
