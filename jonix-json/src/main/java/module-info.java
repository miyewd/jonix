module jonix.json {
    requires transitive jonix.common;

    requires jackson.annotations;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    exports com.tectonica.jonix.json;
}