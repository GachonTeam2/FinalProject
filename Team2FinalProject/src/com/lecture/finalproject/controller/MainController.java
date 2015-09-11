package com.lecture.finalproject.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet(urlPatterns = "/main" )

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	private static Map commandHandlerMap = new HashMap();
	
	
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
        String configFile = config.getInitParameter("configFIle");
        Properties prop = new Properties();
        FileInputStream fis = null;
        
        try{
            String configFilePath = config.getServletContext().getRealPath(configFile);
            fis = new FileInputStream(configFilePath);
            prop.load(fis);
        }catch(IOException e){
            throw new ServletException(e);
        }finally{
            if(fis == null)
            {
                try{
                    fis.close();
                }catch(IOException ex){
                }
            }
        }
        Iterator keyIter = prop.keySet().iterator();
        while(keyIter.hasNext()){
            String command = (String) keyIter.next();
            String handlerClassName = prop.getProperty(command);
            
            try{
                Class handlerClass = Class.forName(handlerClassName);
                Object handlerInstance = handlerClass.newInstance();
                commandHandlerMap.put(command, handlerInstance);
            }catch(ClassNotFoundException e){
                throw new ServletException(e);
            }catch (InstantiationException e) {
                throw new ServletException(e);
            }catch (IllegalAccessException e) {
                throw new ServletException(e);
            }   
        }   
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    processRequest(request,response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/mainPage.jsp");
	    dispatcher.forward(request, response);
	}

}
