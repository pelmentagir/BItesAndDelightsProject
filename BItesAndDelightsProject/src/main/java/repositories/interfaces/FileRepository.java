package repositories.interfaces;

import models.File;

import java.util.List;

public interface FileRepository extends CrudRepository<File> {
    List<File> findAllByRecipeId(Long recipeId);
}
