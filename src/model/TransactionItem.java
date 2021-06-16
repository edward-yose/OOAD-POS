package model;

public class TransactionItem {

	public TransactionItem() {
		// TODO Auto-generated constructor stub
	}

}
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.Connect;

public class TransactionItem {
	private int transactionid;
	private int productid;
	private int qty;
	
	public TransactionItem(int transactionid, int productid, int qty) {
		this.transactionid = transactionid;
		this.productid=productid;
		this.qty=qty;
	}

	public boolean insert() {
		try {
			PreparedStatement ps = Connect.connect().prepareStatement("INSERT INTO transactionitem values(?,?,?)");
			ps.setInt(1,transactionid);
			ps.setInt(2,productid);
			ps.setInt(3, qty);
			return (ps.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error insert");
			return false;
		}
		
	}
}
