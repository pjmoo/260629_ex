# Java 동시성·함수형 프로그래밍 실습과 강의 자료

이 workspace에는 Java 실행 예제 9개와 해설 9개, 날짜별 강의 PDF 103개가 있습니다. src에서는 스레드, 동기화, 비동기 처리, 람다와 Stream을 실습하고, 새 폴더에서는 브라우저 개발부터 Java 웹 개발까지의 개념을 복습합니다.

## 폴더 구성

| 위치 | 내용 |
| --- | --- |
| src/ | Solution01~09 Java 코드와 같은 이름의 Markdown 해설 |
| [새 폴더](<./새 폴더/README.md>) | PDF가 있는 51개 날짜 폴더의 PDF 103개와 날짜별 README |
| .idea/ 및 260629_ex.iml | IntelliJ 프로젝트 설정 |
| out/ | 컴파일 결과 저장 폴더 |

## 코드별 학습 내용

| 코드와 해설 | 학습 내용 |
| --- | --- |
| [Solution01.java](./src/Solution01.java) · [해설](./src/Solution01.md) | 공유 카운터의 경쟁 상태와 스레드별 지역 변수 |
| [Solution02.java](./src/Solution02.java) · [해설](./src/Solution02.md) | synchronized와 ReentrantLock·tryLock |
| [Solution03.java](./src/Solution03.java) · [해설](./src/Solution03.md) | AtomicInteger와 ConcurrentHashMap |
| [Solution04.java](./src/Solution04.java) · [해설](./src/Solution04.md) | ExecutorService 작업 제출과 종료 |
| [Solution05.java](./src/Solution05.java) · [해설](./src/Solution05.md) | CompletableFuture의 예외 복구와 완료 대기 |
| [Solution06.java](./src/Solution06.java) · [해설](./src/Solution06.md) | 람다·함수형 인터페이스·메서드 참조 |
| [Solution07.java](./src/Solution07.java) · [해설](./src/Solution07.md) | record 객체의 사용자 정의 정렬 |
| [Solution08.java](./src/Solution08.java) · [해설](./src/Solution08.md) | filter·limit·map의 지연·단락 평가 |
| [Solution09.java](./src/Solution09.java) · [해설](./src/Solution09.md) | reduce와 병렬 Stream 결과 수집 |

