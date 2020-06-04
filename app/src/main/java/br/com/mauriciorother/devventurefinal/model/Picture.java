package br.com.mauriciorother.devventurefinal.model;

import java.util.List;

public class Picture {

    private List<Data> data;

    public Picture(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public static class Data {
        private List<Images> images;

        public Data(List<Images> images) {
            this.images = images;
        }

        public List<Images> getImages() {
            return images;
        }
    }

    public static class Images {
        private String link;
        private String title;

        public Images(String link) {
            this.link = link;
        }

        public String getLink() {
            return link;
        }

        public String getTitle() {
            return title;
        }
    }
}
