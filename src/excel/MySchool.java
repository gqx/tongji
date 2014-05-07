package excel;

import java.util.ArrayList;

public class MySchool {

	ArrayList<MyClass> myClassList = new ArrayList<MyClass>();
	String name;
	double totalScore = 0;
	int sum = 0;
	double mean = 0;
	int jigeSum = 0;
	int youxiuSum = 0;
	int hegeSum = 0;
	double jigePersent = 0;
	double youxiuPersent = 0;
	double hegePersent = 0;
	int[] section = { 0, 0, 0, 0, 0, 0, 0 };
	int ASum = 0;
	int BSum = 0;
	int CSum = 0;
	int DSum = 0;
	int ESum = 0;
	double APersent = 0;
	double BPersent = 0;
	double CPersent = 0;
	double DPersent = 0;
	double EPersent = 0;

	public void preCalculate() {
		totalScore = 0;
		sum = 0;
		hegeSum = 0;
		jigeSum = 0;
		youxiuSum = 0;
		ASum = 0;
		BSum = 0;
		CSum = 0;
		DSum = 0;
		ESum = 0;
		for (MyClass myClass : myClassList) {
			totalScore += myClass.getTotalScore();
			sum += myClass.getSum();
			hegeSum += myClass.getHegeSum();
			jigeSum += myClass.getJigeSum();
			youxiuSum += myClass.getYouxiuSum();
			ASum += myClass.getASum();
			BSum += myClass.getBSum();
			CSum += myClass.getCSum();
			DSum += myClass.getDSum();
			ESum += myClass.getESum();
		}
	}

	public void calculateMean() {
		mean = (double) totalScore / sum;
	}

	public void calculateHegePersent() {
		hegePersent = (double) hegeSum / sum;
	}

	public void calculateJigePersent() {
		jigePersent = (double) jigeSum / sum;
	}

	public void calculateYouxiuPersent() {
		youxiuPersent = (double) youxiuSum / sum;
	}

	public void calculateAPersent() {
		APersent = (double) ASum / sum;
	}

	public void calculateBPersent() {
		BPersent = (double) BSum / sum;
	}

	public void calculateCPersent() {
		CPersent = (double) CSum / sum;
	}

	public void calculateDPersent() {
		DPersent = (double) DSum / sum;
	}

	public void calculateEPersent() {
		EPersent = (double) ESum / sum;
	}

	public void addClass(MyClass myClass) {
		myClass.setSchool(name);
		this.myClassList.add(myClass);
	}

	public int[] getSection() {
		return section;
	}

	public void setSection(int[] section) {
		this.section = section;
	}

	public ArrayList<MyClass> getMyClassList() {
		return myClassList;
	}

	public void setMyClassList(ArrayList<MyClass> myClassList) {
		this.myClassList = myClassList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getMean() {
		calculateMean();
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public int getHegeSum() {
		return hegeSum;
	}

	public void setHegeSum(int hegeSum) {
		this.hegeSum = hegeSum;
	}

	public double getHegePersent() {
		calculateHegePersent();
		return hegePersent;
	}

	public void setHegePersent(double hegePersent) {
		this.hegePersent = hegePersent;
	}

	public int getJigeSum() {
		return jigeSum;
	}

	public void setJigeSum(int jigeSum) {
		this.jigeSum = jigeSum;
	}

	public int getYouxiuSum() {
		return youxiuSum;
	}

	public void setYouxiuSum(int youxiuSum) {
		this.youxiuSum = youxiuSum;
	}

	public double getJigePersent() {
		calculateJigePersent();
		return jigePersent;
	}

	public void setJigePersent(double jigePersent) {
		this.jigePersent = jigePersent;
	}

	public double getYouxiuPersent() {
		calculateYouxiuPersent();
		return youxiuPersent;
	}

	public void setYouxiuPersent(double youxiuPersent) {
		this.youxiuPersent = youxiuPersent;
	}

	public int getASum() {
		return ASum;
	}

	public void setASum(int aSum) {
		ASum = aSum;
	}

	public int getBSum() {
		return BSum;
	}

	public void setBSum(int bSum) {
		BSum = bSum;
	}

	public int getCSum() {
		return CSum;
	}

	public void setCSum(int cSum) {
		CSum = cSum;
	}

	public int getDSum() {
		return DSum;
	}

	public void setDSum(int dSum) {
		DSum = dSum;
	}

	public int getESum() {
		return ESum;
	}

	public void setESum(int eSum) {
		ESum = eSum;
	}

	public double getAPersent() {
		calculateAPersent();
		return APersent;
	}

	public void setAPersent(double aPersent) {
		APersent = aPersent;
	}

	public double getBPersent() {
		calculateBPersent();
		return BPersent;
	}

	public void setBPersent(double bPersent) {
		BPersent = bPersent;
	}

	public double getCPersent() {
		calculateCPersent();
		return CPersent;
	}

	public void setCPersent(double cPersent) {
		CPersent = cPersent;
	}

	public double getDPersent() {
		calculateDPersent();
		return DPersent;
	}

	public void setDPersent(double dPersent) {
		DPersent = dPersent;
	}

	public double getEPersent() {
		calculateEPersent();
		return EPersent;
	}

	public void setEPersent(double ePersent) {
		EPersent = ePersent;
	}

}
