package com.joham.spider;

import com.joham.httpclient.HttpClientUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author joham
 */
public class Test2 {

    private static final String URL = "https://mp.weixin.qq.com/s/dFiv_jcBF1TgR_3wGX1jjQ";

    private static Pattern titlePattern = Pattern.compile("<meta property=\"og:title\" content=\"(.*?)\" />");

    private static Pattern keyPattern = Pattern.compile("voice_encode_fileid=\"(.*?)\"");

    private static final String VOICE_URL = "https://res.wx.qq.com/voice/getvoice?mediaid=";

    public static void main(String[] args) {
        String result = HttpClientUtil.get(URL, null);
        Matcher titleMatcher = titlePattern.matcher(result);
        if (titleMatcher.find()) {
            String title = titleMatcher.group(1);
            Matcher keyMatcher = keyPattern.matcher(result);
            if (keyMatcher.find()) {
                String key = keyMatcher.group(1);
                String url = VOICE_URL + key;
                try {
                    downLoadFromUrl(url, title, "/Users/joham/Downloads/");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        if (!"".equals(urlStr)) {
            java.net.URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(500 * 1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName + ".mp3");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            System.out.println("info:" + url + " download success");
        }
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
