package com.fagose.booklet.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;


public class CustomDateSerializer extends JsonSerializer<Date>{
 
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd-MM-yyyy");
 
@Override
public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
throws IOException, JsonProcessingException {
 
String formattedDate = dateFormat.format(date);
 
gen.writeString(formattedDate);
}
 
}
