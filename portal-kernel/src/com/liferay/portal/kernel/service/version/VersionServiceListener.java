/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.version;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.version.VersionModel;
import com.liferay.portal.kernel.model.version.VersionedModel;

/**
 * @author Preston Crary
 * @see    VersionService
 */
public interface VersionServiceListener
	<E extends VersionedModel<V>, V extends VersionModel<E>> {

	public void afterCheckout(E draftVersionedModel, int version)
		throws PortalException;

	public void afterCreateDraft(E draftVersionedModel) throws PortalException;

	public void afterDelete(E publishedVersionedModel) throws PortalException;

	public void afterDeleteDraft(E draftVersionedModel) throws PortalException;

	public void afterDeleteVersion(V versionModel) throws PortalException;

	public void afterPublishDraft(E draftVersionedModel, int version)
		throws PortalException;

	public void afterUpdateDraft(E draftVersionedModel) throws PortalException;

}