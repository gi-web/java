package tib;

import java.io.*;

import javax.swing.JFileChooser;

import javax.swing.JOptionPane;



public class ByteStreamDemo 

{

	public static void main(String[] args) 

	{

           File src = fileOpenDlg();

		byte[] imgData = loadImage(src);

		

		File copy = fileSaveDlg();

		saveImage(copy, imgData);

		

		showImage(copy);

	}

	

	private static File fileOpenDlg() 

	{

		JFileChooser chooser = new JFileChooser();

		chooser.setCurrentDirectory(new File("C:/test"));

		

		int returnVal = chooser.showOpenDialog(null);

		if(returnVal == JFileChooser.APPROVE_OPTION)  

//승인하면 선택한 파일을 가져오고 리턴한다.

		{

			File f = chooser.getSelectedFile();

			return f;

		}

		return null;

	}

	

	private static File fileSaveDlg() {

		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setDialogTitle("파일 저장하기"); 

		fileChooser.setSelectedFile(new File("copy.jpg")); // 디폴트 파일이름 제안

		int userSelection = fileChooser.showSaveDialog(null);



		if (userSelection == JFileChooser.APPROVE_OPTION) {

			int n = JOptionPane.showConfirmDialog

(null, "변경된 내용을 저장하시겠어요?", "파일저장확인", 

			JOptionPane.YES_NO_OPTION);

			if(n==JOptionPane.NO_OPTION) return null;

	

			File f = fileChooser.getSelectedFile();

			return f;

		}

		return null;

	}

	

	private static byte[] loadImage(File src){

		try {

			FileInputStream fin = new FileInputStream(src);

			BufferedInputStream bin = new BufferedInputStream(fin);



			byte[] buf = new byte[128];

			ByteArrayOutputStream bout = new ByteArrayOutputStream();

			int cnt = 0;



			while((cnt=bin.read(buf, 0, buf.length))!=-1) {

				bout.write(buf, 0, cnt);

			}



			fin.close();

			bout.close();

			return bout.toByteArray();

			

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}



	private static boolean saveImage(File dest, byte[] buf ) {

		try {

			FileOutputStream fout = new FileOutputStream(dest);

			BufferedOutputStream bout = new BufferedOutputStream(fout);

			bout.write(buf);

			bout.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;

	}

	

	private static void showImage(File imgFile) {

		System.out.println(imgFile.getAbsolutePath());

		String[] param = { "c:\\windows\\system32\\mspaint.exe",                     imgFile.getAbsolutePath()};

   //File.getAbolutePath = 현재 절대경로를 반환함.

		try {

			Runtime.getRuntime().exec(param);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}



