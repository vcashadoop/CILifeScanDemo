

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
// --- <<IS-END-IMPORTS>> ---

public final class startupservice

{
	// ---( internal utility methods )---

	final static startupservice _instance = new startupservice();

	static startupservice _newInstance() { return new startupservice(); }

	static startupservice _cast(Object o) { return (startupservice)o; }

	// ---( server methods )---




	public static final void readProperties (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(readProperties)>> ---
		// @sigtype java 3.5
		// [o] field:0:required url
		// [o] field:0:required username
		// [o] field:0:required password
		// [o] field:0:required fileformat
			InputStream inputStream =null;
		try {
			Properties prop = new Properties();
			String propFileName = "globalvariables.properties";
			inputStream = new FileInputStream("packages/Toll/config/globalvariables.properties"); 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file " + propFileName + " not found");
			}
			// get the property values
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String fileformat = prop.getProperty("fileformat");
			IDataCursor pipelineCursor = pipeline.getCursor();
			IDataUtil.put( pipelineCursor, "url", url );
			IDataUtil.put( pipelineCursor, "username", username);
			IDataUtil.put( pipelineCursor, "password", password );
			IDataUtil.put( pipelineCursor, "fileformat", fileformat );
			pipelineCursor.destroy();
		} catch (Exception e) {
			
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block		
			}
		}
		// --- <<IS-END>> ---

                
	}
}

