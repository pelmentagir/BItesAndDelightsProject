package repositories;

import models.File;
import repositories.interfaces.FileRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileRepositoryImpl implements FileRepository {
    private final Connection connection;

    private static final String INSERT_FILE = "INSERT INTO files (path, recipe_id) VALUES (?, ?)";
    private static final String SELECT_FILE_BY_ID = "SELECT * FROM files WHERE id = ?";
    private static final String SELECT_FILES_BY_RECIPE_ID = "SELECT * FROM files WHERE recipe_id = ?";
    private static final String SELECT_ALL_FILES = "SELECT * FROM files";
    private static final String UPDATE_FILE = "UPDATE files SET path = ?, recipe_id = ? WHERE id = ?";
    private static final String DELETE_FILE_BY_ID = "DELETE FROM files WHERE id = ?";

    public FileRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<File> findAll() throws SQLException {
        List<File> files = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_FILES)) {
            while (rs.next()) {
                files.add(mapToFile(rs));
            }
        }
        return files;
    }

    @Override
    public Optional<File> findById(Long id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_FILE_BY_ID)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapToFile(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<File> findAllByRecipeId(Long recipeId) {
        List<File> files = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_FILES_BY_RECIPE_ID)) {
            stmt.setLong(1, recipeId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    files.add(mapToFile(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return files;
    }

    @Override
    public void save(File file) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_FILE, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, file.getPath());
            stmt.setLong(2, file.getRecipeId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    file.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public void update(File file) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE_FILE)) {
            stmt.setString(1, file.getPath());
            stmt.setLong(2, file.getRecipeId());
            stmt.setLong(3, file.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void remove(File file) throws SQLException {
        removeById(file.getId());
    }

    @Override
    public void removeById(Long id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(DELETE_FILE_BY_ID)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private File mapToFile(ResultSet rs) throws SQLException {
        File file = new File();
        file.setId(rs.getLong("id"));
        file.setPath(rs.getString("path"));
        file.setRecipeId(rs.getLong("recipe_id"));
        return file;
    }
}