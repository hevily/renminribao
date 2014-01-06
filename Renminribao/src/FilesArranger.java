import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;


public class FilesArranger {

	/**
	 * @param args
	 */
	public static void writeToFile(String s, File destFile) throws IOException{
		if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

		FileWriter fw = new FileWriter(destFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(s);
		bw.close();
	}
	
	public static void copyFile(File sourceFile, File destFile) throws IOException {
	    if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

	    FileChannel source = null;
	    FileChannel destination = null;

	    try {
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        destination.transferFrom(source, 0, source.size());
	    }
	    finally {
	        if(source != null) {
	            source.close();
	        }
	        if(destination != null) {
	            destination.close();
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String targetFolder = "C:\\Users\\penghai\\Desktop\\�����ձ�";
		String desFolder = "C:\\Users\\penghai\\Desktop\\�����ձ������\\";
		String guanggaoFolder = "C:\\Users\\penghai\\Desktop\\���\\";
		String tupianFolder = "C:\\Users\\penghai\\Desktop\\ͼƬ����\\";
		
		String FileName = "";
		String TitleName = "";
		try {
			FileUtils.cleanDirectory(new File(desFolder));
			FileUtils.cleanDirectory(new File(tupianFolder));
			FileUtils.cleanDirectory(new File(desFolder));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int countNum = 0;
		String preDate = "";
		
		int countGuanggao = 0;
		int countTupian = 0;
		
		//��date����
		File target = new File(targetFolder);
		File[] files = target.listFiles();
		Arrays.sort(files, new Comparator<File>(){
		    public int compare(File f1, File f2)
		    {
		        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
		    } });
		
		
		HashMap<String, File> titleFileMap = new HashMap<String, File>();
		for(File doc:files){
//			System.out.println(doc.getName());
			
				
			
			
			try {
				
				
				//�õ�title
				Scanner scan = new Scanner(doc);
				String title = scan.nextLine();
				int index = title.indexOf('-');
				title = title.substring(0,index);
				
				
				//�����Ƿ��ظ�
				if(titleFileMap.containsKey(title)){
					File temp = titleFileMap.get(title);
					boolean flag = FileUtils.contentEquals(doc, temp);
					if(flag) continue;
				}
				else
					titleFileMap.put(title, doc);
				
				
				//�������ĺ�title�ļ�
				while(scan.hasNext())
				{
					String line = scan.nextLine();
					if(line.contains("�������ձ�2011"))
						{
						String date = line.substring(5, 18);
						//���� ���ļ�����·��
						
						if(!preDate.equals(date)){
							titleFileMap.clear();
							preDate = date;
						}
						
						if(title.equals("���")){
							FileName = guanggaoFolder + date + countNum+".txt";
							File f = new File(FileName);
							f.createNewFile();
							copyFile(doc,f);
							countGuanggao++;
							break;
						}
						
						if(title.equals("ͼƬ����")){
							FileName = tupianFolder + date + countNum+".txt";
							File f = new File(FileName);
							f.createNewFile();
							copyFile(doc,f);
							countGuanggao++;
							break;
						}
						FileName = desFolder + date + countNum+".txt";
						TitleName = desFolder + date + countNum + "_Title.txt";
						//�����ļ�
						File f = new File(FileName);
						File titleF = new File(TitleName);
						//ʵ����
						f.createNewFile();
						titleF.createNewFile();
						
						//д������
						copyFile(doc,f);
						writeToFile(title,titleF);
						countNum++;
						System.out.println(title);
//						System.out.println(FileName);
						break;
						}
				}
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
