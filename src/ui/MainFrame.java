package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import com.cloudgarden.layout.AnchorConstraint;
import excel.ExcelPost2007Util;
import excel.ExcelPre2007Util;
import excel.MySchool;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainFrame extends javax.swing.JFrame {
	private JPanel topPanel;
	private JButton chooseFileButton;
	private JSpinner jSpinner2;
	private JTextField filePathText;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JSpinner jSpinner1;
	private JButton exportButton;
	private JTabbedPane jTabbedPane1;
	private JButton calculateButton;

	private ClassBasedPanel classPanel;
	private SchoolBasedPanel schoolPanel;
	private String filePath;
	private ArrayList<MySchool> schoolList;
	private SpinnerListModel jigeSpinnerModel;
	private SpinnerListModel youxiuSpinnerModel;
	private SpinnerListModel hegeSpinnerModel;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JSpinner A1Spinner;
	private JSpinner A2Spinner;
	private JSpinner B1Spinner;
	private JSpinner B2Spinner;
	private JSpinner C1Spinner;
	private JSpinner C2Spinner;
	private JSpinner D1Spinner;
	private JSpinner D2Spinner;
	private JSpinner E1Spinner;
	private JSpinner E2Spinner;
	private SpinnerListModel A1SpinnerModel;
	private SpinnerListModel A2SpinnerModel;
	private SpinnerListModel B1SpinnerModel;
	private SpinnerListModel B2SpinnerModel;
	private SpinnerListModel C1SpinnerModel;
	private SpinnerListModel C2SpinnerModel;
	private SpinnerListModel D1SpinnerModel;
	private SpinnerListModel D2SpinnerModel;
	private SpinnerListModel E1SpinnerModel;
	private SpinnerListModel E2SpinnerModel;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel10;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private int FULLSCORE = 150;
	private String A1 = "85";
	private String A2 = "100";
	private JLabel jLabel13;
	private JSpinner jSpinner3;
	private String B1 = "70";
	private String B2 = "85";
	private String C1 = "60";
	private String C2 = "70";
	private String D1 = "40";
	private String D2 = "60";
	private String E1 = "0";
	private String E2 = "40";
	/** 
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame(); 
				// ImageIcon image=new
				// ImageIcon(MainFrame.class.getResource("../../pic/17.png"));
				// inst.setIconImage(Toolkit.getDefaultToolkit().createImage("pic/17.png"));
				// inst.setIconImage(MainFrame.this.getToolKit().getImage("f/image/jg.jpg"));

				inst.setTitle("分数统计工具(单科)");
				inst.setResizable(false);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				topPanel = new JPanel();
				BorderLayout mainFrameLayout = new BorderLayout();
				getContentPane().setLayout(mainFrameLayout);
				getContentPane().add(topPanel, BorderLayout.CENTER);
				topPanel.setPreferredSize(new java.awt.Dimension(792, 545));
				topPanel.setLayout(null);
				{
					filePathText = new JTextField();
					topPanel.add(filePathText, new AnchorConstraint(0, 0, 0, 0,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					filePathText.setBounds(141, 13, 302, 24);
				}
				{
					chooseFileButton = new JButton();
					topPanel.add(chooseFileButton, new AnchorConstraint(0, 0,
							0, 0, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					chooseFileButton.setName("chooseFileButton");
					chooseFileButton.setBounds(449, 12, 86, 25);
					chooseFileButton.setText("选择文件");
					chooseFileButton
							.addActionListener(new choosFileActionListener());
				}
				{
					calculateButton = new JButton();
					topPanel.add(calculateButton, new AnchorConstraint(0, 0, 0,
							0, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					calculateButton.setName("calculateButton");
					calculateButton.setBounds(546, 12, 87, 25);
					calculateButton.setText("开始计算");
					calculateButton
							.addActionListener(new calculateActionListener());
				}
				{
					jTabbedPane1 = new JTabbedPane();
					classPanel = new ClassBasedPanel();
					// classPanel.setData(null);
					schoolPanel = new SchoolBasedPanel();
					// schoolPanel.setData(null);
					jTabbedPane1.add("按班级统计", classPanel);
					classPanel.setPreferredSize(new java.awt.Dimension(794, 338));
					jTabbedPane1.add("按学校统计", schoolPanel);
					topPanel.add(jTabbedPane1, new AnchorConstraint(158, 922,
							905, 18, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jTabbedPane1.setBounds(12, 125, 826, 367);
				}
				{
					exportButton = new JButton();
					topPanel.add(exportButton);
					exportButton.setName("exportButton");
					exportButton.setBounds(378, 507, 81, 27);
					exportButton.setText("保    存");
					exportButton.addActionListener(new saveActionListener());
				}
				{
					String[] jigelist = new String[FULLSCORE];
					for (int i = 0; i < FULLSCORE; i++) {
						

						jigelist[i] = i + "";
					}
					jigeSpinnerModel = new SpinnerListModel(jigelist);
					jigeSpinnerModel.setValue("60");
					jSpinner1 = new JSpinner();
					topPanel.add(jSpinner1);
					jSpinner1.setModel(jigeSpinnerModel);
					jSpinner1.setBounds(388, 54, 58, 22);
					jSpinner1.getEditor().setPreferredSize(
							new java.awt.Dimension(37, 16));
				}
				{
					jLabel1 = new JLabel();
					topPanel.add(jLabel1);
					jLabel1.setBounds(336, 57, 57, 15);
					jLabel1.setName("jLabel1");
					jLabel1.setText("及格线");
				}
				{
					jLabel2 = new JLabel();
					topPanel.add(jLabel2);
					jLabel2.setName("jLabel2");
					jLabel2.setBounds(177, 57, 57, 15);
					jLabel2.setText("优秀线");
				}
				{
					String[] youxiulist = new String[FULLSCORE];
					for (int i = 0; i < FULLSCORE; i++) {
						youxiulist[i] = i + "";
					}
					youxiuSpinnerModel = new SpinnerListModel(youxiulist);
					youxiuSpinnerModel.setValue("80");
					jSpinner2 = new JSpinner();
					topPanel.add(jSpinner2);
					jSpinner2.setModel(youxiuSpinnerModel);
					jSpinner2.setBounds(223, 54, 58, 22);
				}
				
				{
					jLabel3 = new JLabel();
					topPanel.add(jLabel3);
					jLabel3.setText("A类:");
					jLabel3.setName("jLabel3");
					jLabel3.setBounds(24, 94, 29, 15);
				}
				{
					jLabel4 = new JLabel();
					topPanel.add(jLabel4);
					jLabel4.setText("B类:");
					jLabel4.setName("jLabel4");
					jLabel4.setBounds(177, 94, 29, 15);
				}
				{
					jLabel5 = new JLabel();
					topPanel.add(jLabel5);
					jLabel5.setText("C类:");
					jLabel5.setName("jLabel5");
					jLabel5.setBounds(336, 94, 29, 15);
				}
				{
					jLabel6 = new JLabel();
					topPanel.add(jLabel6);
					jLabel6.setText("D类:");
					jLabel6.setName("jLabel6");
					jLabel6.setBounds(497, 94, 29, 15);
				}
				
				{
					String[] A1list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {		
						A1list[i] = i + "";
					}
					A1SpinnerModel = new SpinnerListModel(A1list);
					A1SpinnerModel.setValue(A1);
					A1Spinner = new JSpinner();
					topPanel.add(A1Spinner);
					A1Spinner.setModel(A1SpinnerModel);
					A1Spinner.setBounds(51, 91, 44, 22);
				}
				{
					String[] A2list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {		
						

						A2list[i] = i + "";
					}
					A2SpinnerModel = new SpinnerListModel(A2list);
					A2SpinnerModel.setValue(A2);
					A2Spinner = new JSpinner();
					topPanel.add(A2Spinner);
					A2Spinner.setModel(A2SpinnerModel);
					A2Spinner.setBounds(112, 91, 44, 22);
				}
				{
					String[] B1list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						B1list[i] = i + "";
					}
					B1SpinnerModel = new SpinnerListModel(B1list);
					B1SpinnerModel.setValue(B1);
					B1Spinner = new JSpinner();
					topPanel.add(B1Spinner);
					B1Spinner.setModel(B1SpinnerModel);
					B1Spinner.setBounds(206, 91, 44, 22);
				}
				{
					String[] B2list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {
						B2list[i] = i + "";
					}
					B2SpinnerModel = new SpinnerListModel(B2list);
					B2SpinnerModel.setValue(B2);
					B2Spinner = new JSpinner();
					topPanel.add(B2Spinner);
					B2Spinner.setModel(B2SpinnerModel);
					B2Spinner.setBounds(269, 91, 44, 22);
				}
				{
					String[] C1list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						C1list[i] = i + "";
					}
					C1SpinnerModel = new SpinnerListModel(C1list);
					C1SpinnerModel.setValue(C1);
					C1Spinner = new JSpinner();
					topPanel.add(C1Spinner);
					C1Spinner.setModel(C1SpinnerModel);
					C1Spinner.setBounds(362, 91, 44, 22);
				}
				{
					String[] C2list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {
						C2list[i] = i + "";
					}
					C2SpinnerModel = new SpinnerListModel(C2list);
					C2SpinnerModel.setValue(C2);
					C2Spinner = new JSpinner();
					topPanel.add(C2Spinner);
					C2Spinner.setModel(C2SpinnerModel);
					C2Spinner.setBounds(422, 91, 44, 22);
				}
				{
					String[] D1list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						D1list[i] = i + "";
					}
					D1SpinnerModel = new SpinnerListModel(D1list);
					D1SpinnerModel.setValue(D1);
					D1Spinner = new JSpinner();
					topPanel.add(D1Spinner);
					D1Spinner.setModel(D1SpinnerModel);
					D1Spinner.setBounds(524, 91, 44, 22);
				}
				{
					String[] D2list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {
						D2list[i] = i + "";
					}
					D2SpinnerModel = new SpinnerListModel(D2list);
					D2SpinnerModel.setValue(D2);
					D2Spinner = new JSpinner();
					topPanel.add(D2Spinner);
					D2Spinner.setModel(D2SpinnerModel);
					D2Spinner.setBounds(583, 91, 44, 22);
				}
				{
					jLabel7 = new JLabel();
					topPanel.add(jLabel7);
					jLabel7.setText("~");
					jLabel7.setName("jLabel7");
					jLabel7.setBounds(570, 94, 16, 15);
				}
				{
					jLabel8 = new JLabel();
					topPanel.add(jLabel8);
					jLabel8.setText("~");
					jLabel8.setName("jLabel8");
					jLabel8.setBounds(408, 94, 16, 15);
				}
				{
					jLabel9 = new JLabel();
					topPanel.add(jLabel9);
					jLabel9.setText("~");
					jLabel9.setName("jLabel9");
					jLabel9.setBounds(253, 94, 16, 15);
				}
				{
					jLabel10 = new JLabel();
					topPanel.add(jLabel10);
					jLabel10.setText("~");
					jLabel10.setName("jLabel10");
					jLabel10.setBounds(98, 94, 16, 15);
				}
				{
					String[] E1list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						E1list[i] = i + "";
					}
					E1SpinnerModel = new SpinnerListModel(E1list);
					E1SpinnerModel.setValue(E1);
					E1Spinner = new JSpinner();
					topPanel.add(E1Spinner);
					E1Spinner.setModel(E1SpinnerModel);
					E1Spinner.setBounds(687, 91, 44, 22);
				}
				{
					String[] E2list = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						E2list[i] = i + "";
					}
					E2SpinnerModel = new SpinnerListModel(E2list);
					E2SpinnerModel.setValue(E2);
					E2Spinner = new JSpinner();
					topPanel.add(E2Spinner);
					E2Spinner.setModel(E2SpinnerModel);
					E2Spinner.setBounds(746, 91, 44, 22);
				}
				{
					jLabel11 = new JLabel();
					topPanel.add(jLabel11);
					jLabel11.setText("~");
					jLabel11.setName("jLabel11");
					jLabel11.setBounds(733, 94, 16, 15);
				}
				
				{
					jLabel12 = new JLabel();
					topPanel.add(jLabel12);
					jLabel12.setText("E\u7c7b:");
					jLabel12.setName("jLabel12");
					jLabel12.setBounds(660, 94, 29, 15);
				}
				{
					String[] hegelist = new String[FULLSCORE];
					for (int i = 0; i < FULLSCORE; i++) {
						

						hegelist[i] = i + "";
					}
					hegeSpinnerModel = new SpinnerListModel(hegelist);
					hegeSpinnerModel.setValue("40");
					jSpinner3 = new JSpinner();
					topPanel.add(jSpinner3);
					jSpinner3.setModel(hegeSpinnerModel);
					jSpinner3.setBounds(549, 54, 58, 22);
				}
				{
					jLabel13 = new JLabel();
					topPanel.add(jLabel13);
					jLabel13.setText("\u5408\u683c\u7ebf");
					jLabel13.setName("jLabel13");
					jLabel13.setBounds(497, 57, 57, 15);
				}
				add(topPanel);
			}
			pack();
			this.setSize(866, 583);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}


	class choosFileActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MyFileChooser mfc = new MyFileChooser();
					mfc.setAcceptAllFileFilterUsed(false);
					// 添加excel文件的过滤器
					mfc.addChoosableFileFilter(new ExcelFileFilter2());
					mfc.showOpenDialog(null);
				}
			});
		}
	}

	class calculateActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (filePath != null && !filePath.equals("")) {

				String prefix = filePath
						.substring(filePath.lastIndexOf(".") + 1);
				double hegeLine = Double.parseDouble(hegeSpinnerModel.getValue().toString());
				double jigeLine = Double.parseDouble(jigeSpinnerModel.getValue().toString());
				double youxiuLine = Double.parseDouble(youxiuSpinnerModel.getValue().toString());
				double a1 = Double.parseDouble(A1SpinnerModel.getValue().toString());
				double a2 = Double.parseDouble(A2SpinnerModel.getValue().toString());
				double b1 = Double.parseDouble(B1SpinnerModel.getValue().toString());
				double b2 = Double.parseDouble(B2SpinnerModel.getValue().toString());
				double c1 = Double.parseDouble(C1SpinnerModel.getValue().toString());
				double c2 = Double.parseDouble(C2SpinnerModel.getValue().toString());
				double d1 = Double.parseDouble(D1SpinnerModel.getValue().toString());
				double d2 = Double.parseDouble(D2SpinnerModel.getValue().toString());
				double e1 = Double.parseDouble(E1SpinnerModel.getValue().toString());
				double e2 = Double.parseDouble(E2SpinnerModel.getValue().toString());
				
				if (prefix.equals("xlsx")) {
					ExcelPost2007Util excel = new ExcelPost2007Util(filePath);
					excel.setLine(hegeLine,jigeLine, youxiuLine,a1,a2,b1,b2,c1,c2,d1,d2,e1,e2);
					schoolList = excel.readXls();
				} else if (prefix.equals("xls")) {
					ExcelPre2007Util excel = new ExcelPre2007Util(filePath);
					excel.setLine(hegeLine,jigeLine, youxiuLine,a1,a2,b1,b2,c1,c2,d1,d2,e1,e2);
					schoolList = excel.readXls();
				}

				classPanel.setData(schoolList);
				schoolPanel.setData(schoolList);

			}
		}
	}

	class saveActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MySaveFileChooser mfc = new MySaveFileChooser();
					mfc.setAcceptAllFileFilterUsed(false);
					// 添加excel文件的过滤器
					mfc.addChoosableFileFilter(new ExcelFileFilter("xlsx"));
					// 添加exe文件的过滤器
					mfc.addChoosableFileFilter(new ExcelFileFilter("xls"));
					mfc.showSaveDialog(null);
				}
			});
		}
	}

	public class MyFileChooser extends JFileChooser {
		public void approveSelection() {
			filePath = getSelectedFile().getPath();
			File file = new File(filePath);
			if (file.exists()) {
				super.approveSelection();
				filePathText.setText(file.getAbsolutePath());
			} else {
				JOptionPane.showMessageDialog(null, "你选择的文件不存在，请重新选择！");
			}
		}
	}

	public class MySaveFileChooser extends JFileChooser {
		public void approveSelection() {
			if (schoolList != null) {

				filePath = getSelectedFile().getPath();
				File file = new File(filePath);
				if (file.exists()) {
					JOptionPane.showMessageDialog(null, "文件已存在，请重新选择！");

				} else {					
					super.approveSelection();
					try {
						double hegeLine = Double.parseDouble(hegeSpinnerModel.getValue().toString());
						double jigeLine = Double.parseDouble(jigeSpinnerModel.getValue().toString());
						double youxiuLine = Double.parseDouble(youxiuSpinnerModel.getValue().toString());
						double a1 = Double.parseDouble(A1SpinnerModel.getValue().toString());
						double a2 = Double.parseDouble(A2SpinnerModel.getValue().toString());
						double b1 = Double.parseDouble(B1SpinnerModel.getValue().toString());
						double b2 = Double.parseDouble(B2SpinnerModel.getValue().toString());
						double c1 = Double.parseDouble(C1SpinnerModel.getValue().toString());
						double c2 = Double.parseDouble(C2SpinnerModel.getValue().toString());
						double d1 = Double.parseDouble(D1SpinnerModel.getValue().toString());
						double d2 = Double.parseDouble(D2SpinnerModel.getValue().toString());
						double e1 = Double.parseDouble(E1SpinnerModel.getValue().toString());
						double e2 = Double.parseDouble(E2SpinnerModel.getValue().toString());
						
						if (getFileFilter().getDescription().equals("Microsoft Excel文件(*.xlsx)")) {
							filePath+=".xlsx";
							file = new File(filePath);
							file.createNewFile();
							ExcelPost2007Util excel = new ExcelPost2007Util(filePath);
							excel.setLine(hegeLine,jigeLine, youxiuLine,a1,a2,b1,b2,c1,c2,d1,d2,e1,e2);
							excel.writeXls(schoolList);
						} else if (getFileFilter().getDescription().equals("Microsoft Excel文件(*.xls)")) {
							filePath+=".xls";
							file = new File(filePath);
							file.createNewFile();
							ExcelPre2007Util excel = new ExcelPre2007Util(filePath);
							excel.setLine(hegeLine,jigeLine, youxiuLine,a1,a2,b1,b2,c1,c2,d1,d2,e1,e2);
							excel.writeXls(schoolList);
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static class ExcelFileFilter extends FileFilter {

		String ext;

		// 构造方法的参数是我们需要过滤的文件类型。比如excel文件就是 xls,exe文件是exe.
		ExcelFileFilter(String ext) {
			this.ext = ext;
		}

		/*
		 * 这个方法就是重写 FileFilter 类的方法，参数是File对象，一般这个参数是如何传入的我们可以不用关心。
		 * 他返回一个布尔型。如果为真表示该文件符合过滤设置，那么就会显示在当前目录下，如果为假就会被过滤掉。
		 */
		public boolean accept(File file) {

			// 首先判断该目录下的某个文件是否是目录，如果是目录则返回true，即可以显示在目录下。
			if (file.isDirectory()) {
				return true;
			}

			/*
			 * 获得某个文件的文件名，然后使用lastIndexOf()来获得这个文件名字符串中'.'这个字符最后一次出现的位置。
			 * 并且通过它返回的一个整型来判断该文件是否符合*.*这中文件+文件名的格式，
			 * 如果不符合那么就不显示这个文件。如果符合，那么就将'.'字符后面的字符串提取出来与过滤的文件名相比较，
			 * 如果相等则符合该文件格式，并显示出来。如果不相等那么就将其过滤掉。
			 */
			String fileName = file.getName();
			int index = fileName.lastIndexOf('.');

			if (index > 0 && index < fileName.length() - 1) {
				String extension = fileName.substring(index + 1).toLowerCase();
				if (extension.equals(ext))
					return true;
			}
			return false;
		}

		/*
		 * 这个方法也是重写FileFilter的方法，作用是在过滤名那里显示出相关的信息。
		 * 这个与我们过滤的文件类型想匹配，通过这些信息，可以让用户更清晰的明白需要过滤什么类型的文件。
		 */
		public String getDescription() {

			if (ext.equals("xls")) {
				return "Microsoft Excel文件(*.xls)";
			}
			if (ext.equals("xlsx")) {
				return "Microsoft Excel文件(*.xlsx)";
			}
			return "";
		}
	}
	
	private static class ExcelFileFilter2 extends FileFilter {

		public boolean accept(File file) {

			// 首先判断该目录下的某个文件是否是目录，如果是目录则返回true，即可以显示在目录下。
			if (file.isDirectory()) {
				return true;
			} 

			String fileName = file.getName();
			int index = fileName.lastIndexOf('.');

			if (index > 0 && index < fileName.length() - 1) {
				String extension = fileName.substring(index + 1).toLowerCase();
				if (extension.equals("xlsx") || extension.equals("xls"))
					return true;
			}
			return false;
		}

		public String getDescription() {			
				return "Microsoft Excel文件(*.xlsx, *.xls)";
		}
	}

}
