package org.imersao.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.imageio.ImageIO;

import org.imersao.dto.StickerDto;

/**
 *
 * @author SRamos
 */
@ApplicationScoped
public class StickerService {

    public byte[] handleCreate(StickerDto dto) throws IOException {

        var inputStream = new URL(dto.getImagePath()).openStream();
        var originalImg = ImageIO.read(inputStream);

        int width = originalImg.getWidth();
        int height = originalImg.getHeight();
        int newHeight = height + 200;

        var newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        var graphics2D = (Graphics2D) newImg.getGraphics();

        graphics2D.drawImage(originalImg, 0, 0, null);

        graphics2D.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        graphics2D.setColor(Color.CYAN);
        graphics2D.drawString(dto.getImageText(), 0, newHeight - 120);

        var btArrayOutputStram =  new ByteArrayOutputStream();
        ImageIO.write(newImg, "png", btArrayOutputStram);

        return btArrayOutputStram.toByteArray();

    }

}