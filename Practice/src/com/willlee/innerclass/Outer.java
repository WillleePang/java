package com.willlee.innerclass;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * java�ڲ���
 * 
 * �ڲ�����ָ��һ���ⲿ����ڲ��ڶ���һ���� �ڲ�����Ϊ�ⲿ���һ����Ա�����������ⲿ������ڡ�
 * �ڲ������Ϊ��̬������protected��private���Σ����ⲿ�಻���ԣ��ⲿ��ֻ����public��default����
 * ���ࣺ��Ա�ڲ��ࡢ�ֲ��ڲ��ࡢ��̬�ڲ��ࡢ�����ڲ��ࡣ
 * 
 * @author Administrator
 * 
 */
public class Outer {
	/**
	 * ��Ա�ڲ��� ����
	 */
	private static int i = 1;
	private int j = 10;
	private int k = 20;

	public static void outer_f1() {

	}

	public void outer_f2() {

	}

	/**
	 * �ⲿ��ķǾ�̬�������ʳ�Ա�ڲ���
	 */
	public void outer_f3() {
		Inner inner = new Inner();
		inner.inner_f1();
	}

	/**
	 * �ⲿ��ľ�̬�������ʳ�Ա�ڲ���
	 */
	public static void outer_f4() {
		// step1 �����ⲿ�����
		Outer outer = new Outer();
		// step2 �����ⲿ��������ڲ������
		Inner inner = outer.new Inner();
		// step3 �����ڲ��෽��
		inner.inner_f1();

	}

	/**
	 * ��Ա�ڲ��� ��Ϊ�ⲿ���һ����Ա���ڣ����ⲿ������ԡ��������С� �ŵ㣺
	 * 1���ڲ�����Ϊ�ⲿ��ĳ�Ա�����Է����ⲿ���˽�г�Ա�����ԡ�����ʹ����Ϊprivate�����Ƕ��ڴ������ڲ����ڲ��໹�ǿɼ��ġ���
	 * 2�������ڲ��ඨ�����ⲿ�಻�ɷ��ʵ����ԡ����������ⲿ����ʵ���˱��ⲿ��private��ҪС�Ķ����Ȩ�ޡ� ע�⣺
	 * 1���ڲ�����һ������ʱ�ĸ��һ������ɹ����ͻ��Ϊ��ȫ��ͬ�������ࡣ
	 * ����һ����ΪOuter���ⲿ������ڲ��������ΪInner���ڲ��ࡣ������ɺ����Outer.class �� Outer$Inner.class
	 * ������ 2����Outer��һ��private��ʱ���ⲿ��������ⲿ������˽�еģ����Ծ��޷������ⲿ����󣬽���Ҳ�޷������ڲ������
	 * 
	 * @author Administrator
	 * 
	 */
	class Inner {
		// static int inner_i=100; �ڲ����в������徲̬�������ڲ�����Ϊ�ⲿ���һ����Ա����Ա�ڲ��������徲̬����.
		int j = 100;// �ڲ�����ⲿ���ʵ���������Թ���
		private int inner_i = 1;

		void inner_f1() {
			System.out.println(inner_i);
			System.out.println(j);// ���ڲ����з����ڲ����Լ��ı���ֱ��ʹ�ñ�����
			System.out.println(this.j);// ����ʹ��this.������
			System.out.println(Outer.this.j);// ���ڲ����з����ⲿ�������ڲ���ͬ����ʵ������
												// ���ⲿ����.this.������
			System.out.println(k);// ����ڲ�����û�����ⲿ��ͬ���ı����������ֱ���ñ����������ⲿ�����
			outer_f1();
			outer_f2();
		}
	}

	/**
	 * �ֲ��ڲ������
	 */

	private int s = 100;
	private int out_i = 1;

	public void outer_f5(final int k) {
		final int s = 200;
		int i = 1;
		final int j = 10;
		/**
		 * �ֲ��ڲ��� �ڷ����е�һ���ڲ����Ϊ�ֲ��ڲ��ࡣ
		 * ��ֲ��������ƣ��ھֲ��ڲ���ǰ�������η�public��private���䷶ΧΪ�������Ĵ���� ע�⣺
		 * 1�������ⲻ��ֱ�������ֲ��ڲ��ࣨ��֤�ֲ��ڲ�������ǲ��ɼ��ģ���
		 * 2��Ҫ��ʹ�þֲ��ڲ���ʱ��Ҫ�������󣬶�����÷������ڷ����в��ܵ��þֲ��ڲ��ࡣ
		 * 3��ͨ���ڲ���ͽӿڴﵽһ��ǿ�Ƶ�����ϣ��þֲ��ڲ�����ʵ�ֽӿڣ����ڷ����з��ؽӿ����ͣ�ʹ�ֲ��ڲ��಻�ɼ�������ʵ����Ŀɼ��ԡ�
		 * 
		 * @author Administrator
		 * 
		 */
		class Inner {
			int s = 300;// ���Զ������ⲿ��ͬ���ı���

			// static int m=20;�����Զ��徲̬����
			/**
			 * �ڲ��๹�캯��
			 */
			Inner(int k) {
				inner_f(k);
			}

			int inner_i = 100;

			/**
			 * �ڲ���ķ���
			 * 
			 * @param k
			 */
			void inner_f(int k) {
				System.out.println(out_i);// ����ڲ���û�����ⲿ��ͬ���ı��������ڲ����п���ֱ�ӷ����ⲿ���ʵ������
				System.out.println(j);// ���Է����ⲿ��ľֲ��������������ڵı��������Ǳ���������final��
				System.out.println(s);// ����ڲ����������ⲿ��ͬ���ı�����ֱ���ñ��������ʵ����ڲ���ı���
				System.out.println(this.s);// ��this.������ ���ʵ�Ҳ���ڲ������
				System.out.println(Outer.this.s);// /���ⲿ����.this.�ڲ�������� ���ʵ����ⲿ�����
			}
		}

		new Inner(k);
	}

