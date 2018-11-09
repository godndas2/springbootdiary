package com.github.godndas2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.godndas2.repository.DiaryInterface;
/**
 * 
 * @SpringBootApplication으로 자동 구성이 가능하다.
 *
 */
@SpringBootApplication
public class SpringBootDiaryApplication {

	@Bean
	InitializingBean saveData(DiaryInterface di) {
		return() ->{
			di.save(new Diary("Spring-Boot-Start1","Gute","11/09/2018"));
			di.save(new Diary("Spring-Boot-Start2","Gute2","11/10/2018"));
			di.save(new Diary("Spring-Boot-Start3","Gute3","11/11/2018"));
			di.save(new Diary("Spring-Boot-Start4","Gute4","11/12/2018"));
		};
		// InitializingBean은 스프링 엔진이 인스턴스 생성 후 초기화 할 때 항상 호출하는 특수 클래스
		// saveData는 스프링 시동 준비 전에 실행된다.
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDiaryApplication.class, args);
	}
}
