package br.com.mobhub.jasper.converter;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Strings;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * http://sinanyumak.blogspot.com.br/2013/03/spring-32-json-p-message-converter.html
 */
public class MappingJackson2JsonpHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    private static final String DEFAULT_CALLBACK_PARAMETER = "callback";

    private static final List<MediaType> SUPPORTED_MEDIA_TYPES = new ArrayList<MediaType>() {{
        add( new MediaType("application", "x-javascript") );
        add( new MediaType("application", "javascript") );
        add( new MediaType("text", "javascript") );
    }};

    public MappingJackson2JsonpHttpMessageConverter() {
        setSupportedMediaTypes(SUPPORTED_MEDIA_TYPES);
    }

    @Override
    protected void writeInternal( Object object, HttpOutputMessage outputMessage )
            throws IOException, HttpMessageNotWritableException {
        JsonGenerator jsonGenerator = getJsonGenerator(outputMessage);

        try {
            String callbackParam = getRequestParam(DEFAULT_CALLBACK_PARAMETER);

            //if the callback parameter doesn't exists, use the default one...
            if (Strings.isNullOrEmpty(callbackParam) ) {
                getObjectMapper().writeValue(jsonGenerator, object);
            } else {
                jsonGenerator.writeRaw(callbackParam);
                jsonGenerator.writeRaw(" (");
                getObjectMapper().writeValue(jsonGenerator, object);
                jsonGenerator.writeRaw(");");
            }
            jsonGenerator.flush();
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON:"  + ex.getMessage(), ex);
        }
    }


    private JsonGenerator getJsonGenerator( HttpOutputMessage outputMessage ) throws IOException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        return getObjectMapper().getFactory().createGenerator(outputMessage.getBody(), encoding);
    }

    /**
     * Returns given parameter from servlet request.
     *
     * @param paramName
     *         Name of the param
     */
    private String getRequestParam( String paramName ) {
        return getServletRequest().getParameter(paramName);
    }

    /**
     * Returns current servlet request.
     */
    private HttpServletRequest getServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
