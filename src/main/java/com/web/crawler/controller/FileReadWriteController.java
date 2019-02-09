package com.web.crawler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.crawler.model.FileData;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class FileReadWriteController {

	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/readfile", method = RequestMethod.GET)
	public String readFile(@RequestBody FileData data) { 
		JSONObject finalObjectReturn = new JSONObject();
		try {
			
			final String fileData = readUsingFiles(data.getPath());
			finalObjectReturn.put("status", HttpStatus.OK.getReasonPhrase());
			finalObjectReturn.put("code", HttpStatus.OK.value());
			finalObjectReturn.put("fileData", fileData);
			return finalObjectReturn.toJSONString();
		} catch (IOException e) {
			finalObjectReturn.put("status", HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
			finalObjectReturn.put("code", HttpStatus.SERVICE_UNAVAILABLE.value());
			finalObjectReturn.put("message", "Failed to Read data in File...!");
			return finalObjectReturn.toJSONString();
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/writefile", method = RequestMethod.POST)
	public String writeFile(@RequestBody FileData request) { 
		
		JSONObject finalObjectReturn = new JSONObject();
		if (request.getPath() == null || request.getData() == null) {
			
			finalObjectReturn.put("status", HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
			finalObjectReturn.put("code", HttpStatus.UNPROCESSABLE_ENTITY.value());
			finalObjectReturn.put("message", "Path or Data is missing in the payload..!");
			return finalObjectReturn.toJSONString();
		}
		boolean isFileWriteCompleted = writeUsingFileWriter(request.getData(),request.getPath());
		if (isFileWriteCompleted) {
			finalObjectReturn.put("status", HttpStatus.OK.getReasonPhrase());
			finalObjectReturn.put("code", HttpStatus.OK.value());
			finalObjectReturn.put("message", "Writing to a File is Successful..!");
		} else {
			finalObjectReturn.put("status", HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
			finalObjectReturn.put("code", HttpStatus.SERVICE_UNAVAILABLE.value());
			finalObjectReturn.put("message", "Failed to Write in to File...!");
		}
		return finalObjectReturn.toJSONString();
	}
	
    @SuppressWarnings("unused")
	private static String readUsingFiles(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes);
    }
	
    @SuppressWarnings("finally")
	private boolean writeUsingFileWriter(final String data, final String path) {
        File file = new File(path);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally{
            //close resources
            try {
                fr.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
		
    }
    
    /*
    private static void writeUsingOutputStream(String data) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("/Users/pankaj/os.txt"));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("/Users/pankaj/files.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    private static void writeUsingBufferedWriter(String data, int noOfLines) {
        File file = new File("/Users/pankaj/BufferedWriter.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine=data+System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

*/
    
}
