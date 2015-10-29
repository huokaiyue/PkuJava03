import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 *      
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ�����꣬����������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {

		int x = 1;
		int y = 1;
		long weight = 0;// ��ʼ��Ȩֵ
		long defenceWeight = 0;// ��ʼ������Ȩֵ�����������Ȩֵ���бȽ�
		String[][] board = chessboard.getBoard();// ��ȡ����
		int row = 1;
		int col = 1;// ��ʼ������λ�õ�����
		int defencerow = 1;
		int defencecol = 1;// ��ʼ������λ�����꣬��������ֹ�����γ�����
		boolean isFirst = true;// �Ƿ��ǵ�һ��
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == "ʮ") {
					// ��û�����ӵ�λ�ý���ɨ��
					if (isFirst == true) {
						row = i;
						col = j;
						weight = RowWeight(i, j, "��") + ColWeight(i, j, "��")
								+ LeftUtoDWeight(i, j, "o")
								+ LeftDtoUWeight(i, j, "o");// ���㵱ǰλ�õĽ���Ȩֵ
						isFirst = false;
					} else {
						long nowWeight = 0;
						nowWeight = RowWeight(i, j, "��") + ColWeight(i, j, "��")
								+ LeftUtoDWeight(i, j, "o")
								+ LeftDtoUWeight(i, j, "o");
						if (nowWeight > weight) {
							row = i;
							col = j;
							weight = nowWeight;
						}
					}
				}
			}
		}
		isFirst = true;// �жϺ��ӵ�λ�ã����������Ȩֵ����ס���ӵ�λ��
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == "ʮ") {
					if (isFirst == true) {
						defencerow = i;
						defencecol = j;
						defenceWeight = RowWeight(i, j, "��")
								+ ColWeight(i, j, "��")
								+ LeftUtoDWeight(i, j, "��")
								+ LeftDtoUWeight(i, j, "��");
						isFirst = false;
					} else {
						long nowWeight;
						nowWeight = RowWeight(i, j, "��") + ColWeight(i, j, "��")
								+ LeftUtoDWeight(i, j, "��")
								+ LeftDtoUWeight(i, j, "��");
						if (nowWeight > defenceWeight) {
							defencerow = i;
							defencecol = j;
							defenceWeight = nowWeight;
						}
					}
				}
			}
		}
		if (weight >= defenceWeight) {
			x = row;
			y = col;
		} else {
			x = defencerow;
			y = defencecol;
		}
		// int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// String[][] board = chessboard.getBoard();
		// while (board[posX][posY] != "ʮ") {
		// posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// }
		int[] result = { x, y };
		return result;
	}

	public long ColWeight(int row, int col, String chesscolor) {
		long weight;
		NullAndCount upCol = UpColWeight(row, col, chesscolor);
		NullAndCount downCol = DownColWeight(row, col, chesscolor);
		switch (upCol.getChessCount() + downCol.getChessCount() + 1) {
		case 1:
			if (upCol.getNullCount() == 0 && downCol.getNullCount() == 0) {
				weight = 0;
			} else if ((upCol.getNullCount() == 1 && downCol.getNullCount() == 0)
					|| (upCol.getNullCount() == 0 && downCol.getNullCount() == 1)) {
				weight = 1;
			} else {
				weight = 5;
			}
			break;
		case 2:
			if (upCol.getNullCount() == 0 && downCol.getNullCount() == 0) {
				weight = 0;
			} else if ((upCol.getNullCount() == 1 && downCol.getNullCount() == 0)
					|| (upCol.getNullCount() == 0 && downCol.getNullCount() == 1)) {
				weight = 21;
			} else {
				weight = 85;
			}
			break;
		case 3:
			if (upCol.getNullCount() == 0 && downCol.getNullCount() == 0) {
				weight = 0;
			} else if ((upCol.getNullCount() == 1 && downCol.getNullCount() == 0)
					|| (upCol.getNullCount() == 0 && downCol.getNullCount() == 1)) {
				weight = 341;
			} else {
				weight = 1365;
			}
			break;
		case 4:
			if (upCol.getNullCount() == 0 && downCol.getNullCount() == 0) {
				weight = 0;
			} else if ((upCol.getNullCount() == 1 && downCol.getNullCount() == 0)
					|| (upCol.getNullCount() == 0 && downCol.getNullCount() == 1)) {
				weight = 5461;
			} else {
				weight = 21845;
			}
			break;
		default:
			weight = 87381;
			break;
		}
		return weight;
	}

	public NullAndCount UpColWeight(int row, int col, String chesscolor) {
		String[][] board = chessboard.getBoard();
		int count = 0;
		NullAndCount nullAndCount = new NullAndCount();
		for (int i = row; i > 0; i--) {
			if (board[i - 1][col] == chesscolor) {
				count++;
			} else {
				if (board[i - 1][col] == "ʮ") {
					nullAndCount.setNullCount(1);
				}
				break;
			}
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	public NullAndCount DownColWeight(int row, int col, String chesscolor) {
		String[][] board = chessboard.getBoard();
		int count = 0;
		NullAndCount nullAndCount = new NullAndCount();
		for (int i = row; i < board.length - 1; i++) {
			if (board[i + 1][col] == chesscolor) {
				count++;
			} else {
				if (board[i + 1][col] == "ʮ") {
					nullAndCount.setNullCount(1);
				}
				break;
			}
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	public long RowWeight(int row, int col, String chesscolor) {
		NullAndCount rightRow = rightRowWeight(row, col, chesscolor);
		NullAndCount leftRow = leftRowWeight(row, col, chesscolor);
		long weight = 0;
		switch (rightRow.getChessCount() + leftRow.getChessCount() + 1) {
		case 1:
			if (rightRow.getNullCount() == 0 && leftRow.getNullCount() == 0) {
				weight = 0;
			} else if ((rightRow.getNullCount() == 1 && leftRow.getNullCount() == 0)
					|| (rightRow.getNullCount() == 0 && leftRow
							.getNullCount() == 1)) {
				weight = 1;
			} else {
				weight = 5;
			}
			break;
		case 2:
			if (rightRow.getNullCount() == 0 && leftRow.getNullCount() == 0) {
				weight = 0;
			} else if ((rightRow.getNullCount() == 1 && leftRow.getNullCount() == 0)
					|| (rightRow.getNullCount() == 0 && leftRow
							.getNullCount() == 1)) {
				weight = 21;
			} else {
				weight = 85;
			}
			break;
		case 3:
			if (rightRow.getNullCount() == 0 && leftRow.getNullCount() == 0) {
				weight = 0;
			} else if ((rightRow.getNullCount() == 1 && leftRow.getNullCount() == 0)
					|| (rightRow.getNullCount() == 0 && leftRow
							.getNullCount() == 1)) {
				weight = 341;
			} else {
				weight = 1365;
			}
			break;
		case 4:
			if (rightRow.getNullCount() == 0 && leftRow.getNullCount() == 0) {
				weight = 0;
			} else if ((rightRow.getNullCount() == 1 && leftRow.getNullCount() == 0)
					|| (rightRow.getNullCount() == 0 && leftRow
							.getNullCount() == 1)) {
				weight = 5461;
			} else {
				weight = 21845;
			}
			break;
		default:
			weight = 87381;
		}
		return weight;
	}

	public NullAndCount rightRowWeight(int row, int col, String chesscolor) {
		NullAndCount nullAndCount = new NullAndCount();
		String[][] board = chessboard.getBoard();
		int count = 0;
		for (int i = col; i < board.length - 1; i++) {
			if (board[row][i + 1] == chesscolor) {
				count = count + 1;
			} else {
				if (board[row][i + 1] == "ʮ") {
					nullAndCount.setNullCount(1);
				}
				
				break;
			}
			
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	public NullAndCount leftRowWeight(int row, int col, String chesscolor) {
		NullAndCount nullAndCount = new NullAndCount();
		String[][] board = chessboard.getBoard();
		int count = 0;
		for (int i = col; i > 0; i--) {
			if (board[row][i - 1] == chesscolor) {
				count = count + 1;
			} else {
				if (board[row][i - 1] == "ʮ") {
				nullAndCount.setNullCount(1);
				}
				break;
			}
			
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	public long LeftDtoUWeight(int row, int col, String chesscolor) {
		long weight;
		NullAndCount leftline = LLeftDtoUWeight(row, col, chesscolor);
		NullAndCount rightline = RLeftDtoUWeight(row, col, chesscolor);
		switch (leftline.getChessCount() + rightline.getChessCount() + 1) {
		case 1:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 1;
			} else {
				weight = 5;
			}
			break;
		case 2:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 21;
			} else {
				weight = 85;
			}
			break;
		case 3:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 341;
			} else {
				weight = 1365;
			}
			break;
		case 4:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 5461;
			} else {
				weight = 21845;
			}
			break;
		default:
			weight = 87381;
			break;
		}
		return weight;
	}

	public NullAndCount LLeftDtoUWeight(int row, int col, String chesscolor) {
		NullAndCount nullAndCount = new NullAndCount();
		int count = 0;
		String[][] board = chessboard.getBoard();
		int i = row;
		int j = col;
		while (i < board.length - 1 && j > 0) {
			if (board[i + 1][j - 1] == chesscolor) {
				count++;
				i = i + 1;
				j = j - 1;
			} else {
				if (board[i + 1][j - 1] == "ʮ") {
				nullAndCount.setNullCount(1);
				}
				break;
			}
			
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	public NullAndCount RLeftDtoUWeight(int row, int col, String chesscolor) {
		NullAndCount nullAndCount = new NullAndCount();
		int count = 0;
		String[][] board = chessboard.getBoard();
		int i = row;
		int j = col;
		while (i > 0 && j < board.length-1) {
			if (board[i - 1][j + 1] == chesscolor) {
				count++;
				i = i - 1;
				j = j + 1;
			} else {
				if (board[i - 1][j + 1] == "ʮ") {
				nullAndCount.setNullCount(1);
				}
				break;
			}
			
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	public long LeftUtoDWeight(int row, int col, String chesscolor) {
		long weight;
		NullAndCount leftline = new NullAndCount();
		NullAndCount rightline = new NullAndCount();
		// String[][] board=chessboard.getBoard();
		switch (leftline.getChessCount() + rightline.getChessCount() + 1) {
		case 1:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 1;
			} else {
				weight = 5;
			}
			break;
		case 2:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 21;
			} else {
				weight = 85;
			}
			break;
		case 3:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 341;
			} else {
				weight = 1365;
			}
			break;
		case 4:
			if (leftline.getNullCount() == 0 && rightline.getNullCount() == 0) {
				weight = 0;
			} else if ((leftline.getNullCount() == 0 && rightline
					.getNullCount() == 1)
					|| (leftline.getNullCount() == 1 && rightline
							.getNullCount() == 0)) {
				weight = 5461;
			} else {
				weight = 21845;
			}
			break;
		default:
			weight = 87381;
			break;
		}
		return weight;
	}

	public NullAndCount LLeftUtoDWeight(int row, int col, String chesscolor) {
		NullAndCount nullAndCount = new NullAndCount();
		String[][] board = chessboard.getBoard();
		int count = 0;
		int i = row;
		int j = col;
		while (i > 0 && j > 0) {
			if (board[i - 1][j - 1] == chesscolor) {
				count = count + 1;
				i--;
				j--;
			} else {
				if (board[i - 1][j - 1] == "ʮ") {
				nullAndCount.setNullCount(1);
				}
				break;
			}
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	public NullAndCount RLeftUtoDWeight(int row, int col, String chesscolor) {
		NullAndCount nullAndCount = new NullAndCount();
		int count = 0;
		String[][] board = chessboard.getBoard();
		int x = row;
		int y = col;
		while (x < board.length && y < board.length) {
			if (board[x + 1][y + 1] == chesscolor) {
				count = count + 1;
				x++;
				y++;
			} else{ 
				if (board[x + 1][y + 1] == "ʮ") {
				nullAndCount.setNullCount(1);
				}
				break;
			}
		}
		nullAndCount.setChessCount(count);
		return nullAndCount;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int startPosX, startPosY;// ����X��Y��ֱ���ϵ��������
		int endPosX, endPosY;// ����X��Y��ֱ���ϵ��յ�����
		int count = 0;// ��������������
		int temp;
		// ��X��������긳ֵ
		temp = posX - WIN_COUNT + 1;
		if (temp >= 0)
			startPosX = temp;
		else
			startPosX = 0;
		// ��X���յ����긳ֵ
		temp = posX + WIN_COUNT - 1;
		if (temp <= 21)// ��Ϊ���̵����鷶Χ��0��21��
			endPosX = temp;
		else
			endPosX = 21;
		// ��Y��������긳ֵ
		temp = posY - WIN_COUNT + 1;
		if (temp >= 0)
			startPosY = temp;
		else
			startPosY = 0;
		// ��Y���յ����긳ֵ
		temp = posY + WIN_COUNT - 1;
		if (temp <= 21)
			endPosY = temp;
		else
			endPosY = 21;
		// �жϴ������ҵ�ֱ�߷���
		String[][] board = chessboard.getBoard();
		for (int i = startPosY; i < endPosY; i++) {
			if (board[posX][i] == ico && board[posX][i + 1] == ico) {
				count++;
			} else if (count != 4)
				count = 0;
		}
		// �жϴ��ϵ��µ�ֱ�߷���
		if (count == 0) {
			for (int i = startPosX; i < endPosX; i++) {
				if (board[i][posY] == ico && board[i + 1][posY] == ico)
					count++;
				else if (count != 4)
					count = 0;
			}

		}
		// �ж����������·����ֱ�߷���
		if (count == 0) {
			int j = startPosY;
			for (int i = startPosX; i < endPosX; i++) {
				if (j < endPosY) {
					if (board[i][j] == ico && board[i + 1][j + 1] == ico)
						count++;
					else if (count != 4)
						count = 0;
				}
				j = j + 1;
			}

		}
		// �ж����������Ϸ����ֱ�߷���
		if (count == 0) {
			int j = startPosY;
			for (int i = endPosX; i > startPosX; i--) {
				if (j < endPosY) {
					if (board[i][j] == ico && board[i - 1][j + 1] == ico)
						count++;
					else if (count != 4)
						count = 0;
				}
				j = j + 1;
			}

		}
		if (count == 4)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
