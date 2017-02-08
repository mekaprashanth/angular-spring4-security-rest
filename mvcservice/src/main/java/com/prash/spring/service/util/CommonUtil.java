/**
 * 
 */
package com.prash.spring.service.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

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
	
	public static void main(String[] args) throws ParseException {
		NumberFormat nf = NumberFormat.getInstance(Locale.CHINA);
		BigDecimal val = new BigDecimal(413.99);
		Double d = Double.valueOf(nf.format(val.doubleValue()));
//		Double d = (Double) nf.parse(nf.format(val.doubleValue()));
		System.out.println(d);
	}
}
