import java.sql.*;

public class DAO_Model {
	private int accno;
	private int cusID;
	private String cusPwd;
	private int balance;
	private int amounttransfer;
	private String npw;
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	DAO_Model(){
		DB_Connector dc= new DB_Connector();
		con=dc.getConnection();
	}
	
	public int getAccno() {
		return accno;
	}
	public int getCusID() {
		return cusID;
	}
	public String getCusPwd() {
		return cusPwd;
	}
	public int getBalance() {
		return balance;
	}
	public int getAmounttransfer() {
		return amounttransfer;
	}
	public String getNpw() {
		return npw;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	public void setCusPwd(String cusPwd) {
		this.cusPwd = cusPwd;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setAmounttransfer(int amounttransfer) {
		this.amounttransfer = amounttransfer;
	}
	public void setNpw(String npw) {
		this.npw = npw;
	}

	
	boolean verify() {
		try {
		String s = "SELECT *  FROM BANK WHERE CUSTOMERID = ? AND PASSWORD = ?";
		pstmt= con.prepareStatement(s);
		pstmt.setInt(1,cusID);
		pstmt.setString(2, cusPwd);
		res=pstmt.executeQuery();
		while(res.next()==true) {
			cusID=res.getInt(6);
			cusPwd=res.getString(3);
			accno=res.getInt(1);
			
		}
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	boolean transfer( int amttranf ) {
		try {
		pstmt= con.prepareStatement("UPDATE BANK SET BALANCE = BALANCE -? WHERE ACCNO = ?");
		pstmt.setInt(1, amttranf);
		pstmt.setInt(2, accno);
		int rows = pstmt.executeUpdate();
		if(rows == 0) {
			return false;
		}
		else {
			return true;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
		
	}
	
	
	
	boolean balance() {
		try {
		pstmt=con.prepareStatement("SELECT * FROM BANK WHERE  ACCNO = ?");
		pstmt.setInt(1, accno);
		res=pstmt.executeQuery();
		while(res.next()==true) {
			balance=res.getInt(9);
		}
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	boolean passwordChange(String npw) {
		try {
			
			pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD = ? WHERE PASSWORD = ?");
			pstmt.setString(1, npw);
			pstmt.setString(2, cusPwd);
			int row=pstmt.executeUpdate();
			if(row ==0) {
				return false;
			}else {
				return true;
			}
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
		
	
}
