package antiCyberSquattingTool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JLabel;



public class AntiCyberSquattingTool {

	private JFrame frmAntiCyberSquatting;
	private JTextField textField;
	private JTextField textField_1;
	private String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {



		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AntiCyberSquattingTool window = new AntiCyberSquattingTool();
					window.frmAntiCyberSquatting.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AntiCyberSquattingTool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAntiCyberSquatting = new JFrame();
		frmAntiCyberSquatting.setForeground(Color.ORANGE);
		frmAntiCyberSquatting.setTitle("Anti Cyber Squatting Tool");
		frmAntiCyberSquatting.getContentPane().setBackground(Color.GRAY);
		frmAntiCyberSquatting.setBounds(100, 100, 611, 416);
		frmAntiCyberSquatting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAntiCyberSquatting.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));

		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(175, 275, 150, 47);

		final JButton register = new JButton("REGISTER");
		register.setFont(new Font("Times New Roman", Font.BOLD, 16));

		register.setBackground(Color.ORANGE);
		register.setForeground(Color.WHITE);
		register.setBounds(375, 275, 150, 47);
		register.setEnabled(false);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();

				After_Alogin af = new After_Alogin(str);
				result = af.ret_Gui();
				textField_1.setText(result);
				if(result.equals("Not Registered")){

					register.setEnabled(true);
				}
			}
		});

		frmAntiCyberSquatting.getContentPane().add(btnNewButton);
		frmAntiCyberSquatting.getContentPane().add(register);

		textField = new JTextField();
		textField.setBounds(332, 64, 200, 38);
		frmAntiCyberSquatting.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setBounds(332, 140, 200, 38);
		frmAntiCyberSquatting.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter Domain Name");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(89, 64, 138, 38);
		frmAntiCyberSquatting.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Result");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(89, 151, 138, 27);
		frmAntiCyberSquatting.getContentPane().add(lblNewLabel_1);

		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					FileWriter fout = new FileWriter("C:\\Users\\kanishk\\Desktop\\Java\\ACST\\src\\antiCyberSquattingTool\\trademarks2.txt", true);
					BufferedWriter bw = new BufferedWriter(fout);
					if(!After_Alogin.retRegisteredDomain().equals("")){
						bw.write("\n"+After_Alogin.retRegisteredDomain());
						System.out.println("Domain Name Successfully Registered!");
						textField_1.setText("Successfully Registered!");
					}
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{

					register.setEnabled(false);
					textField.setText("");
				}

			}
		});

	}
}
