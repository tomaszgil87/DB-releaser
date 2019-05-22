package com.tgdevelopment.model;

public class DumpObjectsDTO {

    private String name;
    private String type;
    private int line;
    private String text;

    private  DumpObjectsDTO() { }

    public static final class DumpObjectsDTOBuilder {

        private String name;
        private String type;
        private int line;
        private String text;

        private DumpObjectsDTOBuilder() {}

        public DumpObjectsDTOBuilder withName (String name){
            this.name = name;
            return this;
        }

        public DumpObjectsDTOBuilder withType (String type){
            this.type = type;
            return this;
        }

        public DumpObjectsDTOBuilder withText (String text){
            this.text = text;
            return this;
        }

        public DumpObjectsDTOBuilder withLine ( int line){
            this.line = line;
            return this;
        }

        public DumpObjectsDTO build() {
            DumpObjectsDTO dumpObjectsDTO = new DumpObjectsDTO();
            dumpObjectsDTO.line = this.line;
            dumpObjectsDTO.name = this.name;
            dumpObjectsDTO.text = this.text;
            dumpObjectsDTO.type = this.type;
            return dumpObjectsDTO;
        }

    }

    public static DumpObjectsDTOBuilder builder () {
        return new DumpObjectsDTOBuilder();
    }

}
