package com.infernosstudio.johny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class JCFile {

	public static String fileToString(File file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		if (reader == null) {
			return "FILE READ ERROR!";
		}
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public static boolean stringToFile(String name, String string) {
		return stringToFile(new File(name), string);
	}

	public static boolean stringToFile(File file, String string) {
		File dir = file.getParentFile();
		dir.mkdirs();
		RandomAccessFile raf = null;
		try {
			if (file.isFile()) {
				file.delete();
			}
			if (!(file.createNewFile() && file.canWrite())) {
				return false;
			}
			raf = new RandomAccessFile(file, "rw");
			raf.write(string.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public static boolean deleteFileOrDir(File file) {

		if (file == null) {
			return false;
		}

		if (file.isFile()) {
			return file.delete();
		}

		if (!file.isDirectory()) {
			return false;
		}

		File[] fileList = null;
		fileList = file.listFiles();
		if ((fileList != null) && (fileList.length > 0)) {
			for (File f : fileList) {
				if (!JCFile.deleteFileOrDir(f)) {
					return false;
				}
			}
		}

		return file.delete();
	}

	public static boolean deleteDirContent(File file) {
		if (!file.isDirectory()) {
			return false;
		}

		File[] fileList = null;
		fileList = file.listFiles();
		if ((fileList != null) && (fileList.length > 0)) {
			for (File f : fileList) {
				if (!JCFile.deleteFileOrDir(f)) {
					return false;
				}
			}
		}

		return true;
	}

	public static void copyFile(File sourceFile, File destFile) throws IOException {
		destFile.getParentFile().mkdirs();
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}

	public static String fileToRawString(File file) {
		file.getParentFile().mkdirs();
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			return new String(data, JC.utf8);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean stringToRawFile(File file, String string) {
		file.getParentFile().mkdirs();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(JC.utf8.encode(string).array());
			fos.close();
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

}
