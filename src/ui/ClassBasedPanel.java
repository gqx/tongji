package ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import excel.MyClass;
import excel.MySchool;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


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
public class ClassBasedPanel extends javax.swing.JPanel {
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private String[] tableHead = new String[] { "学校", "班级","平均分","合格率","及格率","优秀率","A类","B类","C类","D类","E类"};
    private String[][] tableContent;
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ClassBasedPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ClassBasedPanel() {
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
				jScrollPane1.setName("jScrollPane1");
				jScrollPane1.setPreferredSize(new java.awt.Dimension(577, 388));
				
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
		int length = 0;
		for(MySchool mySchool:schoolList){
			length+=mySchool.getMyClassList().size();
		}
		
		tableContent = new String[length][11];
		int i = 0;
		for(MySchool mySchool:schoolList){
			for(MyClass myClass : mySchool.getMyClassList()){
				
				tableContent[i][0] = myClass.getSchool();
				tableContent[i][1] = myClass.getName();
				tableContent[i][2] = getScale(myClass.getMean(),2);
				tableContent[i][3] = getScale(myClass.getHegePersent()*100,2)+"%("+myClass.getHegeSum()+"人)";
				tableContent[i][4] = getScale(myClass.getJigePersent()*100,2)+"%("+myClass.getJigeSum()+"人)";
				tableContent[i][5] = getScale(myClass.getYouxiuPersent()*100,2)+"%("+myClass.getYouxiuSum()+"人)";
				tableContent[i][6] = getScale(myClass.getAPersent()*100,2)+"%("+myClass.getASum()+"人)";
				tableContent[i][7] = getScale(myClass.getBPersent()*100,2)+"%("+myClass.getBSum()+"人)";
				tableContent[i][8] = getScale(myClass.getCPersent()*100,2)+"%("+myClass.getCSum()+"人)";
				tableContent[i][9] = getScale(myClass.getDPersent()*100,2)+"%("+myClass.getDSum()+"人)";
				tableContent[i][10] = getScale(myClass.getEPersent()*100,2)+"%("+myClass.getESum()+"人)";
//				System.out.println("A"+myClass.getSchool()+" "+myClass.getName()+"  "+myClass.getMean()+"  "+myClass.getJigePersent()+"  "+myClass.getYouxiuPersent());
				i++;
			}
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
