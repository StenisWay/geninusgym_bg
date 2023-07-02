package brian_background.serviceimpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import brian_background.service.MeHomeService;
import util.CommonConstants;

public class MeHomeServiceImpl implements MeHomeService{

	@Override
	public Boolean timeCompare(String time) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime nowTime = LocalDateTime.now();
		LocalDateTime getTime = LocalDateTime.parse(time ,df);
		Duration duration = Duration.between(getTime, nowTime);
		Long result = duration.toMinutes();
		System.out.println(result);
		return !(result > 5);
	}

	@Override
	public void personPlus() {
		CommonConstants.branchpeople += 1;
	}
	
}
