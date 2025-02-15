package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {
	public static String thread1;
	public static String thread2;
	public static String timeEastern;
	public static String timeMountain;
	public static String timeUTC;
	static ExecutorService messageExecutor=newFixedThreadPool(5);
	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
		Properties properties=new Properties();
		messageExecutor.execute(()-> {
			try {
				InputStream stream = new ClassPathResource("welcome_english.properties").getInputStream();
				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
				thread1 = properties.getProperty("welcome");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		messageExecutor.execute(()-> {
			try {
				InputStream stream = new ClassPathResource("welcome_french.properties").getInputStream();
				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
				thread2 = properties.getProperty("welcome");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		ZoneId zEastern = ZoneId.of("America/New_York");
		ZoneId zMountain = ZoneId.of("America/Denver");
		ZoneId zUTC = ZoneId.of("UTC");
		ZoneId zoneId=ZoneId.systemDefault();

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Local time: " + localDateTime);
		ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

		ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
		LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
		timeEastern = localDateTimeEastern.toString();
		System.out.println("Eastern time "+localDateTimeEastern.toString());

		ZonedDateTime zonedDateTimeMountain =zonedDateTime.withZoneSameInstant(zMountain);
		LocalDateTime localDateTimeMountain= zonedDateTimeMountain.toLocalDateTime();
		timeMountain = localDateTimeMountain.toString();
		System.out.println("Mountain time "+localDateTimeMountain.toString());

		ZonedDateTime zonedDateTimeUTC =zonedDateTime.withZoneSameInstant(zUTC);
		LocalDateTime localDateTimeUTC= zonedDateTimeUTC.toLocalDateTime();
		timeUTC = localDateTimeUTC.toString();
		System.out.println("UTC time "+localDateTimeUTC.toString());
	}


}