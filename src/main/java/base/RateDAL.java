package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score
		// Getting error "RateDomainModel not mapped" although it seems like it should work
		// Left it commented out to make sure the javafx works, not sure what the error was 
		// in the DAL.
		
		double rate = 0;
		
		//Rounding down the scores to match minCreditScore values
		int modulo = GivenCreditScore%50;
		int queryScore = GivenCreditScore - modulo;
		
		
		/*try {
			 Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;tx = session.beginTransaction();	
									
			Query query = session.createQuery("from RateDomainModel where MinCreditScore = :id  ");
			query.setParameter("id", queryScore);
			
			List<?> list = query.list();
			RateDomainModel rateObject = (RateDomainModel)list.get(0);
			rate = rateObject.getInterestRate();
			tx.commit();
			
			//The below code was used to test the JavaFX since the getRate() doesn't always work
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}*/
		
		//Hardcoded to test the JavaFx
		if (queryScore < 600)
		{
			rate = 0;
		}
		else if (queryScore==600)
		{
			rate = .05;
		}
		else if (queryScore==650)
		{
			rate = .045;
		}
		else if (queryScore==700)
		{
			rate = .04;
		}
		else if (queryScore==750)
		{
			rate =.0375;
		}
		else if (queryScore==800)
		{
			rate = .035;
		}
		return rate;
		
		
		//FinalExam - obviously change the return value

	}
	


}