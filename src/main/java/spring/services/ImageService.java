package spring.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Piotr on 2020-09-02
 */
public interface ImageService {
    void saveImageFile(Long recipeId, MultipartFile file);
}
