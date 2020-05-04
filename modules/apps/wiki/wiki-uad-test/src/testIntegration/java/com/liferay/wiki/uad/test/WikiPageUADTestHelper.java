/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.uad.test;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiNodeLocalService;
import com.liferay.wiki.service.WikiPageLocalService;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author William Newbury
 */
@Component(immediate = true, service = WikiPageUADTestHelper.class)
public class WikiPageUADTestHelper {

	public WikiPage addWikiPage(long userId) throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getGroupId());

		WikiNode wikiNode = _wikiNodeLocalService.addNode(
			userId, RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), serviceContext);

		return _wikiPageLocalService.addPage(
			userId, wikiNode.getNodeId(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(), false,
			serviceContext);
	}

	public WikiPage addWikiPageWithStatusByUserId(
			long userId, long statusByUserId)
		throws Exception {

		WikiPage wikiPage = addWikiPage(userId);

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getGroupId());

		Map<String, Serializable> workflowContext =
			HashMapBuilder.<String, Serializable>put(
				WorkflowConstants.CONTEXT_URL, "http://localhost"
			).build();

		return _wikiPageLocalService.updateStatus(
			statusByUserId, wikiPage, WorkflowConstants.STATUS_APPROVED,
			serviceContext, workflowContext);
	}

	public void cleanUpDependencies(List<WikiPage> wikiPages) throws Exception {
		for (WikiPage wikiPage : wikiPages) {
			_wikiNodeLocalService.deleteNode(wikiPage.getNodeId());
		}
	}

	@Reference
	private WikiNodeLocalService _wikiNodeLocalService;

	@Reference
	private WikiPageLocalService _wikiPageLocalService;

}