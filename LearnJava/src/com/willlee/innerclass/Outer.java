package com.willlee.innerclass;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * java内部类
 * 
 * 内部类是指在一个外部类的内部在定义一个类 内部类作为外部类的一个成员，并且依附外部类而存在。
 * 内部类可以为静态，可用protected和private修饰（而外部类不可以，外部类只能用public和default）。
 * 分类：成员内部类、局部内部类、静态内部类、匿名内部类。
 * 
 * @author Administrator
 * 
 */
public class Outer {
	/**
	 * 成员内部类 代码
	 */
	private static int i = 1;
	private int j = 10;
	private int k = 20;

	public static void outer_f1() {

	}

	public void outer_f2() {

	}

	/**
	 * 外部类的非静态方法访问成员内部类
	 */
	public void outer_f3() {
		Inner inner = new Inner();
		inner.inner_f1();
	}

	/**
	 * 外部类的静态方法访问成员内部类
	 */
	public static void outer_f4() {
		// step1 建立外部类对象
		Outer outer = new Outer();
		// step2 根据外部类对象建立内部类对象
		Inner inner = outer.new Inner();
		// step3 访问内部类方法
		inner.inner_f1();

	}

	/**
	 * 成员内部类 作为外部类的一个成员存在，与外部类的属性、方法并列。 优点：
	 * 1、内部类作为外部类的成员，可以访问外部类的私有成员或属性。（即使声明为private，但是对于处于其内部的内部类还是可见的。）
	 * 2、可以内部类定义在外部类不可访问的属性。这样就在外部类中实现了比外部类private还要小的额访问权限。 注意：
	 * 1、内部类是一个编译时的概念，一旦编译成功，就会成为完全不同的两个类。
	 * 对于一个名为Outer的外部类和其内部定义的名为Inner的内部类。编译完成后出现Outer.class 和 Outer$Inner.class
	 * 两个类 2、当Outer是一个private类时，外部类对于其外部访问是私有的，所以就无法建立外部类对象，进而也无法建立内部类对象。
	 * 
	 * @author Administrator
	 * 
	 */
	class Inner {
		// static int inner_i=100; 内部类中不允许定义静态变量，内部类作为外部类的一个成员，成员内部不允许定义静态变量.
		int j = 100;// 内部类和外部类的实例变量可以共存
		private int inner_i = 1;

		void inner_f1() {
			System.out.println(inner_i);
			System.out.println(j);// 在内部类中访问内部类自己的变量直接使用变量名
			System.out.println(this.j);// 或者使用this.变量名
			System.out.println(Outer.this.j);// 在内部类中访问外部类中与内部类同名的实例变量
												// 用外部类名.this.变量名
			System.out.println(k);// 如果内部类中没有与外部类同名的变量，则可以直接用变量名访问外部类变量
			outer_f1();
			outer_f2();
		}
	}

	/**
	 * 局部内部类代码
	 */

	private int s = 100;
	private int out_i = 1;

	public void outer_f5(final int k) {
		final int s = 200;
		int i = 1;
		final int j = 10;
		/**
		 * 局部内部类 在方法中第一的内部类称为局部内部类。
		 * 与局部变量类似，在局部内部类前不加修饰符public和private，其范围为定义它的代码块 注意：
		 * 1、在类外不可直接生产局部内部类（保证局部内部类对外是不可见的）。
		 * 2、要想使用局部内部类时需要生产对象，对象调用方法，在方法中才能调用局部内部类。
		 * 3、通过内部类和接口达到一个强制的弱耦合，用局部内部类来实现接口，并在方法中返回接口类型，使局部内部类不可见，屏蔽实现类的可见性。
		 * 
		 * @author Administrator
		 * 
		 */
		class Inner {
			int s = 300;// 可以定义与外部类同名的变量

			// static int m=20;不可以定义静态变量
			/**
			 * 内部类构造函数
			 */
			Inner(int k) {
				inner_f(k);
			}

			int inner_i = 100;

			/**
			 * 内部类的方法
			 * 
			 * @param k
			 */
			void inner_f(int k) {
				System.out.println(out_i);// 如果内部类没有与外部类同名的变量，在内部类中可以直接访问外部类的实例变量
				System.out.println(j);// 可以访问外部类的局部变量（即方法内的变量，但是变量必须是final）
				System.out.println(s);// 如果内部类中有与外部类同名的变量，直接用变量名访问的是内部类的变量
				System.out.println(this.s);// 用this.变量名 访问的也是内部类变量
				System.out.println(Outer.this.s);// /用外部类名.this.内部类变量名 访问的是外部类变量
			}
		}

		new Inner(k);
	}

	/**
	 * 静态内部类代码 注意： 前三种内部类与变量类似，所以可以对照参考变量
	 */
	private static int a = 1;
	private int b = 10;

	public static void outer_f6() {

	}

	public void outer_f7() {

	}

