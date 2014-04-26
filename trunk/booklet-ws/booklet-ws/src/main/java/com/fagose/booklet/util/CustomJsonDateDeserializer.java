package com.fagose.booklet.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
	private final static String FORMAT = "hh:mm dd-MM-yyyy";
	
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        DateFormat formatter = new SimpleDateFormat(FORMAT);
        String dateString = jsonparser.getText();
        Date date=null;
        try {
            date=formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        
        return date;
    }

}
