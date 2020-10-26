import java.util.Arrays;

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		//System.out.println(mazePathRecursion(0,0,n,n));
		System.out.println(mazePathRecDPTD(0, 0, n, n,new int[n+1][n+1]));
		System.out.println(mazePathDPBU(n,n));
		System.out.println(mazePathBUSE(n,n));
		System.out.println(mPDDPBU(n,n));
		System.out.println(mPDDPTD(0, 0, n, n,new int[n+1][n+1]));
	}
	public static int mazePathRecursion(int cr,int cc,int er,int ec) {
		if(cr==er&&cc==ec) {
			return 1;
		}
		if(cr>er||cc>ec) {
			return 0;
		}
		int ch=mazePathRecursion(cr, cc+1, er, ec);
		int cv=mazePathRecursion(cr+1, cc, er, ec);
		return ch+cv;
	}
	public static int mazePathRecDPTD(int cr,int cc,int er,int ec,int[][] strg) {
		if(cr==er&&cc==ec) {
			return 1;
		}
		if(cr>er||cc>ec) {
			return 0;
		}
		if(strg[cr][cc]!=0) {
			return strg[cr][cc];
		}
		int ch=mazePathRecDPTD(cr, cc+1, er, ec,strg);
		int cv=mazePathRecDPTD(cr+1, cc, er, ec,strg);
		strg[cr][cc]=ch+cv;
		return ch+cv;
	}
	public static int mazePathDPBU(int er,int ec) {
		int[][] strg=new int[er+2][ec+2];
		for(int row=er;row>=0;row--) {
			for(int col=ec;col>=0;col--) {
				if(row==er&&col==ec) {
					strg[row][col]=1;
				}else {
					strg[row][col]=strg[row+1][col]+strg[row][col+1];
				}
			}
		}
		return strg[0][0];
	}
	public static int mazePathBUSE(int er,int ec) {
		int[] strg=new int[ec+1];
		Arrays.fill(strg,1);
		for(int i=0;i<ec;i++) {
			for(int col=ec;col>=0;col--) {
				if(col==ec) {
					strg[col]=1;
				}else {
					strg[col]=strg[col]+strg[col+1];
				}
			}
		}
		return strg[0];
	}
	public static int mazePathDiagonalRecursion(int cr,int cc,int er,int ec) {
		if(cr==er&&cc==cr) {
			return 1;
		}
		if(cr>er||cc>ec) {
			return 0;
		}
		int ch=mazePathDiagonalRecursion(cr, cc+1, er, ec);
		int cd=mazePathDiagonalRecursion(cr+1, cc+1, er, ec);
		int cv=mazePathDiagonalRecursion(cr, cc, er, ec);
		return ch+cd+cv;
	}
	public static int mPDDPTD(int cr,int cc,int er,int ec,int[][] strg) {
		if(cr==er&&cc==cr) {
			return 1;
		}
		if(cr>er||cc>ec) {
			return 0;
		}
		if(strg[cr][cc]!=0) {
			return strg[cr][cc];
		}
		int ch=mPDDPTD(cr, cc+1, er, ec,strg);
		int cd=mPDDPTD(cr+1, cc+1, er, ec,strg);
		int cv=mPDDPTD(cr+1, cc, er, ec,strg);
		strg[cr][cc]=ch+cv+cd;
		return ch+cd+cv;
	}
	public static int mPDDPBU(int er,int ec) {
		int[][] strg=new int[er+2][ec+2];
		for(int row=er;row>=0;row--) {
			for(int col=ec;col>=0;col--) {
				if(row==er&&col==ec) {
					strg[row][col]=1;
				}else {
					strg[row][col]=strg[row+1][col]+strg[row][col+1]+strg[row+1][col+1];
				}
			}
		}
		return strg[0][0];
	}
}