Solution01~05는 [6/29 동시성 강의](<./새 폴더/6-29/README.md#pdf-222-3>), Solution06~09는 [함수형 프로그래밍 강의](<./새 폴더/6-29/README.md#pdf-222-4>)와 연결됩니다.

## 실행 방법

외부 라이브러리 없이 JDK 표준 API를 사용합니다. 코드에 record와 Stream.toList()가 있으므로 JDK 16 이상이 필요합니다. IDE와 터미널의 JDK 설정을 맞춘 뒤 workspace 루트에서 실행합니다.

```powershell
java -version
javac -version
javac -encoding UTF-8 -d out src/Solution*.java
java -cp out Solution08
```

IntelliJ에서는 프로젝트를 열고 Project SDK와 src의 소스 루트 설정을 확인한 뒤 원하는 클래스의 main을 실행합니다. 클래스마다 주석 처리된 다른 실험이 있으므로 실제 호출되는 메서드를 먼저 확인합니다.

## 실행 결과 해석

- 동시성 예제는 실행 순서와 공유 상태를 관찰하는 실험입니다. 경쟁 상태가 한 번의 실행에서 나타나지 않아도 안전성이 입증되는 것은 아닙니다. 자동으로 PASS를 출력하는 테스트 모음은 아닙니다.
- Solution01은 반복 대기 코드 때문에 실행에 시간이 걸릴 수 있습니다. 공유 카운터와 스레드별 지역 변수 결과를 구분합니다.
- Solution05는 의도적으로 예외를 발생시켜 exceptionally의 복구 결과가 마지막 단계로 전달되는 흐름을 보여줍니다.
- Solution06은 현재 main에서 출력 메서드 호출이 주석 처리되어 콘솔 출력 없이 종료될 수 있습니다. 디버거에서 배열 값과 함수 참조를 관찰하거나 runOld·runNew 호출로 비교합니다.
- Solution08은 첫 조건 충족 항목인 Park까지만 처리해 PARK를 출력합니다. 로그로 filter와 map의 호출 순서를 확인합니다.
- Solution09는 결과를 result에 수집하지만 별도의 빈 list 크기를 출력합니다. 현재 출력의 0을 병렬 수집 실패로 해석하지 말고 디버거에서 result.size()를 확인합니다.

## 학습 순서

[Java 문법과 컬렉션](<./새 폴더/6-17/README.md>) → [객체와 클래스](<./새 폴더/6-23/README.md>) → [예외 처리](<./새 폴더/6-26/README.md>) → [동시성·함수형 프로그래밍](<./새 폴더/6-29/README.md>) 순으로 읽고 코드를 실행합니다. 이후 [Servlet과 JSP](<./새 폴더/6-30/README.md>)에서 요청 처리와 화면 구성으로 확장합니다.

브라우저·AI 웹앱·알고리즘 자료는 [전체 강의 목차](<./새 폴더/README.md>)에서 찾을 수 있습니다. 날짜별 README의 복습 과제는 추가 학습 제안이며 해당 기능이 모두 src에 구현되어 있다는 뜻은 아닙니다.

## 7월 추가 강의

7/1~7/30의 PDF 37개를 날짜별 README 21개에 정리했습니다. [전체 목차](<./새 폴더/README.md>)에서 기존 자료와 함께 읽을 수 있습니다.

- [JSP와 웹 아키텍처](<./새 폴더/7-1/README.md>) → [Spring Core·MVC·Boot](<./새 폴더/7-6/README.md>)
- [DB·SQL](<./새 폴더/7-9/README.md>) → [JDBC](<./새 폴더/7-16/README.md>) → [MyBatis](<./새 폴더/7-21/README.md>) → [JPA](<./새 폴더/7-23/README.md>)
- [Spring AI](<./새 폴더/7-27/README.md>) → [대화와 구조화 출력](<./새 폴더/7-28/README.md>) → [RAG·VectorDB](<./새 폴더/7-30/README.md>)

<!-- workspace-readme-learning:start -->
## workspace 전체 저장소와 연결

이번 README 정리 범위는 `C:\workspace` 아래 모든 저장소와 그 안의 README입니다. [전체 저장소 작업 목록](<WORKSPACE_README_REPORT.md>)에서 프로젝트별 안내를 확인할 수 있습니다.

<!-- workspace-readme-learning:end -->

<!-- pdf-til-supplement:start -->
## TIL 부연 설명 — PDF와 연결하기

기존 실습 내용을 이해하기 위한 PDF 기반 부연 설명이다. 아래 예시는 개념을 설명하기 위한 것이며, 이 프로젝트에서 실행해 관찰한 결과와는 구분한다. 페이지 번호는 표지를 포함한 PDF 순서다.

함께 읽을 파일: [Solution01.java](<src/Solution01.java>) · [Solution02.java](<src/Solution02.java>) · [Solution03.java](<src/Solution03.java>)

### 공유 상태와 작업 완료를 따로 확인하기

여러 스레드는 같은 객체의 필드를 공유할 수 있다. count++는 읽기·증가·쓰기 단계로 이루어져 동시에 실행되면 갱신을 잃을 수 있다. synchronized나 원자적 연산은 공유 상태의 변경을 보호하고, join이나 Future의 완료 대기는 결과를 읽을 시점을 정한다.

**예시로 이해하기:** 두 스레드가 모두 10을 읽고 11을 쓰면 두 번 증가했어도 결과는 11이다. 지역 변수로 누적한 뒤 합치는 방식은 공유 쓰기를 줄인다. CompletableFuture의 예외 복구 단계가 값을 반환하면 그 값이 다음 정상 처리 단계로 넘어가는 것도 함께 추적한다.

근거: 222-3 Java Concurrency — [7쪽](<새 폴더/6-29/222-3_Java_Concurrency.pdf#page=7>) · [12쪽](<새 폴더/6-29/222-3_Java_Concurrency.pdf#page=12>) · [16쪽](<새 폴더/6-29/222-3_Java_Concurrency.pdf#page=16>) · [18쪽](<새 폴더/6-29/222-3_Java_Concurrency.pdf#page=18>)

### Stream의 지연 평가와 결과 수집

Stream의 filter·map 같은 중간 연산은 파이프라인을 구성하고 최종 연산이 실행을 이끈다. limit이나 findFirst는 필요한 결과를 얻으면 뒤 원소의 처리를 줄일 수 있다. 따라서 로그가 전체 filter 뒤 전체 map 순으로 나온다고 가정하면 실제 동작을 오해하기 쉽다.

**예시로 이해하기:** 첫 조건 충족 항목 하나만 필요한 파이프라인은 원소별로 조건 검사와 변환이 이어질 수 있다. 병렬 처리에서 외부 ArrayList에 직접 add하기보다 수집 연산의 반환값을 사용한다. 수집한 변수와 출력하는 변수가 같은지도 확인한다.

근거: 222-4 Java Functional Programming — [13쪽](<새 폴더/6-29/222-4_Java_Functional_Programming.pdf#page=13>) · [18쪽](<새 폴더/6-29/222-4_Java_Functional_Programming.pdf#page=18>) · [19쪽](<새 폴더/6-29/222-4_Java_Functional_Programming.pdf#page=19>) · [21쪽](<새 폴더/6-29/222-4_Java_Functional_Programming.pdf#page=21>) · [24쪽](<새 폴더/6-29/222-4_Java_Functional_Programming.pdf#page=24>)

<!-- pdf-til-supplement:end -->

## 8월 추가 자료와 TIL 부연 설명

8/4~8/20 자료 32개를 포함해 전체 PDF 103개의 날짜별 안내를 연결했습니다. [강의 전체 목차](<새 폴더/README.md>)에서 PDF 원문과 개념 설명을 찾을 수 있습니다. 프로젝트별 README와 TIL 문서에는 관련 주제의 설명·예시·원문 페이지를 추가했습니다.
