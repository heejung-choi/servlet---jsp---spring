package rjavaapp;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab1 {
	public static void getString() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection(); 
		rc.eval("library(KoNLP)");
		rc.eval("hotel <- readLines('C:/boxak/Rstudy/hotel.txt')");
		rc.eval("hotel2<- extractNoun(hotel)");
		rc.eval("hotelUn <- unlist(hotel2)");
		rc.eval("hotelUn2<-gsub('[^가-힣]','',hotelUn)");		
		rc.eval("hangul<- Filter(function(x) {nchar(x) >= 2}, hotelUn2)");
		rc.eval("word_table <- table(hangul)");
		rc.eval("final <- sort(word_table, decreasing = T)");
		rc.eval("hotelResult<-head(final, 10)");
		rc.eval("hotelData<-names(hotelResult)");
		REXP x =rc.eval("hotelData");
		String[] d=x.asStrings();		
		for (int i = 0; i < d.length; i++) {
		System.out.println(d[i]);
		}		
		rc.close();
	}
	public static void main(String[] args) throws REXPMismatchException, REngineException {
		System.out.println("R이 보내온 최빈 명사들");	
		JavaRLab1.getString();
		
	}
	
}
