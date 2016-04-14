package Dl;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Scanner;

public class Downloader implements Runnable {

    private final String filename;
    private final String urlString;

    public Downloader(String filename, String urlString) {
        this.filename = filename;
        this.urlString = urlString;

    }

    @Override
    public void run() {
        dlFile(filename, urlString);
    }

    public void dlFile(String filename, String urlString) {
        try
        {
            BufferedInputStream bis = null;
            FileOutputStream fos = null;
            try
            {
                bis = new BufferedInputStream(new URL(urlString).openStream());
                fos = new FileOutputStream(filename);

                byte data[] = new byte[1024];
                int count;
                while ((count = bis.read(data, 0, 1024)) != -1)
                {
                    fos.write(data, 0, count);
                    System.out.println("*");
                }

            } finally //eger hata alınırsa sonraki dl'nin sorunsuz calısması için temizleme
            {
                if (bis != null)
                {
                    bis.close();
                }
                if (fos != null)
                {
                    fos.close();
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
