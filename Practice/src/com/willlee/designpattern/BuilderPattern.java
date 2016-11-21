package com.willlee.designpattern;

public class BuilderPattern {
	private int id;
	private int classId;
	private int schoolId;
	private String name;
	private String className;
	private String schoolName;
	private String sex;
	private String age;

	public static class Builder {
		// 非空信息，限定值（必须填的）
		private int id;
		private int classId;
		private int schoolId;
		// 选择信息，可以不填的，不填默认为“未设定”
		private String name = "未设定";
		private String className = "未设定";
		private String schoolName = "未设定";
		private String sex = "未设定";
		private String age = "未设定";

		// builder构造方法 必须设置限定属性的值
		public Builder(int id, int classId, int schoolId) {
			this.id = id;
			this.classId = classId;
			this.schoolId = schoolId;
		}

		// 外部提供的设置可选属性的值
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder className(String className) {
			this.className = className;
			return this;
		}

		public Builder schoolName(String schoolName) {
			this.schoolName = schoolName;
			return this;
		}

		public Builder sex(String sex) {
			this.sex = sex;
			return this;
		}

		public Builder age(String age) {
			this.age = age;
			return this;
		}

		public BuilderPattern build() {
			return new BuilderPattern(this);
		}

	}

	// 私有化构造方法 外部不能直接new student
	private BuilderPattern(Builder builder) {
		// 通过赋值这种方法来检测传入的值得正确性 不正确会抛出异常
		this.id = builder.id;
		this.classId = builder.classId;
		this.schoolId = builder.schoolId;
		this.name = builder.name;
		this.className = builder.className;
		this.schoolName = builder.schoolName;
		this.age = builder.age;
		this.sex = builder.sex;
	}

	// 提供访问对象各项属性数据的接口
	public int getId() {
		return id;
	}

	public int getClassId() {
		return classId;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public String getSex() {
		return sex;
	}

	public String getAge() {
		return age;
	}

	public static void main(String[] args) {
		BuilderPattern student = new BuilderPattern.Builder(2012, 10086, 13800)
				.name("罗康").age("20").sex("男").build();
		System.out.println("名字：" + student.getName() + " - 学校名："
				+ student.getSchoolName() + " - 性别：" + student.getSex());
	}
}
