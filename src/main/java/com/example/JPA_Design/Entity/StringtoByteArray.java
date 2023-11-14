package com.example.JPA_Design.Entity;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class StringtoByteArray extends JsonDeserializer<byte []> {
    @Override
    public byte[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return (Base64.getEncoder().encode(jsonParser.getText().getBytes(StandardCharsets.UTF_8)));
    }
}
