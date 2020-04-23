package rtest;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;
@Service
public class OnePersonService {	

	public String returnmap7(String path, String name) {
		RConnection r = null;
		String retStr = "";
		try {
			
			r = new RConnection(); 
			r.eval("name <- iconv('"+name+"', from='CP949', to='UTF-8')");
			r.eval("setwd('c:/heejung/Rstudy')");
			r.eval("library(dplyr);library(leaflet);library(Kormaps);library(htmlwidgets)");
			r.eval("DONG<-read.csv('data/one.csv')");
			r.eval("Encoding(names(korpopmap2))<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$name)<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$행정구역별_읍면동)<-'UTF-8'");
			r.eval("Encoding(names(korpopmap3))<-'UTF-8'");
			r.eval("Encoding(korpopmap3@data$name)<-'UTF-8'");
			r.eval("Encoding(korpopmap3@data$행정구역별_읍면동)<-'UTF-8'");
			r.eval("k2 <- korpopmap2");
			r.eval("k3 <- korpopmap3");
			//데이터 뽑기						
			r.eval("guname <-'"+name+"'");
			System.out.println(r.eval("guname").asString());
			r.eval("gucode <- k2@data[k2@data$name == guname, \"code.data\"]");
			r.eval("pattern <- paste0('^', gucode)");
			r.eval("grepD<-grep(pattern,k3@data$code.data)");
			r.eval("k3@polygons<-k3@polygons[grepD]");
			r.eval("k3@data<-k3@data[grepD,]");
			r.eval("k3@data");
			//구 데이터 저장
			r.eval("k3@data$name<-gsub('·','',k3@data$name)");
			r.eval("colnames(DONG)<-c('구별','name','일인가구')");
			r.eval("dong <- DONG %>%filter(구별==guname)");
			r.eval("k3@data<-merge(k3@data,dong,by.x='name',sort=FALSE)");
			r.eval("mymap <- k3@data");
			r.eval("mypalette <- colorNumeric(palette ='Set3' , domain = k3@data$'일인가구')");
			r.eval("mypopup <- paste0(mymap$name,'<br> 1인가구: ',k3@data$'일인가구')");
			//지도 출력			
			//System.out.println(r.eval("k3").asStrings()[0]);
			r.eval("map7 <- NULL");
			r.eval("map7<-leaflet(k3) %>%" + 
					"addTiles()%>%" + 
					"setView(lat=37.52711, lng=126.987517, zoom=11)%>%" + 
					"addPolygons(stroke =FALSE," + 
					"fillOpacity = .7," + 
					"popup = mypopup," + 
					"color = ~mypalette(k3@data$일인가구)) %>% " + 
					"addLegend( values = ~k3@data$일인가구," + 
					"pal = mypalette ," + 
					"title = '인구수'," + 
					"opacity = 1)");
			String fileName = path + "/index.html";
			r.eval("saveWidget(map7,'"+fileName+"',  selfcontained = F)");	        
			retStr = r.eval("'index.html'").asString();
		
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close(); 
		}
		return retStr;
	}
}

