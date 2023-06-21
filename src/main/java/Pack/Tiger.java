package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Tiger {
	@RequestMapping("/") //기본 인덱스
	public String func00() {
		System.out.println("index controller");
		return "index";
	}
	
	@RequestMapping("/t1") //기본 인덱스
	public String func01() {
		System.out.println("function01 call");
		return "TigerView";
	}
	
	@RequestMapping("/t2/{Num}") //기본 인덱스
	public String func02(@PathVariable String Num) {
		System.out.println("function02 call" + Num);
		return "TigerView";
	}
	
	
}

//@Controller
//@ResponseBody
@RestController
@RequestMapping("t3")
class Lion{
	
	@RequestMapping("")
	public String func01() {
		System.out.println("Lion class func01");
		return "문자열이나 객체 전송";
	}
	
	@RequestMapping("/{Num}")
	public String func02(@PathVariable String Num) {
		System.out.println("Lion class func02");
		return "문자열" + Num;
	}
	@RequestMapping("/t4/{Num}")
	public String func03(@PathVariable String Num) {
		System.out.println("Lion class func03");
		return "문자열" + Num;
	}
}

interface A {
	void f1();
}

@Service
class ImplA implements A{
	public ImplA(){
		System.out.println("ImplA constructor");
	}
	@Override
	public void f1() {
		System.out.println("ImplA call");
	}
}

@Controller
class B{
	@Autowired
	A a = null;//ImplA가 a에 자동주입된다. 
	
	@RequestMapping("t6")
	public String func() {
		if(a!=null) a.f1();
		return "TigerView";
	}
}

////형식1
//@Controller
//@RequestMapping
//class Lion{}
//
////형식2
//@Controller
//class Lion2{
//	@RequestMapping("/Lion02")
//	public void lion02Func() {}
//}
//
////형식3
//@Controller
//@RequestMapping
//class Lion3{
//	@RequestMapping("/Lion03")
//	public void lion03Func() {}
//}
//
////형식 4
//@Controller
//@RequestMapping
//class Lion4{
//	@RequestMapping("/Lion04")
//	@ResponseBody
//	public void lion04Func() {}
//}


// @Controller: 뷰를 반환
// @Controller + @ResponseBody: 데이터 반환
// @RestController: @Controller + @ResponseBody
// @Componenet @Controller @Service @Repository: 객체를 생성시킴. 각각 사용 용도가 다르다. 