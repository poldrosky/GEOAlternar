package DAO;

import Entidad.Maps;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MapsFacade extends AbstractFacade<Maps> {

    @PersistenceContext(unitName = "GEOAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MapsFacade() {
        super(Maps.class);
    }

    public Object[] getByCoordenate(int latitude, int longitude, String map, int type) {
        String typemap = "";
        if (type == 1) {
            typemap = "maps_wind";
        }
        if (type == 2) {
            typemap = "maps_biomass";
        }
        if (type == 3) {
            typemap = "maps_solar";
        }
        try {
            Query q = getEntityManager().createNativeQuery("Select m.latitude_3857, m.longitude_3857,m.value_point from (grid_450 natural join  " + typemap + ") m where m.latitude_3857=? and m.longitude_3857=? and m.tag_time=?");
            q.setParameter(1, latitude);
            q.setParameter(2, longitude);
            q.setParameter(3, map);
            return (Object[]) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Object[] getHistoryMonths(int latitude, int longitude, int type) {
        String typemap = "";
        if (type == 1) {
            typemap = "maps_wind";
        }
        if (type == 2) {
            typemap = "maps_biomass";
        }
        if (type == 3) {
            typemap = "maps_solar";
        }
        try {

            Query qmonths = getEntityManager().createNativeQuery("SELECT m.* FROM( "
                    + " (SELECT grid450_id,value_point AS january FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='January') a1 "
                    + "NATURAL JOIN  "
                    + " (SELECT grid450_id,value_point AS february FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='February') a2 "
                    + "NATURAL JOIN  "
                    + " (SELECT grid450_id,value_point AS march FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='March') a3 "
                    + "NATURAL JOIN  "
                    + " (SELECT grid450_id,value_point AS april FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='April') a4 "
                    + "NATURAL JOIN  "
                    + " (SELECT grid450_id,value_point AS May FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='May') a5 "
                    + "NATURAL JOIN  "
                    + " (SELECT grid450_id,value_point AS June FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='June') a6 "
                    + "NATURAL JOIN   "
                    + " (SELECT grid450_id,value_point AS July FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='July') a7 "
                    + "NATURAL JOIN  "
                    + "(SELECT grid450_id,value_point AS August FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='August') a8 "
                    + "NATURAL JOIN  "
                    + " (SELECT grid450_id,value_point AS September FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='September') a9 "
                    + "NATURAL JOIN  "
                    + " (SELECT grid450_id,value_point AS october FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='October') a10 "
                    + "NATURAL JOIN   "
                    + " (SELECT grid450_id,value_point AS november FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='November') a11  "
                    + "NATURAL JOIN "
                    + "  (SELECT grid450_id,value_point AS december FROM grid_450 natural join  " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='December') a12 "
                    + ") as m"
            );

            qmonths.setParameter(1, latitude);
            qmonths.setParameter(2, longitude);
            qmonths.setParameter(3, latitude);
            qmonths.setParameter(4, longitude);
            qmonths.setParameter(5, latitude);
            qmonths.setParameter(6, longitude);
            qmonths.setParameter(7, latitude);
            qmonths.setParameter(8, longitude);
            qmonths.setParameter(9, latitude);
            qmonths.setParameter(10, longitude);
            qmonths.setParameter(11, latitude);
            qmonths.setParameter(12, longitude);
            qmonths.setParameter(13, latitude);
            qmonths.setParameter(14, longitude);
            qmonths.setParameter(15, latitude);
            qmonths.setParameter(16, longitude);
            qmonths.setParameter(17, latitude);
            qmonths.setParameter(18, longitude);
            qmonths.setParameter(19, latitude);
            qmonths.setParameter(20, longitude);
            qmonths.setParameter(21, latitude);
            qmonths.setParameter(22, longitude);
            qmonths.setParameter(23, latitude);
            qmonths.setParameter(24, longitude);
            return (Object[]) qmonths.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    public Object[] getHistoryYears(int latitude, int longitude, int type) {
        String typemap = "";
        if (type == 1) {
            typemap = "maps_wind";
        }
        if (type == 2) {
            typemap = "maps_biomass";
        }
        if (type == 3) {
            typemap = "maps_solar";
        }
        try {
            Query qyears = getEntityManager().createNativeQuery("SELECT m.* FROM("
                    + " (SELECT grid450_id,value_point AS a2000 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2000') a1 "
                    + "NATURAL  JOIN "
                    + " (SELECT 	grid450_id,value_point AS a2001 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2001') a2 "
                    + "NATURAL  JOIN "
                    + " (SELECT 	grid450_id,value_point AS a2002 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2002') a3 "
                    + "NATURAL  JOIN "
                    + " (SELECT 	grid450_id,value_point AS a2003 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2003') a4 "
                    + "NATURAL  JOIN "
                    + " (SELECT 	grid450_id,value_point AS a2004 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2004') a5  "
                    + "NATURAL  JOIN "
                    + " (SELECT 	grid450_id,value_point AS a2005 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2005') a6 "
                    + "NATURAL  JOIN  "
                    + " (SELECT 	grid450_id,value_point AS a2006 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2006') a7 "
                    + "NATURAL  JOIN "
                    + "(SELECT  	grid450_id,value_point AS a2007 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2007') a8 "
                    + "NATURAL  JOIN "
                    + " (SELECT 	grid450_id,value_point AS a2008 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2008') a9 "
                    + "NATURAL  JOIN "
                    + " (SELECT 	grid450_id,value_point AS a2009 FROM  	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2009') a10 "
                    + "NATURAL  JOIN  "
                    + " (SELECT 	grid450_id,value_point AS a2010 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2010') a11  "
                    + "NATURAL  JOIN  "
                    + "  (SELECT 	grid450_id,value_point AS a2011 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='December') a12 "
                    + "  NATURAL  JOIN  "
                    + " (SELECT 	grid450_id,value_point AS a2012 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2012') a13  "
                    + " NATURAL  JOIN  "
                    + " (SELECT 	grid450_id,value_point AS a2013 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2013') a14  "
                    + " NATURAL  JOIN  "
                    + " (SELECT 	grid450_id,value_point AS a2014 FROM 	grid_450 natural join " + typemap + " where latitude_3857=? and longitude_3857=? and tag_time='2014') a15  "
                    + ") as m"
            );

            qyears.setParameter(1, latitude);
            qyears.setParameter(2, longitude);
            qyears.setParameter(3, latitude);
            qyears.setParameter(4, longitude);
            qyears.setParameter(5, latitude);
            qyears.setParameter(6, longitude);
            qyears.setParameter(7, latitude);
            qyears.setParameter(8, longitude);
            qyears.setParameter(9, latitude);
            qyears.setParameter(10, longitude);
            qyears.setParameter(11, latitude);
            qyears.setParameter(12, longitude);
            qyears.setParameter(13, latitude);
            qyears.setParameter(14, longitude);
            qyears.setParameter(15, latitude);
            qyears.setParameter(16, longitude);
            qyears.setParameter(17, latitude);
            qyears.setParameter(18, longitude);
            qyears.setParameter(19, latitude);
            qyears.setParameter(20, longitude);
            qyears.setParameter(21, latitude);
            qyears.setParameter(22, longitude);
            qyears.setParameter(23, latitude);
            qyears.setParameter(24, longitude);
            qyears.setParameter(25, latitude);
            qyears.setParameter(26, longitude);
            qyears.setParameter(27, latitude);
            qyears.setParameter(28, longitude);
            qyears.setParameter(29, latitude);
            qyears.setParameter(30, longitude);
            return (Object[]) qyears.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
