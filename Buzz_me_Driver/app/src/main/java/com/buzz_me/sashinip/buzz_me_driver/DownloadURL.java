package com.buzz_me.sashinip.buzz_me_driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sashinip on 3/26/2018.
 */
public class DownloadURL {

    public String readURL(String url) throws IOException{
        String data = "";

        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;

        try {
            URL url1 = new URL(url);
            httpURLConnection = (HttpURLConnection) url1.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer = new StringBuffer();

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {

                stringBuffer.append(line);
            }

            data = stringBuffer.toString();
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            httpURLConnection.disconnect();
        }

        return data;
    }
}
