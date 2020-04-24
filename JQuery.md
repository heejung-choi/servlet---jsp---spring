# jQuery

- $는 자바스크립트 객체를 jquery로 포장해준다.

- $(자바스크립트 객체)
- $('css 선택자')  
  - $('h1') : h1 객체를 찾아서 jquery로 포장해준다.
  -  $('div>p') 

- $('HTML 태그 문자열') -
  
- $('<div>ㅋㅋㅋ</div>').append("#target")
  
- $(함수)
  
  - 이 문서가 끝나면 수행해줘 하는 이벤트 핸들러를 적용한 것과 같다.
  
    

- $ ('CSS선택자', DOM객체)

- attr(), css()

- attr('HTML속성명')   ---> getter
-  attr('HTML속성명', 'HTML속성값')
     attr('HTML속성명', 함수)
     attr({HTML속성명:'HTML속성값',HTML속성명:'HTML속성값',..})
                                 ---> setter

- css('css속성명')   ---> getter
     css('css속성명', 'css속성값')
     css('css속성명', 함수)
     css({css속성명:'css속성값',css속성명:'css속성값',..})
                            ---> setter
                 

-  html()  --> innerHTML
-  text()  --> textContent

- html()  --> getter
-  html('태그문자열')  --> setter



- jQuery. ajax()
  - $.ajax(), $.get(), $.post(), $.getJSON(), $(....).load()

```java
$(.....).each//...에대한 모든것을 찾아서 이 함수를 호출해줘
$.each(배열객체 또는 자바스크립트 객체, 함수)
```
