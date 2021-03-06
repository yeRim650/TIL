## File
* ### class file
    * 01.파일(a.txt)
    * 02.디렉토리(경로) : 논리적 식별자 - 크기가 없다(윈도우 폴더 = 디렉토리)
* (UNIX 구별자 '/')
* (윈도우 구분자 '\' 자바에서 이미 쓰고 있기 때문에 '\\' 2개로 표현)
* (USB나 CD-ROM도 file개념 인지)
* file class는 불변(immytable) 변경 불가
* 컴퓨터에서 파일을 관리해주는 file-system = O/S
* 자바가 운영체제에게 파일을 만들어달라고 요청 
* 거부하는 경우가 있다 권한이 없다 또는 접근할 수 없는 위치 코드로 해결 불가능 : 강제 예외처리
#### 절대경로/상대경로
* 절대 경로 표기법(root - 상대적)
   * c:\first\a.txt
   * root부터 경로를 풀어냄
   * root의 의미가 다를 수 있다
* 상대경로 표기법(현재 위치 기준)
   * 같은 위치 바로 하위에 있는 경우 사용

><img src="https://postfiles.pstatic.net/MjAyMjA2MDdfMTY5/MDAxNjU0NjA5MzUyNzUz._Vb78WR0Zjs4bfobuQy2uBt2q-eIAb1uRu1Jtj5sV5Ig.ZEUws99DPpGy_lhfEoUjeM5cNsaDOsZTyDiyuOWo8T4g.PNG.forget980/image.png?type=w580" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

>  현재위치가 변경될 때마다 상대경로가 변경되기 때문에 절대 경로 표기법 사용

>```java
>public class FileEx {
>	public static void main(String[] args) {
>		/*
>		 * 물리적 파일 : 디스크상에 실제로 존재하는 파일
>		 * 논리적 파일 : 코드상에서만 존재
>		 */
>		File f = new File("c:\\test\\some.txt"); //논리적인 파일
>		System.out.println(f.exists());//실제 경로에 파일이 존재하는지 확인
>		if(!f.exists()){//이미 존재하는 파일인지 확인
>			try{
>				f.createNewFile();//파일 생성
>			}catch(IOException e){//강제 예외처리
>				//file 관리 system o/s 자원관리 요청
>           			//코드로 해결 x 외부 문제
>				e.printStackTrace();
>			}
>		}else{
>			f.delete();//파일 삭제
>		}
>	}
>}
>```
>```java
>public class FileEx {
>	public static void main(String[] args) {
>		// c:\\test\\a.txt
>		File f1 = new File("c:\\test\\a.txt");
>		File dir = new File("c:\\text");//파일이 아닌 경로를 나타낸다.
>		File f2 = new File(dir,"a.txt");
>		File f3 = new File("c:\\text", "a.txt");
>     		//f1, f2, f3 동일한 파일 표현
>		//경로 나타내는 거지 저장 공간을 가지는게 아니다
>	}
>}
>```
