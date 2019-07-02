package com.dtds.common.baseInterface;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


/// <summary>
/// 创建注释
/// 创建标识：wayne
/// 功能描述：用于公共基类的接口
/// </summary>
public interface IDAO {
	/**
	 * 
	 * 增加一个对象
	 * 
	 * @param object
	 * 
	 */
	public void add(Object object);

	/**
	 * 
	 * 批量修改
	 * 
	 * @param hql
	 * @param params[]
	 * 
	 */
	public void bulkOperate(String hql, Object[] params);

	/**
	 * 
	 * 增加或修改对象
	 * 
	 * @param entity
	 * 
	 */
	public <T> T saveOrUpdate(T entity);

	/**
	 * 
	 * 更新，首先查询缓存，判断对象是否修改。其次执行更新。
	 * 
	 * @param <T>
	 * @param entity
	 * @return entity
	 * 
	 */
	public <T> T merge(T entity);

	/**
	 * 更新对象
	 * 
	 * @param object
	 */
	public void update(Object stinstanceu);

	/**
	 * @param object
	 *            删除一个对象
	 */
	public void del(Object instance);

	/**
	 * 先加载一个持久化对象，在进行删除
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 */
	public <T> void delete(Class<T> clazz, Serializable id);

	/**
	 * 根据不同条件查询
	 * 
	 * @param hql
	 * @param params[]
	 */
	@SuppressWarnings("rawtypes")
	public List findByParams(final String hql, Object[] params);

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
	public <T> List<T> findByHql(final int start, final int limit,
			final String hql, final Object... params);

	/**
	 * 直接查询数据库
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> clazz, Serializable id);

	/**
	 * 查询数据库，返回代理类
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T load(Class<T> clazz, Serializable id);

	/**
	 * 根据条件查询
	 * 
	 * @param cri
	 * @param start
	 * @param num
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List pagerByCriteria(DetachedCriteria cri, int start, int num);

	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param value
	 *            如果hql有一个参数需要传入，value就是传入的参数
	 * @param offset
	 *            第一条记录索引
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("rawtypes")
	public List pagerByHql(final String hql, final Object[]value,
			final int offset, final int pageSize)  throws SQLException, Exception;

	/**
	 * 查询数据
	 * 
	 * @param hql
	 */
	@SuppressWarnings("rawtypes")
	public List findByList(String hql);
}
