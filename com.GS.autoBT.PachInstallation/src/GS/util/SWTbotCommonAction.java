package GS.util;

import java.awt.AWTException;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

import GS.Prespectives.InstallationCenter;

public  class SWTbotCommonAction {
	private static SWTbotCommonAction _instance = null;
	private  SWTWorkbenchBot bot=null;
	
	    
	public SWTbotCommonAction(SWTWorkbenchBot bot)
	{
		 this.bot=bot;
	}
	
	public void setTextByLabel(String TextBoxLabel, String TextString)
	{
		 bot.textWithLabel(TextBoxLabel).setText(TextString);
	}
	
	public  void clickOKButton()
	{
		bot.button("OK").click();
	}
     
	public  void clickCancelButton()
	{
		
	}
	
	public  void clickNextButton()
	{
		bot.button("Next >").click();
	}
    public  void clickAddButton()
    {
    	
    }
    public  void clickSaveButton()
    {
    	
    }
    public  void clickFinishButton()
    {
    	 bot.button("Finish").click();
    }
    
    public  Object openPrespective(String prespectiveName) throws Exception
    {
    	bot.perspectiveByLabel(prespectiveName).activate();
        return new InstallationCenter(bot);
    }
    
    public  void setFocus(String titleOfView)
    {
    	bot.viewByTitle(titleOfView).setFocus();
    }
    
    public void getActiveViewTitleName()
    {
    	bot.activeView().getTitle();
    }
    
    public void SelectItemInComboBoxList(String ComboBoxLabel,String ItemToSelect)
    {
   	 bot.comboBoxWithLabel(ComboBoxLabel).setSelection(ItemToSelect);
    }
}
