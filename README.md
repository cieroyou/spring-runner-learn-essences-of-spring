# Learn Essence of Spring

Learn Essence of Spring 워크숍(강좌) 로 공부하는 프로젝트
오류가 있을 때 예외객체로 잡아서 외부로 전파하기 위해 사용됨

Movie : 생성자는 `private` 임 -> 외부에서 Movie 객체를 생성할 수 있도록 스태틱메서드(of) 를 제공함

run 메서드를 호출함

commandActions : 명령어별로 실행할 메서드를 정의함

세개의 명령어가 정의됨 :
- quit
- directedBy, 
- releasedYearBy

ex) console 에 `directedBy Michael Bay` 를 입력하면 첫번재 인자를 명령어로 실행한다.

### Section 03 : JaxB를 이용한 xml파일 읽어오기
`org.glassfish.jaxb:jaxb-runtime` 의존성 버전에 주의한다. 강의대로 `3.0.2` 를 사용하면 다음과 같은 `javax.xml.bind.JAXBException: Implementation of JAXB-API has not been found on module path or classpath. - with linked exception: [java.lang.ClassNotFoundException` 다음 에러가 발생하는데, `jakarta.xml.bind:jakarta.xml.bind-api'` 의존성이 없어서 발생하는 것이므로, 버전을 제거하던가 `2.3.4` 버전을 사용하도록 한다.

### Section 04 : 제어역전
1. 객체 느슨하게 연결하기  
생성자를 통해 의존객체를 외부에서 주입한다.
- `MovieFinder`는 `MovieReader`의 의존성을 가지는데, `MovieReader`를 교체할 때, `MovieFinder`에 코드변경이 일어나지 않는다.
2. 팩토리로 객체 생성  
`Factory`는 주로 객체를 생성하는 쪽과 객체를 사용하는 쪽의 역할과 책임을 분리하는 목적으로 사용
---
일반적인 자바 프로그램 제어 흐름 :   
모든 객체가 능동적으로 자신이 사용할 객체를 결정하고, 언제 어떻게 그 객체를 만들지 스스로 관장한다.
```markdown
* MovieBuddyApplication은 MovieFinder 객체를 생성하고 사용한다.
* MovieFinder 객체는 MovieReader 객체를 생성하고 사용한다.
```
Factory 도입 이후 제어 흐름
```markdown
* Factory로부터 MovieFinder 객체를 취득해서 사용한다.
* Factory가 공급하는 MovieReader 객체를 사용하여 동작한다.
```

![img.png](blob/template/img.png)
![img_2.png](blob/template/img1.png)

---
워크숍(강좌)에 대한 자세한 소개는 [여기](https://springrunner.dev/training/learn-essence-of-spring-workshop/) 에서 볼 수 있다.