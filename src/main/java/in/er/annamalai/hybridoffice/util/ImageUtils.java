package in.er.annamalai.portfolio.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;

public class ImageUtils {

    private ImageUtils(){
        super();
    }

    public static void drawText(Font font, String text){
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();
 
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();
        try {
            ImageIO.write(img, "gif", new File(text + ".gif"));
            ImageIO.write(img, "png", new File(text + ".png"));
            ImageIO.write(img, "jpg", new File(text + ".jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Font getArialPlainFont() {
        return getFont("Arial", Font.PLAIN, 48);
    }

    private static Font getFont(String name, int style, int size) {
        return new Font(name, style, size);
    }

    public static ImageInfo getImageInfo(String fileName) {
        File outputFile = new File(fileName);
        try {
            return Imaging.getImageInfo(outputFile);
        } catch (ImageReadException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static File writeImage(int idx, BufferedImage image, String fileName, ImageFormats imageFormat) {
        File outputFile = new File(fileName);
        try {
            Imaging.writeImage(image, outputFile, imageFormat);
        } catch (ImageWriteException | IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }


    public static List<BufferedImage> getAllBufferedImages(String fileName) {
        File inputFile = new File(fileName);
        try {
             return Imaging.getAllBufferedImages(inputFile);
        } catch (ImageReadException | IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
