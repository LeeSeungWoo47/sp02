package org.zerock.web;




import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ContentVO;

@CrossOrigin
@RestController   //데이터만제공하는형태에 최신꺼 좋은거임 그냥 컨트롤러보다
@RequestMapping("/cps/*")
public class ContentController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ContentController.class);
	
	@RequestMapping(value="/test", produces={"text/plain; charset=UTF-8"})
	public String sayHello(){
		
		return "안녕";
	}
	
	@PostMapping("/")
	public String register(@RequestBody ContentVO vo){
		
		logger.info("VO : "+ vo);
		return "success";
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable("id") String contentId){
		logger.info("delete id: " + contentId);
		return "success";
	}
	
	@PutMapping("/{id}")
	@PatchMapping("/{id}")
	public String update(@RequestBody ContentVO vo){
		logger.info("update : " +vo);
		return "success";
	}
	
	@CrossOrigin
	@GetMapping("/pages/{num}")
	public List list(@PathVariable("num") Integer num){
		
		List<ContentVO> list = new ArrayList<ContentVO>();
		
		for(int i = 1; i <= 10; i++){
			
			ContentVO vo = new ContentVO();
			vo.setContent("C" + (i*num));
			vo.setWriter("writer");
			list.add(vo);
		}
		return list;
		
	}
	
}
