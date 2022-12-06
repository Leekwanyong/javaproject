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
import java.util.List;

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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

public class Test {
	static String path = System.getProperty("user.dir");
	
	public static List<Ordergoods> list = null;
	public static int pagingNum = 0;
	
	public static String id = "Rewind";
	String pass = "";
	String hp = "456-4564-4564";

	String movetitleValue ="";
	long Personcount = 12;

	private JFrame frame;
	private JTextField idText;
	private JPasswordField pwText;

	private JTextField persontext;
	private JTextField movietitle;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField screeningplace;
	private JTextField price_tf;
	private JTextField movieprice_price_tf;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField 수량입력;
	private JTextField 결제상품입력;
	private JTextField 카드번호입력창;
	private JTextField textField;

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
	public void makeOrderListPanel(JPanel orderlist_panel) {
		orderlist_panel.removeAll();
		orderlist_panel.setLayout(new GridBagLayout());
		list = new DBController().getOrderList();
		GridBagConstraints c = null;
		int y = 1;
		int targetNum = pagingNum* 5;
		for (int i = targetNum; i<targetNum + 5; i++) {
			c = new GridBagConstraints();
	        c.weighty = 1.0;
	        c.weightx = 1.0;
	        c.gridy = y++;
	        c.fill = GridBagConstraints.BOTH;
			String str = list.get(i).getOrderid() +" : "+ list.get(i).getUserid() +" :[인원수] "+ list.get(i).getPersoncount() +"명 : "+ list.get(i).getScreeningplace()
			+" : "+ list.get(i).getMovietitle() +" : "+ list.get(i).getSaleprice()+" 원";
		
			orderlist_panel.add(new JLabel(str),c);
		}
		orderlist_panel.repaint();
		orderlist_panel.revalidate();
//		manager_home.repaint();
//		manager_home.revalidate();
	}
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("영화예매");
		frame.setBounds(100, 100, 549, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel manager_home = new JPanel(); // 관리자 페이지
		manager_home.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(manager_home);
		manager_home.setLayout(null);
		
		JLabel pagingNumlb = new JLabel("");
		pagingNumlb.setBounds(224, 595, 57, 15);
		manager_home.add(pagingNumlb);
		JPanel orderlist_panel = new JPanel();
		orderlist_panel.setBackground(Color.GRAY);
		orderlist_panel.setBounds(12, 105, 507, 474);
		manager_home.add(orderlist_panel);
		
		JLabel lblNewLabel_15 = new JLabel("주문 목록");
		lblNewLabel_15.setBounds(27, 42, 57, 15);
		manager_home.add(lblNewLabel_15);
		// 새로고침 액션
		JButton refresh_btn = new JButton("새로고침");
		refresh_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagingNumlb.setText(String.valueOf(pagingNum));
				makeOrderListPanel(orderlist_panel);
			}
		});
		refresh_btn.setBounds(422, 38, 97, 23);
		manager_home.add(refresh_btn);
		// 이전 버튼 액션
		JButton previousPageBtn = new JButton("이전페이지");
		previousPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((pagingNum -1 ) > -1) {
					pagingNum--;
				};
				pagingNumlb.setText(String.valueOf(pagingNum));
				makeOrderListPanel(orderlist_panel);
			}
		});
		previousPageBtn.setBounds(12, 591, 97, 23);
		manager_home.add(previousPageBtn);
		
		JButton nextPageBtn = new JButton("다음페이지");
		nextPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((pagingNum + 1) * 5) + 5 < list.size()+1) {
					pagingNum++;
				}
				pagingNumlb.setText(String.valueOf(pagingNum));
				makeOrderListPanel(orderlist_panel);
			}
		});
		nextPageBtn.setBounds(422, 591, 97, 23);
		manager_home.add(nextPageBtn);
		
	
		
		
		manager_home.setVisible(false); // 관리자 페이지 숨기기
		
		JPanel mainPage = new JPanel();
		mainPage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(mainPage);
		mainPage.setLayout(null); // 메인 페이지
		
		JPanel movieRankingPage = new JPanel();
		movieRankingPage.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(movieRankingPage);
		movieRankingPage.setLayout(null); // 영화 차트
		
		JPanel storebuy = new JPanel(); // 스토어 결제화면
		storebuy.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(storebuy);
		storebuy.setLayout(null);
		
		JPanel mycgvPage = new JPanel();
		mycgvPage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(mycgvPage);
		mycgvPage.setLayout(null); // mycgv 페이지
		
		JPanel movieprice = new JPanel();
		movieprice.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(movieprice); // 예매확인
		movieprice.setLayout(null);
		
		JPanel movieTicketing = new JPanel();
		movieTicketing.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(movieTicketing);
		movieTicketing.setLayout(null); // 예매 정보입력
		
		
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 533, 82);
		storebuy.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(76, 112, 140));
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(70, 10, 369, 62);
		panel_5.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
		
		JLabel 수량제목 = new JLabel("수량");
		수량제목.setFont(new Font("굴림", Font.PLAIN, 15));
		수량제목.setHorizontalAlignment(SwingConstants.CENTER);
		수량제목.setBounds(12, 136, 57, 30);
		storebuy.add(수량제목);
		
		수량입력 = new JTextField();
		수량입력.setBounds(105, 129, 416, 46);
		storebuy.add(수량입력);
		수량입력.setColumns(10);
		
		결제상품입력 = new JTextField();
		결제상품입력.setBounds(105, 213, 416, 46);
		storebuy.add(결제상품입력);
		결제상품입력.setColumns(10);
		
		JLabel 결제방법선택 = new JLabel("결제 방법");
		결제방법선택.setFont(new Font("굴림", Font.PLAIN, 15));
		결제방법선택.setHorizontalAlignment(SwingConstants.CENTER);
		결제방법선택.setBounds(12, 226, 84, 18);
		storebuy.add(결제방법선택);
		
		JLabel 카드번호 = new JLabel("카드 번호");
		카드번호.setFont(new Font("굴림", Font.PLAIN, 15));
		카드번호.setHorizontalAlignment(SwingConstants.CENTER);
		카드번호.setBounds(7, 300, 89, 15);
		storebuy.add(카드번호);
		
		카드번호입력창 = new JTextField();
		카드번호입력창.setBounds(105, 282, 416, 51);
		storebuy.add(카드번호입력창);
		카드번호입력창.setColumns(10);
		
		JButton paystorebtn = new JButton("확인");
		paystorebtn.setFont(new Font("굴림", Font.PLAIN, 15));
		paystorebtn.setBounds(12, 444, 509, 70);
		storebuy.add(paystorebtn);
		
		JLabel lblNewLabel_3 = new JLabel("결제금액");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(39, 377, 57, 15);
		storebuy.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(105, 361, 416, 47);
		storebuy.add(textField);
		textField.setColumns(10);
		
		JPanel storeOk = new JPanel();	// 스토어 구매확인화면 
		storeOk.setBounds(0, 0, 533, 624);
		frame.getContentPane().add(storeOk);
		storeOk.setLayout(null);
		storeOk.setVisible(false);
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 533, 84);
		storeOk.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(76, 112, 140));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 10, 327, 64);
		lblNewLabel.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
		panel_4.add(lblNewLabel);
		

		JPanel storePage = new JPanel();
		storePage.setBounds(0, 0, 531, 624);
		frame.getContentPane().add(storePage);
		storePage.setLayout(null); // 스토어 페이지

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 531, 84);
		storePage.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(76, 112, 140));

		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(95, 10, 347, 64);
		panel_3.add(lblNewLabel_22);
	
		storebuy.setVisible(false);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(new ImageIcon("./MovieImg/popcorn.jpg"));
		btnNewButton_8.setBounds(35, 103, 182, 181);
		storePage.add(btnNewButton_8);
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				storebuy.setVisible(true);
				storePage.setVisible(false);
			}
		});

		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setIcon(new ImageIcon("./MovieImg/sweet_popcorn.jpg"));
		btnNewButton_9.setBounds(282, 103, 187, 181);
		storePage.add(btnNewButton_9);

		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setIcon(new ImageIcon("./MovieImg/carbonated_drink.jpg"));
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
		btnNewButton_12.setBackground(new Color(36, 138, 220));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				storeOk.setVisible(true);
				storePage.setVisible(false);

			}
		});
		btnNewButton_12.setBounds(35, 550, 434, 64);
		storePage.add(btnNewButton_12);

		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.setBounds(35, 318, 182, 197);
		btnNewButton_10.setIcon(new ImageIcon("./MovieImg/conffee.jpg"));
		storePage.add(btnNewButton_10);

		

		

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 531, 82);
		mycgvPage.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(76, 112, 140));

		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
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

		JLabel lblNewLabel_20 = new JLabel("결제금액");
		lblNewLabel_20.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBounds(35, 376, 57, 15);
		mycgvPage.add(lblNewLabel_20);

		textField_11 = new JTextField();
		textField_11.setBounds(104, 362, 371, 46);
		mycgvPage.add(textField_11);
		textField_11.setColumns(10);

		

	

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 533, 81);
		movieprice.add(panel_1);
		panel_1.setBackground(new Color(76, 112, 140));
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
		movieprice.add(lblNewLabel_11);

		JPanel movieTicketingTop = new JPanel();
		movieTicketingTop.setBounds(0, 0, 533, 84);
		movieTicketing.add(movieTicketingTop);
		movieTicketingTop.setLayout(null);
		movieTicketing.setVisible(false);
		movieTicketingTop.setBackground(new Color(76, 112, 140));

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(124, 10, 290, 64);
		movieTicketingTop.add(lblNewLabel_6);

		persontext = new JTextField();
		persontext.setBounds(92, 120, 429, 44);
		movieTicketing.add(persontext);
		persontext.setColumns(10);

		JLabel number = new JLabel("인원");
		number.setFont(new Font("굴림", Font.PLAIN, 14));
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setBounds(23, 133, 57, 15);
		movieTicketing.add(number);

		JLabel lblNewLabel_5 = new JLabel("상영장소");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(23, 212, 57, 15);
		movieTicketing.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("영화제목");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(23, 287, 57, 15);
		movieTicketing.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("결제금액");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(23, 374, 57, 15);
		movieTicketing.add(lblNewLabel_8);

	

		JButton btnNewButton_4 = new JButton("이전으로");
		btnNewButton_4.setBounds(12, 542, 509, 72);
		movieTicketing.add(btnNewButton_4);
		btnNewButton_4.setBackground(new Color(31, 138, 220));

		JButton paymoviebtn = new JButton("확인");
		paymoviebtn.setBackground(new Color(31, 138, 220));


		movieprice.setVisible(false);

		// 여기가 문제의 그 곳

		movietitle = new JTextField();
		movietitle.setBounds(92, 274, 429, 44);
		movieTicketing.add(movietitle);
		movietitle.setColumns(10);
		movietitle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		textField_1 = new JTextField();
		textField_1.setBounds(113, 106, 376, 46);
		movieprice.add(textField_1);
		textField_1.setColumns(10);
		// persontext.setText();
		textField_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movietitle.setText(textField_1.getText());
				// TODO Auto-generated method stub
				
			}
		});
		
		
	
		
		

		JLabel lblNewLabel_12 = new JLabel("인원");
		lblNewLabel_12.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(44, 187, 57, 15);
		movieprice.add(lblNewLabel_12);

		textField_2 = new JTextField();
		textField_2.setBounds(113, 173, 376, 46);
		movieprice.add(textField_2);
		textField_2.setColumns(10);
		// movietitle.setText(올빼미제목.getText());
		textField_2.setText(persontext.getText());

		JLabel lblNewLabel_13 = new JLabel("상영장소");
		lblNewLabel_13.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(44, 264, 57, 15);
		movieprice.add(lblNewLabel_13);

		textField_3 = new JTextField();
		textField_3.setBounds(114, 250, 375, 46);
		movieprice.add(textField_3);
		textField_3.setColumns(10);
		/*
		 * textField_1.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { MovieName mv = new
		 * MovieName(); if(title.equals(movietText.getText())){ // equals }else {
		 * mv.setMovierank(ranktext.getText()); mv.setMovietitle(movietText.getText());
		 * new DBController().moviejoin(mv);
		 * 
		 * } } });
		 */
		paymoviebtn.setBounds(12, 460, 509, 72);
		movieTicketing.add(paymoviebtn);

		screeningplace = new JTextField();
		screeningplace.setBounds(92, 198, 429, 44);
		movieTicketing.add(screeningplace);
		screeningplace.setColumns(10);

		price_tf = new JTextField();
		price_tf.setBounds(92, 358, 429, 49);
		movieTicketing.add(price_tf);
		price_tf.setColumns(10);
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
		LoginPage.setBackground(new Color(41, 39, 39));
		// 占싸깍옙占쏙옙 占싻놂옙

		JPanel manager = new JPanel();
		manager.setBackground(new Color(76, 112, 140));
		manager.setBounds(0, 0, 531, 83);
		LoginPage.add(manager);
		manager.setLayout(null);

		JLabel managermenu = new JLabel("\uAD00\uB9AC\uC790 \uBA54\uB274");
		managermenu.setHorizontalAlignment(SwingConstants.CENTER);
		managermenu.setBounds(407, 12, 124, 27);
		manager.add(managermenu);

		JButton btnNextLogin = new JButton("\uB85C\uADF8\uC778");
		btnNextLogin.setBackground(new Color(31, 138, 220));

		btnNextLogin.setBounds(42, 401, 450, 67);
		LoginPage.add(btnNextLogin);

		JButton btnNewJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewJoin.addActionListener(new ActionListener() { // 회원가입 이벤트
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Member member = new Member();

				// register
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

				if (id.equals(idText.getText())) { // equals
					JOptionPane.showMessageDialog(null, "占쏙옙占싱듸옙 占싱뱄옙 占쌍쏙옙占싹댐옙.");
				} else {
					member.setUserid(idText.getText());
					member.setUserpw(hex);
					member.setUserhp(hp);
					new DBController().join(member);
					JOptionPane.showMessageDialog(null, id + "회占쏙옙占쏙옙占쏙옙占쏙옙 占싹뤄옙퓸占쏙옙占쏙옙求占�.");
				}
			}
		});

		btnNewJoin.setBounds(42, 480, 450, 67);
		btnNewJoin.setBackground(new Color(31, 138, 220));
		LoginPage.add(btnNewJoin);

		JLabel iconCgvImg = new JLabel("");
		iconCgvImg.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
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

		JButton btnmovie = new JButton("");
		btnmovie.setBackground(new Color(31, 138, 220));
		btnmovie.setIcon(new ImageIcon("./MovieImg/video_player.png"));

		btnmovie.setBounds(50, 205, 178, 145);
		mainPage.add(btnmovie);

		JPanel toppanel = new JPanel();
		toppanel.setBounds(0, 0, 531, 84);
		toppanel.setBackground(new Color(76, 112, 140));
		mainPage.add(toppanel);
		toppanel.setLayout(null);

		JLabel mainIcon = new JLabel("");
		mainIcon.setHorizontalAlignment(SwingConstants.CENTER);
		mainIcon.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
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
		btnMovieStore.setIcon(new ImageIcon("./MovieImg/video_player.png"));
		btnMovieStore.setBackground(new Color(31, 138, 220));
		btnMovieStore.setBounds(278, 205, 178, 145);
		mainPage.add(btnMovieStore);
		JLabel spreadersprice = new JLabel("15000");
		spreadersprice.setBounds(419, 550, 30, 15);
		movieRankingPage.add(spreadersprice);
		
		JLabel owlprice = new JLabel("10000");
		owlprice.setBounds(160, 311, 57, 15);
		movieRankingPage.add(owlprice);
		
		JLabel decibleprice = new JLabel("9000");
		decibleprice.setBounds(409, 312, 57, 15);
		movieRankingPage.add(decibleprice);
		
		JLabel bardoprice = new JLabel("20000");
		bardoprice.setHorizontalAlignment(SwingConstants.CENTER);
		bardoprice.setBounds(160, 550, 57, 15);
		movieRankingPage.add(bardoprice);

		JLabel textMovie = new JLabel("\uC601\uD654 \uCC28\uD2B8");
		textMovie.setHorizontalAlignment(SwingConstants.CENTER);
		textMovie.setBounds(111, 360, 57, 15);
		mainPage.add(textMovie);

		JLabel textmovieStore = new JLabel("\uC2A4\uD1A0\uC5B4");
		textmovieStore.setHorizontalAlignment(SwingConstants.CENTER);
		textmovieStore.setBounds(337, 360, 57, 15);
		mainPage.add(textmovieStore);

		JButton btnLogout = new JButton("종료");
		btnLogout.setBackground(new Color(31, 138, 220));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(40, 482, 440, 52);
		mainPage.add(btnLogout);

		JButton 데시벨버튼 = new JButton("");
		데시벨버튼.setBackground(Color.WHITE);
		데시벨버튼.setSelectedIcon(new ImageIcon("C:\\Users\\이관용\\Downloads\\movieimg\\black.jpg"));
		데시벨버튼.setIcon(new ImageIcon("./MovieImg/decibel.jpg"));
		데시벨버튼.setBounds(320, 93, 146, 209);
		movieRankingPage.add(데시벨버튼);
		데시벨버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				price_tf.setText(decibleprice.getText());
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);
			}
		});

		
		JPanel movierankTop = new JPanel();
		데시벨버튼.setRolloverIcon(null);
		데시벨버튼.setToolTipText("1");
		movierankTop.setBounds(0, 0, 533, 83);
		movieRankingPage.add(movierankTop);
		movierankTop.setBackground(new Color(76, 112, 140));
		movierankTop.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("./MovieImg/netflix_logo_icon.png"));
		lblNewLabel_2.setBounds(97, 10, 351, 63);
		movierankTop.add(lblNewLabel_2);

		JLabel 데시벨제목 = new JLabel("데시벨");
		데시벨제목.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		데시벨제목.setHorizontalAlignment(SwingConstants.CENTER);
		데시벨제목.setBounds(276, 312, 146, 15);
		movieRankingPage.add(데시벨제목);
		
		데시벨버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				movetitleValue = 데시벨제목.getText();
				movietitle.setText(데시벨제목.getText());
				price_tf.setText(decibleprice.getText());
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);

			}
		});
		JButton 올빼미버튼 = new JButton("");
		올빼미버튼.setIcon(new ImageIcon("./MovieImg/owl.jpg"));
		올빼미버튼.setBounds(71, 93, 146, 209);

		JLabel 올빼미제목 = new JLabel("올빼미");
		올빼미제목.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		올빼미제목.setHorizontalAlignment(SwingConstants.CENTER);
		올빼미제목.setBounds(22, 309, 146, 15);
		movieRankingPage.add(올빼미제목);

		movieRankingPage.add(올빼미버튼);
		올빼미버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				movetitleValue = 올빼미제목.getText();
				movietitle.setText(올빼미제목.getText());
				price_tf.setText(owlprice.getText());
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);

			}
		});

		JButton 바르도버튼 = new JButton("");
		바르도버튼.setIcon(new ImageIcon("./MovieImg/bardo.jpg"));
		바르도버튼.setBounds(71, 329, 146, 209);
		movieRankingPage.add(바르도버튼);
		바르도버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				price_tf.setText(bardoprice.getText());
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);
			}
		});

		JLabel 바르도제목 = new JLabel("바르도");
		바르도제목.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		바르도제목.setHorizontalAlignment(SwingConstants.CENTER);
		바르도제목.setBounds(22, 548, 146, 15);
		movieRankingPage.add(바르도제목);
		
		바르도버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				movetitleValue = 바르도제목.getText();
				movietitle.setText(바르도제목.getText());
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);

			}
		});
		

		JButton 유포자버튼 = new JButton("");
		유포자버튼.setIcon(new ImageIcon("./MovieImg/spreaders.jpg"));
		유포자버튼.setBounds(320, 334, 146, 204);
		movieRankingPage.add(유포자버튼);
		유포자버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				price_tf.setText(spreadersprice.getText());
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);

			}
		});
		
		JLabel 유포자들제목 = new JLabel("유포자들");
		유포자들제목.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		유포자들제목.setHorizontalAlignment(SwingConstants.CENTER);
		유포자들제목.setBounds(320, 549, 88, 15);
		movieRankingPage.add(유포자들제목);
		
		유포자버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				movetitleValue = 유포자들제목.getText();
				movietitle.setText(유포자들제목.getText());
				price_tf.setText(spreadersprice.getText());
				movieTicketing.setVisible(true);
				movieRankingPage.setVisible(false);

			}
		});

		JButton previous_btn = new JButton("이전으로");
		previous_btn.setBackground(new Color(31, 138, 220));

		previous_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.setVisible(false);
				btnmovie.setVisible(true);
				mainPage.setVisible(true);
				
				movieRankingPage.setVisible(false);
			}
		});

		previous_btn.setBounds(71, 573, 395, 41);
		movieRankingPage.add(previous_btn);
		
		
		JLabel lblNewLabel_9 = new JLabel("원");
		lblNewLabel_9.setBounds(450, 550, 57, 15);
		movieRankingPage.add(lblNewLabel_9);
		
		JLabel lblNewLabel_4 = new JLabel("원");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(190, 311, 57, 15);
		movieRankingPage.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("원");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_1.setBounds(434, 311, 57, 15);
		movieRankingPage.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("원");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_1_1.setBounds(203, 550, 57, 15);
		movieRankingPage.add(lblNewLabel_4_1_1);
	

		mainPage.setVisible(false); // 화占쏙옙占쏙옙占�
		movieRankingPage.setVisible(false); // 화占쏙옙占쏙옙占�

		btnNextLogin.addActionListener(new ActionListener() { // 화占쏙옙 占쏙옙환
			@Override
			public void actionPerformed(ActionEvent arg0) { // 로그인
				// �뿬湲곗뿉 �꽌 濡� 洹� �씤 �맖
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

				System.out.println("raw占쏙옙 占쌔시곤옙 : " + hex);
				// 조건문
				// if(id.equals(idText.getText()) && pass.equals(hex)) {
				Member loginMember = new DBController().findById(idText.getText());
				if (loginMember.getUserpw().equals(hex)) {
					id = idText.getText();
					if(loginMember.getRole() == 1) {
						//관리자
						manager_home.setVisible(true);
						LoginPage.setVisible(false);
					}else {
						mainPage.setVisible(true);
						LoginPage.setVisible(false);
						
					}
				
				} else {
					JOptionPane.showMessageDialog(null, "占쏙옙占싱듸옙 占쏙옙橘占싫ｏ옙占� 틀占쏙옙占싹댐옙.");
				}
			}
		});

		JButton movieprice_paymoviebtn = new JButton("확인");
		movieprice_paymoviebtn.setBounds(44, 514, 445, 76);
		movieprice.add(movieprice_paymoviebtn);
		movieprice_paymoviebtn.setBackground(new Color(31, 138, 220));

		JLabel lblNewLabel_14 = new JLabel("결제금액");
		lblNewLabel_14.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(44, 338, 57, 15);
		movieprice.add(lblNewLabel_14);

		movieprice_price_tf = new JTextField();
		movieprice_price_tf.setBounds(113, 323, 376, 46);
		movieprice.add(movieprice_price_tf);
		movieprice_price_tf.setColumns(10);

		mycgvPage.setVisible(false);

		paymoviebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ordergoods order = new Ordergoods();
				order = new Ordergoods();
				order.setUserid(id);
				order.setPersoncount(Long.parseLong(persontext.getText()));
				order.setScreeningplace(screeningplace.getText());
				System.out.println(screeningplace.getText());
				order.setMovietitle(movietitle.getText());
				order.setSaleprice(Long.parseLong(price_tf.getText()));
				new DBController().ordergoods(order);
				
				long salePrice = order.getPersoncount() * order.getSaleprice(); 
				// 이버튼을 누르면 select movietitle from moviename;
				// textFiled1.setText()
				
				textField_1.setText(movietitle.getText());
				textField_2.setText(persontext.getText());
				textField_3.setText(screeningplace.getText());
				movieprice_price_tf.setText(String.valueOf(salePrice));
				

				textField_8.setText(movietitle.getText());
				textField_9.setText(persontext.getText());
				textField_10.setText(screeningplace.getText());
				textField_11.setText(price_tf.getText());
				
				
				movieprice.setVisible(true);
				mainPage.setVisible(false);
				movieTicketing.setVisible(false);
				movieRankingPage.setVisible(false);
				/*
				 * if(title.equals(movietText.getText())){ // equals }else {
				 * mv.setMovierank(ranktext.getText()); mv.setMovietitle(movietText.getText());
				 * new DBController().moviejoin(mv); }
				 */

			}
		});

		movieprice_paymoviebtn.addActionListener(new ActionListener() {
				
				

			@Override
			public void actionPerformed(ActionEvent e) {
				// textField_12.setText(textField.getText());
				movieprice.setVisible(false);
				mainPage.setVisible(true);
				btnmovie.setVisible(true);
			}
		});

		JButton btnMycgvinfor = new JButton("MY CGV");
		btnMycgvinfor.setBounds(40, 554, 440, 52);
		btnMycgvinfor.setBackground(new Color(31, 138, 220));
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
		btnNewButton_7.setBackground(new Color(31, 138, 220));
		
		
		
		

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
				
				movieRankingPage.setVisible(true);

			}

		}); // 화占쏙옙 占쏙옙환

	}
}