ECHO ON
SET Eclipse_Home=%1
ECHO Weorking on %Eclipse_Home%
eclipsec.exe -application org.eclipse.equinox.p2.director -repository http://download.eclipse.org/technology/swtbot/releases/latest/,http://download.eclipse.org/releases/juno/ -installIU org.eclipse.swtbot.forms.feature.group,org.eclipse.swtbot.eclipse.feature.group,org.eclipse.swtbot.eclipse.gef.feature.group,org.eclipse.swtbot.feature.group,org.eclipse.swtbot.ide.feature.group,org.eclipse.swtbot.eclipse.test.junit.feature.group -tag swtbot -destination %Eclipse_Home% -profile SDKProfile
