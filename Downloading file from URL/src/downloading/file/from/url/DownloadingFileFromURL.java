/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloading.file.from.url;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author DATAWISE
 */
public class DownloadingFileFromURL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     String url = "https://www.ntsb.gov/investigations/AccidentReports/Pages/aviation.aspx";
     
      String file = "C:\\prog\\aviation.aspx";
 
      BufferedInputStream bufferedIS = null;
      FileOutputStream fileOS = null;
      try {
        URL urlObj = new URL(url);
        bufferedIS = new BufferedInputStream(urlObj.openStream());
        fileOS = new FileOutputStream(file);
 
        int data = bufferedIS.read();
        while(data != -1){
          fileOS.write(data);
          data = bufferedIS.read();
        }
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }finally{
        try {
          if(fileOS != null){
            fileOS.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          if(bufferedIS != null){
            bufferedIS.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }