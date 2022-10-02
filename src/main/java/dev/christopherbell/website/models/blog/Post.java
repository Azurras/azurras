package dev.christopherbell.website.models.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    private String author;
    private String contentText;
    private String date;
    private String description;
    private int id;
    private String imagePath;
    private List<String> tags;
    private String title;
}