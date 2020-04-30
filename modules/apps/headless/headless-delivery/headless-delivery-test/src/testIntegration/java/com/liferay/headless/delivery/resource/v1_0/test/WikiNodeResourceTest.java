/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.service.WikiNodeLocalServiceUtil;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class WikiNodeResourceTest extends BaseWikiNodeResourceTestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		List<WikiNode> wikiNodes = WikiNodeLocalServiceUtil.getNodes(
			testGroup.getGroupId());

		for (WikiNode wikiNode : wikiNodes) {
			WikiNodeLocalServiceUtil.deleteNode(wikiNode);
		}
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	@Override
	protected String[] getAdditionalAssertFieldNames() {
		return new String[] {"description", "name"};
	}

	@Override
	protected String[] getIgnoredEntityFieldNames() {
		return new String[] {"creatorId"};
	}

}