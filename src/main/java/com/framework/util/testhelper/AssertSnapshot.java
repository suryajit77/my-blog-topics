package com.framework.util.testhelper;

import com.assertthat.selenium_shutterbug.core.Snapshot;
import com.assertthat.selenium_shutterbug.utils.image.model.ImageData;
import com.github.romankh3.image.comparison.ImageComparison;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static com.assertthat.selenium_shutterbug.utils.image.ImageProcessor.imagesAreEquals;
import static com.framework.data.Constants.DIFFERENCE_SCREENSHOTS_DIR_PATH;
import static com.framework.util.ImgUtil.getBufferedImage;
import static com.framework.util.ImgUtil.resizeImage;
import static com.framework.util.PathFinder.getFilePathForFile;
import static com.github.romankh3.image.comparison.ImageComparisonUtil.readImageFromResources;
import static org.assertj.core.api.AssertionsForClassTypes.anyOf;

/**
 * Screenshot Comparison:
 * Compare screenshot taken with the expected one and create new image with differences highlighted along with specified deviation rate
 * (for example 0.1 represents that if image differences are less than 10% the images are considered to be equal):
 */
@Slf4j
public class AssertSnapshot extends AbstractAssert<AssertSnapshot, Snapshot> {

    public AssertSnapshot(Snapshot snapshot) {
        super(snapshot, AssertSnapshot.class);
    }

    public static AssertSnapshot assertThat(Snapshot snapshot) {
        return new AssertSnapshot(snapshot);
    }

    @SneakyThrows
    public AssertSnapshot matchesWithSnapshot(String expectedImageName) {
        isNotNull();
        BufferedImage expectedImage = ImageIO.read(new File(getFilePathForFile(expectedImageName.replaceAll("\\s","")).toString()));
        Assertions.assertThat(actual.equalsWithDiff(expectedImage, DIFFERENCE_SCREENSHOTS_DIR_PATH.concat(expectedImageName.replace(".png",""))
                .concat("Difference"), 0.001)).isTrue();
        return this;
    }


    @SneakyThrows
    public AssertSnapshot matchesWithAnyOfSnapshots(String expectedImgName, String expectedAlternateImgName) {

        isNotNull();

        BufferedImage expectedImg = getBufferedImage(expectedImgName);
        BufferedImage expectedAltImg = getBufferedImage(expectedAlternateImgName);

        BufferedImage actualImg = new ImageData(actual.getImage())
                .notEqualsDimensions(new ImageData(expectedImg)) ? resizeImage(actual.getImage(), expectedImg.getWidth(), expectedImg.getHeight()) : actual.getImage();

        Assertions.assertThat(actualImg).is(anyOf(
                new Condition<>(img -> imagesAreEquals(actualImg, expectedImg,0.0001),"First Image comparison"),
                new Condition<>(img -> imagesAreEquals(actualImg, expectedAltImg,0.0001),"Second Image comparison"))
        ); return this;
    }


    @SneakyThrows
    public AssertSnapshot compareSnapshot(String expectedImageName) {
        isNotNull();
        new ImageComparison(readImageFromResources(getFilePathForFile(expectedImageName
                .replaceAll("\\s","")).toString()), readImageFromResources(getFilePathForFile(expectedImageName
                .replaceAll("\\s","")).toString()), new File(DIFFERENCE_SCREENSHOTS_DIR_PATH.concat(expectedImageName.replace(".png",""))))
                .compareImages();
        return this;
    }


}
