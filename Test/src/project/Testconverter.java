package project;

public class Testconverter {
	public static void main(String[] args) {
		System.out.println(intToBinaryString(9));
		System.out.println(intToBinaryString(4));
	}
	public static String intToBinaryString(int num) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = false; // 标志：true表示为负数
		int rem;
		if (num == 0) {
			return "0";
		} else if (num < 0) {
			flag = true;
			num = Math.abs(num + 1);
		}

		while (num != 0) {
			// 正数，保持不变；负数，取反
			rem = (!flag && num % 2 == 0) || (flag && num % 2 == 1) ? 0 : 1;
			num = num / 2;
			System.out.println("num = " + num + "\t" + "rem = " + rem);
			stringBuilder.append(rem);
		}

		// 判断是否为负数，如果是负数，那么前面所有位补1
		if (flag) {
			num = stringBuilder.length();
			for (int i = 1; i <= 32 - num; i++) {
				stringBuilder.append("1");
			}
		}

		return stringBuilder.reverse().toString();

	}
}
