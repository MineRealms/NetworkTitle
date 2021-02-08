package cn.minerealms.networktitle;


import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;

import org.lwjgl.opengl.*;
import net.minecraftforge.fml.common.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class ReplaceTitle
{

    public static void Replace() throws ReplaceException {
        if (Config.Url != "") {
            Display.setTitle(processText());
        }
    }

    public static String readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        System.out.println(new String(bos.toByteArray(),Config.ENCODE));
        return new String(bos.toByteArray(),Config.ENCODE);
    }

    public static String getFile(String urlStr) throws ReplaceException {
        String res=null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(1000*Integer.parseInt(Config.timeout));
            conn.setRequestProperty("User-Agent", Config.UA);

            InputStream inputStream = conn.getInputStream();
            res = readInputStream(inputStream);
        } catch (Exception e) {
            FMLLog.log.info("NetowrkTitle 在替换标题时出现错误，堆栈轨迹如下:");
            e.printStackTrace();
        }
        return res;
    }
    
    public static String processText() throws ReplaceException {
        final String tips = getFile(Config.Url);
        return tips;
    }
}
