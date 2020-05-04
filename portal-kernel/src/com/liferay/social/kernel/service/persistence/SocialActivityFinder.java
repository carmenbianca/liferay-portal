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
public interface SocialActivityFinder {

	public int countByGroupId(long groupId);

	public int countByGroupUsers(long groupId);

	public int countByOrganizationId(long organizationId);

	public int countByOrganizationUsers(long organizationId);

	public int countByRelation(long userId);

	public int countByRelationType(long userId, int type);

	public int countByUserGroups(long userId);

	public int countByUserGroupsAndOrganizations(long userId);

	public int countByUserOrganizations(long userId);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByGroupId(long groupId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByGroupUsers(long groupId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByOrganizationId(long organizationId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByOrganizationUsers(long organizationId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByRelation(long userId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByRelationType(long userId, int type, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByUserGroups(long userId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByUserGroupsAndOrganizations(long userId, int start, int end);

	public java.util.List<com.liferay.social.kernel.model.SocialActivity>
		findByUserOrganizations(long userId, int start, int end);

}