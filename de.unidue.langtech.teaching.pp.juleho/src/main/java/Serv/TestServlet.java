package Serv;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.uima.UIMAException;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.example.Run;
import de.unidue.langtech.teaching.pp.example.Starter;
import myPackage.MyRun;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
				 
		try {
			MyRun run = new MyRun();
			run.runrun();
		} catch (ResourceInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UIMAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathToUnigram = MyRun.getdateipfad();
		String pathToBigram = MyRun.getBigramPath();
		String pathToTrigram = MyRun.getTrigramPath();
		Map<String,Integer> bigramResults = MyRun.getBigramResults();
		Map<String,Integer> trigramResults = MyRun.getTrigramResults();
		Map<String,Float> sentimentresults = MyRun.getSentimentResults();
		request.setAttribute("unigram", pathToUnigram);
		request.setAttribute("sentiment", sentimentresults);
		request.setAttribute("bigrampath", pathToBigram);
		request.setAttribute("trigrampath", pathToTrigram);
		request.setAttribute("bigram", bigramResults);
		request.setAttribute("trigram", trigramResults);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
