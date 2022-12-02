package com.java.ex;

import java.awt.EventQueue;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.java.ex.MovieName;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Test {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
    String id = "Rewind";
    String pass = "";
    String hp = "456-4564-4564";
    
    String title = "";
    String rank = "";
    String img = ""; 
    String moviedate = "010-4545-4545";
	
	private JFrame frame;
	private JTextField idText;
	private JPasswordField pwText;
	

	private JTextField ranktext;
	private JTextField movietText;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("영화예매");
		frame.setBounds(100, 100, 549, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel storePage = new JPanel();
		storePage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(storePage);
		storePage.setLayout(null);	// 스토어 페이지
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 531, 84);
		storePage.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(76,112,140));
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\netflix_logo_icon_170918 (1).png"));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(95, 10, 347, 64);
		panel_3.add(lblNewLabel_22);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\iloveimg-resized (1)\\clasic.jpg"));
		btnNewButton_8.setBounds(35, 103, 182, 181);
		storePage.add(btnNewButton_8);
		btnNewButton_8.setBackground(Color.WHITE);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\iloveimg-resized (1)\\sweet.jpg"));
		btnNewButton_9.setBounds(282, 103, 187, 181);
		storePage.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\iloveimg-resized (1)\\coff.jpg"));
		btnNewButton_10.setBounds(35, 318, 182, 197);
		storePage.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\iloveimg-resized (1)\\coce.jpg"));
		btnNewButton_11.setBounds(282, 318, 187, 197);
		storePage.add(btnNewButton_11);
		
		JLabel lblNewLabel_23 = new JLabel("고소 팝콘:5000원");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setBounds(35, 294, 182, 15);
		storePage.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("달콘 팝콘:6000원");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setBounds(282, 294, 187, 15);
		storePage.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("아메리카노:4000원");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setBounds(35, 525, 182, 15);
		storePage.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("탄산 음료:2500원");
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setBounds(282, 525, 187, 15);
		storePage.add(lblNewLabel_26);
		
		JButton btnNewButton_12 = new JButton("확인");
		btnNewButton_12.setBackground(new Color(36,138,220));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_12.setBounds(35, 550, 434, 64);
		storePage.add(btnNewButton_12);
		
		
		JPanel mainPage = new JPanel();
		mainPage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(mainPage);
		mainPage.setLayout(null);	// 메인 페이지
		
		
		JPanel mycgvPage = new JPanel();
		mycgvPage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(mycgvPage);
		mycgvPage.setLayout(null);	// mycgv 페이지
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 531, 82);
		mycgvPage.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(76,112,140));
		
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\netflix_logo_icon_170918 (1).png"));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(102, 10, 341, 62);
		panel_2.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("영화제목");
		lblNewLabel_17.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setBounds(35, 125, 57, 15);
		mycgvPage.add(lblNewLabel_17);
		
		textField_8 = new JTextField();
		textField_8.setBounds(104, 111, 371, 46);
		mycgvPage.add(textField_8);
		textField_8.setColumns(10);
		textField_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JLabel lblNewLabel_18 = new JLabel("인원");
		lblNewLabel_18.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(35, 212, 57, 15);
		mycgvPage.add(lblNewLabel_18);
		
		textField_9 = new JTextField();
		textField_9.setBounds(104, 198, 371, 46);
		mycgvPage.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("상영장소");
		lblNewLabel_19.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(35, 292, 57, 15);
		mycgvPage.add(lblNewLabel_19);
		
		textField_10 = new JTextField();
		textField_10.setBounds(104, 278, 371, 46);
		mycgvPage.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("결제방법");
		lblNewLabel_20.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBounds(35, 376, 57, 15);
		mycgvPage.add(lblNewLabel_20);
		
		textField_11 = new JTextField();
		textField_11.setBounds(104, 362, 371, 46);
		mycgvPage.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("카드번호");
		lblNewLabel_21.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setBounds(35, 463, 57, 15);
		mycgvPage.add(lblNewLabel_21);
		
		textField_12 = new JTextField();
		textField_12.setBounds(104, 449, 371, 46);
		mycgvPage.add(textField_12);
		textField_12.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(panel); // 예매확인
		panel.setLayout(null);
		

		JPanel movieTicketing = new JPanel();
		movieTicketing.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(movieTicketing);
		movieTicketing.setLayout(null); // 예매 정보입력
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 533, 81);
		panel.add(panel_1);
		panel_1.setBackground(new Color(76,112,140));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\netflix_logo_icon_170918 (1).png"));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(100, 10, 362, 61);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("영화제목");
		lblNewLabel_11.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(44, 120, 57, 15);
		panel.add(lblNewLabel_11);
		
		
		
	
	
		
		JPanel movieTicketingTop = new JPanel();
		movieTicketingTop.setBounds(0, 0, 533, 84);
		movieTicketing.add(movieTicketingTop);
		movieTicketingTop.setLayout(null);
		movieTicketing.setVisible(false);
		movieTicketingTop.setBackground(new Color(76,112,140));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\netflix_logo_icon_170918 (1).png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(124, 10, 290, 64);
		movieTicketingTop.add(lblNewLabel_6);
		
		ranktext = new JTextField();
		ranktext.setBounds(92, 120, 429, 44);
		movieTicketing.add(ranktext);
		ranktext.setColumns(10);
		
		JLabel number = new JLabel("인원");
		number.setFont(new Font("굴림", Font.PLAIN, 14));
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setBounds(23, 133, 57, 15);
		movieTicketing.add(number);
		
		JLabel lblNewLabel_5 = new JLabel("상영장소");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(23, 201, 57, 15);
		movieTicketing.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("영화제목");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(23, 265, 57, 15);
		movieTicketing.add(lblNewLabel_7);
		
		
		
	
		
		JLabel lblNewLabel_8 = new JLabel("결제선택");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(23, 336, 57, 15);
		movieTicketing.add(lblNewLabel_8);
		
		
		
		JPanel movieRankingPage = new JPanel();
		movieRankingPage.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(movieRankingPage);
		movieRankingPage.setLayout(null); // 영화 차트 
		
	
		
		JButton btnNewButton_4 = new JButton("이전으로");
		btnNewButton_4.setBounds(12, 542, 509, 72);
		movieTicketing.add(btnNewButton_4);
		btnNewButton_4.setBackground(new Color(31,138,220));
		
		JButton btnNewButton_5 = new JButton("확인");
		btnNewButton_5.setBackground(new Color(31,138,220));
		
		
			
		
		panel.setVisible(false);
		
		//여기가  문제의  그 곳  
		
		
		movietText = new JTextField();
		movietText.setBounds(92, 252, 429, 44);
		movieTicketing.add(movietText);
		movietText.setColumns(10);
		movietText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 106, 376, 46);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("인원");
		lblNewLabel_12.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(44, 187, 57, 15);
		panel.add(lblNewLabel_12);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 173, 376, 46);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("상영장소");
		lblNewLabel_13.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(44, 264, 57, 15);
		panel.add(lblNewLabel_13);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 250, 375, 46);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieName mv = new MovieName();		
				if(title.equals(movietText.getText())){	// equals
				}else {
					mv.setMovierank(ranktext.getText());
					mv.setMovietitle(movietText.getText());
					new DBController().moviejoin(mv);
					
				}
			}
		});
		
		btnNewButton_5.setBounds(12, 460, 509, 72);
		movieTicketing.add(btnNewButton_5);
		
		textField = new JTextField();
		textField.setBounds(92, 393, 429, 44);
		movieTicketing.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("카드번호");
		lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(23, 407, 57, 15);
		movieTicketing.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 187, 429, 44);
		movieTicketing.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(92, 320, 429, 49);
		movieTicketing.add(textField_5);
		textField_5.setColumns(10);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				movieTicketing.setVisible(false);
				movieRankingPage.setVisible(true);
			}
		});
	
		
		
		JPanel LoginPage = new JPanel();
	
		LoginPage.setForeground(Color.MAGENTA);
		LoginPage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(LoginPage);
		LoginPage.setLayout(null);	
		LoginPage.setBackground(new Color(41,39,39));
		// 占싸깍옙占쏙옙 占싻놂옙
		
		JPanel manager = new JPanel();
		manager.setBackground(new Color(76,112,140));
		manager.setBounds(0, 0, 531, 83);
		LoginPage.add(manager);
		manager.setLayout(null);
		
		JLabel managermenu = new JLabel("\uAD00\uB9AC\uC790 \uBA54\uB274");
		managermenu.setHorizontalAlignment(SwingConstants.CENTER);
		managermenu.setBounds(407, 12, 124, 27);
		manager.add(managermenu);
		// 占쏙옙占쏙옙占쏙옙 占싻놂옙
		
		
		
		JPanel findIdPage = new JPanel();
		findIdPage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(findIdPage);
		findIdPage.setLayout(null);	// 占쏙옙占싱듸옙 찾占쏙옙
		
		JPanel findPwPage = new JPanel();
		findPwPage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(findPwPage);	// 占쏙옙橘占싫� 찾占쏙옙
		findPwPage.setLayout(null);
		
		
		JButton btnNextLogin = new JButton("\uB85C\uADF8\uC778");
		btnNextLogin.setBackground(new Color(31,138,220));
		
		btnNextLogin.setBounds(42, 401, 450, 67);
		LoginPage.add(btnNextLogin);
		
		JButton btnNewJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewJoin.addActionListener(new ActionListener() { // 회원가입 이벤트
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Member member = new Member();

				//register
				String hex = "";
				MessageDigest md;
				try {
					member = new Member();
					md = MessageDigest.getInstance("SHA-256");
					md.update(pwText.getText().getBytes());
					hex = String.format("%064x", new BigInteger(1, md.digest()));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 占쏙옙 占쏙옙호화
				
				if(id.equals(idText.getText())){	// equals
					JOptionPane.showMessageDialog(null, "占쏙옙占싱듸옙 占싱뱄옙 占쌍쏙옙占싹댐옙.");
				}else {
					member.setUserid(idText.getText());
					member.setUserpw(hex);
					member.setUserhp(hp);
					new DBController().join(member);
					JOptionPane.showMessageDialog(null, id + "회占쏙옙占쏙옙占쏙옙占쏙옙 占싹뤄옙퓸占쏙옙占쏙옙求占�.");
				}	
			}
		});
		
		
		btnNewJoin.setBounds(42, 480, 450, 67);
		btnNewJoin.setBackground(new Color(31,138,220));
		LoginPage.add(btnNewJoin);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		idLabel.setForeground(new Color(255, 255, 255));
		
		idLabel.addMouseListener(new MouseAdapter() {	// 占쏙옙占싱듸옙 찾占쏙옙 占쏙옙占쎌스 클占쏙옙 占싱븝옙트 
			@Override
			public void mouseClicked(MouseEvent e) {
				mainPage.setVisible(false);
				LoginPage.setVisible(false);
				findIdPage.setVisible(false);
			}
		});
		
		
		 
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(42, 559, 165, 18);
		LoginPage.add(idLabel);
		
		JLabel pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		pwLabel.setForeground(new Color(255, 255, 255));
		pwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwLabel.setBounds(343, 559, 149, 18);
		LoginPage.add(pwLabel);
		
		JLabel iconCgvImg = new JLabel("");
		iconCgvImg.setIcon(new ImageIcon("C:\\Users\\\uC774\uAD00\uC6A9\\Downloads\\netflix_logo_icon_170918 (1).png"));
		iconCgvImg.setBounds(119, 95, 297, 118);
		iconCgvImg.setHorizontalAlignment(JLabel.CENTER);
		iconCgvImg.setForeground(new Color(255, 255, 255));
		LoginPage.add(iconCgvImg);
		
		idText = new JTextField();
		idText.setBounds(42, 213, 450, 58);
		LoginPage.add(idText);
		idText.setColumns(10);
		
		pwText = new JPasswordField();
		pwText.setColumns(10);
		pwText.setBounds(42, 300, 450, 58);
		LoginPage.add(pwText);
		
		
		
		pwLabel.addMouseListener(new MouseAdapter() {	// 占쏙옙橘占싫� 찾占쏙옙 占쏙옙占쎌스 클占쏙옙 占싱븝옙트 
			@Override
			public void mouseClicked(MouseEvent e) {
				mainPage.setVisible(false);
				LoginPage.setVisible(false);
				findIdPage.setVisible(false);
			}
		});
		
		JButton btnmovie = new JButton("");
		btnmovie.setBackground(new Color(31,138,220));
		btnmovie.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\video-camera.png"));
		
	
		btnmovie.setBounds(170, 105, 178, 145);
		mainPage.add(btnmovie);
		
		JPanel toppanel = new JPanel();
		toppanel.setBounds(0, 0, 531, 84);
		toppanel.setBackground(new Color(76,112,140));
		mainPage.add(toppanel);
		toppanel.setLayout(null);
		
		JLabel mainIcon = new JLabel("");
		mainIcon.setHorizontalAlignment(SwingConstants.CENTER);
		mainIcon.setIcon(new ImageIcon("C:\\Users\\\uC774\uAD00\uC6A9\\Downloads\\netflix_logo_icon_170918 (1).png"));
		mainIcon.setBounds(129, 10, 282, 64);
		toppanel.add(mainIcon);
		
		storePage.setVisible(false);
		JButton btnMovieStore = new JButton("");
		btnMovieStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				storePage.setVisible(true);
				mainPage.setVisible(false);
			}
		});
		btnMovieStore.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\video-camera.png"));
		btnMovieStore.setBackground(new Color(31, 138, 220));
		btnMovieStore.setBounds(40, 302, 178, 145);
		mainPage.add(btnMovieStore);
		
		JButton btnMovieexpected = new JButton("");
		btnMovieexpected.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\video-camera.png"));
		btnMovieexpected.setBackground(new Color(31, 138, 220));
		btnMovieexpected.setBounds(293, 302, 187, 145);
		mainPage.add(btnMovieexpected);
		
		JLabel textMovie = new JLabel("\uC601\uD654 \uCC28\uD2B8");
		textMovie.setHorizontalAlignment(SwingConstants.CENTER);
		textMovie.setBounds(231, 260, 57, 15);
		mainPage.add(textMovie);
		
		JLabel textmovieStore = new JLabel("\uC2A4\uD1A0\uC5B4");
		textmovieStore.setHorizontalAlignment(SwingConstants.CENTER);
		textmovieStore.setBounds(99, 457, 57, 15);
		mainPage.add(textmovieStore);
		
		JLabel textMovieexpected = new JLabel("\uAC1C\uBD09 \uC608\uC815");
		textMovieexpected.setHorizontalAlignment(SwingConstants.CENTER);
		textMovieexpected.setBounds(357, 457, 57, 15);
		mainPage.add(textMovieexpected);
		
		JButton btnLogout = new JButton("종료");
		btnLogout.setBackground(new Color(31,138,220));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(40, 482, 440, 52);
		mainPage.add(btnLogout);
		
		
		
		
		JButton imgbtn = new JButton("");
		imgbtn.setBackground(Color.WHITE);
		imgbtn.setSelectedIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\black.jpg"));
		imgbtn.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\no3.jpg"));
		imgbtn.setBounds(320, 93, 146, 209);
		movieRankingPage.add(imgbtn);
		imgbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);
			}
		});
		
		imgbtn = new JButton(img);
		JPanel movierankTop = new JPanel();
		imgbtn.setRolloverIcon(null);
		imgbtn.setToolTipText("1");
		movierankTop.setBounds(0, 0, 533, 83);
		movieRankingPage.add(movierankTop);
		movierankTop.setBackground(new Color(76,112,140));
		movierankTop.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\netflix_logo_icon_170918 (1).png"));
		lblNewLabel_2.setBounds(97, 10, 351, 63);
		movierankTop.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("데시벨");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(320, 309, 146, 15);
		movieRankingPage.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\no4.jpg"));
		btnNewButton.setBounds(71, 93, 146, 209);
		
			
			
		
			
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("올뺴미");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(71, 310, 146, 15);
		movieRankingPage.add(lblNewLabel_1);
		
		movieRankingPage.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel_1.getText();
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);
				
				
			}
		});
		
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\1.jpg"));
		btnNewButton_1.setBounds(71, 329, 146, 209);
		movieRankingPage.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);				
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("바르도");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(71, 548, 146, 15);
		movieRankingPage.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\2.jpg"));
		btnNewButton_2.setBounds(320, 334, 146, 204);
		movieRankingPage.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("유포자들");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(320, 549, 146, 15);
		movieRankingPage.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("이전으로");
		btnNewButton_3.setBackground(new Color(31,138,220));
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.setVisible(false);
				btnmovie.setVisible(true);
				mainPage.setVisible(true);
				findIdPage.setVisible(false);
				findPwPage.setVisible(false);
				movieRankingPage.setVisible(false);
			}
		});
		
		btnNewButton_3.setBounds(71, 573, 395, 41);
		movieRankingPage.add(btnNewButton_3);
		
		

		mainPage.setVisible(false); // 화占쏙옙占쏙옙占�
		movieRankingPage.setVisible(false);	// 화占쏙옙占쏙옙占�
		
		btnNextLogin.addActionListener(new ActionListener() { // 화占쏙옙 占쏙옙환
			@Override
			public void actionPerformed(ActionEvent arg0) {	// 로그인
				// �뿬湲곗뿉 �꽌  濡� 洹�  �씤 �맖  
				String hex = "";
				MessageDigest md;
				try {
					
					md = MessageDigest.getInstance("SHA-256");
					md.update(pwText.getText().getBytes()); // get TextField password
					// hex password
					hex = String.format("%064x", new BigInteger(1, md.digest()));
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 占쏙옙 占쏙옙호화
				
				System.out.println("raw占쏙옙 占쌔시곤옙 : "+hex);
				// 조건문 
				//if(id.equals(idText.getText()) && pass.equals(hex)) {
				if( new DBController().findById(idText.getText()).getUserpw().equals(hex)){
					mainPage.setVisible(true);
					LoginPage.setVisible(false);
					findIdPage.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "占쏙옙占싱듸옙 占쏙옙橘占싫ｏ옙占� 틀占쏙옙占싹댐옙.");
				}
			}
		});
		
		
		JButton btnNewButton_6 = new JButton("확인");
		btnNewButton_6.setBounds(44, 514, 445, 76);
		panel.add(btnNewButton_6);
		btnNewButton_6.setBackground(new Color(31,138,220));
		
			
		
		
		
		JLabel lblNewLabel_14 = new JLabel("결제방법");
		lblNewLabel_14.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(44, 338, 57, 15);
		panel.add(lblNewLabel_14);
		
		textField_6 = new JTextField();
		textField_6.setBounds(113, 323, 376, 46);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("카드번호");
		lblNewLabel_15.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(44, 420, 57, 15);
		panel.add(lblNewLabel_15);
		
		textField_7 = new JTextField();
		textField_7.setBounds(113, 403, 376, 51);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		mycgvPage.setVisible(false);
		
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MovieName mv = new MovieName();
				// 이버튼을 누르면 select movietitle from moviename;
				// textFiled1.setText()
				textField_1.setText(movietText.getText());
				textField_2.setText(ranktext.getText());
				textField_3.setText(textField_4.getText());
				textField_6.setText(textField_5.getText());
				textField_7.setText(textField.getText());
				
				textField_8.setText(movietText.getText());
				textField_9.setText(ranktext.getText());
				textField_10.setText(textField_4.getText());
				textField_11.setText(textField_5.getText());
				textField_12.setText(textField.getText());
				panel.setVisible(true);
				mainPage.setVisible(false);
				movieTicketing.setVisible(false);
				movieRankingPage.setVisible(false);
				if(title.equals(movietText.getText())){	// equals
				}else {
					mv.setMovierank(ranktext.getText());
					mv.setMovietitle(movietText.getText());
					new DBController().moviejoin(mv);
				}
				
				
			}
		});
		
		
		btnNewButton_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				mainPage.setVisible(true);
				btnmovie.setVisible(true);
			}
		});
		
		
		JButton btnMycgvinfor = new JButton("MY CGV");
		btnMycgvinfor.setBounds(40, 554, 440, 52);
		btnMycgvinfor.setBackground(new Color(31,138,220));
		mainPage.add(btnMycgvinfor);
		btnMycgvinfor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				mycgvPage.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_7 = new JButton("확인");
		btnNewButton_7.setBounds(35, 534, 440, 59);
		mycgvPage.add(btnNewButton_7);
		btnNewButton_7.setBackground(new Color(31,138,220));
		
		
		btnNewButton_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mycgvPage.setVisible(false);
				mainPage.setVisible(true);
				
			}
		});
		
		btnmovie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage.setVisible(false);
				btnmovie.setVisible(false);
				mainPage.setVisible(false);
				findIdPage.setVisible(false);
				findPwPage.setVisible(false);
				movieRankingPage.setVisible(true);
				
				
				
			}
			
		});	// 화占쏙옙 占쏙옙환
		
		
		
	
	}
}
