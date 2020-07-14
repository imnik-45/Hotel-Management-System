package Pack1;

import Pack1.Guest_Info;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signup extends JFrame {
	private static final long serialVersionUID = 1L;

	private JButton signupb, clearb;
	private JPanel sign;
	private JTextField t1, t2, t3, t4, t5, t6, t7;
	private JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8;
	private JRadioButton m, fe;

	private ArrayList<Guest_Info> emplist = new ArrayList<Guest_Info>();
	Guest_Info re;
	Guest_Info r;

	signup() {
		super("Sign Up Here");

		Font f = new Font("Lucida Sans", Font.BOLD, 25);
		Font f2 = new Font("Lucida Sans", Font.BOLD, 22);

		sign = new JPanel();
		sign.setLayout(null);
		setSize(450, 350);
		sign.setBackground(new Color(0, 0, 0, 50));
		sign.setBounds(350, 5, 500, 850);

		l0 = new JLabel("SIGN UP");
		l0.setBounds(210, 0, 250, 50);
		l0.setFont(f2);
		l0.setForeground(Color.WHITE);

		l1 = new JLabel("Name :");
		t1 = new JTextField();
		l1.setFont(f2);
		l1.setForeground(Color.white);
		l1.setBounds(47, 45, 400, 42);
		t1.setFont(f);
		t1.setBounds(50, 86, 400, 45);

		l2 = new JLabel("Password :");
		t2 = new JTextField();
		l2.setFont(f2);
		l2.setForeground(Color.white);
		l2.setBounds(47, 145, 400, 42);
		t2.setFont(f);
		t2.setBounds(50, 186, 400, 45);

		l3 = new JLabel("Email :");
		t3 = new JTextField();
		l3.setFont(f2);
		l3.setForeground(Color.white);
		l3.setBounds(47, 245, 400, 42);
		t3.setFont(f);
		t3.setBounds(50, 286, 400, 45);

		l4 = new JLabel("Aadhar no. :");
		t4 = new JTextField();
		l4.setFont(f2);
		l4.setForeground(Color.white);
		l4.setBounds(47, 345, 400, 42);
		t4.setFont(f);
		t4.setBounds(50, 386, 400, 45);

		l5 = new JLabel("Phone no. :");
		t5 = new JTextField();
		l5.setFont(f2);
		l5.setForeground(Color.white);
		l5.setBounds(47, 445, 400, 42);
		t5.setFont(f);
		t5.setBounds(50, 486, 400, 45);

		l6 = new JLabel("Address :");
		t6 = new JTextField();
		l6.setFont(f2);
		l6.setForeground(Color.white);
		l6.setBounds(47, 545, 400, 42);
		t6.setFont(f);
		t6.setBounds(50, 586, 400, 45);

		l7 = new JLabel("Age :");
		t7 = new JTextField();
		l7.setFont(f2);
		l7.setForeground(Color.white);
		l7.setBounds(47, 645, 400, 42);
		t7.setFont(f);
		t7.setBounds(50, 686, 400, 45);

		l8 = new JLabel("Sex :");
		l8.setFont(f2);
		l8.setForeground(Color.white);
		l8.setBounds(47, 745, 400, 42);
		m = new JRadioButton("Male");
		fe = new JRadioButton("Female");
		ButtonGroup zz = new ButtonGroup();
		zz.add(m);
		zz.add(fe);
		JPanel xx = new JPanel();
		xx.add(m);
		xx.add(fe);
		xx.setBounds(150, 745, 200, 45);
		xx.setBackground(new Color(134, 121, 121, 50));

		sign.add(l0);
		sign.add(l1);
		sign.add(t1);
		sign.add(l2);
		sign.add(t2);
		sign.add(l3);
		sign.add(t3);
		sign.add(l4);
		sign.add(t4);
		sign.add(l5);
		sign.add(t5);
		sign.add(l6);
		sign.add(t6);
		sign.add(l7);
		sign.add(t7);
		sign.add(l8);
		sign.add(xx);

		signupb = new JButton("Register");
		signupb.setForeground(Color.black);
		signupb.setBackground(new Color(134, 121, 121));
		signupb.setFont(f);

		signupb.addActionListener((e) -> {
			if (dataValidation()) {
				
					add();
					new Login_main();
				}
			else {
				JOptionPane.showMessageDialog(null, "please fill the form properly");
			}
		});

		clearb = new JButton("Clear");
		clearb.setForeground(Color.black);
		clearb.setBackground(new Color(134, 121, 121));
		clearb.setFont(f);
		clearb.addActionListener((e) -> {
			this.dispose();
			new signup();
		});

		signupb.setBounds(50, 800, 150, 50);
		sign.add(signupb);
		clearb.setBounds(300, 800, 150, 50);
		sign.add(clearb);

		JLabel bg_img = new JLabel();
		bg_img.setIcon(new ImageIcon(signup.class.getResource("/img7.jpg")));
		bg_img.setBounds(0, 0, 1200, 900);

		add(bg_img);
		bg_img.add(sign);

		setSize(1200, 900);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void add() {

		String id, pass, name, emailid, mobno, address, gender, age;

		id = t4.getText().trim();
		pass = t2.getText().trim();
		name = t1.getText().trim();
		emailid = t3.getText().trim();
		mobno = t5.getText().trim();
		address = t6.getText().trim();
		age = t7.getText().trim();

		gender = "";
		if (m.isSelected()) {
			gender = "Male";
		} else if (fe.isSelected()) {
			gender = "Female";
		}

		re = new Guest_Info(id, pass, name, emailid, mobno, address, gender, age);
		emplist = UserInfoReadWriteFromFile.readObjectFromFile();
		emplist.add(re);
		UserInfoReadWriteFromFile.writeObjecttoFile(emplist);
		JOptionPane.showMessageDialog(this, "Registered,Now you can book Rooms");

	}

	public boolean dataValidation() {
		boolean namevalidation = nameCheck();
		boolean emailvalidation = emilcheck();
		boolean mobnovalidation = mobnocheck();
		boolean passvalidation = passcheck();
		boolean aadharvalidation = aadharcheck();
		boolean agevalidation = agecheck();
		if (namevalidation && emailvalidation && mobnovalidation && passvalidation && aadharvalidation && agevalidation)
			return true;

		return false;
	}

	public boolean nameCheck() {
		boolean namevalid = true;
		String namepattern = "^[a-zA-Z]{3,12}$";

		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(t1.getText().trim());

		String match = sc1.findInLine(namepattern);

		if (match == null) {
			JOptionPane.showMessageDialog(this, "Invalid Name..Please Enter Another Name");
			t1.setText("");
			// t1.setBackground(Color.RED);
			namevalid = false;
		}
		return namevalid;
	}

	public boolean emilcheck() {
		boolean emailvalid = true;
		String emailpattern = "^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$";

		@SuppressWarnings("resource")
		Scanner sc2 = new Scanner(t3.getText().trim());

		String match1 = sc2.findInLine(emailpattern);

		if (match1 == null) {
			JOptionPane.showMessageDialog(this, "Invalid EmailId..Please Enter Another Email");
			t3.setText("");
			// temailid.setBackground(Color.RED);
			emailvalid = false;
		}

		return emailvalid;
	}

	public boolean mobnocheck() {
		boolean mobilenovalid = true;

		String mobnopattern = "^[0-9]{10}$";

		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(t5.getText().trim());

		String match2 = sc3.findInLine(mobnopattern);

		if (match2 == null) {
			JOptionPane.showMessageDialog(this, "Invalid Mobno..Please Enter Another MobNo");
			t5.setText("");
			// tmobno.setBackground(Color.RED);
			mobilenovalid = false;
		}
		return mobilenovalid;
	}

	public boolean aadharcheck() {
		boolean aadharvalid = true;

		String aadharpattern = "^[0-9]{12}$";

		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(t4.getText().trim());

		String match2 = sc3.findInLine(aadharpattern);

		if (match2 == null) {
			JOptionPane.showMessageDialog(this, "Invalid Aadhar number, It should be 12 digits");
			t4.setText("");
			// tmobno.setBackground(Color.RED);
			aadharvalid = false;
		}
		return aadharvalid;
	}

	public boolean passcheck() {
		boolean passvalid = true;

		String passpattern = "^[a-zA-Z0-9]{5}$";

		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(t2.getText().trim());

		String match2 = sc3.findInLine(passpattern);

		if (match2 == null) {
			JOptionPane.showMessageDialog(this, "password must be within 5 characters");
			t2.setText("");
			// tmobno.setBackground(Color.RED);
			passvalid = false;
		}
		return passvalid;
	}

	public boolean agecheck() {
		boolean agevalid = true;

		String agepattern = "^[0-9]{2}$";

		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(t7.getText().trim());

		String match2 = sc3.findInLine(agepattern);

		if (match2 == null) {
			JOptionPane.showMessageDialog(this, "password must be within 5 characters");
			t7.setText("");
			// tmobno.setBackground(Color.RED);
			agevalid = false;
		}
		return agevalid;
	}

	public boolean getinfo() {
		boolean found = false;
		try {
			for (int i = 0; i < emplist.size(); i++) {
				r = emplist.get(i);
				if (t4.getText().equals(emplist.get(i).getId())) {

					found = true;
					break;
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Okay..!!");
		}
		if (found)
			return true;
		else
			return false;
	}

}