import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DB_ex {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/db02";
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("����");

		try {
			Class.forName(JDBC_DRIVER);

			while(true) {
				
				System.out.println("----------------------");
				System.out.println("1. ����");
				System.out.println("2. ���");
				System.out.println("3. ������Ʈ");
				System.out.println("4. ����");
				System.out.println("�޴��� �����ϼ���.");
							
				
				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();
				switch (num) {
				case 1: {
					System.out.println("�̸��� �Է��ϼ���.");
					String name = sc.next();
					System.out.println(name);
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					String ins = "INSERT INTO table02 values('" + name + "');";
					//System.out.println(ins);
					stmt.executeUpdate(ins);
					stmt.close();
					conn.close();
					break;
				}
				case 2: {
					System.out.println("�����ͺ��̽� ����մϴ�.");
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					String sel = "SELECT Fullname FROM table02";
					rs = stmt.executeQuery(sel);
					while(rs.next()){
						String Fullname = rs.getString(1);

						System.out.println(Fullname);
					}
					stmt.close();
					conn.close();
					break;
				}
				case 3: {
					System.out.println("�����մϴ�.");
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					
					String upd = "update table02"+
							" set Fullname='���ڹ�'" +
							" where Fullname='ȫ�浿';";
					//System.out.println(ins);
					stmt.executeUpdate(upd);
					stmt.close();
					conn.close();
					break;
				}
				case 4: {
					System.out.println("�����մϴ�.");
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					String del = "delete from table02 where FullName='�̿���';";
					//System.out.println(ins);
					stmt.executeUpdate(del);
					stmt.close();
					conn.close();
					break;
				}
				default:
				}
				

			}

		}catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); 
			e.printStackTrace(); 

		}catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage()); e.printStackTrace(); 
		}

	}

}
