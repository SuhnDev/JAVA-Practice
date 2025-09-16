import java.util.Scanner;
public class J0915 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //sc Scanner 변수 생성
		int score, sum=0, many=0; //연산에 필요한 정수형 변수 생성
		//score : 입력받은 숫자 문자열을 숫자로 바꿨을 때 저장할 변수
		//sum : 숫자를 합쳐서 넣을 변수, many : 카운트를 저장할 변수
		String input; //input : 입력받은 문자열 저장할 변수
		String ex = "잘못된 입력입니다.\n-----------------------------------\n"; //ex : 예외시 출력할 텍스트
		while(true) {
			System.out.print("성적을 입력하시오. (정수로만 입력하시오.) \n입력 중지시 q 혹은 Q 아니면 음수를 입력하시오.\n>> "); //성적 입력 조건 설명
			input = sc.next(); //input에 성적 입력받기
			try { //try catch 예외처리
				if(input.charAt(0)=='q' || input.charAt(0)=='Q') {  //q나 Q를 입력받으면 무한반복 탈출 / 스트링변수.charAt(인덱스) : 스트링변수의 인덱스번째의 글자를 char 자료형으로 변환
					break; //질문 할꺼 : q나 quit 아니 qawhdwseir를 입력받아도 프로그램이 종료됨. -> q나 Q 하나만 들어가있는지 확인할 방법?
				}
				else { //숫자 입력
					score = Integer.parseInt(input); //문자열로 입력받은 숫자를 Integer.parseInt(변수명)를 이용해 정수형으로 변환
					if(score < 0) //입력받은 값이 음수라면 탈출
						break;
					else if(score > 100){ //입력받은 값이 100보다 넘는다면 밑 코드를 실행하지 않고 반복문 처음으로 돌아감.
						System.out.print("점수는 0~100 까지의 숫자만 넣을 수 있습니다.");
						continue;
					}
					sum+=score; //sum에 score값을 추가해서 저장
					many++; //카운트 증가
				}
			} catch(NumberFormatException e) { //NumberFormatException 예외객체를 담을 변수명 : 문자열을 숫자로 바꿀 수 없을 때 예외처리
				System.out.print(ex); //ex 예외 출력
			}
		}
		if(many==0) {
			System.out.print("입력된 점수가 없습니다."); //카운트 값이 0인데 무한루프 탈출시 예외 출력
		}
		else {
			double avg=(double)sum/many; //avg 평균 계산 sum을 (double)로 형변환
			char gra; //gra 문자 변수 생성
			if(avg>=90) //평균 등급 계산
				gra = 'A'; 
			else if (avg>=80)
				gra = 'B';
			else if (avg>=70)
				gra = 'C';
			else if (avg>=60)
				gra = 'D';
			else
				gra = 'F';
			System.out.print(many+"명의 평균 성적은 "+avg+", 평균 등급은 "+gra+" 입니다."); //결과 출력
		}
	}
}
