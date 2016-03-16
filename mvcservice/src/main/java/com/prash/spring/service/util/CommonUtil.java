/**
 * 
 */
package com.prash.spring.service.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * @author Prashanth_Meka
 *
 */
public class CommonUtil {

	public static boolean hasXMinutesPassed(Date date, int x) {
		if (date == null) {
			return false;
		}
		DateTime paramDate = new DateTime(date);
		return paramDate.plusMinutes(x).isBeforeNow();
	}

	public static boolean hasXSecondsPassed(Date date, int x) {
		if (date == null) {
			return false;
		}
		DateTime paramDate = new DateTime(date);
		return paramDate.plusSeconds(x).isBeforeNow();
	}

	public static byte[] getBytesFromInputStream(InputStream is) throws IOException {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			byte[] buffer = new byte[0xFFFF];

			for (int len; (len = is.read(buffer)) != -1;)
				os.write(buffer, 0, len);

			os.flush();

			return os.toByteArray();
		}
	}
}
