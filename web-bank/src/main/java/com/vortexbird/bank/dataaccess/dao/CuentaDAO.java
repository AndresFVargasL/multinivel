package com.vortexbird.bank.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.vortexbird.bank.dataaccess.api.HibernateDaoImpl;
import com.vortexbird.bank.model.Cuenta;


/**
 * A data access object (DAO) providing persistence and search support for
 * Cuenta entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Cuenta
 */
@Scope("singleton")
@Repository("CuentaDAO")
public class CuentaDAO extends HibernateDaoImpl<Cuenta, String>
    implements ICuentaDAO {
    private static final Logger log = LoggerFactory.getLogger(CuentaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ICuentaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ICuentaDAO) ctx.getBean("CuentaDAO");
    }
}
