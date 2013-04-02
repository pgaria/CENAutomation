package GS.Prespectives;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

public class ConfigureOrchestratorBot {
	 private SWTWorkbenchBot bot;
	    private ConfigureOrchestratorWidget browserBot;


	    public ConfigureOrchestratorBot()
	    {
	        bot = new SWTWorkbenchBot();
	        SWTBotView view = bot.viewByTitle( "Orchestrator Configuration Explorer" );
	        view.show();

	        browserBot = new ConfigureOrchestratorWidget( view.bot() );
	    }


	    public boolean existsEntry( String... path )
	    {
	        return browserBot.existsEntry( path );
	    }


	    public void selectEntry( String... path )
	    {
	        browserBot.selectEntry( path );
	    }


	    public void selectChildrenOfEnty( String[] children, String... path )
	    {
	        browserBot.selectChildrenOfEnty( children, path );
	    }


	  /*  public ReferralDialogBot selectEntryExpectingReferralDialog( String... path )
	    {
	        return browserBot.selectEntryExpectingReferralDialog( path );
	    }
*/

	    public void expandEntry( String... path )
	    {
	       // JobWatcher watcher = new JobWatcher( BrowserCoreMessages.jobs__init_entries_title_subonly );
	        browserBot.expandEntry( path );
	        //watcher.waitUntilDone();
	    }


	    public void waitForEntry( String... path )
	    {
	        browserBot.waitForEntry( path );
	    }


	 /*   public ReferralDialogBot expandEntryExpectingReferralDialog( String... path )
	    {
	        return browserBot.expandEntryExpectingReferralDialog( path );
	    }*/

/*
	    public NewEntryWizardBot openNewEntryWizard()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "New", "New Entry..." );
	        return new NewEntryWizardBot();
	    }


	    public SearchDialogBot openSearchDialog()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "New", "New Search..." );
	        return new SearchDialogBot();
	    }*/


	 /*   public RenameEntryDialogBot openRenameDialog()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Rename Entry..." );
	        return new RenameEntryDialogBot();
	    }


	    public DeleteDialogBot openDeleteDialog()
	    {
	        if ( browserBot.getTree().selectionCount() == 1 )
	        {
	            ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Delete Entry" );
	            return new DeleteDialogBot( DeleteDialogBot.DELETE_ENTRY_TITLE );
	        }
	        else
	        {
	            ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Delete Entries" );
	            return new DeleteDialogBot( DeleteDialogBot.DELETE_ENTRIES_TITLE );
	        }
	    }


	    public ExportWizardBot openExportLdifWizard()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Export", "LDIF Export..." );
	        return new ExportWizardBot( ExportWizardBot.EXPORT_LDIF_TITLE );
	    }


	    public ExportWizardBot openExportDsmlWizard()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Export", "DSML Export..." );
	        return new ExportWizardBot( ExportWizardBot.EXPORT_DSML_TITLE );
	    }


	    public ImportWizardBot openImportLdifWizard()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Import", "LDIF Import..." );
	        return new ImportWizardBot( ImportWizardBot.IMPORT_LDIF_TITLE );
	    }


	    public ImportWizardBot openImportDsmlWizard()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Import", "DSML Import..." );
	        return new ImportWizardBot( ImportWizardBot.IMPORT_DSML_TITLE );
	    }


	    public void refresh()
	    {
	        JobWatcher watcher = new JobWatcher( BrowserCoreMessages.jobs__init_entries_title_subonly );
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Reload Entry" );
	        watcher.waitUntilDone();
	    }


	    public void copy()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Copy" );
	    }


	    public void paste()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Paste" );
	    }


	    public SearchPropertiesDialogBot pasteSearch()
	    {
	        ContextMenuHelper.clickContextMenu( browserBot.getTree(), "Paste" );
	        return new SearchPropertiesDialogBot();
	    }
*/

	    public void typeQuickSearchAttributeType( String attributeType )
	    {
	        bot.comboBox( 0 ).setText( attributeType );
	    }


	    public void typeQuickSearchValue( String value )
	    {
	        bot.comboBox( 2 ).setText( value );
	    }


	    public void clickRunQuickSearchButton()
	    {
	        bot.buttonWithTooltip( "Run Quick Search" ).click();
	    }


	    public boolean isQuickSearchEnabled()
	    {
	        return bot.comboBox( 0 ).isEnabled();
	    }

	}
