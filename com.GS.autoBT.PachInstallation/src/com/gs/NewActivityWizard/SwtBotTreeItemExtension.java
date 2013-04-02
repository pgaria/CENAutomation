package com.gs.NewActivityWizard;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.results.WidgetResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.hamcrest.SelfDescribing;

/**
* @author doconnor
*
*/
public class SwtBotTreeItemExtension  extends SWTBotTreeItem {
	private Tree mParentTree;
/**
* 
* @param treeItem - A SWTBotTreeItem object from which we can get a TreeItem widget
* @throws WidgetNotFoundException
*/
	public SwtBotTreeItemExtension(final TreeItem treeItem, 
			SelfDescribing selfDescribing)
			{
			super(treeItem, selfDescribing);
			mParentTree = syncExec(new WidgetResult<Tree>()
			{
			public Tree run()
			{
			return treeItem.getParent();
			}
			});
			}

/**
* Overrides the behavior of {@link SWTBotTreeItem#click()} such that this method now
* calls {@link SWTBotTreeItemExt#click(int)} with an index of 0
* This method will click on the first column cell
*/
@Override
public SWTBotTreeItem click() {
return click(0);
}

/**
* @param column - Index of the column on which the caller wants to click
* @return
* 
* Clicks on the current TreeItem in the column specified by <code>column</code>
*/
public SWTBotTreeItem click(final int column){
assertEnabled();
Rectangle cellBounds = syncExec(new Result<Rectangle>() {
public Rectangle run() {
Rectangle r = widget.getBounds(column);
return r;
}
});

int x = (cellBounds.width / 2);
clickXY(cellBounds.x + x, cellBounds.y + (cellBounds.height / 2));
return this;
}

public String getText(int column){
return cell(column);
}


}
