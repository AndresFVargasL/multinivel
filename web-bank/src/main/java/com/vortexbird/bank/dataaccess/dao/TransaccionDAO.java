package com.vortexbird.bank.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.vortexbird.bank.dataaccess.api.HibernateDaoImpl;
import com.vortexbird.bank.model.Transaccion;


/**
 * A data access object (DAO) providing persistence and search support for
 * Transaccion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Transaccion
 */
@Scope("singleton")
@Repository("TransaccionDAO")
public class TransaccionDAO extends HibernateDaoImpl<Transaccion, Long>
    implements ITransaccionDAO {
    private static final Logger log = LoggerFactory.getLogger(TransaccionDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ITransaccionDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITransaccionDAO) ctx.getBean("TransaccionDAO");
    }
}
