import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BloodMain extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField bloodgroup;
	private JTextField address;
	private JTextField lastdonation;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodMain frame = new BloodMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	Connection c = null;
	private JTextField blodgroup;
	private JTable searchtable;
	private JTextField i;
	private JTextField na;
	private JTextField bg;
	private JTextField ad;
	private JTextField ld;
	private JTextField pn;
	private JTable table;
	private JTable table_1;
	private JTable updatetable;
	private JButton btnShow;
	
	
	public BloodMain() throws SQLException {
		
		
		c=DriverManager.getConnection("JDBC:sqlite:F:\\Projects\\Workspace\\Blood Donation\\BloodDonation.sqlite");
		JOptionPane.showMessageDialog(null, "Connect Successfully");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnFile.add(mntmDelete);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBloodDonation = new JLabel("BLOOD DONATION");
		lblBloodDonation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodDonation.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblBloodDonation.setBounds(10, 0, 981, 76);
		contentPane.add(lblBloodDonation);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(106, 298, -21, 143);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(54, 77, -46, 24);
		contentPane.add(tabbedPane_1);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(214, 132, 5, 5);
		contentPane.add(tabbedPane_2);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tabbedPane_3.setBounds(20, 87, 906, 510);
		contentPane.add(tabbedPane_3);
		
		JPanel panel = new JPanel();
		tabbedPane_3.addTab("ADD DONER", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblAddDonationPerson = new JLabel("ADD DONATION PERSON INFORMATION");
		lblAddDonationPerson.setForeground(Color.BLUE);
		lblAddDonationPerson.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDonationPerson.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAddDonationPerson.setBounds(0, 57, 720, 92);
		panel.add(lblAddDonationPerson);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(25, 194, 118, 35);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(205, 194, 164, 35);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblId = new JLabel("NAME");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(25, 260, 118, 35);
		panel.add(lblId);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(205, 260, 164, 35);
		panel.add(name);
		
		JLabel lblBgroup = new JLabel("BLOOD GROUP");
		lblBgroup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBgroup.setBounds(25, 308, 170, 35);
		panel.add(lblBgroup);
		
		bloodgroup = new JTextField();
		bloodgroup.setColumns(10);
		bloodgroup.setBounds(205, 308, 164, 35);
		panel.add(bloodgroup);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddress.setBounds(25, 360, 118, 35);
		panel.add(lblAddress);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(205, 360, 164, 35);
		panel.add(address);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhone.setBounds(25, 415, 149, 35);
		panel.add(lblPhone);
		
		lastdonation = new JTextField();
		lastdonation.setColumns(10);
		lastdonation.setBounds(550, 197, 156, 35);
		panel.add(lastdonation);
		
		JLabel lblLastDonation = new JLabel("Last Donation");
		lblLastDonation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLastDonation.setBounds(421, 194, 149, 35);
		panel.add(lblLastDonation);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(205, 418, 164, 35);
		panel.add(phone);
		
		JButton AddDoner = new JButton("ADD DONER");
		AddDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                 String i=id.getText(); 
        		 String nam=name.getText(); 
        		 String bgrou=bloodgroup.getText(); 
        		 String addres=address.getText();
        		 String phon = phone.getText(); 
        		 String lastdon=lastdonation.getText(); 
        		 
        		
        		 String query = "insert into blooddoner(ID,Name,Bgroup,Address,Phone,LastDonation)"
        			+"values ('"+i+"','"+nam+"','"+bgrou+"','"+addres+"','"+phon+"','"+lastdon+"')";	
        		 
        		 try {
        			Statement st = c.createStatement();
        			st.execute(query);
        			JOptionPane.showMessageDialog(null, "DoNER ADD ");
        		 } catch (SQLException e) {
        			 e.printStackTrace();
        		 }
 				
				
			}
		});
		AddDoner.setBackground(Color.BLUE);
		AddDoner.setForeground(Color.BLACK);
		AddDoner.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AddDoner.setBounds(535, 327, 177, 35);
		panel.add(AddDoner);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLUE);
		tabbedPane_3.addTab("SEARCH", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblBloodgroup = new JLabel("BLOODGROUP");
		lblBloodgroup.setBounds(266, 5, 144, 24);
		lblBloodgroup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblBloodgroup);
		
		blodgroup = new JTextField();
		blodgroup.setBounds(290, 40, 91, 26);
		blodgroup.setColumns(10);
		panel_1.add(blodgroup);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bgrou=bloodgroup.getText();
				String query1 ="select * from blooddoner where bgroup='"+bgrou+"'";	
	        		 try {
	        			Statement st1 = c.createStatement();
	        			
	        			ResultSet rs = st1.executeQuery(query1);
	        			searchtable.setModel(DbUtils.resultSetToTableModel(rs));
	        		 } catch (SQLException e) {
	        			 e.printStackTrace();
	        		 }
			}
		});
		
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setBounds(409, 38, 97, 31);
		panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-26, 77, 655, 379);
		panel_1.add(scrollPane);
		
		searchtable = new JTable();
		scrollPane.setViewportView(searchtable);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_3.addTab("UPDATE", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, -138, 767, 643);
		panel_2.add(panel_3);
		
		JLabel label = new JLabel("ADD DONATION PERSON INFORMATION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 30));
		label.setBounds(0, 57, 720, 92);
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_1.setBounds(10, 191, 92, 24);
		panel_3.add(label_1);
		
		i = new JTextField();
		i.setColumns(10);
		i.setBounds(205, 194, 164, 24);
		panel_3.add(i);
		
		JLabel label_2 = new JLabel("NAME");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_2.setBounds(10, 244, 118, 24);
		panel_3.add(label_2);
		
		na = new JTextField();
		na.setColumns(10);
		na.setBounds(205, 247, 164, 24);
		panel_3.add(na);
		
		JLabel label_3 = new JLabel("BLOOD GROUP");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_3.setBounds(10, 301, 170, 24);
		panel_3.add(label_3);
		
		bg = new JTextField();
		bg.setColumns(10);
		bg.setBounds(205, 304, 164, 24);
		panel_3.add(bg);
		
		JLabel label_4 = new JLabel("ADDRESS");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_4.setBounds(10, 346, 118, 24);
		panel_3.add(label_4);
		
		ad = new JTextField();
		ad.setColumns(10);
		ad.setBounds(205, 349, 164, 24);
		panel_3.add(ad);
		
		JLabel label_5 = new JLabel("Phone");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_5.setBounds(10, 399, 149, 24);
		panel_3.add(label_5);
		
		ld = new JTextField();
		ld.setColumns(10);
		ld.setBounds(550, 197, 156, 35);
		panel_3.add(ld);
		
		JLabel label_6 = new JLabel("Last Donation");
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_6.setBounds(421, 194, 149, 35);
		panel_3.add(label_6);
		
		pn = new JTextField();
		pn.setColumns(10);
		pn.setBounds(205, 402, 164, 24);
		panel_3.add(pn);
		
		JButton btnUpdateDoner = new JButton("UPDATE DONER");
		btnUpdateDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String i1=i.getText(); 
       		 String nam1=na.getText(); 
       		 String bgrou1=bg.getText(); 
       		 String addres1=ad.getText();
       		 String phon1 = pn.getText(); 
       		 String lastdon1=ld.getText(); 
       		 
       		
       		 String query5 = "Update Blooddoner Set ID='"+i1+"',Name='"+nam1+"',Bgroup='"+bgrou1+"',Address='"+addres1+"',Phone='"+phon1+"',LastDonation='"+lastdon1+"'where Name='"+nam1+"' ";	
       		 
       		 try {
       			Statement st5 = c.createStatement();
       			st5.execute(query5);
       			JOptionPane.showMessageDialog(null, "DoNER UPDATED ");
       		 } catch (SQLException e2) {
       			 e2.printStackTrace();
       		 }
				
				
				
			}
		});
		btnUpdateDoner.setForeground(Color.BLACK);
		btnUpdateDoner.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdateDoner.setBackground(Color.BLUE);
		btnUpdateDoner.setBounds(535, 325, 209, 35);
		panel_3.add(btnUpdateDoner);
		
		table = new JTable();
		table.setBounds(43, 540, 221, -91);
		panel_3.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(53, 465, 1, 1);
		panel_3.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 465, 627, 167);
		panel_3.add(scrollPane_1);
		
		updatetable = new JTable();
		updatetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			int row =updatetable.getSelectedRow();
			String n = updatetable.getModel().getValueAt(row, 0).toString();
			String query4 ="select * from Blooddoner where Name='"+n+"'";
			
			
			try {
				Statement st4 = c.createStatement();
				ResultSet rs4 = st4.executeQuery(query4);
				
				while(rs4.next()) {
					i.setText(rs4.getString("ID"));
					na.setText(rs4.getString("Name"));
					bg.setText(rs4.getString("Bgroup"));
					ad.setText(rs4.getString("Address"));
					pn.setText(rs4.getString("Phone"));
					ld.setText(rs4.getString("LastDonation"));
					
				
				
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
				
				
			}
		});
		scrollPane_1.setViewportView(updatetable);
		
		btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
       		 try {
       			 String query2 ="select * from blooddoner";
       			Statement st2 = c.createStatement();
       			
       			ResultSet rs2 = st2.executeQuery(query2);
       			updatetable.setModel(DbUtils.resultSetToTableModel(rs2));
       		 } catch (SQLException e1) {
       			 e1.printStackTrace();
       		 }
				
				
			}
		});
		btnShow.setForeground(Color.BLACK);
		btnShow.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnShow.setBackground(Color.BLUE);
		btnShow.setBounds(535, 388, 177, 35);
		panel_3.add(btnShow);
	}
}
