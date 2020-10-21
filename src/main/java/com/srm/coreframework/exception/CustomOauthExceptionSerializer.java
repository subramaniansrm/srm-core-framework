package com.srm.coreframework.exception;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomOauthExceptionSerializer() {
		super(CustomOauthException.class);
	}

	@Override
	public void serialize(CustomOauthException value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		gen.writeStartObject();
		gen.writeStringField("custom_error", value.getOAuth2ErrorCode());
		gen.writeStringField("custom_error_description", value.getMessage());
		if (value.getAdditionalInformation() != null) {
			for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
				String key = entry.getKey();
				String add = entry.getValue();
				gen.writeStringField(key, add);
			}
		}
		gen.writeEndObject();
	}
}