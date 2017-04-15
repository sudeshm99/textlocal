
package packageSendSMS;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.net.URLConnection;
    import java.net.URLEncoder;
     
  public class sendSMS {
	public String sendSms(String massage, String no) {
		try {
			// Construct data
			String user = "username=" + "digital.meter202@gmail.com";
			String hash = "&hash=" + "50aa0d2d26c1e5b1a04fce29cce29886a7b45a8a21be0adaed100c1935c55606";
			String message = "&message=" + massage;
			String sender = "&sender=" + "ceb";
			String numbers = "&numbers=" + no;
			
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
