package com.dtds.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.dtds.common.baseInterface.IDAO;

/**
 * 
 * @author frinder
 * @since SUN JDK1.6.0_13
 * @version
 * 
 */
@Component("idao")
public class BaseDAO implements IDAO
{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 
	 * 增加一个对象
	 * 
	 * @param object
	 * 
	 */
	public void add(Object object)
	{
		this.getHibernateTemplate().save(object);

	}

	/**
	 * 
	 * 批量修改
	 * 
	 * @param hql
	 * @param params []
	 * 
	 */
	public void bulkOperate(String hql, Object[] params)
	{
		this.getHibernateTemplate().bulkUpdate(hql, params);
	}

	/**
	 * 
	 * 增加或修改对象
	 * 
	 * @param entity
	 * 
	 */
	public <T> T saveOrUpdate(T entity)
	{
		this.getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	/**
	 * 
	 * 更新，首先查询缓存，判断对象是否修改。其次执行更新。
	 * 
	 * @param <T>
	 * @param entity
	 * @return entity
	 * 
	 */
	public <T> T merge(T entity)
	{
		this.getHibernateTemplate().merge(entity);
		return entity;
	}

	/**
	 * 更新对象
	 * 
	 * @param object
	 */
	public void update(Object stinstanceu)
	{
		this.getHibernateTemplate().update(stinstanceu);
	}

	/**
	 * @param object 删除一个对象
	 */
	public void del(Object instance)
	{
		this.getHibernateTemplate().delete(instance);
	}

	/**
	 * 先加载一个持久化对象，在进行删除
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 */
	public <T> void delete(Class<T> clazz, Serializable id)
	{
		T entity = (T) this.getHibernateTemplate().load(clazz, id);
		Assert.notNull(entity, "id must not be null");
		this.del(entity);
	}

	/**
	 * 根据不同条件查询
	 * 
	 * @param hql
	 * @param params []
	 */
	public List findByParams(final String hql, Object[] params)
	{
		return this.getHibernateTemplate().find(hql, params);
	}

	/**
	 * 根据参数查询
	 * 
	 * @param <T>
	 * @param start
	 * @param limit
	 * @param hql
	 * @param params
	 * @return
	 */
	public <T> List<T> findByHql(final int start, final int limit, final String hql, final Object... params)
	{
		Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		if (params != null && params.length > 0)
		{
			for (int i = 0; i < params.length; i++)
			{
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult(start);
		query.setMaxResults(limit);
		return query.list();
	}

	/**
	 * 直接查询数据库
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> clazz, Serializable id)
	{
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 查询数据库，返回代理类
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T load(Class<T> clazz, Serializable id)
	{
		return (T) this.getHibernateTemplate().load(clazz, id);
	}

	/**
	 * 根据条件查询
	 * 
	 * @param cri
	 * @param start
	 * @param num
	 * @return
	 */
	public List pagerByCriteria(DetachedCriteria cri, int start, int num)
	{
		return this.getHibernateTemplate().findByCriteria(cri, start, num);
	}

	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql 需要查询的hql语句
	 * @param value 如果hql有一个参数需要传入，value就是传入的参数
	 * @param offset 第一条记录索引
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	public List pagerByHql(final String hql, final Object[] value, final int offset, final int pageSize) throws SQLException, Exception
	{

		List list = getHibernateTemplate().executeFind(new HibernateCallback()
		{
			public Object doInHibernate(Session session)
			{
				List result = null;
				try
				{
					Query query = session.createQuery(hql);
					for (int i = 0; i < value.length; i++)
					{
						query.setParameter(i, value[i]);
					}
					result = query.setFirstResult(offset).setMaxResults(pageSize).list();
				} catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
					// throw new Exception();
				} finally
				{
					// session.close();
				}
				return result;
			}
		});
		return list;
	}

	/**
	 * 查询数据
	 * 
	 * @param hql
	 */
	public List findByList(String hql)
	{
		List list = this.getHibernateTemplate().find(hql);
		return list;
	}

}
