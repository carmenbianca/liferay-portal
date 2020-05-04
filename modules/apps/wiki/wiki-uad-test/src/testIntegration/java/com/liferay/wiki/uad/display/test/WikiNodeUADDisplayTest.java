/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.uad.display.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.user.associated.data.display.UADDisplay;
import com.liferay.user.associated.data.test.util.BaseUADDisplayTestCase;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.uad.test.WikiNodeUADTestHelper;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Brian Wing Shun Chan
 */
@RunWith(Arquillian.class)
public class WikiNodeUADDisplayTest extends BaseUADDisplayTestCase<WikiNode> {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@After
	public void tearDown() throws Exception {
		_wikiNodeUADTestHelper.cleanUpDependencies(_wikiNodes);
	}

	@Override
	protected WikiNode addBaseModel(long userId) throws Exception {
		WikiNode wikiNode = _wikiNodeUADTestHelper.addWikiNode(userId);

		_wikiNodes.add(wikiNode);

		return wikiNode;
	}

	@Override
	protected UADDisplay getUADDisplay() {
		return _uadDisplay;
	}

	@Inject(filter = "component.name=*.WikiNodeUADDisplay")
	private UADDisplay _uadDisplay;

	@DeleteAfterTestRun
	private final List<WikiNode> _wikiNodes = new ArrayList<>();

	@Inject
	private WikiNodeUADTestHelper _wikiNodeUADTestHelper;

}