package com.java.ex;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBController {	// DAO
	static String url = "jdbc:mariadb://localhost:3306/javaproject";
	static String uid = "root";
	static String pwd = "1234";
	
	
	
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	public void store(Store sto) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement(
					"insert into store(storecount,storepayment storepaymentconfirm,storetotalprice,storetitle) values(?,?,?,?,?)");
	
			//hashcode 
			
			st.setLong(1, sto.getStorecount());
			st.setString(2, sto.getStorepeyment());
			st.setString(3, sto.getStorepaymentconfirm());
			st.setLong(4, sto.getStoretotalprice());
			st.setString(5, sto.getStoretitle());
			/*
			st.setLong(1, store.getstorecount);
			st.setLong(2, order.getPersoncount());
			st.setString(3,  order.getScreeningplace());
			st.setString(4, order.getMovietitle());
			*/
			
			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Store svaestore(long storeid)  {
		Store store = new Store();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement("select * from ordergoods where storeid = ?");
			st.setLong(1, storeid);
			rs = st.executeQuery();

			if(rs.next()){
				
				store.setStoreid(rs.getLong("storid"));
				store.setStorecount(rs.getLong("storecount"));
				store.setStorepeyment(rs.getString("storepayment"));
				store.setStorepaymentconfirm(rs.getString("storepaymentconfirm"));
				store.setStoretitle(rs.getString("storetitle"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return store;
	}

	public Movie getMoive(String title){
		Movie movie = new Movie();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement(
					"select * from movie where title = ?");
			st.setString(1,title);
			rs = st.executeQuery();
			if(rs.next()){
				String m_title = rs.getString("m_title");
				String img = rs.getString("img");
				long price = rs.getLong("price");
				movie.setTitle(m_title);
				movie.setImg(img);
				movie.setPrice(price);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	public List<Ordergoods> getOrderList() {
		List<Ordergoods> list = new ArrayList<>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement(
					"select * from ordergoods");
			rs = st.executeQuery();
			while(rs.next()) {
				Ordergoods order = new Ordergoods();
				order.setMovietitle(rs.getString("title"));
				order.setOrderid(rs.getLong("orderid"));
				order.setUserid(rs.getNString("userid"));
				order.setPersoncount(rs.getLong("personcount"));
				order.setScreeningplace(rs.getString("screeningplace"));
				order.setSaleprice(rs.getLong("saleprice"));
				list.add(order);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void ordergoods(Ordergoods order) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement(
					"insert into ordergoods(userid,personcount, screeningplace, title, saleprice) values(?,?,?,?,?)");
	
			//hashcode 
			System.out.println("db order"+order.getMovietitle());
			
			st.setString(1, order.getUserid());
			st.setLong(2, order.getPersoncount());
			st.setString(3,  order.getScreeningplace());
			st.setString(4, order.getMovietitle());
			// 珥� 媛�寃⑹쓣 援ы븯�뒗 濡쒖쭅 �엯�땲�떎. 
			
			Long salePrice = order.getSaleprice() * order.getPersoncount();
			st.setLong(5, salePrice);

			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void join(Member member)  {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement(
					"insert into member(userid,userpw,"
			+"userhp) values(?,?,?)");
			st.setString(1, member.getUserid());
			//hashcode 
			st.setString(2, member.getUserpw());
			// st.setTimestamp(3, member.getUserdateofbirth());
			st.setString(3, member.getUserhp());
			st.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Ordergoods svaeOrder(long orderid)  {
		Ordergoods order = new Ordergoods();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement("select * from ordergoods where orderid = ?");
			st.setLong(1, orderid);
			rs = st.executeQuery();

			if(rs.next()){
				order.setOrderid(rs.getLong("orderid")); 
				order.setUserid(rs.getString("userid"));
				order.setPersoncount(rs.getLong("personcount"));
				order.setScreeningplace(rs.getString("screeningplace"));
				order.setMovietitle(rs.getString("movietitle"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	//占쏙옙占쏙옙
	/*
	public void moviejoin (MovieName moviename) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement(
					"insert into moviename(movietitle,movierank,"
			+"movieimg, moviedate) values(?,?,?,?)");
			st.setString(1, moviename.getMovietitle());
			//hashcode 
			st.setString(2, moviename.getMovierank());
			
			st.setString(3, moviename.getMovieimg());
			st.setString(4, moviename.getMoviedate());
			st.executeUpdate();
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	
	
	/*
	public MovieName findBymoviename(String movietitle)  {
		
		MovieName mv = new MovieName();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement("select * from member where movietitle = ?");
			st.setString(1, movietitle);
			rs = st.executeQuery();

			if(rs.next()){
				mv.setMovietitle(rs.getString("movietitle"));
				mv.setMovierank(rs.getString("movierank"));
				mv.setMovieimg(rs.getString("movieimg"));

			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	*/
	public Member findById(String userId)  {
		
		Member mb = new Member();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.prepareStatement("select * from member where userid = ?");
			st.setString(1, userId);
			rs = st.executeQuery();

			if(rs.next()){
				mb.setUserid(rs.getString("userid"));
				mb.setUserpw(rs.getString("userpw"));
				mb.setUserhp(rs.getString("userhp"));
				mb.setRole(rs.getInt("role"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mb;
	}
	
	
	public static void main(String[] args) {
		
		
		
		
		// Member member = new Member();
		// member.setUserid("test");
		// member.setUserpw("test");
		// member.setUserhp("010-0000-0000");
		// new DBController().join(member);
		// new DBController().findById("1"); DB 占쏙옙占쏙옙 확占쏙옙
		// System.out.println(new DBController().findById("1")); DB 占쏙옙占쏙옙 확占쏙옙
	}
}
