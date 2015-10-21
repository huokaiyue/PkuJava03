package ������;

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
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
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
		int max_black,max_white = 0,max_temp,max=0;
		int row=0;
		int col=0;
		String[][] board=chessboard.getBoard();
		//����������ɨ��
		for(int i=0;i<Chessboard.BOARD_SIZE;i++){
			for(int j=0;j<Chessboard.BOARD_SIZE;j++){
				//�ж���Ҫ�����ӵĵط���û�����ӣ�֮ǰ���Ǽ�������������Իᾭ���ظ���ͬһ��λ�ã������ϰ��ӵ���Ŀ�᲻����
				if(board[i][j]!=Chessman.BLACK.getChessman()&&board[i][j]!=Chessman.WHITE.getChessman())
				//if(!Exist(i,j))
				//String[][] board=chessboard.getBoard();
				//����checkMax�����������Ե�ǰ����Ϊ���ģ����Ӻͺ�������һ��������Ŀ
				max_white=checkMax(i,j,Chessman.BLACK.getChessman());
				max_black=checkMax(i,j,Chessman.WHITE.getChessman());
				//�ȽϺ��ӺͰ�������һ��������Ŀ������Ǻ��ӵ���Ŀ�࣬���������Ƿ��أ�������ֵ���Ŀ�࣬����������ǽ���
				max_temp=Math.max(max_white, max_black);
				if(max_temp>max){
					max=max_temp;
					row=i;
					col=j;
				}
			}
		}
		//chessboard.setBoard(posX, posY,Chessman.WHITE.getChessman());
		int[] result={row,col};
		return result;
	}
	//public boolean Exist(int i,int j)
	//{    String[][] board=chessboard.getBoard();
	//	if(board[i][j]==Chessman.BLACK.getChessman()||board[i][j]==Chessman.WHITE.getChessman())
	//		return true;
	//	return false;
	//}
	public int checkMax(int x,int y,String chess){
		String[][] board = chessboard.getBoard();
		int num=0,max_num,max_temp=0;
		int x1=x,y1=y;
		int x2=x1,y2=y1;
		//�жϺ���
		//�ӵ�ǰλ�ÿ�ʼ���ұ��ж�
		for(int i=1;i<5;i++){
			x2+=1;
			if(x2>Chessboard.BOARD_SIZE - 1)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;
		}
		//�ָ���ǰλ�ã�������ж�
		 x2=x1;y2=y1;
		for(int i=1;i<5;i++){
			x2-=1;
			if(x2<0)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;
		}
		if(num<5)
			max_temp=num;
		//���¸��ĵ�ǰ���꣬�ж�����
		//�����жϣ���num��Ϊ0�����¿�ʼ��¼
		x2=x1;y2=y1;
		num=0;
		for(int i=1;i<5;i++){
			y2-=1;
			if(y2<0)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;}
		//���¸��ĵ�ǰ���꣬�����ж�
		 x2=x1;y2=y1;
		for(int i=1;i<5;i++){
			y2+=1;
			if(y2>Chessboard.BOARD_SIZE-1)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;
		}
		//�Ӻ����������ѡȡһ���ϴ������¼
		if(num>max_temp&&num<5)
			max_temp=num;
		//�ж�б�򣬴ӵ�ǰλ���������ж�
		 x2=x1;y2=y1;
		 num=0;
		for(int i=1;i<5;i++){
			x2-=1;
			y2-=1;
			if(x2<0||y2<0)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;}
		//�ӵ�ǰλ���������ж� 
		 x2=x1;y2=y1;
		 for(int i=1;i<5;i++){
			x2+=1;
			y2+=1;
			if(y2>Chessboard.BOARD_SIZE-1||x2>Chessboard.BOARD_SIZE-1)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;}
		//��¼�½ϴ��numֵ
		if(num>max_temp&&num<5)
			max_temp=num;
		//�ӵ�ǰλ���������ж�
		 x2=x1;y2=y1;
		 for(int i=1;i<5;i++){
				x2-=1;
				y2+=1;
				if(y2>Chessboard.BOARD_SIZE-1||x2<0)
					break;
				if(board[x2][y2]==chess)
					num++;
				else 
					break;}
		 //�ӵ�ǰλ���������ж�
		 x2=x1;y2=y1;
		 for(int i=1;i<5;i++){
			x2+=1;
			y2-=1;
			if(x2>Chessboard.BOARD_SIZE-1||y2<0)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;}
			if(num>max_temp&&num<5)
				max_temp=num;
			max_num=max_temp;
			return max_num;
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

	 public boolean isWon(int posX,int posY,String ico) {
		 //�ֱ����x,y�����ʼ�ͽ���λ��
	 int startX,startY,endX,endY;                             
     int num=0;
   //�ʼ��X���꼴��ǰ���Ӽ�4������λ�������Զ�Ŀ����ԣ�������ֵС��0����֤����ǰ����λ��������������4��ȡ0
   startX=(posX-WIN_COUNT+1)<0?0:posX-WIN_COUNT+1;
   //Y��ͬ��
   startY=(posY-WIN_COUNT+1)<0?0:posY-WIN_COUNT+1;
  //�ʼ��X���꼴��ǰ���Ӽ�4������λ���ұ���Զ�Ŀ����ԣ�������ֵ�������̱߽磬��֤����ǰ����λ��������������4��ȡ���߽�ֵ
   endX=(posX+WIN_COUNT-1>Chessboard.BOARD_SIZE-1)?Chessboard.BOARD_SIZE-1:posX+WIN_COUNT-1;
   //Y��ͬ��
   endY=(posY+WIN_COUNT-1>Chessboard.BOARD_SIZE-1)?Chessboard.BOARD_SIZE-1:posY+WIN_COUNT-1;
   String[][] board = chessboard.getBoard();
   //�������򣬿���startY��endY���Ƿ����������4����ͬ��ɫ������
   for(int i=startY;i<endY;i++){
       if(board[posX][i]==ico){
           num++;
       }else if(num<WIN_COUNT-1){
    	   num=0;
       }
   }
   //�������
   for(int i=startX;i<endX;i++){
       if(board[i][posY]==ico){
    	   num++;
       }else if(num<WIN_COUNT-1){
    	   num=0;
       }
   }
   //��������Ͻǵ����½�
   for(int i=startX;i<endX;i++){
	  int y1;
	  y1=startY;
	  y1-=1;
	  if(y1<endY)
		  break;
	  else if(board[i][y1]==ico){
		  num++;
      }else if(num<WIN_COUNT-1){
    	  num=0;
      }
   }
   //��������Ͻǵ����½�
	  for( int i=startX;i<endX;i--){
		int y1;
		  y1=startY;
		  y1-=1;
		  if(y1<endY)
			  break;
		  else if(board[i][y1]==ico){
			  num++;
	      }else if(num<WIN_COUNT-1){
	    	  num=0;
	      }
   }
	//  int j = startY;
   //   for(int i = startX; i < endX; i++){
     //     if(board[i][j] == ico && board[i+1][j+1] == ico){
      //        num++;
     //     }else if(sameCount < WIN_COUNT - 1){
       //       sameCount = 0;
       //   }
       //   if (j < endY){
        //      j++;
        //  }
    //  }
    //  if (minX < 0){
    //      if(posX > (Chessboard.BOARD_SIZE - 1 - posY)){
     //         startX = minX + (maxY - (Chessboard.BOARD_SIZE - 1));
     //     }
     //     else{
     //         startX = 0;
     //     }
    //  }
   
   if (num>=WIN_COUNT-1){
       return true;
   }else{
       return false;
   }
}

   

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}

