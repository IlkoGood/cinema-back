package cinema.dao.impl;

import cinema.dao.AbstractDao;
import cinema.dao.MovieSessionDao;
import cinema.exception.DataProcessingException;
import cinema.model.MovieSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl extends AbstractDao<MovieSession> implements MovieSessionDao {
    public MovieSessionDaoImpl(SessionFactory factory) {
        super(factory, MovieSession.class);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = factory.openSession()) {
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime startOfNextDay = date.plusDays(1).atStartOfDay();
            Query<MovieSession> getAvailableSessions = session.createQuery(
                    "FROM MovieSession m WHERE m.movie.id = :id "
                            + "AND m.showTime >= :startOfDay "
                            + "AND m.showTime < :startOfNextDay", MovieSession.class);
            getAvailableSessions.setParameter("id", movieId);
            getAvailableSessions.setParameter("startOfDay", startOfDay);
            getAvailableSessions.setParameter("startOfNextDay", startOfNextDay);
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for movie with id "
                    + movieId + " and show date " + date + " not found", e);
        }
    }
}
