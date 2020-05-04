/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.teams.uad.test;

import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.service.TeamLocalService;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = TeamUADTestHelper.class)
public class TeamUADTestHelper {

	public Team addTeam(long userId) throws Exception {
		return _teamLocalService.addTeam(
			userId, TestPropsValues.getGroupId(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(),
			ServiceContextTestUtil.getServiceContext());
	}

	public void cleanUpDependencies(List<Team> teams) throws Exception {
	}

	@Reference
	private TeamLocalService _teamLocalService;

}