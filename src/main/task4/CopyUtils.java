package task4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Утилита для копирования файлов. На консоль выводиться время, потраченное на
 * копирование файла;
 * 
 */
public class CopyUtils {

	public static void copy(String src, String dest) throws IOException {
		copy(new File(src), new File(dest));

	}

	/**
	 * Копирование файлов.
	 * 
	 * @param sourceFile
	 *            имя копируемого файла
	 * @param destFile
	 *            имя для конечногофайла
	 * @throws IOException
	 */
	public static void copy(File sourceFile, File destFile) throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;
		long begin = System.currentTimeMillis();
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
		long end = System.currentTimeMillis();
		System.out.println("Time copy: " + (end - begin) + " ms");
	}
}
