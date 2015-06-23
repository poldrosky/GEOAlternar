/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Maps;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edixred
 */
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
        Query q = getEntityManager().createNativeQuery("Select m.* from maps as m where latitude=? and longitude=? and tag_time=? and tag_type=?");
        q.setParameter(1, latitude);
        q.setParameter(2, longitude);
        q.setParameter(3, map);
        q.setParameter(4, type);
        return (Object[]) q.getSingleResult();
    }

    public Object[] getHistory(int latitude, int longitude, String map, int type) {
            //Query q=getEntityManager().createNativeQuery("Select m.* from maps as m where latitude=? and longitude=? and tag_time=? and tag_type=?");
///////////////////7
        Query qmonths = getEntityManager().createNativeQuery("SELECT "
                + "m.* "
                //+ ",march,april,may,june,july,august,september,october,november,december "
                + "FROM ("
                + "(SELECT latitude, longitude, VALUE AS january FROM maps WHERE latitude=? and longitude=? and tag_time='January' and tag_type=?) AS a1 "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS february FROM maps WHERE latitude=? and longitude=? and tag_time='February' and tag_type=?) AS a2 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS march FROM maps WHERE latitude=? and longitude=? and tag_time='March' and tag_type=?) AS a3 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS april FROM maps WHERE latitude=? and longitude=? and tag_time='April' and tag_type=?) AS a4 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS may FROM maps WHERE latitude=? and longitude=? and tag_time='May' and tag_type=?) AS a5 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS june FROM maps WHERE latitude=? and longitude=? and tag_time='June' and tag_type=?) AS a6 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS july FROM maps WHERE latitude=? and longitude=? and tag_time='July' and tag_type=?) AS a7 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS august FROM maps WHERE latitude=? and longitude=? and tag_time='August' and tag_type=?) AS a8 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS september FROM maps WHERE latitude=? and longitude=? and tag_time='September' and tag_type=?) AS a9 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS october FROM maps WHERE latitude=? and longitude=? and tag_time='October' and tag_type=?) AS a10 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS november FROM maps WHERE latitude=? and longitude=? and tag_time='November' and tag_type=?) AS a11 "
                + "USING(latitude, longitude) "
                + "JOIN"
                + "(SELECT latitude, longitude, VALUE AS december FROM maps WHERE latitude=? and longitude=? and tag_time='December' and tag_type=?) AS a12 "
                + "USING(latitude, longitude) "
                + ") as m"
        );
///////////////////
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
    }
}
