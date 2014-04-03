import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import de.l3s.boilerpipe.BoilerpipeProcessingException;


public class renmin2006 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String targetFolder = "C:\\Users\\penghai\\Desktop\\1\\2006 Part1";
		String desFolder = "C:\\Users\\penghai\\Desktop\\1\\2006人民日报整理后\\";
		try {
			FilesArranger.extracContent(targetFolder);
		} catch (IOException | BoilerpipeProcessingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String FileName = "";
		String TitleName = "";
		new File(desFolder).mkdir();
		try {
			FileUtils.cleanDirectory(new File(desFolder));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int countNum = 0;
		String preDate = "";

		// 按date排序
		File target = new File(targetFolder);
		File[] files = target.listFiles();
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return Long.valueOf(f1.lastModified()).compareTo(
						f2.lastModified());
			}
		});

		HashMap<String, File> titleFileMap = new HashMap<String, File>();
		for (File doc : files) {
			System.out.println(doc.getName());
			if (doc.getName().contains("jj"))
				continue;
			try {
				// System.out.print(doc.getName());
				// 拿到title
				String date = "";
				String title = "";
				Scanner scan = new Scanner(doc);

				String temp = scan.nextLine();
				// int index = temp.indexOf('-');

				date = temp;
				if (!temp.contains("200"))
					continue;
				date = date.replaceAll("\\?", "");

				date = date.substring(5, 15);
				if (scan.hasNext())
					title = scan.nextLine();

				// System.out.println(title);

				// 检验是否重复
				if (titleFileMap.containsKey(title)) {
					File tempF = titleFileMap.get(title);
					boolean flag = FileUtils.contentEquals(doc, tempF);
					if (flag)
						continue;
				} else
					titleFileMap.put(title, doc);
				// 构造 新文件名的路径

				if (!preDate.equals(date)) {
					titleFileMap.clear();
					preDate = date;
				}

				FileName = desFolder + date + "_" + countNum + ".txt";
				TitleName = desFolder + date + "_" + countNum + "_Title.txt";
				// 建新文件
				File f = new File(FileName);
				File titleF = new File(TitleName);
				// 实例化
				f.createNewFile();
				titleF.createNewFile();

				// 写入内容
				FilesArranger.copyFile(doc, f);
				FilesArranger.writeToFile(title, titleF);
				countNum++;
				System.out.println(title);
				// System.out.println(FileName);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
