import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;


public class renmin2005 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String targetFolder = "C:\\Users\\penghai\\Desktop\\1\\2005 Part1";
		String desFolder = "C:\\Users\\penghai\\Desktop\\1\\2005�����ձ������\\";

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

		// ��date����
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
			// System.out.println(doc.getName());

			try {

				// �õ�title
				String date="";
				String title = "";
				Scanner scan = new Scanner(doc);
				for(int i=0;i<10;i++)
					scan.nextLine();
				while(scan.hasNext()) {
					String temp = scan.nextLine();
					temp=temp.trim();
					if (!temp.equals("")){
						date = temp;
						date = date.substring(7,17);
						break;
					}
				}
				while(scan.hasNext()) {
					String temp = scan.nextLine();
					temp=temp.trim();
					if (!temp.equals("")){
						title = temp;	
						String temp2= scan.nextLine();
						temp2= temp2.trim();
						if(!temp2.equals(""))
							title = title+temp2;
						break;
					}
				}
				
				// System.out.println(title);

				// �����Ƿ��ظ�
				if (titleFileMap.containsKey(title)) {
					File temp = titleFileMap.get(title);
					boolean flag = FileUtils.contentEquals(doc, temp);
					if (flag)
						continue;
				} else
					titleFileMap.put(title, doc);
				// ���� ���ļ�����·��

				if (!preDate.equals(date)) {
					titleFileMap.clear();
					preDate = date;
				}

				FileName = desFolder + date + "_"+countNum + ".txt";
				TitleName = desFolder + date +"_"+ countNum + "_Title.txt";
				// �����ļ�
				File f = new File(FileName);
				File titleF = new File(TitleName);
				// ʵ����
				f.createNewFile();
				titleF.createNewFile();

				// д������
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
