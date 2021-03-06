public class IOEx2 {
	private static String saveFile = "save.dat";
	public static void write(Vector<Some> list){
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream(saveFile);
			dos = new DataOutputStream(fos);
			for(Some temp : list){
				//쓸때는 유형에 따라 메서드
				dos.writeInt(temp.getNum());
				dos.writeUTF(temp.getStr1());
				dos.writeDouble(temp.getNum2());
				dos.writeUTF(temp.getStr2());
			}
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtil.closeAll(dos, fos);
		}
	}
	public static void read(){
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try{
			fis = new FileInputStream(saveFile);
			dis = new DataInputStream(fis);
			//available 읽기 가능한 남은 바이트 수를 추정해서 리턴
			while(dis.available()!=0){//0일때까지 읽는다
				int num1 = dis.readInt();
				String str1 = dis.readUTF();
				double num2 = dis.readDouble();
				String str = dis.readUTF();
				Some s = new Some(num1, str1, str, num2);
				System.out.println(s);
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(dis, fis);
		}
	}
	public static void main(String[] args) {
		Vector<Some> list = new Vector<Some>();
		list.add(new Some(3,"apple","banna",3.14));
		list.add(new Some(3,"tesla","amazon",0.12));
		list.add(new Some(3,"한글","國",100.0));
		list.add(new Some(3,"baby","cat",12.55));
		list.add(new Some(3,"iu","ail",3.14));
		write(list);
		read();
	}
}
class Some {
	private int num;
	private String str1;
	private String str2;
	private double num2;
	//alt + shift + s -> o
	public Some(int num, String str1, String str2, double num2) {
		super();
		this.num = num;
		this.str1 = str1;
		this.str2 = str2;
		this.num2 = num2;
	}
	//alt + shift + s -> r
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}
	//alt + shift + s -> s
	@Override
	public String toString() {
		return "Some [num=" + num + ", str1=" + str1 + ", str2=" + str2 + ", num2=" + num2 + "]";
	}
}
