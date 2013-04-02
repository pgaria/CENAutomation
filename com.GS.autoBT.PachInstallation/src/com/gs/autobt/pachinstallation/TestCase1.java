package com.gs.autobt.pachinstallation;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.eclipse.swtbot.eclipse.finder.matchers.WidgetMatcherFactory;
import org.eclipse.swtbot.swt.finder.utils.FileUtils;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
public class TestCase1 {
	private static SWTWorkbenchBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close();
	}

	@AfterClass
	public static void sleep() {
		bot.sleep(5000);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		SWTBotView packageExplorerView = bot.viewByTitle("Package Explorer");
		packageExplorerView.show();
		Composite packageExplorerComposite = (Composite) packageExplorerView.getWidget();

		Tree swtTree = (Tree) bot.widget(WidgetMatcherFactory.widgetOfType(Tree.class), packageExplorerComposite);
		SWTBotTree tree = new SWTBotTree(swtTree);

		tree.select("MyFirstProject");

		bot.menu("Edit").menu("Delete").click();

		// the project deletion confirmation dialog
		SWTBotShell shell = bot.shell("Delete Resources");
		shell.activate();
		bot.checkBox("Delete project contents on disk (cannot be undone)").select();
		bot.button("OK").click();
		//bot.waitUntil(shellCloses(shell));
	}

	@Test
	public void canCreateANewJavaProject() throws Exception {
		// use the NewProjectBot abstraction
      //  NewProjectBot newProjectBot = new NewProjectBot();
       // newProjectBot.setProjectName("MyFirstProject");
       // newProjectBot.finish();

		assertProjectCreated();
	}

	private void assertProjectCreated() {
		SWTBotView packageExplorerView = bot.viewByTitle("Package Explorer");
		packageExplorerView.show();
		Composite packageExplorerComposite = (Composite) packageExplorerView.getWidget();

		Tree swtTree = (Tree) bot.widget(WidgetMatcherFactory.widgetOfType(Tree.class), packageExplorerComposite);
		SWTBotTree tree = new SWTBotTree(swtTree);
		// throws WNFE if the item does not exist
		tree.getTreeItem("MyFirstProject");
	}

	@Test
	public void canCreateANewJavaClass() throws Exception {
		bot.toolbarDropDownButtonWithTooltip("New Java Class").menuItem("Class").click();

		bot.shell("New Java Class").activate();
		bot.textWithLabel("Source folder:").setText("MyFirstProject/src");

		bot.textWithLabel("Package:").setText("org.eclipsecon.project");
		bot.textWithLabel("Name:").setText("HelloWorld");

		bot.button("Finish").click();

		// FIXME: assert that the class is actually created, for later
	}

	@Test
	public void canTypeInTextInAJavaClass() throws Exception {
		//Bundle bundle = Activator.getContext().getBundle();
		//String contents = FileUtils.read(bundle.getEntry("test-files/HelloWorld.java"));
		SWTBotEditor editor = bot.editorByTitle("HelloWorld.java");
		SWTBotEclipseEditor e = editor.toTextEditor();
		//e.setText(contents);
		editor.save();

		// FIXME: verify that the text is actually placed in the editor
	}

	@Test
	public void canExecuteJavaApplication() throws Exception {
		bot.menu("Run").menu("Run").click();

		// FIXME, get rid of sleep
		bot.sleep(5000);
		SWTBotView view = bot.viewByTitle("Console");
		Widget consoleViewComposite = view.getWidget();

		StyledText console = bot.widget(WidgetMatcherFactory.widgetOfType(StyledText.class), consoleViewComposite);
		SWTBotStyledText styledText = new SWTBotStyledText(console);

		//assertTextContains("Hello World", styledText);
	}

	
	
	
}
