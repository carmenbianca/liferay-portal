/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.counter.kernel.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Counter. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CounterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CounterLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CounterLocalServiceUtil} to access the counter local service. Add custom service methods to <code>com.liferay.counter.service.impl.CounterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getNames();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(
		isolation = Isolation.COUNTER, propagation = Propagation.REQUIRES_NEW
	)
	public long increment();

	@Transactional(
		isolation = Isolation.COUNTER, propagation = Propagation.REQUIRES_NEW
	)
	public long increment(String name);

	@Transactional(
		isolation = Isolation.COUNTER, propagation = Propagation.REQUIRES_NEW
	)
	public long increment(String name, int size);

	@Transactional(
		isolation = Isolation.COUNTER, propagation = Propagation.REQUIRES_NEW
	)
	public void rename(String oldName, String newName);

	@Transactional(
		isolation = Isolation.COUNTER, propagation = Propagation.REQUIRES_NEW
	)
	public void reset(String name);

	@Transactional(
		isolation = Isolation.COUNTER, propagation = Propagation.REQUIRES_NEW
	)
	public void reset(String name, long size);

}