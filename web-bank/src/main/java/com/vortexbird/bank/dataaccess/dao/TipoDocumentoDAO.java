package com.vortexbird.bank.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.vortexbird.bank.dataaccess.api.HibernateDaoImpl;
import com.vortexbird.bank.model.TipoDocumento;


/**
 * A data access object (DAO) providing persistence and search support for
 * TipoDocumento entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.TipoDocumento
 */
@Scope("singleton")
@Repository("TipoDocumentoDAO")
public class TipoDocumentoDAO extends HibernateDaoImpl<TipoDocumento, Long>
    implements ITipoDocumentoDAO {
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ITipoDocumentoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITipoDocumentoDAO) ctx.getBean("TipoDocumentoDAO");
    }
}
