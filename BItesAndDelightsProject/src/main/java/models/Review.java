package models;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private Long recipeId;
    private Long userId;
    private String text;
    private int rating;
    private LocalDateTime creationDate;

    public Review() {}

    public Review(Long id, Long recipeId, Long userId, String text, int rating, LocalDateTime creationDate) {
        this.id = id;
        this.recipeId = recipeId;
        this.userId = userId;
        this.text = text;
        this.rating = rating;
        this.creationDate = creationDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRecipeId() { return recipeId; }
    public void setRecipeId(Long recipeId) { this.recipeId = recipeId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", userId=" + userId +
                ", rating=" + rating +
                '}';
    }
}
