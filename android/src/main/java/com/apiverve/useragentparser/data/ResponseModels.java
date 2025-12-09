// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     UserAgentParserData data = Converter.fromJsonString(jsonString);

package com.apiverve.useragentparser.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static UserAgentParserData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(UserAgentParserData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(UserAgentParserData.class);
        writer = mapper.writerFor(UserAgentParserData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// UserAgentParserData.java

package com.apiverve.useragentparser.data;

import com.fasterxml.jackson.annotation.*;

public class UserAgentParserData {
    private String ua;
    private Browser browser;
    private Engine engine;
    private Engine os;
    private CPU device;
    private CPU cpu;

    @JsonProperty("ua")
    public String getUa() { return ua; }
    @JsonProperty("ua")
    public void setUa(String value) { this.ua = value; }

    @JsonProperty("browser")
    public Browser getBrowser() { return browser; }
    @JsonProperty("browser")
    public void setBrowser(Browser value) { this.browser = value; }

    @JsonProperty("engine")
    public Engine getEngine() { return engine; }
    @JsonProperty("engine")
    public void setEngine(Engine value) { this.engine = value; }

    @JsonProperty("os")
    public Engine getOS() { return os; }
    @JsonProperty("os")
    public void setOS(Engine value) { this.os = value; }

    @JsonProperty("device")
    public CPU getDevice() { return device; }
    @JsonProperty("device")
    public void setDevice(CPU value) { this.device = value; }

    @JsonProperty("cpu")
    public CPU getCPU() { return cpu; }
    @JsonProperty("cpu")
    public void setCPU(CPU value) { this.cpu = value; }
}

// Browser.java

package com.apiverve.useragentparser.data;

import com.fasterxml.jackson.annotation.*;

public class Browser {
    private String name;
    private String version;
    private String major;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }

    @JsonProperty("major")
    public String getMajor() { return major; }
    @JsonProperty("major")
    public void setMajor(String value) { this.major = value; }
}

// CPU.java

package com.apiverve.useragentparser.data;

import com.fasterxml.jackson.annotation.*;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class CPU {
}

// Engine.java

package com.apiverve.useragentparser.data;

import com.fasterxml.jackson.annotation.*;

public class Engine {
    private String name;
    private String version;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }
}