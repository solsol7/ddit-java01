package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbExample01 {
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 드라이브 파일 이용해서 오라클 데이터베이스를 커넥트하겠다 - @뒤에 서버 주소 와야함 -- 외워야함
														// //1521 : 오라클의 논리적포트번호(식별자역할)
	// xe : 오라클버전(익스프레스버전 아니면 orcl)
	// thin : JDBC이용해 오라클과 연동하겠다
	String user = "pc16";
	String passwd = "java";
	// ctrl+shift+f = 들어쓰기
	Connection conn = null;
	Statement stmt = null; // sql꺼 import 시켜야함 Statement -정적쿼리
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public static void main(String[] args) {
		new DbExample01().dbConnection();// main메서드에서 static이 붙지 않은 자기 자신의 메서드를 부르는 방법 - 자기 자신의 객체를 먼저 생성시키면 static없어도
											// 불러다 쓸 수 있음
//		int res=new DbExample01().dbInsert();
//		if(res>0) {
//			System.out.println("자료 입력 성공");
//		}

	}

	public void dbConnection() {
		try {
			conn = DriverManager.getConnection(url, user, passwd); // getConnection : 오라클과 자바 연결해주는 메서드 ,거의 공식
			System.out.println("DB 연결 성공");
			stmt = conn.createStatement(); // 커넥션객체 이용해 만듦 try 블럭 안에 써줘야함
			String sql = "select empno, ename, job from temp"; // ""안에 있는 것은 오라클 코드 ->sql에 저장됨
			rs = stmt.executeQuery(sql); // select문을 실행시킬 때 사용되는 메소드 insert, update, delete ->executeUpdate
			while (rs.next()) { // 데이터 가져오는데 next() -> 있으면 true, 없으면 false
				String eid = rs.getNString("empno"); // 오라클에 있는 컬럼명, 컬럼 타입 잘 알아야함
				String eName = rs.getNString("ename");
				String job = rs.getNString(3); // 오라클은 인덱스가 1부터 시작

				System.out.printf("%5s %7s %10s\n", eid, eName, job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

	public int dbInsert() {
		Scanner sc=new Scanner(System.in);
		System.out.println("[사원정보 입력]");
		System.out.print("사원번호 : ");
		String eid=sc.nextLine();
		
		System.out.print("사원이름 : ");
		String name=sc.nextLine();
		
		System.out.print("직무코드: ");
		String jid=sc.nextLine();
		
		System.out.print("부서번호 : ");
		int deptid=Integer.parseInt(sc.nextLine());
		int res=0;		//입력되어진 갯수(몇 행이 입력되었나)  --하나씩 입력했으니까 1
		
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			String sql = "insert into TEMP values(?,?,?,?)"; //?->각 열에 대응됨 //temp테이블의 컬럼 생략됨 -> temp의 모든 컬럼에 데이터 다 집어넣는다 ->그래서 물음표 4개
			
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, eid);	//첫번째 물음표에 eid
			pstmt.setString(2, name);
			pstmt.setString(3, jid);
			pstmt.setInt(4, deptid);
			
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
		return res;
	}
}
