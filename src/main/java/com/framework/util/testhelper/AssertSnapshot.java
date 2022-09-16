package com.framework.util.testhelper;

import com.assertthat.selenium_shutterbug.core.Snapshot;
import com.framework.util.PathFinder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static com.framework.data.Constants.DIFFERENCE_SCREENSHOTS_DIR_PATH;

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
        BufferedImage expectedImage = ImageIO.read(new File(PathFinder.getFilePathForFile(expectedImageName.replaceAll("\\s","")).toString()));
        Assertions.assertThat(actual.equalsWithDiff(expectedImage, DIFFERENCE_SCREENSHOTS_DIR_PATH.concat(expectedImageName.replace(".png",""))
                .concat("Difference"), 0.001)).isTrue();
        return this;
    }

}
