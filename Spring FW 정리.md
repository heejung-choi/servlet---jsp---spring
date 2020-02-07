# Spring FW



1998년 EJB 라는 기술의 FrameWork의 시초가 되었다.

2005년 정도 부터 FrameWork 기반의 개발이 주류를 이루게 된다.

--------------------

FramWork는 **반제품형태의 SW**라고 많이 이야기 한다.

즉, 어느정도 완성되어 있는것을 썼기 때문에 **개발생산성과 유지보수성**이 높다.

Struts, Spring, Mybatic(iBatis), Hibernate .... 

--------

​								[JDBC]

Spring IoC(필요한 객체를 외부에서 만들어준다.), Spring JDBC, String MVC, Spring Android, Spring Hadoop ...			 

​				

[ Spring FW]

- 고급 API 





![image-20200205142944571](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205142944571.png)

![image-20200205142924735](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205142924735.png)

![image-20200205143551667](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143551667.png)

![image-20200205143530271](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143530271.png)





Eclipse EE - Eclipse for Java Developer + WTP(플러그인:pligin) +STS 추가설치

(1) Spring IoC -> Java Application -> SpringIoC

(2) Spring MVC -> Web 기반 -> 

(3) Mybatis -> Web 기반



### 아파치 메이븐

- 아파치 메이븐(Apache Maven)은 자바용 프로젝트 관리 도구이다. 아파치 앤트의 대안으로 만들어졌다. 아파치 라이선스로 배포되는 오픈 소스 소프트웨어 이다.
- 프로젝트 관리 도구 주로 API를 관리해준다.



# Spring 

- 스프링컨테이너가 관리해주는 것 bean
- 일반 값이면 value 객체면 ref
- index를 생략하면 작성 순서에 따라 호출된다.
- 문서 형식 정의(Document Type Definition, DTD)는 컴퓨터 용어로, SGML 계열의 마크업 언어에서 문서 형식을 정의하는 것이다. SGML을 비롯해 HTML, XHTML, XML 등에서 쓰인다.
- XML Schema는 더 세세히 지정할 수 있다.
- autowire : 객체를 생성할때 자동으로 결합해달라는 의미이다.

- autowire="byName"  : setter
  (1) 프로퍼티명과 동일한 명칭의 빈을 찾아서 해당 객체 주입
  (2) 없으면 null 주입

- autowire="byType"  : setter 의 아규먼트 
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 NoUniqueBeanDefinitionException 발생
  (3) 없으면 null 주입

- autowire="constructor"  : constructor (타입으로 찾아서 2개이면 동일한 id값을 갖는다.)
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 매개변수명과 동일한 id 값을 갖는 객체 주입
  (3) 없으면 null 주입



- 필드에 설정된 @Autowired  - Spring FW 전용
  (1) 타입으로 찾아서 1개이면 해당 객체 주입
  (2) 타입으로 찾아서 2개 이상이면 변수명과 동일한 id 값을 갖는 객체 주입
  (3) 없으면 NoSuchBeanDefinitionException 발생
       (required = false 속성을 사용하여 없으면 null 이 되게 지정 가능)
  (4) @Qualifier(value="xxx")를 추가로 사용해서 변수명이 아닌 다른 이름 지정 가능

- 필드에 설정된 @Resource  - Java
  (1) 변수명과 동일한 id 값을 갖는 빈을 찾아서 해당 객체 주입
  (2) 타입으로 찾아서 1개이면 객체 주입
  (3) 타입으로 찾아서 2개이상 이면 NoUniqueBeanDefinitionException 발생
  (4) 없으면 NoSuchBeanDefinitionException 발생



- Spring MVC Project : springedu

 패키지명 : my.spring.springedu

http://localhost:8000/springedu
톰캣재기동 한후에
http://localhost:8000/springedu/hello



# spring mvc 프로젝트 생성하는 법



![image-20200207133425073](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207133425073.png)

![image-20200207133447204](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207133447204.png)



패키지명을 세개 입력해야 한다.

![image-20200207133616866](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207133616866.png)

my.spring.springedu

마지막 패키지명은 project 명과 같게 해야 한다.

![image-20200207134711247](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207134711247.png)

![image-20200207134740365](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207134740365.png)



# Spring MVC

spring project는 webcontent가 없다.

![image-20200207141545306](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207141545306.png)

src-main-webapp-resoures에 이미지, html파일을 넣어야 한다. 다른곳에 넣으면 인식을 못한다. ->클라이언트에 직접 넣을 수 있는것

![image-20200207142318892](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207142318892.png)

UTF-8로 변경 



![image-20200207142650041](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207142650041.png)

web.xml 에 해당내용 저장 

<filter>
<filter-name>encodingFilter</filter-name>
<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
<!-- 이 서버에 있는 모든 페이지는 CharacterEncodingFilter라는 필터를 거쳐라-->
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
<!-- 인코딩이라는 이름이 UTF-8 이라는 값을 저장-->
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>



![image-20200207151525956](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207151525956.png)

**my.spring.springedu** : 컨트롤러 저장하는 파일

![image-20200207152415687](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207152415687.png)

html / views 저장하는 파일