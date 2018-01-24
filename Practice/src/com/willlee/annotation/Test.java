package com.willlee.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Table("user")
public class Test {
	public static void main(String[] args) {
		User user1 = new User();
		user1.setId(10);

		User user2 = new User();
		user2.setUserName("willlee");
		user2.setAge(18);

		User user3 = new User();
		user3.setEmail("liu@sina.com,zh@163.com,777@qq.com");

		String sql1 = query(user1);
		String sql2 = query(user2);
		String sql3 = query(user3);

		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		
		Department department = new Department();
		department.setId(10);
		department.setLeader("willlee");
		department.setAmount(1000);
		department.setName("liushuo");
		String sql4 = query(department);
		System.out.println(sql4);
	}

	private static String query(Object user) {
		StringBuffer sb = new StringBuffer();
		Class<? extends Object> c = user.getClass();
		boolean exists = c.isAnnotationPresent(Table.class);
		if (!exists) {
			return null;
		}
		Table t = (Table) c.getAnnotation(Table.class);
		String tableName = t.value();
		sb.append("select * from ").append(tableName).append(" where 1=1");
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			boolean fExists = field.isAnnotationPresent(Column.class);
			if (!fExists) {
				continue;
			}
			Column column = field.getAnnotation(Column.class);
			String columnName = column.value();
			String fieldName = field.getName();
			String getMethodName = "get"
					+ fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
			Object fieldValue = null;
			try {
				Method getMethod = c.getMethod(getMethodName);
				fieldValue = getMethod.invoke(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (fieldValue == null
					|| (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
				continue;
			}
			sb.append(" and ").append(columnName);
			if (fieldValue instanceof String) {
				if (((String) fieldValue).contains(",")) {
					String[] values = ((String) fieldValue).split(",");
					sb.append(" in(");
					for (String value : values) {
						sb.append("'").append(value).append("'").append(",");
					}
					sb.deleteCharAt(sb.length() - 1);
					sb.append(")");
				} else {
					sb.append(" = ").append("'").append(fieldValue).append("'");
				}
			} else if (fieldValue instanceof Integer) {
				sb.append(" = ").append(fieldValue);
			}

		}
		return sb.toString();
	}
}
