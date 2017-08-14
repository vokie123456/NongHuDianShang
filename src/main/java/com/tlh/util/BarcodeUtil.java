package com.tlh.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class BarcodeUtil {
	public static String generatorBarCode(String content, int width, int height, String path) {
		try {
			MultiFormatWriter writer = new MultiFormatWriter();
			Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			BitMatrix encode = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = FileSystems.getDefault().getPath(path, new String[] { UUID.randomUUID() + ".png" });
			MatrixToImageWriter.writeToPath(encode, "png", file);
			return path + "/" + file.getFileName().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String generatorBarCode(String content, int width, int height, String path, File logoFile) {
		try {
			MultiFormatWriter writer = new MultiFormatWriter();
			Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			hints.put(EncodeHintType.MARGIN, Integer.valueOf(1));
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix encode = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

			BufferedImage image = new BufferedImage(width, height, 1);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, encode.get(x, y) ? -16777216 : -1);
				}
			}

			if (logoFile.exists()) {
				Image logo = ImageIO.read(logoFile);
				int logoWidth = logo.getWidth(null);
				int logoHeight = logo.getHeight(null);
				if (logoWidth > 60) {
					logoWidth = 60;
				}
				if (logoHeight > 60) {
					logoHeight = 60;
				}
				logo = logo.getScaledInstance(logoWidth, logoHeight, 4);

				Graphics2D graph = image.createGraphics();
				int x = (300 - logoWidth) / 2;
				int y = (300 - logoHeight) / 2;
				graph.drawImage(logo, x, y, logoWidth, logoHeight, null);
				graph.dispose();

				File dir = new File(path);
				String fileName = UUID.randomUUID() + ".png";
				File out = new File(dir, fileName);
				ImageIO.write(image, "png", out);
				return path + "/" + fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}