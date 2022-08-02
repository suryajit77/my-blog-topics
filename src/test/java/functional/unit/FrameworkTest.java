package functional.unit;

import com.framework.page.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;

@ExtendWith(MockitoExtension.class)
public class FrameworkTest {

    @Mock
    BasePage basePage;

    @BeforeEach
    public void setupMocks(){
        Mockito.when(basePage.enterText(By.xpath("locator"), "someString"))
                .thenReturn(basePage);
    }

    @Test
    public void checkBasePageReturnTypes(){
        Assertions.assertEquals(basePage, basePage.enterText(By.xpath("locator"), "someString"));
    }



}
