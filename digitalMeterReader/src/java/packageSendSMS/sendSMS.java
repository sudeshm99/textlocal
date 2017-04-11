
package packageSendSMS;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.net.URLConnection;
    import java.net.URLEncoder;
     
    public class sendSMS {
    	public String send(String massage, String number) {
    		try {
    			// Construct data
    			String user = "username=" + "sudeshm40@gmil.com";
    			String hash = "&hash=" + "e4b1f08a81b2e650d73c914e69c0171d981e577afa4a9471af24c5f7b485bb19";
    			String message = "&message=" + massage;
    			String sender = "&sender=" + "Sudesh";
    			String numbers = "&numbers=" + "94" + number.substring(1);
    			
    			// Send data
    			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.txtlocal.com/send/?").openConnection();
    			String data = user + hash + numbers + message + sender;
    			conn.setDoOutput(true);
    			conn.setRequestMethod("POST");
    			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
    			conn.getOutputStream().write(data.getBytes("UTF-8"));
    			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    			final StringBuffer stringBuffer = new StringBuffer();
    			String line;
    			while ((line = rd.readLine()) != null) {
    				stringBuffer.append(line);
    			}
    			rd.close();
    			
    			return stringBuffer.toString();
    		} catch (Exception e) {
    			System.out.println("Error SMS "+e);
    			return "Error "+e;
    		}
    	}
    }
