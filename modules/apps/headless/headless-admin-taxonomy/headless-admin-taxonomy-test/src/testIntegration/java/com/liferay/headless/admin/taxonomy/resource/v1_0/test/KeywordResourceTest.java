/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.admin.taxonomy.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.headless.admin.taxonomy.client.dto.v1_0.Keyword;
import com.liferay.portal.kernel.util.StringUtil;

import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class KeywordResourceTest extends BaseKeywordResourceTestCase {

	@Override
	public void testGetKeywordsRankedPage() {
	}

	@Override
	public void testGetKeywordsRankedPageWithPagination() {
	}

	@Override
	public void testGraphQLDeleteKeyword() {
	}

	@Override
	public void testGraphQLGetKeyword() {
	}

	@Override
	public void testGraphQLGetSiteKeywordsPage() {
	}

	@Override
	public void testGraphQLPostSiteKeyword() {
	}

	@Override
	protected String[] getAdditionalAssertFieldNames() {
		return new String[] {"name"};
	}

	@Override
	protected Keyword randomKeyword() throws Exception {
		Keyword keyword = super.randomKeyword();

		keyword.setName(StringUtil.toLowerCase(keyword.getName()));

		return keyword;
	}

}