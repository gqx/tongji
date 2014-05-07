package excel;

public class MyClass {
	private String name;
	private String school;
	private double totalScore = 0;
	private int sum = 0;
	private double mean = 0;
	private int jigeSum = 0;
	private int youxiuSum = 0;
	private int hegeSum = 0;
	private double jigePersent = 0;
	private double youxiuPersent = 0;
	private double hegePersent = 0;

	private int ASum = 0;
	private int BSum = 0;
	private int CSum = 0;
	private int DSum = 0;
	private int ESum = 0;
	private double APersent = 0;
	private double BPersent = 0;
	private double CPersent = 0;
	private double DPersent = 0;
	private double EPersent = 0;

	public MyClass() {
	}

	public MyClass(String name, double totalScore, int sum,int hegeSum, int jigeSum,
			int youxiuSum, int ASum, int BSum, int CSum, int DSum, int ESum) {
		this.name = name;
		this.totalScore = totalScore;
		this.sum = sum;
		this.hegeSum = hegeSum;
		this.jigeSum = jigeSum;
		this.youxiuSum = youxiuSum;
		this.ASum = ASum;
		this.BSum = BSum;
		this.CSum = CSum;
		this.DSum = DSum;
		this.ESum = ESum;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
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