	/**
	 * 静态内部类 静态内部类可以使用public，protected，private修饰，静态内部类中可以定义静态和非静态的成员。 注意：
	 * 一个静态内部类不需要一个外部类的成员：只是静态内部类和成员内部类的区别。静态内部类的对象可以直接生成 Outer.Inner2 in=new
	 * Outer.Inner2(); 这实际上静态内部类成为了一个顶级类。 静态内部类不可用private来进行定义。
	 * 当类与接口（或者是接口与接口）发生方法命名冲突的时候，此时必须使用内部类来实现。用接口不能完全地实现多继承，用接口配合内部类才能实现真正的多继承。
	 * 例子：
	 * class People{ run(); } 
	 * interface Machine{ run(); } 
	 * class Robot extends People implement Machine
	 * 
	 * @author Administrator
	 * 
	 */
	static class Inner2 {
		static int inner_i = 100;
		int inner_j = 200;

		static void inner_f1() {
			System.out.println("Outer.a:" + a); // 静态内部类只能访问外部类的静态成员
			outer_f6();// 包括静态变量和静态方法
		}

		void inner_f2() {
			// System.out.println("Outer.b:"+b); 静态内部类不能访问外部类的非静态成员
			// outer_f7(); X 包括非静态变量和非静态方法
		}
	}

	/**
	 * 外部类访问静态内部类
	 */
	public void outer_f8() {
		// 外部内访问内部类的静态成员：内部类.静态成员
		System.out.println(Inner2.inner_i);
		Inner2.inner_f1();
		// 外部类访问内部类非静态成员：实例化内部类
		Inner2 inner = new Inner2();
		System.out.println(inner.inner_j);
		inner.inner_f2();

	}

	/**
	 * 匿名内部类
	 * 
	 * 匿名内部类就是没有名字的内部类。 注意： 1、匿名内部类不能有构造函数 2、匿名内部类不能定义任何静态成员、方法和类
	 * 3、匿名内部类不能是public、protected、private、static 4、只能创建匿名内部类的一个实例
	 * 5、一个匿名内部类一定是在new后面，用其隐含实现一个接口或实现一个类。 6、因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效
	 * 
	 * @return
	 */
	public Contents outer_f9() {

		return new Contents() {
			private int i = 10;

			@Override
			public int getValue() {
				// TODO Auto-generated method stub
				return i;
			}

		};// 在匿名内部类末尾的分号，并不是用来标记此内部类结束（C++中是那样）。实际上，它标记的是表达式的结束，只不过这个表达式正巧包含了内部类罢了。因此，这与别的地方使用的分号是一致的。

		// 等同于
		// class MyContents implements Contents {
		// private int i=10;
		// @Override
		// public int getValue() {
		// // TODO Auto-generated method stub
		// return i;
		// }
		//
		// }
		// return new MyContents();
	}

	public Wrapping outer_f10(int x) {
		final int z = x;
		return new Wrapping(x) {
			public void dest() {
				System.out.println("outer_f10: " + z);// 可以访问外部内的局部变量（即方法内的变量，但是变量必须是final）
			}
		};
	}

	public static void main(String[] args) {

		outer_f4();// 成员内部类
		new Outer().outer_f5(4);// 局部内部类
		new Outer().outer_f8();// 静态内部类
		new Outer().outer_f9().getValue();// 匿名内部类
		new Outer().outer_f10(8).dest();// 匿名内部类
		InnerClassTest obj = new InnerClassTest();
		obj.launchFrame();
	}

}

/**
 * 一个内部类的简单应用
 * 
 * @author Administrator
 * 
 */
class InnerClassTest {
	private Frame f;
	private TextField tf;

	public InnerClassTest() {
		f = new Frame("Inner classes example");
		tf = new TextField(30);
	}

	public void launchFrame() {
		Label label = new Label("Click and drag the mouse");
		f.add(label, BorderLayout.NORTH);
		f.add(tf, BorderLayout.SOUTH);
		// 成员内部类
		f.addMouseMotionListener(new MyMouseMotionListener());/* 参数为内部类对象 */
		// 等效 匿名内部类
		// f.addMouseMotionListener(new MouseMotionAdapter(){
		// public void mouseDragged(MouseEvent e) {
		// String s="Mouse dragging: x="+e.getX()+"Y="+e.getY();
		// tf.setText(s);
		// }
		//
		// });
		f.setSize(300, 200);
		f.setVisible(true);
	}

	class MyMouseMotionListener extends MouseMotionAdapter { /* 内部类开始 */
		public void mouseDragged(MouseEvent e) {
			String s = "Mouse dragging: x=" + e.getX() + "Y=" + e.getY();
			tf.setText(s);
		}
	}
	// 内部类结束
}

interface Contents {
	int getValue();
}

class Wrapping {
	int j;

	Wrapping(int i) {
		j = i;
	}

	public void dest() {
		System.out.println("Wrapping:" + j);
	}
}