package excel;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class BaseExcel {
	protected String xlsFile; // 产生的Excel文件的名称
	ArrayList<MySchool> schoolList = new ArrayList<MySchool>();
	double jigeLine = 60;// 及格线
	double youxiuLine = 80;// 优秀线
	double hegeLine = 40;

	protected double a1 = 0;
	protected double a2 = 0;
	protected double b1 = 0;
	protected double b2 = 0;
	protected double c1 = 0;
	protected double c2 = 0;
	protected double d1 = 0;
	protected double d2 = 0;
	protected double e1 = 0;
	protected double e2 = 0;

	abstract public ArrayList<MySchool> readXls();

	abstract public void writeXls(ArrayList<MySchool> schoolListWrite);

	public void setLine(double hegeLine,double jigeLine, double youxiuLine, double a1,
			double a2, double b1, double b2, double c1, double c2, double d1,
			double d2,double e1,double e2) {
		this.hegeLine = hegeLine;
		this.jigeLine = jigeLine;
		this.youxiuLine = youxiuLine;
		this.a1 = a1;
		this.a2 = a2;
		this.b1 = b1;
		this.b2 = b2;
		this.c1 = c1;
		this.c2 = c2;
		this.d1 = d1;
		this.d2 = d2;
		this.e1 = e1;
		this.e2 = e2;
	}

	public static String[] getCityData(ArrayList<MySchool> schoolList) {

		double totalScore = 0;
		double sum = 0;
		double hegeSum = 0;
		double jigeSum = 0;
		double youxiuSum = 0;
		int section[] = new int[7];
		double ASum = 0;
		double BSum = 0;
		double CSum = 0;
		double DSum = 0;
		double ESum = 0;

		for (int i = 0; i < 7; i++) {
			section[i] = 0;
		}

		for (MySchool mySchool : schoolList) {
			mySchool.preCalculate();
			totalScore += mySchool.getTotalScore();
			sum += mySchool.getSum();
			hegeSum += mySchool.getHegeSum();
			jigeSum += mySchool.getJigeSum();
			youxiuSum += mySchool.getYouxiuSum();
			for (int i = 0; i < 7; i++) {
				section[i] += mySchool.getSection()[i];
			}
			ASum += mySchool.getASum();
			BSum += mySchool.getBSum();
			CSum += mySchool.getCSum();
			DSum += mySchool.getDSum();
			ESum += mySchool.getESum();
		}

		String mean = getScale((totalScore / sum),2);
		String hegePersent = getScale(hegeSum / sum*100,2)+"%("+(int)hegeSum+"人)";
		String jigePersent = getScale(jigeSum / sum*100,2)+"%("+(int)jigeSum+"人)";
		String youxiuPersent = getScale(youxiuSum / sum*100,2)+"%("+(int)youxiuSum+"人)";
		String APersent = getScale(ASum / sum*100,2)+"%("+(int)ASum+"人)";
		String BPersent = getScale(BSum / sum*100,2)+"%("+(int)BSum+"人)";
		String CPersent = getScale(CSum / sum*100,2)+"%("+(int)CSum+"人)";
		String DPersent = getScale(DSum / sum*100,2)+"%("+(int)DSum+"人)";
		String EPersent = getScale(ESum / sum*100,2)+"%("+(int)ESum+"人)";

//		double[] result = { mean, jigePersent * 100, youxiuPersent * 100,
//				section[0], section[1], section[2], section[3], section[4],
//				section[5], section[6], APersent, BPersent,
//				CPersent, DPersent,EPersent };
		String[] result = { mean, hegePersent,jigePersent, youxiuPersent,
				APersent, BPersent,CPersent, DPersent,EPersent };

		return result;

	}

	public ArrayList<MySchool> getSchoolList() {
		return this.schoolList;
	}

	public static String getScale(double num, int scale) {
		return new BigDecimal(num).setScale(scale, BigDecimal.ROUND_HALF_UP)
				.toString();
	}

}
