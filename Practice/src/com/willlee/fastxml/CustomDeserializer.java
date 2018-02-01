package com.willlee.fastxml;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDeserializer extends StdDeserializer<Person> {

	protected CustomDeserializer(Class<?> vc) {
		super(vc);
	}

	private static final long serialVersionUID = 3494550537825729391L;

	@Override
	public Person deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		Person person = new Person();
		int age = node.get("age").asInt();
		String name = node.get("name").asText();
		person.setAge(age);
		person.setName(name);
		return person;
	}
}