	/**
	 * ��̬�ڲ������ ע�⣺ ǰ�����ڲ�����������ƣ����Կ��Զ��ղο�����
	 */
	private static int a = 1;
	private int b = 10;

	public static void outer_f6() {

	}

	public void outer_f7() {

	}

	/**
	 * ��̬�ڲ��� ��̬�ڲ������ʹ��public��protected��private���Σ���̬�ڲ����п��Զ��徲̬�ͷǾ�̬�ĳ�Ա�� ע�⣺
	 * һ����̬�ڲ��಻��Ҫһ���ⲿ��ĳ�Ա��ֻ�Ǿ�̬�ڲ���ͳ�Ա�ڲ�������𡣾�̬�ڲ���Ķ������ֱ������ Outer.Inner2 in=new
	 * Outer.Inner2(); ��ʵ���Ͼ�̬�ڲ����Ϊ��һ�������ࡣ ��̬�ڲ��಻����private�����ж��塣
	 * ������ӿڣ������ǽӿ���ӿڣ���������������ͻ��ʱ�򣬴�ʱ����ʹ���ڲ�����ʵ�֡��ýӿڲ�����ȫ��ʵ�ֶ�̳У��ýӿ�����ڲ������ʵ�������Ķ�̳С�
	 * ���ӣ�
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
			System.out.println("Outer.a:" + a); // ��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա
			outer_f6();// ������̬�����;�̬����
		}

		void inner_f2() {
			// System.out.println("Outer.b:"+b); ��̬�ڲ��಻�ܷ����ⲿ��ķǾ�̬��Ա
			// outer_f7(); X �����Ǿ�̬�����ͷǾ�̬����
		}
	}

	/**
	 * �ⲿ����ʾ�̬�ڲ���
	 */
	public void outer_f8() {
		// �ⲿ�ڷ����ڲ���ľ�̬��Ա���ڲ���.��̬��Ա
		System.out.println(Inner2.inner_i);
		Inner2.inner_f1();
		// �ⲿ������ڲ���Ǿ�̬��Ա��ʵ�����ڲ���
		Inner2 inner = new Inner2();
		System.out.println(inner.inner_j);
		inner.inner_f2();

	}

	/**
	 * �����ڲ���
	 * 
	 * �����ڲ������û�����ֵ��ڲ��ࡣ ע�⣺ 1�������ڲ��಻���й��캯�� 2�������ڲ��಻�ܶ����κξ�̬��Ա����������
	 * 3�������ڲ��಻����public��protected��private��static 4��ֻ�ܴ��������ڲ����һ��ʵ��
	 * 5��һ�������ڲ���һ������new���棬��������ʵ��һ���ӿڻ�ʵ��һ���ࡣ 6���������ڲ���Ϊ�ֲ��ڲ��࣬���Ծֲ��ڲ�����������ƶ�������Ч
	 * 
	 * @return
	 */
	public Contents outer_f9() {

		return new Contents() {
			private int i = 10;

			public int getValue() {
				// TODO Auto-generated method stub
				return i;
			}

		};// �������ڲ���ĩβ�ķֺţ�������������Ǵ��ڲ��������C++������������ʵ���ϣ�����ǵ��Ǳ��ʽ�Ľ�����ֻ����������ʽ���ɰ������ڲ�����ˡ���ˣ������ĵط�ʹ�õķֺ���һ�µġ�

		// ��ͬ��
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
				System.out.println("outer_f10: " + z);// ���Է����ⲿ�ڵľֲ��������������ڵı��������Ǳ���������final��
			}
		};
	}

	public static void main(String[] args) {

		outer_f4();// ��Ա�ڲ���
		new Outer().outer_f5(4);// �ֲ��ڲ���
		new Outer().outer_f8();// ��̬�ڲ���
		new Outer().outer_f9().getValue();// �����ڲ���
		new Outer().outer_f10(8).dest();// �����ڲ���
		InnerClassTest obj = new InnerClassTest();
		obj.launchFrame();
	}

}

/**
 * һ���ڲ���ļ�Ӧ��
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
		// ��Ա�ڲ���
		f.addMouseMotionListener(new MyMouseMotionListener());/* ����Ϊ�ڲ������ */
		// ��Ч �����ڲ���
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

	class MyMouseMotionListener extends MouseMotionAdapter { /* �ڲ��࿪ʼ */
		public void mouseDragged(MouseEvent e) {
			String s = "Mouse dragging: x=" + e.getX() + "Y=" + e.getY();
			tf.setText(s);
		}
	}
	// �ڲ������
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