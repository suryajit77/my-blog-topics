package com.framework.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.framework.data.Constants.TEMP_SCREENSHOTS_DIR_PATH;
import static com.framework.util.PathFinder.getFilePathForFile;
import static java.awt.RenderingHints.*;
import static javax.imageio.ImageIO.read;

@Slf4j
public class ImgUtil {


    private static final ThreadLocal<Path> tempImg = new ThreadLocal<>();

    public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) throws IOException {

        tempImg.set(Paths.get(TEMP_SCREENSHOTS_DIR_PATH.concat("/tempImg.png")));

        //create a new BufferedImage for drawing
        BufferedImage newResizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = newResizedImage.createGraphics();

        //background transparent
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.fillRect(0, 0, width, height);

        Map<Key,Object> hints = new HashMap<>();
        hints.put(KEY_RENDERING, VALUE_RENDER_QUALITY);
        hints.put(KEY_INTERPOLATION, VALUE_INTERPOLATION_BILINEAR);
        hints.put(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        graphics2D.addRenderingHints(hints);

        //puts the original image into the newResizedImage
        graphics2D.drawImage(originalImage,0,0, width, height,null);
        graphics2D.dispose();

        //we want image in png format
        ImageIO.write(newResizedImage,"png", tempImg.get().toFile());

        log.info("Resizing the given image...");
        return newResizedImage;
    }

    @SneakyThrows
    public static BufferedImage getBufferedImage(String filename) {
        return read(getFilePathForFile(filename.replaceAll("\\s","")).toFile());
    }

}
