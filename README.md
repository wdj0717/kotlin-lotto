# kotlin-lotto

## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
- 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## 실행결과
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```
## 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.
- 모든 원시값과 문자열을 포장한다.
- 예외 처리를 통해 에러가 발생하지 않도록 한다.

## 요구사항 분석
- [x] 로또 1장의 가격은 1000원이다.
- [x] 로또 1장은 6개의 숫자를 가진다.
- [x] 로또 1장의 숫자는 1~45까지의 숫자이다.
- [x] 로또 1장의 숫자는 중복되지 않는다.
- [x] 로또 1장의 숫자는 오름차순으로 정렬되어 있다.
- [x] 로또 구입 금액을 입력할 수 있다.
- [x] 입력받은 금액을 로또 가격만큼 로또를 구입할 수 있다.
- [x] 입력받은 금액이 로또 가격보다 낮으면 구매할 수 없다.
- [x] 구매한 로또 개수와 구매한 갯수 만큼 로또 번호를 출력한다.
- [x] 당첨번호을 입력할 수 있다.
- [x] 당첨번호는 6자리까지만 입력한다.
- [x] 당첨번호는 1~45까지의 숫자이다.
- [x] 당첨번호는 중복되지 않는다.
- [x] 당첨번호는 쉼표(,)로 구분한다.
- [x] 당첨번호는 숫자만 입력한다.
- [x] 당첨번호와 로또번호를 비교하여 3개 이상 일치하면 5등이다.
- [x] 당첨번호와 로또번호를 비교하여 4개 이상 일치하면 4등이다.
- [x] 당첨번호와 로또번호를 비교하여 5개 이상 일치하면 3등이다.
- [x] 당첨번호와 로또번호를 비교하여 6개 이상 일치하면 1등이다.
- [x] 구입금액과 당첨번호를 입력하면 당첨 통계를 출력한다.
- [x] 보너스 볼을 입력할 수 있다.
- [x] 보너스 볼은 1~45까지의 숫자이다.
- [x] 보너스 볼은 당첨번호와 중복되지 않는다.
- [x] 보너스 볼은 숫자만 입력한다.
- [x] 당첨번호와 로또번호를 비교하여 5개 이상 일치하고 보너스 볼이 일치하면 2등이다.
- [ ] 수동으로 로또 번호를 입력할 수 있다.
- [ ] 수동으로 구매할 로또 개수를 입력할 수 있다.
- [ ] 입력한 수동 로또 개수만큼 로또 번호를 입력한다.
- [ ] 수동으로 입력한 로또 갯수를 제외한 나머지 로또를 자동으로 생성한다.