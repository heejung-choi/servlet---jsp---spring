package rjavaapp;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab2 {
	public static void getDataFrame() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection(); 
		REXP x =rc.eval("hotelData<-source('C:/heejung/Rstudy/lab.R',encoding = 'UTF-8'); hotelData$value");
		RList list = x.asList();
		String[]hangul = list.at("hangul").asStrings();
		int []Freq = list.at("Freq").asIntegers();
		for (int i = 0; i < hangul.length; i++) {
			System.out.println(hangul[i]+" "+Freq[i]);
			}
		
		rc.close();
	}
	public static void main(String[] args) throws REXPMismatchException, REngineException {
		System.out.println("R이 보내온 최빈 명사들");	
		JavaRLab2.getDataFrame();
		
	}
	
}
