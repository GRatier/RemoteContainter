package pers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domains.Client;
import domains.Journey;
import mainClasses.ClientRepository;
import mainClasses.JourneyRepository;

public class SQLRepository implements ClientRepository , JourneyRepository {

		EntityManagerFactory emf;
		EntityManager em;
		boolean isProduction = false;

		public SQLRepository() {
			this(false);
		}

		public SQLRepository(boolean isProduction) {
			this.isProduction = isProduction;
			Map<String, String> properties = new HashMap<String, String>();
			if (isProduction) {
				properties.put("javax.persistence.jdbc.url", "jdbc:sqlite:dbs/production.db");
			} else {
				properties.put("javax.persistence.jdbc.url", "jdbc:sqlite:dbs/test.db");
			}

			emf = Persistence.createEntityManagerFactory("RemoteContainerApp", properties);
			em = emf.createEntityManager();
		}

		@Override
		public void addClient(Client client) {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
		}
		

		@Override
		public Client getClient(String email) {
			return em.createQuery("SELECT c FROM Client c WHERE c.email=:email", Client.class)
			  .setParameter("email", email)
			  .getResultStream().findFirst().orElse(null);
		}
		
		@Override
		public Journey getJourney(String cargo) {
			return em.createQuery("SELECT j FROM Journey j WHERE j.cargo=:cargo", Journey.class)
					  .setParameter("cargo", cargo)
					  .getResultStream().findFirst().orElse(null);
		}
		
		@Override
		public Stream<Client> getAllClientsStream() {
			return em.createQuery("SELECT c FROM Client c", Client.class).getResultStream();
		}

		@Override
		public void addJourney(Journey journey) {
			em.getTransaction().begin();
			em.persist(journey);
			em.getTransaction().commit();
			
		}

		@Override
		public Stream<Journey> getAllJourneysStream() {
			return em.createQuery("SELECT j FROM Journey j", Journey.class).getResultStream();
		}

		@Override
		public void updateJourney(Journey journey) {
			em.getTransaction().begin();
			em.merge(journey);
			em.getTransaction().commit();
		}
		
		@Override
		public void updateClient(Client client) {
			em.getTransaction().begin();
			em.merge(client);
			em.getTransaction().commit();
		}

		@Override
		public void removeJourney(Journey journey) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void removeClient(Client client) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean contains(Client client) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Journey journey) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clearJourneyDatabase() {
			if (isProduction) {
				throw new Error("clearDatabase should not be called with a production database");
			}
			em.getTransaction().begin();
			em.createNativeQuery("DELETE FROM Journey").executeUpdate();
			em.createQuery("DELETE FROM Journey").executeUpdate();
			em.getTransaction().commit();
		}
		
		@Override
		public void clearClientDatabase() {
			if (isProduction) {
				throw new Error("clearDatabase should not be called with a production database");
			}
			em.getTransaction().begin();
			em.createNativeQuery("DELETE FROM Client").executeUpdate();
			em.createQuery("DELETE FROM Client").executeUpdate();
			em.getTransaction().commit();
		}
		
}
