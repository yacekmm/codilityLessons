package com.codility.challenge.second;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {


    public String solution(String S) {
        String[] strings = S.split("\n");

        Map<String, List<Photo>> groupedByCities = Arrays.stream(strings)
                .map(s -> Photo.fromString(s))
                .collect(Collectors.groupingBy(Photo::getCity));

        for (String city : groupedByCities.keySet()) {
            List<Photo> photos = groupedByCities.get(city);
            photos.sort(Comparator.comparing(photo -> photo.dateTime));

            Integer count = photos.size();
            int digits = count.toString().length();
            for (int i = 0; i < count; i++) {
                photos.get(i).buildResultName(digits, i);
            }
        }

        Map<String, String> collect = groupedByCities.values().stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toMap(Photo::getOriginal, Photo::getResult));

        StringBuilder sb = new StringBuilder();
        Arrays.stream(strings)
                .map(s -> collect.get(s))
                .forEach(sb::append);

        return sb.toString().trim();
    }


    static class Photo {
        private final String extension;
        private final String city;
        private final LocalDateTime dateTime;


        private final String original;
        private String result;


        private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public static Photo fromString(String s) {
            String[] strings = s.split(", ");
            return new Photo(
                    strings[0].substring(s.indexOf(".") + 1, s.indexOf(",")),
                    strings[1],
                    parseDate(strings[2]),
                    s);
        }

        public Photo(String extension, String city, LocalDateTime dateTime, String original) {
            this.extension = extension;
            this.city = city;
            this.dateTime = dateTime;
            this.original = original;
        }

        public String getCity() {
            return city;
        }

        public String getResult() {
            return result;
        }

        public String getOriginal() {
            return original;
        }

        private static LocalDateTime parseDate(String string) {
            return LocalDateTime.parse(string, formatter);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Photo photo = (Photo) o;

            if (extension != null ? !extension.equals(photo.extension) : photo.extension != null) return false;
            if (city != null ? !city.equals(photo.city) : photo.city != null) return false;
            return dateTime != null ? dateTime.equals(photo.dateTime) : photo.dateTime == null;
        }

        @Override
        public int hashCode() {
            int result = extension != null ? extension.hashCode() : 0;
            result = 31 * result + (city != null ? city.hashCode() : 0);
            result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Photo{" +
                    "extension='" + extension + '\'' +
                    ", city='" + city + '\'' +
                    ", dateTime=" + dateTime +
                    '}';
        }

        private void buildResultName(int digits, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(city)
                    .append(String.format("%0" + digits + "d", i+1))
                    .append(".")
                    .append(extension)
                    .append("\n");
            this.result = sb.toString();
        }
    }

}
