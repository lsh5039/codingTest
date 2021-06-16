package codintTest2;

public class Chal001 {
	public String solution(int[] numbers, String hand) {// 프로그래머스 // 카카오 2020 인턴십// 키패드 누르기
		String answer = "";
		int[] left = { 0, 0 };
		int[] right = { 2, 0 };

		for (int num : numbers) {

			switch (num) {
			// 왼손
			case 1:
				answer += "L";
				left[0] = 0;
				left[1] = 3;
				break;
			case 4:
				answer += "L";
				left[0] = 0;
				left[1] = 2;
				break;
			case 7:
				answer += "L";
				left[0] = 0;
				left[1] = 1;
				break;
			// 오른손
			case 3:
				answer += "R";
				right[0] = 2;
				right[1] = 3;

				break;
			case 6:
				answer += "R";
				right[0] = 2;
				right[1] = 2;
				break;
			case 9:
				answer += "R";
				right[0] = 2;
				right[1] = 1;
				break;
			// 위치따라
			case 2:
				int leftX = 1 - left[0];
				if (leftX < 0) {
					leftX *= -1;
				}
				int leftY = 3 - left[1];
				if (leftY < 0) {
					leftY *= -1;
				}
				int leftMove = leftX + leftY;

				int rightX = right[0] - 1;
				int rightY = right[1] - 3;
				if (rightX < 0) {
					rightX *= -1;
				}
				if (rightY < 0) {
					rightY *= -1;
				}

				int rightMove = rightX + rightY;

				if (leftMove > rightMove) {
					answer += "R";
					right[0] = 1;
					right[1] = 3;

				} else if (leftMove < rightMove) {
					answer += "L";
					left[0] = 1;
					left[1] = 3;

				} else {// 거리가 같음
					if (hand.equals("left")) {// 왼손잡이
						answer += "L";
						left[0] = 1;
						left[1] = 3;
					} else {// 오른손 잡이
						answer += "R";
						right[0] = 1;
						right[1] = 3;
					}
				}
				break;
			case 5:
				int leftX5 = 1 - left[0];
				if (leftX5 < 0) {
					leftX5 *= -1;
				}
				int leftY5 = 2 - left[1];
				if (leftY5 < 0) {
					leftY5 *= -1;
				}
				int leftMove5 = leftX5 + leftY5;

				int rightX5 = right[0] - 1;
				int rightY5 = right[1] - 2;

				if (rightX5 < 0) {
					rightX5 *= -1;
				}
				if (rightY5 < 0) {
					rightY5 *= -1;
				}

				int rightMove5 = rightX5 + rightY5;

				if (leftMove5 > rightMove5) {
					answer += "R";
					right[0] = 1;
					right[1] = 2;

				} else if (leftMove5 < rightMove5) {
					answer += "L";
					left[0] = 1;
					left[1] = 2;

				} else {// 거리가 같음
					if (hand.equals("left")) {// 왼손잡이
						answer += "L";
						left[0] = 1;
						left[1] = 2;
					} else {// 오른손 잡이
						answer += "R";
						right[0] = 1;
						right[1] = 2;
					}
				}

				break;
			case 8:
				int leftX8 = 1 - left[0];
				if (leftX8 < 0) {
					leftX8 *= -1;
				}
				int leftY8 = 1 - left[1];
				if (leftY8 < 0) {
					leftY8 *= -1;
				}
				int leftMove8 = leftX8 + leftY8;

				int rightX8 = right[0] - 1;
				int rightY8 = right[1] - 1;
				// System.out.println(rightX8);
				// System.out.println(rightY8);
				if (rightX8 < 0) {
					rightX8 *= -1;
				}
				if (rightY8 < 0) {
					rightY8 *= -1;
				}
				int rightMove8 = rightX8 + rightY8;

				if (leftMove8 > rightMove8) {
					answer += "R";
					right[0] = 1;
					right[1] = 1;

				} else if (leftMove8 < rightMove8) {
					answer += "L";
					left[0] = 1;
					left[1] = 1;

				} else {// 거리가 같음
					if (hand.equals("left")) {// 왼손잡이
						answer += "L";
						left[0] = 1;
						left[1] = 1;
					} else {// 오른손 잡이
						answer += "R";
						right[0] = 1;
						right[1] = 1;
					}
				}

				break;

			case 0:
				int leftX0 = 1 - left[0];
				if (leftX0 < 0) {
					leftX0 *= -1;
				}
				int leftY0 = 0 - left[1];
				if (leftY0 < 0) {
					leftY0 *= -1;
				}
				int leftMove0 = leftX0 + leftY0;

				int rightX0 = right[0] - 1;
				int rightY0 = right[1] - 0;

				if (rightX0 < 0) {
					rightX0 *= -1;
				}
				if (rightY0 < 0) {
					rightY0 *= -1;
				}
				int rightMove0 = rightX0 + rightY0;

				if (leftMove0 > rightMove0) {
					answer += "R";
					right[0] = 1;
					right[1] = 0;

				} else if (leftMove0 < rightMove0) {
					answer += "L";
					left[0] = 1;
					left[1] = 0;

				} else {// 거리가 같음
					if (hand.equals("left")) {// 왼손잡이
						answer += "L";
						left[0] = 1;
						left[1] = 0;
					} else {// 오른손 잡이
						answer += "R";
						right[0] = 1;
						right[1] = 0;
					}
				}

				break;

			}

			// System.out.println("왼손 : " + Arrays.toString(left));
			// System.out.println("오른손 : "+ Arrays.toString(right));

		}

		return answer;
	}
}
