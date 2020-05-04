/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface SocialActivitySetFinder {

	public int countByOrganizationId(long organizationId);

	public int countByRelation(long userId);

	public int countByRelationType(long userId, int type);

	public int countByUser(long userId);

	public int countByUserGroups(long userId);

	public java.util.List<com.liferay.social.kernel.model.SocialActivitySet>
		findByOrganizationId(long organizationId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivitySet>
		findByRelation(long userId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivitySet>
		findByRelationType(long userId, int type, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivitySet>
		findByUser(long userId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivitySet>
		findByUserGroups(long userId, int start, int end);

}