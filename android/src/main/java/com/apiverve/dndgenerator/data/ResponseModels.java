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
//     DDGeneratorData data = Converter.fromJsonString(jsonString);

package com.apiverve.dndgenerator.data;

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

    public static DDGeneratorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DDGeneratorData obj) throws JsonProcessingException {
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
        reader = mapper.readerFor(DDGeneratorData.class);
        writer = mapper.writerFor(DDGeneratorData.class);
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

// DDGeneratorData.java

package com.apiverve.dndgenerator.data;

import com.fasterxml.jackson.annotation.*;

public class DDGeneratorData {
    private String type;
    private long count;
    private Results results;

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("results")
    public Results getResults() { return results; }
    @JsonProperty("results")
    public void setResults(Results value) { this.results = value; }
}

// Results.java

package com.apiverve.dndgenerator.data;

import com.fasterxml.jackson.annotation.*;

public class Results {
    private String name;
    private String race;
    private String resultsClass;
    private long level;
    private String background;
    private String alignment;
    private Stats stats;
    private long hitPoints;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("race")
    public String getRace() { return race; }
    @JsonProperty("race")
    public void setRace(String value) { this.race = value; }

    @JsonProperty("class")
    public String getResultsClass() { return resultsClass; }
    @JsonProperty("class")
    public void setResultsClass(String value) { this.resultsClass = value; }

    @JsonProperty("level")
    public long getLevel() { return level; }
    @JsonProperty("level")
    public void setLevel(long value) { this.level = value; }

    @JsonProperty("background")
    public String getBackground() { return background; }
    @JsonProperty("background")
    public void setBackground(String value) { this.background = value; }

    @JsonProperty("alignment")
    public String getAlignment() { return alignment; }
    @JsonProperty("alignment")
    public void setAlignment(String value) { this.alignment = value; }

    @JsonProperty("stats")
    public Stats getStats() { return stats; }
    @JsonProperty("stats")
    public void setStats(Stats value) { this.stats = value; }

    @JsonProperty("hitPoints")
    public long getHitPoints() { return hitPoints; }
    @JsonProperty("hitPoints")
    public void setHitPoints(long value) { this.hitPoints = value; }
}

// Stats.java

package com.apiverve.dndgenerator.data;

import com.fasterxml.jackson.annotation.*;

public class Stats {
    private long strength;
    private long dexterity;
    private long constitution;
    private long intelligence;
    private long wisdom;
    private long charisma;

    @JsonProperty("strength")
    public long getStrength() { return strength; }
    @JsonProperty("strength")
    public void setStrength(long value) { this.strength = value; }

    @JsonProperty("dexterity")
    public long getDexterity() { return dexterity; }
    @JsonProperty("dexterity")
    public void setDexterity(long value) { this.dexterity = value; }

    @JsonProperty("constitution")
    public long getConstitution() { return constitution; }
    @JsonProperty("constitution")
    public void setConstitution(long value) { this.constitution = value; }

    @JsonProperty("intelligence")
    public long getIntelligence() { return intelligence; }
    @JsonProperty("intelligence")
    public void setIntelligence(long value) { this.intelligence = value; }

    @JsonProperty("wisdom")
    public long getWisdom() { return wisdom; }
    @JsonProperty("wisdom")
    public void setWisdom(long value) { this.wisdom = value; }

    @JsonProperty("charisma")
    public long getCharisma() { return charisma; }
    @JsonProperty("charisma")
    public void setCharisma(long value) { this.charisma = value; }
}