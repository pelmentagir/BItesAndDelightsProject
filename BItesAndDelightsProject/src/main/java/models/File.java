package models;

public class File {
    private Long id;
    private String path;
    private Long recipeId;

    public File() {}

    public File(Long id, String path, Long recipeId) {
        this.id = id;
        this.path = path;
        this.recipeId = recipeId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public Long getRecipeId() { return recipeId; }
    public void setRecipeId(Long recipeId) { this.recipeId = recipeId; }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", recipeId=" + recipeId +
                '}';
    }
}
