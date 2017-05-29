<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%! 
	private int imageWidth = 100; //验证码宽度
	private int imageHeight = 30;//验证码高度
	private int codeNum = 4;//字母数量
	private int background = 20;//干扰线的数量
%>
<% 
	//设置响应的MIME格式和页面不缓存
	response.setContentType("image/jpeg");
	response.setHeader("pragma", "no-cache");
	response.setHeader("cache-control", "no-cache");
	
	//创建图像
	BufferedImage bufferedImage = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_RGB);
	//创建画笔
	Graphics2D g = bufferedImage.createGraphics();
	//画背景色
	g.setColor(Color.WHITE);
	g.fillRect(1, 1, imageWidth-2, imageHeight-2);
	//往背景中画干扰线
	Random random = new Random();
	
	for(int i = 0;i<background;i++){
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		g.setColor(new Color(red,green,blue));
		int x1 = random.nextInt(imageWidth);
		int y1 = random.nextInt(imageHeight);
		int x2 = random.nextInt(imageWidth)/2;
		int y2 = random.nextInt(imageHeight)/2;
		g.drawLine(x1, y1, x2, y2);//画线
	}
	//添加字母
	g.setFont(new Font("Courier New",Font.BOLD,imageHeight-2));
	StringBuffer buffer = new StringBuffer();
	for(int i = 0;i<codeNum;i++){
		int red = random.nextInt(100)+50;
		int green = random.nextInt(100)+50;
		int blue = random.nextInt(100)+50;
		g.setColor(new Color(red,green,blue));
		String code = null;
		int type = random.nextInt(2);
		if(type==0){
			code = (char)(random.nextInt(26)+65)+"";
		}else{
			code = (char)(random.nextInt(26)+97)+"";
		}
		buffer.append(code);
		g.drawString(code, (imageWidth/codeNum)*i, 25);
	}
	session.setAttribute("code", buffer.toString());
	ImageIO.write(bufferedImage, "jpeg",response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
	bufferedImage = null;
	random = null;
	
%>
