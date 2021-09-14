package br.ce.caique.cursoappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CtAppiumTest {
	
	@Test
	public  void DeveInteragirComCombo() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "emulator-5554");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		 
		 AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		 
		 driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElementById("android:id/button1").click();
		 
		 //selecionar formulario
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		 
		 //escrever nome
		 
		 MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		 campoNome.sendKeys("Caique");
		 
		 //checar nome escrito
		 String text = campoNome.getText();
		 Assert.assertEquals("Caique", text);
		 
		 //clicar no combo
		 driver.findElement(MobileBy.AccessibilityId("console")).click();
		 
		 //selecionar opção desejada 
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		 
		 //verificar opção desejada
		 String text2 = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView[@text='Nintendo Switch']")).getText();
		 Assert.assertEquals("Nintendo Switch", text2);
		 
		 //driver.quit();
	}
	@Test
	public  void DeveInteragirComSwitchCheckBox() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "emulator-5554");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		 
		 AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		 
		 driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElementById("android:id/button1").click();
		 
		 //selecionar formulario
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		 
		 //verificar status dos elementos
		 MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		 MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		 check.getAttribute("checked"); //retorna true or false
		 Assert.assertTrue(check.getAttribute("checked").equals("false"));
		 Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		 
		 //cicar nos elementos 
		 check.click();
		 switc.click();
		 
		 //verificar status alterados
		 Assert.assertFalse(check.getAttribute("checked").equals("false"));
		 Assert.assertFalse(switc.getAttribute("checked").equals("true"));
		 
		 //driver.quit();
	}
	@Test
	public  void DeveEfetuarCadastro() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 desiredCapabilities.setCapability("platformName", "Android");
		 desiredCapabilities.setCapability("deviceName", "emulator-5554");
		 desiredCapabilities.setCapability("automationName", "uiautomator2");
		 desiredCapabilities.setCapability("appPackage", "com.ctappium");
		 desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		 desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		 
		 AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		 
		 driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElementById("android:id/button1").click();
		 
		 //clicando em formulario
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		 
		 //digitando nome
		 driver.findElement(By.xpath("//android.widget.EditText[@text='Nome']")).sendKeys("Caique");
		 
		 //escolhendo o video game > clicando no combo
		 driver.findElement(MobileBy.AccessibilityId("console")).click();
		 
		 //escolhendo o video game
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='XBox One']")).click();
		 
		 //marcando opções
		 MobileElement check = driver.findElement(MobileBy.AccessibilityId("check"));
		 MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		 check.click();
		 switc.click();
		 
		 //Salvar ultimate> ultima ação 
		 driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //validação de elementos
		 MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Caique']"));
		 MobileElement console = driver.findElement(By.xpath("//android.widget.TextView[@text='Console: xone']"));
		 MobileElement SwitchOff = driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']"));
		 MobileElement checkMarcado = driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
		 	
		/*Assert.assertEquals(nome, "Nome: Caique");
		 Assert.assertEquals(console, "Console: xone");
		 Assert.assertEquals(SwitchOff, "Switch: Off");
		 Assert.assertEquals(checkMarcado, "Checkbox: Marcado");*/
	
	}
}
