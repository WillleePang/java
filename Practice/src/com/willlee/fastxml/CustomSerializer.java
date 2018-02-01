package com.willlee.fastxml;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomSerializer extends StdSerializer<Person> {
	
	private static final long serialVersionUID = -3737223358321108260L;

	protected CustomSerializer(Class<Person> t) {
		super(t);
	}

	@Override
	public void serialize(Person person, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		jgen.writeNumberField("age", person.getAge());
		jgen.writeStringField("name", person.getName());
		jgen.writeEndObject();
	}

}
