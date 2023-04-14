package chapter8.innerClass;

public class ObjectArrayInnerClass {
	class Student {
		private int sid;
		private String sname;

		Student(int sid, String sname) {
			this.sid = sid;
			this.sname = sname;
		}
		

		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + "]";
		}


		void show() {
			//System.out.println("sid = " + sid + ", sname : " + sname);
			System.out.println(this.toString());
		}

		public static void main(String[] args) {
			int[] data = new int[10];
			Student[] sdata = new Student[10];
			
			ObjectArrayInnerClass my = new ObjectArrayInnerClass();
			data[0] = 10;
			sdata[0] = my.new Student(2023, "hong");
			sdata[1] = my.new Student(2022, "kim");
			sdata[2] = my.new Student(2021, "lee");
			sdata[3] = my.new Student(2020, "park");
			sdata[4] = my.new Student(2019, "choi");

			for (int i = 0; i < 5; i++) {
				sdata[i].show();
			}

		}

	}

}
