package com.example.wantlifu.controller.reciveEntity;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author want
 * @createTime 2020.04.13.12:09
 */
public class PayEntity {
    private String idString;

    private String countString;

    private String sizeString;

    private String colorString;
//
    public PayEntity(String idString, String countString) {
        this.idString = idString;
        this.countString = countString;
        String[] ids = idString.split(",");
        String[] counts = countString.split(",");
//        String[] sizes = sizeString.split(",");
//        String[] colors = colorString.split(",");

        sonEntity = new SonEntity[ids.length];
        for (int i = 0; i < ids.length; i++) {
            sonEntity[i] = new SonEntity(Integer.valueOf(ids[i]),Integer.valueOf(counts[i]));
//            sonEntity[i] = new SonEntity(Integer.valueOf(ids[i]),Integer.valueOf(counts[i]),sizes[i],colors[i]);
        }
    }
    public PayEntity(String idString, String countString,String sizeString,String colorString) {
        this.idString = idString;
        this.countString = countString;
        String[] ids = idString.split(",");
        String[] counts = countString.split(",");
        String[] sizes = sizeString.split(",");
        String[] colors = colorString.split(",");

        sonEntity = new SonEntity[ids.length];
        for (int i = 0; i < ids.length; i++) {
//            sonEntity[i] = new SonEntity(Integer.valueOf(ids[i]),Integer.valueOf(counts[i]));
            sonEntity[i] = new SonEntity(Integer.valueOf(ids[i]),Integer.valueOf(counts[i]),sizes[i],colors[i]);
        }
    }

    @Valid
    @NotNull
    private SonEntity[] sonEntity;

    public SonEntity[] getSonEntity() {
        return sonEntity;
    }

    public void setSonEntity(SonEntity[] sonEntity) {
        this.sonEntity = sonEntity;
    }

    public static class SonEntity{
        @Min(1)
        private Integer id;
        @Min(1)
        private Integer count;

        private String size;

        private String color;

        public SonEntity(@Min(1) Integer id, @Min(1) Integer count) {
            this.id = id;
            this.count = count;
        }

        public SonEntity(@Min(1) Integer id, @Min(1) Integer count, String size, String color) {
            this.id = id;
            this.count = count;
            this.size = size;
            this.color = color;
        }
        public SonEntity() {
        }
        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

}
