package org.imersao.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.imageio.ImageIO;

import org.imersao.dto.StickerDto;
import org.imersao.utils.StickerException;

/**
 *
 * @author SRamos
 */
@ApplicationScoped
public class StickerService {

    public byte[] handleCreate(StickerDto dto) {

        try {
            var inputStream = new URL(dto.getImagePath()).openStream();
            var originalImg = ImageIO.read(inputStream);
    
            int width = originalImg.getWidth();
            int height = originalImg.getHeight();
            int newHeight = dto.isTextInsideImage() ? height : height + 140;
    
            var newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
    
            var graphics2D = (Graphics2D) newImg.getGraphics();
    
            graphics2D.drawImage(originalImg, 0, 0, null);
    
            graphics2D.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 82));
            graphics2D.setColor(Color.YELLOW);
            graphics2D.drawString(dto.getImageText(), getTextCenterSize(dto.getImageText()), newHeight - 40);
    
            var btArrayOutputStram =  new ByteArrayOutputStream();
            ImageIO.write(getFinalImage(newImg, dto), "png", btArrayOutputStram);
    
            return btArrayOutputStram.toByteArray();
        } catch (Exception e) {
            throw new StickerException("Erro ao gerar sticker", 500);
        }

    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        var resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        var outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TRANSLUCENT);
        
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        return outputImage;
    }

    private BufferedImage getFinalImage(BufferedImage image, StickerDto dto) throws IOException {
        return dto.isOriginalSize() ? image : resizeImage(image, 200, 200);
    }

    private int getTextCenterSize(String imageText) {
        Integer imageLength = imageText.length();

        if (imageLength <= 3) {
            return 322;
        } else if (imageLength <= 6) {
            return 262;
        } else if (imageLength <= 8) {
            return 202;
        } else if (imageLength <= 10) {
            return 142;
        } else if (imageLength <= 12) {
            return 122;
        } else {
            return 12;
        }
    }

}