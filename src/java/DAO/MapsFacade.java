
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

     public Object[] getByCoordenate(int latitude, int longitude, String map) {
        try{
        Query q = getEntityManager().createNativeQuery("Select m.latitude_3857, m.longitude_3857,m.value_point from (grid_450 natural join maps_biomass) m where m.latitude_3857=? and m.longitude_3857=? and m.tag_time=?");
        q.setParameter(1, latitude);
        q.setParameter(2, longitude);
        q.setParameter(3, map);
        return (Object[]) q.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    public Object[] getHistoryMonths(int latitude, int longitude, int type) {
        try{
            Query qmonths = getEntityManager().createNativeQuery("SELECT m.* FROM" +
"(SELECT " +
"	grid450_id,value_point AS january " +
"FROM " +
"	(grid_450 natural join maps_biomass) where latitude_3857=? and longitude_3857=? and tag_time='January') a1 " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS february " +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='February') a2 " +
"using " +
"	(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS march " +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='March') a3 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS april " +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='April') a4 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS May " +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='May') a5 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS June" +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='June') a6 " +
"using" +
"(grid450_id)" +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS July" +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='July') a7 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT  " +
"	grid450_id,value_point AS August" +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='August') a8 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS September " +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='September') a9 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS october " +
"FROM  " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='October') a10 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS november " +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='November') a11 " +
"using " +
"(grid450_id) " +
"JOIN " +
"(SELECT " +
"	grid450_id,value_point AS december " +
"FROM " +
"	(grid_450 natural join maps_biomass)where latitude_3857=? and longitude_3857=? and tag_time='December') a12 " +
"using " +
"(grid450_id) " +
") m"
);

            qmonths.setParameter(1, latitude);
            qmonths.setParameter(2, longitude);
            qmonths.setParameter(3, type);
            qmonths.setParameter(4, latitude);
            qmonths.setParameter(5, longitude);
            qmonths.setParameter(6, type);
            qmonths.setParameter(7, latitude);
            qmonths.setParameter(8, longitude);
            qmonths.setParameter(9, type);
            qmonths.setParameter(10, latitude);
            qmonths.setParameter(11, longitude);
            qmonths.setParameter(12, type);
            qmonths.setParameter(13, latitude);
            qmonths.setParameter(14, longitude);
            qmonths.setParameter(15, type);
            qmonths.setParameter(16, latitude);
            qmonths.setParameter(17, longitude);
            qmonths.setParameter(18, type);
            qmonths.setParameter(19, latitude);
            qmonths.setParameter(20, longitude);
            qmonths.setParameter(21, type);
            qmonths.setParameter(22, latitude);
            qmonths.setParameter(23, longitude);
            qmonths.setParameter(24, type);
            qmonths.setParameter(25, latitude);
            qmonths.setParameter(26, longitude);
            qmonths.setParameter(27, type);
            qmonths.setParameter(28, latitude);
            qmonths.setParameter(29, longitude);
            qmonths.setParameter(30, type);
            qmonths.setParameter(31, latitude);
            qmonths.setParameter(32, longitude);
            qmonths.setParameter(33, type);
            qmonths.setParameter(34, latitude);
            qmonths.setParameter(35, longitude);
            qmonths.setParameter(36, type);
            return (Object[]) qmonths.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    public Object[] getHistoryYears(int latitude, int longitude, int type) {
        try{
            Query qyears = getEntityManager().createNativeQuery("SELECT "
                    + "m.* "
                    + "FROM ("
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2000' and latitude=? and longitude=? and tag_type=?) AS a1 "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2001' and latitude=? and longitude=? and tag_type=?) AS a2 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2002' and latitude=? and longitude=? and tag_type=?) AS a3 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2003' and latitude=? and longitude=? and tag_type=?) AS a4 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2004' and latitude=? and longitude=? and tag_type=?) AS a5 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2005' and latitude=? and longitude=? and tag_type=?) AS a6 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2006' and latitude=? and longitude=? and tag_type=?) AS a7 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2007' and latitude=? and longitude=? and tag_type=?) AS a8 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2008' and latitude=? and longitude=? and tag_type=?) AS a9 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2009' and latitude=? and longitude=? and tag_type=?) AS a10 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2010' and latitude=? and longitude=? and tag_type=?) AS a11 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2011' and latitude=? and longitude=? and tag_type=?) AS a12 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2012' and latitude=? and longitude=? and tag_type=?) AS a13 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2013' and latitude=? and longitude=? and tag_type=?) AS a14 "
                    + "USING(latitude, longitude) "
                    + "JOIN "
                    + "(SELECT latitude, longitude, value FROM maps WHERE tag_time LIKE '2014' and latitude=? and longitude=? and tag_type=?) AS a15 "
                    + "USING(latitude, longitude) "
                    + ") as m"
            );
            
            qyears.setParameter(1, latitude);
            qyears.setParameter(2, longitude);
            qyears.setParameter(3, type);
            qyears.setParameter(4, latitude);
            qyears.setParameter(5, longitude);
            qyears.setParameter(6, type);
            qyears.setParameter(7, latitude);
            qyears.setParameter(8, longitude);
            qyears.setParameter(9, type);
            qyears.setParameter(10, latitude);
            qyears.setParameter(11, longitude);
            qyears.setParameter(12, type);
            qyears.setParameter(13, latitude);
            qyears.setParameter(14, longitude);
            qyears.setParameter(15, type);
            qyears.setParameter(16, latitude);
            qyears.setParameter(17, longitude);
            qyears.setParameter(18, type);
            qyears.setParameter(19, latitude);
            qyears.setParameter(20, longitude);
            qyears.setParameter(21, type);
            qyears.setParameter(22, latitude);
            qyears.setParameter(23, longitude);
            qyears.setParameter(24, type);
            qyears.setParameter(25, latitude);
            qyears.setParameter(26, longitude);
            qyears.setParameter(27, type);
            qyears.setParameter(28, latitude);
            qyears.setParameter(29, longitude);
            qyears.setParameter(30, type);
            qyears.setParameter(31, latitude);
            qyears.setParameter(32, longitude);
            qyears.setParameter(33, type);
            qyears.setParameter(34, latitude);
            qyears.setParameter(35, longitude);
            qyears.setParameter(36, type);
            qyears.setParameter(37, latitude);
            qyears.setParameter(38, longitude);
            qyears.setParameter(39, type);
            qyears.setParameter(40, latitude);
            qyears.setParameter(41, longitude);
            qyears.setParameter(42, type);
            qyears.setParameter(43, latitude);
            qyears.setParameter(44, longitude);
            qyears.setParameter(45, type);
            return (Object[]) qyears.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
}
