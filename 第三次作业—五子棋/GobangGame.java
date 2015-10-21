package 五子棋;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}
	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		int max_black,max_white = 0,max_temp,max=0;
		int row=0;
		int col=0;
		String[][] board=chessboard.getBoard();
		//对整个棋盘扫描
		for(int i=0;i<Chessboard.BOARD_SIZE;i++){
			for(int j=0;j<Chessboard.BOARD_SIZE;j++){
				//判断想要下棋子的地方有没有棋子，之前忘记加这个函数，电脑会经常重复走同一个位置，棋盘上白子的数目会不增加
				if(board[i][j]!=Chessman.BLACK.getChessman()&&board[i][j]!=Chessman.WHITE.getChessman())
				//if(!Exist(i,j))
				//String[][] board=chessboard.getBoard();
				//调用checkMax函数，查找以当前坐标为中心，白子和黑子连在一起的最大数目
				max_white=checkMax(i,j,Chessman.BLACK.getChessman());
				max_black=checkMax(i,j,Chessman.WHITE.getChessman());
				//比较黑子和白字连在一起的最大数目，如果是黑子的数目多，电脑下棋是防守，如果白字的数目多，电脑下棋就是进攻
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
		//判断横向
		//从当前位置开始向右边判断
		for(int i=1;i<5;i++){
			x2+=1;
			if(x2>Chessboard.BOARD_SIZE - 1)
				break;
			if(board[x2][y2]==chess)
				num++;
			else 
				break;
		}
		//恢复当前位置，向左边判断
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
		//重新更改当前坐标，判断纵向
		//向上判断，将num置为0，重新开始记录
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
		//重新更改当前坐标，向下判断
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
		//从横向和纵向中选取一个较大的数记录
		if(num>max_temp&&num<5)
			max_temp=num;
		//判断斜向，从当前位置向左上判断
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
		//从当前位置向右下判断 
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
		//记录下较大的num值
		if(num>max_temp&&num<5)
			max_temp=num;
		//从当前位置向左下判断
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
		 //从当前位置向右上判断
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
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */

	 public boolean isWon(int posX,int posY,String ico) {
		 //分别计算x,y的最大开始和结束位置
	 int startX,startY,endX,endY;                             
     int num=0;
   //最开始的X坐标即当前下子减4，这是位置左边最远的可能性，如果这个值小于0，则证明当前下子位置与横轴相差少于4，取0
   startX=(posX-WIN_COUNT+1)<0?0:posX-WIN_COUNT+1;
   //Y轴同理
   startY=(posY-WIN_COUNT+1)<0?0:posY-WIN_COUNT+1;
  //最开始的X坐标即当前下子加4，这是位置右边最远的可能性，如果这个值大于棋盘边界，则证明当前下子位置与横轴相差少于4，取最大边界值
   endX=(posX+WIN_COUNT-1>Chessboard.BOARD_SIZE-1)?Chessboard.BOARD_SIZE-1:posX+WIN_COUNT-1;
   //Y轴同理
   endY=(posY+WIN_COUNT-1>Chessboard.BOARD_SIZE-1)?Chessboard.BOARD_SIZE-1:posY+WIN_COUNT-1;
   String[][] board = chessboard.getBoard();
   //计算纵向，看在startY至endY中是否存在连续的4个相同颜色的棋子
   for(int i=startY;i<endY;i++){
       if(board[posX][i]==ico){
           num++;
       }else if(num<WIN_COUNT-1){
    	   num=0;
       }
   }
   //计算横向
   for(int i=startX;i<endX;i++){
       if(board[i][posY]==ico){
    	   num++;
       }else if(num<WIN_COUNT-1){
    	   num=0;
       }
   }
   //计算从左上角到右下角
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
   //计算从右上角到左下角
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

