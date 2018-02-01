package com.willlee.fastxml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

public class JacksonTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		// 在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		// 在序列化时忽略值为 null 的属性
		mapper.setSerializationInclusion(Include.NON_NULL);
		// 忽略值为默认值的属性
		mapper.setDefaultPropertyInclusion(Include.NON_DEFAULT);
		Person person = new Person();
		person.setName("pangweili");
		person.setAge(28);
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
		String jsonString1 = "{\"name\":\"pangweili\",\"age\":28,\"sss\":111}";
		Person item = mapper.readValue(jsonString1, Person.class);
		System.out.println(jsonString);
		System.out.println(jsonString1);
		System.out.println(item);

		String jsonString2 = "[{\"name\":\"pangweili\",\"age\":28,\"sss\":111}]";
		CollectionType javaType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Person.class);
		ArrayList<Person> personList = mapper.readValue(jsonString2, javaType);
		System.out.println(personList);

		String jsonString3 = "{\"person\":{\"name\":\"pangweili\",\"age\":28,\"sss\":111}}";
		MapType mapType = mapper.getTypeFactory().constructMapType(HashMap.class, String.class, Person.class);
		HashMap<String, Person> personMap = mapper.readValue(jsonString3, mapType);
		System.out.println(personMap);

		// 属性可视化
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

		SimpleBeanPropertyFilter newFilter = SimpleBeanPropertyFilter.serializeAllExcept("age");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(Person.class.getName(), newFilter);
		String jsonString4 = mapper.setFilterProvider(filterProvider).writeValueAsString(person);
		System.out.println(jsonString4);

		// 构建 ObjectNode
		ObjectNode personNode = mapper.createObjectNode();
		// 添加/更改属性
		personNode.put("name", "Tom");
		personNode.put("age", 40);
		ObjectNode addressNode = mapper.createObjectNode();
		addressNode.put("zip", "000000");
		addressNode.put("street", "Road NanJing");
		// 设置子节点
		personNode.set("address", addressNode);
		// 通过 path 查找节点
		JsonNode searchNode = personNode.path("street");
		// 删除属性
		personNode.remove("address");
		// 读取 json
		JsonNode rootNode = mapper.readTree(personNode.toString());
		// JsonNode 转换成 java 对象
		Person person1 = mapper.treeToValue(personNode, Person.class);
		// java 对象转换成 JsonNode
		JsonNode node = mapper.valueToTree(person);
	}
}
