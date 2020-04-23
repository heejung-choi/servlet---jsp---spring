package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/*컴포넌트 또는 서비스라고 에노테이션을 주면 된다 조상이 컴포넌트이기 때문에*/
@Service
public class SpringSchedulerTest {
   //@Scheduled(cron="10 * * * * *")//초,분,시,일,월,요일(1:일요일)
	@Scheduled(cron="10 * * * * 5")//월요일 (2) 화요일 (3)... 이런식
	//cron 리눅스에 보면 크론 탭이 있다.
   @Scheduled(fixedDelay=10000)//10초간격으로
   //fixedRate -> 무조건 10초마다 수행시키고 싶다면
	public void scheduleRun() {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat(
				                                       "yyyy-MM-dd HH:mm:ss");
		try {
			Thread.sleep(2000); /* 이부분 때문에 2초간 쉬어 라고 했기 때문에
			Scheduled+2초 동안 수행된다. */
		}catch(Exception e) {
			
		}
		System.out.println(new java.util.Date()+"스케줄 실행:"+dateFormat.format(calendar.getTime()));
		
	}
}
