package in.coder.nitesh.mtbs.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.coder.nitesh.mtbs.dao.MovieDao;
import in.coder.nitesh.mtbs.daoimpl.MovieDaoImpl;
import in.coder.nitesh.mtbs.daoimpl.ShowDaoImpl;
import in.coder.nitesh.mtbs.pojo.Movie;
import in.coder.nitesh.mtbs.pojo.Show;

@MultipartConfig
@WebServlet("/movie")
public class MovieServlet extends HttpServlet 
{
	String movieName,movieCast,movieType,movieLanguage,
	movieProducer,movieDirector,releaseDate,movieDescription,movieReview,movieDuration;
	InputStream movieImage;
	String action;
	int movieId;
	boolean flag;
	List<Movie> movielist=null;
	HttpSession httpsession;
	
	Movie movie=null;
	MovieDao moviedao=new MovieDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		action=request.getParameter("action");
		System.out.println(action);
		if(action!=null && action.equalsIgnoreCase("addMovie"))
		{
		
		movieName = request.getParameter("movieName");
		movieType = request.getParameter("movieType");
		movieLanguage = request.getParameter("movieLanguage");
		movieCast = request.getParameter("movieCast");
		movieProducer = request.getParameter("movieProducer");
		movieDirector = request.getParameter("movieDirector");
		movieDuration = request.getParameter("movieDuration");
		releaseDate = request.getParameter("releaseDate");
		movieDescription = request.getParameter("movieDescription");
		movieReview = request.getParameter("movieReview");
		
		Part part=request.getPart("movieImage");
		
		movieImage= part.getInputStream();
		
		movie=new Movie(movieName, movieType, movieLanguage, movieCast, movieProducer, movieDirector, movieDuration, releaseDate, movieDescription, movieReview,movieImage);
		flag=moviedao.addMovie(movie);	
		if(flag)
		{
			request.setAttribute("msg", "Movie Added");
		}
		else
		{
			request.setAttribute("emsg", "Movie not Added");
		}
		RequestDispatcher rd=request.getRequestDispatcher("addMovie.jsp");
		rd.forward(request, response);
		}
		if(action!=null && action.equalsIgnoreCase("updatemovie"))
		{
			movieName = request.getParameter("movieName");
			movieType = request.getParameter("movieType");
			movieLanguage = request.getParameter("movieLanguage");
			movieCast = request.getParameter("movieCast");
			movieProducer = request.getParameter("movieProducer");
			movieDirector = request.getParameter("movieDirector");
			movieDuration = request.getParameter("movieDuration");
			releaseDate = request.getParameter("releaseDate");
			movieDescription = request.getParameter("movieDescription");
			movieReview = request.getParameter("movieReview");
			
			Part part=request.getPart("movieImage");
			
			movieImage= part.getInputStream();
			
			movieId=Integer.parseInt(request.getParameter("movieId"));
			
			movie=new Movie(movieId, movieName, movieType, movieLanguage, movieCast, movieProducer,
					movieDirector, movieDuration, releaseDate, movieDescription, movieReview, movieImage);
			
			flag=moviedao.updateMovie(movie);
			if(flag)
			{
				request.setAttribute("msg", "Movie updated");
				httpsession=request.getSession();
				movielist=moviedao.showAllMovie();
				httpsession.setAttribute("movielist",movielist);
				request.getRequestDispatcher("movielist.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("msg", "Movie not updated");
				movie=moviedao.searchMovieById(movieId);
				request.setAttribute("movie", movie);
				request.getRequestDispatcher("updatemovie.jsp").forward(request,response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		httpsession=request.getSession();
		
		action =request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("delete"))
		{
			movieId=Integer.parseInt(request.getParameter("movieId"));
			flag=moviedao.deleteMovie(movieId);
			
			if(flag)
			{
				movielist=moviedao.showAllMovie();
				httpsession.setAttribute("movielist", movielist);
				request.setAttribute("msg", "Movie Deleted");
			}
			else
				{
					request.setAttribute("emsg", "Movie not Deleted");	
				}
			RequestDispatcher rd=request.getRequestDispatcher("movielist.jsp");
			rd.forward(request, response);
			}
		else if(action!=null && action.equalsIgnoreCase("edit"))
		{
			movieId=Integer.parseInt(request.getParameter("movieId"));
			movie=moviedao.searchMovieById(movieId);
			if(movie!=null)
			{
				request.setAttribute("movie", movie);
				RequestDispatcher rd=request.getRequestDispatcher("updatemovie.jsp");
				rd.forward(request,response);
			}
		}
		
		else if(action!=null && action.equalsIgnoreCase("details"))
		{
			movieId = Integer.parseInt(request.getParameter("movieId"));
			
			movie = moviedao.searchMovieById(movieId);
			
			if(movie!=null)
			{
				request.setAttribute("movie", movie);
				RequestDispatcher rd = request.getRequestDispatcher("moviedetails.jsp");
				rd.forward(request, response);
			}	
		}
		else if(action!=null && action.equalsIgnoreCase("shows"))
		{
			movieId = Integer.parseInt(request.getParameter("movieId"));
			
			List<Show> showlist = new ShowDaoImpl().showByMovie(movieId);
			request.setAttribute("showlist",showlist);
			RequestDispatcher rd=request.getRequestDispatcher("showlist.jsp");
			rd.forward(request,response);
			
		}
		else
		{
			movielist=moviedao.showAllMovie();
			httpsession.setAttribute("movielist", movielist);
			response.sendRedirect("movielist.jsp");
		}
	}
}
