package ui;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import excel.BaseExcel;
import excel.MySchool;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SchoolBasedPanel extends javax.swing.JPanel {
	private JScrollPane jScrollPane1;
	private JTable jTable1;
//	private String[] tableHead = new String[] { "学校","平均分","及格率","优秀率","0-40","40-50","50-60","60-70","70-80","80-90","90-100","A类","B类","C类","D类","E类" };
	private String[] tableHead = new String[] { "学校","平均分","合格率","及格率","优秀率","A类","B类","C类","D类","E类" };
    private String[][] tableContent;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SchoolBasedPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public SchoolBasedPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(577, 388));
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1, new AnchorConstraint(1, 1000, 1001, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(577, 388));
				jScrollPane1.setName("jScrollPane1");
				{
					TableModel jTable1Model = 
						new DefaultTableModel(
								tableContent,
	        					tableHead);
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setData(ArrayList<MySchool> schoolList){
		int length = schoolList.size();	
		tableContent = new String[length+1][10];
		int i = 0;
		for(MySchool mySchool:schoolList){
			mySchool.preCalculate();
			tableContent[i][0] = mySchool.getName();
			tableContent[i][1] = getScale(mySchool.getMean(),2);
			tableContent[i][2] = getScale(mySchool.getHegePersent()*100,2)+"%("+mySchool.getHegeSum()+"人)";
			tableContent[i][3] = getScale(mySchool.getJigePersent()*100,2)+"%("+mySchool.getJigeSum()+"人)";
			tableContent[i][4] = getScale(mySchool.getYouxiuPersent()*100,2)+"%("+mySchool.getYouxiuSum()+"人)";
//			tableContent[i][4] = mySchool.getSection()[0]+"";
//			tableContent[i][5] = mySchool.getSection()[1]+"";
//			tableContent[i][6] = mySchool.getSection()[2]+"";
//			tableContent[i][7] = mySchool.getSection()[3]+"";
//			tableContent[i][8] = mySchool.getSection()[4]+"";
//			tableContent[i][9] = mySchool.getSection()[5]+"";
//			tableContent[i][10] = mySchool.getSection()[6]+"";
			tableContent[i][5] = getScale(mySchool.getAPersent()*100,2)+"%("+mySchool.getASum()+"人)";
			tableContent[i][6] = getScale(mySchool.getBPersent()*100,2)+"%("+mySchool.getBSum()+"人)";
			tableContent[i][7] = getScale(mySchool.getCPersent()*100,2)+"%("+mySchool.getCSum()+"人)";
			tableContent[i][8] = getScale(mySchool.getDPersent()*100,2)+"%("+mySchool.getDSum()+"人)";
			tableContent[i][9] = getScale(mySchool.getEPersent()*100,2)+"%("+mySchool.getESum()+"人)";
			i++;	
		}
		
		String[] cityData = BaseExcel.getCityData(schoolList);
		tableContent[i][0] = "总计";
		for(int j = 0;j< cityData.length;j++){
			tableContent[i][j+1] = cityData[j];

		}
		
		
		TableModel jTable1Model = 
			new DefaultTableModel(
					tableContent,
					tableHead);
		jTable1.setModel(jTable1Model);
	}
	
	
	
	public String getScale(double num, int scale){
		return new BigDecimal(num).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}
}
