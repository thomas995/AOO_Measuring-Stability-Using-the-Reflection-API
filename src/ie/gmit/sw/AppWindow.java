package ie.gmit.sw;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @author Thomas
 *
 */
public class AppWindow
{
	private JFrame frame;
	private AppSummary as;

	/**
	 * 
	 */
	public AppWindow()
	{
		//Create a window for the application
		frame = new JFrame();
		frame.setTitle("B.Sc. in Software Development - GMIT");
		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());

        //The file panel will contain the file chooser
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));
        top.setBorder(new javax.swing.border.TitledBorder("Select File to Encode"));
        top.setPreferredSize(new java.awt.Dimension(500, 100));
        top.setMaximumSize(new java.awt.Dimension(500, 100));
        top.setMinimumSize(new java.awt.Dimension(500, 100));

        final JTextField txtFileName =  new JTextField(20);
		txtFileName.setPreferredSize(new java.awt.Dimension(100, 30));
		txtFileName.setMaximumSize(new java.awt.Dimension(100, 30));
		txtFileName.setMargin(new java.awt.Insets(2, 2, 2, 2));
		txtFileName.setMinimumSize(new java.awt.Dimension(100, 30));

		JButton btnChooseFile = new JButton("Browse...");
		btnChooseFile.setToolTipText("Select File to Encode");
        btnChooseFile.setPreferredSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMaximumSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnChooseFile.setMinimumSize(new java.awt.Dimension(90, 30));
		btnChooseFile.addActionListener(new java.awt.event.ActionListener()
		{
            public void actionPerformed(ActionEvent evt)
            {
        		JFileChooser fc = new JFileChooser("./");
        		int returnVal = fc.showOpenDialog(frame);
            	if (returnVal == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile().getAbsoluteFile();
                	String name = file.getAbsolutePath();
                	txtFileName.setText(name);
                	System.out.println("You selected the following file: " + name);
            	}
			}
        });

		// Button on Panel called JAR stats which displays the classes of the jar and the different attributes within each
		JButton btnJAR = new JButton("JAR Stats");
		btnJAR.setToolTipText("Look at what is contained within the JAR(one is already selected by default)");
		btnJAR.setPreferredSize(new java.awt.Dimension(150, 30));
		btnJAR.setMaximumSize(new java.awt.Dimension(150, 30));
		btnJAR.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnJAR.setMinimumSize(new java.awt.Dimension(150, 30));
		btnJAR.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent evt)
            {

                // if Jar name is not blank
            	if(txtFileName.getText().length() > 1)
            	{

                    // reads in jar read in from above
                    MetricsCheckerCalc basicMetricCalculator = new MetricsCheckerCalc(txtFileName.getText());

                    // create the summary
                    as =  new AppSummary(frame, true);

                    // get handle on summary table model
                    TypeSummaryTableModel tModel = as.getTableModel();

                    // add metric data into table model
                    tModel.setTableData(basicMetricCalculator.getMetricData());

                    // make the dialog visible
                    as.setVisible(true);

                }
            	else
            	// Displays the content and attributes of each class in the jar to the console
                {
            		// try catches on all the classes in the default JAR
            		try
            		{
						AlgStrsRefl.ReflRefAlgStrs();
					} catch (FileNotFoundException e)
            		{
						e.printStackTrace();
					} catch (ClassNotFoundException e)
            		{
						e.printStackTrace();
					} catch (IOException e)
            		{
						e.printStackTrace();
					}
    			    try
    			    {
						AssignAJobRefl.ReflRefAssignAJob();
					}
    			    catch (FileNotFoundException e1)
    			    {
						e1.printStackTrace();
					}

    			    catch (ClassNotFoundException e1)
    			    {
						e1.printStackTrace();
					}
    			    catch (IOException e1)
    			    {
						e1.printStackTrace();
					}
    			    try
    			    {
						compStringableImplRefl.ReflRefCompStringableImpl();
					}
    			    catch (FileNotFoundException e1)
    			    {
						e1.printStackTrace();
					}
    			    catch (ClassNotFoundException e1)
    			    {

						e1.printStackTrace();
					}
    			    catch (IOException e1)
    			    {


						e1.printStackTrace();
					}
    			    try
    			    {
						compStringableRefl.ReflRefCompStringable();
					}
    			    catch (FileNotFoundException e1)
    			    {

						e1.printStackTrace();
					}
    			    catch (ClassNotFoundException e1)
    			    {

						e1.printStackTrace();
					}
    			    catch (IOException e1)
    			    {

						e1.printStackTrace();
					}
    			    try
    			    {
						resultatorimplRefl.ReflRefResultatorImpl();
					}
    			    catch (FileNotFoundException e1)
    			    {

						e1.printStackTrace();
					}
    			    catch (ClassNotFoundException e1)
    			    {

						e1.printStackTrace();
					}
    			    catch (IOException e1)
    			    {

						e1.printStackTrace();
					}
    			    try
    			    {
						resultatorRefl.ReflRefResultator();
					}
    			    catch (FileNotFoundException e1)
    			    {

						e1.printStackTrace();
					}
    			    catch (ClassNotFoundException e1)
    			    {

						e1.printStackTrace();
					}
    			    catch (IOException e1)
    			    {

						e1.printStackTrace();
					}
    			    try
    			    {
						strCompRunnerRefl.ReflRefStrCompRunner();
					}
    			    catch (FileNotFoundException e)
    			    {

						e.printStackTrace();
					}
    			    catch (ClassNotFoundException e)
    			    {

						e.printStackTrace();
					}
    			    catch (IOException e)
    			    {

						e.printStackTrace();
					}
    			    try
    			    {
						stringserviceimplRefl.ReflRefStringServiceImpl();
					} catch (FileNotFoundException e)
    			    {

						e.printStackTrace();
					}
    			    catch (ClassNotFoundException e)
    			    {

						e.printStackTrace();
					}
    			    catch (IOException e)
    			    {

						e.printStackTrace();
					}
    			    try
    			    {
						stringserviceRefl.ReflRefStringService();
					} catch (FileNotFoundException e)
    			    {

						e.printStackTrace();
					} catch (ClassNotFoundException e)
    			    {

						e.printStackTrace();

					} catch (IOException e)
    			    {

						e.printStackTrace();
					}

                } // if

			}
        });



        top.add(txtFileName);
        top.add(btnChooseFile);
        top.add(btnJAR);
        frame.getContentPane().add(top);


        //A separate panel for the programme output
        JPanel mid = new JPanel(new FlowLayout(FlowLayout.LEADING));
        mid.setBorder(new BevelBorder(BevelBorder.RAISED));
        mid.setPreferredSize(new java.awt.Dimension(500, 300));
        mid.setMaximumSize(new java.awt.Dimension(500, 300));
        mid.setMinimumSize(new java.awt.Dimension(500, 300));

        CustomControl cc = new CustomControl(new java.awt.Dimension(500, 300));
        cc.setBackground(Color.WHITE);
        cc.setPreferredSize(new java.awt.Dimension(300, 300));
        cc.setMaximumSize(new java.awt.Dimension(300, 300));
        cc.setMinimumSize(new java.awt.Dimension(300, 300));
        mid.add(cc);
		frame.getContentPane().add(mid);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setPreferredSize(new java.awt.Dimension(500, 50));
        bottom.setMaximumSize(new java.awt.Dimension(500, 50));
        bottom.setMinimumSize(new java.awt.Dimension(500, 50));

        JButton btnDialog = new JButton("Show Dialog"); //Create Quit button


        JButton btnQuit = new JButton("Quit"); //Create Quit button
        btnQuit.addActionListener(new java.awt.event.ActionListener()
        {
        public void actionPerformed(ActionEvent evt)
        {
        	System.exit(0);
        }
    });
        bottom.add(btnDialog);
        bottom.add(btnQuit);

        frame.getContentPane().add(bottom);
		frame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new AppWindow();
	}
}