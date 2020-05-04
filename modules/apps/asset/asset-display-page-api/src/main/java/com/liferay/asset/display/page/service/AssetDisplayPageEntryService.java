/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.page.service;

import com.liferay.asset.display.page.model.AssetDisplayPageEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for AssetDisplayPageEntry. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AssetDisplayPageEntryServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AssetDisplayPageEntryService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssetDisplayPageEntryServiceUtil} to access the asset display page entry remote service. Add custom service methods to <code>com.liferay.asset.display.page.service.impl.AssetDisplayPageEntryServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public AssetDisplayPageEntry addAssetDisplayPageEntry(
			long userId, long groupId, long classNameId, long classPK,
			long layoutPageTemplateEntryId, int type,
			ServiceContext serviceContext)
		throws Exception;

	public AssetDisplayPageEntry addAssetDisplayPageEntry(
			long userId, long groupId, long classNameId, long classPK,
			long layoutPageTemplateEntryId, ServiceContext serviceContext)
		throws Exception;

	public void deleteAssetDisplayPageEntry(
			long groupId, long classNameId, long classPK)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AssetDisplayPageEntry fetchAssetDisplayPageEntry(
			long groupId, long classNameId, long classPK)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetDisplayPageEntry>
		getAssetDisplayPageEntriesByLayoutPageTemplateEntryId(
			long layoutPageTemplateEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssetDisplayPageEntriesCountByLayoutPageTemplateEntryId(
		long layoutPageTemplateEntryId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public AssetDisplayPageEntry updateAssetDisplayPageEntry(
			long assetDisplayPageEntryId, long layoutPageTemplateEntryId,
			int type)
		throws Exception;

}