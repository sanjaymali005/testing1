package testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class testing1 {
@FindBy(how=How.NAME,using="userName")
public static WebElement uname;

@FindBy(how = How.NAME,using="password")
public static WebElement password;

@FindBy(how = How.NAME,using="login")
public static WebElement Login_button;

	
}
