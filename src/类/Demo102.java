package 类;

public class Demo102 {

}

public class SuperDashboard extends JFrame implements MetaDataUser

		public String getCustomizerLanguagePath()

		public void setSystemConfigPath(String systemConfigPath)

		public String getSystemConfigDocument()

		public void setSystemConfigDocument(String systemConfigDocument)

		public boolean getGuruState()

		public boolean getNoviceState()

		public boolean getOpenSourceState()

		public void showObject(MetaObject object)

		public void showProgress(String s)

		public boolean isMetadataDirty()

		public void setIsMetadataDirty(boolean isMetadataDirty)

		public Component getLastFocusedComponent()

		public void setLastFocused(Component lastFocused)

		public void setMouseSelectState(boolean isMouseSelected)

		public boolean isMouseSelected()

		public LanguageManager getLanguageManager()

		public Project getProject()

		public Project getFirstProject()

		public Project getLastProject()

		public String getNewProjectName()

		public void setComponentSizes(Dimension dim)

		public String getCurrentDir()

		public void setCurrentDir(String newDir)

		public void updateStatus(int dotPos, int markPos)

		public Class[] getDataBaseClasses()

		public MetadataFeeder getMetadataFeeder()

		public void addProject(Project project)

		public boolean setCurrentProject(Project project)

		public boolean removeProject(Project project)

		public MetaProjectHeader getProgramMetadata()

		public void resetDashboard()

		public Project loadProject(String fileName, String projectName)

		public void setCanSaveMetadata(boolean canSave)

		public MetaObject getSelectedObject()

		public void deselectObjects()

		public void setProject(Project project)

		public void editorAction(String actionName, ActionEvent event)

		public void setMode(int mode)

		public FileManager getFileManager()

		public void setFileManager(FileManager fileManager)

		public ConfigManager getConfigManager()

		public void setConfigManager(ConfigManager configManager)

		public ClassLoader getClassLoader()

		public void setClassLoader(ClassLoader classLoader)

		public Properties getProps()

		public String getUserHome()

		public String getBaseDir()

		public int getMajorVersionNumber()

		public int getMinorVersionNumber()

		public int getBuildNumber()

		public MetaObject pasting(MetaObject target, MetaObject pasted, MetaProject project)

		public void processMenuItems(MetaObject metaObject)

		public void processMenuSeparators(MetaObject metaObject)

		public void processTabPages(MetaObject metaObject)

		public void processPlacement(MetaObject object)

		public void processCreateLayout(MetaObject object)

		public void updateDisplayLayer(MetaObject object, int layerIndex)

		public void propertyEditedRepaint(MetaObject object)

		public void processDeleteObject(MetaObject object)

		public boolean getAttachedToDesigner()

		public void processProjectChangedState(boolean hasProjectChang)

		public void processObjectNameChanged(MetaObject object)

		public void runProject()

		public void setAçowDragging(boolean allowDragging)

		public boolean allowDragging()

		public boolean isCustomizing()

		public void setTitle(String title)

		public IdeMenuBar getIdeMenuBar()

		public void showHelper(MetaObject metaObject, String propertyName)

		// ... many non-public methods follow ...

}

public class SuperDashboard extends JFrame implements MetaDataUser {

	public Component getLastFocusedComponent()

	public void setLastFocused(Component lastFocused)

	public int getMajorVersionNumber()

	public int getMinorVersionNumber()

	public int getBuildNumber()

}
