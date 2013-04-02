package GS.Prespectives;

import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import swtbot.Helper.utils.ContextMenuHelper;

import GS.util.SWTbotCommonAction;

public class ConfigureOrchestrator {

	 public SWTWorkbenchBot bot;
	 public SWTbotCommonAction action;
     
	 public ConfigureOrchestrator(SWTWorkbenchBot bot) throws AWTException
		{
			this.bot = bot;
			if(action==null)
			{
			this.action= new SWTbotCommonAction(bot);
			}
		}
	//Methods related to Configure Orchestrator
		public void openConfigureOrchestratorPrespective()
		{
			bot.perspectiveByLabel("Configure Orchestrator").activate();
			
		}
	 
	public void connectToNewApplicationServer()
	{   
		System.out.println("Connecting to NEw Server");
		bot.menu("File").menu("New").menu("Application Server Connection").click();
 		bot.shell("New Application Server Connection").activate();
		 bot.comboBoxWithLabel("Application Server type:").setSelection("WEBLOGIC");
			 bot.textWithLabel("JNDI Service Provider URL:").setText("t3://inauto04:8003");
		
		 bot.textWithLabel("Username:").setText("gsource");
	     bot.textWithLabel("Password:").setText("gsource123");
		 System.out.println("Click Finish button");
		
		 System.out.println("Avtive view"+bot.activeShell().getText());
		
	     bot.button("Finish").click();
	    
	     String Active_Shell;
	     do{
	     Active_Shell = bot.activeShell().getText();
	     System.out.println("Active Sheel is "+Active_Shell);
	     try{
	     if(bot.button("Close").isVisible())
	     {  
	    	 System.out.println("Close button displayed");
	    	 bot.button("Close").click();
	     }
	     }catch(Throwable t)
	     {
	    	 System.out.println("Do nothing");
	     }
	     System.out.println("Checking"); 
	    
	     } while(!Active_Shell.equalsIgnoreCase("Configure Orchestrator - GoldenSource Workbench"));
	     bot.viewByTitle("Orchestrator Configuration Explorer").setFocus();
	     System.out.println("Active View is "+bot.activeView().getTitle());
	}
	

	public void getEnvironmentName()
	{
		SWTBotTree tree = bot.activeView().bot().tree(0);
	}
	
	public void RunWorkFlow(String Feature,String workflowName,String WorkflowState,String ContextMenuItem) throws InterruptedException
	{    
		SWTBotTree OrchestratorConfiTree = bot.viewByTitle("Orchestrator Configuration Explorer").bot().tree();
	    //System.out.println(bot.activeView().bot().tree(0).getText());
	    //System.out.println( bot.treeWithLabel("WEBLOGIC[gsource@t3://inqa05:8003]",0).getId());
	    //System.out.println( bot.treeWithLabel("WEBLOGIC[gsource@t3://inqa05:8003]",0).getAllItems());
	    System.out.println("Clicked");
	    SWTBotTreeItem[] OrchestratorConfiENV = OrchestratorConfiTree.getAllItems();
	    search:
	    for(SWTBotTreeItem EnvName :OrchestratorConfiENV)
	    {   
	    	EnvName.expand();
	    	System.out.println(EnvName.getText());
	    	//Getting Environemnts in the APP server
	    	SWTBotTreeItem[] AllEnvironmentNames = EnvName.getItems();
	    	System.out.println("Size"+AllEnvironmentNames.length);
	    	for(SWTBotTreeItem EnvItem:AllEnvironmentNames)
	    	{   
	    		EnvItem.expand();
	    		System.out.println("--Env NAmes--"+EnvItem.getText());
	    		//Getting all the Folders inside the Env like Workflow
	    		SWTBotTreeItem[] AllFoldersInside = EnvItem.getItems();
	    		System.out.println(AllFoldersInside.length);
	    		for(SWTBotTreeItem folder:AllFoldersInside)
	    		{ //TRaversing to all the Folders one by one
	    			folder.expand();
	    			System.out.println("----Folder--"+folder.getText());
	    			//opening the FOlders inside Main Folder like Workflow
	    			SWTBotTreeItem[] InsideFoldersInside = folder.getItems();
	    			for(SWTBotTreeItem Insidefolder:InsideFoldersInside)
	        		{	
	    				Insidefolder.expand();
	    				System.out.println("---------Inside---"+Insidefolder.getText());
	    				if(Insidefolder.getText().equalsIgnoreCase(Feature))
	    				{     Insidefolder.expand();
	    					//Getting the Workflows Inside Standard folder
	    					SWTBotTreeItem[] AllWorkFlows =  Insidefolder.getItems();
	    					 
	    						for(SWTBotTreeItem WorkflowItem : AllWorkFlows)
	    						 { 
	    						   if(WorkflowItem.getText().equalsIgnoreCase(workflowName))
	    							{  
	    							   WorkflowItem.select().expand();
	    							   System.out.println("Clicking Workflow");
	    							   //Below Line is to open the context menu For the WorkFlow and click View
	    							   //WorkflowContextMenu(WorkflowItem,OrchestratorConfiTree,"View");
	    							   
	    							   //Expanding the Workflow and Getting the Development and Released Version and Its Context Menu
	    							   SWTBotTreeItem[] StatusOfWorkflowITEMS= WorkflowItem.getItems();
	    							   for(SWTBotTreeItem WorkflowINState : StatusOfWorkflowITEMS)
	    							   {   //=------------
	    								   System.out.println("WorkFlow state "+WorkflowINState.getText());
	    								   if(WorkflowINState.getText().equalsIgnoreCase(WorkflowState)&&WorkflowState.equalsIgnoreCase("In Development"))
	    								   {    
	    									   // Example : DevelopmentVersionContextMenu("In Development",OrchestratorConfiTree,"View");
	    										 DevelopmentVersionContextMenu(WorkflowINState,OrchestratorConfiTree,ContextMenuItem);
	    								   }else if(WorkflowINState.getText().equalsIgnoreCase(WorkflowState)&&WorkflowState.equalsIgnoreCase("Released"))
	    								   {  
	    									   System.out.println("Released");
	    									break search;
	    									   // Example : ReleasedVersionContextMenu("Released",OrchestratorConfiTree,"View");
	    									  // ReleasedVersionContextMenu(WorkflowINState,OrchestratorConfiTree,ContextMenuItem);
	    								   }
	    							   }//-----------------------------
	    							      							  
	    							   Thread.sleep(3000);
	    							   //FoundItem=true;
	    							   
	    							
	    						 }
	    					 }
	    					
	    			}
	        		}
	    		}
	    		
	    	}
	    }
		
		
	}
	
