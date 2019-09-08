package example.boot.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.boot.entity.UploadEntity;

@Controller
public class UploadScreenControler {

    @Autowired
    private Environment env;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadScreen(Model model) {
		model.addAttribute("UploadEntity", new UploadEntity());
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(Model model, UploadEntity uploadEnt) {
		//ファイル名
		String fileName = this.getFileNameWithoutExtension(uploadEnt.getFile().getOriginalFilename());

		//拡張子
		String extension = this.getExtension(uploadEnt.getFile().getOriginalFilename());

		//現在時刻
		String nowTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());

		//アップロード先にファイル作成
		//TODO
		//String aa = env.getProperty("spring.jpa.database");
		Path uploadFile = Paths.get("C:/upload/" + fileName + "_" + nowTime + extension);

		//
		try {
			OutputStream outputStream = Files.newOutputStream(uploadFile, StandardOpenOption.CREATE);
			outputStream.write(uploadEnt.getFile().getBytes());
			outputStream.flush();
		}catch(IOException e) {
		}

		return "complete";
	}

	private String getExtension(String fileName) {
		int dot = fileName.lastIndexOf(".");
		if (dot > 0) {
			return fileName.substring(dot).toLowerCase();
		}
		return "";
	}

	private String getFileNameWithoutExtension(String fileName) {
		int dot = fileName.lastIndexOf(".");
		if (dot > 0) {
			return fileName.substring(0,dot).toLowerCase();
		}
		return "";
	}

}
