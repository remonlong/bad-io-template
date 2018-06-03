package com.bad.remon.io.templateIo.util;

import java.io.*;

/**
 * 模板文件在加载工具类
 *
 * @author remon
 * @create 2018-06-01 15:48
 **/
public final class TemplateFileLoadUtil {


    public static InputStream loadFile(String filePath) throws FileNotFoundException {
        return new FileInputStream(filePath);
    }

    public static InputStreamReader getInputStreamReader(String filePath) throws FileNotFoundException {
        return new InputStreamReader(loadFile(filePath));
    }

    public static BufferedReader getBufferReader(String filePath) throws FileNotFoundException {
        return new BufferedReader(getInputStreamReader(filePath));
    }


    public static String getTemplateFileValue(String filePath) throws IOException {
        BufferedReader reader = getBufferReader(filePath);
        StringBuffer sb = new StringBuffer();
        int data = 0;
        while ((data = reader.read()) != -1) {
            sb.append((char) data);
        }
        return sb.toString();
    }

    public static OutputStream loadFileOut(String filePath) throws IOException {
        judgeFile(filePath);
        return new FileOutputStream(filePath);
    }

    public static void judgeFile(String filePath) throws IOException {
        judgeFile(filePath, false);
    }

    public static void judgeFile(String filePath, boolean isDir) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            if (!isDir) {
                file.createNewFile();
            } else {
                file.mkdirs();
            }
        }
    }


    public static String writerFile(String fileTemp, String filePath) throws IOException {
        OutputStream outputStream = loadFileOut(filePath);
        outputStream.write(fileTemp.getBytes());
        return getTemplateFileValue(filePath);
    }

    public static void genDir(String genPath) throws IOException {
        judgeFile(genPath, true);
    }
}