	private void WorkflowContextMenu(SWTBotTreeItem WorkflowItem,SWTBotTree OrchestratorConfiTree,String ContextMenuOption)
	{
		WorkflowItem.select();
		   ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,ContextMenuOption);
	}
	
	//Select the Development Workflow and Click the Context menu option which is passed
	//TO DO : We can Extend the Released Version for further use related to the specific Version of the workflow
	/**
	 * Method Used to click In Development Context Menu options from the Workflow Context Menu if the Version is not present for the Development 
	 * if the VErsion is present for the development it will open the context menu for the Version present.
	 */

	private void DevelopmentVersionContextMenu(SWTBotTreeItem WorkflowINState,SWTBotTree OrchestratorConfiTree,String ContextMenuOption)
	{
		 SWTBotTreeItem[] InDevelopmentVersionITEMS= WorkflowINState.getItems();
		 int RelVErsion = InDevelopmentVersionITEMS.length;
		 
		 if(RelVErsion!=0)  //If Development Version is Present For the WorkFlow 
		 {
		 for(SWTBotTreeItem WorkflowVersion : InDevelopmentVersionITEMS)
		   {
			  
			   WorkflowVersion.select();//Select the First Development Version
			   ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,ContextMenuOption);//Click the context MEnu OPtion provided by user
		   }}else{
		WorkflowINState.select();//If NO Development Version Present the Workflow Context Menu Clicked
		   ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,ContextMenuOption);
		   }
		   }
	
	//Select the Released Workflow and Click the Context menu option which is passed
	//TO DO : We can Extend the Released Version for further use related to the specific Version of the workflow
	/**
	 * Method Used to click In In Released Context Menu options from the Workflow Context Menu if the Version is not present for the Released 
	 * if the VErsion is present for the Released it will open the context menu for the Version present.
	 */
	private void ReleasedVersionContextMenu(SWTBotTreeItem WorkflowINState,SWTBotTree OrchestratorConfiTree,String ContextMenuOption)
	{    System.out.println("Release MEthod");
		 SWTBotTreeItem[] ReleasedVersionITEMS= WorkflowINState.getItems();
		 System.out.println(ReleasedVersionITEMS.length);
		 int RelVErsion = ReleasedVersionITEMS.length;
		 
		 if(RelVErsion!=0)  //If Released Version is Present For the WorkFlow 
		 {
		 for(SWTBotTreeItem WorkflowVersion : ReleasedVersionITEMS)
		   {
			  System.out.println("Selecting Released VErsion"+WorkflowVersion.getText());
			   WorkflowVersion.select();//Select the First Released Version
			   //ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,ContextMenuOption);//Click the context MEnu OPtion provided by user
		   }}else{
			   System.out.println("NO Released");
		WorkflowINState.select();//If NO Released Version Present the Workflow Context Menu Clicked
		   ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,ContextMenuOption);
		   }
		
	}
	private void write(String path) throws IOException
	{
		Writer FlowString;
		File file = new File("C:\\GoldenSource\\Workbench_8.4.11\\FlowFile.txt");
		FlowString = new BufferedWriter(new FileWriter(file));
		FlowString.write(path);
	}
	
	public void CreateFlowFile(String Feature,String workflowName,String WorkflowState,String ContextMenuItem) throws InterruptedException, IOException
	{    
		StringBuilder  PATH=null;
		
		SWTBotTree OrchestratorConfiTree = bot.viewByTitle("Orchestrator Configuration Explorer").bot().tree();
	    //System.out.println(bot.activeView().bot().tree(0).getText());
	    //System.out.println( bot.treeWithLabel("WEBLOGIC[gsource@t3://inqa05:8003]",0).getId());
	    //System.out.println( bot.treeWithLabel("WEBLOGIC[gsource@t3://inqa05:8003]",0).getAllItems());
	    System.out.println("Clicked");
	    SWTBotTreeItem[] OrchestratorConfiENV = OrchestratorConfiTree.getAllItems();
	    
	    for(SWTBotTreeItem EnvName :OrchestratorConfiENV)
	    {   
	    	EnvName.expand();
	    	System.out.println(EnvName.getText());
	    	PATH.append(EnvName.getText()+",");
	    	//Getting Environemnts in the APP server
	    	SWTBotTreeItem[] AllEnvironmentNames = EnvName.getItems();
	    	System.out.println("Size"+AllEnvironmentNames.length);
	    	for(SWTBotTreeItem EnvItem:AllEnvironmentNames)
	    	{   
	    		EnvItem.expand();
	    		System.out.println("--Env NAmes--"+EnvItem.getText());
	    		//Getting all the Folders inside the Env like Workflow
	    		SWTBotTreeItem[] AllFoldersInside = EnvItem.getItems();
	    		System.out.println(AllFoldersInside.length);
	    		for(SWTBotTreeItem folder:AllFoldersInside)
	    		{ //TRaversing to all the Folders one by one
	    			folder.expand();
	    			System.out.println("----Folder--"+folder.getText());
	    			//opening the FOlders inside Main Folder like Workflow
	    			SWTBotTreeItem[] InsideFoldersInside = folder.getItems();
	    			for(SWTBotTreeItem Insidefolder:InsideFoldersInside)
	        		{	
	    				Insidefolder.expand();
	    				System.out.println("---------Inside---"+Insidefolder.getText());
	    				if(Insidefolder.getText().equalsIgnoreCase(Feature))
	    				{     Insidefolder.expand();
	    					//Getting the Workflows Inside Standard folder
	    					SWTBotTreeItem[] AllWorkFlows =  Insidefolder.getItems();
	    					 
	    						for(SWTBotTreeItem WorkflowItem : AllWorkFlows)
	    						 { 
	    						   if(WorkflowItem.getText().equalsIgnoreCase(workflowName))
	    							{  
	    							   WorkflowItem.select().expand();
	    							   System.out.println("Clicking Workflow");
	    							   //Below Line is to open the context menu For the WorkFlow and click View
	    							   //WorkflowContextMenu(WorkflowItem,OrchestratorConfiTree,"View");
	    							   
	    							   //Expanding the Workflow and Getting the Development and Released Version and Its Context Menu
	    							   SWTBotTreeItem[] StatusOfWorkflowITEMS= WorkflowItem.getItems();
	    							   for(SWTBotTreeItem WorkflowINState : StatusOfWorkflowITEMS)
	    							   {   //=------------
	    								   if(WorkflowINState.getText().equals("Released"))
	    								   {
	    									   SWTBotTreeItem[] app  = WorkflowINState.getItems();
	    									   System.out.println(app.length);
	    									   for(SWTBotTreeItem pp :app)
	    									   {
	    										   System.out.println("a"+pp.getText());
														
	    										   pp.select();
	    										   ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,"View");
	    									   }
	    								   }
	    							   }//-----------------------------
	    							      							  
	    							   Thread.sleep(3000);
	    							   //FoundItem=true;
	    							   
	    							return;
	    						 }
	    					 }
	    					
	    			}
	        		}
	    		}
	    		
	    	}
	    }
		
		
	}
	
	
	
	
	
}