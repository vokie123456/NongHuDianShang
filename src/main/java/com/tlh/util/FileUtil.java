package com.tlh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FileUtil {
	public static String uploadFile(HttpServletRequest request, MultipartFile file) {
		try {
			String path = request.getServletContext().getRealPath("upload");
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			if ((file != null) && (!file.isEmpty())) {
				String oldName = file.getOriginalFilename();
				String ex = oldName.substring(oldName.lastIndexOf("."));
				String name = UUID.randomUUID().toString() + ex;
				File upload = new File(dir, name);
				file.transferTo(upload);
				return "/upload/" + name;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean generateXmlFile(Object object, String path) {
		try {
			XStreamAlias annotation = (XStreamAlias) object.getClass().getAnnotation(XStreamAlias.class);
			if (annotation != null) {
				XStream xs = new XStream(new DomDriver("UTF-8"));
				xs.processAnnotations(object.getClass());
				xs.setMode(1001);
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File file = new File(dir, annotation.value() + ".xml");
				FileOutputStream fos = new FileOutputStream(file);
				xs.toXML(object, fos);
				fos.flush();
				fos.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}