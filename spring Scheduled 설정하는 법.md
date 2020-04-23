# 1 pom.xml

	<properties>
		<java-version>1.8</java-version>
		<org.springframework-<version>5.0.2.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>
이부분 <java-version> 1.6에서 1.8로 변경

이부분 <version> 5.0.2로 변경

# 2 web.xml

이부분 추가

```
	<filter>
    	<filter-name>encodingFilter</filter-name>
    	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    	<init-param>
      		<param-name>encoding</param-name>
      		<param-value>UTF-8</param-value>
    	</init-param>
  </filter>
  <filter-mapping>
  	<filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

# 3. 설정 오른쪽 버튼

properties

-> project Facets -> java 1.8로 변경