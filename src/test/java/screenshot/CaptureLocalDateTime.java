package screenshot;

import java.time.LocalDateTime;

public class CaptureLocalDateTime {
public static void main(String[] args) {
	/*
	 * LocalDateTime ldt = LocalDateTime.now(); System.out.println(ldt); String
	 * updatedLDT = ldt.toString().replace(':', '-');
	 * System.out.println(updatedLDT);
	 */
	String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	System.out.println(timeStamp);
}
}
