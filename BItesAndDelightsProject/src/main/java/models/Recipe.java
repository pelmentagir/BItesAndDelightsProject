package models;

import java.time.LocalDateTime;

public class Recipe {
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private Long categoryId;
    private LocalDateTime creationDate;

    public Recipe() {}

    public Recipe(Long id, String title, String description, Long userId, Long categoryId, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.categoryId = categoryId;
        this.creationDate = creationDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                '}';
    }
}
