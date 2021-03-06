package nl.maastrichtuniversity.networklibrary.cyneo4j.internal.extensionlogic;

import java.util.List;

import nl.maastrichtuniversity.networklibrary.cyneo4j.internal.Plugin;

public interface ExtensionExecutor {
	
	/**
	 * Use this method to obtain all necessary parameters for the execution of the extension
	 * form the user and/or the environment
	 * @return true if the collection is successful, false if any problem arose
	 */
	boolean collectParameters();

	/**
	 * This method will be called after each extension call is executed by the server.
	 * @param call The call that was executed
	 * @param callRetValue The return value generated by the call
	 */
	void processCallResponse(ExtensionCall call, Object callRetValue);

	void setPlugin(Plugin plugin);
	void setExtension(Extension extension);

	/**
	 * Generate here a list of calls that should be executed. Each of the calls is going to be executed
	 * sequentially and the call and result will be handed backed to the ExtensionExecutor
	 * @return List of calls for the server to execute
	 */
	List<ExtensionCall> buildExtensionCalls();
	
}
