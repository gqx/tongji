package excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelPost2007Util extends BaseExcel{
	
	FileInputStream fIn;
	XSSFWorkbook readWorkBook;
	XSSFSheet readSheet;

	public ExcelPost2007Util(String filePath) {
		this.xlsFile = filePath;
	}

	public void initRead() {
		try {
			fIn = new FileInputStream(xlsFile);
			readWorkBook = new XSSFWorkbook(fIn);
			readSheet = readWorkBook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeXls(ArrayList<MySchool> schoolListWrite) {
		XSSFWorkbook workbook = new XSSFWorkbook(); // ��������������

		createClassData(schoolListWrite, workbook);
		createSchoolData(schoolListWrite, workbook);

		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(xlsFile);
			workbook.write(fOut);
			fOut.flush();
			fOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("�ļ�����...");
	}

	public void createClassData(ArrayList<MySchool> schoolListWrite,XSSFWorkbook workbook) {
		String A = "A��"+a1+"~"+a2;
		String B = "B��"+b1+"~"+b2;
		String C = "C��"+c1+"~"+c2;
		String D = "D��"+d1+"~"+d2;
		String E = "E��"+e1+"~"+e2;
		String[] tableHead = new String[] { "ѧУ", "�༶", "ƽ����","�ϸ���", "������", "������",A,B,C,D,E };
		XSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "���༶ͳ��");

		XSSFRow headRow = sheet.createRow(0);
		for (int i = 0; i < tableHead.length; i++) {
//			System.out.println(i);
			setRowData(headRow, i, tableHead[i]);
		}

		int i = 1;
		for (MySchool mySchool : schoolListWrite) {
			for (MyClass myClass : mySchool.getMyClassList()) {
				XSSFRow row = sheet.createRow(i);
				setRowData(row, 0, myClass.getSchool());
				setRowData(row, 1, myClass.getName());
				setRowData(row, 2, getScale(myClass.getMean(), 2));
				setRowData(row, 3, getScale(myClass.getHegePersent()*100, 2)+"%("+myClass.getHegeSum()+"��)");
				setRowData(row, 4, getScale(myClass.getJigePersent()*100, 2)+"%("+myClass.getJigeSum()+"��)");
				setRowData(row, 5, getScale(myClass.getYouxiuPersent()*100, 2)+"%("+myClass.getYouxiuSum()+"��)");
				setRowData(row, 6, getScale(myClass.getAPersent()*100, 2)+"%("+myClass.getASum()+"��)");
				setRowData(row, 7, getScale(myClass.getBPersent()*100, 2)+"%("+myClass.getBSum()+"��)");
				setRowData(row, 8, getScale(myClass.getCPersent()*100, 2)+"%("+myClass.getCSum()+"��)");
				setRowData(row, 9, getScale(myClass.getDPersent()*100, 2)+"%("+myClass.getDSum()+"��)");
				setRowData(row, 10, getScale(myClass.getEPersent()*100, 2)+"%("+myClass.getESum()+"��)");
				i++;
			}
		}
	}

	public void createSchoolData(ArrayList<MySchool> schoolListWrite,XSSFWorkbook workbook) {
		String A = "A��"+a1+"~"+a2;
		String B = "B��"+b1+"~"+b2;
		String C = "C��"+c1+"~"+c2;
		String D = "D��"+d1+"~"+d2;
		String E = "E��"+e1+"~"+e2;
//		String[] tableHead = new String[] { "ѧУ", "ƽ����", "������", "������", "0-40",
//				"40-50", "50-60", "60-70", "70-80", "80-90", "90-100",A,B,C,D,E };
		String[] tableHead = new String[] { "ѧУ", "ƽ����","�ϸ���", "������", "������",A,B,C,D,E };
		XSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(1, "��ѧУͳ��");

		// ����һ��
		XSSFRow headRow = sheet.createRow(0);
		for (int i = 0; i < tableHead.length; i++) {
			setRowData(headRow, i, tableHead[i]);
		}

		int i = 1;
		for (MySchool mySchool : schoolListWrite) {
			mySchool.preCalculate();
			XSSFRow row = sheet.createRow(i);
			setRowData(row, 0, mySchool.getName());
			setRowData(row, 1, getScale(mySchool.getMean(), 2));
			setRowData(row, 2, getScale(mySchool.getHegePersent()*100, 2)+"%("+mySchool.getHegeSum()+"��)");
			setRowData(row, 3, getScale(mySchool.getJigePersent()*100, 2)+"%("+mySchool.getJigeSum()+"��)");
			setRowData(row, 4, getScale(mySchool.getYouxiuPersent()*100, 2)+"%("+mySchool.getYouxiuSum()+"��)");
//			setRowData(row, 4, mySchool.getSection()[0] + "");
//			setRowData(row, 5, mySchool.getSection()[1] + "");
//			setRowData(row, 6, mySchool.getSection()[2] + "");
//			setRowData(row, 7, mySchool.getSection()[3] + "");
//			setRowData(row, 8, mySchool.getSection()[4] + "");
//			setRowData(row, 9, mySchool.getSection()[5] + "");
//			setRowData(row, 10, mySchool.getSection()[6] + "");
			setRowData(row, 5, mySchool.getAPersent()*100 +"%("+mySchool.getASum()+"��)");
			setRowData(row, 6, mySchool.getBPersent()*100 +"%("+mySchool.getBSum()+"��)");
			setRowData(row, 7, mySchool.getCPersent()*100 +"%("+mySchool.getCSum()+"��)");
			setRowData(row, 8, mySchool.getDPersent()*100 +"%("+mySchool.getDSum()+"��)");
			setRowData(row, 9, mySchool.getEPersent()*100 +"%("+mySchool.getESum()+"��)");
			i++;
		}
		
		String[] cityData = getCityData(schoolListWrite);
		XSSFRow row = sheet.createRow(i);
		setRowData(row, 0, "�ܼ�");
		for(int j = 0;j < cityData.length;j++){
			setRowData(row, j+1, cityData[j]);
		}
	}

	private void setRowData(XSSFRow row, int cellIndex, String value) {
		// ����һ����Ԫ��
		XSSFCell cell = row.createCell(cellIndex);
		// ���õ�Ԫ������Ϊ�ַ�����
		cell.setCellType(XSSFCell.CELL_TYPE_STRING);
		// Ϊ�����ڵ�Ԫ����д�����ģ������ַ�����ΪUTF_16��
		// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		// ����һ����Ԫ����д����Ϣ
		cell.setCellValue(value);
	}

	public ArrayList<MySchool> readXls() {
		initRead();

		java.util.Iterator<Row> rowIterator = readSheet.rowIterator();
		XSSFRow readRow;

//		int rowsNum = readSheet.getPhysicalNumberOfRows();
//		System.out.println("�ܹ�������" + rowsNum);

		String currentSchool = "";
		String currentClass = "";
		double totalScore = 0;// �༶�ܷ�
		int sum = 0;// �༶������
		int hegeSum = 0;
		int jigeSum = 0;// �༶����������
		int youxiuSum = 0;// �༶����������
		int ASum = 0;
		int BSum = 0;
		int CSum = 0;
		int DSum = 0;
		int ESum = 0;
		boolean start = true;

		while (rowIterator.hasNext()) {
			readRow = (XSSFRow) rowIterator.next();
			String newSchool = readRow.getCell(0).getStringCellValue();
			String newClass = readRow.getCell(1).getStringCellValue();
			if (start) {
				currentSchool = newSchool;
				currentClass = newClass;
				MySchool mySchool = new MySchool();
				mySchool.setName(currentSchool);
				schoolList.add(mySchool);
				start = false;
			}
			double score = readRow.getCell(2).getNumericCellValue();

			if (!newSchool.equals(currentSchool)
					|| !newClass.equals(currentClass)) {
				MyClass myClass = new MyClass(currentClass, totalScore, sum,hegeSum, jigeSum, youxiuSum,ASum,BSum,CSum,DSum,ESum);
				schoolList.get(schoolList.size() - 1).addClass(myClass);

				if (!newSchool.equals(currentSchool)) {
					MySchool mySchool = new MySchool();
					mySchool.setName(newSchool);
					schoolList.add(mySchool);
				}

				currentSchool = newSchool;
				currentClass = newClass;
				totalScore = 0;
				sum = 0;
				hegeSum = 0;
				youxiuSum = 0;
				jigeSum = 0;
				ASum = 0;
				BSum = 0;
				CSum = 0;
				DSum = 0;
				ESum = 0;
			}

//			if (score < 40) {
//				schoolList.get(schoolList.size() - 1).getSection()[0]++;
//			} else if (40 <= score && score < 50) {
//				schoolList.get(schoolList.size() - 1).getSection()[1]++;
//			} else if (50 <= score && score < 60) {
//				schoolList.get(schoolList.size() - 1).getSection()[2]++;
//			} else if (60 <= score && score < 70) {
//				schoolList.get(schoolList.size() - 1).getSection()[3]++;
//			} else if (70 <= score && score < 80) {
//				schoolList.get(schoolList.size() - 1).getSection()[4]++;
//			} else if (80 <= score && score < 90) {
//				schoolList.get(schoolList.size() - 1).getSection()[5]++;
//			} else if (90 <= score) {
//				schoolList.get(schoolList.size() - 1).getSection()[6]++;
//			}
			if (score >= hegeLine) hegeSum++;
			
			if (score >= jigeLine) jigeSum++;

			if (score >= youxiuLine) youxiuSum++;
			
			if(a1 <= score && score <= a2)ASum++;
			
			if(b1 <= score && score < b2)BSum++;		
			
			if(c1 <= score && score < c2)CSum++;		
			
			if(d1 <= score && score < d2)DSum++;
			
			if(e1 <= score && score < e2)ESum++;
			

			totalScore += score;
			sum++;
		}

		MyClass myClass = new MyClass(currentClass, totalScore, sum,hegeSum, jigeSum,youxiuSum,ASum,BSum,CSum,DSum,ESum);
		schoolList.get(schoolList.size() - 1).addClass(myClass);

		return schoolList;
	}


//	public void output() {
//		for (MySchool mySchool : schoolList) {
//			for (MyClass myClass : mySchool.getMyClassList()) {
//				System.out.println("A" + myClass.getSchool() + " "
//						+ myClass.getName() + "  " + myClass.getMean() + "  "
//						+ myClass.getJigePersent() + "  "
//						+ myClass.getYouxiuPersent());
//			}
//			mySchool.preCalculate();
//			System.out.println(mySchool.getYouxiuSum() + " "
//					+ mySchool.getSum());
//			System.out.println("B" + mySchool.getMean() + " "
//					+ mySchool.getJigePersent() + " "
//					+ mySchool.getYouxiuPersent() + " "
//					+ mySchool.getSection()[0] + " " + mySchool.getSection()[1]
//					+ " " + mySchool.getSection()[2] + " "
//					+ mySchool.getSection()[3] + " " + mySchool.getSection()[4]
//					+ " " + mySchool.getSection()[5] + " "
//					+ mySchool.getSection()[6]);
//		}
//
//	}


}
