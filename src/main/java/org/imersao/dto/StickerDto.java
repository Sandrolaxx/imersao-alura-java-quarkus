package org.imersao.dto;

public class StickerDto {
    
    private String imagePath;

    private String imageText;

    private boolean textInsideImage;

    private boolean originalSize;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public boolean isTextInsideImage() {
        return textInsideImage;
    }

    public void setTextInsideImage(boolean textInsideImage) {
        this.textInsideImage = textInsideImage;
    }

    public boolean isOriginalSize() {
        return originalSize;
    }

    public void setOriginalSize(boolean originalSize) {
        this.originalSize = originalSize;
    }
    
}
