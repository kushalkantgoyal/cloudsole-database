package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.CsvReaderService;
import com.example.service.CustomerService;

@Controller
@RequestMapping("/file")
public class FileController {

		@Autowired
		@Qualifier("jpaRepository")
		CustomerService customerService;
	
		@RequestMapping("")
		public String showUploadForm(){
			return "filebox";
		}
	
		@RequestMapping(value="/upload")
		public String fileUpload(@RequestParam(value="file", required=false) MultipartFile multiPartFile, HttpServletResponse httpServletResponse, Map<String, Object> map) throws IOException{
			String orgName = multiPartFile.getOriginalFilename();
			
			String filePath = "/Users/thysmichels/Desktop/" + orgName;
			File dest = new File(filePath);
				
			try{
				multiPartFile.transferTo(dest);
			}catch(IllegalStateException e){
				e.printStackTrace();
				
				map.put("uploadResult", "File uploaded failed " + orgName);
				return "filebox";
			}	
			map.put("uploadResult", "File uploaded :" + orgName);
			return "filebox";
		}
		
		@RequestMapping(value="/parse")
		public String fileUploadAndParse(@RequestParam(value="file", required=false) MultipartFile multiPartFile, HttpServletResponse httpServletResponse, Map<String, Object> map) throws IOException{
			String orgName = multiPartFile.getOriginalFilename();
			String contentType = multiPartFile.getContentType();
			String name = multiPartFile.getName();
			Long size = multiPartFile.getSize();
			
			File tmpFile = File.createTempFile("uploaded", ".csv");
			multiPartFile.transferTo(tmpFile);
			
			try{
				CsvReaderService csvReader = new CsvReaderService();
				Map<String, String> mapOfCustomers = csvReader.readCsv(tmpFile);
				map.put("csvList", mapOfCustomers);
				customerService.createCustomersFromMap(mapOfCustomers);
				
			}catch(IllegalStateException e){
				e.printStackTrace();
				
				map.put("uploadResult", "File uploaded failed " + orgName);
				return "filebox";
			}finally {
				tmpFile.deleteOnExit();
		     }
			map.put("uploadResult", "File uploaded success: File" + orgName + " Other Name: " + name + " Type: " + contentType + " Size: " + size);
			return "filebox";
		}
		
		@RequestMapping(value="/download", method=RequestMethod.GET)
		public void filedownload(@PathVariable("sobjectName") String sObjectName, Map<String, Object> map, HttpServletResponse response) throws Exception{
			 File file = File.createTempFile("cloudsole", ".csv");
			 
		     response.setContentType("application/csv"); 
		     response.setContentLength(new Long(file.length()).intValue());
		     response.setHeader("Content-Disposition","attachment; filename=CloudSole-" + sObjectName + ".csv");
		 
		     try {
		    	 FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
		    	 map.put("success", "Your file was downloaded successfully");
		     } catch (IOException e) {
		         e.printStackTrace();
		         map.put("error", e.getMessage());
		     }
		     finally
		     {
		    	 file.deleteOnExit();
		     }
		}
}
