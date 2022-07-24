package org.imersao.dto;

public class StickerDto {
    
    private String imagePath;

    private String imageText;

    private boolean textInsideImage;

    private boolean originaLSize;

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

    public boolean isOriginaLSize() {
        return originaLSize;
    }

    public void setOriginaLSize(boolean originaLSize) {
        this.originaLSize = originaLSize;
    }

}
