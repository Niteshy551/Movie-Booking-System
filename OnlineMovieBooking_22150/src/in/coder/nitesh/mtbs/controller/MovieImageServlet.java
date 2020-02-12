package in.coder.nitesh.mtbs.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.coder.nitesh.mtbs.daoimpl.MovieDaoImpl;
import in.coder.nitesh.mtbs.pojo.Movie;

@WebServlet("/MovieImage")
public class MovieImageServlet extends HttpServlet 
{
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("image/*");
		PrintWriter out=response.getWriter();
		
		int movieId=Integer.parseInt(request.getParameter("movieId"));
		
		Movie movie=new MovieDaoImpl().searchMovieById(movieId);
		
		System.out.println(movie);
		
		if(movie!=null)
		{
			InputStream in=movie.getMovieImage();
			int i=0;
			while((i=in.read())!=-1)
			{
				out.write(i);
			}
			in.close();
			out.close();
		}
	}	
}
