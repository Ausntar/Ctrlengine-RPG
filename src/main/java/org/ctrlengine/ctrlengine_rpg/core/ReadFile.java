package org.ctrlengine.ctrlengine_rpg.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static org.ctrlengine.ctrlengine_rpg.core.Log.logger;

/**
 * @author Ctrlengine Development Team
 */
public class ReadFile {
    static ArrayList<String> jsonContent = new ArrayList<>();
    static ArrayList<String> jsonPath = new ArrayList<>();
    public String readFile(String filePath){
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
               contentBuilder.append(currentLine).append("\n");
           }
       } catch (IOException e) {
            logger.error("无法读取文件：{}", filePath, e);
       }

       return contentBuilder.toString();
   }
    public static String readJson(String filePath, String findSettings, String type) {
        if (Objects.equals(type, "flushed")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                
                if (content.toString().contains(findSettings)) {
                    int start = content.indexOf(findSettings);
                    int end = content.indexOf("}", start);
                    if (start != -1 && end != -1) {
                        String json = content.substring(start, end + 1);
                        if (Objects.equals(type, "String")) {
                            return json;
                        }
                    }
                }
            } catch (IOException e) {
                logger.error("发生异常：", e);
            }
            return null;
        }
        else if(Objects.equals(type, "coiled")){
            String content = null;
            try{
                for(int i=0;i<jsonPath.size();i++){
                    if(Objects.equals(jsonPath.get(i), filePath)){
                        content = jsonContent.get(i);
                        break;
                    }
                }
                if (content != null && content.contains(findSettings)) {
                    int start = content.indexOf(findSettings);
                    int end = content.indexOf("}", start);
                    if (start != -1 && end != -1) {
                        String json = content.substring(start, end + 1);
                        if (Objects.equals(type, "String")) {
                            return json;
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("发生异常：", e);
                return null;
            }
        }
        return null;
    }
}
