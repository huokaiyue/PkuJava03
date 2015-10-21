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
	 * ��������Ƿ�Ϸ���
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
				// ��������ѡ��λ������
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
		//	System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
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
 	/*	int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		 	int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		 	String[][] board = chessboard.getBoard();
	 	while (board[posX][posY] != "ʮ") {
		 		posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		 		posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		 	}
		 	int[] result = { posX, posY };
		 	return result;*/
		int max_b,max_w,middle,max=0;
		int row=0;
		int col=0;
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				String s1=Chessman.BLACK.getChessman();
				String s2=Chessman.WHITE.getChessman();
			    String[][] board=chessboard.getBoard();
				if(board[i][j]=="ʮ"){
				max_b=checkMax(i,j,s1);       //���ü����Χ�������������checkMax();
				max_w=checkMax(i,j,s2);
				middle=Math.max(max_b,max_w);
				if(middle>max){
					max=middle;
					row=i;
					col=j;
				}
				} 
			}
		}
		// String[][] board=chessboard.getBoard();
		
		int[] result = {row, col};
		return result;
	}
	//	int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
	//	int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
	//	String[][] board = chessboard.getBoard();
	//	while (board[posX][posY] != "ʮ") {
	//		posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
	//		posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
	//	}
	//	int[] result = { posX, posY };
	//	return result;
	public int checkMax(int x,int y,String chess){
		
		
		int num=0;
		int middle=0;
		int x_num=x,y_num=y;
		String[][] board=chessboard.getBoard();
		//�жϵ����ҷ���ͬ����ɫ����
		for(int i=1;i<5;i++){
			x_num+=1;
			if(x_num>chessboard.BOARD_SIZE-1)
				break;
			if(board[x_num][y_num]==chess)
				num++;
			else
				break;
		}
		x_num=x;
		for(int i=1;i<5;i++){
			x_num-=1;
			if(x_num<0)
			   break;
			if(board[x_num][y_num]==chess)
				num++;
			 else
				break;
			
		}
		if(num<5)
			middle=num;
		//�����ж�
		x_num=x;
		y_num=y;
		num=0;
		for(int i=1;i<5;i++){
			y_num-=1;
			if(y_num<0)
				break;
			if(board[x_num][y_num]==chess)
				num++;
			else
				break;
			
		}
		y_num=y;
	//	x_num=x;
		for(int i=1;i<5;i++){
			y_num+=1;
			if(y_num>chessboard.BOARD_SIZE-1)
				break;
			if(board[x_num][y_num]==chess)
				num++;
			else
				break;
		}
		if(num<5&&num>middle)
			middle=num;
		//���Ϻ������ж�
		x_num=x;
		y_num=y;
		num=0;
		for(int i=1;i<5;i++){
			x_num-=1;
			y_num-=1;
			if(x_num<0||y_num<0)
				break;
			if(board[x_num][y_num]==chess)
				num++;
			else
				break;
			
		}
		x_num=x;
		y_num=y;
		for(int i=1;i<5;i++){
			x_num+=1;
			y_num+=1;
			if(x_num>chessboard.BOARD_SIZE-1||y_num>chessboard.BOARD_SIZE-1)
				break;
			if(board[x_num][y_num]==chess)
				num++;
			else
				break;
		}
		if(num<5&&num>middle)
			middle=num;
		//�����������ж�
		x_num=x;
		y_num=y;
		num=0;
		for(int i=1;i<5;i++){
			x_num+=1;
			y_num-=1;
			if(x_num>chessboard.BOARD_SIZE-1||y_num<0)
				break;
			if(board[x_num][y_num]==chess)
				num++;
			else
				break;
		}
		x_num=x;
		y_num=y;
		for(int i=1;i<5;i++){
			x_num-=1;
			y_num+=1;
			if(x_num<0||y_num>chessboard.BOARD_SIZE-1)
				break;
			if(board[x_num][y_num]==chess)
				num++;
			else
				break;
			
		}
		if(num<5&&num>middle)
			middle=num;
		
		return middle;
			
		
			
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
		int num=1;
		int x=posX,y=posY;
		String[][] board=chessboard.getBoard();
		//�����жϣ������ң�������
		for(int i=1;i<5;i++){   //�ұ��ж�
			x+=1;
			if(x>Chessboard.BOARD_SIZE-1)
				break;
			if(board[x][y]==ico)
				num++;
			else
				break;
		}
		x=posX;
		for(int i=1;i<5;i++){
			x-=1;
			if(x<0) 
				break;
			if(board[x][y]==ico)
				num++;
			else
				break;
		}
		if(num==5)
			return true;
		//�����жϣ����Ϻ���
		x=posX;
		y=posY;
		num=1;
		for(int i=1;i<5;i++){
			y-=1;
			if(y<0)
				break;
			if(board[x][y]==ico)
				num++;
			else
				break;
			
		}
		y=posY;
		for(int i=1;i<5;i++){
			y+=1;
			if(y>chessboard.BOARD_SIZE-1)
				break;
			if(board[x][y]==ico)
				num++;
			else
				break;
		}
		if(num==5)
		return true;
		//�ж���������
	   x=posX;
	   y=posY;
	   num=1;
	   for(int i=1;i<5;i++){
		   x-=1;
		   y-=1;
		   if(x<0||y<0) break;
		   if(board[x][y]==ico)
			   num++;
		   else
			   break;
	   }
	   x=posX;
	   y=posY;
	   for(int i=1;i<5;i++){
		   x+=1;
		   y+=1;
		   if(x>chessboard.BOARD_SIZE-1||y>chessboard.BOARD_SIZE-1)
			   break;
		   if(board[x][y]==ico)
			   num++;
		   else 
			   break;
			   
	   }
	   if(num==5)
		   return true;
	   //�����������ж�
	   x=posX;
	   y=posY;
	   num=1;
	   for(int i=1;i<5;i++){
		   x+=1;
		   y-=1;
		   if(x>chessboard.BOARD_SIZE-1||y<0)
			   break;
		   if(board[x][y]==ico)
			   num++;
		   else
			   break;
		   
	   }
	   x=posX;
	   y=posY;
	   for(int i=1;i<5;i++){
		x-=1;
		y+=1;
	   if(x<0||y>chessboard.BOARD_SIZE-1)
		   break;
	   if(board[x][y]==ico)
		   num++;
	   else
		   break;
	   }
	   if(num==5)
		   return true;
	   return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
