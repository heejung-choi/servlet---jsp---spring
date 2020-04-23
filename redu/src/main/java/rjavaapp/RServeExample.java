package rjavaapp;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RServeExample {
	public static void getString() throws RserveException, REXPMismatchException {
		/* 버전정보 리턴 */
		RConnection rc = new RConnection(); /* RConnection 객체를 생성해주면 R서버에 접속한다. */
		//접속되어 있지 않다면 여기서부터 오류가 난다.
		String s = "가나다";
		rc.assign("x", s);//첫번째 아규먼트: R이 만들고자 하는 변수명(객체의이름)(x), 변수(객체)에 할당하고자 하는 값(s)
		rc.eval("y<- '" + s + "'");//위와 같은 역할, R의 대입 연산자
		rc.eval("if(x == '가나다') print('XXX')"); //R의 print함수이기 때문에 R의 cmd 창에 나온다.
		//중간중간의 R코드의 함수가 어떻게 실행되었는지 궁금하다면 print 하면 된다.
		rc.eval("if(y == '가나다') print('YYY')");
		rc.eval("Encoding(x)<- 'UTF-8'");//assign함수의 인코딩을 할때에는 이와 같은 방법으로 해야 한다.
		rc.eval("y<-iconv(y, 'CP949', 'UTF-8')");//대입연산자의 인코딩을 할때에는 이와 같은 방법대로 해야 한다.
		REXP x = rc.eval("paste(R.version.string,x,y)"); //R버전을 확인 할때 쓰는 코드 
		/*버전정보에 대한 문자열을 담고 있다.*/
		//REngine이 제공하는 REXP 클래스는 R이 사용 하는 자료구조를 Java에서도 사용이 가능하도록 기능을 제공하여 준다.
		//리턴값을 변수에 담지 않으면 화면에 출력된다. 그런데 화면에 출력될 것을  REXP를 사용해서 객체 안에 담는 것이다.		
		System.out.println("R 버전 정보 : " + x.asString());
		rc.close();
	}                  

	public static void getInteger() throws RserveException, REXPMismatchException {
		//예외처리는 TRY CATCH로 하거나 위의 THROWS를 해줘야 한다.
		RConnection rc = new RConnection();
		REXP x = rc.eval("length(LETTERS)");
		System.out.println("알파벳 갯수 : " + x.asInteger());
		rc.close();
	}

	public static void getDoubles() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("rnorm(20)");//20개의 난수를 추출
		double[] d = x.asDoubles();
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		rc.close();
	}

	public static void getIntegers() throws REngineException, REXPMismatchException {
		RConnection rc = new RConnection();
		int[] dataX = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		rc.assign("x", dataX);
		rc.eval("y <- x + 10");
		int[] resultX = rc.eval("y").asIntegers();//정수형이니까 asIntegers를 한것이다. 실수형이 있다면
		//asDoubles해줘야 한다.
		for (int i = 0; i < resultX.length; i++) {
			System.out.println(resultX[i]);
		}
		rc.close();
	}

	public static void getDataFrame1() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("d<-data.frame(LETTERS[11:20],c(11:20), stringsAsFactors=F)");
		RList list = x.asList();
		int v_size = list.size();
		int d_length = list.at(0).length();//관측치가 된다.
		System.out.println("데이터(관측치)의 갯수 : " + d_length);
		System.out.println("변수의 갯수 : " + v_size);
		System.out.println(list);
		System.out.println(list.at(0));
		System.out.println(list.at(1));
		int arrayRows = v_size;
		int arrayCols = d_length;
		String[][] s = new String[arrayRows][]; // 데이터프레임의 변수 갯수로 행의 크기를 정한다.

		for (int i = 0; i < arrayRows; i++) {//2행 10열로 한것을 예시로 든것이다.
			s[i] = list.at(i).asStrings(); //자바의 배열은 모두 맞춰야 하기 때문에 String으로 변환했다.
		}

		for (int i = 0; i < arrayRows; i++) {//행의 갯수만큼 반복하면서 각각의 열의 갯수를 출력하게 했다.
			for (int j = 0; j < arrayCols; j++) {
				System.out.print(s[i][j] + "\t");
			}
			System.out.println();
		}
		rc.close();
	}

	public static void getDataFrame2() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("imsi<-source('C:/boxak/Rstudy/rjavatest.R'); imsi$value");// R 소스 파일 수행
		RList list = x.asList();//데이터 프레임 이니까 list로 받아온다.

		String pid = list.at("product").asString();
		System.out.print("PID : " + pid);

		int clickcount = list.at("clickcount").asInteger();
		System.out.println("\tCLICKCOUNT : " + clickcount);
		rc.close();
	}

	public static void main(String[] args) throws REXPMismatchException, REngineException {
		System.out.println("------------ R에서 버젼정보 가져오기 --------------");
		RServeExample.getString(); /* static 형이기 때문에 getString 해줘도 된다. */
		System.out.println("------------ R에서 정수 데이터 가져오기 --------------");
		RServeExample.getInteger();
		System.out.println("------------ R에서 더블 데이터들 가져오기 -------------");
		RServeExample.getDoubles();
		System.out.println("------------  R에서 데이터 주입 연산후 가져오기 ------");
		RServeExample.getIntegers();
		System.out.println("------------  R에서 데이터 생성(데이터 프레임) 연산후 가져오기------");
		RServeExample.getDataFrame1();
		System.out.println("------------ R에서 데이터 프레임 가져오기 --------------");
		RServeExample.getDataFrame2();

	}
	
}
